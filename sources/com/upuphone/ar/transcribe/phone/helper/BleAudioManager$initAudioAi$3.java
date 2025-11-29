package com.upuphone.ar.transcribe.phone.helper;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "iSta", "", "channel", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class BleAudioManager$initAudioAi$3 extends Lambda implements Function2<Integer, Integer, Unit> {
    final /* synthetic */ BleAudioManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BleAudioManager$initAudioAi$3(BleAudioManager bleAudioManager) {
        super(2);
        this.this$0 = bleAudioManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2) {
        this.this$0.g(i, i2);
    }
}
