package com.upuphone.xr.interconnect.util.log;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public /* synthetic */ class PayloadLoggingKt$readableSamplePrint$1 extends FunctionReferenceImpl implements Function1<Byte, String> {
    public static final PayloadLoggingKt$readableSamplePrint$1 INSTANCE = new PayloadLoggingKt$readableSamplePrint$1();

    public PayloadLoggingKt$readableSamplePrint$1() {
        super(1, PayloadLoggingKt.class, "humanPrint", "humanPrint(B)Ljava/lang/String;", 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).byteValue());
    }

    @NotNull
    public final String invoke(byte b) {
        return PayloadLoggingKt.humanPrint(b);
    }
}
