package umc.spring.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Review;
import umc.spring.domain.Store;

import umc.spring.repository.RegionRepository.RegionRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.StoreDTO.StoreRequestDTO;


@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public Store joinStore(StoreRequestDTO.JoinDTO request) {
       Region region = regionRepository.findById(request.getRegionId())
               .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

       Store newStore = StoreConverter.toStore(request, region);
       return storeRepository.save(newStore);
    }

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();

        Page<Review> storePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return storePage;
    }

    public boolean doesStoreExist(Long storeId) {
        return storeRepository.existsById(storeId);
    }
}
