package com.xjsd.ai.assistant.phone.vad;

import android.util.SparseArray;
import com.here.odnp.config.OdnpConfigStatic;
import com.honey.account.ma.a;
import com.honey.account.view.web.WebJs;
import com.meizu.common.app.SlideNotice;
import com.ucar.databus.proto.UCarProto;
import com.xjmz.ai.opus.OpusCodec;
import com.xjsd.ai.assistant.core.factory.ThreadPoolFactory;
import com.xjsd.ai.assistant.log.ILog;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vad/OpusDecoder;", "", "<init>", "()V", "", "data", "", "len", "Lkotlin/Function1;", "", "action", "c", "([BILkotlin/jvm/functions/Function1;)V", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "a", "Ljava/util/concurrent/ExecutorService;", "mThreadPool", "b", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class OpusDecoder {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);
    public static final SparseArray c = new SparseArray();

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f8613a = ThreadPoolFactory.b("OpusDecode");

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vad/OpusDecoder$Companion;", "", "<init>", "()V", "", "pack", "Lcom/xjmz/ai/opus/OpusCodec;", "a", "(I)Lcom/xjmz/ai/opus/OpusCodec;", "PACKAGE_SIZE_120", "I", "PACKAGE_SIZE_240", "PACKAGE_SIZE_40", "PACKAGE_SIZE_83", "", "TAG", "Ljava/lang/String;", "Landroid/util/SparseArray;", "codecMap", "Landroid/util/SparseArray;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OpusCodec a(int i) {
            OpusCodec opusCodec = (OpusCodec) OpusDecoder.c.get(i);
            if (opusCodec != null) {
                return opusCodec;
            }
            if (i == 40) {
                OpusCodec build = OpusCodec.newBuilder().withBitrate(UCarProto.SampleRate.SAMPLE_RATE_24000_VALUE).withFrameSize(SlideNotice.SHOW_ANIMATION_DURATION).withSampleRate(16000).withChannels(1).withMaxPacketSize(40).withMaxFrameSize(SlideNotice.SHOW_ANIMATION_DURATION).build();
                OpusDecoder.c.put(i, build);
                return build;
            } else if (i != 83 && i != 120 && i != 240) {
                return null;
            } else {
                OpusCodec build2 = OpusCodec.newBuilder().withBitrate(11000).withFrameSize(OdnpConfigStatic.UPLOAD_MEDIUM_PRIORITY_DURATION_MINUTES).withSampleRate(16000).withChannels(1).withMaxPacketSize(i).withMaxFrameSize(1920).build();
                OpusDecoder.c.put(i, build2);
                return build2;
            }
        }

        public Companion() {
        }
    }

    public static final void d(Function1 function1, byte[] bArr) {
        Intrinsics.checkNotNullParameter(function1, "$action");
        Intrinsics.checkNotNull(bArr);
        function1.invoke(bArr);
    }

    public final void c(byte[] bArr, int i, Function1 function1) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        Intrinsics.checkNotNullParameter(function1, WebJs.ACTION);
        OpusCodec a2 = b.a(i);
        if (a2 == null) {
            ILog.g("OpusDecoder", "did not find decoder for pack len: " + i);
            return;
        }
        this.f8613a.execute(new a(function1, a2.decodeFrame(bArr)));
    }
}
