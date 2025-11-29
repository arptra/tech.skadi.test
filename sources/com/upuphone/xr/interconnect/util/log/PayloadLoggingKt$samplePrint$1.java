package com.upuphone.xr.interconnect.util.log;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public /* synthetic */ class PayloadLoggingKt$samplePrint$1 extends FunctionReferenceImpl implements Function1<Byte, String> {
    public static final PayloadLoggingKt$samplePrint$1 INSTANCE = new PayloadLoggingKt$samplePrint$1();

    public PayloadLoggingKt$samplePrint$1() {
        super(1, PayloadLoggingKt.class, "hexPrint", "hexPrint(B)Ljava/lang/String;", 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).byteValue());
    }

    @NotNull
    public final String invoke(byte b) {
        return PayloadLoggingKt.hexPrint(b);
    }
}
