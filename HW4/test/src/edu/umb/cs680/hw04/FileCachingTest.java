package edu.umb.cs680.hw04;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class FileCachingTest {

    private String[] hashmapToStringArray(HashMap<String, String> map){
        String[] array = new String[map.size()];
        int i = 0;
        for(Map.Entry<String, String> set: map.entrySet()){
            array[i++] = set.getKey()+"="+set.getValue();
        }
        return array;
    }

    @Test
    public void FIFOFileCacheTest(){
        FIFOFileCache cacheMechanism = new FIFOFileCache();
        String[] targetFiles = new String[]{"Target1", "Target2", "Target3", "Target1", "Target4", "Target2", "Target5"};
        for(String files: targetFiles){
            cacheMechanism.fetchTarget(files);
        }
        String[] expected = new String[]{"Target2=Contents of Target2", "Target3=Contents of Target3", "Target4=Contents of Target4", "Target5=Contents of Target5"};
        String[] actual = hashmapToStringArray(cacheMechanism.cache);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void LRUFileCacheTest(){
        LFUFileCache cacheMechanism = new LFUFileCache();
        String[] targetFiles = new String[]{"Target1", "Target2", "Target3", "Target1", "Target4", "Target2", "Target5"};
        for(String files: targetFiles){
            cacheMechanism.fetchTarget(files);
        }
        String[] expected = new String[]{"Target1=Contents of Target1", "Target2=Contents of Target2", "Target4=Contents of Target4", "Target5=Contents of Target5"};
        String[] actual = hashmapToStringArray(cacheMechanism.cache);
        Assertions.assertArrayEquals(expected, actual);
    }
}
