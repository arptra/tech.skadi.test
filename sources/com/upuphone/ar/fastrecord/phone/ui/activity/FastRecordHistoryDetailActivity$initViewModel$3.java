package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordDetailHistoryViewAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordHistoryDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordHistoryDetailActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordHistoryDetailActivity$initViewModel$3\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,1520:1\n262#2,2:1521\n262#2,2:1523\n262#2,2:1525\n262#2,2:1527\n262#2,2:1529\n*S KotlinDebug\n*F\n+ 1 FastRecordHistoryDetailActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordHistoryDetailActivity$initViewModel$3\n*L\n1279#1:1521,2\n1280#1:1523,2\n1281#1:1525,2\n1282#1:1527,2\n1283#1:1529,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/upuphone/ar/fastrecord/phone/db/RecordVoiceWordEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryDetailActivity$initViewModel$3 extends Lambda implements Function1<List<? extends RecordVoiceWordEntity>, Unit> {
    final /* synthetic */ FastRecordHistoryDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryDetailActivity$initViewModel$3(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        super(1);
        this.this$0 = fastRecordHistoryDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<RecordVoiceWordEntity>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable List<RecordVoiceWordEntity> list) {
        String str;
        if (list != null) {
            FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity = this.this$0;
            LogExt.logE("curRecordVoiceWordList size = " + list.size(), "FastRecordHistoryDetailActivity");
            fastRecordHistoryDetailActivity.showAiAndCopyImage(true);
            fastRecordHistoryDetailActivity.getLayout().e.c.setClickable(true);
            ScrollView b = fastRecordHistoryDetailActivity.getLayout().g.getRoot();
            Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
            b.setVisibility(8);
            LinearLayout b2 = fastRecordHistoryDetailActivity.getLayout().f.getRoot();
            Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
            b2.setVisibility(8);
            LinearLayout b3 = fastRecordHistoryDetailActivity.getLayout().h.getRoot();
            Intrinsics.checkNotNullExpressionValue(b3, "getRoot(...)");
            b3.setVisibility(8);
            RecyclerView recyclerView = fastRecordHistoryDetailActivity.getLayout().j;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recRecord");
            recyclerView.setVisibility(0);
            View view = fastRecordHistoryDetailActivity.getLayout().c;
            Intrinsics.checkNotNullExpressionValue(view, "ivBottomTran");
            view.setVisibility(0);
            FastRecordDetailHistoryViewAdapter access$getViewAdapter$p = fastRecordHistoryDetailActivity.viewAdapter;
            FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter = null;
            if (access$getViewAdapter$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                access$getViewAdapter$p = null;
            }
            RecordEntity value = fastRecordHistoryDetailActivity.getViewModel().getCurRecordData().getValue();
            if (value == null || (str = value.getLanguageType()) == null) {
                str = "";
            }
            access$getViewAdapter$p.setRecordWordLanguageType(str);
            FastRecordDetailHistoryViewAdapter access$getViewAdapter$p2 = fastRecordHistoryDetailActivity.viewAdapter;
            if (access$getViewAdapter$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            } else {
                fastRecordDetailHistoryViewAdapter = access$getViewAdapter$p2;
            }
            fastRecordDetailHistoryViewAdapter.setData(list);
        }
    }
}
