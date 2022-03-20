package edu.umb.cs680.hw04;

import java.util.HashMap;

abstract class FIleCache {
    // cache map for saving file path as key and content as value
    // size of the cache is 4
    protected HashMap<String, String> cache = new HashMap<>();
    public String fetchTarget(String targetFilePath){
        if(isCached(targetFilePath)){
            return cache.get(targetFilePath);
        } else {
            if(!isCacheFull()){
                cacheFile(targetFilePath);
                return cache.get(targetFilePath);
            } else {
                // cache is full so delete according to the subclass logic
                replace(targetFilePath);
                return cache.get(targetFilePath);
            }
        }
    }

    // cache size of 5 is considered full
    public abstract boolean isCacheFull();

    public abstract boolean isCached(String targetFile);

    public abstract void cacheFile(String targetFile);

    public abstract void replace(String targetFile);

    public static void main(String[] args) {

    }
}
