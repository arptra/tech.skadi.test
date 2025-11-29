package com.here.sdk.engine;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.here.sdk.core.SDKLibraryLoader;
import com.here.sdk.core.engine.ApplicationUtilsInitializer;
import com.here.sdk.core.engine.PlatformUtilsInitializer;
import com.here.sdk.core.threading.ThreadingInitializer;

public class InitProvider {
    private static final String CLASS_WITH_LIBRARY_LIST_SUFFIX = "SDK";
    private static final String TAG = "InitProvider";
    private static SDKLibraryLoader mLibraryLoader = null;
    private static boolean mSdkInternalsIsInitialized = false;

    public static void initialize(@NonNull Context context) {
        if (!mSdkInternalsIsInitialized) {
            mSdkInternalsIsInitialized = true;
            Log.d(TAG, "Initializing platform modules");
            PlatformUtilsInitializer.startAsyncPathLoader(context);
            if (mLibraryLoader == null) {
                mLibraryLoader = new SDKLibraryLoader(CLASS_WITH_LIBRARY_LIST_SUFFIX);
            }
            initializeSDK(context);
        }
    }

    public static void initializeSDK(@NonNull Context context) {
        ThreadingInitializer.initialize();
        NetworkingInitializer.initialize(context);
        PlatformUtilsInitializer.initialize(context);
        ApplicationUtilsInitializer.initialize(context);
        CompleteInitialization.completed();
    }

    public static void loadSDK(String str) {
        try {
            SDKLibraryLoader.class.getMethod("loadLibraries", new Class[]{String[].class, String.class}).invoke((Object) null, new Object[]{new String[]{str}, CLASS_WITH_LIBRARY_LIST_SUFFIX});
        } catch (Exception unused) {
            Log.w(TAG, "Failed to invoke default method to load library.");
            System.loadLibrary(str);
        }
    }
}
