import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class Application {

    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMANY);

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:/app.xml");

        context.registerShutdownHook();
    }
}
