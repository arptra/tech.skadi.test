package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentFeedbackBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 FeedBackFragment.kt\ncom/upuphone/xr/sapp/fragment/FeedBackFragment\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 5 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n334#2,4:98\n339#2,4:103\n1#3:102\n71#4:107\n77#5:108\n*E\n"})
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FeedBackFragment$initView$$inlined$addTextChangedListener$default$1 implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedBackFragment f6953a;

    public FeedBackFragment$initView$$inlined$addTextChangedListener$default$1(FeedBackFragment feedBackFragment) {
        this.f6953a = feedBackFragment;
    }

    public void afterTextChanged(Editable editable) {
        if (editable != null) {
            if (editable.length() > 300) {
                editable.delete(300, editable.length());
                if (this.f6953a.getContext() != null) {
                    UToast.Companion companion = UToast.f6444a;
                    Context requireContext = this.f6953a.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                    String string = this.f6953a.getString(R.string.edit_limit);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    companion.d(requireContext, string);
                }
            }
            String str = editable.length() + "/300";
            FragmentFeedbackBinding N0 = this.f6953a.j;
            if (N0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                N0 = null;
            }
            N0.g.setText(str);
            this.f6953a.G1();
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
