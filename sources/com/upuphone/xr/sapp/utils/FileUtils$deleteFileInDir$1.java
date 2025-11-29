package com.upuphone.xr.sapp.utils;

import com.upuphone.star.core.log.ULog;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/utils/FileUtils$deleteFileInDir$1", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "file", "Ljava/nio/file/attribute/BasicFileAttributes;", "attrs", "Ljava/nio/file/FileVisitResult;", "a", "(Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class FileUtils$deleteFileInDir$1 extends SimpleFileVisitor<Path> {
    /* renamed from: a */
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) {
        try {
            Files.delete(path);
        } catch (Throwable th) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("FileUtils", "Files.delete, error: " + th);
        }
        return FileVisitResult.CONTINUE;
    }
}
