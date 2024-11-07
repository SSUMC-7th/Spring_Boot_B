package umc.spring.repository.MemberRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Member;
import umc.spring.domain.QMember;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;

    @Override
    public Member dynamicQueryGetMemberInfo(Long memberId) {
        BooleanBuilder predicate = new BooleanBuilder();

        // 조건 추가: memberId가 존재하는 경우
        if (memberId != null) {
            predicate.and(member.id.eq(memberId));
        }

        // 조건에 맞는 Member 조회
        return jpaQueryFactory
                .selectFrom(member)
                .where(predicate)
                .fetchOne();
    }
}
