package com.xjsd.ai.assistant.common.util;

import com.meizu.common.app.SlideNotice;
import com.ucar.databus.proto.UCarProto;
import com.xjmz.ai.opus.OpusCodec;

public class OpusUtil {

    /* renamed from: a  reason: collision with root package name */
    public final OpusCodec f8446a = OpusCodec.newBuilder().withBitrate(UCarProto.SampleRate.SAMPLE_RATE_32000_VALUE).withFrameSize(SlideNotice.SHOW_ANIMATION_DURATION).withSampleRate(16000).withChannels(1).withMaxPacketSize(40).withMaxFrameSize(SlideNotice.SHOW_ANIMATION_DURATION).build();

    public byte[] a(byte[] bArr) {
        return this.f8446a.decodeFrame(bArr);
    }

    public byte[] b(byte[] bArr) {
        return this.f8446a.encodeFrame(bArr);
    }

    public void c() {
        this.f8446a.destroy();
    }
}
