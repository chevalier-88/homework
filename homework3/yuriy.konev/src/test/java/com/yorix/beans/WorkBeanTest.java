package com.yorix.beans;

import com.yorix.LocalizedStringBeanPostProcessor;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {WorkBean.class, LocalizedStringBeanPostProcessor.class})
public class WorkBeanTest {
    @Autowired
    private WorkBean workBean;

    private static Locale enLocale, ruLocale, uaLocale;

    @BeforeClass
    public static void before() {
        enLocale = new Locale("en", "US");
        ruLocale = new Locale("ru", "RU");
        uaLocale = new Locale("ua", "UA");

        Locale.setDefault(ruLocale);
    }

    @Test
    public void testRuLocaleSayHello() {
        if (Locale.getDefault().equals(ruLocale))
            assertEquals(workBean.sayHello(), "здравствуйте");
    }

    @Test
    public void testEnLocaleSayHello() {
        if (Locale.getDefault().equals(enLocale))
            assertEquals(workBean.sayHello(), "hello");
    }

    @Test
    public void testUaLocaleSayHello() {
        if (Locale.getDefault().equals(uaLocale))
            assertEquals(workBean.sayHello(), "вітаю");
    }
}