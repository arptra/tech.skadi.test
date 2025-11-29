package org.apache.commons.io.filefilter;

import com.meizu.common.widget.MzContactsContract;
import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class OrFileFilter extends AbstractFileFilter implements ConditionalFileFilter, Serializable {
    private static final long serialVersionUID = 5767770777065432721L;
    private final List<IOFileFilter> fileFilters;

    public OrFileFilter() {
        this(0);
    }

    public boolean accept(File file) {
        for (IOFileFilter accept : this.fileFilters) {
            if (accept.accept(file)) {
                return true;
            }
        }
        return false;
    }

    public void addFileFilter(IOFileFilter iOFileFilter) {
        List<IOFileFilter> list = this.fileFilters;
        Objects.requireNonNull(iOFileFilter, "fileFilter");
        list.add(iOFileFilter);
    }

    public List<IOFileFilter> getFileFilters() {
        return Collections.unmodifiableList(this.fileFilters);
    }

    public boolean removeFileFilter(IOFileFilter iOFileFilter) {
        return this.fileFilters.remove(iOFileFilter);
    }

    public void setFileFilters(List<IOFileFilter> list) {
        this.fileFilters.clear();
        List<IOFileFilter> list2 = this.fileFilters;
        Objects.requireNonNull(list, "fileFilters");
        list2.addAll(list);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("(");
        if (this.fileFilters != null) {
            for (int i = 0; i < this.fileFilters.size(); i++) {
                if (i > 0) {
                    sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
                }
                sb.append(this.fileFilters.get(i));
            }
        }
        sb.append(")");
        return sb.toString();
    }

    private OrFileFilter(ArrayList<IOFileFilter> arrayList) {
        Objects.requireNonNull(arrayList, "initialList");
        this.fileFilters = arrayList;
    }

    public void addFileFilter(IOFileFilter... iOFileFilterArr) {
        Objects.requireNonNull(iOFileFilterArr, "fileFilters");
        for (IOFileFilter addFileFilter : iOFileFilterArr) {
            addFileFilter(addFileFilter);
        }
    }

    public boolean accept(File file, String str) {
        for (IOFileFilter accept : this.fileFilters) {
            if (accept.accept(file, str)) {
                return true;
            }
        }
        return false;
    }

    private OrFileFilter(int i) {
        this((ArrayList<IOFileFilter>) new ArrayList(i));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OrFileFilter(IOFileFilter... iOFileFilterArr) {
        this(iOFileFilterArr.length);
        Objects.requireNonNull(iOFileFilterArr, "fileFilters");
        addFileFilter(iOFileFilterArr);
    }

    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        for (IOFileFilter accept : this.fileFilters) {
            FileVisitResult accept2 = accept.accept(path, basicFileAttributes);
            FileVisitResult fileVisitResult = FileVisitResult.CONTINUE;
            if (accept2 == fileVisitResult) {
                return fileVisitResult;
            }
        }
        return FileVisitResult.TERMINATE;
    }

    public OrFileFilter(IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        this(2);
        addFileFilter(iOFileFilter);
        addFileFilter(iOFileFilter2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OrFileFilter(List<IOFileFilter> list) {
        this((ArrayList<IOFileFilter>) new ArrayList(list));
        Objects.requireNonNull(list, "fileFilters");
    }
}
