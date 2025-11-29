package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class NotFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 6131563330944994230L;
    private final IOFileFilter filter;

    public NotFileFilter(IOFileFilter iOFileFilter) {
        if (iOFileFilter != null) {
            this.filter = iOFileFilter;
            return;
        }
        throw new IllegalArgumentException("The filter must not be null");
    }

    private FileVisitResult not(FileVisitResult fileVisitResult) {
        FileVisitResult fileVisitResult2 = FileVisitResult.CONTINUE;
        return fileVisitResult == fileVisitResult2 ? FileVisitResult.TERMINATE : fileVisitResult2;
    }

    public boolean accept(File file) {
        return !this.filter.accept(file);
    }

    public String toString() {
        return "NOT (" + this.filter.toString() + ")";
    }

    public boolean accept(File file, String str) {
        return !this.filter.accept(file, str);
    }

    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        return not(this.filter.accept(path, basicFileAttributes));
    }
}
