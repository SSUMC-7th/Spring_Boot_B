package umc.spring.repository.RegionRepository;

import umc.spring.domain.Region;
import java.util.List;

public interface RegionRepositoryCustom {
    List<Region> dynamicQueryWithBooleanBuilder(String name, Float score);
}