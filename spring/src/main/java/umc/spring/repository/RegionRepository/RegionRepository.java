package umc.spring.repository.RegionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Region;
import umc.spring.repository.StoreRepository.StoreRepositoryCustom;

public interface RegionRepository extends JpaRepository<Region, Long>, StoreRepositoryCustom {
}
