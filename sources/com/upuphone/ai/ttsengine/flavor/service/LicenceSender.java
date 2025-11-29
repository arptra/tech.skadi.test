package com.upuphone.ai.ttsengine.flavor.service;

import android.content.Context;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.r3.a;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.ai.ttsengine.flavor.service.connect.Communicator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 .2\u00020\u0001:\u0001/B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH@¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010!\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/upuphone/ai/ttsengine/flavor/service/LicenceSender;", "", "Landroid/content/Context;", "context", "Lcom/upuphone/ai/ttsengine/flavor/service/connect/Communicator;", "communicator", "", "pkg", "<init>", "(Landroid/content/Context;Lcom/upuphone/ai/ttsengine/flavor/service/connect/Communicator;Ljava/lang/String;)V", "", "data", "", "h", "(Landroid/content/Context;[B)V", "", "version", "k", "(Landroid/content/Context;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "byte", "", "len", "i", "(B[BI)V", "a", "Lcom/upuphone/ai/ttsengine/flavor/service/connect/Communicator;", "b", "Ljava/lang/String;", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "c", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "Lkotlinx/coroutines/CoroutineScope;", "d", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/Job;", "e", "Lkotlinx/coroutines/Job;", "sendingJob", "", "f", "Z", "isChecking", "g", "Companion", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nLicenceSender.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LicenceSender.kt\ncom/upuphone/ai/ttsengine/flavor/service/LicenceSender\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,137:1\n48#2,4:138\n*S KotlinDebug\n*F\n+ 1 LicenceSender.kt\ncom/upuphone/ai/ttsengine/flavor/service/LicenceSender\n*L\n36#1:138,4\n*E\n"})
public final class LicenceSender {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Communicator f5560a;
    public final String b;
    public final AILOG c = AILOG.a("LicenceSender");
    public final CoroutineScope d = CoroutineScopeKt.a(SupervisorKt.b((Job) null, 1, (Object) null).plus(Dispatchers.b()).plus(new LicenceSender$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.a0, this)));
    public Job e;
    public volatile boolean f;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ai/ttsengine/flavor/service/LicenceSender$Companion;", "", "()V", "LICENCE_FILE_PATH", "", "LICENCE_VERSION_FILE_PATH", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public LicenceSender(final Context context, Communicator communicator, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(communicator, "communicator");
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        this.f5560a = communicator;
        this.b = str;
        communicator.g(new Communicator.OnDataRcvListener(this) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LicenceSender f5562a;

            {
                this.f5562a = r1;
            }

            public void a(byte[] bArr) {
                if (bArr != null) {
                    if ((!(bArr.length == 0)) && bArr[0] == 20) {
                        this.f5562a.c.c("receive normal licence message", new Object[0]);
                        byte[] copyOfRange = ArraysKt.copyOfRange(bArr, 2, bArr.length);
                        if (bArr[1] == 3) {
                            this.f5562a.h(context, copyOfRange);
                            return;
                        }
                        AILOG d = this.f5562a.c;
                        byte b2 = bArr[1];
                        d.h("not support licence type: " + b2, new Object[0]);
                    }
                }
            }
        });
        communicator.f(new a(this));
    }

    public static final void b(LicenceSender licenceSender, boolean z) {
        Intrinsics.checkNotNullParameter(licenceSender, "this$0");
        if (!z) {
            Job job = licenceSender.e;
            if (job != null) {
                Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
            }
            licenceSender.f = false;
        }
    }

    public static /* synthetic */ void j(LicenceSender licenceSender, byte b2, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = bArr.length;
        }
        licenceSender.i(b2, bArr, i);
    }

    public final void h(Context context, byte[] bArr) {
        this.c.c("start check", new Object[0]);
        if (this.f) {
            this.c.c("checking is already running", new Object[0]);
            return;
        }
        this.f = true;
        AILOG ailog = this.c;
        boolean h = CoroutineScopeKt.h(this.d);
        ailog.c("scope active: " + h, new Object[0]);
        this.e = BuildersKt__Builders_commonKt.d(this.d, (CoroutineContext) null, (CoroutineStart) null, new LicenceSender$check$1(this, context, bArr, (Continuation<? super LicenceSender$check$1>) null), 3, (Object) null);
    }

    public final void i(byte b2, byte[] bArr, int i) {
        byte[] bArr2 = new byte[(i + 2)];
        bArr2[0] = 20;
        bArr2[1] = b2;
        ArraysKt.copyInto(bArr, bArr2, 2, 0, i);
        Communicator.j(this.f5560a, bArr2, (String) null, this.b, 2, (Object) null);
    }

    public final Object k(Context context, long j, Continuation continuation) {
        Object g2 = BuildersKt.g(Dispatchers.b(), new LicenceSender$sendFile$2(context, this, j, (Continuation<? super LicenceSender$sendFile$2>) null), continuation);
        return g2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g2 : Unit.INSTANCE;
    }
}
