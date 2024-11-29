package umc.spring.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apiPayload.code.BaseCode;
import umc.spring.apiPayload.code.ReasonDTO;
@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    // 일반적인 응답
    _OK(HttpStatus.OK, "COMMON200", "성공입니다."),
    // 멤버 관련 응답
    // 리뷰 관련 응답
    REVIEW_CREATE_OK(HttpStatus.OK, "REVIEW201", "리뷰 등록 성공"),
    REVIEW_GET_OK(HttpStatus.OK, "REVIEW202", "리뷰 가져오기 성공"),

    // 레스토랑  관련 응답
    RESTAURANT_CREATE_OK(HttpStatus.OK, "RESTAURANT201", "레스토랑 등록 성공"),

    // 미션 관련 응답
    MISSION_CREATE_OK(HttpStatus.OK, "MISSION201", "미션 등록 성공"),

    MEMBER_MISSION_CREATE_OK(HttpStatus.OK, "MISSION202", "진행 중인 미션 등록 성공"),
    MISSION_GET_OK(HttpStatus.OK, "MISSION203", "미션 가져오기 성공"),
    MEMBER_MISSION_COMPLETE_OK(HttpStatus.OK, "MISSION204", "미션 완료 등록 성공");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }
    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
