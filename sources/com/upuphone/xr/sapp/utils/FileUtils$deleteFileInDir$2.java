package com.upuphone.xr.sapp.utils;

import com.upuphone.star.core.log.ULog;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/utils/FileUtils$deleteFileInDir$2", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "file", "Ljava/nio/file/attribute/BasicFileAttributes;", "attrs", "Ljava/nio/file/FileVisitResult;", "a", "(Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class FileUtils$deleteFileInDir$2 extends SimpleFileVisitor<Path> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f7882a;

    public FileUtils$deleteFileInDir$2(List list) {
        this.f7882a = list;
    }

    /* renamed from: a */
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) {
        Intrinsics.checkNotNullParameter(path, "file");
        Intrinsics.checkNotNullParameter(basicFileAttributes, "attrs");
        try {
            if (!this.f7882a.contains(path.toFile())) {
                Files.delete(path);
            }
        } catch (Throwable th) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("FileUtils", "Files.delete, error: " + th);
        }
        return FileVisitResult.CONTINUE;
    }
}
