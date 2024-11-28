package umc.spring.service.StoreService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreDTO.StoreRequestDTO;

public interface StoreService {
    Store joinStore(StoreRequestDTO.JoinDTO request);
    Page<Review> getReviewList(Long StoreId, Integer page);
}
