package com.honey.account.v4;

import com.upuphone.ar.transcribe.phone.activity.TranscribeStartActivity;
import com.upuphone.ar.transcribe.phone.bean.TransStateEvent;

public final /* synthetic */ class m0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TransStateEvent f5262a;
    public final /* synthetic */ TranscribeStartActivity b;

    public /* synthetic */ m0(TransStateEvent transStateEvent, TranscribeStartActivity transcribeStartActivity) {
        this.f5262a = transStateEvent;
        this.b = transcribeStartActivity;
    }

    public final void run() {
        TranscribeStartActivity.handleTranslateState$lambda$12(this.f5262a, this.b);
    }
}
