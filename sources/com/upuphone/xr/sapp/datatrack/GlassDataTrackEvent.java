package com.upuphone.xr.sapp.datatrack;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0017\u0010\u0017\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0004R\u0017\u0010\u001a\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0004R#\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010)\u001a\u00020$8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/GlassDataTrackEvent;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Z", "get_debug_", "()Z", "_debug_", "b", "Ljava/lang/String;", "get_event_type_", "_event_type_", "c", "get_event_name_", "_event_name_", "d", "get_page_", "_page_", "e", "get_referrer_page_", "_referrer_page_", "", "f", "Ljava/util/Map;", "get_event_attr_value_", "()Ljava/util/Map;", "_event_attr_value_", "", "g", "J", "get_event_time_", "()J", "_event_time_", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GlassDataTrackEvent {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f6917a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final Map f;
    public final long g;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassDataTrackEvent)) {
            return false;
        }
        GlassDataTrackEvent glassDataTrackEvent = (GlassDataTrackEvent) obj;
        return this.f6917a == glassDataTrackEvent.f6917a && Intrinsics.areEqual((Object) this.b, (Object) glassDataTrackEvent.b) && Intrinsics.areEqual((Object) this.c, (Object) glassDataTrackEvent.c) && Intrinsics.areEqual((Object) this.d, (Object) glassDataTrackEvent.d) && Intrinsics.areEqual((Object) this.e, (Object) glassDataTrackEvent.e) && Intrinsics.areEqual((Object) this.f, (Object) glassDataTrackEvent.f) && this.g == glassDataTrackEvent.g;
    }

    public int hashCode() {
        int hashCode = ((((((Boolean.hashCode(this.f6917a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        String str = this.e;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f.hashCode()) * 31) + Long.hashCode(this.g);
    }

    public String toString() {
        boolean z = this.f6917a;
        String str = this.b;
        String str2 = this.c;
        String str3 = this.d;
        String str4 = this.e;
        Map map = this.f;
        long j = this.g;
        return "GlassDataTrackEvent(_debug_=" + z + ", _event_type_=" + str + ", _event_name_=" + str2 + ", _page_=" + str3 + ", _referrer_page_=" + str4 + ", _event_attr_value_=" + map + ", _event_time_=" + j + ")";
    }
}
