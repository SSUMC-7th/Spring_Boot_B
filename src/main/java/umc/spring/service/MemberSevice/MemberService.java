package umc.spring.service.MemberSevice;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.web.dto.MemberDTO.MemberRequestDTO;

public interface MemberService {
    Member joinMember(MemberRequestDTO.JoinDTO request);
    Page<Review> getReviewList(Long memberId, Integer page);
}
