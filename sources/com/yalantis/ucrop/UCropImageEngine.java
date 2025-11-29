package com.yalantis.ucrop;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

public interface UCropImageEngine {

    public interface OnCallbackListener<T> {
    }

    void a(Context context, String str, ImageView imageView);

    void b(Context context, Uri uri, int i, int i2, OnCallbackListener onCallbackListener);
}
