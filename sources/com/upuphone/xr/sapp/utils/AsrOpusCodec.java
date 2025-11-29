package com.upuphone.xr.sapp.utils;

import com.theeasiestway.opus.Constants;
import com.theeasiestway.opus.Opus;
import com.ucar.databus.proto.UCarProto;
import com.upuphone.star.core.log.ULog;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u0013\u0010\u000b\u001a\u00020\u0006*\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/upuphone/xr/sapp/utils/AsrOpusCodec;", "", "<init>", "()V", "", "isMono", "", "a", "(Z)V", "d", "", "c", "(Ljava/lang/String;)V", "Lcom/theeasiestway/opus/Opus;", "Lcom/theeasiestway/opus/Opus;", "mOpus", "Lcom/theeasiestway/opus/Constants$Channels;", "b", "Lcom/theeasiestway/opus/Constants$Channels;", "mChannel", "Lcom/theeasiestway/opus/Constants$SampleRate;", "Lcom/theeasiestway/opus/Constants$SampleRate;", "mSampleRate", "Lcom/theeasiestway/opus/Constants$Application;", "Lcom/theeasiestway/opus/Constants$Application;", "mApplication", "e", "Companion", "OpusFrameLen", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AsrOpusCodec {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public Opus f7843a;
    public Constants.Channels b = Constants.Channels.Companion.stereo();
    public final Constants.SampleRate c = Constants.SampleRate.Companion._16000();
    public final Constants.Application d = Constants.Application.Companion.audio();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/utils/AsrOpusCodec$Companion;", "", "()V", "FRAME_LEN_FORTY", "", "FRAME_LEN_ONE_HUNDRED", "FRAME_LEN_SIXTY", "FRAME_LEN_TWENTY", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/upuphone/xr/sapp/utils/AsrOpusCodec$OpusFrameLen;", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface OpusFrameLen {
    }

    public static /* synthetic */ void b(AsrOpusCodec asrOpusCodec, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        asrOpusCodec.a(z);
    }

    public final void a(boolean z) {
        Constants.Channels channels;
        if (this.f7843a != null) {
            c("AsrOpusCodec has init");
            return;
        }
        c("AsrOpusCodec is init");
        Opus opus = new Opus();
        if (z) {
            opus.encoderSetBitrate(Constants.Bitrate.Companion.instance(UCarProto.SampleRate.SAMPLE_RATE_32000_VALUE));
            channels = Constants.Channels.Companion.mono();
        } else {
            channels = Constants.Channels.Companion.stereo();
        }
        this.b = channels;
        opus.encoderInit(this.c, channels, this.d);
        opus.decoderInit(this.c, this.b);
        this.f7843a = opus;
    }

    public final void c(String str) {
        ULog.f6446a.g("AsrOpusCodec", str);
    }

    public final void d() {
        if (this.f7843a == null) {
            c("AsrOpusCodec has unInit");
            return;
        }
        c("AsrOpusCodec is unInit");
        Opus opus = this.f7843a;
        if (opus != null) {
            opus.encoderRelease();
            opus.decoderRelease();
            opus.destroy();
        }
        this.f7843a = null;
    }
}
