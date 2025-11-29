package com.honey.account.g8;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.upuphone.xr.sapp.dialog.EditScheduleDialog;

public final /* synthetic */ class a implements OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditScheduleDialog f4472a;

    public /* synthetic */ a(EditScheduleDialog editScheduleDialog) {
        this.f4472a = editScheduleDialog;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return EditScheduleDialog.n0(this.f4472a, view, windowInsetsCompat);
    }
}
