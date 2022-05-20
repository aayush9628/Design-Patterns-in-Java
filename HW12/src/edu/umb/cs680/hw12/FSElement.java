package edu.umb.cs680.hw12;

import java.time.LocalDateTime;

public abstract class FSElement {
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    protected ApfsDirectory parent;

    public FSElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime){
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }
    public int getSize(){
        return this.size;
    }

    public abstract boolean isDirectory();
}
