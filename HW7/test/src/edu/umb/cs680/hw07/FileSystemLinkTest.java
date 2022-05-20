package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class FileSystemLinkTest {
    @Test
    public void testingLink(){
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
        Link symLink = new Link(folder1, "to_folder1", 0, LocalDateTime.now(), file1);
        folder1.appendChild(symLink);
        File file3 = new File(folder2, "file3", 0, LocalDateTime.now());
        folder2.appendChild(file3);
        fileSystem.appendRootDir(root);
        FSElement actual = symLink.getTarget();
        FSElement expected = file1;
        Assertions.assertEquals(expected, actual);
    }
}
