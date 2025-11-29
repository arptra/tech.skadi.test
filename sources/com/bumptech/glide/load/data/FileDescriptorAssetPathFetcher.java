package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;

public class FileDescriptorAssetPathFetcher extends AssetPathFetcher<AssetFileDescriptor> {
    public FileDescriptorAssetPathFetcher(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    public Class a() {
        return AssetFileDescriptor.class;
    }

    /* renamed from: g */
    public void e(AssetFileDescriptor assetFileDescriptor) {
        assetFileDescriptor.close();
    }

    /* renamed from: h */
    public AssetFileDescriptor f(AssetManager assetManager, String str) {
        return assetManager.openFd(str);
    }
}
