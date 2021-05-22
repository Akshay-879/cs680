package edu.umb.cs680.hw10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class AfpsFileSearchVisitorTest {

    static LocalDateTime localTime = LocalDateTime.of(2021, 05, 21, 0, 0);

    private String[] dirToStringArray(ApfsFile d) {
        Optional<ApfsDirectory> optDirectory = Optional.ofNullable(d.getParent());
        String[] dirInfo = {d.getName(), Integer.toString(d.getSize()),d.getOwnerName(),
                d.getCreationTime().toString(),d.getLastModified().toString(),d.getParent().getName()
        };
        return dirInfo;
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
    public void verifyFileA() {
        ApfsFileSearchVisitor apfsvisior = new ApfsFileSearchVisitor("a");
        APFS ApfsFileSystem = APFS.getAPFSFileSystem();
        ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
        String[] expected = { "a", "430", "Akshay", localTime.toString(), localTime.toString(), "applications" };
        apfsvisior.setFileName("a");
        root.accept(apfsvisior);
        ApfsFile actual = apfsvisior.getFile();
        assertArrayEquals(expected,dirToStringArray(actual));
    }


}