package com.upuphone.xr.sapp.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.upuphone.xr.sapp.databinding.FragmentOpinionFeedbackBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/upuphone/xr/sapp/fragment/OpinionFeedbackFragment$initView$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OpinionFeedbackFragment$initView$3 implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OpinionFeedbackFragment f6986a;

    public OpinionFeedbackFragment$initView$3(OpinionFeedbackFragment opinionFeedbackFragment) {
        this.f6986a = opinionFeedbackFragment;
    }

    public void afterTextChanged(Editable editable) {
        FragmentOpinionFeedbackBinding F0 = this.f6986a.j;
        Integer num = null;
        if (F0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            F0 = null;
        }
        TextView textView = F0.n;
        if (editable != null) {
            num = Integer.valueOf(editable.length());
        }
        textView.setText(num + "/300");
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
