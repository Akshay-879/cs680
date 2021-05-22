package edu.umb.cs680.hw15;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ApfsLinkTest {

    static LocalDateTime localTime = LocalDateTime.of(2021, 05, 14, 0, 0);

    @SuppressWarnings("unused")
    @BeforeAll
    public static void setupupofApfsFilestructure() {


        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        ApfsDirectory root = (ApfsDirectory) FilesystemofApfs.initFileSystem("drive", 3500);
        ApfsDirectory applications = new ApfsDirectory("applications", 0, "Akshay", localTime, localTime, root);
        ApfsDirectory home = new ApfsDirectory("home", 0, "Akshay", localTime, localTime, root);
        ApfsDirectory code = new ApfsDirectory("code", 0, "Akshay", localTime, localTime, root);
        ApfsFile a = new ApfsFile("a", 430, "Akshay", localTime, localTime, applications);
        ApfsFile b = new ApfsFile("b", 579, "Akshay", localTime, localTime, applications);
        ApfsFile c = new ApfsFile("c", 340, "Akshay", localTime, localTime, home);
        ApfsFile d = new ApfsFile("d", 280, "Akshay", localTime, localTime, home);
        ApfsFile e = new ApfsFile("e", 680, "Akshay", localTime, localTime, code);
        ApfsFile f = new ApfsFile("f", 356, "Akshay", localTime, localTime, code);
        ApfsLink x = new ApfsLink("x", 0, "Akshay", localTime, localTime, home, applications);
        ApfsLink y = new ApfsLink("y", 0, "Akshay", localTime, localTime, code, b);

    }

    @Test
    void verifyIsNotDirectory() {
        APFS ApfsFileSystem = APFS.getAPFSFileSystem();
        ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDir();
        assertTrue(root.isDirectory());
        assertFalse(root.getSubDirectories().get(0).getChild().get(0).isDirectory());
        assertFalse(root.getSubDirectories().get(0).getChild().get(0).isDirectory());
    }

    @Test
    void verifyTarget(){
        APFS ApfsFileSystem = APFS.getAPFSFileSystem();
        ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDir();
        String expected = root.getSubDirectories().get(1).getLinks().get(0).getTarget().getName();
        String actual = "applications";
        assertEquals(expected,actual);
    }
}