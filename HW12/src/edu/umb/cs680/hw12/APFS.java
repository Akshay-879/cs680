package edu.umb.cs680.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class APFS extends FileSystem {

    private static APFS fs = null;

    private APFS() {
    }

    public static APFS getFileSystem() {
        if (fs == null) {
            fs = new APFS();
            fs.initFileSystem("Root", 1800);
        }
        return fs;
    }

    public LinkedList<ApfsElement> getRootDirs(ApfsElement d) {
        LinkedList<ApfsElement> child = new LinkedList<>();
        while (d.getParent() != null) {
            child.add(d.getParent());
            d = d.getParent();
        }
        return child;
    }

    @Override
    protected FSElement createDefaultRoot() {
        return new ApfsDirectory("Root", 0, "author",LocalDateTime.of(2019, 2, 2, 12, 0), null,null);
    }

    public void setRootDir(ApfsDirectory root) {
        super.setRoot(root);
    }

    public ApfsDirectory getRootDir() {
        return (ApfsDirectory)this.getRoot();
    }
}