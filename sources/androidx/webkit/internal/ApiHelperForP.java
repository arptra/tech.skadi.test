package androidx.webkit.internal;

import android.os.Looper;
import android.webkit.TracingConfig;
import android.webkit.TracingController;
import android.webkit.WebView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.webkit.TracingConfig;
import java.io.OutputStream;
import java.util.concurrent.Executor;

@RequiresApi
public class ApiHelperForP {
    @DoNotInline
    @NonNull
    public static TracingController a() {
        return TracingController.getInstance();
    }

    @DoNotInline
    @NonNull
    public static ClassLoader b() {
        return WebView.getWebViewClassLoader();
    }

    @DoNotInline
    @NonNull
    public static Looper c(@NonNull WebView webView) {
        return webView.getWebViewLooper();
    }

    @DoNotInline
    public static boolean d(@NonNull TracingController tracingController) {
        return tracingController.isTracing();
    }

    @DoNotInline
    public static void e(@NonNull String str) {
        WebView.setDataDirectorySuffix(str);
    }

    @DoNotInline
    public static void f(@NonNull TracingController tracingController, @NonNull TracingConfig tracingConfig) {
        tracingController.start(new TracingConfig.Builder().addCategories(new int[]{tracingConfig.b()}).addCategories(tracingConfig.a()).setTracingMode(tracingConfig.c()).build());
    }

    @DoNotInline
    public static boolean g(@NonNull TracingController tracingController, @Nullable OutputStream outputStream, @NonNull Executor executor) {
        return tracingController.stop(outputStream, executor);
    }
}
