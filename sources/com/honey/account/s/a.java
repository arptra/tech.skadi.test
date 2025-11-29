package com.honey.account.s;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;

public final /* synthetic */ class a implements InputConnectionCompat.OnCommitContentListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f3088a;

    public /* synthetic */ a(View view) {
        this.f3088a = view;
    }

    public final boolean a(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
        return InputConnectionCompat.f(this.f3088a, inputContentInfoCompat, i, bundle);
    }
}
