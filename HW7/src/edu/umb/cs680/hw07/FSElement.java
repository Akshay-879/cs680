package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public abstract class FSElement {
    private String Name;
    private int Size;
    private LocalDateTime CreationTime;
    private Directory Parent;

    public FSElement(String name, int size, LocalDateTime creationTime, Directory parent) {
        Name = name;
        Size = size;
        CreationTime = creationTime;
        Parent = parent;
    }

    public abstract boolean isDirectory();

    public String getName() {
        return Name;
    }

    public int getSize() {
        return Size;
    }

    public LocalDateTime getCreationTime() {
        return CreationTime;
    }

    public Directory getParent() {
        return Parent;
    }
}
