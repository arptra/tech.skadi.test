package io.ktor.util.pipeline;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, d2 = {"Lio/ktor/util/pipeline/PipelinePhase;", "", "", "name", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "a", "Ljava/lang/String;", "ktor-utils"}, k = 1, mv = {1, 8, 0})
public final class PipelinePhase {

    /* renamed from: a  reason: collision with root package name */
    public final String f9068a;

    public PipelinePhase(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f9068a = str;
    }

    public final String a() {
        return this.f9068a;
    }

    public String toString() {
        return "Phase('" + this.f9068a + "')";
    }
}
