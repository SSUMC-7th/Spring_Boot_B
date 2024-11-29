package umc.spring.service.ReviewService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.time.LocalDateTime;

@Service
@Transactional
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    public ReviewQueryServiceImpl(ReviewRepository reviewRepository, MemberRepository memberRepository, StoreRepository storeRepository) {
        this.reviewRepository = reviewRepository;
        this.memberRepository = memberRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public Review saveReview(Long memberId, Long storeId, String content, float rating) {
        // Member와 Store 엔티티 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found with ID: " + memberId));
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found with ID: " + storeId));

        // Review 생성 및 저장
        Review review = Review.builder()
                .member(member)
                .store(store)
                .content(content)
                .rating(rating)
                .build();

        return reviewRepository.save(review);
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {

        Store store = storeRepository.findById(StoreId)
                .orElseThrow(() -> new IllegalArgumentException("해당 가게가 존재하지 않습니다; StoreId: " + StoreId));


        Page<Review> ReviewPage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return ReviewPage;
    }
}
