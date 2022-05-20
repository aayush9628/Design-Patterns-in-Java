package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement{
    public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    @Override
    public boolean isDirectory() {
        return super.isDirectory();
    }
}
