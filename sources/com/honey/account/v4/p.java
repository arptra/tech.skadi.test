package com.honey.account.v4;

import android.view.View;
import android.view.WindowInsets;
import com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity;

public final /* synthetic */ class p implements View.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeDetailActivity f5266a;
    public final /* synthetic */ int b;

    public /* synthetic */ p(TranscribeDetailActivity transcribeDetailActivity, int i) {
        this.f5266a = transcribeDetailActivity;
        this.b = i;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return TranscribeDetailActivity.adjustSoftInputHeight$lambda$1(this.f5266a, this.b, view, windowInsets);
    }
}
