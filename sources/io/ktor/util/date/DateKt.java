package io.ktor.util.date;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u001c\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/util/date/GMTDate;", "", "milliseconds", "a", "(Lio/ktor/util/date/GMTDate;J)Lio/ktor/util/date/GMTDate;", "ktor-utils"}, k = 2, mv = {1, 8, 0})
public final class DateKt {
    public static final GMTDate a(GMTDate gMTDate, long j) {
        Intrinsics.checkNotNullParameter(gMTDate, "<this>");
        return DateJvmKt.b(Long.valueOf(gMTDate.d() + j));
    }
}
