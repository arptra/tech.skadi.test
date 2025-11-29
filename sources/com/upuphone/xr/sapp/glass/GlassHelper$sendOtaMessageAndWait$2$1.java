package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.sapp.common.ResultListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGlassHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassHelper.kt\ncom/upuphone/xr/sapp/glass/GlassHelper$sendOtaMessageAndWait$2$1\n*L\n1#1,649:1\n*E\n"})
public final class GlassHelper$sendOtaMessageAndWait$2$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ GlassHelper$sendOtaMessageAndWait$2$messageListener$1 $messageListener;
    final /* synthetic */ String $subAction;
    final /* synthetic */ String $uid;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassHelper$sendOtaMessageAndWait$2$1(String str, String str2, GlassHelper$sendOtaMessageAndWait$2$messageListener$1 glassHelper$sendOtaMessageAndWait$2$messageListener$1) {
        super(1);
        this.$uid = str;
        this.$subAction = str2;
        this.$messageListener = glassHelper$sendOtaMessageAndWait$2$messageListener$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        GlassHelper glassHelper = GlassHelper.f7049a;
        ResultListener unused = glassHelper.J(this.$uid);
        glassHelper.I(this.$subAction, this.$messageListener);
    }
}
