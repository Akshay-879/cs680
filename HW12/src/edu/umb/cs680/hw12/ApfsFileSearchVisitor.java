package edu.umb.cs680.hw12;

public class ApfsFileSearchVisitor<T> implements ApfsFSVisitor<T> {

    ApfsFile file;
    @Override
    public void visit(ApfsLink link){}

    @Override
    public void visit(ApfsDirectory dir){}

    @Override
    public void visit(ApfsFile file) {
        this.file = file;
    }

    public boolean search(String fileName) {
        if(fileName.equals(file.getName()))
            return true;
        return false;
    }
}
