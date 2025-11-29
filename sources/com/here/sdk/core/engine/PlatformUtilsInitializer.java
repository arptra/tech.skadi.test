package com.here.sdk.core.engine;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.here.sdk.core.engine.PlatformUtils;
import com.honey.account.z1.a;
import com.honey.account.z1.b;
import com.upuphone.runasone.core.api.ApiConstant;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class PlatformUtilsInitializer {
    private static final String LOG_TAG = PlatformUtilsInitializer.class.getSimpleName();
    private static ExecutorService mExecutorService = Executors.newFixedThreadPool(2);
    private static Future<String> mFutureCacheDir;
    private static Future<String> mFutureFilesDir;

    public interface PathRetrieval {
        String getPath();
    }

    private PlatformUtilsInitializer() {
    }

    private static PathRetrieval getCachePathRetrieval(@NonNull Context context) {
        return new a(context);
    }

    private static String getDirectoryFromFuture(Future<String> future, PathRetrieval pathRetrieval) {
        if (future == null) {
            Log.w(LOG_TAG, "Cache and file paths are not initialized. The HERE SDK is calling PlatformUtilsInitializer.startAsyncPathLoader() to asynchronously initialize the paths in background. Consider to call this earlier to speed up start-up time.");
            return pathRetrieval.getPath();
        }
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.w(LOG_TAG, "Failed to retrieve directory path in background thread, falling back to sync approach", e);
            return pathRetrieval.getPath();
        }
    }

    private static PathRetrieval getFilesPathRetrieval(@NonNull Context context) {
        return new b(context);
    }

    public static void initialize(@NonNull Context context) {
        PlatformUtils.setPlatformInformation(new PlatformUtils.PlatformInformation("Android", Build.VERSION.RELEASE, getDirectoryFromFuture(mFutureFilesDir, getFilesPathRetrieval(context)), getDirectoryFromFuture(mFutureCacheDir, getCachePathRetrieval(context))));
        AndroidAssetsLoader androidAssetsLoader = new AndroidAssetsLoader(context);
        PlatformUtils.setAssetsLoader(ApiConstant.COMPONENT, androidAssetsLoader);
        PlatformUtils.setAssetsLoader("mapview-harp", androidAssetsLoader);
        PlatformUtils.setAssetsLoader(VuiModelType.NAVIGATION, androidAssetsLoader);
        PlatformUtils.setAssetsLoader("traffic-broadcast", androidAssetsLoader);
        PlatformUtils.setConnectivityStatusNotifier(AndroidConnectivityStatusNotifier.make(context));
        PlatformUtils.setLocaleFactory(new AndroidLocaleFactory());
        PlatformUtils.setProcessKiller(new AndroidProcessKiller());
        PlatformUtils.setOptionalModulesInitializer(new AndroidOptionalModulesInitializer());
        PlatformUtils.setCAresInitialiserBridge(new AndroidCAresInitialiserBridge());
        PlatformUtils.setAndroidContext(context);
        mExecutorService = null;
    }

    public static void startAsyncPathLoader(@NonNull Context context) {
        if (mFutureCacheDir != null) {
            Log.w(LOG_TAG, "Attempt to call PlatformUtilsInitializer.startAsyncPathLoader() twice is detected, skipping.");
            return;
        }
        mFutureFilesDir = mExecutorService.submit(new a(context));
        mFutureCacheDir = mExecutorService.submit(new b(context));
        mExecutorService.shutdown();
    }
}
