package com.upuphone.ar.transcribe.phone.activity;

import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.upuphone.ar.transcribe.databinding.TranscribeRecordFragmentBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nTranscribeRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeRecordFragment.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment$initAdapter$4\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,488:1\n262#2,2:489\n*S KotlinDebug\n*F\n+ 1 TranscribeRecordFragment.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment$initAdapter$4\n*L\n216#1:489,2\n*E\n"})
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment$initAdapter$4", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranscribeRecordFragment$initAdapter$4 extends RecyclerView.OnScrollListener {
    final /* synthetic */ TranscribeRecordFragment this$0;

    public TranscribeRecordFragment$initAdapter$4(TranscribeRecordFragment transcribeRecordFragment) {
        this.this$0 = transcribeRecordFragment;
    }

    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            TranscribeRecordFragmentBinding access$getBinding$p = this.this$0.binding;
            if (access$getBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p = null;
            }
            ImageView imageView = access$getBinding$p.d;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivToTop");
            int i2 = 0;
            if (!(i == 0 && findLastCompletelyVisibleItemPosition > 5)) {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }
}
