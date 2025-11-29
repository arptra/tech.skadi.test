package com.upuphone.ai.ttsengine.base.service;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.honey.account.o3.c;
import com.upuphone.ai.ttsengine.base.TtsManager;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0002 !B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001e¨\u0006\""}, d2 = {"Lcom/upuphone/ai/ttsengine/base/service/TtsStatusTimer;", "", "Lcom/upuphone/ai/ttsengine/base/service/SpeakCallback;", "speakCallback", "<init>", "(Lcom/upuphone/ai/ttsengine/base/service/SpeakCallback;)V", "", "caller", "text", "id", "", "addTime", "", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "d", "(Ljava/lang/String;)V", "additional", "c", "(Ljava/lang/String;J)J", "e", "(Ljava/lang/String;)J", "a", "Lcom/upuphone/ai/ttsengine/base/service/SpeakCallback;", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "handler", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "Companion", "TtsItem", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TtsStatusTimer {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);
    public static final Regex e = new Regex("[\\u4e00-\\u9fa5]");

    /* renamed from: a  reason: collision with root package name */
    public SpeakCallback f5520a;
    public final Handler b;
    public final AILOG c = AILOG.a("TtsStatusTimer");

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/service/TtsStatusTimer$Companion;", "", "()V", "CHINESE_PATTERN", "Lkotlin/text/Regex;", "MAX_DELAY_TIME", "", "MIN_SPEECH_TIME", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/service/TtsStatusTimer$TtsItem;", "", "", "caller", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class TtsItem {

        /* renamed from: a  reason: collision with root package name */
        public final String f5521a;
        public final String b;

        public TtsItem(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "caller");
            Intrinsics.checkNotNullParameter(str2, "id");
            this.f5521a = str;
            this.b = str2;
        }

        public final String a() {
            return this.f5521a;
        }

        public final String b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TtsItem)) {
                return false;
            }
            TtsItem ttsItem = (TtsItem) obj;
            return Intrinsics.areEqual((Object) this.f5521a, (Object) ttsItem.f5521a) && Intrinsics.areEqual((Object) this.b, (Object) ttsItem.b);
        }

        public int hashCode() {
            return (this.f5521a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            String str = this.f5521a;
            String str2 = this.b;
            return "TtsItem(caller=" + str + ", id=" + str2 + ")";
        }
    }

    public TtsStatusTimer(SpeakCallback speakCallback) {
        this.f5520a = speakCallback;
        HandlerThread handlerThread = new HandlerThread("TTS-STATUS-TIMER");
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper(), new c(this));
    }

    public static final boolean b(TtsStatusTimer ttsStatusTimer, Message message) {
        Intrinsics.checkNotNullParameter(ttsStatusTimer, "this$0");
        Intrinsics.checkNotNullParameter(message, "it");
        Object obj = message.obj;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.ai.ttsengine.base.service.TtsStatusTimer.TtsItem");
        TtsItem ttsItem = (TtsItem) obj;
        AILOG ailog = ttsStatusTimer.c;
        ailog.c("timeout for speak item: " + ttsItem, new Object[0]);
        SpeakCallback speakCallback = ttsStatusTimer.f5520a;
        if (speakCallback == null) {
            return true;
        }
        speakCallback.onError(ttsItem.a(), ttsItem.b(), 8);
        return true;
    }

    public final long c(String str, long j) {
        long max = Math.max(AssistantConstants.TIMEOUT_VAD_MUTE, ((long) (str.length() / 4)) * e(str)) + 8000 + j;
        AILOG ailog = this.c;
        int length = str.length();
        ailog.c("calculate time for: " + length + " is: " + max, new Object[0]);
        return max;
    }

    public final void d(String str) {
        AILOG ailog = this.c;
        int i = 0;
        ailog.c("cancel timer for id: " + str, new Object[0]);
        Handler handler = this.b;
        if (str != null) {
            i = str.hashCode();
        }
        handler.removeMessages(i);
    }

    public final long e(String str) {
        return (!TtsManager.c().e() || !e.containsMatchIn(str)) ? 1000 : 1500;
    }

    public final void f(String str, String str2, String str3, long j) {
        Intrinsics.checkNotNullParameter(str, "caller");
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(str3, "id");
        Message obtain = Message.obtain();
        obtain.what = str3.hashCode();
        TtsItem ttsItem = new TtsItem(str, str3);
        obtain.obj = ttsItem;
        AILOG ailog = this.c;
        ailog.c("start timer for tts Item: " + ttsItem, new Object[0]);
        this.b.sendMessageDelayed(obtain, c(str2, j));
    }
}
