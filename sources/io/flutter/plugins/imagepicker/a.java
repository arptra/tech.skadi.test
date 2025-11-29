package io.flutter.plugins.imagepicker;

import io.flutter.plugins.imagepicker.ImagePickerDelegate;

public final /* synthetic */ class a implements ImagePickerDelegate.OnPathReadyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate f8809a;

    public /* synthetic */ a(ImagePickerDelegate imagePickerDelegate) {
        this.f8809a = imagePickerDelegate;
    }

    public final void onPathReady(String str) {
        this.f8809a.lambda$handleCaptureImageResult$6(str);
    }
}
