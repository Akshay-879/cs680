package edu.umb.cs680.hw09;

import java.time.LocalDateTime;

public abstract class ApfsElement extends FSElement {

    private String ownerName;
    private LocalDateTime lastModified;

    public ApfsElement(String name, int size, String ownerName,LocalDateTime creationTime, LocalDateTime lastModified,ApfsDirectory parent) {
        super(name, size, creationTime, parent);
        this.ownerName = ownerName;
        this.lastModified = lastModified;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public abstract boolean isDirectory();

}
