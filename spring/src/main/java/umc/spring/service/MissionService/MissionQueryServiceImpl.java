package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.util.List;

@Service
@Transactional
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    public MissionQueryServiceImpl(MissionRepository missionRepository, StoreRepository storeRepository) {
        this.missionRepository = missionRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public List<Mission> getAvailableMissions(String regionName, Long cursor, Long memberId) {
        return missionRepository.findMissions(regionName, cursor, memberId);
    }

    @Override
    public Page<Mission> getMissionsByStore(Long storeId, Integer page) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Page<Mission> missionPage = missionRepository.findALLByStore(store, PageRequest.of(page, 10));
        return missionPage;
    }
}