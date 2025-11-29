package com.upuphone.ar.transcribe.ext;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0007R\u0017\u0010\u0015\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/upuphone/ar/transcribe/ext/AudioLogBean;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getCount", "count", "", "b", "J", "getTime", "()J", "time", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AudioLogBean {

    /* renamed from: a  reason: collision with root package name */
    public final int f6064a;
    public final long b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioLogBean)) {
            return false;
        }
        AudioLogBean audioLogBean = (AudioLogBean) obj;
        return this.f6064a == audioLogBean.f6064a && this.b == audioLogBean.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f6064a) * 31) + Long.hashCode(this.b);
    }

    public String toString() {
        int i = this.f6064a;
        long j = this.b;
        return "AudioLogBean(count=" + i + ", time=" + j + ")";
    }
}
