package edu.umb.cs680.hw09.apfs.util;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;

public interface ApfsFSVisitor {
    void visit(ApfsDirectory dir);
    void visit(ApfsFile file);
    void visit(ApfsLink link);
}
