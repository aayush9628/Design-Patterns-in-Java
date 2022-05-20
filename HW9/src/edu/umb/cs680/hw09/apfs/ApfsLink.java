package edu.umb.cs680.hw09.apfs;

import edu.umb.cs680.hw09.apfs.util.ApfsFSVisitor;

import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement{
    private ApfsElement target;

    public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, ApfsElement target) {
        super(parent, name, size, creationTime);
        this.target = target;
    }

    public ApfsElement getTarget() {
        return target;
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
