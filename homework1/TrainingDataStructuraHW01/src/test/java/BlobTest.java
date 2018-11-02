import com.gmail.vladimir.chevalier.entities.Blob;
import org.junit.Before;

import java.nio.charset.Charset;

public class BlobTest {

    private Blob blob;

    @Before
    public void testInit() {
        blob = new Blob("anotherdata".getBytes(Charset.forName("UTF-8")));
    }
//TODO
}
