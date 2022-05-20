package edu.umb.cs680.hw08;

import java.util.LinkedList;

public abstract class FileSystem {
    protected String name;
    protected int capacity;
    protected int id;
    private LinkedList<FSElement> rootDirs;

    public FSElement init(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.rootDirs = new LinkedList<>();
        FSElement root = this.createDefaultRoot();
        if(root.isDirectory() && capacity >= root.getSize()){
            setRoot(root);
            this.id = root.hashCode();
            return root;
        } else{
            return null;
        }
    }

    protected abstract FSElement createDefaultRoot();
    protected void setRoot(FSElement root){
        rootDirs.add(root);
    }
    protected int getCapacity(){
        return this.capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<FSElement> getRootDirs() {
        return rootDirs;
    }

    public void setRootDirs(LinkedList<FSElement> rootDirs) {
        this.rootDirs = rootDirs;
    }
}
