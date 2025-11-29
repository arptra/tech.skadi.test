package com.here.sdk.search;

import androidx.annotation.Nullable;
import com.here.NativeBase;
import java.util.List;

class SuggestCallbackExtendedImpl extends NativeBase implements SuggestCallbackExtended {
    public SuggestCallbackExtendedImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SuggestCallbackExtendedImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onSuggestExtendedCompleted(@Nullable SearchError searchError, @Nullable List<Suggestion> list, @Nullable ResponseDetails responseDetails);
}
