package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.validation.annotation.CheckMemberMissionInProgress;
import umc.spring.validation.annotation.CheckMemberMissionNotInProgress;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionResponseDTO;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/member-missions")
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    @Operation(summary = "유저의 진행 중인 미션 생성", description = "유저의 진행 중인 미션을 생성합니다.")
    public ApiResponse<MemberMissionResponseDTO.CreateMemberMissionResultDto> createMemberMission(
            @RequestBody @Valid @CheckMemberMissionInProgress MemberMissionRequestDTO.CreateMemberMissionDto request) {
        MemberMission memberMission = memberMissionCommandService.createMemberMissionInProgress(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toCreateResultDto(memberMission));
    }

    @PostMapping("/complete")
    @Operation(summary = "유저의 진행 중인 미션 완료로 변경", description = "유저의 진행 중인 미션을 완료로 변경합니다.")
    public ApiResponse<MemberMissionResponseDTO.UpdateMissionCompleteResultDTO> completeMemberMission(
            @RequestBody @Valid @CheckMemberMissionNotInProgress MemberMissionRequestDTO.UpdateMemberMissionCompleteDTO request) {
        MemberMission memberMission = memberMissionCommandService.updateMemberMissionComplete(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toUpdateCompleteResultDTO(memberMission));
    }
}

