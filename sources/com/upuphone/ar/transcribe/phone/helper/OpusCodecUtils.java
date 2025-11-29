package com.upuphone.ar.transcribe.phone.helper;

import com.here.odnp.config.OdnpConfigStatic;
import com.meizu.common.app.SlideNotice;
import com.theeasiestway.opus.Constants;
import com.theeasiestway.opus.Opus;
import com.ucar.databus.proto.UCarProto;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import com.upuphone.ar.transcribe.ext.LogExt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/helper/OpusCodecUtils;", "Lcom/upuphone/ar/transcribe/phone/helper/IOpusDecoder;", "<init>", "()V", "", "data", "a", "([B)[B", "", "destroy", "", "isAir", "c", "(Z)V", "Lcom/theeasiestway/opus/Constants$FrameSize;", "b", "(Z)Lcom/theeasiestway/opus/Constants$FrameSize;", "Lcom/theeasiestway/opus/Opus;", "Lcom/theeasiestway/opus/Opus;", "opus", "Z", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class OpusCodecUtils implements IOpusDecoder {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);
    public static final Constants.SampleRate d = Constants.SampleRate.Companion._16000();
    public static final Constants.Application e = Constants.Application.Companion.audio();

    /* renamed from: a  reason: collision with root package name */
    public Opus f6104a;
    public boolean b;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/helper/OpusCodecUtils$Companion;", "", "()V", "AIR_DEFAULT_DATA_SIZE", "", "DEFAULT_DATA_SIZE", "TAG", "", "application", "Lcom/theeasiestway/opus/Constants$Application;", "sampleRate", "Lcom/theeasiestway/opus/Constants$SampleRate;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public OpusCodecUtils() {
        boolean g = TranscribeConstants.g();
        this.b = g;
        c(g);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r7 = com.theeasiestway.opus.Opus.decode$default(r1, r8, b(r7.b), 0, 4, (java.lang.Object) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] a(byte[] r8) {
        /*
            r7 = this;
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.theeasiestway.opus.Opus r1 = r7.f6104a
            if (r1 == 0) goto L_0x0019
            boolean r0 = r7.b
            com.theeasiestway.opus.Constants$FrameSize r3 = r7.b(r0)
            r5 = 4
            r6 = 0
            r4 = 0
            r2 = r8
            byte[] r7 = com.theeasiestway.opus.Opus.decode$default((com.theeasiestway.opus.Opus) r1, (byte[]) r2, (com.theeasiestway.opus.Constants.FrameSize) r3, (int) r4, (int) r5, (java.lang.Object) r6)
            if (r7 != 0) goto L_0x001c
        L_0x0019:
            r7 = 0
            byte[] r7 = new byte[r7]
        L_0x001c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.helper.OpusCodecUtils.a(byte[]):byte[]");
    }

    public final Constants.FrameSize b(boolean z) {
        return z ? Constants.FrameSize.Companion.fromValue(OdnpConfigStatic.UPLOAD_MEDIUM_PRIORITY_DURATION_MINUTES) : Constants.FrameSize.Companion.fromValue(SlideNotice.SHOW_ANIMATION_DURATION);
    }

    public final void c(boolean z) {
        Constants.Channels channels;
        if (this.f6104a != null) {
            LogExt.g("OpusCodecUtils has init....", "OpusCodecUtils");
            return;
        }
        LogExt.g("OpusCodecUtils is init...." + z, "OpusCodecUtils");
        Opus opus = new Opus();
        this.f6104a = opus;
        if (z) {
            opus.encoderSetBitrate(Constants.Bitrate.Companion.instance(UCarProto.SampleRate.SAMPLE_RATE_32000_VALUE));
            channels = Constants.Channels.Companion.mono();
        } else {
            channels = Constants.Channels.Companion.stereo();
        }
        Opus opus2 = this.f6104a;
        if (opus2 != null) {
            opus2.encoderInit(d, channels, e);
        }
        Opus opus3 = this.f6104a;
        if (opus3 != null) {
            opus3.decoderInit(d, channels);
        }
    }

    public void destroy() {
        if (this.f6104a == null) {
            LogExt.g("OpusCodecUtils has unInit....", "OpusCodecUtils");
            return;
        }
        LogExt.g("OpusCodecUtils is unInit....", "OpusCodecUtils");
        Opus opus = this.f6104a;
        if (opus != null) {
            opus.encoderRelease();
        }
        Opus opus2 = this.f6104a;
        if (opus2 != null) {
            opus2.decoderRelease();
        }
        Opus opus3 = this.f6104a;
        if (opus3 != null) {
            opus3.destroy();
        }
        this.f6104a = null;
    }
}
