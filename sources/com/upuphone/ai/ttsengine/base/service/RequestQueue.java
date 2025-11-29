package com.upuphone.ai.ttsengine.base.service;

import android.media.AudioAttributes;
import android.os.Bundle;
import com.honey.account.o3.a;
import com.upuphone.ai.ttsengine.base.service.TtsImpl;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001HB'\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b\"\u0010#R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020)8\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010/R$\u00106\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b%\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010=\u001a\u0004\u0018\u0001078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b2\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010A\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b>\u0010!\u001a\u0004\b>\u0010#\"\u0004\b?\u0010@R*\u0010G\u001a\u00020\n2\u0006\u0010B\u001a\u00020\n8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\"\u0010C\u001a\u0004\bD\u0010\f\"\u0004\bE\u0010F¨\u0006I"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/service/RequestQueue;", "", "", "caller", "", "streamType", "Landroid/media/AudioAttributes;", "audioAttributes", "<init>", "(Ljava/lang/String;ILandroid/media/AudioAttributes;)V", "", "l", "()Z", "id", "k", "(Ljava/lang/String;)Z", "text", "Landroid/os/Bundle;", "params", "queueMode", "", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;I)V", "c", "(Ljava/lang/String;)V", "n", "(ILandroid/media/AudioAttributes;)Z", "e", "()V", "a", "Ljava/lang/String;", "getCaller", "()Ljava/lang/String;", "I", "i", "()I", "Landroid/media/AudioAttributes;", "f", "()Landroid/media/AudioAttributes;", "o", "(Landroid/media/AudioAttributes;)V", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "d", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/upuphone/ai/ttsengine/base/service/RequestQueue$RequestItem;", "Ljava/util/concurrent/LinkedBlockingQueue;", "queue", "Lcom/upuphone/ai/ttsengine/base/service/RequestQueue$RequestItem;", "g", "()Lcom/upuphone/ai/ttsengine/base/service/RequestQueue$RequestItem;", "setPlayingItem", "(Lcom/upuphone/ai/ttsengine/base/service/RequestQueue$RequestItem;)V", "playingItem", "Lcom/upuphone/ai/ttsengine/base/service/TtsImpl;", "Lcom/upuphone/ai/ttsengine/base/service/TtsImpl;", "j", "()Lcom/upuphone/ai/ttsengine/base/service/TtsImpl;", "r", "(Lcom/upuphone/ai/ttsengine/base/service/TtsImpl;)V", "ttsImpl", "h", "p", "(I)V", "priority", "value", "Z", "m", "q", "(Z)V", "isProcessing", "RequestItem", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nRequestQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RequestQueue.kt\ncom/upuphone/ai/ttsengine/base/service/RequestQueue\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,124:1\n1#2:125\n*E\n"})
public final class RequestQueue {

    /* renamed from: a  reason: collision with root package name */
    public final String f5511a;
    public final int b;
    public AudioAttributes c;
    public final AILOG d;
    public LinkedBlockingQueue e = new LinkedBlockingQueue();
    public RequestItem f;
    public TtsImpl g;
    public int h = 2;
    public boolean i;

    public RequestQueue(String str, int i2, AudioAttributes audioAttributes) {
        Intrinsics.checkNotNullParameter(str, "caller");
        this.f5511a = str;
        this.b = i2;
        this.c = audioAttributes;
        AILOG a2 = AILOG.a("RequestQueue");
        Intrinsics.checkNotNullExpressionValue(a2, "createLogger(...)");
        this.d = a2;
    }

