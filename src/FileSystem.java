public class FileSystem {
    private final Directory root;
    private Directory currentDirectory;
    private final PathResolver pathResolver;

    public FileSystem () {
        this.root = new Directory("");;
        currentDirectory= root;
        pathResolver = new PathResolver();
    }

    void mkdir(String path){
        try{
            ResolvedParent resolvedParent = pathResolver.resolveParent(path,root,currentDirectory);
            Directory parent = resolvedParent.getParent();
            String fileName = resolvedParent.getFileName();

            Directory dir = new Directory(fileName);
            parent.addChild(dir);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    void cd(String path){
        try {
            FileSystemNode node = pathResolver.resolvePath(path, root, currentDirectory);
            if (!(node instanceof Directory dir)) {
                throw new IllegalArgumentException("Invalid path: " + node.getName() + "is not a directory");
            }
            currentDirectory = dir;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    void touch(String path){
        try{
            ResolvedParent resolvedParent = pathResolver.resolveParent(path,root,currentDirectory);
            Directory parent = resolvedParent.getParent();
            String fileName = resolvedParent.getFileName();

            File file = new File(fileName);
            parent.addChild(file);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    void ls(){
        ls("./");
    }
    void ls(String path){
        try{
            FileSystemNode node = pathResolver.resolvePath(path,root,currentDirectory);
            if(node instanceof Directory dir){
                for(String child : dir.getChildren().keySet()){
                    System.out.println(child);
                }
            } else {
                System.out.println(node.getName());
            }
            System.out.println("-------------------------");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
