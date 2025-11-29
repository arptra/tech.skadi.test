package io.ktor.util.date;

import com.meizu.common.datetimepicker.date.MonthView;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.time.TimeZones;

@Metadata(d1 = {"\u0000.\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a=\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000e\u001a\u001b\u0010\u0010\u001a\u00020\u0002*\u00020\u000f2\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0013\"\u001c\u0010\u0017\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0016¨\u0006\u0018"}, d2 = {"", "timestamp", "Lio/ktor/util/date/GMTDate;", "b", "(Ljava/lang/Long;)Lio/ktor/util/date/GMTDate;", "", "seconds", "minutes", "hours", "dayOfMonth", "Lio/ktor/util/date/Month;", "month", "year", "a", "(IIIILio/ktor/util/date/Month;I)Lio/ktor/util/date/GMTDate;", "Ljava/util/Calendar;", "e", "(Ljava/util/Calendar;Ljava/lang/Long;)Lio/ktor/util/date/GMTDate;", "d", "()J", "Ljava/util/TimeZone;", "kotlin.jvm.PlatformType", "Ljava/util/TimeZone;", "GMT_TIMEZONE", "ktor-utils"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nDateJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DateJvm.kt\nio/ktor/util/date/DateJvmKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,78:1\n1#2:79\n*E\n"})
public final class DateJvmKt {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeZone f9048a = TimeZone.getTimeZone(TimeZones.GMT_ID);

    public static final GMTDate a(int i, int i2, int i3, int i4, Month month, int i5) {
        Intrinsics.checkNotNullParameter(month, MonthView.VIEW_PARAMS_MONTH);
        Calendar instance = Calendar.getInstance(f9048a, Locale.ROOT);
        Intrinsics.checkNotNull(instance);
        instance.set(1, i5);
        instance.set(2, month.ordinal());
        instance.set(5, i4);
        instance.set(11, i3);
        instance.set(12, i2);
        instance.set(13, i);
        instance.set(14, 0);
        return e(instance, (Long) null);
    }

    public static final GMTDate b(Long l) {
        Calendar instance = Calendar.getInstance(f9048a, Locale.ROOT);
        Intrinsics.checkNotNull(instance);
        return e(instance, l);
    }

    public static /* synthetic */ GMTDate c(Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return b(l);
    }

    public static final long d() {
        return System.currentTimeMillis();
    }

    public static final GMTDate e(Calendar calendar, Long l) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        int i = calendar.get(15) + calendar.get(16);
        return new GMTDate(calendar.get(13), calendar.get(12), calendar.get(11), WeekDay.Companion.a((calendar.get(7) + 5) % 7), calendar.get(5), calendar.get(6), Month.Companion.a(calendar.get(2)), calendar.get(1), calendar.getTimeInMillis() + ((long) i));
    }
}
