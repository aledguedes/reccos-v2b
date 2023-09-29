package com.reccos.admin.mapper;

import com.reccos.admin.dto.GroupRequest;
import com.reccos.admin.dto.GroupResponse;
import com.reccos.admin.models.Group;

public class GroupMapperImpl implements GroupMapper {

    @Override
    public Group toGroup(GroupRequest groupRequest) {
        if (groupRequest == null) {
            return null;
        }
        return Group.builder()
                .name(groupRequest.getName())
                .build();

    }

    @Override
    public GroupResponse toGroupResponse(Group group) {
        if (group == null) {
            return null;
        }

        return GroupResponse.builder()
        		.id(group.getId())
                .name(group.getName())
                .build();
    }

}
