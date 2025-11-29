package com.here.sdk.maploader;

import androidx.annotation.Nullable;

@FunctionalInterface
public interface RepairPersistentMapCallback {
    void onCompleted(@Nullable PersistentMapRepairError persistentMapRepairError);
}
