package umc.spring.handler.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.spring.handler.annotation.CheckPage;

@Component
public class CheckPageArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean hasCheckPage = parameter.hasParameterAnnotation(CheckPage.class);
        boolean isRequestParam = parameter.hasParameterAnnotation(RequestParam.class);
        boolean isInteger = parameter.getParameterType().equals(Integer.class);

        System.out.println("supportsParameter called for parameter: " + parameter.getParameterName()
                + ", hasCheckPage: " + hasCheckPage + ", isRequestParam: " + isRequestParam
                + ", isInteger: " + isInteger);
        return hasCheckPage && isRequestParam && isInteger;
    }


    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        System.out.println("CheckPageArgumentResolver resolveArgument called for: " + parameter.getParameterName());

        String pageParam = webRequest.getParameter("page");
        if (pageParam == null) {
            throw new IllegalArgumentException("page 파라미터가 필요합니다.");
        }

        int page = Integer.parseInt(pageParam);
        if (page < 1) {
            throw new IllegalArgumentException("페이지 값은 1 이상이어야 합니다.");
        }
        return page - 1;
    }
}
