package com.upuphone.ar.transcribe.phone.helper;

import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.TranscribeManager;
import com.upuphone.star.core.log.ULog;
import com.xjsd.xr.sapp.asr.dao.TtsData;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ReceiveChannel;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001!B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0012\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001cR\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/upuphone/ar/transcribe/phone/helper/TtsDataSender;", "", "<init>", "()V", "", "f", "g", "Lcom/upuphone/ar/transcribe/phone/helper/TtsDataSender$OpusTtsData;", "opusTts", "c", "(Lcom/upuphone/ar/transcribe/phone/helper/TtsDataSender$OpusTtsData;)V", "", "", "sendList", "", "time", "", "isEnd", "d", "(Ljava/util/List;JZ)V", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "ioScope", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/Channel;", "opusChannel", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "consumerJob", "e", "Z", "isFirstSend", "OpusTtsData", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TtsDataSender {

    /* renamed from: a  reason: collision with root package name */
    public static final TtsDataSender f6112a = new TtsDataSender();
    public static CoroutineScope b;
    public static Channel c;
    public static Job d;
    public static boolean e;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u001a\u001a\u0004\b\u0016\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/helper/TtsDataSender$OpusTtsData;", "", "", "bytes", "", "isEnd", "", "totalTime", "<init>", "([BZJ)V", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "[B", "()[B", "b", "Z", "c", "()Z", "J", "()J", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class OpusTtsData {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f6113a;
        public final boolean b;
        public final long c;

        public OpusTtsData(byte[] bArr, boolean z, long j) {
            Intrinsics.checkNotNullParameter(bArr, "bytes");
            this.f6113a = bArr;
            this.b = z;
            this.c = j;
        }

        public final byte[] a() {
            return this.f6113a;
        }

        public final long b() {
            return this.c;
        }

        public final boolean c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual((Object) OpusTtsData.class, (Object) obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.ar.transcribe.phone.helper.TtsDataSender.OpusTtsData");
            OpusTtsData opusTtsData = (OpusTtsData) obj;
            return Arrays.equals(this.f6113a, opusTtsData.f6113a) && this.b == opusTtsData.b && this.c == opusTtsData.c;
        }

        public int hashCode() {
            return (((Arrays.hashCode(this.f6113a) * 31) + Boolean.hashCode(this.b)) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            String arrays = Arrays.toString(this.f6113a);
            boolean z = this.b;
            long j = this.c;
            return "OpusTtsData(bytes=" + arrays + ", isEnd=" + z + ", totalTime=" + j + ")";
        }
    }

    public static /* synthetic */ void e(TtsDataSender ttsDataSender, List list, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        ttsDataSender.d(list, j, z);
    }

    public final void c(OpusTtsData opusTtsData) {
        Intrinsics.checkNotNullParameter(opusTtsData, "opusTts");
        CoroutineScope coroutineScope = b;
        if (coroutineScope != null) {
            Job unused = BuildersKt__Builders_commonKt.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new TtsDataSender$sendData$1(opusTtsData, (Continuation<? super TtsDataSender$sendData$1>) null), 3, (Object) null);
        }
    }

    public final void d(List list, long j, boolean z) {
        byte[] bArr = new byte[0];
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bArr = ArraysKt.plus(bArr, (byte[]) it.next());
        }
        if (!e) {
            e = true;
        } else {
            j = z ? -1 : 0;
        }
        InterConnectHelper.c.a().r(4, 30, new TtsData(bArr, j));
        int length = bArr.length;
        int size = list.size();
        LogExt.d("sendToGlass sendBytes=" + length + ", sendList=" + size + ", time=" + j, "TtsDataSender");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (kotlinx.coroutines.CoroutineScopeKt.h(r8) == false) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f() {
        /*
            r8 = this;
            com.upuphone.ar.transcribe.phone.TranscribeManager$Companion r8 = com.upuphone.ar.transcribe.phone.TranscribeManager.j
            com.upuphone.ar.transcribe.phone.TranscribeManager r8 = r8.a()
            int r8 = r8.l()
            r0 = 4
            java.lang.String r1 = "TtsDataSender"
            if (r8 == r0) goto L_0x0017
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r0 = "not dialog transcribe type"
            r8.o(r1, r0)
            return
        L_0x0017:
            kotlinx.coroutines.CoroutineScope r8 = b
            r0 = 0
            if (r8 == 0) goto L_0x0025
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            boolean r8 = kotlinx.coroutines.CoroutineScopeKt.h(r8)
            if (r8 != 0) goto L_0x003f
        L_0x0025:
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r2 = "create io coroutine scope"
            r8.o(r1, r2)
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.b()
            r1 = 1
            kotlinx.coroutines.CompletableJob r1 = kotlinx.coroutines.SupervisorKt.b(r0, r1, r0)
            kotlin.coroutines.CoroutineContext r8 = r8.plus(r1)
            kotlinx.coroutines.CoroutineScope r8 = kotlinx.coroutines.CoroutineScopeKt.a(r8)
            b = r8
        L_0x003f:
            r8 = 7
            r1 = 0
            kotlinx.coroutines.channels.Channel r8 = kotlinx.coroutines.channels.ChannelKt.b(r1, r0, r0, r8, r0)
            c = r8
            e = r1
            kotlinx.coroutines.CoroutineScope r2 = b
            if (r2 == 0) goto L_0x005a
            com.upuphone.ar.transcribe.phone.helper.TtsDataSender$start$1 r5 = new com.upuphone.ar.transcribe.phone.helper.TtsDataSender$start$1
            r5.<init>(r0)
            r6 = 3
            r7 = 0
            r3 = 0
            r4 = 0
            kotlinx.coroutines.Job r0 = kotlinx.coroutines.BuildersKt__Builders_commonKt.d(r2, r3, r4, r5, r6, r7)
        L_0x005a:
            d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.helper.TtsDataSender.f():void");
    }

    public final void g() {
        ULog.f6446a.a("TtsDataSender", "stop");
        if (TranscribeManager.j.a().l() == 4) {
            Channel channel = c;
            if (channel != null) {
                ReceiveChannel.DefaultImpls.a(channel, (CancellationException) null, 1, (Object) null);
            }
            Job job = d;
            if (job != null) {
                Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
            }
            c = null;
            d = null;
            e = false;
        }
    }
}
