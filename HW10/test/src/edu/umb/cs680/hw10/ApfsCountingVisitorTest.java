package edu.umb.cs680.hw10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AfpsCountingVisitorTest {

    static LocalDateTime localTime = LocalDateTime.of(2020, 05, 21, 0, 0);

    @SuppressWarnings("unused")
    @BeforeAll
    public static void setupupoffilestructure() {

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
    //count the visitors
    @Test
    void TestCountingVisitorvalue() {
        ApfsCountingVisitor count_visitor = new ApfsCountingVisitor();
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
        root.accept(count_visitor);

        assertEquals(count_visitor.getDirectory_Num(), 4);
        assertEquals(count_visitor.getFile_Num(), 6);
        assertEquals(count_visitor.getLink_Num(), 2);
    }
}