    public static final boolean d(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.upuphone.ai.ttsengine.base.service.RequestQueue$RequestItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.upuphone.ai.ttsengine.base.service.RequestQueue$RequestItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: com.upuphone.ai.ttsengine.base.service.RequestQueue$RequestItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: com.upuphone.ai.ttsengine.base.service.RequestQueue$RequestItem} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r15, java.lang.String r16, java.lang.String r17, android.os.Bundle r18, int r19) {
        /*
            r14 = this;
            r0 = r14
            r3 = r16
            r10 = r17
            java.lang.String r1 = "caller"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            java.lang.String r1 = "id"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            java.lang.String r1 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            java.lang.String r1 = "params"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)
            com.upuphone.ai.ttsengine.base.utils.AILOG r1 = r0.d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "text addRequest id: "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            r11 = 0
            java.lang.Object[] r6 = new java.lang.Object[r11]
            r1.c(r4, r6)
            com.upuphone.ai.ttsengine.base.service.RequestQueue$RequestItem r1 = r0.f
            r4 = 0
            if (r1 == 0) goto L_0x003f
            java.lang.String r1 = r1.e()
            goto L_0x0040
        L_0x003f:
            r1 = r4
        L_0x0040:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x005d
            com.upuphone.ai.ttsengine.base.utils.AILOG r1 = r0.d
            java.lang.String r2 = "text addRequest to playing"
            java.lang.Object[] r3 = new java.lang.Object[r11]
            r1.c(r2, r3)
            com.upuphone.ai.ttsengine.base.service.RequestQueue$RequestItem r0 = r0.f
            if (r0 == 0) goto L_0x00b0
            java.util.List r0 = r0.d()
            if (r0 == 0) goto L_0x00b0
            r0.add(r10)
            goto L_0x00b0
        L_0x005d:
            java.util.concurrent.LinkedBlockingQueue r1 = r0.e
            java.util.Iterator r1 = r1.iterator()
        L_0x0063:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x007b
            java.lang.Object r6 = r1.next()
            r7 = r6
            com.upuphone.ai.ttsengine.base.service.RequestQueue$RequestItem r7 = (com.upuphone.ai.ttsengine.base.service.RequestQueue.RequestItem) r7
            java.lang.String r7 = r7.e()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r3)
            if (r7 == 0) goto L_0x0063
            r4 = r6
        L_0x007b:
            com.upuphone.ai.ttsengine.base.service.RequestQueue$RequestItem r4 = (com.upuphone.ai.ttsengine.base.service.RequestQueue.RequestItem) r4
            if (r4 == 0) goto L_0x0089
            java.util.List r1 = r4.d()
            if (r1 == 0) goto L_0x0089
            r1.add(r10)
            goto L_0x00b0
        L_0x0089:
            java.util.concurrent.LinkedBlockingQueue r12 = r0.e
            com.upuphone.ai.ttsengine.base.service.RequestQueue$RequestItem r13 = new com.upuphone.ai.ttsengine.base.service.RequestQueue$RequestItem
            r8 = 36
            r9 = 0
            r4 = 0
            r7 = 0
            r1 = r13
            r2 = r15
            r3 = r16
            r5 = r18
            r6 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.List r1 = r13.d()
            r1.add(r10)
            com.upuphone.ai.ttsengine.base.utils.AILOG r0 = r0.d
            java.lang.String r1 = "text addRequest to new create"
            java.lang.Object[] r2 = new java.lang.Object[r11]
            r0.c(r1, r2)
            r12.add(r13)
        L_0x00b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.base.service.RequestQueue.b(java.lang.String, java.lang.String, java.lang.String, android.os.Bundle, int):void");
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        RequestItem requestItem = this.f;
        if (Intrinsics.areEqual((Object) requestItem != null ? requestItem.e() : null, (Object) str)) {
            TtsImpl ttsImpl = this.g;
            if (ttsImpl != null) {
                ttsImpl.r();
            }
            this.f = null;
            return;
        }
        this.e.removeIf(new a(new RequestQueue$cancelRequest$1(str)));
    }

    public final void e() {
        AILOG ailog = this.d;
        boolean z = this.i;
        ailog.c("flushRequest isProcessing=" + z, new Object[0]);
        if (this.i) {
            AILOG ailog2 = this.d;
            TtsImpl ttsImpl = this.g;
            Boolean valueOf = ttsImpl != null ? Boolean.valueOf(ttsImpl.l()) : null;
            ailog2.c("flushRequest stop + isSpeaking()=" + valueOf, new Object[0]);
            TtsImpl ttsImpl2 = this.g;
            if (ttsImpl2 != null) {
                ttsImpl2.r();
            }
        }
        q(false);
        this.f = null;
        this.e.clear();
        AILOG ailog3 = this.d;
        int size = this.e.size();
        ailog3.c("flushRequest over queue size=" + size, new Object[0]);
    }

    public final AudioAttributes f() {
        return this.c;
    }

    public final RequestItem g() {
        return this.f;
    }

    public final int h() {
        return this.h;
    }

    public final int i() {
        return this.b;
    }

    public final TtsImpl j() {
        return this.g;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.upuphone.ai.ttsengine.base.service.RequestQueue$RequestItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.upuphone.ai.ttsengine.base.service.RequestQueue$RequestItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.upuphone.ai.ttsengine.base.service.RequestQueue$RequestItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.upuphone.ai.ttsengine.base.service.RequestQueue$RequestItem} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(java.lang.String r5) {
        /*
            r4 = this;
            com.upuphone.ai.ttsengine.base.service.RequestQueue$RequestItem r0 = r4.f
            r1 = 0
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.e()
            goto L_0x000b
        L_0x000a:
            r0 = r1
        L_0x000b:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)
            r2 = 1
            if (r0 != 0) goto L_0x0043
            java.util.concurrent.LinkedBlockingQueue r4 = r4.e
            java.util.Iterator r4 = r4.iterator()
        L_0x0018:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0030
            java.lang.Object r0 = r4.next()
            r3 = r0
            com.upuphone.ai.ttsengine.base.service.RequestQueue$RequestItem r3 = (com.upuphone.ai.ttsengine.base.service.RequestQueue.RequestItem) r3
            java.lang.String r3 = r3.e()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0018
            r1 = r0
        L_0x0030:
            com.upuphone.ai.ttsengine.base.service.RequestQueue$RequestItem r1 = (com.upuphone.ai.ttsengine.base.service.RequestQueue.RequestItem) r1
            if (r1 == 0) goto L_0x0042
            java.util.List r4 = r1.d()
            if (r4 == 0) goto L_0x0042
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r2
            if (r4 != r2) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r2 = 0
        L_0x0043:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.base.service.RequestQueue.k(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.d();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean l() {
        /*
            r2 = this;
            com.upuphone.ai.ttsengine.base.service.RequestQueue$RequestItem r0 = r2.f
            r1 = 1
            if (r0 == 0) goto L_0x0013
            java.util.List r0 = r0.d()
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r1
            if (r0 != r1) goto L_0x0013
            goto L_0x001d
        L_0x0013:
            java.util.concurrent.LinkedBlockingQueue r2 = r2.e
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.base.service.RequestQueue.l():boolean");
    }

    public final boolean m() {
        return this.i;
    }

    public final boolean n(int i2, AudioAttributes audioAttributes) {
        TtsImpl.TtsCallback i3;
        if (this.g == null) {
            this.d.c("processItem: tts service is not ready. mTts=null ", new Object[0]);
            return false;
        } else if (this.i) {
            this.d.c("processItem: already during processing", new Object[0]);
            return false;
        } else {
            AILOG ailog = this.d;
            RequestItem requestItem = this.f;
            ailog.c("playing item: " + requestItem, new Object[0]);
            RequestItem requestItem2 = this.f;
            if (requestItem2 == null) {
                requestItem2 = !this.e.isEmpty() ? (RequestItem) this.e.poll() : null;
            }
            this.f = requestItem2;
            if (requestItem2 == null) {
                return false;
            }
            if (requestItem2.d().isEmpty()) {
                this.d.c("processItem: texts empty", new Object[0]);
                return false;
            }
            TtsImpl ttsImpl = this.g;
            if (!(ttsImpl == null || (i3 = ttsImpl.i()) == null)) {
                i3.a(requestItem2.a(), requestItem2.e());
            }
            TtsImpl ttsImpl2 = this.g;
            if (ttsImpl2 != null) {
                ttsImpl2.n(requestItem2.d(), i2, requestItem2.c(), audioAttributes, requestItem2.b());
            }
            q(true);
            return true;
        }
    }

    public final void o(AudioAttributes audioAttributes) {
        this.c = audioAttributes;
    }

    public final void p(int i2) {
        this.h = i2;
    }

    public final void q(boolean z) {
        RequestItem requestItem;
        List d2;
        this.i = z;
        if (!z && (requestItem = this.f) != null && (d2 = requestItem.d()) != null && d2.isEmpty()) {
            this.d.c("set playing item null", new Object[0]);
            this.f = null;
        }
    }

    public final void r(TtsImpl ttsImpl) {
        this.g = ttsImpl;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\b\u0018\u00002\u00020\u0001BE\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\u0019\u0010\u0010R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001e\u001a\u0004\b\u001a\u0010\u001fR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0019\u0010 \u001a\u0004\b\u0018\u0010\u0012R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/service/RequestQueue$RequestItem;", "", "", "callerId", "utteranceId", "", "texts", "Landroid/os/Bundle;", "params", "", "mode", "", "isStarted", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Landroid/os/Bundle;IZ)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", "e", "c", "Ljava/util/List;", "d", "()Ljava/util/List;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "I", "f", "Z", "()Z", "g", "(Z)V", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class RequestItem {

        /* renamed from: a  reason: collision with root package name */
        public final String f5512a;
        public final String b;
        public final List c;
        public final Bundle d;
        public final int e;
        public boolean f;

        public RequestItem(String str, String str2, List list, Bundle bundle, int i, boolean z) {
            Intrinsics.checkNotNullParameter(str, "callerId");
            Intrinsics.checkNotNullParameter(str2, "utteranceId");
            Intrinsics.checkNotNullParameter(list, "texts");
            Intrinsics.checkNotNullParameter(bundle, PayloadConstant.KEY_PARAMS);
            this.f5512a = str;
            this.b = str2;
            this.c = list;
            this.d = bundle;
            this.e = i;
            this.f = z;
        }

        public final String a() {
            return this.f5512a;
        }

        public final int b() {
            return this.e;
        }

        public final Bundle c() {
            return this.d;
        }

        public final synchronized List d() {
            return this.c;
        }

        public final String e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestItem)) {
                return false;
            }
            RequestItem requestItem = (RequestItem) obj;
            return Intrinsics.areEqual((Object) this.f5512a, (Object) requestItem.f5512a) && Intrinsics.areEqual((Object) this.b, (Object) requestItem.b) && Intrinsics.areEqual((Object) this.c, (Object) requestItem.c) && Intrinsics.areEqual((Object) this.d, (Object) requestItem.d) && this.e == requestItem.e && this.f == requestItem.f;
        }

        public final boolean f() {
            return this.f;
        }

        public final void g(boolean z) {
            this.f = z;
        }

        public int hashCode() {
            return (((((((((this.f5512a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Integer.hashCode(this.e)) * 31) + Boolean.hashCode(this.f);
        }

        public String toString() {
            String str = this.f5512a;
            String str2 = this.b;
            List list = this.c;
            Bundle bundle = this.d;
            int i = this.e;
            boolean z = this.f;
            return "RequestItem(callerId=" + str + ", utteranceId=" + str2 + ", texts=" + list + ", params=" + bundle + ", mode=" + i + ", isStarted=" + z + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ RequestItem(String str, String str2, List list, Bundle bundle, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i2 & 4) != 0 ? new ArrayList() : list, bundle, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? false : z);
        }
    }
}
