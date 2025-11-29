package com.honey.account.i2;

import android.content.Context;
import android.widget.EditText;
import com.honey.account.utils.system.InputMethodUtilsKt;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f9203a;
    public final /* synthetic */ Context b;

    public /* synthetic */ a(EditText editText, Context context) {
        this.f9203a = editText;
        this.b = context;
    }

    public final void run() {
        InputMethodUtilsKt.showInputMethod$lambda$0(this.f9203a, this.b);
    }
}
