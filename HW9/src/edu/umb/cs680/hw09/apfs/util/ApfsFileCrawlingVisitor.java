package edu.umb.cs680.hw09.apfs.util;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;

import java.util.LinkedList;

public class ApfsFileCrawlingVisitor implements ApfsFSVisitor{
    private final LinkedList<ApfsFile> files = new LinkedList<>();
    public ApfsFileCrawlingVisitor(){
    }

    @Override
    public void visit(ApfsDirectory dir) {}

    @Override
    public void visit(ApfsFile file) {
        this.files.add(file);
    }

    @Override
    public void visit(ApfsLink link) {}

    public LinkedList<ApfsFile> getFiles() {
        return this.files;
    }
}
