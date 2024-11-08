package umc.spring.repository.MemberMissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QMember;
import umc.spring.domain.QMission;
import umc.spring.domain.QStore;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.QMemberMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<MemberMission> findMissionsByMemberAndStatus(Long memberId, String status, Long cursor, Pageable pageable) {
        QMember member = QMember.member;
        QMemberMission memberMission = QMemberMission.memberMission;
        QMission mission = QMission.mission;
        QStore store = QStore.store;

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(member.id.eq(memberId));
        builder.and(memberMission.status.eq(MissionStatus.valueOf(status)));

        // cursor 값 조건 추가
        if (cursor != null) {
            builder.and(mission.id.lt(cursor));
        }

        List<MemberMission> result = jpaQueryFactory
                .select(memberMission)
                .from(member)
                .join(memberMission).on(member.id.eq(memberMission.member.id))
                .join(mission).on(memberMission.mission.id.eq(mission.id))
                .join(store).on(mission.store.id.eq(store.id))
                .where(builder)
                .orderBy(mission.id.desc())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(result, pageable, result.size());
    }
}
