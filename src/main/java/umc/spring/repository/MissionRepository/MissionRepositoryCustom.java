package umc.spring.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.Mission;

public interface MissionRepositoryCustom {
    // 상태(progress, completed)와 paging 정보를 받아 해당 조건에 맞는 mission 목록을 페이지 형태로 반환
    Page<Mission> findMissionsByStatus(String status, Pageable pageable);
    Page<Mission> findMissionsByRegion(Long regionId, Pageable pageable);
}
