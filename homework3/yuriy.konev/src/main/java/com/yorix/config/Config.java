package com.yorix.config;

import com.yorix.LocalizedStringBeanPostProcessor;
import com.yorix.beans.WorkBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public WorkBean workBean() {
        return new WorkBean();
    }

    @Bean
    public LocalizedStringBeanPostProcessor localizedStringBeanPostProcessor() {
        return new LocalizedStringBeanPostProcessor();
    }
}
