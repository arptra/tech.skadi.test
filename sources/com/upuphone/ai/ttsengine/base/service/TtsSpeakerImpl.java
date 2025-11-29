package com.upuphone.ai.ttsengine.base.service;

import android.content.Context;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.upuphone.ai.ttsengine.base.service.RequestQueue;
import com.upuphone.ai.ttsengine.base.service.TtsImpl;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.ai.ttsengine.base.utils.NumberUtilsKt;
import com.upuphone.ai.ttsengine.base.utils.PackageUtils;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 L2\u00020\u0001:\u0003MNOB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u001d\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ/\u0010 \u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010$\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\nH\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\nH\u0002¢\u0006\u0004\b&\u0010'J;\u0010+\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010)2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b+\u0010,J#\u0010-\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b-\u0010.J\u001f\u0010/\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b/\u00100R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001c\u00107\u001a\n 4*\u0004\u0018\u000103038\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R2\u0010C\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0?j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e`@8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006P"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/service/TtsSpeakerImpl;", "Lcom/upuphone/ai/ttsengine/base/service/ITtsSpeaker;", "Landroid/content/Context;", "context", "Lcom/upuphone/ai/ttsengine/base/service/SpeakCallback;", "speakCallback", "<init>", "(Landroid/content/Context;Lcom/upuphone/ai/ttsengine/base/service/SpeakCallback;)V", "", "caller", "", "streamType", "Landroid/media/AudioAttributes;", "audioAttributes", "Lcom/upuphone/ai/ttsengine/base/service/RequestQueue;", "k", "(Ljava/lang/String;ILandroid/media/AudioAttributes;)Lcom/upuphone/ai/ttsengine/base/service/RequestQueue;", "id", "", "n", "(Ljava/lang/String;Ljava/lang/String;)V", "priority", "stopType", "m", "(II)V", "text", "queueMode", "Landroid/os/Bundle;", "params", "l", "(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)V", "", "j", "(Ljava/lang/String;Ljava/lang/String;II)Z", "queue", "delay", "p", "(Lcom/upuphone/ai/ttsengine/base/service/RequestQueue;I)V", "o", "(I)V", "callingInstance", "", "utteranceId", "q", "(Ljava/lang/String;Ljava/lang/CharSequence;ILandroid/os/Bundle;Ljava/lang/String;)Z", "s", "(Ljava/lang/String;Ljava/lang/String;)I", "r", "(II)I", "a", "Lcom/upuphone/ai/ttsengine/base/service/SpeakCallback;", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "b", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "c", "Landroid/content/Context;", "applicationContext", "Lcom/upuphone/ai/ttsengine/base/service/TtsImplPool;", "d", "Lcom/upuphone/ai/ttsengine/base/service/TtsImplPool;", "implPool", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "e", "Ljava/util/HashMap;", "implMap", "Landroid/os/Handler;", "f", "Landroid/os/Handler;", "processHandler", "Lcom/upuphone/ai/ttsengine/base/service/TtsStatusTimer;", "g", "Lcom/upuphone/ai/ttsengine/base/service/TtsStatusTimer;", "statusTimer", "h", "Companion", "SpeakRequestParam", "TtsImplCallback", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTtsSpeakerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TtsSpeakerImpl.kt\ncom/upuphone/ai/ttsengine/base/service/TtsSpeakerImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,555:1\n1855#2,2:556\n1747#2,3:567\n1747#2,3:570\n766#2:582\n857#2,2:583\n2333#2,14:585\n1855#2:599\n1856#2:601\n526#3:558\n511#3,6:559\n526#3:573\n511#3,6:574\n215#4,2:565\n215#4,2:580\n1#5:600\n*S KotlinDebug\n*F\n+ 1 TtsSpeakerImpl.kt\ncom/upuphone/ai/ttsengine/base/service/TtsSpeakerImpl\n*L\n136#1:556,2\n202#1:567,3\n211#1:570,3\n241#1:582\n241#1:583,2\n243#1:585,14\n439#1:599\n439#1:601\n144#1:558\n144#1:559,6\n215#1:573\n215#1:574,6\n151#1:565,2\n224#1:580,2\n*E\n"})
public final class TtsSpeakerImpl implements ITtsSpeaker {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public SpeakCallback f5516a;
    public final AILOG b = AILOG.a("TtsSpeakerImpl");
    public Context c;
    public TtsImplPool d;
    public HashMap e;
    public Handler f;
    public TtsStatusTimer g;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/service/TtsSpeakerImpl$Companion;", "", "()V", "ADD_SPEECH_REQUEST", "", "GIVE_BACK_IMPL", "PARAM_KEY_PRIORITY", "", "PAUSE_SPEECH_REQUEST", "QUEUE_PROCESS_ITEM", "RESUME_SPEECH_REQUEST", "STOP_SPEECH_PRIORITY", "STOP_SPEECH_REQUEST", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u0017R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001d\u0010\u001eR\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001f\u001a\u0004\b\u0018\u0010 \"\u0004\b!\u0010\"R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u0017¨\u0006&"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/service/TtsSpeakerImpl$SpeakRequestParam;", "", "", "caller", "text", "", "queueMode", "Landroid/os/Bundle;", "params", "utteranceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "setCaller", "(Ljava/lang/String;)V", "b", "d", "setText", "c", "I", "setQueueMode", "(I)V", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "setParams", "(Landroid/os/Bundle;)V", "e", "getUtteranceId", "setUtteranceId", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class SpeakRequestParam {

        /* renamed from: a  reason: collision with root package name */
        public String f5518a;
        public String b;
        public int c;
        public Bundle d;
        public String e;

        public SpeakRequestParam(String str, String str2, int i, Bundle bundle, String str3) {
            Intrinsics.checkNotNullParameter(str, "caller");
            Intrinsics.checkNotNullParameter(str2, "text");
            Intrinsics.checkNotNullParameter(bundle, PayloadConstant.KEY_PARAMS);
            Intrinsics.checkNotNullParameter(str3, "utteranceId");
            this.f5518a = str;
            this.b = str2;
            this.c = i;
            this.d = bundle;
            this.e = str3;
        }

        public final String a() {
            return this.f5518a;
        }

        public final Bundle b() {
            return this.d;
        }

        public final int c() {
            return this.c;
        }

        public final String d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SpeakRequestParam)) {
                return false;
            }
            SpeakRequestParam speakRequestParam = (SpeakRequestParam) obj;
            return Intrinsics.areEqual((Object) this.f5518a, (Object) speakRequestParam.f5518a) && Intrinsics.areEqual((Object) this.b, (Object) speakRequestParam.b) && this.c == speakRequestParam.c && Intrinsics.areEqual((Object) this.d, (Object) speakRequestParam.d) && Intrinsics.areEqual((Object) this.e, (Object) speakRequestParam.e);
        }

        public int hashCode() {
            return (((((((this.f5518a.hashCode() * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public String toString() {
            String str = this.f5518a;
            String str2 = this.b;
            int i = this.c;
            Bundle bundle = this.d;
            String str3 = this.e;
            return "SpeakRequestParam(caller=" + str + ", text=" + str2 + ", queueMode=" + i + ", params=" + bundle + ", utteranceId=" + str3 + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/service/TtsSpeakerImpl$TtsImplCallback;", "Lcom/upuphone/ai/ttsengine/base/service/TtsImpl$TtsCallback;", "<init>", "(Lcom/upuphone/ai/ttsengine/base/service/TtsSpeakerImpl;)V", "", "caller", "id", "", "a", "(Ljava/lang/String;Ljava/lang/String;)V", "onStart", "()V", "b", "", "errorCode", "onError", "(I)V", "Ljava/lang/String;", "getCaller", "()Ljava/lang/String;", "setCaller", "(Ljava/lang/String;)V", "getUtteranceId", "setUtteranceId", "utteranceId", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class TtsImplCallback implements TtsImpl.TtsCallback {

        /* renamed from: a  reason: collision with root package name */
        public String f5519a;
        public String b;

        public TtsImplCallback() {
        }

        public void a(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "caller");
            Intrinsics.checkNotNullParameter(str2, "id");
            this.f5519a = str;
            this.b = str2;
        }

        public void b() {
            AILOG a2 = TtsSpeakerImpl.this.b;
            String str = this.f5519a;
            String str2 = this.b;
            a2.c("onDone caller: " + str + ",  utteranceId = " + str2, new Object[0]);
            TtsSpeakerImpl.this.g.d(this.b);
            RequestQueue requestQueue = (RequestQueue) TtsSpeakerImpl.this.e.get(this.f5519a);
            if (requestQueue != null) {
                requestQueue.q(false);
                TtsSpeakerImpl.this.p(requestQueue, 0);
            }
            SpeakCallback c2 = TtsSpeakerImpl.this.f5516a;
            if (c2 != null) {
                c2.onDone(this.f5519a, this.b);
            }
        }

        public void onError(int i) {
            AILOG a2 = TtsSpeakerImpl.this.b;
            String str = this.f5519a;
            String str2 = this.b;
            a2.c("onError caller: " + str + ",  utteranceId = " + str2, new Object[0]);
            TtsSpeakerImpl.this.g.d(this.b);
            RequestQueue requestQueue = (RequestQueue) TtsSpeakerImpl.this.e.get(this.f5519a);
            if (requestQueue != null) {
                requestQueue.q(false);
            }
            SpeakCallback c2 = TtsSpeakerImpl.this.f5516a;
            if (c2 != null) {
                c2.onError(this.f5519a, this.b, i);
            }
        }

        public void onStart() {
            RequestQueue.RequestItem g;
            AILOG a2 = TtsSpeakerImpl.this.b;
            String str = this.f5519a;
            String str2 = this.b;
            a2.c("onStart caller: " + str + ", utteranceId = " + str2, new Object[0]);
            RequestQueue requestQueue = (RequestQueue) TtsSpeakerImpl.this.e.get(this.f5519a);
            if (requestQueue != null) {
                requestQueue.q(true);
            }
            if (requestQueue != null && (g = requestQueue.g()) != null && !g.f()) {
                RequestQueue.RequestItem g2 = requestQueue.g();
                if (g2 != null) {
                    g2.g(true);
                }
                SpeakCallback c2 = TtsSpeakerImpl.this.f5516a;
                if (c2 != null) {
                    c2.onStart(this.f5519a, this.b);
                }
            }
        }
    }

    public TtsSpeakerImpl(Context context, SpeakCallback speakCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f5516a = speakCallback;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.c = applicationContext;
        TtsImplPool b2 = TtsImplPool.b(applicationContext);
        Intrinsics.checkNotNullExpressionValue(b2, "getInstance(...)");
        this.d = b2;
        this.e = new HashMap();
        this.g = new TtsStatusTimer(this.f5516a);
        HandlerThread handlerThread = new HandlerThread("TTS_HANDLER");
        handlerThread.start();
        this.f = new Handler(this, handlerThread.getLooper()) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TtsSpeakerImpl f5517a;

            {
                this.f5517a = r1;
            }

            public void handleMessage(Message message) {
                TtsImpl j;
                TtsImpl j2;
                Intrinsics.checkNotNullParameter(message, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
                AILOG a2 = this.f5517a.b;
                int i = message.what;
                a2.c("handler message: " + i, new Object[0]);
                switch (message.what) {
                    case 1:
                        Object obj = message.obj;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.ai.ttsengine.base.service.RequestQueue");
                        RequestQueue requestQueue = (RequestQueue) obj;
                        if (requestQueue.l()) {
                            requestQueue.n(requestQueue.i(), requestQueue.f());
                            return;
                        } else {
                            this.f5517a.o(1000);
                            return;
                        }
                    case 2:
                        Object obj2 = message.obj;
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.upuphone.ai.ttsengine.base.service.TtsSpeakerImpl.SpeakRequestParam");
                        SpeakRequestParam speakRequestParam = (SpeakRequestParam) obj2;
                        this.f5517a.l(speakRequestParam.a(), speakRequestParam.d(), speakRequestParam.c(), speakRequestParam.b());
                        return;
                    case 3:
                        Object obj3 = message.obj;
                        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Pair<kotlin.String, kotlin.String>");
                        Pair pair = (Pair) obj3;
                        this.f5517a.n((String) pair.getFirst(), (String) pair.getSecond());
                        return;
                    case 4:
                        Object obj4 = message.obj;
                        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.upuphone.ai.ttsengine.base.service.RequestQueue");
                        ((RequestQueue) obj4).e();
                        return;
                    case 5:
                        Object obj5 = message.obj;
                        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
                        RequestQueue requestQueue2 = (RequestQueue) this.f5517a.e.get((String) obj5);
                        if (requestQueue2 != null && (j = requestQueue2.j()) != null) {
                            j.m();
                            return;
                        }
                        return;
                    case 6:
                        Object obj6 = message.obj;
                        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.String");
                        RequestQueue requestQueue3 = (RequestQueue) this.f5517a.e.get((String) obj6);
                        if (requestQueue3 != null && (j2 = requestQueue3.j()) != null) {
                            j2.o();
                            return;
                        }
                        return;
                    case 7:
                        this.f5517a.m(message.arg1, message.arg2);
                        return;
                    default:
                        AILOG a3 = this.f5517a.b;
                        int i2 = message.what;
                        a3.h("un support message type: " + i2, new Object[0]);
                        return;
                }
            }
        };
    }

    public final boolean j(String str, String str2, int i, int i2) {
        if (i != 0 && i != 3) {
            return true;
        }
        Collection<RequestQueue> values = this.e.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        if (!values.isEmpty()) {
            for (RequestQueue requestQueue : values) {
                if (requestQueue.m() && requestQueue.h() < i2) {
                    this.b.c("has other high priority caller is speaking, return", new Object[0]);
                    return false;
                }
            }
        }
        HashMap hashMap = this.e;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (i != 0) {
                if (i == 3) {
                    if (i2 <= ((RequestQueue) entry.getValue()).h()) {
                        if (((RequestQueue) entry.getValue()).k(str2)) {
                        }
                    }
                }
            } else if (!Intrinsics.areEqual(entry.getKey(), (Object) str) && i2 > ((RequestQueue) entry.getValue()).h()) {
            }
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            ((RequestQueue) entry2.getValue()).e();
            this.f.removeMessages(2, entry2);
            this.f.removeMessages(1, entry2);
        }
        return true;
    }

    public final RequestQueue k(String str, int i, AudioAttributes audioAttributes) {
        RequestQueue requestQueue = (RequestQueue) this.e.get(str);
        if (requestQueue == null) {
            requestQueue = new RequestQueue(str, i, audioAttributes);
            this.e.put(str, requestQueue);
            TtsImpl a2 = this.d.a(this.c.getPackageName());
            a2.p(new TtsImplCallback());
            requestQueue.r(a2);
            AILOG ailog = this.b;
            TtsImpl j = requestQueue.j();
            ailog.c("set tts impl = " + j, new Object[0]);
        } else {
            this.b.c("get request queue from cache", new Object[0]);
        }
        if (requestQueue.f() != audioAttributes) {
            requestQueue.o(audioAttributes);
        }
        return requestQueue;
    }

    public final void l(String str, String str2, int i, Bundle bundle) {
        RequestQueue requestQueue;
        int a2 = NumberUtilsKt.a(bundle.getInt("caller_priority", 2), 0, 4);
        this.b.c("handleSpeakRequest priority: " + a2 + ", for caller: " + str, new Object[0]);
        String string = bundle.getString("utteranceId", "");
        Intrinsics.checkNotNull(string);
        if (!j(str, string, i, a2)) {
            this.g.d(string);
            SpeakCallback speakCallback = this.f5516a;
            if (speakCallback != null) {
                speakCallback.onError(str, string, 15);
                return;
            }
            return;
        }
        String a3 = PackageUtils.a(this.c, "XR_CHANNEL");
        int i2 = 9;
        if (a3 != null) {
            int hashCode = a3.hashCode();
            if (hashCode != -1354792126) {
                if (hashCode == 115187) {
                    boolean equals = a3.equals("tts");
                } else if (hashCode == 104263205 && a3.equals("music")) {
                    i2 = 3;
                }
            } else if (a3.equals("config")) {
                i2 = bundle.getInt("streamType", 9);
            }
        }
        AudioAttributes audioAttributes = Build.VERSION.SDK_INT >= 33 ? (AudioAttributes) bundle.getParcelable("audioAttributes", AudioAttributes.class) : (AudioAttributes) bundle.getParcelable("audioAttributes");
        this.b.c("handleSpeakRequest: streamType = " + i2 + ", caller=" + str + ", id=" + string, new Object[0]);
        RequestQueue k = k(str, i2, audioAttributes);
        k.p(a2);
        k.b(str, string, str2, bundle, i);
        if (i == 0) {
            p(k, 0);
        } else if (i == 1) {
            Collection<RequestQueue> values = this.e.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            if (!(values instanceof Collection) || !values.isEmpty()) {
                for (RequestQueue m : values) {
                    if (m.m()) {
                        return;
                    }
                }
            }
            o(0);
        } else if (i == 3 && (requestQueue = (RequestQueue) this.e.get(str)) != null && !requestQueue.m()) {
            p(k, 0);
        }
    }

    public final void m(int i, int i2) {
        AILOG ailog = this.b;
        ailog.c("handleStopRequest: priority = " + i + ", stop type = " + i2, new Object[0]);
        HashMap hashMap = this.e;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        if (((RequestQueue) entry.getValue()).h() < i) {
                        }
                    }
                } else if (((RequestQueue) entry.getValue()).h() == i) {
                }
            } else if (((RequestQueue) entry.getValue()).h() != i) {
            }
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry value : linkedHashMap.entrySet()) {
            ((RequestQueue) value.getValue()).e();
        }
    }

    public final void n(String str, String str2) {
        AILOG ailog = this.b;
        ailog.c("handleStopRequest: caller = " + str + ", id: " + str2, new Object[0]);
        if (str == null) {
            Collection<RequestQueue> values = this.e.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            for (RequestQueue e2 : values) {
                e2.e();
            }
        } else if (str2 == null || str2.length() == 0) {
            RequestQueue requestQueue = (RequestQueue) this.e.get(str);
            if (requestQueue != null) {
                requestQueue.e();
            }
        } else {
            RequestQueue requestQueue2 = (RequestQueue) this.e.get(str);
            if (requestQueue2 != null) {
                requestQueue2.c(str2);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.upuphone.ai.ttsengine.base.service.RequestQueue} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o(int r6) {
        /*
            r5 = this;
            com.upuphone.ai.ttsengine.base.utils.AILOG r0 = r5.b
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "processAllQueues"
            r0.c(r2, r1)
            java.util.HashMap r0 = r5.e
            java.util.Collection r0 = r0.values()
            java.lang.String r1 = "<get-values>(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x001e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0035
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.upuphone.ai.ttsengine.base.service.RequestQueue r3 = (com.upuphone.ai.ttsengine.base.service.RequestQueue) r3
            boolean r3 = r3.l()
            if (r3 == 0) goto L_0x001e
            r1.add(r2)
            goto L_0x001e
        L_0x0035:
            java.util.Iterator r0 = r1.iterator()
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x0041
            r0 = 0
            goto L_0x006a
        L_0x0041:
            java.lang.Object r1 = r0.next()
            boolean r2 = r0.hasNext()
            if (r2 != 0) goto L_0x004d
        L_0x004b:
            r0 = r1
            goto L_0x006a
        L_0x004d:
            r2 = r1
            com.upuphone.ai.ttsengine.base.service.RequestQueue r2 = (com.upuphone.ai.ttsengine.base.service.RequestQueue) r2
            int r2 = r2.h()
        L_0x0054:
            java.lang.Object r3 = r0.next()
            r4 = r3
            com.upuphone.ai.ttsengine.base.service.RequestQueue r4 = (com.upuphone.ai.ttsengine.base.service.RequestQueue) r4
            int r4 = r4.h()
            if (r2 <= r4) goto L_0x0063
            r1 = r3
            r2 = r4
        L_0x0063:
            boolean r3 = r0.hasNext()
            if (r3 != 0) goto L_0x0054
            goto L_0x004b
        L_0x006a:
            com.upuphone.ai.ttsengine.base.service.RequestQueue r0 = (com.upuphone.ai.ttsengine.base.service.RequestQueue) r0
            if (r0 == 0) goto L_0x0071
            r5.p(r0, r6)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.base.service.TtsSpeakerImpl.o(int):void");
    }

    public final void p(RequestQueue requestQueue, int i) {
        Message obtainMessage = this.f.obtainMessage(1, requestQueue);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "obtainMessage(...)");
        this.f.sendMessageDelayed(obtainMessage, (long) i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean q(java.lang.String r17, java.lang.CharSequence r18, int r19, android.os.Bundle r20, java.lang.String r21) {
        /*
            r16 = this;
            r0 = r16
            r7 = r17
            r8 = r19
            r5 = r20
            r1 = r21
            java.lang.String r2 = "callingInstance"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            java.lang.String r2 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            r2 = 0
            if (r18 != 0) goto L_0x00bf
            java.lang.String r3 = "Sample"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x00bf
            java.lang.String r3 = "rate"
            int r4 = r5.getInt(r3)
            java.lang.String r6 = "pitch"
            int r9 = r5.getInt(r6)
            com.upuphone.ai.ttsengine.base.utils.AILOG r10 = r0.b
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "系统语速rate: "
            r11.append(r12)
            r11.append(r4)
            java.lang.String r11 = r11.toString()
            java.lang.Object[] r12 = new java.lang.Object[r2]
            r10.c(r11, r12)
            com.upuphone.ai.ttsengine.base.utils.AILOG r10 = r0.b
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "系统音高pitch: "
            r11.append(r12)
            r11.append(r9)
            java.lang.String r11 = r11.toString()
            java.lang.Object[] r12 = new java.lang.Object[r2]
            r10.c(r11, r12)
            r10 = 100
            if (r4 != r10) goto L_0x0067
            if (r9 != r10) goto L_0x0067
            r4 = 10
            r9 = r4
            goto L_0x0083
        L_0x0067:
            r10 = 4591381629579380570(0x3fb7dd441355475a, double:0.09322)
            double r12 = (double) r4
            double r12 = r12 * r10
            r10 = 4618365081854759718(0x4017ba92a3055326, double:5.9322)
            double r12 = r12 - r10
            int r4 = (int) r12
            r10 = 4598413009605601578(0x3fd0d844d013a92a, double:0.2632)
            double r12 = (double) r9
            double r12 = r12 * r10
            r9 = 4632974421275977554(0x404ba1b089a02752, double:55.2632)
            double r12 = r12 - r9
            int r9 = (int) r12
        L_0x0083:
            com.upuphone.ai.ttsengine.base.utils.AILOG r10 = r0.b
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "转换后的语速rate: "
            r11.append(r12)
            r11.append(r4)
            java.lang.String r11 = r11.toString()
            java.lang.Object[] r12 = new java.lang.Object[r2]
            r10.c(r11, r12)
            com.upuphone.ai.ttsengine.base.utils.AILOG r10 = r0.b
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "转换后的音高pitch: "
            r11.append(r12)
            r11.append(r9)
            java.lang.String r11 = r11.toString()
            java.lang.Object[] r12 = new java.lang.Object[r2]
            r10.c(r11, r12)
            r5.putInt(r3, r4)
            r5.putInt(r6, r9)
            java.lang.String r3 = "床前明月光，疑是地上霜；举头望明月，低头思故乡"
            goto L_0x00c1
        L_0x00bf:
            r3 = r18
        L_0x00c1:
            if (r1 == 0) goto L_0x00cc
            int r4 = r21.length()
            if (r4 != 0) goto L_0x00ca
            goto L_0x00cc
        L_0x00ca:
            r9 = r1
            goto L_0x00d5
        L_0x00cc:
            long r9 = java.lang.System.currentTimeMillis()
            java.lang.String r4 = java.lang.String.valueOf(r9)
            r9 = r4
        L_0x00d5:
            if (r3 != 0) goto L_0x00e1
            com.upuphone.ai.ttsengine.base.utils.AILOG r0 = r0.b
            java.lang.String r1 = "error text is null"
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.h(r1, r3)
            return r2
        L_0x00e1:
            com.upuphone.ai.ttsengine.base.helper.TextFilter r4 = com.upuphone.ai.ttsengine.base.helper.TextFilter.f5505a
            boolean r6 = r4.b(r3)
            if (r6 != 0) goto L_0x0189
            boolean r6 = r4.c(r3)
            if (r6 == 0) goto L_0x00f1
            goto L_0x0189
        L_0x00f1:
            java.lang.String r12 = r4.a(r3)
            java.lang.String r3 = "utteranceId"
            r5.putString(r3, r9)
            java.lang.String r3 = "delay_time"
            r13 = 0
            long r3 = r5.getLong(r3, r13)
            int r6 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            r15 = 2
            if (r6 <= 0) goto L_0x010a
        L_0x0108:
            r13 = r3
            goto L_0x0121
        L_0x010a:
            java.lang.String r3 = "com.tts.call"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0121
            java.lang.String r3 = "com.ss.android.lark"
            r4 = 0
            boolean r3 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r3, (boolean) r2, (int) r15, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x011e
            r3 = 500(0x1f4, double:2.47E-321)
            goto L_0x0108
        L_0x011e:
            r3 = 300(0x12c, double:1.48E-321)
            goto L_0x0108
        L_0x0121:
            com.upuphone.ai.ttsengine.base.utils.AILOG r3 = r0.b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "IBinder="
            r4.append(r6)
            r4.append(r7)
            java.lang.String r6 = ", text="
            r4.append(r6)
            r4.append(r12)
            java.lang.String r6 = ", queueMode="
            r4.append(r6)
            r4.append(r8)
            java.lang.String r6 = ", originId="
            r4.append(r6)
            r4.append(r1)
            java.lang.String r1 = ", newId="
            r4.append(r1)
            r4.append(r9)
            java.lang.String r1 = ", delay="
            r4.append(r1)
            r4.append(r13)
            java.lang.String r1 = r4.toString()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3.c(r1, r2)
            android.os.Handler r6 = r0.f
            com.upuphone.ai.ttsengine.base.service.TtsSpeakerImpl$SpeakRequestParam r4 = new com.upuphone.ai.ttsengine.base.service.TtsSpeakerImpl$SpeakRequestParam
            r1 = r4
            r2 = r17
            r3 = r12
            r10 = r4
            r4 = r19
            r5 = r20
            r11 = r6
            r6 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            android.os.Message r1 = r11.obtainMessage(r15, r10)
            r11.sendMessageDelayed(r1, r13)
            r1 = 3
            if (r8 == r1) goto L_0x0187
            com.upuphone.ai.ttsengine.base.service.TtsStatusTimer r0 = r0.g
            r1 = r17
            r2 = r12
            r3 = r9
            r4 = r13
            r0.f(r1, r2, r3, r4)
        L_0x0187:
            r0 = 1
            return r0
        L_0x0189:
            com.upuphone.ai.ttsengine.base.utils.AILOG r1 = r0.b
            java.lang.String r3 = "error, text is empty after filter"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r1.h(r3, r2)
            r1 = 3
            if (r8 == r1) goto L_0x01a3
            com.upuphone.ai.ttsengine.base.service.SpeakCallback r1 = r0.f5516a
            if (r1 == 0) goto L_0x019c
            r1.onStart(r7, r9)
        L_0x019c:
            com.upuphone.ai.ttsengine.base.service.SpeakCallback r0 = r0.f5516a
            if (r0 == 0) goto L_0x01a3
            r0.onDone(r7, r9)
        L_0x01a3:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.base.service.TtsSpeakerImpl.q(java.lang.String, java.lang.CharSequence, int, android.os.Bundle, java.lang.String):boolean");
    }

    public int r(int i, int i2) {
        Handler handler = this.f;
        Message obtainMessage = handler.obtainMessage(7);
        obtainMessage.arg1 = i;
        obtainMessage.arg2 = i2;
        handler.sendMessage(obtainMessage);
        return 0;
    }

    public int s(String str, String str2) {
        Handler handler = this.f;
        handler.sendMessage(handler.obtainMessage(3, new Pair(str, str2)));
        return 0;
    }
}
