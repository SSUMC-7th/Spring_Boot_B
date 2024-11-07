package umc.spring.repository.MemberRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Member;

import java.util.Optional;

import static umc.spring.domain.QMember.member;

@Repository
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Autowired
    public MemberRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Optional<Member> findMemberById(Long memberId) {
        BooleanBuilder builder = new BooleanBuilder();

        if (memberId != null) {
            builder.and(member.id.eq(memberId));
        }

        Member result = queryFactory.selectFrom(member)
                .where(builder)
                .fetchOne();

        return Optional.ofNullable(result);
    }
}

