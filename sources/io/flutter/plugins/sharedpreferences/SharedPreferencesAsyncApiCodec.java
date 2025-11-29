package io.flutter.plugins.sharedpreferences;

import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0014¨\u0006\u000e"}, d2 = {"Lio/flutter/plugins/sharedpreferences/SharedPreferencesAsyncApiCodec;", "Lio/flutter/plugin/common/StandardMessageCodec;", "()V", "readValueOfType", "", "type", "", "buffer", "Ljava/nio/ByteBuffer;", "writeValue", "", "stream", "Ljava/io/ByteArrayOutputStream;", "value", "shared_preferences_android_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class SharedPreferencesAsyncApiCodec extends StandardMessageCodec {
    @NotNull
    public static final SharedPreferencesAsyncApiCodec INSTANCE = new SharedPreferencesAsyncApiCodec();

    private SharedPreferencesAsyncApiCodec() {
    }

    @Nullable
    public Object readValueOfType(byte b, @NotNull ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        if (b != Byte.MIN_VALUE) {
            return super.readValueOfType(b, byteBuffer);
        }
        Object readValue = readValue(byteBuffer);
        List list = readValue instanceof List ? (List) readValue : null;
        if (list != null) {
            return SharedPreferencesPigeonOptions.Companion.fromList(list);
        }
        return null;
    }

    public void writeValue(@NotNull ByteArrayOutputStream byteArrayOutputStream, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(byteArrayOutputStream, "stream");
        if (obj instanceof SharedPreferencesPigeonOptions) {
            byteArrayOutputStream.write(128);
            writeValue(byteArrayOutputStream, ((SharedPreferencesPigeonOptions) obj).toList());
            return;
        }
        super.writeValue(byteArrayOutputStream, obj);
    }
}
