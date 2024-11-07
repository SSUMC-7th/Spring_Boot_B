package umc.spring.repository.MissionRepository;

import com.querydsl.core.types.dsl.BooleanExpression;
import umc.spring.domain.Mission;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> findMissions(String regionName, Long cursor, Long memberId);
}