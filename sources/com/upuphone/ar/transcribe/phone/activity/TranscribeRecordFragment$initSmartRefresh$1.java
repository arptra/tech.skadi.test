package com.upuphone.ar.transcribe.phone.activity;

import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.simple.SimpleMultiListener;
import com.upuphone.ar.transcribe.databinding.TranscribeRecordFragmentBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nTranscribeRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeRecordFragment.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment$initSmartRefresh$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,488:1\n262#2,2:489\n*S KotlinDebug\n*F\n+ 1 TranscribeRecordFragment.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment$initSmartRefresh$1\n*L\n236#1:489,2\n*E\n"})
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment$initSmartRefresh$1", "Lcom/scwang/smart/refresh/layout/simple/SimpleMultiListener;", "onStateChanged", "", "refreshLayout", "Lcom/scwang/smart/refresh/layout/api/RefreshLayout;", "oldState", "Lcom/scwang/smart/refresh/layout/constant/RefreshState;", "newState", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranscribeRecordFragment$initSmartRefresh$1 extends SimpleMultiListener {
    final /* synthetic */ TranscribeRecordFragment this$0;

    public TranscribeRecordFragment$initSmartRefresh$1(TranscribeRecordFragment transcribeRecordFragment) {
        this.this$0 = transcribeRecordFragment;
    }

    public void onStateChanged(@NotNull RefreshLayout refreshLayout, @NotNull RefreshState refreshState, @NotNull RefreshState refreshState2) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(refreshState, "oldState");
        Intrinsics.checkNotNullParameter(refreshState2, "newState");
        super.onStateChanged(refreshLayout, refreshState, refreshState2);
        TranscribeRecordFragmentBinding access$getBinding$p = this.this$0.binding;
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding = null;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        RecyclerView.LayoutManager layoutManager = access$getBinding$p.f.getLayoutManager();
        if (layoutManager != null && (layoutManager instanceof LinearLayoutManager)) {
            int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            TranscribeRecordFragmentBinding access$getBinding$p2 = this.this$0.binding;
            if (access$getBinding$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                transcribeRecordFragmentBinding = access$getBinding$p2;
            }
            ImageView imageView = transcribeRecordFragmentBinding.d;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivToTop");
            int i = 0;
            if (!(refreshState2 == RefreshState.None && findLastCompletelyVisibleItemPosition > 5)) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }
}
