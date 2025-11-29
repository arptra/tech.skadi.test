package com.upuphone.ar.translation.audio;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class AudioAiManager$callbackReductionNoiseData$2 extends Lambda implements Function2<byte[], byte[], Unit> {
    public static final AudioAiManager$callbackReductionNoiseData$2 INSTANCE = new AudioAiManager$callbackReductionNoiseData$2();

    public AudioAiManager$callbackReductionNoiseData$2() {
        super(2);
    }

    public final void invoke(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(bArr2, "<anonymous parameter 1>");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((byte[]) obj, (byte[]) obj2);
        return Unit.INSTANCE;
    }
}
