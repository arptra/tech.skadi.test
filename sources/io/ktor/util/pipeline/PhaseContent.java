package io.ktor.util.pipeline;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nPhaseContent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PhaseContent.kt\nio/ktor/util/pipeline/PhaseContent\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,91:1\n1#2:92\n*E\n"})
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u0000 !*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u00014Ba\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012H\u0010\u000e\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r0\b¢\u0006\u0004\b\u000f\u0010\u0010B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0011JQ\u0010\u0013\u001a\u00020\f2B\u0010\u0012\u001a>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r¢\u0006\u0004\b\u0013\u0010\u0014JW\u0010\u0016\u001a\u00020\f2H\u0010\u0015\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r0\b¢\u0006\u0004\b\u0016\u0010\u0017JO\u0010\u0018\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r0\b¢\u0006\u0004\b\u0018\u0010\u0019JO\u0010\u001a\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r0\b¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b$\u0010%RX\u0010\u000e\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r0\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010&R\"\u0010-\u001a\u00020'8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010/\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\b.\u0010*R\u0011\u00103\u001a\u0002008F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00065"}, d2 = {"Lio/ktor/util/pipeline/PhaseContent;", "", "TSubject", "Call", "Lio/ktor/util/pipeline/PipelinePhase;", "phase", "Lio/ktor/util/pipeline/PipelinePhaseRelation;", "relation", "", "Lkotlin/Function3;", "Lio/ktor/util/pipeline/PipelineContext;", "Lkotlin/coroutines/Continuation;", "", "Lio/ktor/util/pipeline/PipelineInterceptorFunction;", "interceptors", "<init>", "(Lio/ktor/util/pipeline/PipelinePhase;Lio/ktor/util/pipeline/PipelinePhaseRelation;Ljava/util/List;)V", "(Lio/ktor/util/pipeline/PipelinePhase;Lio/ktor/util/pipeline/PipelinePhaseRelation;)V", "interceptor", "a", "(Lkotlin/jvm/functions/Function3;)V", "destination", "b", "(Ljava/util/List;)V", "i", "()Ljava/util/List;", "c", "", "toString", "()Ljava/lang/String;", "d", "()V", "Lio/ktor/util/pipeline/PipelinePhase;", "e", "()Lio/ktor/util/pipeline/PipelinePhase;", "Lio/ktor/util/pipeline/PipelinePhaseRelation;", "f", "()Lio/ktor/util/pipeline/PipelinePhaseRelation;", "Ljava/util/List;", "", "Z", "getShared", "()Z", "setShared", "(Z)V", "shared", "h", "isEmpty", "", "g", "()I", "size", "Companion", "ktor-utils"}, k = 1, mv = {1, 8, 0})
public final class PhaseContent<TSubject, Call> {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public static final List f = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public final PipelinePhase f9064a;
    public final PipelinePhaseRelation b;
    public List c;
    public boolean d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/util/pipeline/PhaseContent$Companion;", "", "<init>", "()V", "ktor-utils"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public PhaseContent(PipelinePhase pipelinePhase, PipelinePhaseRelation pipelinePhaseRelation, List list) {
        Intrinsics.checkNotNullParameter(pipelinePhase, "phase");
        Intrinsics.checkNotNullParameter(pipelinePhaseRelation, "relation");
        Intrinsics.checkNotNullParameter(list, "interceptors");
        this.f9064a = pipelinePhase;
        this.b = pipelinePhaseRelation;
        this.c = list;
        this.d = true;
    }

    public final void a(Function3 function3) {
        Intrinsics.checkNotNullParameter(function3, "interceptor");
        if (this.d) {
            d();
        }
        this.c.add(function3);
    }

    public final void b(List list) {
        Intrinsics.checkNotNullParameter(list, RtspHeaders.Values.DESTINATION);
        List list2 = this.c;
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(list.size() + list2.size());
        }
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            list.add(list2.get(i));
        }
    }

    public final List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.c);
        return arrayList;
    }

    public final void d() {
        this.c = c();
        this.d = false;
    }

    public final PipelinePhase e() {
        return this.f9064a;
    }

    public final PipelinePhaseRelation f() {
        return this.b;
    }

    public final int g() {
        return this.c.size();
    }

    public final boolean h() {
        return this.c.isEmpty();
    }

    public final List i() {
        this.d = true;
        return this.c;
    }

    public String toString() {
        return "Phase `" + this.f9064a.a() + "`, " + g() + " handlers";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PhaseContent(io.ktor.util.pipeline.PipelinePhase r3, io.ktor.util.pipeline.PipelinePhaseRelation r4) {
        /*
            r2 = this;
            java.lang.String r0 = "phase"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "relation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.List r0 = f
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Function3<io.ktor.util.pipeline.PipelineContext<TSubject of io.ktor.util.pipeline.PhaseContent, Call of io.ktor.util.pipeline.PhaseContent>, TSubject of io.ktor.util.pipeline.PhaseContent, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>{ io.ktor.util.pipeline.PipelineKt.PipelineInterceptorFunction<TSubject of io.ktor.util.pipeline.PhaseContent, Call of io.ktor.util.pipeline.PhaseContent> }>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            java.util.List r1 = kotlin.jvm.internal.TypeIntrinsics.asMutableList(r0)
            r2.<init>(r3, r4, r1)
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x001f
            return
        L_0x001f:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "The shared empty array list has been modified"
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.pipeline.PhaseContent.<init>(io.ktor.util.pipeline.PipelinePhase, io.ktor.util.pipeline.PipelinePhaseRelation):void");
    }
}
