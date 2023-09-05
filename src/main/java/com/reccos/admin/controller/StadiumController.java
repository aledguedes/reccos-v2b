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

import com.reccos.admin.dto.StadiumRequest;
import com.reccos.admin.dto.StadiumResponse;
import com.reccos.admin.service.StadiumService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/stadium")
public class StadiumController {

	private final StadiumService stadiumService;

	@GetMapping
	public List<StadiumResponse> listAll() {
		return stadiumService.listAll();
	}

	@GetMapping(value = "/{stadium_id}")
	public StadiumResponse StadiumById(@PathVariable Long stadium_id) {
		return stadiumService.StadiumById(stadium_id);
	}

	@GetMapping(value = "find/by-federation/{federation_id}")
	public List<StadiumResponse> stadiumByFederation(@PathVariable Long federation_id) {
		return stadiumService.getStadiumByFederation(federation_id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public StadiumResponse createRefree(@RequestBody @Valid final StadiumRequest stadiumRequest) {
		return stadiumService.createRefree(stadiumRequest);
	}

	@PostMapping(value = "/link_team/{team_id}")
	public StadiumResponse createWithTeam(@RequestBody @Valid final StadiumRequest stadiumRequest,
			@PathVariable Long team_id) {
		return stadiumService.createWithTeam(stadiumRequest, team_id);
	}

	@PutMapping(value = "/{stadium_id}")
	public StadiumResponse updateRefree(@RequestBody @Valid final StadiumRequest stadiumRequest,
			@PathVariable Long stadium_id) {
		return stadiumService.updateRefree(stadiumRequest, stadium_id);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{stadium_id}")
	public void deleteRefree(@PathVariable Long stadium_id) {
		stadiumService.deleteRefree(stadium_id);
	}

}
