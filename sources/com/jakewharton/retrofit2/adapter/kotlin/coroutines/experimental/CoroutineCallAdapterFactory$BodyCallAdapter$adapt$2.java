package com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CompletableDeferred;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¨\u0006\f"}, d2 = {"com/jakewharton/retrofit2/adapter/kotlin/coroutines/experimental/CoroutineCallAdapterFactory$BodyCallAdapter$adapt$2", "Lretrofit2/Callback;", "(Lkotlinx/coroutines/experimental/CompletableDeferred;)V", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "retrofit2-kotlin-coroutines-adapter"}, k = 1, mv = {1, 1, 9})
public final class CoroutineCallAdapterFactory$BodyCallAdapter$adapt$2 implements Callback<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CompletableDeferred f9250a;

    public CoroutineCallAdapterFactory$BodyCallAdapter$adapt$2(CompletableDeferred completableDeferred) {
        this.f9250a = completableDeferred;
    }

    public void onFailure(Call call, Throwable th) {
        this.f9250a.completeExceptionally(th);
    }

    public void onResponse(Call call, Response response) {
        if (response.isSuccessful()) {
            CompletableDeferred completableDeferred = this.f9250a;
            Object body = response.body();
            if (body == null) {
                Intrinsics.throwNpe();
            }
            completableDeferred.complete(body);
            return;
        }
        this.f9250a.completeExceptionally(new HttpException(response));
    }
}
