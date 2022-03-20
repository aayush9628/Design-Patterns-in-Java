package edu.umb.cs680.hw04;

import java.util.LinkedList;
import java.util.Queue;

public class FIFOFileCache extends FIleCache{
    Queue<String> fifo = new LinkedList<>();
    private int size = 4;
    @Override
    public boolean isCacheFull() {
        return cache.size() == size;
    }

    @Override
    public boolean isCached(String targetFile) {
        return cache.get(targetFile) != null;
    }

    @Override
    public void cacheFile(String targetFile) {
        cache.put(targetFile, "Contents of "+targetFile);
        fifo.add(targetFile);
    }

    @Override
    public void replace(String targetFile) {
        String fileToBeRemoved = fifo.remove();
        cache.remove(fileToBeRemoved);
        cache.put(targetFile, "Contents of "+targetFile);
        fifo.add(targetFile);
    }

    public static void main(String[] args) {
        FIFOFileCache cacheMechanism = new FIFOFileCache();
        String[] targetFiles = new String[]{"Target1", "Target2", "Target3", "Target1", "Target4", "Target2", "Target5"};
        for(String files: targetFiles){
            cacheMechanism.fetchTarget(files);
            System.out.println(cacheMechanism.cache);
        }
    }
}
