/**
 * @author Andrii Hubarenko
 * Class operator uses for operating by tree
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;

public class CommitTree implements Iterable{
    private String userName;
    private Branch currentBranch;
    private Commit currentCommit;
    int idCount = 1;

    CommitTree(String userName) {
        this.userName = userName;
    }

    /**
     * Class commit uses as a checkpoint, contains a top branch of a tree.
     */
    class Commit {
        private long id;
        private String userName;
        private String commitName;
        private Date dateOfCommitting;
        private Branch topBranch;
        private Commit previousCommit;

        Commit(long id, String userName, String commitName, Branch topBranch, Commit previousCommit) {
            this.id = id;
            this.userName = userName;
            this.commitName = commitName;
            this.dateOfCommitting = new Date();
            this.topBranch = topBranch;
            this.previousCommit = previousCommit;
        }

        public long getId() {
            return id;
        }

        public String getUserName() {
            return userName;
        }

        public String getCommitName() {
            return commitName;
        }

        public Date getDateOfCommitting() {
            return dateOfCommitting;
        }

        public Commit getPreviousCommit() {
            return previousCommit;
        }

        public void setPreviousCommit(Commit previousCommit) {
            this.previousCommit = previousCommit;
        }


        public Branch getTopBranch() {
            return topBranch;
        }

        @Override
        public boolean equals(Object other) {
            if (other == null) return false;
            if (other == this) return true;
            if (!(other instanceof Commit)) return false;
            Commit otherCommit = (Commit) other;
            return otherCommit.getId() == (this.id)
                    && otherCommit.getUserName().equals(this.userName)
                    && otherCommit.getCommitName().equals(this.commitName)
                    && otherCommit.getDateOfCommitting().equals(this.dateOfCommitting)
                    && otherCommit.getTopBranch().equals(this.topBranch)
                    && otherCommit.getPreviousCommit().equals(this.previousCommit);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, userName, commitName, dateOfCommitting, topBranch, previousCommit);
        }

        @Override
        public String toString() {
            return "ID: " + id + " "
                    + "USER NAME" + userName + " "
                    + "COMMIT NAME" + commitName + " "
                    + "DATE OF COMMIT" + dateOfCommitting.getTime() + " "
                    + "NAME OF BRANCH" + topBranch.getName() + " "
                    + "REFERENCE TO PREVIOUS COMMIT" + previousCommit;
        }
    }

    /**
     * Method initialize the work with the tree and create
     * the first branch named "Master"
     */
    public void init() {
        if(currentBranch == null) {
            currentBranch = new Branch("Master");
        } else {
            System.out.println("Already initialized!");
        }
    }

    /**
     * Provide the access to current branch
     * @return Branch which is current
     */
    public Branch getCurrentBranch() {
        return currentBranch;
    }

    /**
     * Method adds file to current branch
     * @param blob file you are going to add to the branch
     */
    public void addFileToBranch(Blob blob) {
        currentBranch.addFile(blob);
    }

    /**
     * Method return the desired file
     * @param name of desired file
     * @return Blob file or null
     */
    public Blob getFile(String name) {
        return currentBranch.getFile(name);
    }

    /**
     * Remove file from the branch by file name
     * @param name of file
     */
    public void deleteFileFromBranch(String name) {
        currentBranch.deleteFile(name);
    }

    /**
     * Create and add the new branch to the current brunch
     * @param name of new branch
     */
    public void addSubBranch(String name) {
        currentBranch.addSubBranch(name);
    }

    /**
     * Return the branch by name
     * @param name of desired branch
     * @return Branch you are looking for or null
     */
    public Branch getSubBranch(String name) {
        return currentBranch.getBranch(name);
    }

    /**
     * Set up the specified by name branch as actual
     * @param name of brunch you are going to set up as current
     */
    public void setCurrentBranch(String name) {
        Branch temp = currentBranch;
        Branch desired = getSubBranch(name);
        if(desired != null) {
            currentBranch = desired;
        } else {
            currentBranch = currentBranch.getParentBranch();
            if(currentBranch != null) {
                setCurrentBranch(currentBranch.getName());
            } else {
                currentBranch = temp;
                System.out.println("Branch with name: " + name + " has been not found!");
            }
        }
    }

    /**
     * Remove the branch by name
     * @param name of branch you are going to remove
     */
    public void deleteSubBranch(String name) {
        currentBranch.deleteSubBranch(name);
    }

    /**
     * Create and store the commit object
     * @param commitName of commit
     */
    public void commit(String commitName) {
        long id = idCount;
        idCount++;
        currentCommit = new Commit(id, userName, commitName, currentBranch.clone(), currentCommit);

    }

    /**
     * Allow the access to current commit value
     * @return Commit current commit
     */
    public Commit getCurrentCommit() {
        return currentCommit;
    }

    /**
     * Read the list of commits and return the array of their names
     * @return String[] of the commit`s names
     */
    public List<String> readListOfCommits() {
        List<String> result = new ArrayList<>();
        Iterator it = this.iterator();
        while(it.hasNext()) {
            Commit c = (Commit)it.next();
            result.add(c.getCommitName());
        }
        return result;
    }

    /**
     * Set up the specified by name commit as an actual
     * @param name of desired commit
     */
    public void setCommitAsCurrent(String name) {
        Iterator it = this.iterator();
        Commit c;
        while(it.hasNext()) {
            c = (Commit)it.next();
            if(c.getCommitName().equals(name)) {
                currentCommit = c;
                return;
            }
        }
        System.out.println("Commit with name: " + name + " has been not found!");
    }

    /**
     * Remove the commit by name
     * @param name you are going to remove
     */
    public void deleteCommit(String name) {
        Commit desired;
        Commit prev = currentCommit;
        Iterator it = this.iterator();
        while (it.hasNext()) {
            desired = (Commit)it.next();
            if(!desired.getCommitName().equals(name)) {
                prev = desired;
            } else {
                if(prev.equals(desired)){
                    currentCommit = desired.getPreviousCommit();
                    return;
                } else if(desired.getPreviousCommit() == null){
                    prev.setPreviousCommit(null);
                    return;
                } else {
                    prev.setPreviousCommit((Commit)it.next());
                    return;
                }
            }
        }
        System.out.println("Commit with name: " + name + " has been not found!");
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Commit temp = currentCommit;
            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public Commit next() {
                Commit result = temp;
                temp = temp.previousCommit;
                return result;
            }
        };
    }
}
