package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class FileSystemTest {

    LocalDateTime localDateTime = LocalDateTime.now();

    @Test
    void testSameFileSystem() {
        FileSystem f1 = FileSystem.getFileSystem();
        FileSystem f2 = FileSystem.getFileSystem();
        assertSame(f1, f2);
    }

//    @Test
//    void testRootDirectory() {
//        Directory root = new Directory("root", 0, localDateTime, null);
//        String[] expected = {"root", "0", localDateTime.toString(), null};
//        FileSystem.getFileSystem().addRootDir(root);
//        Directory actual = FileSystem.getFileSystem().getRootDirs().get(0);
//        assertArrayEquals(expected, stringarrayforthedirectory(actual));
//    }

}