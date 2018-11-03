import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BlobTest {
    @Test
    public void setData() throws Exception {
        Blob blob = new Blob();
        byte[] data = {(byte)1, (byte)2, (byte) 3};
        blob.setData(data);
        System.out.println(Arrays.toString(blob.getData()));
    }

    @Test
    public void getData() throws Exception {
        byte[] data = {(byte)1, (byte)2, (byte) 3};
        Blob blob = new Blob(data);
        System.out.println(Arrays.toString(blob.getData()));
    }

}