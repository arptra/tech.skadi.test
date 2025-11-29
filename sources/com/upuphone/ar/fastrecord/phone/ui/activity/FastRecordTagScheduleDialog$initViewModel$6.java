package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.widget.TextView;
import com.upuphone.ar.fastrecord.databinding.FastRecordTagPersonLayoutBinding;
import com.upuphone.ar.fastrecord.phone.db.RecordPersonEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordPersonEntity;", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordTagScheduleDialog$initViewModel$6 extends Lambda implements Function1<ArrayList<RecordPersonEntity>, Unit> {
    final /* synthetic */ FastRecordTagScheduleDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTagScheduleDialog$initViewModel$6(FastRecordTagScheduleDialog fastRecordTagScheduleDialog) {
        super(1);
        this.this$0 = fastRecordTagScheduleDialog;
    }

    /* access modifiers changed from: private */
    public static final CharSequence invoke$lambda$1$lambda$0(TextView textView, int i, RecordPersonEntity recordPersonEntity) {
        return recordPersonEntity.getPersonName();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<RecordPersonEntity>) (ArrayList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable ArrayList<RecordPersonEntity> arrayList) {
        if (arrayList != null) {
            FastRecordTagScheduleDialog fastRecordTagScheduleDialog = this.this$0;
            fastRecordTagScheduleDialog.setOkTvStateForPersonTag();
            FastRecordTagPersonLayoutBinding access$getPersonTagBinding$p = fastRecordTagScheduleDialog.personTagBinding;
            FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding = null;
            if (access$getPersonTagBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
                access$getPersonTagBinding$p = null;
            }
            access$getPersonTagBinding$p.m.setLabels(arrayList, new f());
            FastRecordTagPersonLayoutBinding access$getPersonTagBinding$p2 = fastRecordTagScheduleDialog.personTagBinding;
            if (access$getPersonTagBinding$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
            } else {
                fastRecordTagPersonLayoutBinding = access$getPersonTagBinding$p2;
            }
            fastRecordTagPersonLayoutBinding.m.requestLayout();
        }
    }
}
