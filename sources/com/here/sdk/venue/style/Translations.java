package com.here.sdk.venue.style;

import androidx.annotation.NonNull;
import com.here.NativeBase;

final class Translations extends NativeBase {
    public Translations(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Translations.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void addTranslation(@NonNull String str, @NonNull String str2, @NonNull String str3);

    @NonNull
    public native String getTranslation(@NonNull String str, @NonNull String str2);
}
