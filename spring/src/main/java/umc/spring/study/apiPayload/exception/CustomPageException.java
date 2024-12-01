package umc.spring.study.apiPayload.exception;

public class CustomPageException extends RuntimeException {
    public CustomPageException(String message) {
        super(message);
    }
}
