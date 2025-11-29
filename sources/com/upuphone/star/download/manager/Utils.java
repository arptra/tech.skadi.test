package com.upuphone.star.download.manager;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/upuphone/star/download/manager/Utils;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "subDir", "name", "Ljava/io/File;", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;", "b", "(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;", "lib_download_manager_release"}, k = 1, mv = {1, 9, 0})
public final class Utils {

    /* renamed from: a  reason: collision with root package name */
    public static final Utils f6462a = new Utils();

    public final File a(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str2, "name");
        File externalFilesDir = context.getExternalFilesDir((String) null);
        if (externalFilesDir == null) {
            externalFilesDir = context.getFilesDir();
        }
        if (!(str == null || str.length() == 0)) {
            File file = new File(externalFilesDir, str);
            file.mkdirs();
            externalFilesDir = file;
        }
        return new File(externalFilesDir, str2);
    }

    public final File b(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        File externalFilesDir = context.getExternalFilesDir((String) null);
        if (externalFilesDir == null) {
            externalFilesDir = context.getFilesDir();
        }
        if (!(str == null || str.length() == 0)) {
            File file = new File(externalFilesDir, str);
            file.mkdirs();
            externalFilesDir = file;
        }
        Intrinsics.checkNotNull(externalFilesDir);
        return externalFilesDir;
    }
}
