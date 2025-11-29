package com.luck.picture.lib.basic;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;

public class PictureMediaScannerConnection implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a  reason: collision with root package name */
    public final MediaScannerConnection f9395a;
    public final String b;
    public ScanListener c;

    public interface ScanListener {
        void a();
    }

    public PictureMediaScannerConnection(Context context, String str) {
        this.b = str;
        MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(context.getApplicationContext(), this);
        this.f9395a = mediaScannerConnection;
        mediaScannerConnection.connect();
    }

    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.b)) {
            this.f9395a.scanFile(this.b, (String) null);
        }
    }

    public void onScanCompleted(String str, Uri uri) {
        this.f9395a.disconnect();
        ScanListener scanListener = this.c;
        if (scanListener != null) {
            scanListener.a();
        }
    }
}
