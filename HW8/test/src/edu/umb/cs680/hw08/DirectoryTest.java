package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectoryTest {

    static LocalDateTime localTime = LocalDateTime.now();

    @BeforeAll
    public static void setupupoffilestructure() {
        Directory root = new Directory("root",100000,localTime,null);
        Directory applications = new Directory("applications", 0,localTime, root);
        Directory home = new Directory("home", 0,localTime,root);
        Directory code = new Directory("code", 0, localTime,root);
        File a = new File("a", 430, localTime,applications);
        File b = new File("b", 579,localTime,applications);
        File c = new File("c", 340,localTime,home);
        File d = new File( "d", 280,localTime,home);
        File e = new File("e", 680,localTime, code);
        File f = new File("f", 356,localTime,code);

        FileSystem.getFileSystem().addRootDir(root);
    }

    private String[] dirToStringArray(Directory d) {
        Optional<Directory> optionalDirectory = Optional.ofNullable(d.getParent());
        String[] directorystring = { Boolean.toString(d.isDirectory()), d.getName(),
                Integer.toString(d.getSize()), d.getCreationTime().toString(),
                optionalDirectory.isPresent()?d.getParent().getName():null,
                Integer.toString(d.getTotalSize()),
                Integer.toString(d.countChildren())};
        return directorystring;
    }

    @Test
    public void verifySizeofFile(){
        FileSystem f =  FileSystem.getFileSystem();
        int actual  = f.getRootDirs().get(0).getTotalSize();
        int expected = 2665;
        assertEquals(expected, actual);

    }

    @Test
    public void verifynumberofChildren(){
        FileSystem f =  FileSystem.getFileSystem();
        int expected = f.getRootDirs().get(0).countChildren();
        int actual  = 3;
        assertEquals(expected, actual);

    }



}