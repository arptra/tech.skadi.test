package com.here.sdk.core;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.engine.SDKBuildInformation;
import java.util.HashSet;

public final class SDKLibraryLoader {
    private static final String TAG = "SDKLibraryLoader";
    private static final HashSet<String> loadedLibraries = new HashSet<>();

    public SDKLibraryLoader(@NonNull String str) {
        if (!isLoaded(str)) {
            loadLibraries(getLibrariesToLoad(str), str);
            String str2 = TAG;
            Log.i(str2, "HERESDK Version " + SDKBuildInformation.sdkVersion().versionName);
        }
    }

    @NonNull
    public static String[] getLibrariesToLoad(@NonNull String str) {
        String[] readLibraryListFromClass = readLibraryListFromClass(str + "TestLibraryList");
        if (readLibraryListFromClass != null) {
            return readLibraryListFromClass;
        }
        String str2 = str + "LibraryList";
        String[] readLibraryListFromClass2 = readLibraryListFromClass(str2);
        if (readLibraryListFromClass2 != null) {
            return readLibraryListFromClass2;
        }
        throw new RuntimeException("Failed to retrieve libraries to load from class " + str2);
    }

    private static boolean isLoaded(@NonNull String str) {
        boolean contains = loadedLibraries.contains(str);
        if (contains) {
            String str2 = TAG;
            Log.d(str2, "Libraries listed for " + str + " are already loaded");
        }
        return contains;
    }

    public static void loadLibraries(@NonNull String[] strArr, @NonNull String str) {
        if (!isLoaded(str)) {
            for (String str2 : strArr) {
                Log.d(TAG, "Loading shared library: " + str2);
                System.loadLibrary(str2);
            }
            loadedLibraries.add(str);
        }
    }

    @Nullable
    private static String[] readLibraryListFromClass(@NonNull String str) {
        boolean z = false;
        try {
            Class<?> cls = Class.forName("com.here.sdk.core." + str);
            Log.i(TAG, "Reading library list");
            z = true;
            return (String[]) cls.getField("LIBRARIES_TO_LOAD").get((Object) null);
        } catch (Exception e) {
            if (z) {
                Log.e(TAG, "Failed to read library list", e);
            }
            return null;
        }
    }
}
