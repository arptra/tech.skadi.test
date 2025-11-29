package io.flutter.embedding.engine.plugins.contentprovider;

import androidx.annotation.NonNull;

public interface ContentProviderAware {
    void onAttachedToContentProvider(@NonNull ContentProviderPluginBinding contentProviderPluginBinding);

    void onDetachedFromContentProvider();
}
