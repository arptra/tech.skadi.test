package com.upuphone.xr.sapp.tips;

import com.upuphone.star.core.log.ULog;
import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TipsManager$showTips$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $btnClick;
    final /* synthetic */ AndroidAppApi.HomeTips $homeTips;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TipsManager$showTips$1(AndroidAppApi.HomeTips homeTips, Function0<Unit> function0) {
        super(0);
        this.$homeTips = homeTips;
        this.$btnClick = function0;
    }

    public final void invoke() {
        String b = this.$homeTips.b();
        Intrinsics.checkNotNullExpressionValue(b, "getTipsKey(...)");
        TipsKey d = TipsKeyKt.d(b);
        Intrinsics.checkNotNull(d);
        TipsManager.c.add(0, new TipsModel(d, this.$homeTips, this.$btnClick));
        ULog.Delegate delegate = ULog.f6446a;
        String b2 = this.$homeTips.b();
        delegate.a("TipsManager", "showTips homeTips:" + b2);
        AndroidAppApi.TipsFlutterApi b3 = TipsManager.b;
        if (b3 != null) {
            b3.g(this.$homeTips, new AndroidAppApi.VoidResult() {
                public void error(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "error");
                    ULog.Delegate delegate = ULog.f6446a;
                    String message = th.getMessage();
                    delegate.a("TipsManager", "showHomeTips && error:" + message);
                }

                public void success() {
                    ULog.f6446a.a("TipsManager", "showHomeTips && success");
                }
            });
        }
    }
}
