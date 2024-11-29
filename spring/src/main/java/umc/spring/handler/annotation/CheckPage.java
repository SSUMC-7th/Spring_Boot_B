package umc.spring.handler.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "페이지 값이 잘못되었습니다. 1 이상이어야 합니다.";
}
