package umc.spring.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import umc.spring.handler.resolver.CheckPageArgumentResolver;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final CheckPageArgumentResolver checkPageArgumentResolver;

    public WebConfig(CheckPageArgumentResolver checkPageArgumentResolver) {
        this.checkPageArgumentResolver = checkPageArgumentResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(0, checkPageArgumentResolver);
        System.out.println("CheckPageArgumentResolver registered.");
        resolvers.forEach(resolver -> System.out.println("Registered Resolver: " + resolver.getClass().getName()));

    }
}


