package com.reccos.admin.service;

import java.util.List;

import com.reccos.admin.dto.GroupRequest;
import com.reccos.admin.dto.GroupResponse;

public interface GroupService {
    List<GroupResponse> listAll();
    GroupResponse groupById(Long group_id);
    GroupResponse createGroup(GroupRequest groupRequest, Long player_id, Long team_id);
    GroupResponse updateGroup(GroupRequest groupRequest, Long group_id, Long player_id, Long team_id);
    void deleteGroup(Long group_id);
}
