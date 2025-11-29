package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.widget.TextView;
import com.upuphone.ar.fastrecord.databinding.FastRecordTagContentLayoutBinding;
import com.upuphone.ar.fastrecord.phone.db.RecordContentTagEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordContentTagEntity;", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordTagScheduleDialog$initViewModel$4 extends Lambda implements Function1<ArrayList<RecordContentTagEntity>, Unit> {
    final /* synthetic */ FastRecordTagScheduleDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTagScheduleDialog$initViewModel$4(FastRecordTagScheduleDialog fastRecordTagScheduleDialog) {
        super(1);
        this.this$0 = fastRecordTagScheduleDialog;
    }

    /* access modifiers changed from: private */
    public static final CharSequence invoke$lambda$1$lambda$0(TextView textView, int i, RecordContentTagEntity recordContentTagEntity) {
        return recordContentTagEntity.getContentName();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<RecordContentTagEntity>) (ArrayList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable ArrayList<RecordContentTagEntity> arrayList) {
        if (arrayList != null) {
            FastRecordTagScheduleDialog fastRecordTagScheduleDialog = this.this$0;
            fastRecordTagScheduleDialog.setOkTvStateForContentTag();
            FastRecordTagContentLayoutBinding access$getContentTagBinding$p = fastRecordTagScheduleDialog.contentTagBinding;
            FastRecordTagContentLayoutBinding fastRecordTagContentLayoutBinding = null;
            if (access$getContentTagBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentTagBinding");
                access$getContentTagBinding$p = null;
            }
            access$getContentTagBinding$p.e.setLabels(arrayList, new d());
            FastRecordTagContentLayoutBinding access$getContentTagBinding$p2 = fastRecordTagScheduleDialog.contentTagBinding;
            if (access$getContentTagBinding$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentTagBinding");
            } else {
                fastRecordTagContentLayoutBinding = access$getContentTagBinding$p2;
            }
            fastRecordTagContentLayoutBinding.e.requestLayout();
        }
    }
}
