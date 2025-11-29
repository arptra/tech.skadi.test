package com.upuphone.xr.audio.record.ai.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0012\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/audio/record/ai/bean/AiFeedBackRequest;", "", "", "feedbackType", "", "traceId", "contentValue", "requestId", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "b", "Ljava/lang/String;", "d", "c", "lib_audio_record_release"}, k = 1, mv = {1, 9, 0})
public final class AiFeedBackRequest {

    /* renamed from: a  reason: collision with root package name */
    public final int f6557a;
    public final String b;
    public final String c;
    public final String d;

    public AiFeedBackRequest(int i, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "traceId");
        Intrinsics.checkNotNullParameter(str2, "contentValue");
        Intrinsics.checkNotNullParameter(str3, "requestId");
        this.f6557a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public final String a() {
        return this.c;
    }

    public final int b() {
        return this.f6557a;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AiFeedBackRequest)) {
            return false;
        }
        AiFeedBackRequest aiFeedBackRequest = (AiFeedBackRequest) obj;
        return this.f6557a == aiFeedBackRequest.f6557a && Intrinsics.areEqual((Object) this.b, (Object) aiFeedBackRequest.b) && Intrinsics.areEqual((Object) this.c, (Object) aiFeedBackRequest.c) && Intrinsics.areEqual((Object) this.d, (Object) aiFeedBackRequest.d);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f6557a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        int i = this.f6557a;
        String str = this.b;
        String str2 = this.c;
        String str3 = this.d;
        return "AiFeedBackRequest(feedbackType=" + i + ", traceId=" + str + ", contentValue=" + str2 + ", requestId=" + str3 + ")";
    }
}
