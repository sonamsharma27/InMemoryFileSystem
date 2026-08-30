public class File extends FileSystemNode{
    private String content;

    public File(String name){
        super(name);
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content=content;
    }
}
