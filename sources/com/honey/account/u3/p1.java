package com.honey.account.u3;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordTagScheduleDialog;

public final /* synthetic */ class p1 implements OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FastRecordTagScheduleDialog f5198a;

    public /* synthetic */ p1(FastRecordTagScheduleDialog fastRecordTagScheduleDialog) {
        this.f5198a = fastRecordTagScheduleDialog;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return FastRecordTagScheduleDialog.setupContentView$lambda$3$lambda$2(this.f5198a, view, windowInsetsCompat);
    }
}
