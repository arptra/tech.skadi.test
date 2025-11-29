package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.routing.PostAction;
import java.util.List;

class PostActionListenerImpl extends NativeBase implements PostActionListener {
    public PostActionListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                PostActionListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onPostActions(@NonNull List<PostAction> list);
}
