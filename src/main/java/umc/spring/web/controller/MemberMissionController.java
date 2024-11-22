package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.MemberMissionServiceImpl;
import umc.spring.validation.annotation.AlreadyChallengeMissions;
import umc.spring.validation.annotation.ExistMissions;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionResponseDTO;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/membermissions")
public class MemberMissionController {

    private final MemberMissionServiceImpl memberMissionService;

    @PostMapping("/{memberId}/{missionId}/challenge")
    public ApiResponse<MemberMissionResponseDTO.joinResultDTO> join(
            @PathVariable("memberId") Long memberId,
            @PathVariable("missionId") @ExistMissions @AlreadyChallengeMissions Long missionId) {

        MemberMission memberMission = memberMissionService.joinMemberMission(memberId, missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toJoinResultDTO(memberMission));
    }
}
