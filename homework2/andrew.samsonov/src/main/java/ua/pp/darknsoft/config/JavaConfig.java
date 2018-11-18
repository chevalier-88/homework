package ua.pp.darknsoft.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ua.pp.darknsoft.models.Buyer;

@Configuration
public class JavaConfig {
    private long buyerCounter;

    @Bean
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public Buyer buyer() {
        buyerCounter++;
        return new Buyer(buyerCounter, "firstName" + buyerCounter, "lastName" + buyerCounter);
    }


}
