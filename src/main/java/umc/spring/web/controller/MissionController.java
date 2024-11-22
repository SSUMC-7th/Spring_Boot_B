package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.service.MissionService.MissionServiceImpl;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionController {

    private final MissionServiceImpl missionService;

    @PostMapping("/{storeId}")
    public ApiResponse<MissionResponseDTO.JoinResultDTO> join(
            @PathVariable("storeId") @ExistStores Long storeId,
            @RequestBody @Valid MissionRequestDTO.JoinDTO request) {
        Mission mission = missionService.joinMission(request, storeId);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }
}
