package umc.spring.service.MemberSevice;

import umc.spring.domain.Member;
import umc.spring.web.dto.MemberDTO.MemberRequestDTO;

public interface MemberService {
    Member joinMember(MemberRequestDTO.JoinDTO request);
}
