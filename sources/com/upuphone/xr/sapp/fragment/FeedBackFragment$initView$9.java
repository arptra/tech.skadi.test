package com.upuphone.xr.sapp.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentFeedbackBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"com/upuphone/xr/sapp/fragment/FeedBackFragment$initView$9", "Landroid/text/TextWatcher;", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", "p2", "p3", "onTextChanged", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FeedBackFragment$initView$9 implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedBackFragment f6955a;

    public FeedBackFragment$initView$9(FeedBackFragment feedBackFragment) {
        this.f6955a = feedBackFragment;
    }

    public void afterTextChanged(Editable editable) {
        FragmentFeedbackBinding N0 = this.f6955a.j;
        FragmentFeedbackBinding fragmentFeedbackBinding = null;
        if (N0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            N0 = null;
        }
        N0.e.setBackgroundResource(R.drawable.bg_feedback_input);
        FragmentFeedbackBinding N02 = this.f6955a.j;
        if (N02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentFeedbackBinding = N02;
        }
        fragmentFeedbackBinding.f.setVisibility(8);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
