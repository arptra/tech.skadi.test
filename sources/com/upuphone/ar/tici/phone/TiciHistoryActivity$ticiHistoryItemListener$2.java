package com.upuphone.ar.tici.phone;

import android.view.View;
import com.upuphone.ar.tici.phone.data.TiciHistory;
import com.upuphone.ar.tici.phone.listener.TiciHistoryItemListener;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/upuphone/ar/tici/phone/TiciHistoryActivity$ticiHistoryItemListener$2$1", "invoke", "()Lcom/upuphone/ar/tici/phone/TiciHistoryActivity$ticiHistoryItemListener$2$1;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TiciHistoryActivity$ticiHistoryItemListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ TiciHistoryActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciHistoryActivity$ticiHistoryItemListener$2(TiciHistoryActivity ticiHistoryActivity) {
        super(0);
        this.this$0 = ticiHistoryActivity;
    }

    @NotNull
    public final AnonymousClass1 invoke() {
        final TiciHistoryActivity ticiHistoryActivity = this.this$0;
        return new TiciHistoryItemListener() {
            public void a(View view, TiciHistory ticiHistory) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(ticiHistory, "ticiHistory");
                CommonExtKt.e("onItemMenuClick, " + ticiHistory, "TiciHistoryActivity");
                if (TiciApp.b.d()) {
                    ticiHistoryActivity.t1(view, ticiHistory);
                }
            }

            public void b(TiciHistory ticiHistory) {
                Intrinsics.checkNotNullParameter(ticiHistory, "ticiHistory");
                CommonExtKt.e("onReachLastItem, " + ticiHistory, "TiciHistoryActivity");
                String g = TiciApp.b.g();
                if (g == null || g.length() == 0) {
                    CommonExtKt.e("onReachLastItem, userId is null", "TiciHistoryActivity");
                } else {
                    ticiHistoryActivity.a1().k(g, Long.valueOf(ticiHistory.getLastModified()));
                }
            }

            public void c(TiciHistory ticiHistory) {
                Intrinsics.checkNotNullParameter(ticiHistory, "ticiHistory");
                CommonExtKt.e("onItemClick, " + ticiHistory, "TiciHistoryActivity");
                if (TiciApp.b.d()) {
                    Long loadingTiciId = ticiHistoryActivity.Y0().getLoadingTiciId();
                    long id = ticiHistory.getId();
                    if (loadingTiciId != null && loadingTiciId.longValue() == id) {
                        CommonExtKt.e("onItemClick, loading, return", "TiciHistoryActivity");
                    } else {
                        ticiHistoryActivity.z1(ticiHistory);
                    }
                }
            }

            public void d(TiciHistory ticiHistory) {
                Intrinsics.checkNotNullParameter(ticiHistory, "ticiHistory");
                CommonExtKt.e("onCloseClick, " + ticiHistory, "TiciHistoryActivity");
                ticiHistoryActivity.d.D();
            }
        };
    }
}
