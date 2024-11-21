package umc.spring.apiPayload.exception.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.code.status.ErrorStatus;

@Getter
public class StoreHandler extends RuntimeException {
    private final ErrorStatus errorStatus;

    public StoreHandler(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
        this.errorStatus = errorStatus;
    }

    public HttpStatus getHttpStatus() {
        return this.errorStatus.getHttpStatus();
    }
}

