package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.service.MemberMisisonService.MemberMissionCommandService;
import umc.spring.service.MemberMisisonService.MemberMissionQueryService;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members/{memberId}/missions")
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;
    private final MemberMissionQueryService memberMissionQueryService;


    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDTO.MissionChallengeResponseDTO> challengeMission(
            @RequestBody @Valid MemberMissionRequestDTO.MissionChallengeRequestDTO request) {
        MemberMissionResponseDTO.MissionChallengeResponseDTO memberMissionResponse = memberMissionCommandService.challengeMission(request);
        return ApiResponse.onSuccess(memberMissionResponse);
    }

    @GetMapping("/in-progressList")
    @Operation(summary = "진행 중인 미션 목록 조회", description = "회원이 진행 중인 미션 목록을 페이징하여 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원 ID (Path Variable)"),
            @Parameter(name = "page", description = "페이지 번호 (1부터 시작)")
    })
    public ApiResponse<MissionResponseDTO.MissionListDTO> getInProgressMissions(
            @PathVariable Long memberId,
            @CheckPage @RequestParam Integer page) {

        Page<Mission> missions = memberMissionQueryService.getInProgressMissions(memberId, page - 1);

        return ApiResponse.onSuccess(MissionConverter.toMissionListDTO(missions));
    }
}
