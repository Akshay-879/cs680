package edu.umb.cs680.hw07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {
    static LocalDateTime localTime = LocalDateTime.now();

    @SuppressWarnings("unused")
    @BeforeAll
    public static void directoryandfilecreation() {
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

    @Test
    public void verifyFileNameA() {
        FileSystem f = FileSystem.getFileSystem();
        String expected =  "a" ;
        String actual = f.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0).getName();
        assertEquals(expected,actual);
    }

    @Test
    public void verifyFileSizeA() {
        FileSystem f = FileSystem.getFileSystem();
        int expected =  430 ;
        int actual = f.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0).getSize();
        assertEquals(expected,actual);
    }

    @Test
    public void verifyFileParentA() {
        FileSystem f = FileSystem.getFileSystem();
        String expected =  "applications" ;
        String actual = f.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0).getParent().getName();
        assertEquals(expected,actual);
    }



}