import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Directory extends FileSystemNode{
    private final Map<String,FileSystemNode> children = new HashMap<>();

    Directory(String name){
        super(name);
    }
    public  void addChild(FileSystemNode node){
        if(children.containsKey(node.getName())){
           throw new IllegalArgumentException("Directory/File already exist: "+node.getName());
        }
        children.put(node.getName(),node);
        node.setParent(this);
    }

    public  void removeChild(String node){
        if(!(children.containsKey(node))){
            throw new IllegalArgumentException("Directory does not exist : " + node);
        }
        children.remove(node);
    }

    public FileSystemNode getChild(String child){
        return children.get(child);
    }

    public Map<String, FileSystemNode> getChildren(){
        return Collections.unmodifiableMap(children);
    }
}
