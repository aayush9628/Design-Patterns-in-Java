package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class FileSystem {
    private LinkedList<Directory> rootDirs;
    private static FileSystem singletonFileSystem = null;

    private FileSystem(){}
    public static FileSystem getFileSystem(){
        if(singletonFileSystem == null){
            singletonFileSystem = new FileSystem();
            singletonFileSystem.rootDirs = new LinkedList<>();
        }
        return singletonFileSystem;
    }
    public LinkedList<Directory> getRootDirs(){
        return this.rootDirs;
    }
    public void appendRootDir(Directory root){
        this.rootDirs.add(root);
    }

    public static void main(String[] args) {
        FileSystem fileSystem = getFileSystem();
        Directory root = new Directory(null, "root", 0, LocalDateTime.now());
        Directory folder1 = new Directory(root, "folder1", 0, LocalDateTime.now());
        root.appendChild(folder1);
        Directory folder2 = new Directory(root, "folder2", 0, LocalDateTime.now());
        root.appendChild(folder2);
        File file1 = new File(root, "file1", 0, LocalDateTime.now());
        root.appendChild(file1);
        File file2 = new File(root, "file2", 0, LocalDateTime.now());
        root.appendChild(file2);
        Directory folder3 = new Directory(folder1, "folder3", 0, LocalDateTime.now());
        folder1.appendChild(folder3);
        File file3 = new File(folder2, "file3", 0, LocalDateTime.now());
        folder2.appendChild(file3);
        fileSystem.appendRootDir(root);
        Directory home = new Directory(null, "home", 0, LocalDateTime.now());
        fileSystem.appendRootDir(home);

        for(Directory dir : fileSystem.getRootDirs()) {
            System.out.println(dir.getName());
        }
        for(FSElement element : fileSystem.getRootDirs().get(0).getChildren()){
            System.out.println(element.getName());
        }
        System.out.println(fileSystem.getRootDirs().get(0).getTotalSize());
    }
}
