package umc.spring.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Mission;
import umc.spring.domain.QMember;
import umc.spring.domain.QMission;
import umc.spring.domain.QStore;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.QMemberMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMember member = QMember.member;
    private final QStore store = QStore.store;

    @Override
    public List<Mission> dynamicQueryFindInProgressMissionsByMemberWithCursor(Long memberId, Long cursorId, int limit) {
        BooleanBuilder predicate = new BooleanBuilder();

        // 특정 회원의 미션 조회
        if (memberId != null) {
            predicate.and(memberMission.member.id.eq(memberId));
        }

        // 진행 중인 미션만 조회
        predicate.and(memberMission.status.eq(MissionStatus.CHALLENGING));

        // cursorId 기준 페이징
        if (cursorId != null) {
            predicate.and(mission.id.lt(cursorId));
        }

        return jpaQueryFactory
                .selectFrom(mission)
                .join(mission.store, store).fetchJoin() // Store 정보를 함께 조회
                .join(mission.memberMissionList, memberMission).fetchJoin() // MemberMission 정보를 함께 조회
                .where(predicate)
                .orderBy(mission.id.desc())
                .limit(limit)
                .fetch();
    }
}


