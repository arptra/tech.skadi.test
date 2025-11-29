package com.upuphone.ar.transcribe.phone.helper;

import com.here.odnp.config.OdnpConfigStatic;
import com.meizu.common.widget.CircularProgressButton;
import com.xjmz.ai.opus.OpusCodec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\u0003R\u001e\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/helper/OpusDecoder;", "Lcom/upuphone/ar/transcribe/phone/helper/IOpusDecoder;", "<init>", "()V", "", "data", "a", "([B)[B", "", "destroy", "Lcom/xjmz/ai/opus/OpusCodec;", "kotlin.jvm.PlatformType", "Lcom/xjmz/ai/opus/OpusCodec;", "decoder", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class OpusDecoder implements IOpusDecoder {

    /* renamed from: a  reason: collision with root package name */
    public OpusCodec f6105a = OpusCodec.newBuilder().withBitrate(11000).withFrameSize(OdnpConfigStatic.UPLOAD_MEDIUM_PRIORITY_DURATION_MINUTES).withSampleRate(16000).withChannels(1).withMaxPacketSize(CircularProgressButton.MorphingAnimation.DURATION_NORMAL).withMaxFrameSize(1920).build();

    public byte[] a(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        byte[] decodeFrame = this.f6105a.decodeFrame(bArr);
        Intrinsics.checkNotNullExpressionValue(decodeFrame, "decodeFrame(...)");
        return decodeFrame;
    }

    public void destroy() {
        OpusCodec opusCodec = this.f6105a;
        if (opusCodec != null) {
            opusCodec.destroy();
        }
        this.f6105a = null;
    }
}
