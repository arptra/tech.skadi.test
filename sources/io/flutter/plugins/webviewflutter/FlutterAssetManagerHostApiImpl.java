package io.flutter.plugins.webviewflutter;

import androidx.annotation.NonNull;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlutterAssetManagerHostApiImpl implements GeneratedAndroidWebView.FlutterAssetManagerHostApi {
    final FlutterAssetManager flutterAssetManager;

    public FlutterAssetManagerHostApiImpl(@NonNull FlutterAssetManager flutterAssetManager2) {
        this.flutterAssetManager = flutterAssetManager2;
    }

    @NonNull
    public String getAssetFilePathByName(@NonNull String str) {
        return this.flutterAssetManager.getAssetFilePathByName(str);
    }

    @NonNull
    public List<String> list(@NonNull String str) {
        try {
            String[] list = this.flutterAssetManager.list(str);
            return list == null ? new ArrayList() : Arrays.asList(list);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
