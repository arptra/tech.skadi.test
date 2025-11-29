package com.upuphone.ar.tici.phone.data;

import com.upuphone.ar.tici.phone.db.entity.TiciContentPart;
import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001a\u0010$\u001a\u0004\b\u001c\u0010\u0013R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\"\u0010$\u001a\u0004\b\u0018\u0010\u0013R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u001e\u0010%\u001a\u0004\b \u0010&¨\u0006'"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/OpenTiciConfig;", "", "Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsg;", "openTiciMsg", "Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "ticiEntity", "Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;", "ticiContentPart", "", "currentPage", "currentIndex", "Lcom/upuphone/ar/tici/phone/data/OpenTiciFrom;", "from", "<init>", "(Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsg;Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;IILcom/upuphone/ar/tici/phone/data/OpenTiciFrom;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsg;", "d", "()Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsg;", "b", "Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "f", "()Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "c", "Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;", "e", "()Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;", "I", "Lcom/upuphone/ar/tici/phone/data/OpenTiciFrom;", "()Lcom/upuphone/ar/tici/phone/data/OpenTiciFrom;", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class OpenTiciConfig {

    /* renamed from: a  reason: collision with root package name */
    public final OpenTiciMsg f5913a;
    public final TiciEntity b;
    public final TiciContentPart c;
    public final int d;
    public final int e;
    public final OpenTiciFrom f;

    public OpenTiciConfig(OpenTiciMsg openTiciMsg, TiciEntity ticiEntity, TiciContentPart ticiContentPart, int i, int i2, OpenTiciFrom openTiciFrom) {
        Intrinsics.checkNotNullParameter(openTiciMsg, "openTiciMsg");
        Intrinsics.checkNotNullParameter(ticiEntity, "ticiEntity");
        Intrinsics.checkNotNullParameter(ticiContentPart, "ticiContentPart");
        Intrinsics.checkNotNullParameter(openTiciFrom, "from");
        this.f5913a = openTiciMsg;
        this.b = ticiEntity;
        this.c = ticiContentPart;
        this.d = i;
        this.e = i2;
        this.f = openTiciFrom;
    }

    public final int a() {
        return this.e;
    }

    public final int b() {
        return this.d;
    }

    public final OpenTiciFrom c() {
        return this.f;
    }

    public final OpenTiciMsg d() {
        return this.f5913a;
    }

    public final TiciContentPart e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenTiciConfig)) {
            return false;
        }
        OpenTiciConfig openTiciConfig = (OpenTiciConfig) obj;
        return Intrinsics.areEqual((Object) this.f5913a, (Object) openTiciConfig.f5913a) && Intrinsics.areEqual((Object) this.b, (Object) openTiciConfig.b) && Intrinsics.areEqual((Object) this.c, (Object) openTiciConfig.c) && this.d == openTiciConfig.d && this.e == openTiciConfig.e && this.f == openTiciConfig.f;
    }

    public final TiciEntity f() {
        return this.b;
    }

    public int hashCode() {
        return (((((((((this.f5913a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + this.f.hashCode();
    }

    public String toString() {
        OpenTiciMsg openTiciMsg = this.f5913a;
        TiciEntity ticiEntity = this.b;
        TiciContentPart ticiContentPart = this.c;
        int i = this.d;
        int i2 = this.e;
        OpenTiciFrom openTiciFrom = this.f;
        return "OpenTiciConfig(openTiciMsg=" + openTiciMsg + ", ticiEntity=" + ticiEntity + ", ticiContentPart=" + ticiContentPart + ", currentPage=" + i + ", currentIndex=" + i2 + ", from=" + openTiciFrom + ")";
    }
}
