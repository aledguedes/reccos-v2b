package com.reccos.admin.mapper;

import org.springframework.stereotype.Component;

import com.reccos.admin.dto.ScoreRequest;
import com.reccos.admin.dto.ScoreResponse;
import com.reccos.admin.models.Score;

@Component
public class ScoreMapperImpl implements ScoreMapper {

    @Override
    public Score toScore(ScoreRequest scoreRequest) {

        if(scoreRequest == null) {
            return null;
        }
        return Score.builder()
                .winner(scoreRequest.getWinner())
                .draw(scoreRequest.getDraw())
                .loser(scoreRequest.getLoser())
                .build();
    }

    @Override
    public ScoreResponse toScoreResponse(Score score) {
        if (score == null) {
            return null;
        }
        return ScoreResponse.builder()
        		.id(score.getId())
                .winner(score.getWinner())
                .draw(score.getDraw())
                .loser(score.getLoser())
	            .createdAt(score.getCreatedAt())
	            .updatedAt(score.getUpdatedAt())
                .build();
    }
    
}
