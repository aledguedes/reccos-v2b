package com.reccos.admin.mapper;

import com.reccos.admin.dto.GroupRequest;
import com.reccos.admin.dto.GroupResponse;
import com.reccos.admin.models.Group;

public interface GroupMapper {

    Group toGroup(GroupRequest groupRequest);
    GroupResponse toGroupResponse(Group group);
}
