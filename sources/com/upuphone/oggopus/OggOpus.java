package com.upuphone.oggopus;

import androidx.annotation.Keep;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0003\u0016\u0017\u0018B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H J\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bJ#\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012J)\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H J\u0011\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\bH J\u0006\u0010\u0014\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/upuphone/oggopus/OggOpus;", "", "mode", "", "sample", "channel", "(III)V", "nativeProxy", "", "create", "decode", "", "data", "len", "proxy", "decodeAsync", "", "listener", "Lcom/upuphone/oggopus/OggOpus$OnDataListener;", "destroy", "init", "release", "Builder", "Companion", "OnDataListener", "oggopus_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Keep
public final class OggOpus {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_OPUS = 1;
    public static final int TYPE_PCM = 0;
    private final int channel;
    private final int mode;
    private long nativeProxy;
    private final int sample;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\b\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/upuphone/oggopus/OggOpus$Builder;", "", "<init>", "()V", "Lcom/upuphone/oggopus/OggOpus;", "a", "()Lcom/upuphone/oggopus/OggOpus;", "", "I", "getResultType", "()I", "c", "(I)V", "resultType", "b", "getSample", "d", "sample", "getChannel", "channel", "oggopus_release"}, k = 1, mv = {1, 8, 0})
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public int f6435a;
        public int b = 16000;
        public int c = 1;

        public final OggOpus a() {
            return new OggOpus(this.f6435a, this.b, this.c, (DefaultConstructorMarker) null);
        }

        public final void b(int i) {
            this.c = i;
        }

        public final void c(int i) {
            this.f6435a = i;
        }

        public final void d(int i) {
            this.b = i;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/oggopus/OggOpus$Companion;", "", "()V", "TYPE_OPUS", "", "TYPE_PCM", "oggopus_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\bç\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/upuphone/oggopus/OggOpus$OnDataListener;", "", "onData", "", "data", "", "len", "", "oggopus_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnDataListener {
        void onData(@NotNull byte[] bArr, long j);
    }

    static {
        System.loadLibrary("oggopus");
    }

    public /* synthetic */ OggOpus(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    private final native long create(int i, int i2, int i3);

    private final native byte[] decode(long j, byte[] bArr, long j2);

    private final native void decodeAsync(long j, byte[] bArr, long j2, OnDataListener onDataListener);

    private final native void destroy(long j);

    @Nullable
    public final byte[] decode(@NotNull byte[] bArr, long j) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        long j2 = this.nativeProxy;
        if (j2 != -1) {
            return decode(j2, bArr, j);
        }
        return null;
    }

    public final void decodeAsync(@NotNull byte[] bArr, long j, @NotNull OnDataListener onDataListener) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        Intrinsics.checkNotNullParameter(onDataListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        long j2 = this.nativeProxy;
        if (j2 != -1) {
            decodeAsync(j2, bArr, j, onDataListener);
        }
    }

    public final void init() {
        this.nativeProxy = create(this.mode, this.sample, this.channel);
    }

    public final void release() {
        long j = this.nativeProxy;
        if (j != -1) {
            destroy(j);
            this.nativeProxy = -1;
        }
    }

    private OggOpus(int i, int i2, int i3) {
        this.mode = i;
        this.sample = i2;
        this.channel = i3;
        this.nativeProxy = -1;
    }
}
