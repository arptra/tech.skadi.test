package com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CompletableDeferredKt;
import kotlinx.coroutines.experimental.Deferred;
import kotlinx.coroutines.experimental.Job;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0003\r\u000e\u000fJ:\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/jakewharton/retrofit2/adapter/kotlin/coroutines/experimental/CoroutineCallAdapterFactory;", "Lretrofit2/CallAdapter$Factory;", "Ljava/lang/reflect/Type;", "returnType", "", "", "annotations", "Lretrofit2/Retrofit;", "retrofit", "Lretrofit2/CallAdapter;", "get", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/CallAdapter;", "a", "BodyCallAdapter", "Companion", "ResponseCallAdapter", "retrofit2-kotlin-coroutines-adapter"}, k = 1, mv = {1, 4, 0})
public final class CoroutineCallAdapterFactory extends CallAdapter.Factory {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f9248a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\bJ#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/jakewharton/retrofit2/adapter/kotlin/coroutines/experimental/CoroutineCallAdapterFactory$BodyCallAdapter;", "T", "Lretrofit2/CallAdapter;", "Lkotlinx/coroutines/experimental/Deferred;", "Ljava/lang/reflect/Type;", "responseType", "<init>", "(Ljava/lang/reflect/Type;)V", "()Ljava/lang/reflect/Type;", "Lretrofit2/Call;", "call", "a", "(Lretrofit2/Call;)Lkotlinx/coroutines/experimental/Deferred;", "Ljava/lang/reflect/Type;", "retrofit2-kotlin-coroutines-adapter"}, k = 1, mv = {1, 4, 0})
    public static final class BodyCallAdapter<T> implements CallAdapter<T, Deferred<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        public final Type f9249a;

        public BodyCallAdapter(Type type) {
            this.f9249a = type;
        }

        /* renamed from: a */
        public Deferred adapt(Call call) {
            Deferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
            Job.DefaultImpls.invokeOnCompletion$default(CompletableDeferred$default, false, new CoroutineCallAdapterFactory$BodyCallAdapter$adapt$1(CompletableDeferred$default, call), 1, (Object) null);
            call.enqueue(new CoroutineCallAdapterFactory$BodyCallAdapter$adapt$2(CompletableDeferred$default));
            return CompletableDeferred$default;
        }

        public Type responseType() {
            return this.f9249a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/jakewharton/retrofit2/adapter/kotlin/coroutines/experimental/CoroutineCallAdapterFactory$Companion;", "", "<init>", "()V", "retrofit2-kotlin-coroutines-adapter"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00030\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\tJ)\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/jakewharton/retrofit2/adapter/kotlin/coroutines/experimental/CoroutineCallAdapterFactory$ResponseCallAdapter;", "T", "Lretrofit2/CallAdapter;", "Lkotlinx/coroutines/experimental/Deferred;", "Lretrofit2/Response;", "Ljava/lang/reflect/Type;", "responseType", "<init>", "(Ljava/lang/reflect/Type;)V", "()Ljava/lang/reflect/Type;", "Lretrofit2/Call;", "call", "a", "(Lretrofit2/Call;)Lkotlinx/coroutines/experimental/Deferred;", "Ljava/lang/reflect/Type;", "retrofit2-kotlin-coroutines-adapter"}, k = 1, mv = {1, 4, 0})
    public static final class ResponseCallAdapter<T> implements CallAdapter<T, Deferred<? extends Response<T>>> {

        /* renamed from: a  reason: collision with root package name */
        public final Type f9251a;

        public ResponseCallAdapter(Type type) {
            this.f9251a = type;
        }

        /* renamed from: a */
        public Deferred adapt(Call call) {
            Deferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
            Job.DefaultImpls.invokeOnCompletion$default(CompletableDeferred$default, false, new CoroutineCallAdapterFactory$ResponseCallAdapter$adapt$1(CompletableDeferred$default, call), 1, (Object) null);
            call.enqueue(new CoroutineCallAdapterFactory$ResponseCallAdapter$adapt$2(CompletableDeferred$default));
            return CompletableDeferred$default;
        }

        public Type responseType() {
            return this.f9251a;
        }
    }

    public CallAdapter get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (!Intrinsics.areEqual((Object) Deferred.class, (Object) CallAdapter.Factory.getRawType(type))) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type a2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
            if (!Intrinsics.areEqual((Object) CallAdapter.Factory.getRawType(a2), (Object) Response.class)) {
                Intrinsics.checkExpressionValueIsNotNull(a2, "responseType");
                return new BodyCallAdapter(a2);
            } else if (a2 instanceof ParameterizedType) {
                Type a3 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) a2);
                Intrinsics.checkExpressionValueIsNotNull(a3, "getParameterUpperBound(0, responseType)");
                return new ResponseCallAdapter(a3);
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<out Foo>");
            }
        } else {
            throw new IllegalStateException("Deferred return type must be parameterized as Deferred<Foo> or Deferred<out Foo>");
        }
    }
}
