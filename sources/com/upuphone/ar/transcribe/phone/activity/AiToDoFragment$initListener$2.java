package com.upuphone.ar.transcribe.phone.activity;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.upuphone.ar.transcribe.databinding.FragmentTranscribeTodoBinding;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/ar/transcribe/phone/activity/AiToDoFragment$initListener$2", "Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AiToDoFragment$initListener$2 extends RecyclerView.SimpleOnItemTouchListener {
    final /* synthetic */ AiToDoFragment this$0;

    public AiToDoFragment$initListener$2(AiToDoFragment aiToDoFragment) {
        this.this$0 = aiToDoFragment;
    }

    public boolean onInterceptTouchEvent(@NotNull RecyclerView recyclerView, @NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(recyclerView, "rv");
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        View findChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AiToDoFragment", "onInterceptTouchEvent: " + findChildViewUnder);
        if (findChildViewUnder != null) {
            return false;
        }
        delegate.a("AiToDoFragment", "rv request focus");
        FragmentTranscribeTodoBinding access$getBinding$p = this.this$0.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        access$getBinding$p.getRoot().requestFocus();
        return false;
    }
}
