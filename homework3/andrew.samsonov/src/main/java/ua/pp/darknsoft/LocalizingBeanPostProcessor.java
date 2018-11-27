package ua.pp.darknsoft;

import org.springframework.beans.factory.config.BeanPostProcessor;
import ua.pp.darknsoft.anotation.Localize;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizingBeanPostProcessor implements BeanPostProcessor {

    private Locale locale;

    public LocalizingBeanPostProcessor() {
        locale = Locale.getDefault();
    }

    public LocalizingBeanPostProcessor(String lang) {
        this.locale = new Locale(lang);
        System.out.println("getCountry(): " + locale.getLanguage());
        System.out.println("toString(): " + locale.toString());
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {

        Arrays
                .stream(bean.getClass().getDeclaredFields())
                .filter(this::isStringField)
                .filter(this::isAnnotatedWithLocalized)
                .forEach(field -> setLocalizedValue(bean, field));
        return bean;
    }

    private boolean isStringField(Field field) {
        return field.getType().equals(String.class);
    }

    private boolean isAnnotatedWithLocalized(Field field) {
        return field.isAnnotationPresent(Localize.class);
    }

    private void setLocalizedValue(Object bean, Field field) {
        String key = field.getAnnotation(Localize.class).key();
        String localizedValue = ResourceBundle.getBundle("i18n/application", locale).getString(key);
        field.setAccessible(true);
        try {
            field.set(bean, localizedValue);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
