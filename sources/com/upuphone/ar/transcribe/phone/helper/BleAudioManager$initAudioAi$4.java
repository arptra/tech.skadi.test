package com.upuphone.ar.transcribe.phone.helper;

import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.statemachine.machine.TranscribeStateManager;
import com.upuphone.xr.sapp.context.IAudioMulti;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/context/IAudioMulti;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class BleAudioManager$initAudioAi$4 extends Lambda implements Function1<IAudioMulti, Unit> {
    final /* synthetic */ BleAudioManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BleAudioManager$initAudioAi$4(BleAudioManager bleAudioManager) {
        super(1);
        this.this$0 = bleAudioManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IAudioMulti) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IAudioMulti iAudioMulti) {
        Intrinsics.checkNotNullParameter(iAudioMulti, "it");
        if (!TranscribeStateManager.h.a().d().n()) {
            LogExt.c("通话翻译复用但通道还未通", "BleAudioManager", "audioMultiCallback", 0, false, 12, (Object) null);
            return;
        }
        byte[] audioBytes = iAudioMulti.getAudioBytes();
        byte[] copyOf = Arrays.copyOf(audioBytes, audioBytes.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        int length = copyOf.length;
        LogExt.c("通话翻译复用音频数据 " + length, "BleAudioManager", "audioMultiCallback", 0, false, 12, (Object) null);
        int length2 = copyOf.length / 2;
        byte[] sliceArray = ArraysKt.sliceArray(copyOf, RangesKt.until(0, length2));
        this.this$0.f(ArraysKt.sliceArray(copyOf, RangesKt.until(length2, copyOf.length)), 0);
        this.this$0.f(sliceArray, 1);
    }
}
