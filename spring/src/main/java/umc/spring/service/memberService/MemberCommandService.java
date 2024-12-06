package umc.spring.service.memberService;

import umc.spring.domain.Member;
import umc.spring.dto.memberDTO.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
