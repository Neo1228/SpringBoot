package umc.spring.study.validation.annotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageNumber {
    String message() default "페이지 수가 0보다 커야 합니다.";
}
