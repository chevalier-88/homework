import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CommitTest {

    Commit commit1, commit2;

    @Before
    public void initObj(){
        commit1 = new Commit("Stas");
        commit2 = new Commit("Yulia");
    }

    @Test
    public void testCommitID(){
        assertEquals(0, commit2.getCommitID());
    }

    @Test
    public void testAddTree(){
        commit1.addTree("JustATree");
        assertNotNull(commit1.getParentTree());
    }


}
