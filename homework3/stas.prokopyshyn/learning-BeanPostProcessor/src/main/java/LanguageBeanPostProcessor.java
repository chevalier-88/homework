import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageBeanPostProcessor implements BeanPostProcessor {

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> aClass = bean.getClass();
        for (Field field : aClass.getDeclaredFields()){
            if ((fieldHasCorrectType(field)) && isAnnotated(field)){
                setTranslatedValue(bean, field);
            }
        }

        return bean;
    }

    private void setTranslatedValue(Object bean, Field field) {
        LocalizedString ls = field.getAnnotation(LocalizedString.class);
        String key = ls.key();

        ResourceBundle bundle = ResourceBundle.getBundle("i18n.LanguageBundle", Locale.getDefault());
        String translation = (String) bundle.getObject(key);
        //System.out.println(translation);

        setFieldValue(bean, field, translation);
    }

    private void setFieldValue(Object bean, Field field, String translation) {
        field.setAccessible(true);
        try {
            field.set(bean, translation);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private boolean isAnnotated(Field field) {
        return field.isAnnotationPresent(LocalizedString.class);
    }

    private boolean fieldHasCorrectType(Field field) {
        return field.getType().equals(String.class);
    }

}
