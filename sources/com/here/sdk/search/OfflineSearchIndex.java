package com.here.sdk.search;

import com.here.NativeBase;

public final class OfflineSearchIndex extends NativeBase {

    public enum Error {
        INVALID_PERSISTENT_PATH(0),
        MAP_ERROR(1),
        DATABASE_ERROR(2),
        OPERATION_CANCELLED(3),
        INTERNAL_ERROR(4);
        
        public final int value;

        private Error(int i) {
            this.value = i;
        }
    }

    public enum Operation {
        CREATING(0),
        REMOVING(1);
        
        public final int value;

        private Operation(int i) {
            this.value = i;
        }
    }

    public static final class Options {
        public boolean enabled = true;
    }

    public OfflineSearchIndex(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                OfflineSearchIndex.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);
}
