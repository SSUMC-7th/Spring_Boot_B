package umc.spring.repository.MemberRepository;

import umc.spring.domain.Member;
import umc.spring.dto.MemberProfileDTO;

public interface MemberRepositoryCustom {
    MemberProfileDTO findMemberProfile(Long memberId);
}
