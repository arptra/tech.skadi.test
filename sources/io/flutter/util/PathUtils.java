package io.flutter.util;

import android.content.Context;
import androidx.annotation.NonNull;
import java.io.File;

public final class PathUtils {
    @NonNull
    public static String getCacheDirectory(@NonNull Context context) {
        File codeCacheDir = context.getCodeCacheDir();
        if (codeCacheDir == null) {
            codeCacheDir = context.getCacheDir();
        }
        if (codeCacheDir == null) {
            codeCacheDir = new File(getDataDirPath(context), "cache");
        }
        return codeCacheDir.getPath();
    }

    private static String getDataDirPath(Context context) {
        return context.getDataDir().getPath();
    }

    @NonNull
    public static String getDataDirectory(@NonNull Context context) {
        File dir = context.getDir("flutter", 0);
        if (dir == null) {
            dir = new File(getDataDirPath(context), "app_flutter");
        }
        return dir.getPath();
    }

    @NonNull
    public static String getFilesDir(@NonNull Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            filesDir = new File(getDataDirPath(context), "files");
        }
        return filesDir.getPath();
    }
}
