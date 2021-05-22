package edu.umb.cs680.hw12;

import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement {

    private ApfsElement target;

    public ApfsLink(String name, int size, String ownerName, LocalDateTime creationTime, LocalDateTime lastModified, ApfsDirectory parent, ApfsElement target) {
        super(name, size, ownerName,creationTime , lastModified, parent);
        this.target = target;
        parent.appendChild(this);
    }

    public boolean isDirectory() {
        return false;
    }

    @Override
    public void accept(ApfsFSVisitor v) {
        v.visit(this);
    }



    public ApfsElement getTarget() {
        return target;
    }
}
