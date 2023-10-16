package com.reccos.admin.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.reccos.admin.dto.ScoreRequest;
import com.reccos.admin.dto.ScoreResponse;
import com.reccos.admin.exceptions.core.ScoreNotFoundException;
import com.reccos.admin.exceptions.core.StadiumNotFoundException;
import com.reccos.admin.mapper.ScoreMapper;
import com.reccos.admin.repository.ScoreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService {

    private final ScoreMapper scoreMapper;
    private final ScoreRepository scoreRepository;

    @Override
    public List<ScoreResponse> listAll() {
        return scoreRepository.findAll().stream().map(scoreMapper::toScoreResponse).toList();
    }

    @Override
    public ScoreResponse ScoreById(Long score_id) {
        return scoreRepository.findById(score_id).map(scoreMapper::toScoreResponse)
                .orElseThrow(ScoreNotFoundException::new);
    }

    @Override
    public ScoreResponse createScore(ScoreRequest scoreRequest) {

        String w = "W" + scoreRequest.getWinner();
        String d = "D" + scoreRequest.getDraw();
        String l = "L" + scoreRequest.getLoser();

        String name = w + d + l;

        var score = scoreMapper.toScore(scoreRequest);
        score.setName(name);
        return scoreMapper.toScoreResponse(scoreRepository.save(score));
    }

    @Override
    public ScoreResponse updateScore(ScoreRequest scoreRequest, Long score_id) {
        var score = scoreRepository.findById(score_id).orElseThrow(StadiumNotFoundException::new);
        BeanUtils.copyProperties(scoreRequest, score, "id", "name", "createdAt", "updatedAt");
        var updatedscore = scoreRepository.save(score);
        return scoreMapper.toScoreResponse(updatedscore);
    }

    @Override
    public void deleteScore(Long score_id) {
        scoreRepository.deleteById(score_id);
    }

}
