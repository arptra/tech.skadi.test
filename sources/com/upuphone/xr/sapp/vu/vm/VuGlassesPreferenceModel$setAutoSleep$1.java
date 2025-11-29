package com.upuphone.xr.sapp.vu.vm;

import com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuGlassesPreferenceModel$setAutoSleep$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ int $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassesPreferenceModel$setAutoSleep$1(int i) {
        super(0);
        this.$value = i;
    }

    @NotNull
    public final Integer invoke() {
        return Integer.valueOf(VuGlassesHidUtil.f8104a.C(this.$value));
    }
}
