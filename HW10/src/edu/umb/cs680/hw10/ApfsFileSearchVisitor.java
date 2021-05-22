package edu.umb.cs680.hw10;

public class ApfsFileSearchVisitor implements ApfsFSVisitor{

    private String Name;
    private ApfsFile file;

    public ApfsFileSearchVisitor(String name) {
        Name = name;
    }

    public void setFileName(String Name) {
        this.Name = Name;
    }

    public ApfsFile getFile() {
        return file;
    }

    @Override
    public void visit(ApfsLink link) {
        return;
    }

    @Override
    public void visit(ApfsDirectory dir) {
        return;
    }

    @Override
    public void visit(ApfsFile file) {
        if(Name.equals(file.getName()))
            this.file = file;
    }

}
