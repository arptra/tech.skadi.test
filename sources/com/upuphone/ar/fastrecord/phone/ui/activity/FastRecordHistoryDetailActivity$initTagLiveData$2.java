package com.upuphone.ar.fastrecord.phone.ui.activity;

import com.upuphone.ar.fastrecord.phone.db.RecordPersonEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordDetailHistoryViewAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordHistoryDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordHistoryDetailActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordHistoryDetailActivity$initTagLiveData$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1520:1\n1864#2,2:1521\n1866#2:1524\n1#3:1523\n*S KotlinDebug\n*F\n+ 1 FastRecordHistoryDetailActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordHistoryDetailActivity$initTagLiveData$2\n*L\n580#1:1521,2\n580#1:1524\n*E\n"})
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/upuphone/ar/fastrecord/phone/db/RecordPersonEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryDetailActivity$initTagLiveData$2 extends Lambda implements Function1<List<? extends RecordPersonEntity>, Unit> {
    final /* synthetic */ FastRecordHistoryDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryDetailActivity$initTagLiveData$2(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        super(1);
        this.this$0 = fastRecordHistoryDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<RecordPersonEntity>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable List<RecordPersonEntity> list) {
        LogExt.logE("curRecordPersonTagEntityList list " + list, "FastRecordHistoryDetailActivity");
        FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter = null;
        if (list == null || list.isEmpty()) {
            this.this$0.tagPersonValue = "";
            FastRecordDetailHistoryViewAdapter access$getViewAdapter$p = this.this$0.viewAdapter;
            if (access$getViewAdapter$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                access$getViewAdapter$p = null;
            }
            access$getViewAdapter$p.setAllPersonTagList((List<RecordPersonEntity>) null);
        } else {
            FastRecordDetailHistoryViewAdapter access$getViewAdapter$p2 = this.this$0.viewAdapter;
            if (access$getViewAdapter$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            } else {
                fastRecordDetailHistoryViewAdapter = access$getViewAdapter$p2;
            }
            fastRecordDetailHistoryViewAdapter.setAllPersonTagList(list);
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (T next : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                RecordPersonEntity recordPersonEntity = (RecordPersonEntity) next;
                if (i != list.size() - 1) {
                    stringBuffer.append(recordPersonEntity.getPersonName());
                    stringBuffer.append(FastRecordHistoryDetailActivity.TAG_SPLIT);
                } else {
                    stringBuffer.append(recordPersonEntity.getPersonName());
                }
                String personName = recordPersonEntity.getPersonName();
                if (personName != null) {
                    arrayList.add(personName);
                }
                i = i2;
            }
            FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity = this.this$0;
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
            fastRecordHistoryDetailActivity.tagPersonValue = stringBuffer2;
            LogExt.logE("curRecordPersonTagEntityList value = " + this.this$0.tagPersonValue + " , tagsList = " + arrayList, "FastRecordHistoryDetailActivity");
        }
        try {
            this.this$0.showPersonTagInfo();
        } catch (Exception e) {
            LogExt.logE("showPersonTagInfo error = " + e.getMessage(), "FastRecordHistoryDetailActivity");
        }
    }
}
