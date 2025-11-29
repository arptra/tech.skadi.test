package io.ktor.client.engine;

import io.ktor.client.engine.HttpClientEngine;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058VX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lio/ktor/client/engine/HttpClientJvmEngine;", "Lio/ktor/client/engine/HttpClientEngine;", "", "close", "()V", "Lkotlin/coroutines/CoroutineContext;", "a", "Lkotlin/coroutines/CoroutineContext;", "clientContext", "b", "Lkotlin/Lazy;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHttpClientJvmEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpClientJvmEngine.kt\nio/ktor/client/engine/HttpClientJvmEngine\n+ 2 HttpClientJvmEngine.kt\nio/ktor/client/engine/HttpClientJvmEngineKt\n*L\n1#1,56:1\n55#2:57\n*S KotlinDebug\n*F\n+ 1 HttpClientJvmEngine.kt\nio/ktor/client/engine/HttpClientJvmEngine\n*L\n35#1:57\n*E\n"})
@Deprecated(level = DeprecationLevel.ERROR, message = "Use HttpClientEngineBase instead.", replaceWith = @ReplaceWith(expression = "HttpClientEngineBase", imports = {}))
public abstract class HttpClientJvmEngine implements HttpClientEngine {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineContext f8826a;
    public final Lazy b;

    public Set C() {
        return HttpClientEngine.DefaultImpls.g(this);
    }

    public void close() {
        Job k = JobKt.k(this.f8826a);
        Intrinsics.checkNotNull(k, "null cannot be cast to non-null type kotlinx.coroutines.CompletableJob");
        ((CompletableJob) k).complete();
    }

    public CoroutineContext getCoroutineContext() {
        return (CoroutineContext) this.b.getValue();
    }
}
