package umc.spring.service.MissionService;

import umc.spring.domain.Store;

import java.util.List;
import java.util.Optional;

public interface MissionQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
}
