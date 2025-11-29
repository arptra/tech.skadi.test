package org.apache.commons.io.file;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.io.file.Counters;

public class AccumulatorPathVisitor extends CountingPathVisitor {
    private final List<Path> dirList = new ArrayList();
    private final List<Path> fileList = new ArrayList();

    public AccumulatorPathVisitor() {
        super(Counters.noopPathCounters());
    }

    private void add(List<Path> list, Path path) {
        list.add(path.normalize());
    }

    public static AccumulatorPathVisitor withBigIntegerCounters() {
        return new AccumulatorPathVisitor(Counters.bigIntegerPathCounters());
    }

    public static AccumulatorPathVisitor withLongCounters() {
        return new AccumulatorPathVisitor(Counters.longPathCounters());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || !(obj instanceof AccumulatorPathVisitor)) {
            return false;
        }
        AccumulatorPathVisitor accumulatorPathVisitor = (AccumulatorPathVisitor) obj;
        return Objects.equals(this.dirList, accumulatorPathVisitor.dirList) && Objects.equals(this.fileList, accumulatorPathVisitor.fileList);
    }

    public List<Path> getDirList() {
        return this.dirList;
    }

    public List<Path> getFileList() {
        return this.fileList;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Objects.hash(new Object[]{this.dirList, this.fileList});
    }

    public List<Path> relativizeDirectories(Path path, boolean z, Comparator<? super Path> comparator) {
        return PathUtils.relativize(getDirList(), path, z, comparator);
    }

    public List<Path> relativizeFiles(Path path, boolean z, Comparator<? super Path> comparator) {
        return PathUtils.relativize(getFileList(), path, z, comparator);
    }

    public void updateDirCounter(Path path, IOException iOException) {
        super.updateDirCounter(path, iOException);
        add(this.dirList, path);
    }

    public void updateFileCounters(Path path, BasicFileAttributes basicFileAttributes) {
        super.updateFileCounters(path, basicFileAttributes);
        add(this.fileList, path);
    }

    public static AccumulatorPathVisitor withBigIntegerCounters(PathFilter pathFilter, PathFilter pathFilter2) {
        return new AccumulatorPathVisitor(Counters.bigIntegerPathCounters(), pathFilter, pathFilter2);
    }

    public static AccumulatorPathVisitor withLongCounters(PathFilter pathFilter, PathFilter pathFilter2) {
        return new AccumulatorPathVisitor(Counters.longPathCounters(), pathFilter, pathFilter2);
    }

    public AccumulatorPathVisitor(Counters.PathCounters pathCounters) {
        super(pathCounters);
    }

    public AccumulatorPathVisitor(Counters.PathCounters pathCounters, PathFilter pathFilter, PathFilter pathFilter2) {
        super(pathCounters, pathFilter, pathFilter2);
    }
}
