import io.github.badgateway12.jee.Blob;
import io.github.badgateway12.jee.Tree;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static junit.framework.TestCase.assertEquals;

public class TreeTests {
    private Tree tree1, tree2;
    private String string1 = "blob1 data";
    private Blob blob1 = new Blob("blob1", string1.getBytes(StandardCharsets.UTF_8));
    private String string2 = "blob2 data";
    private Blob blob2 = new Blob("blob2", string2.getBytes(StandardCharsets.UTF_8));
    private String string3 = "blob3 data";
    private Blob blob3 = new Blob("blob3", string3.getBytes(StandardCharsets.UTF_8));

    @Before
    public void setUp() throws Exception {
        tree1 = new Tree("tree1");
        tree2 = new Tree("tree2");
    }

    @Test
    public void testAddBlob() {
        tree1.add(blob1);

        assertEquals(1, tree1.size());
    }


    @Test
    public void testAddTree() {
        tree1.add(blob1).add(blob2).add(tree2.add(blob3));

        assertEquals(3, tree1.size());
    }

    @Test
    public void testRemoveBlob() {
        tree1.add(blob1);
        tree1.add(blob2);
        tree1.remove(blob1);
        assertEquals(1, tree1.size());
    }


    @Test
    public void testRemoveTree() {
        tree1.add(blob1).add(tree2.add(blob3));
        tree1.remove(tree2);

        assertEquals(1, tree1.size());
    }
}
