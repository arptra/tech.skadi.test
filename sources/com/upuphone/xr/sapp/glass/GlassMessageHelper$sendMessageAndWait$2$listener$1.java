package com.upuphone.xr.sapp.glass;

import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.sapp.common.ResultListener;
import com.upuphone.xr.sapp.entity.SendMessageException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/upuphone/xr/sapp/glass/GlassMessageHelper$sendMessageAndWait$2$listener$1", "Lcom/upuphone/xr/sapp/common/ResultListener;", "", "result", "", "a", "(Ljava/lang/String;)V", "", "code", "msg", "onFail", "(ILjava/lang/String;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassMessageHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassMessageHelper.kt\ncom/upuphone/xr/sapp/glass/GlassMessageHelper$sendMessageAndWait$2$listener$1\n*L\n1#1,344:1\n*E\n"})
public final class GlassMessageHelper$sendMessageAndWait$2$listener$1 implements ResultListener<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f7056a;
    public final /* synthetic */ String b;
    public final /* synthetic */ GlassMessageHelper$sendMessageAndWait$2$messageListener$1 c;
    public final /* synthetic */ CancellableContinuation d;

    public GlassMessageHelper$sendMessageAndWait$2$listener$1(String str, String str2, GlassMessageHelper$sendMessageAndWait$2$messageListener$1 glassMessageHelper$sendMessageAndWait$2$messageListener$1, CancellableContinuation cancellableContinuation) {
        this.f7056a = str;
        this.b = str2;
        this.c = glassMessageHelper$sendMessageAndWait$2$messageListener$1;
        this.d = cancellableContinuation;
    }

    /* renamed from: a */
    public void onSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "result");
    }

    public void onFail(int i, String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        GlassMessageHelper.f7054a.f(this.f7056a, this.b, this.c);
        if (this.d.isActive()) {
            CancellableContinuation cancellableContinuation = this.d;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(new SendMessageException(i, str))));
        }
    }
}
