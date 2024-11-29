package umc.spring.service.missionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.dto.missionDTO.MissionRequestDTO;
import umc.spring.dto.reviewDTO.ReviewRequestDTO;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.restaurantRepository.RestaurantRepository;
import umc.spring.repository.reviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService{
    private final RestaurantRepository restaurantRepository;
    private final MissionRepository missionRepository;

    @Override
    public Mission addMission(MissionRequestDTO.AddMissionDTO request){
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.RESTAURANT_NOT_FOUND));
        Mission newMission = MissionConverter.toMission(request, restaurant);
        missionRepository.save(newMission);
        return newMission;
    }

    @Override
    public Page<Mission> getMissionListByRestaurantId(Long restaurantId, Integer page){
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.RESTAURANT_NOT_FOUND));

        return missionRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
    }
}
