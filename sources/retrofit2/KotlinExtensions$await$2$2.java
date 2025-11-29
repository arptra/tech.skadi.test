package retrofit2;

import com.geetest.sdk.t;
import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¨\u0006\u000b"}, d2 = {"retrofit2/KotlinExtensions$await$2$2", "Lretrofit2/Callback;", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "retrofit"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class KotlinExtensions$await$2$2 implements Callback<T> {
    final /* synthetic */ CancellableContinuation<T> $continuation;

    public KotlinExtensions$await$2$2(CancellableContinuation<? super T> cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public void onFailure(@NotNull Call<T> call, @NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(th, t.f);
        CancellableContinuation<T> cancellableContinuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(th)));
    }

    public void onResponse(@NotNull Call<T> call, @NotNull Response<T> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.isSuccessful()) {
            T body = response.body();
            if (body == null) {
                Object tag = call.request().tag(Invocation.class);
                Intrinsics.checkNotNull(tag);
                Invocation invocation = (Invocation) tag;
                Class<?> service = invocation.service();
                Method method = invocation.method();
                KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException("Response from " + service.getName() + '.' + method.getName() + " was null but response body type was declared as non-null");
                CancellableContinuation<T> cancellableContinuation = this.$continuation;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(kotlinNullPointerException)));
                return;
            }
            this.$continuation.resumeWith(Result.m20constructorimpl(body));
            return;
        }
        CancellableContinuation<T> cancellableContinuation2 = this.$continuation;
        Result.Companion companion2 = Result.Companion;
        cancellableContinuation2.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(new HttpException(response))));
    }
}
