package org.apache.commons.io.filefilter;

import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class FileEqualsFileFilter extends AbstractFileFilter {
    private final File file;
    private final Path path;

    public FileEqualsFileFilter(File file2) {
        Objects.requireNonNull(file2, "file");
        this.file = file2;
        this.path = file2.toPath();
    }

    public boolean accept(File file2) {
        return Objects.equals(this.file, file2);
    }

    public FileVisitResult accept(Path path2, BasicFileAttributes basicFileAttributes) {
        return AbstractFileFilter.toFileVisitResult(Objects.equals(this.path, path2), path2);
    }
}
