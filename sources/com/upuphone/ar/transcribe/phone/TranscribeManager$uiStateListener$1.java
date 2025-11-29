package com.upuphone.ar.transcribe.phone;

import com.upuphone.ar.transcribe.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.phone.helper.InterConnectHelper;
import com.upuphone.ar.transcribe.phone.helper.TranscribeDBHelper;
import com.upuphone.ar.transcribe.phone.network.NetworkConnectManager;
import com.upuphone.ar.transcribe.statemachine.listener.UiStateListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/upuphone/ar/transcribe/phone/TranscribeManager$uiStateListener$1", "Lcom/upuphone/ar/transcribe/statemachine/listener/UiStateListener;", "", "state", "expCode", "", "a", "(II)V", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranscribeManager$uiStateListener$1 implements UiStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeManager f6073a;

    public TranscribeManager$uiStateListener$1(TranscribeManager transcribeManager) {
        this.f6073a = transcribeManager;
    }

    public void a(int i, int i2) {
        TranscribeBean k;
        String transResult;
        String e = InterconnectMsgCodExtKt.e(i);
        LogExt.d("notifyStateChanged state=" + i + ", stateStr=" + e, "TranscribeManager");
        String d = InterconnectMsgCodExtKt.d(i2);
        LogExt.d("notifyStateChanged expCode=" + i + ", expStr = " + d, "TranscribeManager");
        boolean j = this.f6073a.h().j(i);
        if (j && (k = TranscribeDBHelper.f6108a.k()) != null && (transResult = k.getTransResult()) != null && transResult.length() > 0) {
            InterConnectHelper.c.a().y();
        }
        this.f6073a.o(i, i2);
        this.f6073a.p(i, i2);
        if (j) {
            TranscribeDBHelper.f6108a.v();
        }
        this.f6073a.q(i, i2);
        NetworkConnectManager a2 = this.f6073a.d;
        if (a2 != null) {
            a2.v(i);
        }
    }
}
