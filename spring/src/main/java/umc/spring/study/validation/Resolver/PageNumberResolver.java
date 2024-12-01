package umc.spring.study.validation.Resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.spring.study.apiPayload.exception.CustomPageException;
import umc.spring.study.validation.annotation.PageNumber;

public class PageNumberResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(PageNumber.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {
        String pageParam = webRequest.getParameter("page");
        if (pageParam == null || Integer.parseInt(pageParam) <= 0) {
            throw new CustomPageException("페이지 수가 0보다 커야 합니다.");
        }
        return Integer.parseInt(pageParam) - 1;
    }
}
