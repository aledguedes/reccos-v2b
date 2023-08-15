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

import com.reccos.admin.dto.RefreeRequest;
import com.reccos.admin.dto.RefreeResponse;
import com.reccos.admin.service.RefreeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/refree")
public class RefreeController {

    private final RefreeService refreeService;

    @GetMapping
    public List<RefreeResponse> listAll() {
        return refreeService.listAll();
    }

    @GetMapping(value = "/{refree_id}")
    public RefreeResponse RefreeById(@PathVariable Long refree_id) {
        return refreeService.RefreeById(refree_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RefreeResponse createRefree(@RequestBody @Valid RefreeRequest refreeRequest) {
        return refreeService.createRefree(refreeRequest);
    }

    @PutMapping(value = "/{refree_id}")
    public RefreeResponse updateRefree(@RequestBody @Valid RefreeRequest refreeRequest, @PathVariable Long refree_id) {
        return refreeService.updateRefree(refreeRequest, refree_id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{refree_id}")
    public void deleteRefree(@PathVariable Long refree_id) {
        refreeService.deleteRefree(refree_id);
    }

}
