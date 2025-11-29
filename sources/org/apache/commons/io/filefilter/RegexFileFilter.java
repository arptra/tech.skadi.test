package org.apache.commons.io.filefilter;

import com.honey.account.tb.b;
import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.Function;
import java.util.regex.Pattern;
import org.apache.commons.io.IOCase;

public class RegexFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 4269646126155225062L;
    private final Function<Path, String> pathToString;
    private final Pattern pattern;

    public RegexFileFilter(Pattern pattern2) {
        this(pattern2, (Function<Path, String>) new b());
    }

    private static Pattern compile(String str, int i) {
        if (str != null) {
            return Pattern.compile(str, i);
        }
        throw new IllegalArgumentException("Pattern is missing");
    }

    private static int toFlags(IOCase iOCase) {
        return IOCase.isCaseSensitive(iOCase) ? 2 : 0;
    }

    public boolean accept(File file, String str) {
        return this.pattern.matcher(str).matches();
    }

    public String toString() {
        return "RegexFileFilter [pattern=" + this.pattern + "]";
    }

    public RegexFileFilter(Pattern pattern2, Function<Path, String> function) {
        if (pattern2 != null) {
            this.pattern = pattern2;
            this.pathToString = function;
            return;
        }
        throw new IllegalArgumentException("Pattern is missing");
    }

    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        return AbstractFileFilter.toFileVisitResult(this.pattern.matcher(this.pathToString.apply(path)).matches(), path);
    }

    public RegexFileFilter(String str) {
        this(str, 0);
    }

    public RegexFileFilter(String str, int i) {
        this(compile(str, i));
    }

    public RegexFileFilter(String str, IOCase iOCase) {
        this(compile(str, toFlags(iOCase)));
    }
}
