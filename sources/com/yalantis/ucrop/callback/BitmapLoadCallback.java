package com.yalantis.ucrop.callback;

import android.graphics.Bitmap;
import android.net.Uri;
import com.yalantis.ucrop.model.ExifInfo;

public interface BitmapLoadCallback {
    void a(Bitmap bitmap, ExifInfo exifInfo, Uri uri, Uri uri2);

    void onFailure(Exception exc);
}
