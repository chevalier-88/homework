import com.gmail.vladimir.chevalier.entities.Blob;
import com.gmail.vladimir.chevalier.entities.Commit;
import com.gmail.vladimir.chevalier.entities.Tree;
import org.junit.Before;

import java.nio.charset.Charset;
import java.util.Date;

public class TestCommit {

    private String testAuthorCommit;
    private Date testDateCommit;
    private Commit testPrevCommit;
    private Tree testTree;

    private Commit currentObj;

    @Before
    public void testInit() {
        testAuthorCommit = "Ivanov Ivan";
        testDateCommit = new Date();
        testTree = new Tree(1, null, new Blob("anonimus".getBytes(Charset.forName("UTF-8"))));
        testPrevCommit = null;

        currentObj = new Commit(testAuthorCommit, testDateCommit, testPrevCommit, testTree);
    }
    //TODO
}
