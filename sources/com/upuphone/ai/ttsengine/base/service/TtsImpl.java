package com.upuphone.ai.ttsengine.base.service;

import android.content.Context;
import android.os.Bundle;
import com.upuphone.ai.ttsengine.base.ITtsAgent;
import com.upuphone.ai.ttsengine.base.ITtsStatusListener;
import com.upuphone.ai.ttsengine.base.TtsManager;
import com.upuphone.ai.ttsengine.base.bean.EmotionTypeKt;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001FB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J=\u0010\u0011\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u0015J\u001f\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\"\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R$\u0010@\u001a\u0002082\u0006\u0010<\u001a\u0002088\u0006@BX\u000e¢\u0006\f\n\u0004\b=\u0010:\u001a\u0004\b>\u0010?R(\u0010E\u001a\u0004\u0018\u00010*2\b\u0010A\u001a\u0004\u0018\u00010*8F@FX\u000e¢\u0006\f\u001a\u0004\b=\u0010B\"\u0004\bC\u0010D¨\u0006G"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/service/TtsImpl;", "", "Landroid/content/Context;", "ctx", "", "packageName", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "", "texts", "", "streamType", "Landroid/os/Bundle;", "params", "Landroid/media/AudioAttributes;", "audioAttributes", "queueMode", "n", "(Ljava/util/List;ILandroid/os/Bundle;Landroid/media/AudioAttributes;I)I", "", "r", "()V", "m", "o", "k", "j", "Lcom/upuphone/ai/ttsengine/base/ITtsAgent;", "ttsClient", "q", "(Lcom/upuphone/ai/ttsengine/base/ITtsAgent;Landroid/os/Bundle;)V", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "a", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "b", "Ljava/lang/Object;", "mCallbackLockObj", "Lcom/upuphone/ai/ttsengine/base/ITtsStatusListener;", "c", "Lcom/upuphone/ai/ttsengine/base/ITtsStatusListener;", "listener", "Lcom/upuphone/ai/ttsengine/base/service/TtsImpl$TtsCallback;", "d", "Lcom/upuphone/ai/ttsengine/base/service/TtsImpl$TtsCallback;", "mCallback", "e", "Ljava/lang/String;", "mPackageName", "f", "Landroid/content/Context;", "mContext", "Lcom/upuphone/ai/ttsengine/base/TtsManager;", "g", "Lcom/upuphone/ai/ttsengine/base/TtsManager;", "ttsManager", "", "h", "Z", "isStopCalled", "<set-?>", "i", "l", "()Z", "isSpeaking", "cb", "()Lcom/upuphone/ai/ttsengine/base/service/TtsImpl$TtsCallback;", "p", "(Lcom/upuphone/ai/ttsengine/base/service/TtsImpl$TtsCallback;)V", "callback", "TtsCallback", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTtsImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TtsImpl.kt\ncom/upuphone/ai/ttsengine/base/service/TtsImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,325:1\n1855#2,2:326\n223#2,2:329\n223#2,2:331\n1054#2:333\n766#2:334\n857#2,2:335\n1#3:328\n107#4:337\n79#4,22:338\n*S KotlinDebug\n*F\n+ 1 TtsImpl.kt\ncom/upuphone/ai/ttsengine/base/service/TtsImpl\n*L\n100#1:326,2\n226#1:329,2\n230#1:331,2\n234#1:333\n236#1:334\n236#1:335,2\n305#1:337\n305#1:338,22\n*E\n"})
public final class TtsImpl {

    /* renamed from: a  reason: collision with root package name */
    public final AILOG f5513a;
    public final Object b = new Object();
    public ITtsStatusListener c;
    public TtsCallback d;
    public String e = "TextToSpeech";
    public final Context f;
    public final TtsManager g;
    public boolean h;
    public boolean i;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/service/TtsImpl$TtsCallback;", "", "", "callerId", "id", "", "a", "(Ljava/lang/String;Ljava/lang/String;)V", "onStart", "()V", "b", "", "errorCode", "onError", "(I)V", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface TtsCallback {
        void a(String str, String str2);

        void b();

        void onError(int i);

