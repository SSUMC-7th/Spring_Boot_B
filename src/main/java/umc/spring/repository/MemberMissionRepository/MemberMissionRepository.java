package umc.spring.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.MissionStatus;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    @Query("SELECT mm.status FROM MemberMission mm WHERE mm.mission.id = :missionId")
    Optional<MissionStatus> findStatusByMissionId(@Param("missionId") Long missionId);
}
