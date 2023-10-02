package com.reccos.admin.service;

import java.util.List;

import com.reccos.admin.dto.GroupRequest;
import com.reccos.admin.dto.GroupResponse;

public interface GroupService {
    List<GroupResponse> listAll();
    GroupResponse groupById(Long group_id);
    GroupResponse createGroup(GroupRequest groupRequest);
    String updateGroup(List<GroupRequest> groupRequest);
    void deleteGroup(Long group_id);
}
