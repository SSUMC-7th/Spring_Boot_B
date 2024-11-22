package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.MemberMisisonService.MemberMissionCommandService;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
public class MemberMissionRestController {

    public final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/members/missions/challenge")
    public ApiResponse<MemberMissionResponseDTO.MissionChallengeResponseDTO> challengeMission(
            @RequestBody @Valid MemberMissionRequestDTO.MissionChallengeRequestDTO request) {
        MemberMissionResponseDTO.MissionChallengeResponseDTO memberMissionResponse = memberMissionCommandService.challengeMission(request);
        return ApiResponse.onSuccess(memberMissionResponse);
    }
}
