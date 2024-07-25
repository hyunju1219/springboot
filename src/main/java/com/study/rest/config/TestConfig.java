package com.study.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.TypedValue;

@Configuration
public class TestConfig {

    //라이브러리의 객체를 직접 생성해 bean으로 등록(직접 생성한 메서드 위에 @Bean작성 대신 그 클래스는 @Configuration이 있어야함 )
    @Bean
    public TypedValue typedValue() {
        return new TypedValue(null);
    }
}
