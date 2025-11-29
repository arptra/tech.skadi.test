package com.upuphone.xr.audio.record.ai.bean;

import com.upuphone.starrynet.payload.PayloadConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/audio/record/ai/bean/AiFeedBackResponse;", "", "", "code", "", "msg", "", "data", "<init>", "(ILjava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "I", "b", "Ljava/lang/String;", "c", "Z", "()Z", "lib_audio_record_release"}, k = 1, mv = {1, 9, 0})
public final class AiFeedBackResponse {

    /* renamed from: a  reason: collision with root package name */
    public final int f6558a;
    public final String b;
    public final boolean c;

    public AiFeedBackResponse(int i, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        this.f6558a = i;
        this.b = str;
        this.c = z;
    }

    public final int a() {
        return this.f6558a;
    }

    public final boolean b() {
        return this.c;
    }

    public final String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AiFeedBackResponse)) {
            return false;
        }
        AiFeedBackResponse aiFeedBackResponse = (AiFeedBackResponse) obj;
        return this.f6558a == aiFeedBackResponse.f6558a && Intrinsics.areEqual((Object) this.b, (Object) aiFeedBackResponse.b) && this.c == aiFeedBackResponse.c;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f6558a) * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        int i = this.f6558a;
        String str = this.b;
        boolean z = this.c;
        return "AiFeedBackResponse(code=" + i + ", msg=" + str + ", data=" + z + ")";
    }
}
