import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GitTest {
    private static Tree oldCommitRoot, newCommitRoot, workRoot;
    private static Git git;

    @BeforeClass
    public static void init() {
        workRoot = new Tree("root");
        git = new Git(workRoot);
    }

    @Test
    public void testCommit() {
        workRoot.add(new Tree("tree 1").add(new Blob("blob 1")));
        git.commit("commit 1", "Yorix");
        oldCommitRoot = newCommitRoot = git.getCommits().get(0).getTree();

        assertEquals(oldCommitRoot, workRoot);
        assertEquals(newCommitRoot, workRoot);
        assertEquals(oldCommitRoot, newCommitRoot);

        workRoot.add(new Blob("blob 2"));

        assertNotEquals(oldCommitRoot, workRoot);
        assertNotEquals(newCommitRoot, workRoot);
        assertEquals(oldCommitRoot, newCommitRoot);

        git.commit("commit 2", "Yorix");
        newCommitRoot = git.getCommits().get(1).getTree();

        assertNotEquals(oldCommitRoot, workRoot);
        assertEquals(newCommitRoot, workRoot);
        assertNotEquals(oldCommitRoot, newCommitRoot);
    }

    @Test
    public void testGit() {
        Git git;
        Tree tree1, tree2, tree3;
        Blob blob1, blob2, blob3;

        tree1 = new Tree("directory 1");
        tree2 = new Tree("directory 2");
        tree3 = new Tree("directory 3");
        blob1 = new Blob("file 1");
        blob2 = new Blob("file 2");
        blob3 = new Blob("file 3");

        git = new Git(tree1);

        tree1.add(blob1);
        git.commit("commit 1", "Yorix");
        git.printCommits();
        System.out.println("\n");

        tree2.add(blob2);
        tree1.add(tree2);
        git.commit("commit 2", "Yorix");
        git.printCommits();
        System.out.println("\n");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tree2.add(tree3);
        tree3.add(blob3);
        blob1.setData("CHANGE".getBytes());
        git.commit("commit 3", "Yorix");
        git.printCommits();
        System.out.println("\n");

        blob1.setName("blob 1");
        tree2.remove(tree3);
        git.commit("commit 4", "Yorix");
        git.printCommits();
    }
}