import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class ApplicationTest {
    @Autowired
    private NavigationBar navigationBar;
    @Test
    public void BeanPostprocessorWithUALanguageReturnsUaLocalizedString() throws Exception {
        Assert.assertEquals( "Datei", navigationBar.getFile());
        Assert.assertEquals("Bearbeiten", navigationBar.getEdit());
        Assert.assertEquals("Aussicht", navigationBar.getView());
        Assert.assertEquals("Navigieren", navigationBar.getNavigate());
        Assert.assertEquals("Code", navigationBar.getCode());
        Assert.assertEquals("Analysieren", navigationBar.getAnalyze());
    }
}
