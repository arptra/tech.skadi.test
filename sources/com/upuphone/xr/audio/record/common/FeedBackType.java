package com.upuphone.xr.audio.record.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\u0019R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b\u0011\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/audio/record/common/FeedBackType;", "", "", "type", "", "typeContent", "", "selectState", "<init>", "(ILjava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "I", "b", "setType", "(I)V", "Ljava/lang/String;", "c", "setTypeContent", "(Ljava/lang/String;)V", "Z", "()Z", "d", "(Z)V", "lib_audio_record_release"}, k = 1, mv = {1, 9, 0})
public final class FeedBackType {

    /* renamed from: a  reason: collision with root package name */
    public int f6562a;
    public String b;
    public boolean c;

    public FeedBackType(int i, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "typeContent");
        this.f6562a = i;
        this.b = str;
        this.c = z;
    }

    public final boolean a() {
        return this.c;
    }

    public final int b() {
        return this.f6562a;
    }

    public final String c() {
        return this.b;
    }

    public final void d(boolean z) {
        this.c = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedBackType)) {
            return false;
        }
        FeedBackType feedBackType = (FeedBackType) obj;
        return this.f6562a == feedBackType.f6562a && Intrinsics.areEqual((Object) this.b, (Object) feedBackType.b) && this.c == feedBackType.c;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f6562a) * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        int i = this.f6562a;
        String str = this.b;
        boolean z = this.c;
        return "FeedBackType(type=" + i + ", typeContent=" + str + ", selectState=" + z + ")";
    }
}
