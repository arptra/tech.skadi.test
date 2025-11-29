package com.xjsd.ai.assistant.flutter.util;

import androidx.core.util.Consumer;
import com.honey.account.da.a;
import com.honey.account.da.b;
import com.xjsd.ai.assistant.flutter.util.PcmEncodedData;
import com.xjsd.ai.assistant.phone.codec.PcmToAmrWbCoder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0003R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/util/AmrWbEncoder;", "Lcom/xjsd/ai/assistant/flutter/util/PcmEncoder;", "<init>", "()V", "Landroidx/core/util/Consumer;", "Lcom/xjsd/ai/assistant/flutter/util/PcmEncodedData;", "consumer", "", "a", "(Landroidx/core/util/Consumer;)V", "", "b", "()Ljava/lang/String;", "start", "", "data", "encode", "([B)V", "flush", "Lcom/xjsd/ai/assistant/phone/codec/PcmToAmrWbCoder;", "Lkotlin/Lazy;", "e", "()Lcom/xjsd/ai/assistant/phone/codec/PcmToAmrWbCoder;", "pcmToAmrWbCoder", "Landroidx/core/util/Consumer;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AmrWbEncoder implements PcmEncoder {

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f8493a = LazyKt.lazy(AmrWbEncoder$pcmToAmrWbCoder$2.INSTANCE);
    public Consumer b;

    public static final void f(AmrWbEncoder amrWbEncoder, Integer num) {
        Intrinsics.checkNotNullParameter(amrWbEncoder, "this$0");
        if (num != null && num.intValue() == 200) {
            Consumer consumer = amrWbEncoder.b;
            if (consumer != null) {
                consumer.accept(new PcmEncodedData.FlagData(true));
                return;
            }
            return;
        }
        Consumer consumer2 = amrWbEncoder.b;
        if (consumer2 != null) {
            consumer2.accept(new PcmEncodedData.FlagData(false));
        }
    }

    public static final void g(AmrWbEncoder amrWbEncoder, byte[] bArr) {
        Intrinsics.checkNotNullParameter(amrWbEncoder, "this$0");
        Consumer consumer = amrWbEncoder.b;
        if (consumer != null) {
            Intrinsics.checkNotNull(bArr);
            consumer.accept(new PcmEncodedData.ByteData(bArr));
        }
    }

    public void a(Consumer consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        this.b = consumer;
    }

    public String b() {
        return "AMR_WB";
    }

    public final PcmToAmrWbCoder e() {
        return (PcmToAmrWbCoder) this.f8493a.getValue();
    }

    public void encode(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        e().b(bArr);
    }

    public void flush() {
        e().c();
    }

    public void start() {
        PcmToAmrWbCoder e = e();
        e.g(new a(this));
        e.f(new b(this));
        e.h();
        byte[] bytes = "#!AMR-WB\n".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        Consumer consumer = this.b;
        if (consumer != null) {
            consumer.accept(new PcmEncodedData.ByteData(bytes));
        }
    }
}
