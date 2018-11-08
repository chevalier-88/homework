import java.util.HashMap;
import java.util.Map;

public class Tree {
    private Map<String, Tree> _subtrees;
    private Map<String, Blob> _blobs;

    public Tree(){
        _subtrees = new HashMap<>();
        _blobs = new HashMap<>();
    }

    public Tree(Map<String, Tree> subtrees, Map<String, Blob> files){
        _subtrees = subtrees;
        _blobs = files;
    }


    public Map<String, Tree> get_subtrees() {
        return _subtrees;
    }

    public void set_subtrees(Map<String, Tree> _subtrees) {
        this._subtrees = _subtrees;
    }

    public Map<String, Blob> get_blobs() {
        return _blobs;
    }

    public void set_blobs(Map<String, Blob> _blobs) {
        this._blobs = _blobs;
    }

    @Override
    public String toString() {
        return "Directories: " + _subtrees.keySet().toString()
                + "\nFiles: " + _blobs.keySet().toString();
    }

    public boolean addBlob(String name, Blob blob){
        if(_blobs.containsKey(name)){
            return false;
        }

        _blobs.put(name, blob);
        return true;
    }

    public boolean addSubtree(String name, Tree subtree){
        if(_subtrees.containsKey(name)){
            return false;
        }

        _subtrees.put(name, subtree);
        return true;
    }

    public boolean removeBlob(String name){
        if(!_blobs.containsKey(name)){
            return false;
        }

        _blobs.remove(name);
        return true;
    }

    public boolean removeSubtree(String name){
        if(!_subtrees.containsKey(name)){
            return false;
        }

        _subtrees.remove(name);
        return true;
    }

    public boolean containsBlob(String name){
        return _blobs.containsKey(name);
    }

    public boolean containsSubtree(String name){
        return _subtrees.containsKey(name);
    }

    public Blob getBlob(String name){
        return _blobs.get(name);
    }

    public Tree getSubtree(String name){
        return _subtrees.get(name);
    }
}
