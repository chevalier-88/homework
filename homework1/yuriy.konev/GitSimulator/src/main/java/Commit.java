import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Commit {
    private final String message, author;
    private final LocalDateTime date;
    private Tree tree;
    private final Commit previous;

    public Commit(String message, String author, Tree tree, Commit previous) {
        this.message = message;
        this.author = author;
        this.date = LocalDateTime.now();
        this.previous = previous;

        this.tree = cloneTree(tree);
        this.previous.getTree().setIndexLabel(previous.getTree(), false);
        this.tree.setIndexLabel(this.tree, true);
        this.tree = sortTrees(previous.getTree(), this.tree, new Tree(this.tree.getName()));
    }

    public Commit() {
        this.message = null;
        this.author = null;
        this.tree = new Tree("");
        this.date = null;
        this.previous = null;
    }

    private Tree cloneTree(Tree tree) {
        Tree resultTree;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(tree);
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(baos.toByteArray())));
            resultTree = (Tree) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            resultTree = new Tree("");
        }
        return resultTree;
    }

    private Tree sortTrees(Tree oldTree, Tree newTree, Tree resultTree) {

        resultTree.setChanged(!oldTree.equals(newTree));

        for (int j = 0; j < newTree.getBlobs().size(); j++) {
            Blob newBlob = newTree.getBlobs().get(j);
            if (oldTree.getBlobs().size() > j) {
                Blob oldBlob = oldTree.getBlobs().get(j);
                resultTree.add(oldBlob.equals(newBlob) ? oldBlob : newBlob);
            } else
                resultTree.add(newBlob);
        }

        if (oldTree.getTrees().isEmpty() && newTree.getTrees().isEmpty())
            return oldTree.equals(newTree) ? oldTree : newTree;

        for (int i = 0, size = newTree.getTrees().size(); i < size; i++) {
            if (oldTree.getTrees().size() > i) {
                resultTree.add(
                        sortTrees(
                                oldTree.getTrees().get(i),
                                newTree.getTrees().get(i),
                                new Tree(
                                        oldTree.getTrees().get(i).equals(newTree.getTrees().get(i))
                                                ? oldTree.getTrees().get(i).getName()
                                                : newTree.getTrees().get(i).getName()
                                )
                        )
                );

            } else resultTree.add(newTree.getTrees().get(i));


        }
        return resultTree;
    }

    public Tree getTree() {
        return tree;
    }

    @Override
    public String toString() {
        return "Commit{" +
                "message='" + message + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")) +
                "\n------------\n" + tree.showTree();
    }
}
