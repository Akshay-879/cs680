package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class Link extends FSElement{

    public FSElement getTarget() {
        return target;

    }
    @Override
    public boolean isDirectory() {
        return false;
    }
    public Link(String name, int size, LocalDateTime creationTime, FSElement target, Directory parent) {
        super(name, size, creationTime,parent);
        this.target = target;
        parent.appendChild(this);
    }
    private FSElement target;

}
