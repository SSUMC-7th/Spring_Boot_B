package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Optional<Mission> findMission(Long id) {
        return missionRepository.findById(id);
    }

    @Override
    public List<Mission> findInProgressMissionsByMemberWithCursor(Long memberId, Long cursorId, int limit) {
        List<Mission> filteredMissions = missionRepository.dynamicQueryFindInProgressMissionsByMemberWithCursor(memberId, cursorId, limit);

        // 출력 확인
        filteredMissions.forEach(mission -> System.out.println("Mission ID: " + mission.getId() +
                ", Store Name: " + mission.getStore().getName() +
                ", Reward: " + mission.getReward() +
                ", Mission Spec: " + mission.getMissionSpec() +
                ", Status: " + mission.getMissionStatus()));

        return filteredMissions;
    }

    @Override
    public Page<Mission> getMissionsByStore(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("가게를 찾을 수 없습니다."));
        return missionRepository.findByStore(store, PageRequest.of(page, 10));
    }
}