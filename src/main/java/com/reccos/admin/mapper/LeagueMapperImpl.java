package com.reccos.admin.mapper;

import org.springframework.stereotype.Component;

import com.reccos.admin.dto.LeagueRequest;
import com.reccos.admin.dto.LeagueResponse;
import com.reccos.admin.models.League;

@Component
public class LeagueMapperImpl implements LeagueMapper {

    @Override
    public League toLeague(LeagueRequest leagueRequest) {
        if (leagueRequest == null) {
            return null;
        }
        return League.builder()
                .name(leagueRequest.getName())
                .status(leagueRequest.getStatus())
                .img_logo(leagueRequest.getImg_logo())
                .dt_start(leagueRequest.getDt_start())
                .dt_end(leagueRequest.getDt_end())
                .league_system(leagueRequest.getLeague_system())
                .league_mode(leagueRequest.getLeague_mode())
                .qt_group(leagueRequest.getQt_group())
                .idd_fed(leagueRequest.getIdd_fed())
                .build();
    }

    @Override
    public LeagueResponse toLeagueResponse(League league) {
        if (league == null) {
            return null;
        }

        return LeagueResponse.builder()
                .name(league.getName())
                .status(league.getStatus())
                .img_logo(league.getImg_logo())
                .dt_start(league.getDt_start())
                .dt_end(league.getDt_end())
                .league_system(league.getLeague_system())
                .league_mode(league.getLeague_mode())
                .createdAt(league.getCreatedAt())
                .updatedAt(league.getUpdatedAt())
                .build();
    }

}
