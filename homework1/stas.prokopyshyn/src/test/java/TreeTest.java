import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TreeTest {

    Tree tree1, tree2;


    @Before
    public void initObjects(){
        tree1 = new Tree("TreeOne");
        tree2 = new Tree("TreeTwo");
    }

    @Test
    public void testAddBlob() throws Exception {
        tree1.addBlob(new Blob("B1", new String("BlobOne").getBytes()));
        tree1.addBlob(new Blob("B2", new String("BlobTwo").getBytes()));
        assertEquals(2, tree1.getListOfBlobs().size());
    }

    @Test
    public void testAddTree(){
        tree1.addTree(new Tree("TreeOne"));
        tree1.addTree(new Tree("TreeTwo"));
        assertEquals(2, tree1.getTreeList().size());
    }

    @Test
    public void testEquals(){
        tree1.addBlob(new Blob("B1", new String("BlobOne").getBytes()));
        tree1.addBlob(new Blob("B2", new String("BlobTwo").getBytes()));

        tree2.addBlob(new Blob("B1", new String("BlobOne").getBytes()));
        tree2.addBlob(new Blob("B2", new String("BlobTwo").getBytes()));

        assertEquals(false, tree1.equals(tree2));
    }
}
