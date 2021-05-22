package edu.umb.cs680.hw09;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsElement{

    private String OwnerName;
    private LocalDateTime lastModified;
    private LinkedList<ApfsElement> child;

    public ApfsDirectory(String name, int size, String OwnerName ,LocalDateTime creationTime,LocalDateTime lastModified,ApfsDirectory parent) {
        super(name, size, OwnerName, creationTime,lastModified,parent );
        this.OwnerName = OwnerName;
        this.lastModified = lastModified;
        if (parent != null)
            parent.appendChild(this);
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public LinkedList<ApfsElement> getChild() {
        if(this.child == null) {
            this.child = new LinkedList<ApfsElement>();
        }
        return child;
    }

    public int getTotalSize() {
        int Size = 0;
        for (ApfsElement e : getChild()) {
            if (e instanceof ApfsDirectory)
                Size += ((ApfsDirectory) e).getTotalSize();
            else
                Size += e.getSize();
        }
        return Size;
    }

    public LinkedList<ApfsLink> getLinks() {
        LinkedList<ApfsLink> listoflink = new LinkedList<ApfsLink>();
        for(FSElement element : getChild()) {
            if(element instanceof ApfsLink)
                listoflink.add((ApfsLink) element);
        }
        return listoflink;
    }

    public LinkedList<ApfsDirectory> getSubDirectories() {
        LinkedList<ApfsDirectory> listdir = new LinkedList<ApfsDirectory>();
        for(FSElement element : getChild()) {
            if(element instanceof ApfsDirectory)
                listdir.add((ApfsDirectory) element);
        }
        return listdir;
    }

    public void appendChild(ApfsElement child) {
        if(this.child == null) {
            this.child = new LinkedList<ApfsElement>();
        }
        this.child.add(child);
    }

    public int countChildren() {
        return getChild().size() - getLinks().size();
    }

    @Override
    public boolean isDirectory(){
        return true;
    }

}
