package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import java.util.List;
import java.util.Map;

public final class Suggestion extends NativeBase {
    public Suggestion(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Suggestion.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native Map<HighlightType, List<IndexRange>> getHighlights();

    @Nullable
    public native String getHref();

    @Nullable
    public native String getId();

    @Nullable
    public native Place getPlace();

    @NonNull
    public native String getTitle();

    @NonNull
    public native SuggestionType getType();
}
