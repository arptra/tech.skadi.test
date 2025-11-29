package com.here.sdk.search;

import androidx.annotation.Nullable;
import com.here.NativeBase;
import java.util.List;

class SuggestCallbackImpl extends NativeBase implements SuggestCallback {
    public SuggestCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SuggestCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onSuggestCompleted(@Nullable SearchError searchError, @Nullable List<Suggestion> list);
}
