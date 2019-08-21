package com.gundam.unicorn.config;

import com.gundam.unicorn.config.intercepter.UnicornInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域请求控制合并拦截器控制
 * @author kampf
 * @date 2019/7/22 08:50
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Autowired
    UnicornInterceptor unicornInterceptor;

    /**
     * 用于加载静态资源配置，html，js，css等
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
    }

    /**
     * 注册拦截器，自定义需要在此注册生效
     * @return
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        /**
         * swagger需要过滤，将其添置在自定义
         */
        registry.addInterceptor(unicornInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.jpeg", "/*.html", "/**/*.html","/swagger-resources/**");
    }

    /**
     * 设置跨域
     * @return
     */
    @Bean
    public FilterRegistrationBean corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", bulidConfig());

        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }

    /**
     * 跨域参数设置
     * @return
     */
    private CorsConfiguration bulidConfig(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        /**
         * 允许跨域携带域名
         */
        corsConfiguration.setAllowCredentials(true);
        /**
         * 允许任何域名
         */
        corsConfiguration.addAllowedOrigin("*");
        /**
         * 允许任何请求头
         */
        corsConfiguration.addAllowedHeader("*");
        /**
         * 允许任何请求方法
         */
        corsConfiguration.addAllowedMethod("*");

        return corsConfiguration;
    }
}
