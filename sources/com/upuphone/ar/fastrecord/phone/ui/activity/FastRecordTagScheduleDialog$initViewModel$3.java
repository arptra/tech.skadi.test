package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.widget.TextView;
import com.upuphone.ar.fastrecord.databinding.FastRecordTagContentLayoutBinding;
import com.upuphone.ar.fastrecord.phone.db.RecordContentHistoryTagEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordTagScheduleDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTagScheduleDialog.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordTagScheduleDialog$initViewModel$3\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,539:1\n262#2,2:540\n*S KotlinDebug\n*F\n+ 1 FastRecordTagScheduleDialog.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordTagScheduleDialog$initViewModel$3\n*L\n173#1:540,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordContentHistoryTagEntity;", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordTagScheduleDialog$initViewModel$3 extends Lambda implements Function1<ArrayList<RecordContentHistoryTagEntity>, Unit> {
    final /* synthetic */ FastRecordTagScheduleDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTagScheduleDialog$initViewModel$3(FastRecordTagScheduleDialog fastRecordTagScheduleDialog) {
        super(1);
        this.this$0 = fastRecordTagScheduleDialog;
    }

    /* access modifiers changed from: private */
    public static final CharSequence invoke$lambda$1$lambda$0(TextView textView, int i, RecordContentHistoryTagEntity recordContentHistoryTagEntity) {
        return recordContentHistoryTagEntity.getContentName();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<RecordContentHistoryTagEntity>) (ArrayList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable ArrayList<RecordContentHistoryTagEntity> arrayList) {
        FastRecordTagContentLayoutBinding access$getContentTagBinding$p = this.this$0.contentTagBinding;
        FastRecordTagContentLayoutBinding fastRecordTagContentLayoutBinding = null;
        if (access$getContentTagBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTagBinding");
            access$getContentTagBinding$p = null;
        }
        TextView textView = access$getContentTagBinding$p.g;
        Intrinsics.checkNotNullExpressionValue(textView, "tvTipHistoryTag");
        int i = 0;
        if (!(true ^ (arrayList == null || arrayList.isEmpty()))) {
            i = 8;
        }
        textView.setVisibility(i);
        this.this$0.setOkTvStateForContentTag();
        if (arrayList != null) {
            FastRecordTagScheduleDialog fastRecordTagScheduleDialog = this.this$0;
            FastRecordTagContentLayoutBinding access$getContentTagBinding$p2 = fastRecordTagScheduleDialog.contentTagBinding;
            if (access$getContentTagBinding$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentTagBinding");
                access$getContentTagBinding$p2 = null;
            }
            access$getContentTagBinding$p2.d.setLabels(arrayList, new c());
            FastRecordTagContentLayoutBinding access$getContentTagBinding$p3 = fastRecordTagScheduleDialog.contentTagBinding;
            if (access$getContentTagBinding$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentTagBinding");
            } else {
                fastRecordTagContentLayoutBinding = access$getContentTagBinding$p3;
            }
            fastRecordTagContentLayoutBinding.d.requestLayout();
        }
    }
}
