package com.upuphone.ar.fastrecord.phone;

import com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper;
import com.upuphone.xr.sapp.context.IAudioMulti;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/context/IAudioMulti;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordManager$initAudioMulti$1 extends Lambda implements Function1<IAudioMulti, Unit> {
    public static final FastRecordManager$initAudioMulti$1 INSTANCE = new FastRecordManager$initAudioMulti$1();

    public FastRecordManager$initAudioMulti$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IAudioMulti) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IAudioMulti iAudioMulti) {
        Intrinsics.checkNotNullParameter(iAudioMulti, "it");
        RecordInterConnectHelper.Companion.getInstance().commandPhoneVoiceData((long) iAudioMulti.getData().getTag(), (long) iAudioMulti.getData().getId(), iAudioMulti.getData().getType(), iAudioMulti.getAudioBytes());
    }
}
