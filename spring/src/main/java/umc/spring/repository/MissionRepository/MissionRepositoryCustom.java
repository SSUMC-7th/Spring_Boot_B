package umc.spring.repository.MissionRepository;

import umc.spring.domain.Mission;
import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> dynamicQueryWithBooleanBuilder(String name, Float score);
}