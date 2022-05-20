package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class FileSystemTest {
    @Test
    public void testingTotalSize(){
        FileSystem fileSystem = FileSystem.getFileSystem();
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
        int actual = fileSystem.getRootDirs().get(0).getTotalSize();
        int expected = 6;
        Assertions.assertEquals(expected, actual);
        actual = folder1.getTotalSize();
        expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testingParentChildRelationship(){
        FileSystem fileSystem = FileSystem.getFileSystem();
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
        Directory parentActual = folder1.parent;
        Directory parentExpected = root;
        Assertions.assertSame(parentExpected, parentActual);
        parentExpected = folder2.parent;
        Assertions.assertSame(parentExpected, parentActual);
    }

    @Test
    public void testingTotalDirectoriesAndFiles(){
        FileSystem fileSystem = FileSystem.getFileSystem();
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
        int actual = root.getSubDirectory().size();
        int expected = 2;
        Assertions.assertEquals(expected, actual);
        int actualFiles = root.getFiles().size();
        int expectedFiles = 2;
        Assertions.assertEquals(expectedFiles, actualFiles);
    }

    @Test
    public void testingChildren(){
        FileSystem fileSystem = FileSystem.getFileSystem();
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
        LinkedList<FSElement> children = fileSystem.getRootDirs().get(0).getChildren();
        String[] childNamesActual = new String[4];
        int i = 0;
        for(FSElement element : children){
            childNamesActual[i++] = element.getName();
        }
        String[] childNamesExpected = new String[]{"folder1", "folder2", "file1", "file2"};
        Assertions.assertArrayEquals(childNamesExpected, childNamesActual);
    }
}
