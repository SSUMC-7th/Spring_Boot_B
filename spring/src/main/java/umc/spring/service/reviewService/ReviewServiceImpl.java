package umc.spring.service.reviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.dto.reviewDTO.ReviewRequestDTO;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.restaurantRepository.RestaurantRepository;
import umc.spring.repository.reviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    @Override
    public Review addReview(ReviewRequestDTO.AddReviewDTO request){
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow();
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow();
        Review review = ReviewConverter.toReview(request, restaurant, member);
        reviewRepository.save(review);
        return review;
    }
}
