package io.ktor.client.statement;

import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00072\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nR\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lio/ktor/client/statement/HttpReceivePipeline;", "Lio/ktor/util/pipeline/Pipeline;", "Lio/ktor/client/statement/HttpResponse;", "", "", "f", "Z", "g", "()Z", "developmentMode", "Phases", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class HttpReceivePipeline extends Pipeline<HttpResponse, Unit> {
    public static final Phases g = new Phases((DefaultConstructorMarker) null);
    public static final PipelinePhase h = new PipelinePhase("Before");
    public static final PipelinePhase i = new PipelinePhase("State");
    public static final PipelinePhase j = new PipelinePhase("After");
    public final boolean f;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lio/ktor/client/statement/HttpReceivePipeline$Phases;", "", "<init>", "()V", "Lio/ktor/util/pipeline/PipelinePhase;", "State", "Lio/ktor/util/pipeline/PipelinePhase;", "b", "()Lio/ktor/util/pipeline/PipelinePhase;", "After", "a", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Phases {
        public /* synthetic */ Phases(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PipelinePhase a() {
            return HttpReceivePipeline.j;
        }

        public final PipelinePhase b() {
            return HttpReceivePipeline.i;
        }

        public Phases() {
        }
    }

    public boolean g() {
        return this.f;
    }
}
