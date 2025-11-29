package com.upuphone.ar.transcribe.utils;

import android.content.Context;
import com.upuphone.ar.transcribe.ext.LogExt;
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

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0007H@¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ar/transcribe/utils/NetworkUtils;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isAccessible", "", "callback", "b", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "host", "", "c", "(Ljava/lang/String;)J", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "mIoScope", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nNetworkUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkUtils.kt\ncom/upuphone/ar/transcribe/utils/NetworkUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,167:1\n1#2:168\n*E\n"})
public final class NetworkUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final NetworkUtils f6189a = new NetworkUtils();
    public static final CoroutineScope b = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));

    public static /* synthetic */ long d(NetworkUtils networkUtils, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "www.baidu.com";
        }
        return networkUtils.c(str);
    }

    public final Object a(Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new NetworkUtils$isInternetAvailable$2((Continuation<? super NetworkUtils$isInternetAvailable$2>) null), continuation);
    }

    public final void b(Context context, Function1 function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(b, (CoroutineContext) null, (CoroutineStart) null, new NetworkUtils$isNetworkCapabilities$1(context, function1, (Continuation<? super NetworkUtils$isNetworkCapabilities$1>) null), 3, (Object) null);
    }

    public final long c(String str) {
        Intrinsics.checkNotNullParameter(str, ApiConstant.VALUE_HOST);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ProcessBuilder(new String[]{"ping", "-c", "1", str}).start().getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                Intrinsics.checkNotNull(readLine);
                if (readLine == null) {
                    break;
                } else if (StringsKt.startsWith$default(readLine, "rtt", false, 2, (Object) null)) {
                    List split$default = StringsKt.split$default((CharSequence) readLine, new String[]{" "}, false, 0, 6, (Object) null);
                    if (split$default.size() >= 4) {
                        List split$default2 = StringsKt.split$default((CharSequence) split$default.get(3), new String[]{"/"}, false, 0, 6, (Object) null);
                        if (split$default2.size() >= 4) {
                            return (long) Double.parseDouble((String) split$default2.get(1));
                        }
                    }
                }
            }
            return 0;
        } catch (Exception e) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e);
            LogExt.g("pingDelayTime error=" + stackTraceToString, "NetworkUtils");
            return -1;
        }
    }
}
