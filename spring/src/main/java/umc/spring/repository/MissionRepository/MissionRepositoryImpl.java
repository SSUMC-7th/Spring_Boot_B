package umc.spring.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Mission;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static umc.spring.domain.QMission.mission;
import static umc.spring.domain.QStore.store;
import static umc.spring.domain.QRegion.region;
import static umc.spring.domain.mapping.QMemberMission.memberMission;

@Repository
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Autowired
    public MissionRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Mission> findMissions(String regionName, Long cursor, Long memberId) {
        BooleanBuilder builder = new BooleanBuilder();

        if (regionName != null) {
            builder.and(region.name.eq(regionName));
        }
        if (cursor != null) {
            builder.and(mission.id.lt(cursor));
        }
        builder.and(mission.dueDate.after(LocalDate.from(LocalDateTime.now())));

        // 미션 ID가 member_mission에 존재하지 않는 조건
        builder.and(mission.id.notIn(
                queryFactory.select(memberMission.mission.id)
                        .from(memberMission)
                        .where(memberMission.member.id.eq(memberId))
        ));

        return queryFactory.select(mission)
                .from(mission)
                .join(mission.store, store)
                .join(store.region, region)
                .where(builder)
                .orderBy(mission.id.desc())
                .limit(10)
                .fetch();
    }
}


