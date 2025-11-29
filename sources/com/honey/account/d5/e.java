package com.honey.account.d5;

import com.upuphone.ar.translation.phone.activity.TranslatorMainActivity;
import com.upuphone.ar.translation.phone.bean.OperateMessage;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OperateMessage f4310a;
    public final /* synthetic */ TranslatorMainActivity b;

    public /* synthetic */ e(OperateMessage operateMessage, TranslatorMainActivity translatorMainActivity) {
        this.f4310a = operateMessage;
        this.b = translatorMainActivity;
    }

    public final void run() {
        TranslatorMainActivity.handleVariousMsg$lambda$11(this.f4310a, this.b);
    }
}
