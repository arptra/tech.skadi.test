package com.upuphone.ar.translation.phone.fragment;

import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.simple.SimpleMultiListener;
import com.upuphone.ar.translation.phone.databinding.TransRecordFragmentBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTransRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransRecordFragment.kt\ncom/upuphone/ar/translation/phone/fragment/TransRecordFragment$initSmartRefresh$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,565:1\n262#2,2:566\n*S KotlinDebug\n*F\n+ 1 TransRecordFragment.kt\ncom/upuphone/ar/translation/phone/fragment/TransRecordFragment$initSmartRefresh$1\n*L\n248#1:566,2\n*E\n"})
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/upuphone/ar/translation/phone/fragment/TransRecordFragment$initSmartRefresh$1", "Lcom/scwang/smart/refresh/layout/simple/SimpleMultiListener;", "onStateChanged", "", "refreshLayout", "Lcom/scwang/smart/refresh/layout/api/RefreshLayout;", "oldState", "Lcom/scwang/smart/refresh/layout/constant/RefreshState;", "newState", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TransRecordFragment$initSmartRefresh$1 extends SimpleMultiListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TransRecordFragment f6293a;

    public TransRecordFragment$initSmartRefresh$1(TransRecordFragment transRecordFragment) {
        this.f6293a = transRecordFragment;
    }

    public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(refreshState, "oldState");
        Intrinsics.checkNotNullParameter(refreshState2, "newState");
        super.onStateChanged(refreshLayout, refreshState, refreshState2);
        TransRecordFragmentBinding m0 = this.f6293a.f6290a;
        TransRecordFragmentBinding transRecordFragmentBinding = null;
        if (m0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            m0 = null;
        }
        RecyclerView.LayoutManager layoutManager = m0.f.getLayoutManager();
        if (layoutManager != null) {
            TransRecordFragment transRecordFragment = this.f6293a;
            if (layoutManager instanceof LinearLayoutManager) {
                int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
                TransRecordFragmentBinding m02 = transRecordFragment.f6290a;
                if (m02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    transRecordFragmentBinding = m02;
                }
                ImageView imageView = transRecordFragmentBinding.d;
                Intrinsics.checkNotNullExpressionValue(imageView, "ivToTop");
                int i = 0;
                if (!(refreshState2 == RefreshState.None && findLastCompletelyVisibleItemPosition > 5)) {
                    i = 8;
                }
                imageView.setVisibility(i);
            }
        }
    }
}
