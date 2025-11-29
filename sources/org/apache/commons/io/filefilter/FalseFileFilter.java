package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class FalseFileFilter implements IOFileFilter, Serializable {
    public static final IOFileFilter FALSE;
    public static final IOFileFilter INSTANCE;
    private static final String TO_STRING = Boolean.FALSE.toString();
    private static final long serialVersionUID = 6210271677940926200L;

    static {
        FalseFileFilter falseFileFilter = new FalseFileFilter();
        FALSE = falseFileFilter;
        INSTANCE = falseFileFilter;
    }

    public boolean accept(File file) {
        return false;
    }

    public IOFileFilter and(IOFileFilter iOFileFilter) {
        return INSTANCE;
    }

    public IOFileFilter negate() {
        return TrueFileFilter.INSTANCE;
    }

    public IOFileFilter or(IOFileFilter iOFileFilter) {
        return iOFileFilter;
    }

    public String toString() {
        return TO_STRING;
    }

    public boolean accept(File file, String str) {
        return false;
    }

    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        return FileVisitResult.TERMINATE;
    }
}
