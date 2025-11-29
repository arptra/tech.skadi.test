package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class FileFileFilter extends AbstractFileFilter implements Serializable {
    @Deprecated
    public static final IOFileFilter FILE;
    public static final IOFileFilter INSTANCE;
    private static final long serialVersionUID = 5345244090827540862L;

    static {
        FileFileFilter fileFileFilter = new FileFileFilter();
        INSTANCE = fileFileFilter;
        FILE = fileFileFilter;
    }

    public boolean accept(File file) {
        return file.isFile();
    }

    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        return AbstractFileFilter.toFileVisitResult(Files.isRegularFile(path, new LinkOption[0]), path);
    }
}
