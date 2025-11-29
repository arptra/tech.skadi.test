package io.flutter.plugins.webviewflutter;

import android.webkit.WebStorage;
import androidx.annotation.NonNull;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.Objects;

public class WebStorageHostApiImpl implements GeneratedAndroidWebView.WebStorageHostApi {
    private final InstanceManager instanceManager;
    private final WebStorageCreator webStorageCreator;

    public static class WebStorageCreator {
        @NonNull
        public WebStorage createWebStorage() {
            return WebStorage.getInstance();
        }
    }

    public WebStorageHostApiImpl(@NonNull InstanceManager instanceManager2, @NonNull WebStorageCreator webStorageCreator2) {
        this.instanceManager = instanceManager2;
        this.webStorageCreator = webStorageCreator2;
    }

    public void create(@NonNull Long l) {
        this.instanceManager.addDartCreatedInstance(this.webStorageCreator.createWebStorage(), l.longValue());
    }

    public void deleteAllData(@NonNull Long l) {
        WebStorage webStorage = (WebStorage) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webStorage);
        webStorage.deleteAllData();
    }
}
