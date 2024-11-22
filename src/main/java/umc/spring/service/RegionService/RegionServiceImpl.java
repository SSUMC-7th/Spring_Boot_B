package umc.spring.service.RegionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.RegionRepository.RegionRepository;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl {

    private final RegionRepository regionRepository;

    public boolean doRegionExist(Long regionId) {
        return regionRepository.existsById(regionId);
    }
}
