package com.gumdan.unicorn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author kampf
 * @date 2019/7/22 08:50
 */
@Configuration
public class CorsConfig {

    private CorsConfiguration bulidConfig(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
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

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", bulidConfig());
        return new CorsFilter(source);
    }
}
