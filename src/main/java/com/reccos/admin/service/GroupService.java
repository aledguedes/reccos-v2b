package com.reccos.admin.service;

import java.util.List;

import com.reccos.admin.dto.GroupRequest;
import com.reccos.admin.dto.GroupResponse;
import com.reccos.admin.dto.TeamGroupRequest;
import com.reccos.admin.dto.TeamWithGroupRequest;

public interface GroupService {
    List<GroupResponse> listAll();
    void deleteGroup(Long group_id);
    GroupResponse groupById(Long group_id);
    String updateGroup(List<GroupRequest> groupRequest);
    List<GroupResponse> createGroup(List<GroupRequest> groupRequest);
    String updateGroupByTeams(List<TeamGroupRequest> teamGroupRequest);
    String createGroupByTeams(List<TeamWithGroupRequest> teamWithGroupRequests, Long league_id);
}
