package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.widget.TextView;
import com.upuphone.ar.fastrecord.databinding.FastRecordTagPersonLayoutBinding;
import com.upuphone.ar.fastrecord.phone.db.RecordHistoryPersonEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordTagScheduleDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTagScheduleDialog.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordTagScheduleDialog$initViewModel$5\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,539:1\n262#2,2:540\n*S KotlinDebug\n*F\n+ 1 FastRecordTagScheduleDialog.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordTagScheduleDialog$initViewModel$5\n*L\n192#1:540,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordHistoryPersonEntity;", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordTagScheduleDialog$initViewModel$5 extends Lambda implements Function1<ArrayList<RecordHistoryPersonEntity>, Unit> {
    final /* synthetic */ FastRecordTagScheduleDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTagScheduleDialog$initViewModel$5(FastRecordTagScheduleDialog fastRecordTagScheduleDialog) {
        super(1);
        this.this$0 = fastRecordTagScheduleDialog;
    }

    /* access modifiers changed from: private */
    public static final CharSequence invoke$lambda$1$lambda$0(TextView textView, int i, RecordHistoryPersonEntity recordHistoryPersonEntity) {
        return recordHistoryPersonEntity.getPersonName();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<RecordHistoryPersonEntity>) (ArrayList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable ArrayList<RecordHistoryPersonEntity> arrayList) {
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding = null;
        if (Intrinsics.areEqual((Object) "normal_mode", (Object) this.this$0.curModel) && this.this$0.isPersonTagType()) {
            FastRecordTagPersonLayoutBinding access$getPersonTagBinding$p = this.this$0.personTagBinding;
            if (access$getPersonTagBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
                access$getPersonTagBinding$p = null;
            }
            TextView textView = access$getPersonTagBinding$p.r;
            Intrinsics.checkNotNullExpressionValue(textView, "tvTipHistoryPerson");
            int i = 0;
            if (!(true ^ (arrayList == null || arrayList.isEmpty()))) {
                i = 8;
            }
            textView.setVisibility(i);
        }
        this.this$0.setOkTvStateForPersonTag();
        if (arrayList != null) {
            FastRecordTagScheduleDialog fastRecordTagScheduleDialog = this.this$0;
            FastRecordTagPersonLayoutBinding access$getPersonTagBinding$p2 = fastRecordTagScheduleDialog.personTagBinding;
            if (access$getPersonTagBinding$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
                access$getPersonTagBinding$p2 = null;
            }
            access$getPersonTagBinding$p2.l.setLabels(arrayList, new e());
            FastRecordTagPersonLayoutBinding access$getPersonTagBinding$p3 = fastRecordTagScheduleDialog.personTagBinding;
            if (access$getPersonTagBinding$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
            } else {
                fastRecordTagPersonLayoutBinding = access$getPersonTagBinding$p3;
            }
            fastRecordTagPersonLayoutBinding.l.requestLayout();
        }
    }
}
