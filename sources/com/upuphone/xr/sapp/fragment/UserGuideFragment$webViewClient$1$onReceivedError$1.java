package com.upuphone.xr.sapp.fragment;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class UserGuideFragment$webViewClient$1$onReceivedError$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UserGuideFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserGuideFragment$webViewClient$1$onReceivedError$1(UserGuideFragment userGuideFragment) {
        super(0);
        this.this$0 = userGuideFragment;
    }

    public final void invoke() {
        Intent intent = new Intent("android.settings.SETTINGS");
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.startActivity(intent);
        }
    }
}
