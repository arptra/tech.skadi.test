package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.search.OfflineSearchIndex;

public interface OfflineSearchIndexListener {
    void onComplete(@Nullable OfflineSearchIndex.Error error);

    void onProgress(int i);

    void onStarted(@NonNull OfflineSearchIndex.Operation operation);
}
