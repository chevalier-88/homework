import org.junit.Test;

import static org.junit.Assert.*;

public class CommitTest {
    @Test
    public void test() throws Exception {
        Commit commit1 = new Commit("Alice", new Tree(), null);
        System.out.println(commit1.toString());
        Tree tree = new Tree();
        byte[] data = {(byte)1, (byte)2, (byte) 3};
        Blob blob = new Blob(data);
        tree.addBlob("qwe", blob);
        Commit commit2 = new Commit("Bob", tree, commit1);
        System.out.println(commit2.toString());
        System.out.println(commit2.get_previous().get_author());
    }

}