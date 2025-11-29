package com.here.sdk.venue.data;

import androidx.annotation.NonNull;
import com.here.NativeBase;

public final class Property extends NativeBase {

    public enum PropertyType {
        BOOL(0),
        INT(1),
        STRING(2);
        
        public final int value;

        private PropertyType(int i) {
            this.value = i;
        }
    }

    public Property(boolean z) {
        this(fromBool(z), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long fromBool(boolean z);

    private static native long fromInt(int i);

    private static native long fromString(@NonNull String str);

    public native int getInt();

    @NonNull
    public native String getString();

    @NonNull
    public native PropertyType getType();

    public native boolean isBool();

    @NonNull
    public native String toString();

    public Property(int i) {
        this(fromInt(i), (Object) null);
        cacheThisInstance();
    }

    public Property(@NonNull String str) {
        this(fromString(str), (Object) null);
        cacheThisInstance();
    }

    public Property(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Property.disposeNativeHandle(j);
            }
        });
    }
}
