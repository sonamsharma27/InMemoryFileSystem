public class ResolvedParent {
    private final Directory parent;
    private final String fileName;

    public  ResolvedParent(Directory parent, String fileName){
        this.parent=parent;
        this.fileName=fileName;
    }

    public Directory getParent(){
        return  parent;
    }

    public String getFileName(){
        return  fileName;
    }


}
