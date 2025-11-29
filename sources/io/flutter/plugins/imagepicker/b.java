package io.flutter.plugins.imagepicker;

import io.flutter.plugins.imagepicker.ImagePickerDelegate;

public final /* synthetic */ class b implements ImagePickerDelegate.OnPathReadyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate f8810a;

    public /* synthetic */ b(ImagePickerDelegate imagePickerDelegate) {
        this.f8810a = imagePickerDelegate;
    }

    public final void onPathReady(String str) {
        this.f8810a.finishWithSuccess(str);
    }
}
