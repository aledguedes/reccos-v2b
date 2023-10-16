package com.reccos.admin.service;

import java.util.List;

import com.reccos.admin.dto.ScoreRequest;
import com.reccos.admin.dto.ScoreResponse;

public interface ScoreService {
    List<ScoreResponse> listAll();
    ScoreResponse ScoreById(Long score_id);
    ScoreResponse createScore(ScoreRequest scoreRequest);
    ScoreResponse updateScore(ScoreRequest scoreRequest, Long score_id);
    void deleteScore(Long score_id);
}
