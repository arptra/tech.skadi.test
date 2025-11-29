package io.flutter.plugins.webviewflutter;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.io.IOException;

abstract class FlutterAssetManager {
    final AssetManager assetManager;

    public static class PluginBindingFlutterAssetManager extends FlutterAssetManager {
        final FlutterPlugin.FlutterAssets flutterAssets;

        public PluginBindingFlutterAssetManager(AssetManager assetManager, FlutterPlugin.FlutterAssets flutterAssets2) {
            super(assetManager);
            this.flutterAssets = flutterAssets2;
        }

        public String getAssetFilePathByName(String str) {
            return this.flutterAssets.getAssetFilePathByName(str);
        }
    }

    public FlutterAssetManager(AssetManager assetManager2) {
        this.assetManager = assetManager2;
    }

    public abstract String getAssetFilePathByName(String str);

    public String[] list(@NonNull String str) throws IOException {
        return this.assetManager.list(str);
    }
}
