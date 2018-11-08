/**
 * @author Andrii Hubarenko
 * Class Branch uses to store the Blob files and another branches.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

class Branch {
    private Branch parentBranch;
    private String name;
    private List<Blob> listOfFiles;
    private List<Branch> listOfBranches;

    Branch(String name) {
        this.name = name;
        listOfFiles = new ArrayList<>();
        listOfBranches = new ArrayList<>();
    }

    public Branch getParentBranch() {
        return parentBranch;
    }

    public void setParentBranch(Branch parentBranch) {
        this.parentBranch = parentBranch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blob> getListOfFiles() {
        return listOfFiles;
    }

    public void setListOfFiles(List<Blob> listOfFiles) {
        this.listOfFiles = listOfFiles;
    }

    public List<Branch> getListOfBranches() {
        return listOfBranches;
    }

    public void setListOfBranches(List<Branch> listOfBranches) {
        this.listOfBranches = listOfBranches;
    }

    public void addFile(Blob blob) {
        listOfFiles.add(blob);
    }

    public Blob getFile(String name) {
        for(Blob f: listOfFiles) {
            if(f.getName().equals(name)) {
                return f;
            }
        }
        return null;
    }

    public void deleteFile(String name) {
        Blob file = getFile(name);
        if(file != null) {
            listOfFiles.remove(file);
        } else {
            System.out.println("File not found!");
        }
    }

    public Branch addSubBranch(String name) {
        Branch subBranch = new Branch(name);
        subBranch.setParentBranch(this);
        listOfBranches.add(subBranch);
        return subBranch;
    }

    public Branch getBranch(String name) {
        for(Branch b: listOfBranches) {
            if(b.getName().equals(name)) {
                return b;
            }
        }
        return null;
    }

    public void deleteSubBranch(String name) {
        Branch b = getBranch(name);
        if(b != null) {
            listOfBranches.remove(b);
        } else {
            System.out.println("Branch not found!");
        }
    }

    @Override
    public Branch clone() {
        Branch clone = new Branch(this.name);

        clone.setParentBranch(this.parentBranch);
        clone.setListOfBranches(new ArrayList<>(listOfBranches));
        clone.setListOfFiles(new ArrayList<>(listOfFiles));
        clone.setName(this.name);

        return clone;
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Branch))return false;
        Branch otherBranch = (Branch)other;
        return otherBranch.getName().equals(this.name)
                && otherBranch.getParentBranch().equals(this.parentBranch)
                && otherBranch.getListOfBranches().equals(this.listOfBranches)
                && otherBranch.getListOfFiles().equals(this.listOfFiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parentBranch, listOfFiles, listOfBranches);
    }
}
