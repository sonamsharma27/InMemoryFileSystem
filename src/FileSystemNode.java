import java.time.Instant;

public abstract class FileSystemNode {
    private final String  name;
    private Directory parent;
    private final Instant createdAt;

    protected FileSystemNode(String name){
        this.name=name;
        this.createdAt = Instant.now();
        this.parent=null;
    }

    public String getName(){
        return  name;
    }

    public void setParent(Directory parent){
        this.parent = parent;
    }

    public Directory getParent() {
        return parent;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getPath(){
        if(name.isEmpty()){
            return "";
        }
        return parent.getPath()+ "/" + name;
    }
}
