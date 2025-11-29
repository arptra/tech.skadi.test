package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.text.TextUtils;
import android.widget.LinearLayout;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordSearchViewAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nFastRecordSearchActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordSearchActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordSearchActivity$initViewModel$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,207:1\n262#2,2:208\n*S KotlinDebug\n*F\n+ 1 FastRecordSearchActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordSearchActivity$initViewModel$1\n*L\n204#1:208,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u000120\u0010\u0002\u001a,\u0012\u0004\u0012\u00020\u0004 \u0006*\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00050\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "list", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "Lkotlin/collections/ArrayList;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordSearchActivity$initViewModel$1 extends Lambda implements Function1<ArrayList<RecordEntity>, Unit> {
    final /* synthetic */ FastRecordSearchActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordSearchActivity$initViewModel$1(FastRecordSearchActivity fastRecordSearchActivity) {
        super(1);
        this.this$0 = fastRecordSearchActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<RecordEntity>) (ArrayList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ArrayList<RecordEntity> arrayList) {
        if (arrayList != null) {
            FastRecordSearchActivity fastRecordSearchActivity = this.this$0;
            int size = arrayList.size();
            LogExt.logE("curRecordData size = " + size, "FastRecordSearchActivity");
            FastRecordSearchViewAdapter access$getViewAdapter$p = fastRecordSearchActivity.viewAdapter;
            if (access$getViewAdapter$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                access$getViewAdapter$p = null;
            }
            access$getViewAdapter$p.notifyRecordData(arrayList);
        }
        LinearLayout linearLayout = this.this$0.getLayout().d;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llEmpty");
        int i = 0;
        if (!(!TextUtils.isEmpty(this.this$0.keyWordValue) && (arrayList == null || arrayList.isEmpty()))) {
            i = 8;
        }
        linearLayout.setVisibility(i);
    }
}
