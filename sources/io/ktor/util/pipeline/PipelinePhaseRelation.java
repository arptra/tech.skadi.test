package io.ktor.util.pipeline;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lio/ktor/util/pipeline/PipelinePhaseRelation;", "", "()V", "After", "Before", "Last", "Lio/ktor/util/pipeline/PipelinePhaseRelation$After;", "Lio/ktor/util/pipeline/PipelinePhaseRelation$Before;", "Lio/ktor/util/pipeline/PipelinePhaseRelation$Last;", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PipelinePhaseRelation {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/util/pipeline/PipelinePhaseRelation$After;", "Lio/ktor/util/pipeline/PipelinePhaseRelation;", "Lio/ktor/util/pipeline/PipelinePhase;", "relativeTo", "<init>", "(Lio/ktor/util/pipeline/PipelinePhase;)V", "a", "Lio/ktor/util/pipeline/PipelinePhase;", "()Lio/ktor/util/pipeline/PipelinePhase;", "ktor-utils"}, k = 1, mv = {1, 8, 0})
    public static final class After extends PipelinePhaseRelation {

        /* renamed from: a  reason: collision with root package name */
        public final PipelinePhase f9069a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public After(PipelinePhase pipelinePhase) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(pipelinePhase, "relativeTo");
            this.f9069a = pipelinePhase;
        }

        public final PipelinePhase a() {
            return this.f9069a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/util/pipeline/PipelinePhaseRelation$Before;", "Lio/ktor/util/pipeline/PipelinePhaseRelation;", "Lio/ktor/util/pipeline/PipelinePhase;", "relativeTo", "<init>", "(Lio/ktor/util/pipeline/PipelinePhase;)V", "a", "Lio/ktor/util/pipeline/PipelinePhase;", "getRelativeTo", "()Lio/ktor/util/pipeline/PipelinePhase;", "ktor-utils"}, k = 1, mv = {1, 8, 0})
    public static final class Before extends PipelinePhaseRelation {

        /* renamed from: a  reason: collision with root package name */
        public final PipelinePhase f9070a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Before(PipelinePhase pipelinePhase) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(pipelinePhase, "relativeTo");
            this.f9070a = pipelinePhase;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/ktor/util/pipeline/PipelinePhaseRelation$Last;", "Lio/ktor/util/pipeline/PipelinePhaseRelation;", "()V", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Last extends PipelinePhaseRelation {

        /* renamed from: a  reason: collision with root package name */
        public static final Last f9071a = new Last();

        public Last() {
            super((DefaultConstructorMarker) null);
        }
    }

    public /* synthetic */ PipelinePhaseRelation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public PipelinePhaseRelation() {
    }
}
