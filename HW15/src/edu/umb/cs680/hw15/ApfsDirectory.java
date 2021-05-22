package edu.umb.cs680.hw15;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
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

    public LinkedList<ApfsDirectory> getSubDirectories(Comparator<ApfsElement> comparator) {
        LinkedList<ApfsDirectory> listofdir = getSubDirectories();
        Collections.sort(listofdir, comparator);
        return listofdir;
    }



    public LinkedList<ApfsElement> getChildren() {
        if(this.child == null) {
            this.child = new LinkedList<ApfsElement>();
        }
        Collections.sort(child, (ApfsElement object1, ApfsElement object2) -> object1.getName().compareTo(object2.getName()));
        return child;
    }

    public LinkedList<ApfsElement> getChildren(Comparator<ApfsElement> comparator) {
        Collections.sort(getChildren(), comparator);
        return child;
    }




    public LinkedList<ApfsFile> getFiles() {
        LinkedList<ApfsFile> fileList = new LinkedList<ApfsFile>();
        for(FSElement x : getChildren()) {
            if(x instanceof ApfsFile)
                fileList.add((ApfsFile) x);
        }
        Collections.sort(fileList, (ApfsElement object1, ApfsElement object2) -> object1.getName().compareTo(object2.getName()));
        return fileList;
    }

    public LinkedList<ApfsFile> getFiles(Comparator<ApfsElement> comparator) {
        LinkedList<ApfsFile> fileList = getFiles();
        Collections.sort(fileList, comparator);
        return fileList;
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


    public ApfsFile findFileByName(String fileName) {
        ApfsFile file = null;
        for(ApfsFile f : getFiles()) {
            if(fileName.equals(f.getName()))
                file = f;
        }
        if(file == null) {
            for(ApfsDirectory dir : getSubDirectories()) {
                file = dir.findFileByName(fileName);
                if(file != null)
                    break;
            }
        }
        return file;
    }

    @Override
    public boolean isDirectory(){
        return true;
    }

}
