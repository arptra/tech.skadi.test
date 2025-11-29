package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\nB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lio/ktor/client/plugins/BodyProgress;", "", "<init>", "()V", "Lio/ktor/client/HttpClient;", "scope", "", "c", "(Lio/ktor/client/HttpClient;)V", "a", "Plugin", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class BodyProgress {

    /* renamed from: a  reason: collision with root package name */
    public static final Plugin f8830a = new Plugin((DefaultConstructorMarker) null);
    public static final AttributeKey b = new AttributeKey("BodyProgress");

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\t\u001a\u00020\u00032\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/client/plugins/BodyProgress$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "", "Lio/ktor/client/plugins/BodyProgress;", "<init>", "()V", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "d", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/BodyProgress;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "c", "(Lio/ktor/client/plugins/BodyProgress;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Plugin implements HttpClientPlugin<Unit, BodyProgress> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: c */
        public void b(BodyProgress bodyProgress, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(bodyProgress, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            bodyProgress.c(httpClient);
        }

        /* renamed from: d */
        public BodyProgress a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            return new BodyProgress();
        }

        public AttributeKey getKey() {
            return BodyProgress.b;
        }

        public Plugin() {
        }
    }

    public final void c(HttpClient httpClient) {
        PipelinePhase pipelinePhase = new PipelinePhase("ObservableContent");
        httpClient.n().j(HttpRequestPipeline.g.b(), pipelinePhase);
        httpClient.n().l(pipelinePhase, new BodyProgress$handle$1((Continuation<? super BodyProgress$handle$1>) null));
        httpClient.j().l(HttpReceivePipeline.g.a(), new BodyProgress$handle$2((Continuation<? super BodyProgress$handle$2>) null));
    }
}
