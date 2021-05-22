package edu.umb.cs680.hw12;

public class ApfsCountingVisitor implements ApfsFSVisitor {

    private int Directory_Num = 0;
    private int File_Num = 0;
    private int Link_Num = 0;

    @Override
    public void visit(ApfsLink link) {
        Link_Num++;
    }

    @Override
    public void visit(ApfsDirectory dir) {
        Directory_Num++;
    }

    @Override
    public void visit(ApfsFile file) {
        File_Num++;
    }

    public int getDirectory_Num() {
        return Directory_Num;
    }

    public int getFile_Num() {
        return File_Num;
    }

    public int getLink_Num() {
        return Link_Num;
    }

}
