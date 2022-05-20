package edu.umb.cs680.hw09.apfs;

import edu.umb.cs680.hw09.apfs.util.ApfsFSVisitor;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement{
    public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public void accept(ApfsFSVisitor apfsFSVisitor) {
        apfsFSVisitor.visit(this);
    }
}
