package umc.spring.repository.MemberRepository;

import umc.spring.domain.Member;

public interface MemberRepositoryCustom {
    Member dynamicQueryGetMemberInfo(Long memberId);
}
