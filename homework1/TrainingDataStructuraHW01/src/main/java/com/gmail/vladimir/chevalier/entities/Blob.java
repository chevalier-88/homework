package com.gmail.vladimir.chevalier.entities;

import java.util.Arrays;

public class Blob {

    private byte[] binaryData;

    public Blob(byte[] binaryData) {
        this.binaryData = binaryData;
    }

    public byte[] getBinaryData() {
        return binaryData;
    }

    public void setBinaryData(byte[] binaryData) {
        this.binaryData = binaryData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blob blob = (Blob) o;
        return Arrays.equals(binaryData, blob.binaryData);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(binaryData);
    }

    @Override
    public String toString() {
        return "Blob{" +
                "binaryData=" + Arrays.toString(binaryData) +
                '}';
    }
}
