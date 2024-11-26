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
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.memberMissionDTO.MemberMissionRequestDTO;
import umc.spring.dto.memberMissionDTO.MemberMissionResponseDTO;
import umc.spring.service.memberMissionService.MemberMissionService;

@RestController
@RequestMapping("/members/missions")
@RequiredArgsConstructor
public class MemberMissionController {
    private final MemberMissionService memberMissionService;
    @Operation(summary = "챌린지 중인 미션으로 등록", description = "챌린지 중인 미션으로 등록하기 api입니다.")
    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionIdDTO> addMemberMission(@Valid @RequestBody MemberMissionRequestDTO.AddMemberMissionDTO request) {
        MemberMission memberMission = memberMissionService.addMemberMission(request);
        MemberMissionResponseDTO.MemberMissionIdDTO response = MemberMissionConverter.toMemberMissionIdDTO(memberMission);
        return ApiResponse.of(SuccessStatus.MEMBER_MISSION_CREATE_OK, response);
    }
}
