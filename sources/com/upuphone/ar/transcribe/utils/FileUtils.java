package com.upuphone.ar.transcribe.utils;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/upuphone/ar/transcribe/utils/FileUtils;", "", "<init>", "()V", "Ljava/io/File;", "file", "", "a", "(Ljava/io/File;)Z", "c", "dirFile", "b", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class FileUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final FileUtils f6184a = new FileUtils();

    public final boolean a(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return file.isDirectory() ? b(file) : c(file);
    }

    public final boolean b(File file) {
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return file.delete();
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    return false;
                }
            } else if (file2.isDirectory()) {
                Intrinsics.checkNotNull(file2);
                if (!b(file2)) {
                    return false;
                }
            } else {
                continue;
            }
        }
        return file.delete();
    }

    public final boolean c(File file) {
        if (!file.exists()) {
            return true;
        }
        return file.isFile() && file.delete();
    }
}
