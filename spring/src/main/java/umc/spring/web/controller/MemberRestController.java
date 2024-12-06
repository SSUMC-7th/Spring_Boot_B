package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.MemberRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.CreateMemberResultDTO> addMember(@RequestBody @Valid MemberRequestDTO.CreateMemberDto request){
        Member member = memberCommandService.createMember(request);
        return ApiResponse.onSuccess(MemberConverter.toCreateResultDTO(member));
    }
}
