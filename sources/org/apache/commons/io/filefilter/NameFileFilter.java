package org.apache.commons.io.filefilter;

import com.meizu.common.widget.MzContactsContract;
import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Objects;
import org.apache.commons.io.IOCase;

public class NameFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 176844364689077340L;
    private final IOCase caseSensitivity;
    private final String[] names;

    public NameFileFilter(List<String> list) {
        this(list, (IOCase) null);
    }

    private boolean acceptBaseName(String str) {
        for (String checkEquals : this.names) {
            if (this.caseSensitivity.checkEquals(str, checkEquals)) {
                return true;
            }
        }
        return false;
    }

    private IOCase toIOCase(IOCase iOCase) {
        return iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public boolean accept(File file) {
        return acceptBaseName(file.getName());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("(");
        if (this.names != null) {
            for (int i = 0; i < this.names.length; i++) {
                if (i > 0) {
                    sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
                }
                sb.append(this.names[i]);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public NameFileFilter(List<String> list, IOCase iOCase) {
        if (list != null) {
            this.names = (String[]) list.toArray(IOFileFilter.EMPTY_STRING_ARRAY);
            this.caseSensitivity = toIOCase(iOCase);
            return;
        }
        throw new IllegalArgumentException("The list of names must not be null");
    }

    public boolean accept(File file, String str) {
        return acceptBaseName(str);
    }

    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        return AbstractFileFilter.toFileVisitResult(acceptBaseName(Objects.toString(path.getFileName(), (String) null)), path);
    }

    public NameFileFilter(String str) {
        this(str, IOCase.SENSITIVE);
    }

    public NameFileFilter(String... strArr) {
        this(strArr, IOCase.SENSITIVE);
    }

    public NameFileFilter(String str, IOCase iOCase) {
        if (str != null) {
            this.names = new String[]{str};
            this.caseSensitivity = toIOCase(iOCase);
            return;
        }
        throw new IllegalArgumentException("The wildcard must not be null");
    }

    public NameFileFilter(String[] strArr, IOCase iOCase) {
        if (strArr != null) {
            String[] strArr2 = new String[strArr.length];
            this.names = strArr2;
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            this.caseSensitivity = toIOCase(iOCase);
            return;
        }
        throw new IllegalArgumentException("The array of names must not be null");
    }
}
