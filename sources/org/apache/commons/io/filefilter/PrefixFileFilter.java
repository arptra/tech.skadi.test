package org.apache.commons.io.filefilter;

import com.meizu.common.widget.MzContactsContract;
import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import org.apache.commons.io.IOCase;

public class PrefixFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 8533897440809599867L;
    private final IOCase caseSensitivity;
    private final String[] prefixes;

    public PrefixFileFilter(List<String> list) {
        this(list, IOCase.SENSITIVE);
    }

    public boolean accept(File file) {
        return accept(file == null ? null : file.getName());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("(");
        if (this.prefixes != null) {
            for (int i = 0; i < this.prefixes.length; i++) {
                if (i > 0) {
                    sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
                }
                sb.append(this.prefixes[i]);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public PrefixFileFilter(List<String> list, IOCase iOCase) {
        if (list != null) {
            this.prefixes = (String[]) list.toArray(IOFileFilter.EMPTY_STRING_ARRAY);
            this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
            return;
        }
        throw new IllegalArgumentException("The list of prefixes must not be null");
    }

    public boolean accept(File file, String str) {
        return accept(str);
    }

    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        File file;
        Path fileName = path.getFileName();
        if (fileName == null) {
            file = null;
        } else {
            file = fileName.toFile();
        }
        return AbstractFileFilter.toFileVisitResult(accept(file), path);
    }

    private boolean accept(String str) {
        for (String checkStartsWith : this.prefixes) {
            if (this.caseSensitivity.checkStartsWith(str, checkStartsWith)) {
                return true;
            }
        }
        return false;
    }

    public PrefixFileFilter(String str) {
        this(str, IOCase.SENSITIVE);
    }

    public PrefixFileFilter(String... strArr) {
        this(strArr, IOCase.SENSITIVE);
    }

    public PrefixFileFilter(String str, IOCase iOCase) {
        if (str != null) {
            this.prefixes = new String[]{str};
            this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
            return;
        }
        throw new IllegalArgumentException("The prefix must not be null");
    }

    public PrefixFileFilter(String[] strArr, IOCase iOCase) {
        if (strArr != null) {
            String[] strArr2 = new String[strArr.length];
            this.prefixes = strArr2;
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
            return;
        }
        throw new IllegalArgumentException("The array of prefixes must not be null");
    }
}
