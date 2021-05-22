package edu.umb.cs680.hw12;

import java.util.ArrayList;

public class ApfsFileCrawlingVisitor<T> implements ApfsFSVisitor<T> {

    ArrayList<ApfsFile> files = new ArrayList<>();

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
        files.add(file);
    }

    public ArrayList getFiles() {
        return files;
    }
}
