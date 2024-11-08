package umc.spring.repository.MemberRepository;

import com.querydsl.core.types.dsl.BooleanExpression;
import umc.spring.domain.Member;
import java.util.Optional;

public interface MemberRepositoryCustom {
    Optional<Member> findMemberById(Long memberId);
}
