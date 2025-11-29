package com.xingin.xhssharesdk.j;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import java.io.File;

public final class b implements d {
    public final Uri a(Context context, String str, File file) {
        try {
            return FileProvider.getUriForFile(context, str, file);
        } catch (Throwable th) {
            XhsShareSdk.d("XhsShare_AndroidXFileProvider", "getUriForFile error.", th);
            return null;
        }
    }
}
