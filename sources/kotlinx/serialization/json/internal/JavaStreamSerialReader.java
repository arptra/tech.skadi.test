package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\n¨\u0006\f"}, d2 = {"Lkotlinx/serialization/json/internal/JavaStreamSerialReader;", "Lkotlinx/serialization/json/internal/InternalJsonReader;", "", "buffer", "", "bufferOffset", "count", "a", "([CII)I", "Lkotlinx/serialization/json/internal/CharsetReader;", "Lkotlinx/serialization/json/internal/CharsetReader;", "reader", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
public final class JavaStreamSerialReader implements InternalJsonReader {

    /* renamed from: a  reason: collision with root package name */
    public final CharsetReader f4104a;

    public int a(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "buffer");
        return this.f4104a.d(cArr, i, i2);
    }
}
