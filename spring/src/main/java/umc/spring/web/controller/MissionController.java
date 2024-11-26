package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.apiPayload.code.status.SuccessStatus;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.dto.missionDTO.MissionRequestDTO;
import umc.spring.dto.missionDTO.MissionResponseDTO;
import umc.spring.service.missionService.MissionService;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {
    private final MissionService missionService;

    @Operation(summary = "미션 등록", description = "미션 등록 api입니다.")
    @PostMapping("/add")
    public ApiResponse<MissionResponseDTO.MissionIdDTO> addMission(@Valid @RequestBody MissionRequestDTO.AddMissionDTO request) {
        Mission mission = missionService.addMission(request);
        MissionResponseDTO.MissionIdDTO response = MissionConverter.toMissionIdDTO(mission);
        return ApiResponse.of(SuccessStatus.MISSION_CREATE_OK, response);
    }
}
