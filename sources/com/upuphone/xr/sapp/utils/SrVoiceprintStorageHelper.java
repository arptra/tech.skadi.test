package com.upuphone.xr.sapp.utils;

import android.content.Context;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.utils.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0003J\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0003R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/utils/SrVoiceprintStorageHelper;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "b", "(Landroid/content/Context;)V", "", "byteArray", "", "fileName", "c", "([BLjava/lang/String;)V", "d", "a", "Ljava/lang/String;", "bleSaveFolder", "", "Z", "audioDebug", "Ljava/io/FileOutputStream;", "Ljava/io/FileOutputStream;", "fileOutputStream", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SrVoiceprintStorageHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final SrVoiceprintStorageHelper f7916a = new SrVoiceprintStorageHelper();
    public static String b;
    public static boolean c;
    public static FileOutputStream d;

    public static final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        c = true;
        String absolutePath = context.getFilesDir().getAbsolutePath();
        String str = File.separator;
        String str2 = absolutePath + str + "SrVoiceprint" + str;
        b = str2;
        LogExt.j("openDebug: audioDebug: " + c + ", path: " + str2, "SrVoiceprintStorageHelper");
        File file = new File(b, "");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static final void c(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "byteArray");
        Intrinsics.checkNotNullParameter(str, "fileName");
        if (c) {
            File file = new File(b, str);
            if (file.exists()) {
                FileUtils.f6363a.a(file);
                LogExt.j("saveAudioSource 文件已经存在，先删除已经存在的文件", "SrVoiceprintStorageHelper");
            }
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            if (d == null) {
                d = new FileOutputStream(file, true);
            }
            FileOutputStream fileOutputStream = d;
            if (fileOutputStream != null) {
                fileOutputStream.write(copyOf);
                fileOutputStream.flush();
            }
        }
    }

    public final void a() {
        FileOutputStream fileOutputStream = d;
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        d = null;
    }

    public final void d() {
        c = false;
        a();
    }
}
