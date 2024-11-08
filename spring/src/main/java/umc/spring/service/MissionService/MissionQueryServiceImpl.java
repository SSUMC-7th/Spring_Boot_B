package umc.spring.service.MissionService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.repository.MissionRepository.MissionRepository;

import java.util.List;

@Service
@Transactional
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    public MissionQueryServiceImpl(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    @Override
    public List<Mission> getAvailableMissions(String regionName, Long cursor, Long memberId) {
        return missionRepository.findMissions(regionName, cursor, memberId);
    }
}