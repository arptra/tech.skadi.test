package com.upuphone.ar.translation.phone.fragment;

import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.upuphone.ar.translation.phone.databinding.TransRecordFragmentBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTransRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransRecordFragment.kt\ncom/upuphone/ar/translation/phone/fragment/TransRecordFragment$initAdapter$4\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,565:1\n262#2,2:566\n*S KotlinDebug\n*F\n+ 1 TransRecordFragment.kt\ncom/upuphone/ar/translation/phone/fragment/TransRecordFragment$initAdapter$4\n*L\n223#1:566,2\n*E\n"})
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/ar/translation/phone/fragment/TransRecordFragment$initAdapter$4", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TransRecordFragment$initAdapter$4 extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TransRecordFragment f6292a;

    public TransRecordFragment$initAdapter$4(TransRecordFragment transRecordFragment) {
        this.f6292a = transRecordFragment;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            TransRecordFragment transRecordFragment = this.f6292a;
            if (layoutManager instanceof LinearLayoutManager) {
                int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
                TransRecordFragmentBinding m0 = transRecordFragment.f6290a;
                if (m0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    m0 = null;
                }
                ImageView imageView = m0.d;
                Intrinsics.checkNotNullExpressionValue(imageView, "ivToTop");
                int i2 = 0;
                if (!(i == 0 && findLastCompletelyVisibleItemPosition > 5)) {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
            }
        }
    }
}
