package umc.spring.service.RegionService;

import umc.spring.domain.Store;

import java.util.List;
import java.util.Optional;

public interface RegionQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
}
