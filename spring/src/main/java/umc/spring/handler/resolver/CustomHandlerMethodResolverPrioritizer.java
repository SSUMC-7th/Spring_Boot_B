package umc.spring.handler.resolver;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;


public class CustomHandlerMethodResolverPrioritizer {

    private final RequestMappingHandlerAdapter adapter;

    public CustomHandlerMethodResolverPrioritizer(RequestMappingHandlerAdapter adapter) {
        this.adapter = adapter;
    }

    @PostConstruct
    public void prioritizeCustomArgumentMethodHandlers() {
        List<HandlerMethodArgumentResolver> originalResolvers = new ArrayList<>(adapter.getArgumentResolvers());
        List<HandlerMethodArgumentResolver> customResolvers = adapter.getCustomArgumentResolvers();

        // Swagger 관련 Resolver 식별 및 보호
        List<HandlerMethodArgumentResolver> swaggerResolvers = new ArrayList<>();
        for (HandlerMethodArgumentResolver resolver : originalResolvers) {
            if (resolver.getClass().getName().contains("springdoc")) { // Swagger 관련 Resolver 확인
                swaggerResolvers.add(resolver);
            }
        }

        // 기본 Resolvers에서 Swagger 관련 Resolver 제거
        originalResolvers.removeAll(swaggerResolvers);

        // 커스텀 Resolver를 맨 앞에 추가하고, Swagger Resolver는 유지
        originalResolvers.addAll(0, customResolvers);
        originalResolvers.addAll(swaggerResolvers);

        adapter.setArgumentResolvers(originalResolvers);

        System.out.println("Custom and Swagger Resolvers prioritized.");
    }



}

