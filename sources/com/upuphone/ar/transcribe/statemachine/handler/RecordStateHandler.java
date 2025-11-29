package com.upuphone.ar.transcribe.statemachine.handler;

import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.helper.InterConnectHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0003J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0003¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/transcribe/statemachine/handler/RecordStateHandler;", "", "<init>", "()V", "", "a", "c", "d", "b", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class RecordStateHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6162a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/transcribe/statemachine/handler/RecordStateHandler$Companion;", "", "()V", "TAG", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public final void a() {
        LogExt.g("initRecorder", "GlassRecorderDealHandler");
        InterConnectHelper.c.a().m(1);
    }

    public final void b() {
        LogExt.g("releaseRecorder", "GlassRecorderDealHandler");
        InterConnectHelper.c.a().m(4);
    }

    public final void c() {
        LogExt.g("startRecorder", "GlassRecorderDealHandler");
        InterConnectHelper.c.a().m(2);
    }

    public final void d() {
        LogExt.g("stopRecorder", "GlassRecorderDealHandler");
        InterConnectHelper.c.a().m(3);
    }
}
