package umc.spring.repository.MissionRepository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.Mission;
import umc.spring.domain.QMission;
import umc.spring.domain.QRegion;
import umc.spring.domain.QStore;
import umc.spring.domain.mapping.QMemberMission;

import java.time.LocalDate;
import java.util.List;

public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public MissionRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<Mission> findMissionsByStatus(String status, Pageable pageable) {
        QMission mission = QMission.mission;
        QMemberMission memberMission = QMemberMission.memberMission;

        BooleanExpression statusCondition = getStatusCondition(status);

        // 실제 미션 list
        List<Mission> missions = queryFactory.selectFrom(mission)
                .leftJoin(mission.memberMissionList, memberMission).fetchJoin()
                .where(statusCondition)
                .orderBy(mission.deadline.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        // 전체 미션 개수
        long total = queryFactory.selectFrom(mission)
                .where(statusCondition)
                .fetchCount();

        return new PageImpl<>(missions, pageable, total);
    }

    @Override
    public Page<Mission> findMissionsByRegion(Long regionId, Pageable pageable) {
        QMission mission = QMission.mission;
        QStore store = QStore.store;
        QRegion region = QRegion.region;

        List<Mission> missions = queryFactory.selectFrom(mission)
                .join(mission.store, store)
                .join(store.region, region)
                .where(region.id.eq(regionId)
                        .and(mission.deadline.after(LocalDate.now())))
                .orderBy(mission.deadline.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory.selectFrom(mission)
                .join(mission.store, store)
                .join(store.region, region)
                .where(region.id.eq(regionId)
                        .and(mission.deadline.after(LocalDate.now())))
                .fetchCount();

        return new PageImpl<>(missions, pageable, total);
    }

    private BooleanExpression getStatusCondition(String status) {
        QMission mission = QMission.mission;

        if ("progress".equals(status)) {
            return mission.deadline.after(LocalDate.now());
        } else if ("completed".equals(status)) {
            return mission.deadline.before(LocalDate.now());
        }
        return null;
    }
}
