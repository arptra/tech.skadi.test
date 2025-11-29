package rxhttp.wrapper.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rxhttp.wrapper.CallFactory;
import rxhttp.wrapper.parse.Parser;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00028\u0000H@¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lrxhttp/wrapper/coroutines/CallAwait;", "T", "Lrxhttp/wrapper/coroutines/Await;", "Lrxhttp/wrapper/CallFactory;", "callFactory", "Lrxhttp/wrapper/parse/Parser;", "parser", "<init>", "(Lrxhttp/wrapper/CallFactory;Lrxhttp/wrapper/parse/Parser;)V", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Lrxhttp/wrapper/CallFactory;", "b", "Lrxhttp/wrapper/parse/Parser;", "rxhttp"}, k = 1, mv = {1, 9, 0})
public final class CallAwait<T> implements Await<T> {

    /* renamed from: a  reason: collision with root package name */
    public final CallFactory f3545a;
    public final Parser b;

    public CallAwait(CallFactory callFactory, Parser parser) {
        Intrinsics.checkNotNullParameter(callFactory, "callFactory");
        Intrinsics.checkNotNullParameter(parser, "parser");
        this.f3545a = callFactory;
        this.b = parser;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object c(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof rxhttp.wrapper.coroutines.CallAwait$await$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            rxhttp.wrapper.coroutines.CallAwait$await$1 r0 = (rxhttp.wrapper.coroutines.CallAwait$await$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            rxhttp.wrapper.coroutines.CallAwait$await$1 r0 = new rxhttp.wrapper.coroutines.CallAwait$await$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.L$0
            okhttp3.Call r5 = (okhttp3.Call) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x002d }
            goto L_0x004d
        L_0x002d:
            r6 = move-exception
            goto L_0x0052
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            rxhttp.wrapper.CallFactory r6 = r5.f3545a
            okhttp3.Call r6 = r6.a()
            rxhttp.wrapper.parse.Parser r5 = r5.b     // Catch:{ all -> 0x004e }
            r0.L$0 = r6     // Catch:{ all -> 0x004e }
            r0.label = r3     // Catch:{ all -> 0x004e }
            java.lang.Object r6 = rxhttp.wrapper.utils.Utils.a(r6, r5, r0)     // Catch:{ all -> 0x004e }
            if (r6 != r1) goto L_0x004d
            return r1
        L_0x004d:
            return r6
        L_0x004e:
            r5 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L_0x0052:
            rxhttp.wrapper.exception.ProxyException r0 = new rxhttp.wrapper.exception.ProxyException
            okhttp3.Request r5 = r5.request()
            r0.<init>((okhttp3.Request) r5, (java.lang.Throwable) r6)
            rxhttp.wrapper.utils.LogUtil.k(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: rxhttp.wrapper.coroutines.CallAwait.c(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
