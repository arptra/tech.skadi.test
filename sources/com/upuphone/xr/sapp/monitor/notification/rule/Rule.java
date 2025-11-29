package com.upuphone.xr.sapp.monitor.notification.rule;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\t8\u0004X\u0004¢\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/rule/Rule;", "T", "", "<init>", "()V", "data", "", "c", "(Ljava/lang/Object;)Z", "", "a", "()Ljava/lang/String;", "Ljava/lang/String;", "b", "tag", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public abstract class Rule<T> {

    /* renamed from: a  reason: collision with root package name */
    public final String f7774a;

    public Rule() {
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        this.f7774a = name;
    }

    public abstract String a();

    public final String b() {
        return this.f7774a;
    }

    public abstract boolean c(Object obj);
}
