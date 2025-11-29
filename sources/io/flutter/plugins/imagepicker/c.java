package io.flutter.plugins.imagepicker;

import android.media.MediaScannerConnection;
import android.net.Uri;
import io.flutter.plugins.imagepicker.ImagePickerDelegate;

public final /* synthetic */ class c implements MediaScannerConnection.OnScanCompletedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate.OnPathReadyListener f8811a;

    public /* synthetic */ c(ImagePickerDelegate.OnPathReadyListener onPathReadyListener) {
        this.f8811a = onPathReadyListener;
    }

    public final void onScanCompleted(String str, Uri uri) {
        this.f8811a.onPathReady(str);
    }
}
