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

import com.reccos.admin.dto.ScoreRequest;
import com.reccos.admin.dto.ScoreResponse;
import com.reccos.admin.service.ScoreService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/score")
public class Score {
    
    private final ScoreService scoreService;

    @GetMapping
    public List<ScoreResponse> listAll() {
        return scoreService.listAll();
    }

    @GetMapping(value = "/{score_id}")
    public ScoreResponse ScoreById(@PathVariable Long score_id) {
        return scoreService.ScoreById(score_id);
    }

    @PostMapping
    public ScoreResponse createScore(@RequestBody @Valid ScoreRequest scoreRequest) {
        return scoreService.createScore(scoreRequest);
    }

    @PutMapping(value = "/{score_id}")
    public ScoreResponse updateScore(@RequestBody @Valid ScoreRequest scoreRequest, @PathVariable Long score_id) {
        return scoreService.updateScore(scoreRequest, score_id);
    }

        @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{score_id}")
    public void deleteScore(@PathVariable Long score_id) {
        scoreService.deleteScore(score_id);
    }

    
}
