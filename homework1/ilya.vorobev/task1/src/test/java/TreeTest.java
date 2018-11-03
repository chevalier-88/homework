import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void test() throws Exception {
        Tree tree = new Tree();
        byte[] data = {(byte)1, (byte)2, (byte) 3};
        Blob blob = new Blob(data);
        tree.addBlob("qwe", blob);
        System.out.println(tree.containsBlob("qwe"));
        System.out.println(tree.toString());

        Tree tree1 = new Tree();
        tree1.addSubtree("child1", tree);
        System.out.println(tree1.toString());
        tree.removeBlob("qwe");
        System.out.println(tree.toString());
        System.out.println(tree1.getSubtree("child1").toString());
    }

}