package com.xjsd.ai.assistant.phone.helper;

import com.xjsd.ai.assistant.common.util.KeyStoreHelper;
import io.ktor.util.Base64Kt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class WakeupVoiceStorage$get$1$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ List<float[]> $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WakeupVoiceStorage$get$1$1(List<float[]> list) {
        super(1);
        this.$result = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        this.$result.add(WakeupVoiceStorage.INSTANCE.toFloatArray(KeyStoreHelper.f8445a.a(Base64Kt.c(str))));
    }
}
