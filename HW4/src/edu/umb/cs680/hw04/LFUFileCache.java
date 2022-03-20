package edu.umb.cs680.hw04;

import java.util.HashMap;
import java.util.Map;

public class LFUFileCache extends FIleCache{
    // to keep track of frequency as integer, lfu map is created
    HashMap<String, Integer> lfu = new HashMap<>();
    private int size = 4;

    @Override
    public boolean isCacheFull() {
        return cache.size() == size;
    }

    @Override
    public boolean isCached(String targetFile) {
        if(cache.get(targetFile) != null){
            lfu.put(targetFile, lfu.get(targetFile) + 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void cacheFile(String targetFile) {
        cache.put(targetFile, "Contents of "+targetFile);
        lfu.put(targetFile, 1);
    }

    @Override
    public void replace(String targetFile) {
        int minVal = Integer.MAX_VALUE;
        String replacingFile = "";
        for(Map.Entry<String, Integer> set: lfu.entrySet()){
            if(set.getValue() < minVal){
                minVal = set.getValue();
                replacingFile = set.getKey();
            }
        }
        cache.remove(replacingFile);
        lfu.remove(replacingFile);
        cache.put(targetFile, "Contents of "+targetFile);
        lfu.put(targetFile, 1);
    }

    public static void main(String[] args) {
        LFUFileCache cacheMechanism = new LFUFileCache();
        String[] targetFiles = new String[]{"Target1", "Target2", "Target3", "Target1", "Target4", "Target2", "Target5"};
        for(String files: targetFiles){
            cacheMechanism.fetchTarget(files);
            System.out.println(cacheMechanism.cache);
            System.out.println(cacheMechanism.lfu);
        }
    }
}
