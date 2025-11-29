package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;
import org.apache.commons.io.file.PathVisitor;

public abstract class AbstractFileFilter implements IOFileFilter, PathVisitor {
    public static FileVisitResult toFileVisitResult(boolean z, Path path) {
        return z ? FileVisitResult.CONTINUE : FileVisitResult.TERMINATE;
    }

    public boolean accept(File file) {
        Objects.requireNonNull(file, "file");
        return accept(file.getParentFile(), file.getName());
    }

    public FileVisitResult handle(Throwable th) {
        return FileVisitResult.TERMINATE;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public FileVisitResult postVisitDirectory(Path path, IOException iOException) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        return accept(path, basicFileAttributes);
    }

    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        return accept(path, basicFileAttributes);
    }

    public FileVisitResult visitFileFailed(Path path, IOException iOException) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public boolean accept(File file, String str) {
        Objects.requireNonNull(str, "name");
        return accept(new File(file, str));
    }
}
