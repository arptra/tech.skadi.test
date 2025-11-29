package io.flutter.app;

import androidx.annotation.CallSuper;
import com.google.android.play.core.splitcompat.SplitCompatApplication;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.deferredcomponents.PlayStoreDeferredComponentManager;

public class FlutterPlayStoreSplitApplication extends SplitCompatApplication {
    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, com.google.android.play.core.splitcompat.SplitCompatApplication, io.flutter.app.FlutterPlayStoreSplitApplication] */
    @CallSuper
    public void onCreate() {
        FlutterPlayStoreSplitApplication.super.onCreate();
        FlutterInjector.setInstance(new FlutterInjector.Builder().setDeferredComponentManager(new PlayStoreDeferredComponentManager(this, (FlutterJNI) null)).build());
    }
}
