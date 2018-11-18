import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:app.xml")
public class AppTests {
    
    @Autowired
    private Navigation navigationBean;

    @Test
    public void BeanPostprocessorWithUALanguageReturnsUaLocalizedString() throws Exception {
        assertEquals( "Головна", navigationBean.getHomeItemName());
        assertEquals("Блог", navigationBean.getBlogItemName());
        assertEquals("Про автора", navigationBean.getAboutItemName());
        assertEquals("Зворотній зв'язок", navigationBean.getContactItemName());
    }
}
