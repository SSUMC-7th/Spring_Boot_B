package umc.spring.service.MemberService;

import umc.spring.domain.Store;

import java.util.List;
import java.util.Optional;

public interface MemberQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
}
