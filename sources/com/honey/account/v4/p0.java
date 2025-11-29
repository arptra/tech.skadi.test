package com.honey.account.v4;

import com.upuphone.ar.transcribe.phone.activity.TranscribeStartActivity;
import com.upuphone.ar.transcribe.phone.listener.SwitchLangCallback;

public final /* synthetic */ class p0 implements SwitchLangCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeStartActivity f5267a;

    public /* synthetic */ p0(TranscribeStartActivity transcribeStartActivity) {
        this.f5267a = transcribeStartActivity;
    }

    public final void a(int i, String str, String str2) {
        TranscribeStartActivity.initListener$lambda$1(this.f5267a, i, str, str2);
    }
}
