import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

public class CommitTreeTest {
    private CommitTree ct;
    private Blob<String> file1;
    private Blob<Integer> file2;
    private Blob<Boolean> file3;
    private Blob<byte[]> file4;

    @Before
    public void setUp() throws Exception{
        ct = new CommitTree("Andrii");
        file1 = new Blob<>("file 1", "Some content");
        file2 = new Blob<>("file 2", 124);
        file3 = new Blob<>("file 3", true);
        byte[]arr = {-128, -127, -2, 0, 100, 127};
        file4 = new Blob<>("file 4", arr);
    }

    @Test
    public void testInit() {
        ct.init();
        System.out.println(ct.getCurrentBranch().hashCode());
    }

    @Test
    public void testGetCurrentBranch() {
        ct.init();
        Assert.assertEquals("Master", ct.getCurrentBranch().getName());
    }

    @Test
    public void testAddFile() {
        ct.init();
        ct.addFileToBranch(file1);
        ct.addFileToBranch(file2);
        ct.addFileToBranch(file3);
    }

    @Test
    public void testGetFile() {
        ct.init();
        ct.addFileToBranch(file3);
        Blob actual = ct.getFile("file 3");
        Assert.assertEquals(file3, actual);
    }

    @Test
    public void testDeleteFile() {
        ct.init();
        ct.addFileToBranch(file1);
        ct.addFileToBranch(file2);
        ct.addFileToBranch(file3);
        ct.deleteFileFromBranch("file 2");
        Assert.assertNull(ct.getFile("file 2"));
    }

    @Test
    public void testAddSubBranch() {
        ct.init();
        ct.addSubBranch("Second branch");
    }

    @Test
    public void testSetCurrentBranch() {
        ct.init();
        ct.addSubBranch("Second branch");
        ct.setCurrentBranch("Second branch");
        Assert.assertEquals("Second branch", ct.getCurrentBranch().getName());
        ct.setCurrentBranch("Master");
        Assert.assertEquals("Master", ct.getCurrentBranch().getName());
    }

    @Test
    public void testGetSubBranch() {
        ct.init();
        ct.addSubBranch("Second branch");
        Assert.assertEquals("Second branch", ct.getSubBranch("Second branch").getName());
        Assert.assertEquals("Master", ct.getSubBranch("Second branch").getParentBranch().getName());
    }

    @Test
    public void testDeleteSubBranch() {
        ct.init();
        ct.addSubBranch("Second branch");
        Assert.assertEquals("Second branch", ct.getSubBranch("Second branch").getName());
        ct.deleteSubBranch("Second branch");
        Assert.assertNull(ct.getSubBranch("Second branch"));
    }

    @Test
    public void testCommit() {
        ct.init();
        ct.addFileToBranch(file1);
        ct.addFileToBranch(file4);
        ct.addSubBranch("Second branch");

        ct.commit("First commit");
    }

    @Test
    public void testGetCurrentCommit() {
        ct.init();
        ct.commit("First commit");
        ct.commit("Second commit");
        Assert.assertEquals("Second commit", ct.getCurrentCommit().getCommitName());
    }

    @Test
    public void testReadListOfCommits() {
        ct.init();
        ct.addFileToBranch(file1);
        ct.addFileToBranch(file4);
        ct.addSubBranch("Second branch");

        ct.commit("First commit");
        List<String> expected = new ArrayList<>();
        expected.add("First commit");
        Assert.assertEquals(expected, ct.readListOfCommits());
    }

    @Test
    public void testSetCommitAsCurrent() {
        ct.init();
        ct.commit("First commit");
        ct.commit("Second commit");

        ct.setCommitAsCurrent("First commit");
        Assert.assertEquals("First commit", ct.getCurrentCommit().getCommitName());
    }

    @Test
    public void testDeleteCommit() {
        ct.init();
        ct.commit("First commit");
        ct.commit("Second commit");
        ct.deleteCommit("Second commit");
        Assert.assertEquals("First commit", ct.getCurrentCommit().getCommitName());
    }
}
