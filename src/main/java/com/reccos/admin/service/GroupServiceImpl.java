package com.reccos.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.reccos.admin.dto.GroupRequest;
import com.reccos.admin.dto.GroupResponse;
import com.reccos.admin.exceptions.core.GroupNotFoundException;
import com.reccos.admin.mapper.GroupMapper;
import com.reccos.admin.repository.GroupRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

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
    public GroupResponse createGroup(GroupRequest groupRequest, Long player_id, Long team_id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createGroup'");
    }

    @Override
    public GroupResponse updateGroup(GroupRequest groupRequest, Long group_id, Long player_id, Long team_id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateGroup'");
    }

    @Override
    public void deleteGroup(Long group_id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteGroup'");
    }

    
    
}
