package com.upuphone.ar.fastrecord.phone.ui.fragment;

import android.widget.ImageView;
import android.widget.TextView;
import com.upuphone.ar.fastrecord.databinding.FastRecordTodoFragmentLayoutBinding;
import com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordTodoViewAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordTodoFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTodoFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordTodoFragment$initViewModel$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,475:1\n262#2,2:476\n262#2,2:478\n262#2,2:480\n262#2,2:482\n262#2,2:484\n*S KotlinDebug\n*F\n+ 1 FastRecordTodoFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordTodoFragment$initViewModel$2\n*L\n342#1:476,2\n350#1:478,2\n351#1:480,2\n353#1:482,2\n354#1:484,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/upuphone/ar/fastrecord/phone/db/RecordTodoItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordTodoFragment$initViewModel$2 extends Lambda implements Function1<List<? extends RecordTodoItemEntity>, Unit> {
    final /* synthetic */ FastRecordTodoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTodoFragment$initViewModel$2(FastRecordTodoFragment fastRecordTodoFragment) {
        super(1);
        this.this$0 = fastRecordTodoFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<RecordTodoItemEntity>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable List<RecordTodoItemEntity> list) {
        this.this$0.setBottomBtnState();
        FastRecordTodoFragmentLayoutBinding access$getBinding$p = this.this$0.binding;
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding = null;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        access$getBinding$p.g.setVisibility(8);
        FastRecordTodoFragmentLayoutBinding access$getBinding$p2 = this.this$0.binding;
        if (access$getBinding$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p2 = null;
        }
        TextView textView = access$getBinding$p2.i;
        Intrinsics.checkNotNullExpressionValue(textView, "tvExtractTip");
        textView.setVisibility(8);
        this.this$0.updateTitleBarStatus();
        if (list != null) {
            FastRecordTodoFragment fastRecordTodoFragment = this.this$0;
            FastRecordTodoViewAdapter access$getViewAdapter$p = fastRecordTodoFragment.viewAdapter;
            if (access$getViewAdapter$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                access$getViewAdapter$p = null;
            }
            access$getViewAdapter$p.notifyData((ArrayList) list);
            if (list.get(0).isReport()) {
                FastRecordTodoFragmentLayoutBinding access$getBinding$p3 = fastRecordTodoFragment.binding;
                if (access$getBinding$p3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    access$getBinding$p3 = null;
                }
                ImageView imageView = access$getBinding$p3.b;
                Intrinsics.checkNotNullExpressionValue(imageView, "ivFeedback");
                imageView.setVisibility(8);
                FastRecordTodoFragmentLayoutBinding access$getBinding$p4 = fastRecordTodoFragment.binding;
                if (access$getBinding$p4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fastRecordTodoFragmentLayoutBinding = access$getBinding$p4;
                }
                TextView textView2 = fastRecordTodoFragmentLayoutBinding.j;
                Intrinsics.checkNotNullExpressionValue(textView2, "tvFeedback");
                textView2.setVisibility(0);
                return;
            }
            FastRecordTodoFragmentLayoutBinding access$getBinding$p5 = fastRecordTodoFragment.binding;
            if (access$getBinding$p5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p5 = null;
            }
            ImageView imageView2 = access$getBinding$p5.b;
            Intrinsics.checkNotNullExpressionValue(imageView2, "ivFeedback");
            imageView2.setVisibility(0);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p6 = fastRecordTodoFragment.binding;
            if (access$getBinding$p6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fastRecordTodoFragmentLayoutBinding = access$getBinding$p6;
            }
            TextView textView3 = fastRecordTodoFragmentLayoutBinding.j;
            Intrinsics.checkNotNullExpressionValue(textView3, "tvFeedback");
            textView3.setVisibility(8);
        }
    }
}
