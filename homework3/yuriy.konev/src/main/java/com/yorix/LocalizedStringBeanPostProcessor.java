package com.yorix;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizedStringBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Arrays.stream(bean.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(LocalizedString.class) && field.getType().equals(String.class))
                .forEach(field -> setLocalizedString(bean, field));
        return bean;
    }

    private void setLocalizedString(Object bean, Field field) {
        field.setAccessible(true);

        LocalizedString string = field.getAnnotation(LocalizedString.class);
        Locale locale = Locale.getDefault();

        String key = string.value();
        String value = ResourceBundle.getBundle("messages", locale).getString(key);

        try {
            field.set(bean, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
