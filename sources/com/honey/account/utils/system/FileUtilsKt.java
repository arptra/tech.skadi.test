package com.honey.account.utils.system;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"getDocumentsPath", "", "context", "Landroid/content/Context;", "readStreamToString", "inputStream", "Ljava/io/InputStream;", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class FileUtilsKt {
    @NotNull
    public static final String getDocumentsPath(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        if (externalFilesDir != null) {
            String path = externalFilesDir.getPath();
            Intrinsics.checkNotNull(path);
            return path;
        }
        return "/storage/emulated/0/Android/data/" + context.getPackageName() + "/files/Documents";
    }

    @NotNull
    public static final String readStreamToString(@Nullable InputStream inputStream) {
        String str;
        if (inputStream != null) {
            byte[] bArr = new byte[1024];
            StringBuffer stringBuffer = new StringBuffer();
            while (inputStream.read(bArr) != -1) {
                stringBuffer.append(new String(bArr, Charsets.UTF_8));
            }
            inputStream.close();
            str = stringBuffer.toString();
        } else {
            str = null;
        }
        return str == null ? "" : str;
    }
}
