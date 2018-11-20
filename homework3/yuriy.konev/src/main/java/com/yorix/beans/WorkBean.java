package com.yorix.beans;

import com.yorix.LocalizedString;
import org.springframework.beans.factory.InitializingBean;

public class WorkBean implements InitializingBean {
    @LocalizedString("hello")
    private String greeting;

    @LocalizedString("thank_you")
    private String thanks;

    @LocalizedString("goodbye")
    private String goodbye;

    public String sayHello() {
        return greeting;
    }

    public String sayThankYou() {
        return thanks;
    }

    public String sayGoodbye() {
        return goodbye;
    }

    private void init() {
        System.out.printf("%s, %s, %s!", sayHello(), sayThankYou(), sayGoodbye());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }
}
