package com.upuphone.xr.sapp.monitor.schedule.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0017\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/RemoteCalendarModel;", "", "", "accessToken", "refreshToken", "unionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "b", "d", "getUnionId", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class RemoteCalendarModel {

    /* renamed from: a  reason: collision with root package name */
    public String f7792a;
    public String b;
    public final String c;

    public RemoteCalendarModel(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "accessToken");
        Intrinsics.checkNotNullParameter(str2, "refreshToken");
        Intrinsics.checkNotNullParameter(str3, "unionId");
        this.f7792a = str;
        this.b = str2;
        this.c = str3;
    }

    public final String a() {
        return this.f7792a;
    }

    public final String b() {
        return this.b;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f7792a = str;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteCalendarModel)) {
            return false;
        }
        RemoteCalendarModel remoteCalendarModel = (RemoteCalendarModel) obj;
        return Intrinsics.areEqual((Object) this.f7792a, (Object) remoteCalendarModel.f7792a) && Intrinsics.areEqual((Object) this.b, (Object) remoteCalendarModel.b) && Intrinsics.areEqual((Object) this.c, (Object) remoteCalendarModel.c);
    }

    public int hashCode() {
        return (((this.f7792a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        String str = this.f7792a;
        String str2 = this.b;
        String str3 = this.c;
        return "RemoteCalendarModel(accessToken=" + str + ", refreshToken=" + str2 + ", unionId=" + str3 + ")";
    }
}
