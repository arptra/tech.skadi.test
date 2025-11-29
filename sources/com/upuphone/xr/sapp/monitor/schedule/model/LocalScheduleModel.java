package com.upuphone.xr.sapp.monitor.schedule.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001c\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u001bR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u001c\u0010\u001bR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010(\u001a\u0004\b\u001d\u0010)\"\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/LocalScheduleModel;", "", "", "id", "displayName", "displayColor", "", "isOpen", "Lcom/upuphone/xr/sapp/monitor/schedule/model/SubscribeType;", "subscribeType", "Lcom/upuphone/xr/sapp/monitor/schedule/model/RemoteCalendarModel;", "remoteCalendarModel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/upuphone/xr/sapp/monitor/schedule/model/SubscribeType;Lcom/upuphone/xr/sapp/monitor/schedule/model/RemoteCalendarModel;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "c", "b", "h", "(Ljava/lang/String;)V", "g", "d", "Z", "f", "()Z", "i", "(Z)V", "e", "Lcom/upuphone/xr/sapp/monitor/schedule/model/SubscribeType;", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/SubscribeType;", "k", "(Lcom/upuphone/xr/sapp/monitor/schedule/model/SubscribeType;)V", "Lcom/upuphone/xr/sapp/monitor/schedule/model/RemoteCalendarModel;", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/RemoteCalendarModel;", "j", "(Lcom/upuphone/xr/sapp/monitor/schedule/model/RemoteCalendarModel;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class LocalScheduleModel {

    /* renamed from: a  reason: collision with root package name */
    public final String f7791a;
    public String b;
    public String c;
    public boolean d;
    public SubscribeType e;
    public RemoteCalendarModel f;

    public LocalScheduleModel(String str, String str2, String str3, boolean z, SubscribeType subscribeType, RemoteCalendarModel remoteCalendarModel) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "displayName");
        Intrinsics.checkNotNullParameter(str3, "displayColor");
        Intrinsics.checkNotNullParameter(subscribeType, "subscribeType");
        this.f7791a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
        this.e = subscribeType;
        this.f = remoteCalendarModel;
    }

    public final String a() {
        return this.c;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.f7791a;
    }

    public final RemoteCalendarModel d() {
        return this.f;
    }

    public final SubscribeType e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalScheduleModel)) {
            return false;
        }
        LocalScheduleModel localScheduleModel = (LocalScheduleModel) obj;
        return Intrinsics.areEqual((Object) this.f7791a, (Object) localScheduleModel.f7791a) && Intrinsics.areEqual((Object) this.b, (Object) localScheduleModel.b) && Intrinsics.areEqual((Object) this.c, (Object) localScheduleModel.c) && this.d == localScheduleModel.d && this.e == localScheduleModel.e && Intrinsics.areEqual((Object) this.f, (Object) localScheduleModel.f);
    }

    public final boolean f() {
        return this.d;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f7791a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode()) * 31;
        RemoteCalendarModel remoteCalendarModel = this.f;
        return hashCode + (remoteCalendarModel == null ? 0 : remoteCalendarModel.hashCode());
    }

    public final void i(boolean z) {
        this.d = z;
    }

    public final void j(RemoteCalendarModel remoteCalendarModel) {
        this.f = remoteCalendarModel;
    }

    public final void k(SubscribeType subscribeType) {
        Intrinsics.checkNotNullParameter(subscribeType, "<set-?>");
        this.e = subscribeType;
    }

    public String toString() {
        String str = this.f7791a;
        String str2 = this.b;
        String str3 = this.c;
        boolean z = this.d;
        SubscribeType subscribeType = this.e;
        RemoteCalendarModel remoteCalendarModel = this.f;
        return "LocalScheduleModel(id=" + str + ", displayName=" + str2 + ", displayColor=" + str3 + ", isOpen=" + z + ", subscribeType=" + subscribeType + ", remoteCalendarModel=" + remoteCalendarModel + ")";
    }
}
