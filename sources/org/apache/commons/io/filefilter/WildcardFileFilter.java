package org.apache.commons.io.filefilter;

import com.meizu.common.widget.MzContactsContract;
import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Objects;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;

public class WildcardFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -7426486598995782105L;
    private final IOCase caseSensitivity;
    private final String[] wildcards;

    public WildcardFileFilter(List<String> list) {
        this(list, IOCase.SENSITIVE);
    }

    public boolean accept(File file) {
        return accept(file.getName());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("(");
        for (int i = 0; i < this.wildcards.length; i++) {
            if (i > 0) {
                sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
            }
            sb.append(this.wildcards[i]);
        }
        sb.append(")");
        return sb.toString();
    }

    public WildcardFileFilter(List<String> list, IOCase iOCase) {
        if (list != null) {
            this.wildcards = (String[]) list.toArray(IOFileFilter.EMPTY_STRING_ARRAY);
            this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
            return;
        }
        throw new IllegalArgumentException("The wildcard list must not be null");
    }

    public boolean accept(File file, String str) {
        return accept(str);
    }

    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        return AbstractFileFilter.toFileVisitResult(accept(Objects.toString(path.getFileName(), (String) null)), path);
    }

    private boolean accept(String str) {
        for (String wildcardMatch : this.wildcards) {
            if (FilenameUtils.wildcardMatch(str, wildcardMatch, this.caseSensitivity)) {
                return true;
            }
        }
        return false;
    }

    public WildcardFileFilter(String str) {
        this(str, IOCase.SENSITIVE);
    }

    public WildcardFileFilter(String... strArr) {
        this(strArr, IOCase.SENSITIVE);
    }

    public WildcardFileFilter(String str, IOCase iOCase) {
        if (str != null) {
            this.wildcards = new String[]{str};
            this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
            return;
        }
        throw new IllegalArgumentException("The wildcard must not be null");
    }

    public WildcardFileFilter(String[] strArr, IOCase iOCase) {
        if (strArr != null) {
            String[] strArr2 = new String[strArr.length];
            this.wildcards = strArr2;
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
            return;
        }
        throw new IllegalArgumentException("The wildcard array must not be null");
    }
}
