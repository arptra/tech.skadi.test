package com.honey.account.j1;

import android.view.View;
import android.widget.EditText;
import com.google.android.material.datepicker.DateSelector;

public final /* synthetic */ class a implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText[] f9772a;

    public /* synthetic */ a(EditText[] editTextArr) {
        this.f9772a = editTextArr;
    }

    public final void onFocusChange(View view, boolean z) {
        DateSelector.lambda$showKeyboardWithAutoHideBehavior$0(this.f9772a, view, z);
    }
}
