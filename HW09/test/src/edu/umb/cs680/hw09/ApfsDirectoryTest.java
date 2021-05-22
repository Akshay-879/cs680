package edu.umb.cs680.hw09;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ApfsDirectoryTest {

    static LocalDateTime localTime = LocalDateTime.of(2021, 05, 14, 0, 0);

    @SuppressWarnings("unused")
    @BeforeAll
    public static void setupupofApfsFilestructure() {

        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.initFileSystem("drive", 3500);
        ApfsDirectory applications = new ApfsDirectory("applications", 0,"Akshay" ,localTime,localTime, root);
        ApfsDirectory home = new ApfsDirectory("home", 0, "Akshay",localTime, localTime,root);
        ApfsDirectory code = new ApfsDirectory("code", 0,"Akshay" ,localTime, localTime,root);
        ApfsFile a = new ApfsFile("a", 430, "Akshay",localTime, localTime,applications);
        ApfsFile b = new ApfsFile("b", 579, "Akshay",localTime, localTime,applications);
        ApfsFile c = new ApfsFile("c", 340, "Akshay",localTime, localTime,home);
        ApfsFile d = new ApfsFile( "d", 280, "Akshay",localTime, localTime,home);
        ApfsFile e = new ApfsFile("e", 680, "Akshay",localTime, localTime, code);
        ApfsFile f = new ApfsFile("f", 356, "Akshay",localTime, localTime,code);
        ApfsLink x = new ApfsLink( "x", 0, "Akshay",localTime, localTime,home,applications);
        ApfsLink y = new ApfsLink( "y", 0, "Akshay",localTime, localTime,code ,b);
    }

    @Test
    public void testOwnerName(){
        APFS FileSystem = APFS.getAPFSFileSystem();
        ApfsDirectory root = (ApfsDirectory) FileSystem.getRootDir();
        String expected = "Akshay";
        String actual = root.getOwnerName();
        assertEquals(expected,actual);

    }

    @Test
    public void verifyLastModified(){
        APFS FileSystem = APFS.getAPFSFileSystem();
        ApfsDirectory root = (ApfsDirectory) FileSystem.getRootDir();
        LocalDateTime expected =  root.getSubDirectories().get(0).getLastModified();
        LocalDateTime actual = localTime;
        assertEquals(expected,actual);
    }

    @Test
    public void testCountofChildren(){
        APFS FileSystem = APFS.getAPFSFileSystem();
        ApfsDirectory root = (ApfsDirectory) FileSystem.getRootDir();
        int expected = 2;
        int actual = root.getSubDirectories().get(0).countChildren();
        assertEquals(expected,actual);
    }

}