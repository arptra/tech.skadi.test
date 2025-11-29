package com.upuphone.ai.ttsengine.engines.cloud;

import android.media.MediaDataSource;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u000f\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cloud/CacheDataSource;", "Landroid/media/MediaDataSource;", "", "data", "<init>", "([B)V", "", "close", "()V", "", "position", "buffer", "", "offset", "size", "readAt", "(J[BII)I", "getSize", "()J", "a", "[B", "getData", "()[B", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "b", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class CacheDataSource extends MediaDataSource {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f5547a;
    public final AILOG b = AILOG.a("CacheDataSource");

    public CacheDataSource(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        this.f5547a = bArr;
    }

    public void close() {
        this.b.c("close", new Object[0]);
    }

    public long getSize() {
        return (long) this.f5547a.length;
    }

    public int readAt(long j, byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.f5547a;
        if (j >= ((long) bArr2.length)) {
            return -1;
        }
        long j2 = ((long) i2) + j;
        if (j2 > ((long) bArr2.length)) {
            i2 -= (int) (j2 - ((long) bArr2.length));
        }
        System.arraycopy(bArr2, (int) j, bArr, i, i2);
        return i2;
    }
}
