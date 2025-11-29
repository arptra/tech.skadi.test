package com.upuphone.ar.transcribe.phone;

import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.helper.InterConnectHelper;
import com.upuphone.ar.transcribe.statemachine.listener.TranscribeResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"com/upuphone/ar/transcribe/phone/TranscribeManager$transResultListener$1", "Lcom/upuphone/ar/transcribe/statemachine/listener/TranscribeResultListener;", "", "obj", "", "c", "(Ljava/lang/Object;)V", "b", "d", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranscribeManager$transResultListener$1 implements TranscribeResultListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeManager f6072a;

    public TranscribeManager$transResultListener$1(TranscribeManager transcribeManager) {
        this.f6072a = transcribeManager;
    }

    public void b(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        LogExt.d("发送近端转写结果到眼镜: " + obj, "TranscribeManager");
        if (obj instanceof String) {
            String str = (String) obj;
            InterConnectHelper.c.a().l(str);
            this.f6072a.t(str, 0);
        }
    }

    public void c(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        LogExt.d("发送远端转写结果到眼镜: " + obj, "TranscribeManager");
        if (obj instanceof String) {
            String str = (String) obj;
            InterConnectHelper.c.a().n(str);
            this.f6072a.t(str, 1);
        }
    }

    public void d(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (obj instanceof String) {
            InterConnectHelper.c.a().o((String) obj);
        }
    }
}
