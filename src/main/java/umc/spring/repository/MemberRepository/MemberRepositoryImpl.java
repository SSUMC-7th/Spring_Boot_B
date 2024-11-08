package umc.spring.repository.MemberRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import umc.spring.domain.QMember;
import umc.spring.dto.MemberProfileDTO;

public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public MemberProfileDTO findMemberProfile(Long memberId) {
        QMember member = QMember.member;

        return queryFactory.select(Projections.constructor(MemberProfileDTO.class,
                        member.name,
                        member.email,
                        member.point,
                        member.phoneNumber))  // 핸드폰 번호 추가
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();
    }
}
