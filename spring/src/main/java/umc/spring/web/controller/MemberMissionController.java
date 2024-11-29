package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.apiPayload.code.status.SuccessStatus;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.memberMissionDTO.MemberMissionRequestDTO;
import umc.spring.dto.memberMissionDTO.MemberMissionResponseDTO;
import umc.spring.dto.missionDTO.MissionResponseDTO;
import umc.spring.handler.annotation.CheckPage;
import umc.spring.handler.annotation.RestaurantExists;
import umc.spring.handler.resolver.CheckPageValidator;
import umc.spring.service.memberMissionService.MemberMissionService;

@Validated
@RestController
@RequestMapping("/members/missions")
@RequiredArgsConstructor
public class MemberMissionController {
    private final MemberMissionService memberMissionService;
    @Operation(summary = "진행 중인 미션으로 등록", description = "진행 중인 미션으로 등록하기 api입니다.")
    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionIdDTO> addMemberMission(@Valid @RequestBody MemberMissionRequestDTO.AddMemberMissionDTO request) {
        MemberMission memberMission = memberMissionService.addMemberMission(request);
        MemberMissionResponseDTO.MemberMissionIdDTO response = MemberMissionConverter.toMemberMissionIdDTO(memberMission);
        return ApiResponse.of(SuccessStatus.MEMBER_MISSION_CREATE_OK, response);
    }

    @Operation(summary = "특정 사용자의 진행 중인 미션 가져오기", description = "특정 사용자의 진행 중인 미션 가져오는 api입니다.")
    @GetMapping("/{memberId}/missions")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionListDTO> getMissionListByRestaurantId(@PathVariable(name = "memberId") Long memberId,
                                                                                                 @CheckPage @RequestParam(name = "page") Integer page) {
        MemberMissionResponseDTO.MemberMissionListDTO response = MemberMissionConverter.memberMissionListDTO(memberMissionService.getMissionListByMemberId(memberId, CheckPageValidator.adjustPage(page), MissionStatus.CHALLENGING));
        return ApiResponse.of(SuccessStatus.MISSION_GET_OK, response);
    }

    @Operation(summary = "진행 중인 미션을 진행 완료로 변경", description = "진행 중인 미션을 진행 완료로 변경하는 api입니다.")
    @PostMapping("/complete")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionIdDTO> changeToCompleteMission(@Valid @RequestBody MemberMissionRequestDTO.AddMemberMissionDTO request) {
        MemberMission memberMission = memberMissionService.changeToCompleteMission(request);
        MemberMissionResponseDTO.MemberMissionIdDTO response = MemberMissionConverter.toMemberMissionIdDTO(memberMission);
        return ApiResponse.of(SuccessStatus.MEMBER_MISSION_COMPLETE_OK, response);
    }
}
