import java.util.Map;

public class PathResolver {

    public PathResolver(){
    }

    public FileSystemNode resolvePath(String path, Directory root, Directory currentDirectory){
        if(path==null || path.isEmpty()){
            throw new IllegalArgumentException("Path cannot be empty");
        }
        FileSystemNode current = currentDirectory;

        if(path.startsWith("/")){
            current=root;
        }
        String[] components = path.split("/");
        for(String comp: components){
            if(comp.isEmpty() || comp.equals(".")){
                continue;
            }
            if(comp.equals("..")){
                if(current==root){
                    continue;
                }
                current=current.getParent();
                continue;
            }
            if(!(current instanceof Directory directory)){
                throw new IllegalArgumentException("Invalid path: "+ current + " is not a directory");
            }
            FileSystemNode child= directory.getChild(comp);
           if(child==null) {
               throw  new IllegalArgumentException("Invalid path: "+ comp + " deosn not exist");
           }
           current=child;
        }
        return current;
    }

    public ResolvedParent resolveParent(String path, Directory root, Directory currentDirectory){
        if(path==null || path.isEmpty()){
            throw new IllegalArgumentException("Invalid path");
        }
        int lastIndex = path.lastIndexOf("/");
        if(lastIndex==-1){
            return  new ResolvedParent(currentDirectory,path);
        }
        String fileName = path.substring(lastIndex+1);
        if(fileName.endsWith("/")){
            fileName = fileName.substring(0,(int)fileName.length());
        }
        String pathToResolve = path.substring(0,lastIndex+1);
        FileSystemNode parent;
        if(pathToResolve.isEmpty()){
                    parent = currentDirectory;
        } else  if(pathToResolve.equals("/")){
            parent=root;
        } else {
            parent = resolvePath(pathToResolve,root,currentDirectory);
        }
        if(!(parent instanceof  Directory dir)){
            throw new IllegalArgumentException("Invalid path");
        }
        return  new ResolvedParent(dir,fileName);

    }
}
