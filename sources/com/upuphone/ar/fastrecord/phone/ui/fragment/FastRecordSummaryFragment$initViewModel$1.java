package com.upuphone.ar.fastrecord.phone.ui.fragment;

import android.widget.ImageView;
import android.widget.TextView;
import com.upuphone.ar.fastrecord.databinding.FastRecordSummaryFragmentLayoutBinding;
import com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.widget.CopyEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordSummaryFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordSummaryFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordSummaryFragment$initViewModel$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,429:1\n262#2,2:430\n262#2,2:432\n262#2,2:434\n262#2,2:436\n*S KotlinDebug\n*F\n+ 1 FastRecordSummaryFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordSummaryFragment$initViewModel$1\n*L\n289#1:430,2\n290#1:432,2\n292#1:434,2\n293#1:436,2\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ar/fastrecord/phone/db/RecordSummaryEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordSummaryFragment$initViewModel$1 extends Lambda implements Function1<RecordSummaryEntity, Unit> {
    final /* synthetic */ FastRecordSummaryFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordSummaryFragment$initViewModel$1(FastRecordSummaryFragment fastRecordSummaryFragment) {
        super(1);
        this.this$0 = fastRecordSummaryFragment;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(FastRecordSummaryFragment fastRecordSummaryFragment) {
        Intrinsics.checkNotNullParameter(fastRecordSummaryFragment, "this$0");
        FastRecordSummaryFragmentLayoutBinding access$getBinding$p = fastRecordSummaryFragment.binding;
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding = null;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        int height = access$getBinding$p.o.getHeight();
        LogExt.logE("llStatementTip tvSummaryStatement height = " + height, "SummaryFragment");
        if (height > 0) {
            FastRecordSummaryFragmentLayoutBinding access$getBinding$p2 = fastRecordSummaryFragment.binding;
            if (access$getBinding$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p2 = null;
            }
            access$getBinding$p2.i.setPadding(0, 0, 0, height);
            FastRecordSummaryFragmentLayoutBinding access$getBinding$p3 = fastRecordSummaryFragment.binding;
            if (access$getBinding$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fastRecordSummaryFragmentLayoutBinding = access$getBinding$p3;
            }
            fastRecordSummaryFragmentLayoutBinding.i.requestLayout();
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RecordSummaryEntity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable RecordSummaryEntity recordSummaryEntity) {
        this.this$0.setBottomBtnState();
        this.this$0.updateTitleBarStatus();
        if (recordSummaryEntity != null) {
            FastRecordSummaryFragment fastRecordSummaryFragment = this.this$0;
            FastRecordSummaryFragmentLayoutBinding access$getBinding$p = fastRecordSummaryFragment.binding;
            FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding = null;
            if (access$getBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p = null;
            }
            access$getBinding$p.o.setVisibility(0);
            fastRecordSummaryFragment.showFeedBackState(true);
            fastRecordSummaryFragment.refreshViewShow(false);
            FastRecordSummaryFragmentLayoutBinding access$getBinding$p2 = fastRecordSummaryFragment.binding;
            if (access$getBinding$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p2 = null;
            }
            CopyEditText copyEditText = access$getBinding$p2.d;
            String contentTemp = recordSummaryEntity.getContentTemp();
            copyEditText.setText(contentTemp != null ? StringsKt.trim((CharSequence) contentTemp).toString() : null);
            FastRecordSummaryFragmentLayoutBinding access$getBinding$p3 = fastRecordSummaryFragment.binding;
            if (access$getBinding$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p3 = null;
            }
            TextView textView = access$getBinding$p3.l;
            String contentTemp2 = recordSummaryEntity.getContentTemp();
            textView.setText(contentTemp2 != null ? StringsKt.trim((CharSequence) contentTemp2).toString() : null);
            LogExt.logE("summaryLiveData value = " + recordSummaryEntity.getContentTemp(), "SummaryFragment");
            FastRecordSummaryFragmentLayoutBinding access$getBinding$p4 = fastRecordSummaryFragment.binding;
            if (access$getBinding$p4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p4 = null;
            }
            access$getBinding$p4.o.post(new a(fastRecordSummaryFragment));
            if (recordSummaryEntity.isReport()) {
                FastRecordSummaryFragmentLayoutBinding access$getBinding$p5 = fastRecordSummaryFragment.binding;
                if (access$getBinding$p5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    access$getBinding$p5 = null;
                }
                ImageView imageView = access$getBinding$p5.e;
                Intrinsics.checkNotNullExpressionValue(imageView, "ivFeedback");
                imageView.setVisibility(8);
                FastRecordSummaryFragmentLayoutBinding access$getBinding$p6 = fastRecordSummaryFragment.binding;
                if (access$getBinding$p6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fastRecordSummaryFragmentLayoutBinding = access$getBinding$p6;
                }
                TextView textView2 = fastRecordSummaryFragmentLayoutBinding.n;
                Intrinsics.checkNotNullExpressionValue(textView2, "tvFeedback");
                textView2.setVisibility(0);
                return;
            }
            FastRecordSummaryFragmentLayoutBinding access$getBinding$p7 = fastRecordSummaryFragment.binding;
            if (access$getBinding$p7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p7 = null;
            }
            ImageView imageView2 = access$getBinding$p7.e;
            Intrinsics.checkNotNullExpressionValue(imageView2, "ivFeedback");
            imageView2.setVisibility(0);
            FastRecordSummaryFragmentLayoutBinding access$getBinding$p8 = fastRecordSummaryFragment.binding;
            if (access$getBinding$p8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fastRecordSummaryFragmentLayoutBinding = access$getBinding$p8;
            }
            TextView textView3 = fastRecordSummaryFragmentLayoutBinding.n;
            Intrinsics.checkNotNullExpressionValue(textView3, "tvFeedback");
            textView3.setVisibility(8);
        }
    }
}
