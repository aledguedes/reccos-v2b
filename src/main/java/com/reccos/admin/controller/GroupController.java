package com.reccos.admin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reccos.admin.dto.GroupRequest;
import com.reccos.admin.dto.GroupResponse;
import com.reccos.admin.dto.TeamGroupRequest;
import com.reccos.admin.service.GroupService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/group")
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public List<GroupResponse> listAll() {
        return groupService.listAll();
    }

    @GetMapping(value = "/{group_id}")
    public GroupResponse groupById(@PathVariable Long group_id) {
        return groupService.groupById(group_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<GroupResponse> createGroup(List<GroupRequest> groupRequest) {
        return groupService.createGroup(groupRequest);
    }

    @PutMapping
    public String updateGroup(@RequestBody @Valid List<GroupRequest> groupRequest) {
        return groupService.updateGroup(groupRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{group_id}")
    public void deleteGroup(@PathVariable Long group_id) {
        groupService.deleteGroup(group_id);
    }

    @PostMapping(value = "/add-teams")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateGroupByTeams(@RequestBody List<TeamGroupRequest> teamGroupRequest) {
        return groupService.updateGroupByTeams(teamGroupRequest);
    }

}
