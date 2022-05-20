package edu.umb.cs680.hw09.apfs.util;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;

public class ApfsCountingVisitor implements ApfsFSVisitor{
    private int dirNum;
    private int fileNum;
    private int linkNum;

    @Override
    public void visit(ApfsDirectory dir) {
        this.dirNum++;
    }

    @Override
    public void visit(ApfsFile file) {
        this.fileNum++;
    }

    @Override
    public void visit(ApfsLink link) {
        this.linkNum++;
    }

    public int getDirNum() {
        return this.dirNum;
    }

    public int getFileNum() {
        return this.fileNum;
    }

    public int getLinkNum() {
        return this.linkNum;
    }
}
