package edu.umb.cs680.hw08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class LinkTest {

    private String[] fsElementToStringArray(FSElement f) {
        Optional<Directory> optionalDirectory = Optional.ofNullable(f.getParent());
        String[] fsElementInfo = { Boolean.toString(f.isDirectory()), f.getName(),
                Integer.toString(f.getSize()), f.getCreationTime().toString(),
                optionalDirectory.isPresent()?f.getParent().getName():null};
        return fsElementInfo;
    }

    static LocalDateTime localTime = LocalDateTime.now();

    @SuppressWarnings("unused")
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
        Link y = new Link("Image_6-7",0, localTime,b,code);
        FileSystem.getFileSystem().addRootDir(root);
    }

    @Test
    public void verifyTargetHome() {
        FileSystem fileSystem = FileSystem.getFileSystem();
        String[] expected = {"true", "code","0", localTime.toString(), "root"};
        Directory actual = (Directory) fileSystem.getRootDirs().get(0).getSubDirectories().get(2).getLinks().get(0).getParent();
        assertArrayEquals(expected, fsElementToStringArray(actual));
    }

    @Test
    public void verifyTargetEqualityE() {
        FileSystem fileSystem = FileSystem.getFileSystem();
        String[] expected = {"false" , "e", "680", localTime.toString(), "code" };
        File actual = (File) fileSystem.getRootDirs().get(0).getSubDirectories().get(2).getFiles().get(0);
        assertArrayEquals(expected,fsElementToStringArray(actual));
    }

}