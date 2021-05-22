package edu.umb.cs680.hw12;

import java.time.LocalDateTime;

public abstract class FSElement {
    private String name;
    private int size;
    private LocalDateTime creationTime;
    private ApfsDirectory parent;

    public FSElement(String name, int size, LocalDateTime creationTime, ApfsDirectory parent) {
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public ApfsDirectory getParent() {
        return parent;
    }

    public abstract boolean isDirectory();
}
