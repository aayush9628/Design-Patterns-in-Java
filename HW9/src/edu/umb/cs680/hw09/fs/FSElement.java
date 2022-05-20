package edu.umb.cs680.hw09.fs;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.util.ApfsFSVisitor;

import java.time.LocalDateTime;

public abstract class FSElement {
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    protected ApfsDirectory parent;
    public ApfsDirectory getParent() {
        return this.parent;
    }
    public String getName(){
        return this.name;
    }

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
