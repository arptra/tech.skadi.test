package io.ktor.util.date;

import com.meizu.common.datetimepicker.date.MonthView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0012\u0010\fR\"\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u000e\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010 \u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\b\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\f¨\u0006!"}, d2 = {"Lio/ktor/util/date/GMTDateBuilder;", "", "<init>", "()V", "Lio/ktor/util/date/GMTDate;", "a", "()Lio/ktor/util/date/GMTDate;", "", "Ljava/lang/Integer;", "getSeconds", "()Ljava/lang/Integer;", "g", "(Ljava/lang/Integer;)V", "seconds", "b", "getMinutes", "e", "minutes", "c", "getHours", "d", "hours", "getDayOfMonth", "dayOfMonth", "Lio/ktor/util/date/Month;", "Lio/ktor/util/date/Month;", "()Lio/ktor/util/date/Month;", "f", "(Lio/ktor/util/date/Month;)V", "month", "getYear", "h", "year", "ktor-utils"}, k = 1, mv = {1, 8, 0})
public final class GMTDateBuilder {

    /* renamed from: a  reason: collision with root package name */
    public Integer f9050a;
    public Integer b;
    public Integer c;
    public Integer d;
    public Month e;
    public Integer f;

    public final GMTDate a() {
        Integer num = this.f9050a;
        Intrinsics.checkNotNull(num);
        int intValue = num.intValue();
        Integer num2 = this.b;
        Intrinsics.checkNotNull(num2);
        int intValue2 = num2.intValue();
        Integer num3 = this.c;
        Intrinsics.checkNotNull(num3);
        int intValue3 = num3.intValue();
        Integer num4 = this.d;
        Intrinsics.checkNotNull(num4);
        int intValue4 = num4.intValue();
        Month b2 = b();
        Integer num5 = this.f;
        Intrinsics.checkNotNull(num5);
        return DateJvmKt.a(intValue, intValue2, intValue3, intValue4, b2, num5.intValue());
    }

    public final Month b() {
        Month month = this.e;
        if (month != null) {
            return month;
        }
        Intrinsics.throwUninitializedPropertyAccessException(MonthView.VIEW_PARAMS_MONTH);
        return null;
    }

    public final void c(Integer num) {
        this.d = num;
    }

    public final void d(Integer num) {
        this.c = num;
    }

    public final void e(Integer num) {
        this.b = num;
    }

    public final void f(Month month) {
        Intrinsics.checkNotNullParameter(month, "<set-?>");
        this.e = month;
    }

    public final void g(Integer num) {
        this.f9050a = num;
    }

    public final void h(Integer num) {
        this.f = num;
    }
}
