import java.util.Objects;

/**
 * @author Andrii Hubarenko
 * Blob is a parameterized class for object storing inside the tree;
 * @param <E>
 */
class Blob<E>{
    private String name;
    private E content;

    Blob(String name, E content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public E getContent() {
        return content;
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Blob))return false;
        Blob otherBlob = (Blob)other;
        return otherBlob.getName().equals(this.name)
                && otherBlob.getContent().equals(this.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, content);
    }
}
