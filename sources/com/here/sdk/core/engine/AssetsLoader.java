package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import java.util.List;

interface AssetsLoader {
    boolean checkAssetAvailability(@NonNull String str);

    @NonNull
    String getAssetsPath();

    @NonNull
    List<String> getSubfolderNames(@NonNull String str);

    @NonNull
    String loadAsset(@NonNull String str);

    @NonNull
    byte[] loadAssetBlob(@NonNull String str);
}
