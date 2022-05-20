package edu.umb.cs680.hw14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;

public class ApfsElementSortingTest {
    @Test
    public void testingDefaultComparator(){
        APFS apfs = new APFS();
        apfs.init("root", 1);
        ApfsDirectory root = apfs.getRootDir();
        ApfsDirectory folder1 = new ApfsDirectory(root, "folder1", 0, LocalDateTime.now());
        root.appendChild(folder1);
        ApfsDirectory folder2 = new ApfsDirectory(root, "folder2", 0, LocalDateTime.now());
        root.appendChild(folder2);
        ApfsFile file1 = new ApfsFile(root, "file1", 0, LocalDateTime.now());
        root.appendChild(file1);
        ApfsFile file2 = new ApfsFile(root, "file2", 0, LocalDateTime.now());
        root.appendChild(file2);
        ApfsDirectory folder3 = new ApfsDirectory(folder1, "folder3", 0, LocalDateTime.now());
        folder1.appendChild(folder3);
        ApfsFile file3 = new ApfsFile(folder2, "file3", 0, LocalDateTime.now());
        LinkedList<ApfsElement> children = root.getChildren(null);
        String[] actualChildren = new String[4];
        int i = 0;
        for(ApfsElement element : children){
            actualChildren[i++] = element.name;
        }
        String[] expectedChildren = new String[]{"file1", "file2", "folder1", "folder2"};
        Assertions.assertArrayEquals(expectedChildren, actualChildren);
    }

    @Test
    public void testingTimeStampComparator(){
        APFS apfs = new APFS();
        apfs.init("root", 1);
        ApfsDirectory root = apfs.getRootDir();
        ApfsDirectory folder1 = new ApfsDirectory(root, "folder1", 0, LocalDateTime.of(2012, 4, 23, 7, 43, 22));
        root.appendChild(folder1);
        ApfsDirectory folder2 = new ApfsDirectory(root, "folder2", 0, LocalDateTime.of(2010, 7, 25, 2, 45, 22));
        root.appendChild(folder2);
        ApfsFile file1 = new ApfsFile(root, "file1", 0, LocalDateTime.of(2014, 7, 2, 17, 43, 22));
        root.appendChild(file1);
        ApfsFile file2 = new ApfsFile(root, "file2", 0, LocalDateTime.of(2002, 4, 23, 7, 43, 22));
        root.appendChild(file2);
        ApfsDirectory folder3 = new ApfsDirectory(folder1, "folder3", 0, LocalDateTime.of(2020, 8, 12, 5, 3, 2));
        folder1.appendChild(folder3);
        ApfsFile file3 = new ApfsFile(folder2, "file3", 0, LocalDateTime.of(2090, 3, 30, 11, 43, 22));
        LinkedList<ApfsElement> children = root.getChildren(Comparator.comparing(apfsDirectory -> apfsDirectory.creationTime));
        String[] actualChildren = new String[4];
        int i = 0;
        for(ApfsElement element : children){
            actualChildren[i++] = element.name;
        }
        String[] expectedChildren = new String[]{"file2", "folder2", "folder1", "file1"};
        Assertions.assertArrayEquals(expectedChildren, actualChildren);
    }
}
