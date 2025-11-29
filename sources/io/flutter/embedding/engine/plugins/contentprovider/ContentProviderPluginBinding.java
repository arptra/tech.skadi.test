package io.flutter.embedding.engine.plugins.contentprovider;

import android.content.ContentProvider;
import androidx.annotation.NonNull;

public interface ContentProviderPluginBinding {
    @NonNull
    ContentProvider getContentProvider();
}
