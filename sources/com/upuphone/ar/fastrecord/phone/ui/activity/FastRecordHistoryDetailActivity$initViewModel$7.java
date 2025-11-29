package com.upuphone.ar.fastrecord.phone.ui.activity;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.AsrDuringProgress;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordHistoryDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordHistoryDetailActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordHistoryDetailActivity$initViewModel$7\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1520:1\n1855#2,2:1521\n*S KotlinDebug\n*F\n+ 1 FastRecordHistoryDetailActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordHistoryDetailActivity$initViewModel$7\n*L\n1324#1:1521,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "asrResultList", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/AsrDuringProgress;", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryDetailActivity$initViewModel$7 extends Lambda implements Function1<ArrayList<AsrDuringProgress>, Unit> {
    final /* synthetic */ FastRecordHistoryDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryDetailActivity$initViewModel$7(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        super(1);
        this.this$0 = fastRecordHistoryDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<AsrDuringProgress>) (ArrayList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable ArrayList<AsrDuringProgress> arrayList) {
        AsrDuringProgress asrDuringProgress = null;
        if (arrayList != null) {
            FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity = this.this$0;
            for (AsrDuringProgress asrDuringProgress2 : arrayList) {
                long recordId = asrDuringProgress2.getRecordId();
                Long access$getRecordId$p = fastRecordHistoryDetailActivity.recordId;
                if (access$getRecordId$p != null && recordId == access$getRecordId$p.longValue()) {
                    asrDuringProgress = asrDuringProgress2;
                }
            }
        }
        if (asrDuringProgress != null) {
            FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity2 = this.this$0;
            LogExt.logE("recordAsrDuringProgress curArs = " + asrDuringProgress, "FastRecordHistoryDetailActivity");
            fastRecordHistoryDetailActivity2.showAsrDuringProgress(asrDuringProgress);
        }
    }
}
