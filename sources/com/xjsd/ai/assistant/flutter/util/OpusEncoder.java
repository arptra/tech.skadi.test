package com.xjsd.ai.assistant.flutter.util;

import androidx.core.util.Consumer;
import com.honey.account.da.c;
import com.xjsd.ai.assistant.common.util.OpusUtil;
import com.xjsd.ai.assistant.core.factory.ThreadPoolFactory;
import com.xjsd.ai.assistant.flutter.util.PcmEncodedData;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00148\u0002XD¢\u0006\u0006\n\u0004\b\b\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001eR\u001c\u0010$\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/util/OpusEncoder;", "Lcom/xjsd/ai/assistant/flutter/util/PcmEncoder;", "<init>", "()V", "Landroidx/core/util/Consumer;", "Lcom/xjsd/ai/assistant/flutter/util/PcmEncodedData;", "consumer", "", "a", "(Landroidx/core/util/Consumer;)V", "", "b", "()Ljava/lang/String;", "start", "", "data", "encode", "([B)V", "flush", "e", "", "I", "unitPackSize", "[B", "unitBuffer", "c", "remainDataLength", "d", "Landroidx/core/util/Consumer;", "Lcom/xjsd/ai/assistant/common/util/OpusUtil;", "Lcom/xjsd/ai/assistant/common/util/OpusUtil;", "opusUtil", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "f", "Ljava/util/concurrent/ExecutorService;", "worker", "g", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class OpusEncoder implements PcmEncoder {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final int f8495a = 640;
    public final byte[] b = new byte[640];
    public int c;
    public Consumer d;
    public final OpusUtil e = new OpusUtil();
    public final ExecutorService f = ThreadPoolFactory.b("flutter-pcm-encode");

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/util/OpusEncoder$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void d(OpusEncoder opusEncoder, byte[] bArr) {
        int i;
        Intrinsics.checkNotNullParameter(opusEncoder, "this$0");
        Intrinsics.checkNotNullParameter(bArr, "$data");
        int i2 = opusEncoder.c;
        if (i2 == 0 && bArr.length == opusEncoder.f8495a) {
            opusEncoder.e(bArr);
            return;
        }
        int length = bArr.length + i2;
        if (length < opusEncoder.f8495a) {
            System.arraycopy(bArr, 0, opusEncoder.b, i2, bArr.length);
            opusEncoder.c = length;
            ILog.a("OpusEncoder", "encode: 1.数据不足一包，余量->" + length);
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = opusEncoder.f8495a;
            if (length < i4) {
                break;
            }
            int i5 = opusEncoder.c;
            if (i5 > 0) {
                i = i4 - i5;
                System.arraycopy(bArr, 0, opusEncoder.b, i5, i);
                opusEncoder.c = 0;
            } else {
                System.arraycopy(bArr, i3, opusEncoder.b, 0, i4);
                i = opusEncoder.f8495a;
            }
            opusEncoder.e(opusEncoder.b);
            i3 += i;
            length -= opusEncoder.f8495a;
        }
        int length2 = bArr.length - i3;
        if (length2 > 0) {
            ILog.a("OpusEncoder", "encode: 2.数据不足一包，余量->" + length2);
            System.arraycopy(bArr, i3, opusEncoder.b, length - length2, length2);
        }
        opusEncoder.c = length;
    }

    public void a(Consumer consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        this.d = consumer;
    }

    public String b() {
        return AsrConstants.AUDIO_OPUS;
    }

    public final void e(byte[] bArr) {
        byte[] b2 = this.e.b(bArr);
        byte[] bArr2 = new byte[(b2.length + 2)];
        bArr2[0] = (byte) (b2.length >> 8);
        bArr2[1] = (byte) (b2.length & 255);
        System.arraycopy(b2, 0, bArr2, 2, b2.length);
        Consumer consumer = this.d;
        if (consumer != null) {
            consumer.accept(new PcmEncodedData.ByteData(bArr2));
        }
    }

    public void encode(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        this.f.execute(new c(this, bArr));
    }

    public void flush() {
        Consumer consumer = this.d;
        if (consumer != null) {
            consumer.accept(new PcmEncodedData.FlagData(true));
        }
    }

    public void start() {
        this.c = 0;
    }
}