        void onStart();
    }

    public TtsImpl(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        AILOG a2 = AILOG.a("TtsImpl");
        this.f5513a = a2;
        a2.c("create TtsImpl packageName = " + str, new Object[0]);
        this.f = context;
        this.e = str;
        a2.c("before create session...", new Object[0]);
        TtsManager c2 = TtsManager.c();
        Intrinsics.checkNotNullExpressionValue(c2, "getInstance(...)");
        this.g = c2;
        k();
    }

    public final TtsCallback i() {
        return this.d;
    }

    public final void j() {
        if (this.c == null) {
            this.c = new TtsImpl$initListener$1(this);
        }
    }

    public final void k() {
        this.f5513a.c("initService", new Object[0]);
        j();
        List<ITtsAgent> b2 = TtsManager.c().b();
        Intrinsics.checkNotNullExpressionValue(b2, "getAllAgents(...)");
        for (ITtsAgent listener : b2) {
            listener.setListener(this.c);
        }
    }

    public final boolean l() {
        return this.i;
    }

    public final void m() {
        this.f5513a.c("pause", new Object[0]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int n(java.util.List r15, int r16, android.os.Bundle r17, android.media.AudioAttributes r18, int r19) {
        /*
            r14 = this;
            r2 = r14
            r4 = r17
            java.lang.String r0 = "texts"
            r6 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "voice_id"
            java.lang.String r1 = "BV700_streaming"
            java.lang.String r0 = r4.getString(r0, r1)
            java.lang.String r1 = "language"
            java.lang.String r3 = ""
            java.lang.String r1 = r4.getString(r1, r3)
            java.lang.String r3 = "test_tool"
            r8 = 0
            int r3 = r4.getInt(r3, r8)
            java.lang.String r5 = "Collection contains no element matching the predicate."
            java.lang.String r7 = "getAllAgents(...)"
            r9 = 1
            if (r3 != r9) goto L_0x0066
            com.upuphone.ai.ttsengine.base.TtsManager r0 = r2.g
            java.util.List r0 = r0.b()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r7)
            java.util.Iterator r0 = r0.iterator()
        L_0x003a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0060
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.upuphone.ai.ttsengine.base.ITtsAgent r3 = (com.upuphone.ai.ttsengine.base.ITtsAgent) r3
            com.upuphone.ai.ttsengine.base.enums.TtsAgentType r7 = r3.getAgentType()
            com.upuphone.ai.ttsengine.base.enums.TtsAgentType r9 = com.upuphone.ai.ttsengine.base.enums.TtsAgentType.CLOUD
            if (r7 == r9) goto L_0x0057
            com.upuphone.ai.ttsengine.base.enums.TtsAgentType r3 = r3.getAgentType()
            com.upuphone.ai.ttsengine.base.enums.TtsAgentType r7 = com.upuphone.ai.ttsengine.base.enums.TtsAgentType.GOOGLE
            if (r3 != r7) goto L_0x003a
        L_0x0057:
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r1)
            r10 = r19
        L_0x005d:
            r1 = r0
            goto L_0x00e0
        L_0x0060:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>(r5)
            throw r0
        L_0x0066:
            r3 = 3
            r10 = r19
            if (r10 != r3) goto L_0x00a0
            com.upuphone.ai.ttsengine.base.TtsManager r0 = r2.g
            java.util.List r0 = r0.b()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r7)
            java.util.Iterator r0 = r0.iterator()
        L_0x0078:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x009a
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.upuphone.ai.ttsengine.base.ITtsAgent r3 = (com.upuphone.ai.ttsengine.base.ITtsAgent) r3
            com.upuphone.ai.ttsengine.base.enums.TtsAgentType r7 = r3.getAgentType()
            com.upuphone.ai.ttsengine.base.enums.TtsAgentType r9 = com.upuphone.ai.ttsengine.base.enums.TtsAgentType.CLOUD
            if (r7 == r9) goto L_0x0095
            com.upuphone.ai.ttsengine.base.enums.TtsAgentType r3 = r3.getAgentType()
            com.upuphone.ai.ttsengine.base.enums.TtsAgentType r7 = com.upuphone.ai.ttsengine.base.enums.TtsAgentType.GOOGLE
            if (r3 != r7) goto L_0x0078
        L_0x0095:
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r1)
            goto L_0x005d
        L_0x009a:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>(r5)
            throw r0
        L_0x00a0:
            com.upuphone.ai.ttsengine.base.TtsManager r3 = r2.g
            java.util.List r3 = r3.b()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            com.upuphone.ai.ttsengine.base.service.TtsImpl$play$$inlined$sortedByDescending$1 r5 = new com.upuphone.ai.ttsengine.base.service.TtsImpl$play$$inlined$sortedByDescending$1
            r5.<init>()
            java.util.List r3 = kotlin.collections.CollectionsKt.sortedWith(r3, r5)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x00bb:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x00df
            java.lang.Object r7 = r3.next()
            r11 = r7
            com.upuphone.ai.ttsengine.base.ITtsAgent r11 = (com.upuphone.ai.ttsengine.base.ITtsAgent) r11
            if (r11 == 0) goto L_0x00bb
            com.upuphone.ai.ttsengine.base.bean.CacheKey r12 = new com.upuphone.ai.ttsengine.base.bean.CacheKey
            java.lang.Object r13 = kotlin.collections.CollectionsKt.first(r15)
            java.lang.String r13 = (java.lang.String) r13
            r12.<init>(r0, r1, r13)
            boolean r11 = r11.isSupport(r12)
            if (r11 != r9) goto L_0x00bb
            r5.add(r7)
            goto L_0x00bb
        L_0x00df:
            r1 = r5
        L_0x00e0:
            com.upuphone.ai.ttsengine.base.utils.AILOG r0 = r2.f5513a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "used engine for text is: "
            r3.append(r5)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r5 = new java.lang.Object[r8]
            r0.c(r3, r5)
            r2.h = r8
            kotlinx.coroutines.GlobalScope r9 = kotlinx.coroutines.GlobalScope.f3732a
            com.upuphone.ai.ttsengine.base.service.TtsImpl$play$1 r11 = new com.upuphone.ai.ttsengine.base.service.TtsImpl$play$1
            r7 = 0
            r0 = r11
            r2 = r14
            r3 = r18
            r4 = r17
            r5 = r19
            r6 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = 3
            r1 = 0
            r2 = 0
            r3 = 0
            r14 = r9
            r15 = r2
            r16 = r3
            r17 = r11
            r18 = r0
            r19 = r1
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.d(r14, r15, r16, r17, r18, r19)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.base.service.TtsImpl.n(java.util.List, int, android.os.Bundle, android.media.AudioAttributes, int):int");
    }

    public final void o() {
        this.f5513a.c("resume", new Object[0]);
    }

    public final void p(TtsCallback ttsCallback) {
        synchronized (this.b) {
            this.d = ttsCallback;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void q(ITtsAgent iTtsAgent, Bundle bundle) {
        AILOG ailog = this.f5513a;
        ailog.c("setParam: " + bundle, new Object[0]);
        String string = bundle.getString("emotionType");
        int i2 = bundle.getInt("rate");
        int i3 = bundle.getInt("pitch");
        int i4 = bundle.getInt("volume");
        String string2 = bundle.getString("language", "");
        int i5 = bundle.getInt("test_tool", 0);
        int i6 = bundle.getInt("calling_type", 0);
        int i7 = bundle.getInt("multi_language", 0);
        String string3 = bundle.getString("voice_id", "BV700_streaming");
        int i8 = bundle.getInt("disable_bt", 0);
        int i9 = bundle.getInt("voice_gender", -1);
        int i10 = bundle.getInt("voice_id_by_language", 0);
        if (EmotionTypeKt.a(string)) {
            iTtsAgent.setParam(1638, string);
        } else {
            iTtsAgent.setParam(1638, "neutral");
        }
        if (i2 != 0) {
            iTtsAgent.setParam(1282, i2);
        }
        if (i3 != 0) {
            iTtsAgent.setParam(1283, i3);
        }
        if (i4 != 0) {
            iTtsAgent.setParam(1284, i4);
        }
        iTtsAgent.setParam(1234567892, string2);
        iTtsAgent.setParam(1234567893, i5);
        iTtsAgent.setParam(1234567891, i6);
        iTtsAgent.setParam(1234567894, i7);
        iTtsAgent.setParam(1234567895, string3);
        iTtsAgent.setParam(1234567896, i8);
        iTtsAgent.setParam(1234567897, i9);
        iTtsAgent.setParam(1234567898, i10);
    }

    public final void r() {
        AILOG ailog = this.f5513a;
        boolean z = this.i;
        ailog.c("set stop called: " + z, new Object[0]);
        this.h = true;
        if (this.i) {
            TtsManager.c().f();
        }
    }
}
