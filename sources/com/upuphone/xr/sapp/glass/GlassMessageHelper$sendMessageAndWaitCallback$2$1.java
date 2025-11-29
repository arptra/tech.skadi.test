package com.upuphone.xr.sapp.glass;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 176)
@SourceDebugExtension({"SMAP\nGlassMessageHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassMessageHelper.kt\ncom/upuphone/xr/sapp/glass/GlassMessageHelper$sendMessageAndWaitCallback$2$1\n*L\n1#1,344:1\n*E\n"})
public final class GlassMessageHelper$sendMessageAndWaitCallback$2$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ String $uid;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassMessageHelper$sendMessageAndWaitCallback$2$1(String str) {
        super(1);
        this.$uid = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        GlassMessageHelper.f7054a.e(this.$uid);
    }
}
