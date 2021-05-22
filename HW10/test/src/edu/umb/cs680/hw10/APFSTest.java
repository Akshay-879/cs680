package edu.umb.cs680.hw10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;


class APFSTest {

    static LocalDateTime localTime = LocalDateTime.of(2021, 05, 21, 0, 0);

    private String[] dirToStringArray(ApfsDirectory d) {
        Optional<ApfsDirectory> optDirectory = Optional.ofNullable(d.getParent());
        String[] dirInfo = {d.getName(), Integer.toString(d.getSize())
        };
        return dirInfo;
    }

    @SuppressWarnings("unused")
    @BeforeAll
    public static void setupupoffilestructure() {
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        FilesystemofApfs.initFileSystem("drive", 3500);
    }


    @Test
    public void testrootmaindirectory() {
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
        String[] expected = {"root","0" };
        String[] actual = dirToStringArray(root);
        assertArrayEquals(expected,actual);
    }
}