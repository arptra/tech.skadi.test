package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class TrueFileFilter implements IOFileFilter, Serializable {
    public static final IOFileFilter INSTANCE;
    private static final String TO_STRING = Boolean.TRUE.toString();
    public static final IOFileFilter TRUE;
    private static final long serialVersionUID = 8782512160909720199L;

    static {
        TrueFileFilter trueFileFilter = new TrueFileFilter();
        TRUE = trueFileFilter;
        INSTANCE = trueFileFilter;
    }

    public boolean accept(File file) {
        return true;
    }

    public IOFileFilter and(IOFileFilter iOFileFilter) {
        return iOFileFilter;
    }

    public IOFileFilter negate() {
        return FalseFileFilter.INSTANCE;
    }

    public IOFileFilter or(IOFileFilter iOFileFilter) {
        return INSTANCE;
    }

    public String toString() {
        return TO_STRING;
    }

    public boolean accept(File file, String str) {
        return true;
    }

    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        return FileVisitResult.CONTINUE;
    }
}
