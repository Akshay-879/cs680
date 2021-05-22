package edu.umb.cs680.hw15;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class AlphabeticalComparatorTest {

    static LocalDateTime localTime = LocalDateTime.of(2021, 05, 21, 0, 0);
    private String[] dirToStringArray(LinkedList<ApfsElement> fsElements) {
        String[] listoffilename = new String[fsElements.size()];
        int i = 0;
        for(ApfsElement elementforapfs : fsElements) {
            listoffilename[i] = elementforapfs.getName();
            i++;
        }
        return listoffilename;
    }
    @SuppressWarnings("unused")
    @BeforeAll
    public static void setupupoffilestructure() {

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
    void verifySequenceOfChildren() {
        APFS Apfssystemfile = APFS.getAPFSFileSystem();
        ApfsDirectory root = (ApfsDirectory)Apfssystemfile.getRootDir();
        String[] expected = {"applications", "home", "code"};
        assertArrayEquals(expected,dirToStringArray(root.getChildren()));
    }
    @Test
    void verifySequenceOfFiles() {
        APFS Apfssystemfile = APFS.getAPFSFileSystem();
        ApfsDirectory root = (ApfsDirectory)Apfssystemfile.getRootDir();
        String[] expected = {"e", "f"};
        LinkedList<ApfsElement> actual = new LinkedList<ApfsElement>();
        for(ApfsElement apfselement : root.getSubDirectories().get(2).getFiles()){
            actual.add(apfselement);
        }
        assertArrayEquals(expected,dirToStringArray(actual));
    }

}