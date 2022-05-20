package edu.umb.cs680.hw09.apfs;

import edu.umb.cs680.hw09.apfs.util.ApfsCountingVisitor;
import edu.umb.cs680.hw09.apfs.util.ApfsFSVisitor;
import edu.umb.cs680.hw09.fs.FSElement;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsElement {

    private LinkedList<ApfsElement> children;

    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        this.children = new LinkedList<>();
    }

    public LinkedList<ApfsElement> getChildren(){
        return this.children;
    }

    public void appendChild(ApfsElement child){
        this.children.add(child);
    }

    public int countChildren(){
        return this.children.size();
    }

    public LinkedList<ApfsDirectory> getSubDirectory(){
        LinkedList<ApfsDirectory> dirs = new LinkedList<>();
        for(ApfsElement element : this.children){
            if(element.isDirectory()){
                dirs.add((ApfsDirectory) element);
            }
        }
        return dirs;
    }

    public LinkedList<ApfsFile> getFiles(){
        LinkedList<ApfsFile> files = new LinkedList<>();
        for(ApfsElement element : this.children){
            if(!element.isDirectory()){
                files.add((ApfsFile) element);
            }
        }
        return files;
    }

    public int getTotalSize(){
        if(this.getChildren() == null){
            return 0;
        }
        LinkedList<ApfsDirectory> subDirectories = this.getSubDirectory();
        int count = this.getChildren().size();
        for(ApfsDirectory dir : subDirectories){
            count += dir.getTotalSize();
        }
        return count;
    }
    @Override
    public boolean isDirectory(){
        return true;
    }

    @Override
    public void accept(ApfsFSVisitor apfsFSVisitor) {
        apfsFSVisitor.visit(this);
        for(ApfsElement element : this.getChildren()){
            element.accept(apfsFSVisitor);
        }
    }
}
