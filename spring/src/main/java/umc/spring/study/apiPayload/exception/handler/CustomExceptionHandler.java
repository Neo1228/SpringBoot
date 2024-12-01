package umc.spring.study.apiPayload.exception.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.CustomPageException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomPageException.class)
    public ApiResponse<String> handlePageException(CustomPageException ex) {
        // 실패 응답 생성
        return ApiResponse.onFailure(ErrorStatus.PAGE_VALIDATION_FAILED.getCode(),
                ErrorStatus.PAGE_VALIDATION_FAILED.getMessage(),
                ex.getMessage());
    }
}
