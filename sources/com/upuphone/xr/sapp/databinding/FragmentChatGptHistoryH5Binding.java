package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentChatGptHistoryH5Binding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f6775a;
    public final ViewStub b;

    public FragmentChatGptHistoryH5Binding(FrameLayout frameLayout, ViewStub viewStub) {
        this.f6775a = frameLayout;
        this.b = viewStub;
    }

    public static FragmentChatGptHistoryH5Binding a(View view) {
        int i = R.id.view_stub_load_fail;
        ViewStub viewStub = (ViewStub) ViewBindings.a(view, i);
        if (viewStub != null) {
            return new FragmentChatGptHistoryH5Binding((FrameLayout) view, viewStub);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentChatGptHistoryH5Binding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_chat_gpt_history_h5, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f6775a;
    }
}
