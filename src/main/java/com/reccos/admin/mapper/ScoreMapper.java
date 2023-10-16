package com.reccos.admin.mapper;

import com.reccos.admin.dto.ScoreRequest;
import com.reccos.admin.dto.ScoreResponse;
import com.reccos.admin.models.Score;

public interface ScoreMapper {
    
    Score toScore(ScoreRequest scoreRequest);
    ScoreResponse toScoreResponse(Score score);
}
