package edu.umb.cs680.hw10;

import java.time.LocalDateTime;

public class APFS extends FileSystem{

    private APFS() {
    }

    @Override
    protected FSElement createDefaultRoot() {
        LocalDateTime localTime = LocalDateTime.of(2021, 05, 14, 0, 0);
        ApfsDirectory root = new ApfsDirectory("root", 0, "Akshay",localTime,localTime,null );
        return root;
    }

    private static APFS classinst = null;

    public static APFS getAPFSFileSystem() {
        if(classinst==null)
            classinst = new APFS ();
        return classinst;
    }

}