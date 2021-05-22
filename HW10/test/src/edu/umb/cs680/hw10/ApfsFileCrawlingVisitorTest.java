package edu.umb.cs680.hw10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AfspFileCrawlingVisitorTest {

    static LocalDateTime localTime = LocalDateTime.of(2021, 05, 21, 0, 0);

    private String[] dirToStringArray(ArrayList<ApfsFile> files) {
        String[] filesInDir = new String[files.size()];
        int i = 0;
        for (ApfsFile x : files) {
            filesInDir[i] = x.getName();
            i++;
        }
        return filesInDir;
    }

    @SuppressWarnings("unused")
    @BeforeAll
    public static void setupUpOfFileStructure() {

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
    void checkFilesUnderHome() {
        ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
        APFS ApfsFileSystem = APFS.getAPFSFileSystem();
        ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
        ApfsDirectory home = root.getSubDirectories().get(1);
        home.accept(visitor);
        String[] expected = {"c","d"};
        ArrayList<ApfsFile> actual= visitor.getFiles();
        assertArrayEquals(expected,dirToStringArray(actual));
    }

    @Test
    void test_Files_Code() {
        ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
        APFS ApfsFileSystem = APFS.getAPFSFileSystem();
        ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
        ApfsDirectory pictures = root.getSubDirectories().get(2);
        pictures.accept(visitor);
        String[] expected = {"e","f"};
        ArrayList<ApfsFile> actual= visitor.getFiles();
        assertArrayEquals(expected,dirToStringArray(actual));
    }
}