package com.ecom.api.security;

import org.springframework.context.annotation.Configuration;
//import com.okta.spring.boot.oauth.Okta;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.accept.ContentNegotiationStrategy;
//import org.springframework.web.accept.HeaderContentNegotiationStrategy;

@Configuration
public class SecurityConfiguration {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        // protect endpoint
//        http.authorizeRequests()
//                .requestMatchers("/v1/orders/**")
//                .authenticated()
//                .and()
//                .oauth2ResourceServer()
//                .jwt();
//
//        // add cors filters
//        http.cors();
//
//        // enable below once version 3.0.1 support okta
//        // add content negotiation strategy
//        //http.setSharedObject(ContentNegotiationStrategy.class, new HeaderContentNegotiationStrategy());
//
//        // force a non-empty response body for 401 to make response more friendly
//        //Okta.configureResourceServer401ResponseBody(http);
//
//        return http.build();
//    }
 }
