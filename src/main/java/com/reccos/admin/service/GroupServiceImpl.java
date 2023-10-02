package com.reccos.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.reccos.admin.dto.GroupRequest;
import com.reccos.admin.dto.GroupResponse;
import com.reccos.admin.exceptions.core.GroupNotFoundException;
import com.reccos.admin.exceptions.core.LeagueNotFoundException;
import com.reccos.admin.mapper.GroupMapper;
import com.reccos.admin.models.Group;
import com.reccos.admin.repository.GroupRepository;
import com.reccos.admin.repository.LeagueRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupMapper groupMapper;
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
    public GroupResponse createGroup(GroupRequest groupRequest) {
        var league = leagueRepository
                .findById(groupRequest.getIdd_league()) 
                .orElseThrow(LeagueNotFoundException::new);
        var newGroup = groupMapper.toGroup(groupRequest);
        newGroup.setLeague(league);
        var createdGroup = groupRepository.save(newGroup);
        return groupMapper.toGroupResponse(createdGroup);
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
            String successMessage = "Atualização de grupos concluída com sucesso. IDs dos grupos modificados: " + updatedGroupIds;
            return successMessage;
        } else {
            return "Nenhum grupo foi modificado.";
        }
    }

    @Override
    public void deleteGroup(Long group_id) {
        groupRepository.deleteById(group_id);
    }

}
