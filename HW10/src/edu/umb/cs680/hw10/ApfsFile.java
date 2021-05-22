package edu.umb.cs680.hw10;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement{

    public ApfsFile(String name, int size, String ownerName ,LocalDateTime creationTime, LocalDateTime lastModified, ApfsDirectory parent) {
        super(name, size,  ownerName,creationTime, lastModified, parent);
        parent.appendChild(this);
    }

    @Override
    public void accept(ApfsFSVisitor visitor) {
        visitor.visit(this);
    }

    public boolean isDirectory() {
        return false;
    }

}
