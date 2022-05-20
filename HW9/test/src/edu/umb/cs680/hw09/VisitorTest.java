package edu.umb.cs680.hw09;

import edu.umb.cs680.hw09.apfs.*;
import edu.umb.cs680.hw09.apfs.util.ApfsCountingVisitor;
import edu.umb.cs680.hw09.apfs.util.ApfsFileCrawlingVisitor;
import edu.umb.cs680.hw09.apfs.util.ApfsFileSearchVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class VisitorTest {
    @Test
    public void testingCountingVisitor(){
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
        folder2.appendChild(file3);

        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        root.accept(visitor);
        int actual = visitor.getDirNum() + visitor.getFileNum() + visitor.getLinkNum();
        int expected = 7;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testingFileCrawlingVisitor(){
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
        folder2.appendChild(file3);

        ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
        root.accept(visitor);
        int actual = visitor.getFiles().size();
        int expected = 3;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testingFileSearchVisitor(){
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
        folder2.appendChild(file3);

        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("file2");
        root.accept(visitor);
        LinkedList<ApfsFile> children = visitor.getFoundFiles();
        String[] actualChildren = new String[1];
        int i = 0;
        for(ApfsElement element : children){
            actualChildren[i++] = element.getName();
        }
        String[] expectedChildren = new String[]{"file2"};
        Assertions.assertArrayEquals(expectedChildren, actualChildren);
    }
}
