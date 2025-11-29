package com.upuphone.ar.tici.phone;

import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.upuphone.ar.tici.phone.data.SystemFileInfo;
import com.upuphone.ar.tici.phone.epoxy.SystemFileController;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTiciFileSearchActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciFileSearchActivity.kt\ncom/upuphone/ar/tici/phone/TiciFileSearchActivity$initViewModels$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,157:1\n262#2,2:158\n262#2,2:160\n*S KotlinDebug\n*F\n+ 1 TiciFileSearchActivity.kt\ncom/upuphone/ar/tici/phone/TiciFileSearchActivity$initViewModels$1\n*L\n135#1:158,2\n137#1:160,2\n*E\n"})
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u000122\u0010\u0002\u001a.\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005 \u0007*\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "it", "", "", "", "Lcom/upuphone/ar/tici/phone/data/SystemFileInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TiciFileSearchActivity$initViewModels$1 extends Lambda implements Function1<Map<String, ? extends List<? extends SystemFileInfo>>, Unit> {
    final /* synthetic */ TiciFileSearchActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciFileSearchActivity$initViewModels$1(TiciFileSearchActivity ticiFileSearchActivity) {
        super(1);
        this.this$0 = ticiFileSearchActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, ? extends List<SystemFileInfo>>) (Map) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Map<String, ? extends List<SystemFileInfo>> map) {
        RecyclerView recyclerView = this.this$0.G0().f;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "filesRecyclerview");
        int i = 0;
        recyclerView.setVisibility(0);
        SystemFileController B0 = this.this$0.F0();
        Intrinsics.checkNotNull(map);
        B0.refreshData(map);
        LinearLayout linearLayout = this.this$0.G0().i;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "layNoSearchResult");
        if (!map.isEmpty()) {
            i = 8;
        }
        linearLayout.setVisibility(i);
    }
}
