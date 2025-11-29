package com.honey.account.u3;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordBaseActivity;

public final /* synthetic */ class a implements OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FastRecordBaseActivity f5153a;

    public /* synthetic */ a(FastRecordBaseActivity fastRecordBaseActivity) {
        this.f5153a = fastRecordBaseActivity;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return FastRecordBaseActivity.setupContentView$lambda$6$lambda$5(this.f5153a, view, windowInsetsCompat);
    }
}
