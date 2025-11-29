package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import org.apache.commons.io.file.NoopPathVisitor;
import org.apache.commons.io.file.PathUtils;
import org.apache.commons.io.file.PathVisitor;

public class PathVisitorFileFilter extends AbstractFileFilter {
    private final PathVisitor pathVisitor;

    public PathVisitorFileFilter(PathVisitor pathVisitor2) {
        this.pathVisitor = pathVisitor2 == null ? NoopPathVisitor.INSTANCE : pathVisitor2;
    }

    public boolean accept(File file) {
        try {
            Path path = file.toPath();
            if (visitFile(path, file.exists() ? PathUtils.readBasicFileAttributes(path) : null) == FileVisitResult.CONTINUE) {
                return true;
            }
            return false;
        } catch (IOException e) {
            if (handle(e) == FileVisitResult.CONTINUE) {
                return true;
            }
            return false;
        }
    }

    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        return this.pathVisitor.visitFile(path, basicFileAttributes);
    }

    public boolean accept(File file, String str) {
        try {
            Path resolve = file.toPath().resolve(str);
            if (accept(resolve, PathUtils.readBasicFileAttributes(resolve)) == FileVisitResult.CONTINUE) {
                return true;
            }
            return false;
        } catch (IOException e) {
            if (this.handle(e) == FileVisitResult.CONTINUE) {
                return true;
            }
            return false;
        }
    }

    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        try {
            return Files.isDirectory(path, new LinkOption[0]) ? this.pathVisitor.postVisitDirectory(path, (IOException) null) : visitFile(path, basicFileAttributes);
        } catch (IOException e) {
            return handle(e);
        }
    }
}
