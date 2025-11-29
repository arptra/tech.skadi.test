package com.upuphone.ar.fastrecord.phone.utils;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;

public class IntentUtils {
    static final String AUTHORITY_FILE_PROVIDER = "com.upup.start.launcher.soundrecorder.fileprovider";

    public static Uri getShareUriForFile(Context context, String str) {
        return FileProvider.getUriForFile(context, AUTHORITY_FILE_PROVIDER, new File(str));
    }
}
