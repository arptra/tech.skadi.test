package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class HiddenFileFilter extends AbstractFileFilter implements Serializable {
    public static final IOFileFilter HIDDEN;
    public static final IOFileFilter VISIBLE;
    private static final long serialVersionUID = 8930842316112759062L;

    static {
        HiddenFileFilter hiddenFileFilter = new HiddenFileFilter();
        HIDDEN = hiddenFileFilter;
        VISIBLE = hiddenFileFilter.negate();
    }

    public boolean accept(File file) {
        return file.isHidden();
    }

    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        try {
            return AbstractFileFilter.toFileVisitResult(Files.isHidden(path), path);
        } catch (IOException e) {
            return handle(e);
        }
    }
}
