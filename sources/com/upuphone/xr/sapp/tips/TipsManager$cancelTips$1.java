package com.upuphone.xr.sapp.tips;

import com.upuphone.star.core.log.ULog;
import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTipsManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TipsManager.kt\ncom/upuphone/xr/sapp/tips/TipsManager$cancelTips$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,120:1\n766#2:121\n857#2,2:122\n*S KotlinDebug\n*F\n+ 1 TipsManager.kt\ncom/upuphone/xr/sapp/tips/TipsManager$cancelTips$1\n*L\n61#1:121\n61#1:122,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TipsManager$cancelTips$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TipsKey $key;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TipsManager$cancelTips$1(TipsKey tipsKey) {
        super(0);
        this.$key = tipsKey;
    }

    public final void invoke() {
        List c = TipsManager.c;
        TipsKey tipsKey = this.$key;
        ArrayList arrayList = new ArrayList();
        for (Object next : c) {
            if (((TipsModel) next).b() == tipsKey) {
                arrayList.add(next);
            }
        }
        TipsManager.c.removeAll(arrayList);
        AndroidAppApi.TipsFlutterApi b = TipsManager.b;
        if (b != null) {
            b.c(this.$key.name(), new AndroidAppApi.VoidResult() {
                public void error(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "error");
                    ULog.Delegate delegate = ULog.f6446a;
                    String message = th.getMessage();
                    delegate.a("TipsManager", "cancelTips && error:" + message);
                }

                public void success() {
                    ULog.f6446a.a("TipsManager", "cancelTips && success");
                }
            });
        }
    }
}
