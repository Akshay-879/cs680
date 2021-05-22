package edu.umb.cs680.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;

public abstract class ApfsElement extends FSElement {

    private ApfsFSVisitor v;


    LinkedList<ApfsElement> children = new LinkedList<>();

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


    public void accept(ApfsFSVisitor v) {
        this.v = v;
    }

    private String ownerName;
    private LocalDateTime lastModification;

    public LocalDateTime getLastModification() {
        return lastModification;
    }

    public void setLastModification(LocalDateTime lastModification) {
        this.lastModification = lastModification;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void appendChild(ApfsElement child) {
        children.add(child);
    }

    public int countChildren() {
        LinkedList<ApfsElement> child = new LinkedList<>();
        int count = 0;
        child.addAll(children);
        for(ApfsElement e: child) {
            if(e.isDirectory())
                child.add(e);
            else
                count += 1;
            child.remove(e);
        }
        return count;
    }

    public int getTotalSize() {
        LinkedList<ApfsElement> child = new LinkedList<>();
        int count = 0;
        child.addAll(children);
        while(child.size() != 0) {
            ApfsElement e = child.get(0);
            if(e instanceof ApfsLink && ((ApfsLink)e).getTarget() instanceof ApfsDirectory) {
                child.add(((ApfsLink) e).getTarget());
            }
            else if(e instanceof ApfsDirectory && e.isDirectory())
                child.addAll(((ApfsDirectory) e).getChildren());
            else
                count += e.getSize();
            child.remove(0);
        }
        return count;
    }

    public LinkedList<ApfsElement> getSubDirectories(){
        LinkedList<ApfsElement> child = new LinkedList<>();
        for(ApfsElement e: children) {
            child.add(e);
        }
        return child;
    }

    public LinkedList<ApfsFile> getFiles(){
        LinkedList<ApfsFile> child = new LinkedList<>();
        for(ApfsElement e: children) {
            if(!e.isDirectory())
                child.add((ApfsFile) e);
        }
        return child;
    }

    public abstract boolean isDirectory();

}
