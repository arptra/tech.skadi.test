package com.upuphone.ar.translation.phone.helper;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "proximalBytes", "", "remoteBytes", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class BleAudioHelper$initAudioAi$1$4 extends Lambda implements Function2<byte[], byte[], Unit> {
    public static final BleAudioHelper$initAudioAi$1$4 INSTANCE = new BleAudioHelper$initAudioAi$1$4();

    public BleAudioHelper$initAudioAi$1$4() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((byte[]) obj, (byte[]) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "proximalBytes");
        Intrinsics.checkNotNullParameter(bArr2, "remoteBytes");
        BleAudioHelper bleAudioHelper = BleAudioHelper.f6295a;
        bleAudioHelper.q(bArr);
        bleAudioHelper.r(bArr2);
    }
}
