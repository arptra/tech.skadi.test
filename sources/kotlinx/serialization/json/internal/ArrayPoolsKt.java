package kotlinx.serialization.json.internal;

import com.here.posclient.PositionEstimate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0004\"\u0014\u0010\u0003\u001a\u00020\u00008\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002¨\u0006\u0004"}, d2 = {"", "a", "I", "MAX_CHARS_IN_POOL", "kotlinx-serialization-json"}, k = 2, mv = {1, 9, 0})
public final class ArrayPoolsKt {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4097a;

    static {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            Intrinsics.checkNotNullExpressionValue(property, "getProperty(...)");
            obj = Result.m20constructorimpl(StringsKt.toIntOrNull(property));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m26isFailureimpl(obj)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        f4097a = num != null ? num.intValue() : PositionEstimate.Value.WLAN_AP_COUNT;
    }
}
