package edu.umb.cs680.hw07;

import java.util.LinkedList;

public class FileSystem {

    private LinkedList<Directory> directoryroot;
    private static FileSystem instance = null;

    private FileSystem() {
    }

    void addRootDir(Directory Rootdirectory) {
        directoryroot = new LinkedList<Directory>();
        directoryroot.add(Rootdirectory);
    }

    public static FileSystem getFileSystem() {
        if(instance==null)
            instance = new FileSystem ();
        return instance;
    }

    public LinkedList<Directory> getRootDirs() {
        return this.directoryroot;
    }
}
