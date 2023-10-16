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
                .turn(leagueRequest.getTurn())
                .dt_end(leagueRequest.getDt_end())
                .status(leagueRequest.getStatus())
                .idd_fed(leagueRequest.getIdd_fed())
                .qt_group(leagueRequest.getQt_group())
                .location(leagueRequest.getLocation())
                .img_logo(leagueRequest.getImg_logo())
                .dt_start(leagueRequest.getDt_start())
                .league_mode(leagueRequest.getLeague_mode())
                .league_system(leagueRequest.getLeague_system())
                .num_teams(leagueRequest.getNum_teams())
                .build();
    }

    @Override
    public LeagueResponse toLeagueResponse(League league) {
        if (league == null) {
            return null;
        }

        return LeagueResponse.builder()
        		.id(league.getId())
                .name(league.getName())
                .turn(league.getTurn())
                .dt_end(league.getDt_end())
                .status(league.getStatus())
                .groups(league.getGroups())
                .location(league.getLocation())
                .img_logo(league.getImg_logo())
                .dt_start(league.getDt_start())
                .createdAt(league.getCreatedAt())
                .updatedAt(league.getUpdatedAt())
                .league_mode(league.getLeague_mode())
                .league_system(league.getLeague_system())
                .enrollment_end(league.getEnrollment_end())
                .enrollment_start(league.getEnrollment_start())
                .num_teams(league.getNum_teams())
                .score(league.getScore())
                .build();
    }

}
