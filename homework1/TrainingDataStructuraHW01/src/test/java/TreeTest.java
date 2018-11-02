import com.gmail.vladimir.chevalier.entities.Blob;
import com.gmail.vladimir.chevalier.entities.Tree;
import org.junit.Before;

import java.nio.charset.Charset;

public class TreeTest {

    private int testTreeID;
    private Tree testOtherTree;
    private Blob testBlob;

    private Tree currentObj;

    @Before
    public void testInit() {
        testTreeID = 1;
        testBlob = new Blob("blob_for_test".getBytes(Charset.forName("UTF-8")));
        testOtherTree = null;
        currentObj = new Tree(testTreeID, null, testBlob);
    }
    //TODO
}
