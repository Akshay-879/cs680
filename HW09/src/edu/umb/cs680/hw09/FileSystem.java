package edu.umb.cs680.hw09;

public abstract class FileSystem {
    private int id;
    private int capacity;
    private String fsName;
    private FSElement rootDir;


    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getFsName() {
        return fsName;
    }

    public FSElement getRootDir() {
        return rootDir;
    }

    public void setRootDir(FSElement rootDir) {
        this.rootDir = rootDir;
    }

    public FSElement initFileSystem(String name, int capacity) {
        this.fsName = name;
        this.capacity = capacity;
        FSElement root = createDefaultRoot();
        if (root.isDirectory() && capacity >= root.getSize()) {
            setRootDir(root);
            this.id = root.hashCode();
            return root;
        } else
        {
            return null;
        }
    }

    protected abstract FSElement createDefaultRoot();

}
