package com.upuphone.ar.translation.phone.helper;

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

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0002%&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u001f\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0011\u001a\u00020\u0006*\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\"¨\u0006'"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/TranslatorOpusCodec;", "", "<init>", "()V", "", "isMono", "", "c", "(Z)V", "e", "", "bytes", "", "frameLen", "a", "([BI)[B", "", "d", "(Ljava/lang/String;)V", "Lcom/theeasiestway/opus/Constants$FrameSize;", "b", "(I)Lcom/theeasiestway/opus/Constants$FrameSize;", "Lcom/theeasiestway/opus/Opus;", "Lcom/theeasiestway/opus/Opus;", "mOpus", "I", "mFrameSizeDivisor", "Lcom/theeasiestway/opus/Constants$Channels;", "Lcom/theeasiestway/opus/Constants$Channels;", "mChannel", "Lcom/theeasiestway/opus/Constants$SampleRate;", "Lcom/theeasiestway/opus/Constants$SampleRate;", "mSampleRate", "Lcom/theeasiestway/opus/Constants$Application;", "Lcom/theeasiestway/opus/Constants$Application;", "mApplication", "f", "Companion", "OpusFrameLen", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranslatorOpusCodec {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public Opus f6310a;
    public int b = 1;
    public Constants.Channels c = Constants.Channels.Companion.stereo();
    public final Constants.SampleRate d = Constants.SampleRate.Companion._16000();
    public final Constants.Application e = Constants.Application.Companion.audio();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/TranslatorOpusCodec$Companion;", "", "()V", "FRAME_LEN_FORTY", "", "FRAME_LEN_ONE_HUNDRED", "FRAME_LEN_SIXTY", "FRAME_LEN_TWENTY", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/TranslatorOpusCodec$OpusFrameLen;", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface OpusFrameLen {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r7 = com.theeasiestway.opus.Opus.decode$default(r1, r8, b(r9), 0, 4, (java.lang.Object) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] a(byte[] r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "bytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.theeasiestway.opus.Opus r1 = r7.f6310a
            if (r1 == 0) goto L_0x0017
            com.theeasiestway.opus.Constants$FrameSize r3 = r7.b(r9)
            r5 = 4
            r6 = 0
            r4 = 0
            r2 = r8
            byte[] r7 = com.theeasiestway.opus.Opus.decode$default((com.theeasiestway.opus.Opus) r1, (byte[]) r2, (com.theeasiestway.opus.Constants.FrameSize) r3, (int) r4, (int) r5, (java.lang.Object) r6)
            if (r7 != 0) goto L_0x001a
        L_0x0017:
            r7 = 0
            byte[] r7 = new byte[r7]
        L_0x001a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.helper.TranslatorOpusCodec.a(byte[], int):byte[]");
    }

    public final Constants.FrameSize b(int i) {
        return Constants.FrameSize.Companion.fromValue(((this.d.getV() / 1000) * i) / this.b);
    }

    public final void c(boolean z) {
        Constants.Channels channels;
        if (this.f6310a != null) {
            d("AsrOpusCodec has init");
            return;
        }
        d("AsrOpusCodec is init isMono=" + z);
        Opus opus = new Opus();
        if (z) {
            opus.encoderSetBitrate(Constants.Bitrate.Companion.instance(UCarProto.SampleRate.SAMPLE_RATE_32000_VALUE));
            channels = Constants.Channels.Companion.mono();
        } else {
            channels = Constants.Channels.Companion.stereo();
        }
        this.c = channels;
        opus.encoderInit(this.d, channels, this.e);
        opus.decoderInit(this.d, this.c);
        this.f6310a = opus;
        this.b = z ? 1 : 2;
    }

    public final void d(String str) {
        ULog.f6446a.g("TranslatorOpusCodec", str);
    }

    public final void e() {
        if (this.f6310a == null) {
            d("AsrOpusCodec has unInit");
            return;
        }
        d("AsrOpusCodec is unInit");
        Opus opus = this.f6310a;
        if (opus != null) {
            opus.encoderRelease();
            opus.decoderRelease();
            opus.destroy();
        }
        this.f6310a = null;
        this.b = 1;
    }
}
