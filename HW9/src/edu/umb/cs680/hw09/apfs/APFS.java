package edu.umb.cs680.hw09.apfs;

import edu.umb.cs680.hw09.fs.*;

import java.time.LocalDateTime;

public class APFS extends FileSystem {
    private FSElement defaultRoot;
    public APFS(){}
    @Override
    protected FSElement createDefaultRoot() {
        if(defaultRoot == null){
            defaultRoot = new ApfsDirectory(null, "root", 0, LocalDateTime.now());
        }
        return defaultRoot;
    }
    public ApfsDirectory getRootDir(){
        return (ApfsDirectory) this.defaultRoot;
    }
}
