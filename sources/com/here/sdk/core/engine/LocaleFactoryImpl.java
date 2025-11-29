package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import java.util.Locale;

class LocaleFactoryImpl extends NativeBase implements LocaleFactory {
    public LocaleFactoryImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                LocaleFactoryImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @Nullable
    public native Locale getLocaleByBcp47(@NonNull String str);
}
