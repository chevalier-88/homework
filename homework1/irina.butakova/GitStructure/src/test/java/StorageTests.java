import io.github.badgateway12.jee.Blob;
import io.github.badgateway12.jee.Commit;
import io.github.badgateway12.jee.Storage;
import io.github.badgateway12.jee.Tree;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static junit.framework.TestCase.assertEquals;

public class StorageTests {

    private Storage storage;
    private Tree tree1, tree2;
    private String string1 = "blob1 data";
    private Blob blob1 = new Blob("blob1", string1.getBytes(StandardCharsets.UTF_8));
    private String string2 = "blob2 data";
    private Blob blob2 = new Blob("blob2", string2.getBytes(StandardCharsets.UTF_8));
    private String string3 = "blob3 data";
    private Blob blob3 = new Blob("blob3", string3.getBytes(StandardCharsets.UTF_8));

    @Before
    public void setUp() throws Exception {
        storage = new Storage();
        tree1 = new Tree("tree1");
        tree2 = new Tree("tree2");
    }

    @Test
    public void testAddCommit() {
        tree1.add(blob1).add(blob2).add(tree2.add(blob3));
        storage.addCommit(1, "the first commit", tree1);

        assertEquals(1, storage.size());
    }

    @Test
    public void testGetCommitReturnsCorrectCommit() {
        tree1.add(blob1).add(blob2);
        Commit commit = storage.addCommit(1, "the first commit", tree1);

        assertEquals(commit, storage.getCommit(commit.hashCode()));
    }

    @Test
    public void testGetTreeReturnsCorrectTree() {
        tree1.add(blob1).add(blob2);
        Commit commit = storage.addCommit(1, "the first commit", tree1);

        assertEquals(tree1, storage.getTree(commit.hashCode()));
    }
}
