package umc.spring.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.MissionRepository.MissionRepositoryImpl;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.repository.StoreRepository.StoreRepositoryImpl;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Mission joinMission(MissionRequestDTO.JoinDTO request, Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = MissionConverter.toMission(request, store);
        return missionRepository.save(mission);
    }

    public boolean doesMissionExist(Long missionId) {
        return missionRepository.existsById(missionId);
    }
}
