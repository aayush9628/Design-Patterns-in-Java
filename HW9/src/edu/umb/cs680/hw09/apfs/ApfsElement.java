package edu.umb.cs680.hw09.apfs;

import edu.umb.cs680.hw09.apfs.util.ApfsFSVisitor;
import edu.umb.cs680.hw09.fs.FSElement;

import java.time.LocalDateTime;

public class ApfsElement extends FSElement {

    public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    public void accept(ApfsFSVisitor apfsFSVisitor){}
}
