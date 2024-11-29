package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.MemberMissionServiceImpl;
import umc.spring.validation.annotation.AlreadyChallengeMissions;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistMissions;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionResponseDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;

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

    @GetMapping("/{memberId}/complete")
    @Operation(summary = "사용자가 진행 완료한 미션 목록 조회 API",description = "사용자가 진행 완료한 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query string 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "사용자의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.MissionPreviewListDTO> getMissionInChallengeList(@PathVariable(name = "memberId") Long memberId, @CheckPage @RequestParam(name = "page") Integer page){
        Page<Mission> missionList = memberMissionService.getCompleteMissions(memberId, page-1);
        return ApiResponse.onSuccess(MemberConverter.missionPreviewListDTO(missionList));
    }
}
