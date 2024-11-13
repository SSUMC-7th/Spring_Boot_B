package umc.spring.apiPayload.code;

import java.awt.desktop.UserSessionEvent;

public interface BaseCode {

    UserSessionEvent.Reason getReason();

    UserSessionEvent.Reason getReasonHttpStatus();

}
