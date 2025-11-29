package io.ktor.util.date;

import com.meizu.common.datetimepicker.date.MonthView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\b\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00015BQ\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u001e\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010\u0018R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010\u0018R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b/\u0010\u001d\u001a\u0004\b0\u0010\u0018R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b#\u00103¨\u00066"}, d2 = {"Lio/ktor/util/date/GMTDate;", "", "", "seconds", "minutes", "hours", "Lio/ktor/util/date/WeekDay;", "dayOfWeek", "dayOfMonth", "dayOfYear", "Lio/ktor/util/date/Month;", "month", "year", "", "timestamp", "<init>", "(IIILio/ktor/util/date/WeekDay;IILio/ktor/util/date/Month;IJ)V", "other", "a", "(Lio/ktor/util/date/GMTDate;)I", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "", "equals", "(Ljava/lang/Object;)Z", "I", "getSeconds", "b", "getMinutes", "c", "getHours", "d", "Lio/ktor/util/date/WeekDay;", "getDayOfWeek", "()Lio/ktor/util/date/WeekDay;", "e", "getDayOfMonth", "f", "getDayOfYear", "g", "Lio/ktor/util/date/Month;", "getMonth", "()Lio/ktor/util/date/Month;", "h", "getYear", "i", "J", "()J", "j", "Companion", "ktor-utils"}, k = 1, mv = {1, 8, 0})
public final class GMTDate implements Comparable<GMTDate> {
    public static final Companion j = new Companion((DefaultConstructorMarker) null);
    public static final GMTDate k = DateJvmKt.b(0L);

    /* renamed from: a  reason: collision with root package name */
    public final int f9049a;
    public final int b;
    public final int c;
    public final WeekDay d;
    public final int e;
    public final int f;
    public final Month g;
    public final int h;
    public final long i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/util/date/GMTDate$Companion;", "", "<init>", "()V", "ktor-utils"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public GMTDate(int i2, int i3, int i4, WeekDay weekDay, int i5, int i6, Month month, int i7, long j2) {
        Intrinsics.checkNotNullParameter(weekDay, "dayOfWeek");
        Intrinsics.checkNotNullParameter(month, MonthView.VIEW_PARAMS_MONTH);
        this.f9049a = i2;
        this.b = i3;
        this.c = i4;
        this.d = weekDay;
        this.e = i5;
        this.f = i6;
        this.g = month;
        this.h = i7;
        this.i = j2;
    }

    /* renamed from: a */
    public int compareTo(GMTDate gMTDate) {
        Intrinsics.checkNotNullParameter(gMTDate, "other");
        return Intrinsics.compare(this.i, gMTDate.i);
    }

    public final long d() {
        return this.i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GMTDate)) {
            return false;
        }
        GMTDate gMTDate = (GMTDate) obj;
        return this.f9049a == gMTDate.f9049a && this.b == gMTDate.b && this.c == gMTDate.c && this.d == gMTDate.d && this.e == gMTDate.e && this.f == gMTDate.f && this.g == gMTDate.g && this.h == gMTDate.h && this.i == gMTDate.i;
    }

    public int hashCode() {
        return (((((((((((((((Integer.hashCode(this.f9049a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31) + Long.hashCode(this.i);
    }

    public String toString() {
        return "GMTDate(seconds=" + this.f9049a + ", minutes=" + this.b + ", hours=" + this.c + ", dayOfWeek=" + this.d + ", dayOfMonth=" + this.e + ", dayOfYear=" + this.f + ", month=" + this.g + ", year=" + this.h + ", timestamp=" + this.i + ')';
    }
}
