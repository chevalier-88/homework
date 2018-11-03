public class Blob {
    private byte[] _data;

    public Blob(){
        _data = new byte[0];
    }

    public Blob(byte[] data){
        _data = data;
    }

    public byte[] getData() {
        return _data;
    }

    public void setData(byte[] data) {
        this._data = data;
    }
}
