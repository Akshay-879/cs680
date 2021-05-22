package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class FileSystemTest {

    LocalDateTime localDateTime = LocalDateTime.now();

    private String[] stringarrayforthedirectory(Directory dir){
        String[] stringelement = {dir.getName(), Integer.toString(dir.getSize()), dir.getCreationTime().toString(), null};
        return stringelement;
    }

    @Test
    void verifyFileSystem() {
        FileSystem f1 = FileSystem.getFileSystem();
        FileSystem f2 = FileSystem.getFileSystem();
        assertSame(f1, f2);
    }

    @Test
    void verifyRootDirectory() {
        Directory root = new Directory("root", 0, localDateTime, null);
        String[] expected = {"root", "0", localDateTime.toString(), null};
        FileSystem.getFileSystem().addRootDir(root);
        Directory actual = FileSystem.getFileSystem().getRootDirs().get(0);
        assertArrayEquals(expected, stringarrayforthedirectory(actual));
    }

}