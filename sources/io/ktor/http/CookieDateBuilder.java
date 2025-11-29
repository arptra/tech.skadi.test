package io.ktor.http;

import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.util.date.Month;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u0015\u0010\fR$\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010 \u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\b\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\f¨\u0006!"}, d2 = {"Lio/ktor/http/CookieDateBuilder;", "", "<init>", "()V", "Lio/ktor/util/date/GMTDate;", "a", "()Lio/ktor/util/date/GMTDate;", "", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "l", "(Ljava/lang/Integer;)V", "seconds", "b", "d", "j", "minutes", "c", "i", "hours", "h", "dayOfMonth", "Lio/ktor/util/date/Month;", "e", "Lio/ktor/util/date/Month;", "()Lio/ktor/util/date/Month;", "k", "(Lio/ktor/util/date/Month;)V", "month", "g", "m", "year", "ktor-http"}, k = 1, mv = {1, 8, 0})
public final class CookieDateBuilder {

    /* renamed from: a  reason: collision with root package name */
    public Integer f8954a;
    public Integer b;
    public Integer c;
    public Integer d;
    public Month e;
    public Integer f;

    public final GMTDate a() {
        Integer num = this.f8954a;
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
        Month month = this.e;
        Intrinsics.checkNotNull(month);
        Integer num5 = this.f;
        Intrinsics.checkNotNull(num5);
        return DateJvmKt.a(intValue, intValue2, intValue3, intValue4, month, num5.intValue());
    }

    public final Integer b() {
        return this.d;
    }

    public final Integer c() {
        return this.c;
    }

    public final Integer d() {
        return this.b;
    }

    public final Month e() {
        return this.e;
    }

    public final Integer f() {
        return this.f8954a;
    }

    public final Integer g() {
        return this.f;
    }

    public final void h(Integer num) {
        this.d = num;
    }

    public final void i(Integer num) {
        this.c = num;
    }

    public final void j(Integer num) {
        this.b = num;
    }

    public final void k(Month month) {
        this.e = month;
    }

    public final void l(Integer num) {
        this.f8954a = num;
    }

    public final void m(Integer num) {
        this.f = num;
    }
}
