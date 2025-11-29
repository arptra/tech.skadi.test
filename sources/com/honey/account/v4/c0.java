package com.honey.account.v4;

import android.view.KeyEvent;
import android.widget.TextView;
import com.upuphone.ar.transcribe.phone.activity.TranscribeSearchActivity;

public final /* synthetic */ class c0 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeSearchActivity f5245a;

    public /* synthetic */ c0(TranscribeSearchActivity transcribeSearchActivity) {
        this.f5245a = transcribeSearchActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return TranscribeSearchActivity.initViews$lambda$5(this.f5245a, textView, i, keyEvent);
    }
}
