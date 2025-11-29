package com.luck.picture.lib.engine;

import android.content.Context;
import com.luck.picture.lib.interfaces.OnQueryAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;

@Deprecated
public interface ExtendLoaderEngine {
    void a(Context context, OnQueryAllAlbumListener onQueryAllAlbumListener);

    void b(Context context, long j, int i, int i2, int i3, OnQueryDataResultListener onQueryDataResultListener);

    void c(Context context, OnQueryAlbumListener onQueryAlbumListener);

    void d(Context context, long j, int i, int i2, OnQueryDataResultListener onQueryDataResultListener);
}
