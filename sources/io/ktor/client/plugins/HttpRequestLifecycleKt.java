package io.ktor.client.plugins;

import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Metadata;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import org.slf4j.Logger;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u000b\u001a\u00060\u0007j\u0002`\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/CompletableJob;", "requestJob", "Lkotlinx/coroutines/Job;", "clientEngineJob", "", "c", "(Lkotlinx/coroutines/CompletableJob;Lkotlinx/coroutines/Job;)V", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "a", "Lorg/slf4j/Logger;", "LOGGER", "ktor-client-core"}, k = 2, mv = {1, 8, 0})
public final class HttpRequestLifecycleKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f8855a = KtorSimpleLoggerJvmKt.a("io.ktor.client.plugins.HttpRequestLifecycle");

    public static final void c(CompletableJob completableJob, Job job) {
        completableJob.r(new HttpRequestLifecycleKt$attachToClientEngineJob$1(job.r(new HttpRequestLifecycleKt$attachToClientEngineJob$handler$1(completableJob))));
    }
}
