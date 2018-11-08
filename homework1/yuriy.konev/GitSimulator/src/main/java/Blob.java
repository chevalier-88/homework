import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Blob implements Serializable {
    private String name;
    private byte[] data;
    private boolean changed;

    public Blob(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blob blob = (Blob) o;
        return Objects.equals(name, blob.name) &&
                Arrays.equals(data, blob.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, data);
    }

    @Override
    public String toString() {
        return name + (isChanged() ? " *" : "");
    }
}
