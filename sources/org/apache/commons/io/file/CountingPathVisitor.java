package org.apache.commons.io.file;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;
import org.apache.commons.io.file.Counters;

public class CountingPathVisitor extends SimplePathVisitor {
    static final String[] EMPTY_STRING_ARRAY = new String[0];
    private final PathFilter dirFilter;
    private final PathFilter fileFilter;
    private final Counters.PathCounters pathCounters;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CountingPathVisitor(org.apache.commons.io.file.Counters.PathCounters r2) {
        /*
            r1 = this;
            org.apache.commons.io.filefilter.IOFileFilter r0 = org.apache.commons.io.filefilter.TrueFileFilter.INSTANCE
            r1.<init>(r2, r0, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.file.CountingPathVisitor.<init>(org.apache.commons.io.file.Counters$PathCounters):void");
    }

    public static CountingPathVisitor withBigIntegerCounters() {
        return new CountingPathVisitor(Counters.bigIntegerPathCounters());
    }

    public static CountingPathVisitor withLongCounters() {
        return new CountingPathVisitor(Counters.longPathCounters());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CountingPathVisitor)) {
            return false;
        }
        return Objects.equals(this.pathCounters, ((CountingPathVisitor) obj).pathCounters);
    }

    public Counters.PathCounters getPathCounters() {
        return this.pathCounters;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.pathCounters});
    }

    public String toString() {
        return this.pathCounters.toString();
    }

    public void updateDirCounter(Path path, IOException iOException) {
        this.pathCounters.getDirectoryCounter().increment();
    }

    public void updateFileCounters(Path path, BasicFileAttributes basicFileAttributes) {
        this.pathCounters.getFileCounter().increment();
        this.pathCounters.getByteCounter().add(basicFileAttributes.size());
    }

    public CountingPathVisitor(Counters.PathCounters pathCounters2, PathFilter pathFilter, PathFilter pathFilter2) {
        Objects.requireNonNull(pathCounters2, "pathCounter");
        this.pathCounters = pathCounters2;
        Objects.requireNonNull(pathFilter, "fileFilter");
        this.fileFilter = pathFilter;
        Objects.requireNonNull(pathFilter2, "dirFilter");
        this.dirFilter = pathFilter2;
    }

    public FileVisitResult postVisitDirectory(Path path, IOException iOException) throws IOException {
        updateDirCounter(path, iOException);
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        FileVisitResult accept = this.dirFilter.accept(path, basicFileAttributes);
        FileVisitResult fileVisitResult = FileVisitResult.CONTINUE;
        return accept != fileVisitResult ? FileVisitResult.SKIP_SUBTREE : fileVisitResult;
    }

    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        if (Files.exists(path, new LinkOption[0]) && this.fileFilter.accept(path, basicFileAttributes) == FileVisitResult.CONTINUE) {
            updateFileCounters(path, basicFileAttributes);
        }
        return FileVisitResult.CONTINUE;
    }
}
