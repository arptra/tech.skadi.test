package com.upuphone.xr.sapp.glass;

import com.honey.account.view.web.WebJs;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/glass/GlassHelper$sendOtaMessageAndWait$2$messageListener$1", "Lcom/upuphone/xr/sapp/glass/GlassMessageListener;", "", "action", "data", "", "a", "(Ljava/lang/String;Ljava/lang/String;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassHelper.kt\ncom/upuphone/xr/sapp/glass/GlassHelper$sendOtaMessageAndWait$2$messageListener$1\n*L\n1#1,649:1\n*E\n"})
public final class GlassHelper$sendOtaMessageAndWait$2$messageListener$1 implements GlassMessageListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f7051a;

    public GlassHelper$sendOtaMessageAndWait$2$messageListener$1(CancellableContinuation cancellableContinuation) {
        this.f7051a = cancellableContinuation;
    }

    public void a(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        GlassHelper.f7049a.I(str, this);
        if (this.f7051a.isActive()) {
            this.f7051a.resumeWith(Result.m20constructorimpl(str2));
        }
    }
}
