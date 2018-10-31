package io.github.badgateway12.jee;

import java.util.Arrays;
import java.util.Objects;

public class Blob {
    private final String name;
    private final byte[] data;

    public Blob(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Blob blob = (Blob) other;
        return Objects.equals(name, blob.name) && Arrays.equals(data, blob.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}

