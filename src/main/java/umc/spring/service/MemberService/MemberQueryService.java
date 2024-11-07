package umc.spring.service.MemberService;

import umc.spring.domain.Member;

public interface MemberQueryService {
    Member getMemberInfo(Long memberId);
}
