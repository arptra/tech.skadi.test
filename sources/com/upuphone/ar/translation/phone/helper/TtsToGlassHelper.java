package com.upuphone.ar.translation.phone.helper;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.statemachine.bean.AsrTtsResult;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import com.upuphone.ar.translation.utils.JsonUtils;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.Dst;
import com.xjsd.xr.sapp.asr.dao.ResultExt;
import com.xjsd.xr.sapp.asr.dao.Src;
import com.xjsd.xr.sapp.asr.dao.TtsData;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001/B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u001d\u0010\u0011\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J1\u0010\u0018\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010$R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010$R\u0018\u0010*\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001cR\u0018\u0010+\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001cR\u0018\u0010,\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\u0016\u0010.\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010-¨\u00060"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/TtsToGlassHelper;", "", "<init>", "()V", "", "n", "o", "Lcom/upuphone/ar/translation/phone/helper/TtsToGlassHelper$OpusTtsData;", "opusTts", "m", "(Lcom/upuphone/ar/translation/phone/helper/TtsToGlassHelper$OpusTtsData;)V", "i", "k", "g", "", "", "sendList", "l", "(Ljava/util/List;)V", "h", "", "time", "", "isEnd", "j", "(Ljava/util/List;JZ)V", "Lkotlinx/coroutines/Job;", "b", "Lkotlinx/coroutines/Job;", "mIoJob", "Lkotlinx/coroutines/CoroutineScope;", "c", "Lkotlinx/coroutines/CoroutineScope;", "mIoScope", "Lkotlinx/coroutines/channels/Channel;", "d", "Lkotlinx/coroutines/channels/Channel;", "mRemoteOpusChannel", "e", "mProximalOpusChannel", "f", "mReminderOpusChannel", "mRemoteConsumerJob", "mProximalConsumerJob", "mReminderConsumerJob", "Z", "mIsFirstSendReminder", "OpusTtsData", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TtsToGlassHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final TtsToGlassHelper f6315a = new TtsToGlassHelper();
    public static Job b;
    public static CoroutineScope c;
    public static Channel d = ChannelKt.b(0, (BufferOverflow) null, (Function1) null, 7, (Object) null);
    public static Channel e = ChannelKt.b(0, (BufferOverflow) null, (Function1) null, 7, (Object) null);
    public static Channel f = ChannelKt.b(0, (BufferOverflow) null, (Function1) null, 7, (Object) null);
    public static Job g;
    public static Job h;
    public static Job i;
    public static boolean j;

    static {
        CompletableJob b2 = SupervisorKt.b((Job) null, 1, (Object) null);
        b = b2;
        c = CoroutineScopeKt.a(b2.plus(Dispatchers.b()));
    }

    public final void g() {
        if (b.isCancelled()) {
            b = SupervisorKt.b((Job) null, 1, (Object) null);
            c = CoroutineScopeKt.a(Dispatchers.b().plus(b));
        }
    }

    public final void h(List list) {
        byte[] bArr = new byte[0];
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bArr = ArraysKt.plus(bArr, (byte[]) it.next());
        }
        TranslateStateManager p = TranslationManager.q.a().p();
        if (p != null) {
            p.w(new AsrTtsResult(JsonUtils.d(new AsrResult((Src) null, (Dst) null, (ResultExt) null, 7, (DefaultConstructorMarker) null)), bArr));
        }
        int length = bArr.length;
        int size = list.size();
        LogExt.g("sendProximalTts sendBytes=" + length + ", sendList=" + size, "TtsToGlassHelper");
    }

    public final void i(OpusTtsData opusTtsData) {
        Intrinsics.checkNotNullParameter(opusTtsData, "opusTts");
        Job unused = BuildersKt__Builders_commonKt.d(c, (CoroutineContext) null, (CoroutineStart) null, new TtsToGlassHelper$sendProximalTtsData$1(opusTtsData, (Continuation<? super TtsToGlassHelper$sendProximalTtsData$1>) null), 3, (Object) null);
    }

    public final void j(List list, long j2, boolean z) {
        byte[] bArr = new byte[0];
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bArr = ArraysKt.plus(bArr, (byte[]) it.next());
        }
        if (!j) {
            j = true;
        } else {
            j2 = z ? -1 : 0;
        }
        InterConnectHelper.c.a().r(4, 30, new TtsData(bArr, j2));
        int length = bArr.length;
        int size = list.size();
        LogExt.g("sendReminderTts sendBytes=" + length + ", sendList=" + size + ", time=" + j2, "TtsToGlassHelper");
    }

    public final void k(OpusTtsData opusTtsData) {
        Intrinsics.checkNotNullParameter(opusTtsData, "opusTts");
        Job unused = BuildersKt__Builders_commonKt.d(c, (CoroutineContext) null, (CoroutineStart) null, new TtsToGlassHelper$sendReminderTtsData$1(opusTtsData, (Continuation<? super TtsToGlassHelper$sendReminderTtsData$1>) null), 3, (Object) null);
    }

    public final void l(List list) {
        byte[] bArr = new byte[0];
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bArr = ArraysKt.plus(bArr, (byte[]) it.next());
        }
        TranslateStateManager p = TranslationManager.q.a().p();
        if (p != null) {
            p.x(new AsrTtsResult(JsonUtils.d(new AsrResult((Src) null, (Dst) null, (ResultExt) null, 7, (DefaultConstructorMarker) null)), bArr));
        }
        int length = bArr.length;
        int size = list.size();
        LogExt.g("sendRemoteTts sendBytes=" + length + ", sendList=" + size, "TtsToGlassHelper");
    }

    public final void m(OpusTtsData opusTtsData) {
        Intrinsics.checkNotNullParameter(opusTtsData, "opusTts");
        Job unused = BuildersKt__Builders_commonKt.d(c, (CoroutineContext) null, (CoroutineStart) null, new TtsToGlassHelper$sendRemoteTtsData$1(opusTtsData, (Continuation<? super TtsToGlassHelper$sendRemoteTtsData$1>) null), 3, (Object) null);
    }

    public final void n() {
        if (TelephoneTransHelper.f6305a.A()) {
            g();
            d = ChannelKt.b(0, (BufferOverflow) null, (Function1) null, 7, (Object) null);
            e = ChannelKt.b(0, (BufferOverflow) null, (Function1) null, 7, (Object) null);
            f = ChannelKt.b(0, (BufferOverflow) null, (Function1) null, 7, (Object) null);
            j = false;
            g = BuildersKt__Builders_commonKt.d(c, (CoroutineContext) null, (CoroutineStart) null, new TtsToGlassHelper$start$1((Continuation<? super TtsToGlassHelper$start$1>) null), 3, (Object) null);
            h = BuildersKt__Builders_commonKt.d(c, (CoroutineContext) null, (CoroutineStart) null, new TtsToGlassHelper$start$2((Continuation<? super TtsToGlassHelper$start$2>) null), 3, (Object) null);
            i = BuildersKt__Builders_commonKt.d(c, (CoroutineContext) null, (CoroutineStart) null, new TtsToGlassHelper$start$3((Continuation<? super TtsToGlassHelper$start$3>) null), 3, (Object) null);
        }
    }

    public final void o() {
        if (TelephoneTransHelper.f6305a.A()) {
            ReceiveChannel.DefaultImpls.a(d, (CancellationException) null, 1, (Object) null);
            ReceiveChannel.DefaultImpls.a(e, (CancellationException) null, 1, (Object) null);
            ReceiveChannel.DefaultImpls.a(f, (CancellationException) null, 1, (Object) null);
            Job job = g;
            if (job != null) {
                Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
            }
            Job job2 = h;
            if (job2 != null) {
                Job.DefaultImpls.a(job2, (CancellationException) null, 1, (Object) null);
            }
            Job job3 = i;
            if (job3 != null) {
                Job.DefaultImpls.a(job3, (CancellationException) null, 1, (Object) null);
            }
            j = false;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u001a\u001a\u0004\b\u0016\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/TtsToGlassHelper$OpusTtsData;", "", "", "bytes", "", "isEnd", "", "totalTime", "<init>", "([BZJ)V", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "[B", "()[B", "b", "Z", "c", "()Z", "J", "()J", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class OpusTtsData {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f6316a;
        public final boolean b;
        public final long c;

        public OpusTtsData(byte[] bArr, boolean z, long j) {
            Intrinsics.checkNotNullParameter(bArr, "bytes");
            this.f6316a = bArr;
            this.b = z;
            this.c = j;
        }

        public final byte[] a() {
            return this.f6316a;
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
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.ar.translation.phone.helper.TtsToGlassHelper.OpusTtsData");
            OpusTtsData opusTtsData = (OpusTtsData) obj;
            if (Arrays.equals(this.f6316a, opusTtsData.f6316a) && this.b == opusTtsData.b) {
                return this.c == opusTtsData.c;
            }
            return false;
        }

        public int hashCode() {
            return (((Arrays.hashCode(this.f6316a) * 31) + Boolean.hashCode(this.b)) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            String arrays = Arrays.toString(this.f6316a);
            boolean z = this.b;
            long j = this.c;
            return "OpusTtsData(bytes=" + arrays + ", isEnd=" + z + ", totalTime=" + j + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ OpusTtsData(byte[] bArr, boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(bArr, (i & 2) != 0 ? false : z, (i & 4) != 0 ? 0 : j);
        }
    }
}
