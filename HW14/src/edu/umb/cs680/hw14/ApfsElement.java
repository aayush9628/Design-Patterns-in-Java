package edu.umb.cs680.hw14;

import java.time.LocalDateTime;

public class ApfsElement extends FSElement{

    public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }
}
