import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizedNavigationBeanPostProcessor implements BeanPostProcessor {

    private Locale locale;

    public LocalizedNavigationBeanPostProcessor() {
        locale = Locale.getDefault();
    }

    public LocalizedNavigationBeanPostProcessor(String language) {
        try {
            locale = new Locale(language);
        } catch (Exception e) {
            locale = Locale.getDefault();
        }
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
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
        return field.isAnnotationPresent(Localized.class);
    }

    private void setLocalizedValue(Object bean, Field field) {
        String key = field.getAnnotation(Localized.class).key();
        String localizedValue = ResourceBundle.getBundle("locale/navigation", locale).getString(key);
        field.setAccessible(true);
        try {
            field.set(bean, localizedValue);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
