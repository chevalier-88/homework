import java.util.Arrays;
import java.util.Objects;

public class Blob {

    private String name;
    private byte[] data;

    public Blob(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || (getClass() != obj.getClass())) return false;
        Blob blob = (Blob) obj;
        return Objects.equals(name, blob.name) &&
                Arrays.equals(data, blob.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name) + 31 * Arrays.hashCode(data);
    }


}
