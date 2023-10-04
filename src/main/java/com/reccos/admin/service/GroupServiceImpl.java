package com.reccos.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.reccos.admin.dto.GroupRequest;
import com.reccos.admin.dto.GroupResponse;
import com.reccos.admin.dto.TeamGroupRequest;
import com.reccos.admin.dto.TeamWithGroupRequest;
import com.reccos.admin.exceptions.core.GroupNotFoundException;
import com.reccos.admin.exceptions.core.LeagueNotFoundException;
import com.reccos.admin.mapper.GroupMapper;
import com.reccos.admin.models.Group;
import com.reccos.admin.models.Team;
import com.reccos.admin.repository.GroupRepository;
import com.reccos.admin.repository.LeagueRepository;
import com.reccos.admin.repository.TeamRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupMapper groupMapper;
    private final TeamRepository teamRepository;
    private final GroupRepository groupRepository;
    private final LeagueRepository leagueRepository;

    @Override
    public List<GroupResponse> listAll() {
        return groupRepository.findAll()
                .stream()
                .map(groupMapper::toGroupResponse)
                .toList();
    }

    @Override
    public GroupResponse groupById(Long group_id) {
        return groupRepository.findById(group_id)
                .map(groupMapper::toGroupResponse)
                .orElseThrow(GroupNotFoundException::new);
    }

    @Override
    public List<GroupResponse> createGroup(List<GroupRequest> groupRequests) {
        if (groupRequests == null || groupRequests.isEmpty()) {
            throw new IllegalArgumentException("A lista de grupos está vazia ou nula.");
        }

        Long leagueId = groupRequests.get(0).getIdd_league();

        var league = leagueRepository
                .findById(leagueId)
                .orElseThrow(LeagueNotFoundException::new);

        List<GroupResponse> createdGroupResponses = new ArrayList<>();

        for (GroupRequest groupRequest : groupRequests) {
            var newGroup = groupMapper.toGroup(groupRequest);
            newGroup.setLeague(league);
            var createdGroup = groupRepository.save(newGroup);
            createdGroupResponses.add(groupMapper.toGroupResponse(createdGroup));
        }
        return createdGroupResponses;
    }

    @Override
    public String updateGroup(List<GroupRequest> groupRequest) {
        var updatedGroupIds = new ArrayList<Long>();
        for (GroupRequest request : groupRequest) {
            String[] parts = request.getName().split("\\?");

            String groupId = parts[0];
            String newName = parts[1];

            Optional<Group> groupOptional = groupRepository.findById(Long.parseLong(groupId));

            if (groupOptional.isPresent()) {
                Group group = groupOptional.get();
                group.setName(newName);
                groupRepository.save(group);
                updatedGroupIds.add(group.getId());
            }
        }

        if (!updatedGroupIds.isEmpty()) {
            String successMessage = "Atualização de grupos concluída com sucesso. IDs dos grupos modificados: "
                    + updatedGroupIds;
            return successMessage;
        } else {
            return "Nenhum grupo foi modificado.";
        }
    }

    @Override
    public void deleteGroup(Long group_id) {
        groupRepository.deleteById(group_id);
    }

    @Override
    public String updateGroupByTeams(List<TeamGroupRequest> teamGroupRequest) {

        List<Group> updatedGroups = teamGroupRequest.stream()
                .map(groupTeamRequest -> {
                    Long groupId = groupTeamRequest.getId_group();
                    List<Long> teamIds = groupTeamRequest.getIds_teams();

                    Group group = groupRepository.findById(groupId)
                            .orElseThrow(() -> new EntityNotFoundException("Grupo não encontrado"));

                    List<Team> teams = teamRepository.findAllById(teamIds);
                    group.getTeams().addAll(teams);

                    return group;
                })
                .collect(Collectors.toList());

        groupRepository.saveAll(updatedGroups);

        StringBuilder result = new StringBuilder("Grupos atualizados: ");
        for (Group group : updatedGroups) {
            result.append("Grupo ID: ").append(group.getId()).append(", ");
        }

        if (updatedGroups.size() > 0) {
            result.setLength(result.length() - 2);
        }

        return result.toString();
    }

    @Override
    public String createGroupByTeams(List<TeamWithGroupRequest> teamWithGroupRequests, Long league_id) {

        var league = leagueRepository
                .findById(league_id)
                .orElseThrow(LeagueNotFoundException::new);

        for (TeamWithGroupRequest groupRequestDTO : teamWithGroupRequests) {
            Group group = new Group();
            group.setName(groupRequestDTO.getName());
            group.setLeague(league);

            List<Long> teamIds = groupRequestDTO.getIds_teams();
            List<Team> teams = teamRepository.findAllById(teamIds);
            group.getTeams().addAll(teams);
            // group.setTeams(teams);

            groupRepository.save(group);
        }
        StringBuilder result = new StringBuilder("Grupos criados com sucesso!!");
        return result.toString();
    }

}
