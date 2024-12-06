package umc.spring.service.memberService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.FavoriteFood;
import umc.spring.domain.Member;
import umc.spring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.dto.memberDTO.MemberRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        /*
        if (request.getPreferCategory() != null) {
            List<FavoriteFood> favoriteFoods = request.getPreferCategory().stream()
                    .map(foodName -> {
                        FavoriteFood favoriteFood = favoriteFoodRepository.findById();
                        favoriteFood.setFoodName(foodName);
                        return favoriteFood;
                    }).toList();
        }
         */
        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));
        return memberRepository.save(newMember);
    }
}
