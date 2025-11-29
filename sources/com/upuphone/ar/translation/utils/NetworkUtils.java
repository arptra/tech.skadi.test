package com.upuphone.ar.translation.utils;

import android.content.Context;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.runasone.api.ApiConstant;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\b¢\u0006\u0004\b\u000f\u0010\u0010J8\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\tH@¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J;\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bH@¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/upuphone/ar/translation/utils/NetworkUtils;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "delayTime", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isAccessible", "", "callback", "d", "(Landroid/content/Context;JLkotlin/jvm/functions/Function1;)V", "e", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "host", "f", "(Ljava/lang/String;)J", "b", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "mIoScope", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nNetworkUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkUtils.kt\ncom/upuphone/ar/translation/utils/NetworkUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n1#2:181\n*E\n"})
public final class NetworkUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final NetworkUtils f6368a = new NetworkUtils();
    public static final CoroutineScope b = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));

    public static /* synthetic */ long g(NetworkUtils networkUtils, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "www.baidu.com";
        }
        return networkUtils.f(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(android.content.Context r7, kotlin.jvm.functions.Function1 r8, kotlin.coroutines.Continuation r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.upuphone.ar.translation.utils.NetworkUtils$isInternalNetworkCapabilities$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.upuphone.ar.translation.utils.NetworkUtils$isInternalNetworkCapabilities$1 r0 = (com.upuphone.ar.translation.utils.NetworkUtils$isInternalNetworkCapabilities$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.translation.utils.NetworkUtils$isInternalNetworkCapabilities$1 r0 = new com.upuphone.ar.translation.utils.NetworkUtils$isInternalNetworkCapabilities$1
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            java.lang.String r2 = "NetworkUtils"
            r3 = 1
            if (r1 == 0) goto L_0x0038
            if (r1 != r3) goto L_0x0030
            java.lang.Object r7 = r0.L$0
            r8 = r7
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x008f
        L_0x0030:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.String r6 = "connectivity"
            java.lang.Object r6 = r7.getSystemService(r6)
            java.lang.String r7 = "null cannot be cast to non-null type android.net.ConnectivityManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            android.net.ConnectivityManager r6 = (android.net.ConnectivityManager) r6
            android.net.Network r7 = r6.getActiveNetwork()
            android.net.NetworkCapabilities r6 = r6.getNetworkCapabilities(r7)
            r7 = 0
            if (r6 == 0) goto L_0x00aa
            r1 = 12
            boolean r1 = r6.hasCapability(r1)
            r4 = 16
            boolean r6 = r6.hasCapability(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "isNetworkCapabilities 网络连接="
            r4.append(r5)
            r4.append(r1)
            java.lang.String r5 = ", 网络可用="
            r4.append(r5)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            com.upuphone.ar.translation.ext.LogExt.j(r4, r2)
            if (r1 != 0) goto L_0x007f
            r3 = r7
            goto L_0x00a9
        L_0x007f:
            if (r6 == 0) goto L_0x0082
            goto L_0x00a9
        L_0x0082:
            com.upuphone.ar.translation.utils.NetworkUtils r6 = f6368a
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r6 = r6.c(r0)
            if (r6 != r9) goto L_0x008f
            return r9
        L_0x008f:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r3 = r6.booleanValue()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "isNetworkCapabilities 请求互联网="
            r6.append(r7)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            com.upuphone.ar.translation.ext.LogExt.j(r6, r2)
        L_0x00a9:
            r7 = r3
        L_0x00aa:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r9 = "isNetworkCapabilities isAccessible="
            r6.append(r9)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.upuphone.ar.translation.ext.LogExt.j(r6, r2)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            r8.invoke(r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.utils.NetworkUtils.b(android.content.Context, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object c(Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new NetworkUtils$isInternetAvailable$2((Continuation<? super NetworkUtils$isInternetAvailable$2>) null), continuation);
    }

    public final void d(Context context, long j, Function1 function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(b, (CoroutineContext) null, (CoroutineStart) null, new NetworkUtils$isNetworkCapabilities$1(j, context, function1, (Continuation<? super NetworkUtils$isNetworkCapabilities$1>) null), 3, (Object) null);
    }

    public final void e(Context context, Function1 function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(b, (CoroutineContext) null, (CoroutineStart) null, new NetworkUtils$isNetworkCapabilities$2(context, function1, (Continuation<? super NetworkUtils$isNetworkCapabilities$2>) null), 3, (Object) null);
    }

    public final long f(String str) {
        String readLine;
        Intrinsics.checkNotNullParameter(str, ApiConstant.VALUE_HOST);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ProcessBuilder(new String[]{"ping", "-c", "1", str}).start().getInputStream()));
            do {
                readLine = bufferedReader.readLine();
                Intrinsics.checkNotNull(readLine);
                if (readLine == null) {
                    return 0;
                }
            } while (!StringsKt.startsWith$default(readLine, "rtt", false, 2, (Object) null));
            List split$default = StringsKt.split$default((CharSequence) readLine, new String[]{" "}, false, 0, 6, (Object) null);
            if (split$default.size() < 4) {
                return 0;
            }
            List split$default2 = StringsKt.split$default((CharSequence) split$default.get(3), new String[]{"/"}, false, 0, 6, (Object) null);
            if (split$default2.size() < 4) {
                return 0;
            }
            return (long) Double.parseDouble((String) split$default2.get(1));
        } catch (Exception e) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e);
            LogExt.j("pingDelayTime error=" + stackTraceToString, "NetworkUtils");
            return 0;
        }
    }
}
