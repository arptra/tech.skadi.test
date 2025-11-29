package com.upuphone.ar.translation.phone.helper;

import com.upuphone.ar.translation.ext.LogExt;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "audioMulti", "Lcom/upuphone/xr/sapp/context/IAudioMulti;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TelephoneTransHelper$init$2 extends Lambda implements Function1<IAudioMulti, Unit> {
    public static final TelephoneTransHelper$init$2 INSTANCE = new TelephoneTransHelper$init$2();

    public TelephoneTransHelper$init$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IAudioMulti) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IAudioMulti iAudioMulti) {
        Intrinsics.checkNotNullParameter(iAudioMulti, "audioMulti");
        if (TelephoneTransHelper.d) {
            byte[] audioBytes = iAudioMulti.getAudioBytes();
            byte[] copyOf = Arrays.copyOf(audioBytes, audioBytes.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            int length = copyOf.length;
            LogExt.f("通话翻译复用音频数据 " + length, "TelephoneTransHelper", "audioMultiCallback", 0, 4, (Object) null);
            int length2 = copyOf.length / 2;
            byte[] sliceArray = ArraysKt.sliceArray(copyOf, RangesKt.until(0, length2));
            byte[] sliceArray2 = ArraysKt.sliceArray(copyOf, RangesKt.until(length2, copyOf.length));
            TelephoneTransHelper telephoneTransHelper = TelephoneTransHelper.f6305a;
            telephoneTransHelper.q(sliceArray2);
            telephoneTransHelper.p(sliceArray);
        }
    }
}
