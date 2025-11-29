package rxhttp.wrapper.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.Response;
import rxhttp.wrapper.OkHttpCompat;
import rxhttp.wrapper.parse.Parser;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a(\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@¢\u0006\u0004\b\u0004\u0010\u0005\u001a3\u0010\r\u001a\u00020\u000b*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u0012\u001a\u00020\u000b2\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0013\u0010\u0016\u001a\u00020\u0015*\u00020\u0014H\u0000¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"T", "Lokhttp3/Call;", "Lrxhttp/wrapper/parse/Parser;", "parser", "a", "(Lokhttp3/Call;Lrxhttp/wrapper/parse/Parser;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/InputStream;", "Ljava/io/OutputStream;", "outStream", "Lkotlin/Function1;", "", "", "progress", "d", "(Ljava/io/InputStream;Ljava/io/OutputStream;Lkotlin/jvm/functions/Function1;)V", "", "Ljava/io/Closeable;", "closeables", "b", "([Ljava/io/Closeable;)V", "Lokhttp3/Response;", "", "c", "(Lokhttp3/Response;)Z", "rxhttp"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\nrxhttp/wrapper/utils/Utils\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,103:1\n314#2,11:104\n1#3:115\n*S KotlinDebug\n*F\n+ 1 Utils.kt\nrxhttp/wrapper/utils/Utils\n*L\n29#1:104,11\n*E\n"})
@JvmName(name = "Utils")
public final class Utils {
    public static final Object a(Call call, Parser parser, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        cancellableContinuationImpl.E(new Utils$await$2$1(call));
        call.enqueue(new Utils$await$2$2(cancellableContinuationImpl, parser));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public static final void b(Closeable... closeableArr) {
        Intrinsics.checkNotNullParameter(closeableArr, "closeables");
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    public static final boolean c(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        return OkHttpCompat.g(response);
    }

    public static final void d(InputStream inputStream, OutputStream outputStream, Function1 function1) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(outputStream, "outStream");
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr, 0, 8192);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                    if (function1 != null) {
                        function1.invoke(Integer.valueOf(read));
                    }
                } else {
                    return;
                }
            }
        } finally {
            b(inputStream, outputStream);
        }
    }

    public static /* synthetic */ void e(InputStream inputStream, OutputStream outputStream, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        d(inputStream, outputStream, function1);
    }
}
