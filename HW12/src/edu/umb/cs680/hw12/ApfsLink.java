package edu.umb.cs680.hw12;

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
        return super.isDirectory();
    }
}
