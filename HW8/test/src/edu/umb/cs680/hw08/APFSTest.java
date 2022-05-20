package edu.umb.cs680.hw08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class APFSTest {
    @Test
    public void testingParentChildRelationship(){
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
        ApfsFile file3 = new ApfsFile(folder2, "folder2", 0, LocalDateTime.now());
        ApfsDirectory actual = folder1.parent;
        ApfsDirectory expected = root;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testingTotalSizeOfDirectory(){
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
        ApfsFile file3 = new ApfsFile(folder2, "folder2", 0, LocalDateTime.now());
        int actual = root.getTotalSize();
        int expected = 5;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testingChildren(){
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
        ApfsFile file3 = new ApfsFile(folder2, "folder2", 0, LocalDateTime.now());
        LinkedList<ApfsElement> children = root.getChildren();
        String[] actualChildren = new String[4];
        int i = 0;
        for(ApfsElement element : children){
            actualChildren[i++] = element.name;
        }
        String[] expectedChildren = new String[]{"folder1", "folder2", "file1", "file2"};
        Assertions.assertArrayEquals(expectedChildren, actualChildren);
    }

    @Test
    public void testingLink(){
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
        ApfsFile file3 = new ApfsFile(folder2, "folder2", 0, LocalDateTime.now());
        ApfsLink symlink = new ApfsLink(folder1, "shortcut", 0, LocalDateTime.now(), root);
        Assertions.assertSame(root, symlink.getTarget());
    }
}
