package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.enums.Gender;
import umc.spring.dto.memberDTO.MemberRequestDTO;

import java.util.ArrayList;

public class MemberConverter {
    public static Member toMember(MemberRequestDTO.JoinDto request) {
        Gender gender = null;
        switch (request.getGender()) {
            case 1: gender = Gender.MALE; break;
            case 2: gender = Gender.FEMALE; break;
        }

        return Member.builder()
                .name(request.getName())
                .email(request.getEmail())   // 추가된 코드
                .password(request.getPassword())   // 추가된 코드
                .gender(gender)
                .address(request.getAddress())
                .role(request.getRole())   // 추가된 코드
                .build();
    }
}
