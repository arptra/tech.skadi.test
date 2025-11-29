package org.apache.commons.io.filefilter;

import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class PathEqualsFileFilter extends AbstractFileFilter {
    private final Path path;

    public PathEqualsFileFilter(Path path2) {
        this.path = path2;
    }

    public boolean accept(File file) {
        return Objects.equals(this.path, file.toPath());
    }

    public FileVisitResult accept(Path path2, BasicFileAttributes basicFileAttributes) {
        return AbstractFileFilter.toFileVisitResult(Objects.equals(this.path, path2), path2);
    }
}
