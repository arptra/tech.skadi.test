package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Objects;
import org.apache.commons.io.FilenameUtils;

@Deprecated
public class WildcardFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -5037645902506953517L;
    private final String[] wildcards;

    public WildcardFilter(List<String> list) {
        if (list != null) {
            this.wildcards = (String[]) list.toArray(IOFileFilter.EMPTY_STRING_ARRAY);
            return;
        }
        throw new IllegalArgumentException("The wildcard list must not be null");
    }

    public boolean accept(File file) {
        if (file.isDirectory()) {
            return false;
        }
        for (String wildcardMatch : this.wildcards) {
            if (FilenameUtils.wildcardMatch(file.getName(), wildcardMatch)) {
                return true;
            }
        }
        return false;
    }

    public WildcardFilter(String str) {
        if (str != null) {
            this.wildcards = new String[]{str};
            return;
        }
        throw new IllegalArgumentException("The wildcard must not be null");
    }

    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        if (Files.isDirectory(path, new LinkOption[0])) {
            return FileVisitResult.TERMINATE;
        }
        for (String wildcardMatch : this.wildcards) {
            if (FilenameUtils.wildcardMatch(Objects.toString(path.getFileName(), (String) null), wildcardMatch)) {
                return FileVisitResult.CONTINUE;
            }
        }
        return FileVisitResult.TERMINATE;
    }

    public WildcardFilter(String... strArr) {
        if (strArr != null) {
            String[] strArr2 = new String[strArr.length];
            this.wildcards = strArr2;
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            return;
        }
        throw new IllegalArgumentException("The wildcard array must not be null");
    }

    public boolean accept(File file, String str) {
        if (file != null && new File(file, str).isDirectory()) {
            return false;
        }
        for (String wildcardMatch : this.wildcards) {
            if (FilenameUtils.wildcardMatch(str, wildcardMatch)) {
                return true;
            }
        }
        return false;
    }
}
