package com.upuphone.xr.sapp.vm;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.audio.VoiceStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/audio/VoiceStatus;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class WakeupRecordingViewmodel$voiceAiAdapter$1 extends Lambda implements Function1<VoiceStatus, Unit> {
    final /* synthetic */ WakeupRecordingViewmodel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WakeupRecordingViewmodel$voiceAiAdapter$1(WakeupRecordingViewmodel wakeupRecordingViewmodel) {
        super(1);
        this.this$0 = wakeupRecordingViewmodel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VoiceStatus) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull VoiceStatus voiceStatus) {
        Intrinsics.checkNotNullParameter(voiceStatus, "it");
        if (voiceStatus instanceof VoiceStatus.Data) {
            byte[] a2 = ((VoiceStatus.Data) voiceStatus).a();
            if (a2 != null) {
                WakeupRecordingViewmodel wakeupRecordingViewmodel = this.this$0;
                wakeupRecordingViewmodel.j = ArraysKt.plus(wakeupRecordingViewmodel.j, a2);
            }
        } else if (Intrinsics.areEqual((Object) voiceStatus, (Object) VoiceStatus.Wakeup.f6647a)) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("WakeupRecordingViewmodel", "wakeup world");
            if (!this.this$0.N()) {
                this.this$0.b0();
            } else {
                delegate.o("WakeupRecordingViewmodel", "wakeup but in call off hook");
            }
        }
    }
}
