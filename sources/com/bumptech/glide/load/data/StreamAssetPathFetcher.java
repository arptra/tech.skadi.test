package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import java.io.InputStream;

public class StreamAssetPathFetcher extends AssetPathFetcher<InputStream> {
    public StreamAssetPathFetcher(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    public Class a() {
        return InputStream.class;
    }

    /* renamed from: g */
    public void e(InputStream inputStream) {
        inputStream.close();
    }

    /* renamed from: h */
    public InputStream f(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }
}
