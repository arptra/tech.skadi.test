package com.honey.account.v4;

import com.upuphone.ar.transcribe.phone.activity.TranscribeStartActivity;
import com.upuphone.ar.transcribe.phone.bean.OperateMessage;

public final /* synthetic */ class i0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OperateMessage f5256a;
    public final /* synthetic */ TranscribeStartActivity b;

    public /* synthetic */ i0(OperateMessage operateMessage, TranscribeStartActivity transcribeStartActivity) {
        this.f5256a = operateMessage;
        this.b = transcribeStartActivity;
    }

    public final void run() {
        TranscribeStartActivity.handleVariousMsg$lambda$10(this.f5256a, this.b);
    }
}
