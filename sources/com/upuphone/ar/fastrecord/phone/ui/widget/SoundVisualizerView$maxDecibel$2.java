package com.upuphone.ar.fastrecord.phone.ui.widget;

import com.upuphone.ar.fastrecord.phone.bean.AmplitudeBean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SoundVisualizerView$maxDecibel$2 extends Lambda implements Function0<Float> {
    public static final SoundVisualizerView$maxDecibel$2 INSTANCE = new SoundVisualizerView$maxDecibel$2();

    public SoundVisualizerView$maxDecibel$2() {
        super(0);
    }

    @NotNull
    public final Float invoke() {
        return Float.valueOf(AmplitudeBean.Companion.amplitude2db(32767));
    }
}
