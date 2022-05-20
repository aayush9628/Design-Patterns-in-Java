package edu.umb.cs680.hw12;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsElement{

    private LinkedList<ApfsElement> children;

    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        this.children = new LinkedList<>();
    }

    public LinkedList<ApfsElement> getChildren(Comparator<ApfsElement> apfsElementComparator){
        if(apfsElementComparator == null){
            Collections.sort(this.children, new AlphabeticalComparator());
            return this.children;
        }
        Collections.sort(this.children, apfsElementComparator);
        return this.children;
    }

    public void appendChild(ApfsElement child){
        this.children.add(child);
    }

    public int countChildren(){
        return this.children.size();
    }

    public LinkedList<ApfsDirectory> getSubDirectory(Comparator<ApfsElement> apfsElementComparator){
        LinkedList<ApfsDirectory> dirs = new LinkedList<>();
        for(FSElement element : this.children){
            if(element.isDirectory()){
                dirs.add((ApfsDirectory) element);
            }
        }
        if(apfsElementComparator == null){
            Collections.sort(dirs, new AlphabeticalComparator());
            return dirs;
        }
        Collections.sort(dirs, apfsElementComparator);
        return dirs;
    }

    public LinkedList<ApfsFile> getFiles(Comparator<ApfsElement> apfsElementComparator){
        LinkedList<ApfsFile> files = new LinkedList<>();
        for(FSElement element : this.children){
            if(!element.isDirectory()){
                files.add((ApfsFile) element);
            }
        }
        if(apfsElementComparator == null){
            Collections.sort(files, new AlphabeticalComparator());
            return files;
        }
        Collections.sort(files, apfsElementComparator);
        return files;
    }

    public int getTotalSize(){
        if(this.children == null){
            return 0;
        }
        LinkedList<ApfsDirectory> subDirectories = this.getSubDirectory(null);
        int count = this.children.size();
        for(ApfsDirectory dir : subDirectories){
            count += dir.getTotalSize();
        }
        return count;
    }
    @Override
    public boolean isDirectory(){
        return true;
    }
}
