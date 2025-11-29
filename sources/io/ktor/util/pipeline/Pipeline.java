package io.ktor.util.pipeline;

import io.ktor.util.pipeline.PipelinePhaseRelation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\f\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001J3\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015JQ\u0010\u001b\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u001a0\u0016H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJQ\u0010\u001d\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u001a0\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJY\u0010!\u001a\u00020\u00192H\u0010 \u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u001a0\u0016H\u0002¢\u0006\u0004\b!\u0010\"J#\u0010$\u001a\u00020\u00192\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rH\u0002¢\u0006\u0004\b$\u0010%J[\u0010'\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2B\u0010&\u001a>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u001aH\u0002¢\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u001d\u0010,\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b,\u0010-J\u001d\u0010.\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b.\u0010-JS\u00100\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u000b29\u0010&\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017¢\u0006\u0002\b/ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0019H\u0016¢\u0006\u0004\b2\u0010\u001fR\u001a\u00106\u001a\u00020\u00138\u0016XD¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u0001078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u00108R\u0016\u0010;\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010:R\u0016\u0010<\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u00103R\u0018\u0010>\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010=R¬\u0001\u0010B\u001aF\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u001a\u0018\u00010\u00162J\u0010?\u001aF\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u001a\u0018\u00010\u00168B@BX\u000e¢\u0006\f\u001a\u0004\b@\u0010\u001c\"\u0004\bA\u0010\"\u0002\u0004\n\u0002\b\u0019¨\u0006C"}, d2 = {"Lio/ktor/util/pipeline/Pipeline;", "", "TSubject", "TContext", "context", "subject", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/util/pipeline/PipelineContext;", "c", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/util/pipeline/PipelinePhase;", "phase", "Lio/ktor/util/pipeline/PhaseContent;", "e", "(Lio/ktor/util/pipeline/PipelinePhase;)Lio/ktor/util/pipeline/PhaseContent;", "", "f", "(Lio/ktor/util/pipeline/PipelinePhase;)I", "", "i", "(Lio/ktor/util/pipeline/PipelinePhase;)Z", "", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "Lio/ktor/util/pipeline/PipelineInterceptorFunction;", "b", "()Ljava/util/List;", "q", "n", "()V", "list", "m", "(Ljava/util/List;)V", "phaseContent", "p", "(Lio/ktor/util/pipeline/PhaseContent;)V", "block", "r", "(Lio/ktor/util/pipeline/PipelinePhase;Lkotlin/jvm/functions/Function3;)Z", "d", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reference", "j", "(Lio/ktor/util/pipeline/PipelinePhase;Lio/ktor/util/pipeline/PipelinePhase;)V", "k", "Lkotlin/ExtensionFunctionType;", "l", "(Lio/ktor/util/pipeline/PipelinePhase;Lkotlin/jvm/functions/Function3;)V", "a", "Z", "g", "()Z", "developmentMode", "", "Ljava/util/List;", "phasesRaw", "I", "interceptorsQuantity", "interceptorsListShared", "Lio/ktor/util/pipeline/PipelinePhase;", "interceptorsListSharedPhase", "value", "h", "o", "interceptors", "ktor-utils"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPipeline.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pipeline.kt\nio/ktor/util/pipeline/Pipeline\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,503:1\n1549#2:504\n1620#2,3:505\n1855#2,2:508\n800#2,11:510\n288#2,2:521\n1855#2,2:523\n*S KotlinDebug\n*F\n+ 1 Pipeline.kt\nio/ktor/util/pipeline/Pipeline\n*L\n43#1:504\n43#1:505,3\n70#1:508,2\n173#1:510,11\n174#1:521,2\n214#1:523,2\n*E\n"})
public class Pipeline<TSubject, TContext> {
    @NotNull
    private volatile /* synthetic */ Object _interceptors;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f9065a;
    public final List b;
    public int c;
    public boolean d;
    public PipelinePhase e;

    public void a() {
    }

    public final List b() {
        int lastIndex;
        int i = this.c;
        if (i == 0) {
            m(CollectionsKt.emptyList());
            return CollectionsKt.emptyList();
        }
        List list = this.b;
        int i2 = 0;
        if (i == 1 && (lastIndex = CollectionsKt.getLastIndex(list)) >= 0) {
            int i3 = 0;
            while (true) {
                Object obj = list.get(i3);
                PhaseContent phaseContent = obj instanceof PhaseContent ? (PhaseContent) obj : null;
                if (phaseContent == null || phaseContent.h()) {
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                } else {
                    List i4 = phaseContent.i();
                    p(phaseContent);
                    return i4;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        int lastIndex2 = CollectionsKt.getLastIndex(list);
        if (lastIndex2 >= 0) {
            while (true) {
                Object obj2 = list.get(i2);
                PhaseContent phaseContent2 = obj2 instanceof PhaseContent ? (PhaseContent) obj2 : null;
                if (phaseContent2 != null) {
                    phaseContent2.b(arrayList);
                }
                if (i2 == lastIndex2) {
                    break;
                }
                i2++;
            }
        }
        m(arrayList);
        return arrayList;
    }

    public final PipelineContext c(Object obj, Object obj2, CoroutineContext coroutineContext) {
        return PipelineContextKt.a(obj, q(), obj2, coroutineContext, g());
    }

    public final Object d(Object obj, Object obj2, Continuation continuation) {
        return c(obj, obj2, continuation.getContext()).a(obj2, continuation);
    }

    public final PhaseContent e(PipelinePhase pipelinePhase) {
        List list = this.b;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj == pipelinePhase) {
                PhaseContent phaseContent = new PhaseContent(pipelinePhase, PipelinePhaseRelation.Last.f9071a);
                list.set(i, phaseContent);
                return phaseContent;
            }
            if (obj instanceof PhaseContent) {
                PhaseContent phaseContent2 = (PhaseContent) obj;
                if (phaseContent2.e() == pipelinePhase) {
                    return phaseContent2;
                }
            }
        }
        return null;
    }

    public final int f(PipelinePhase pipelinePhase) {
        List list = this.b;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj == pipelinePhase || ((obj instanceof PhaseContent) && ((PhaseContent) obj).e() == pipelinePhase)) {
                return i;
            }
        }
        return -1;
    }

    public boolean g() {
        return this.f9065a;
    }

    public final List h() {
        return (List) this._interceptors;
    }

    public final boolean i(PipelinePhase pipelinePhase) {
        List list = this.b;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj == pipelinePhase) {
                return true;
            }
            if ((obj instanceof PhaseContent) && ((PhaseContent) obj).e() == pipelinePhase) {
                return true;
            }
        }
        return false;
    }

    public final void j(PipelinePhase pipelinePhase, PipelinePhase pipelinePhase2) {
        PipelinePhaseRelation f;
        PipelinePhase a2;
        Intrinsics.checkNotNullParameter(pipelinePhase, "reference");
        Intrinsics.checkNotNullParameter(pipelinePhase2, "phase");
        if (!i(pipelinePhase2)) {
            int f2 = f(pipelinePhase);
            if (f2 != -1) {
                int i = f2 + 1;
                int lastIndex = CollectionsKt.getLastIndex(this.b);
                if (i <= lastIndex) {
                    while (true) {
                        Object obj = this.b.get(i);
                        PipelinePhaseRelation.After after = null;
                        PhaseContent phaseContent = obj instanceof PhaseContent ? (PhaseContent) obj : null;
                        if (phaseContent != null && (f = phaseContent.f()) != null) {
                            if (f instanceof PipelinePhaseRelation.After) {
                                after = (PipelinePhaseRelation.After) f;
                            }
                            if (!(after == null || (a2 = after.a()) == null || !Intrinsics.areEqual((Object) a2, (Object) pipelinePhase))) {
                                f2 = i;
                            }
                            if (i == lastIndex) {
                                break;
                            }
                            i++;
                        } else {
                            break;
                        }
                    }
                }
                this.b.add(f2 + 1, new PhaseContent(pipelinePhase2, new PipelinePhaseRelation.After(pipelinePhase)));
                return;
            }
            throw new InvalidPhaseException("Phase " + pipelinePhase + " was not registered for this pipeline");
        }
    }

    public final void k(PipelinePhase pipelinePhase, PipelinePhase pipelinePhase2) {
        Intrinsics.checkNotNullParameter(pipelinePhase, "reference");
        Intrinsics.checkNotNullParameter(pipelinePhase2, "phase");
        if (!i(pipelinePhase2)) {
            int f = f(pipelinePhase);
            if (f != -1) {
                this.b.add(f, new PhaseContent(pipelinePhase2, new PipelinePhaseRelation.Before(pipelinePhase)));
                return;
            }
            throw new InvalidPhaseException("Phase " + pipelinePhase + " was not registered for this pipeline");
        }
    }

    public final void l(PipelinePhase pipelinePhase, Function3 function3) {
        Intrinsics.checkNotNullParameter(pipelinePhase, "phase");
        Intrinsics.checkNotNullParameter(function3, "block");
        PhaseContent e2 = e(pipelinePhase);
        if (e2 != null) {
            Function3 function32 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function3, 3);
            if (r(pipelinePhase, function3)) {
                this.c++;
                return;
            }
            e2.a(function3);
            this.c++;
            n();
            a();
            return;
        }
        throw new InvalidPhaseException("Phase " + pipelinePhase + " was not registered for this pipeline");
    }

    public final void m(List list) {
        o(list);
        this.d = false;
        this.e = null;
    }

    public final void n() {
        o((List) null);
        this.d = false;
        this.e = null;
    }

    public final void o(List list) {
        this._interceptors = list;
    }

    public final void p(PhaseContent phaseContent) {
        o(phaseContent.i());
        this.d = false;
        this.e = phaseContent.e();
    }

    public final List q() {
        if (h() == null) {
            b();
        }
        this.d = true;
        List h = h();
        Intrinsics.checkNotNull(h);
        return h;
    }

    public final boolean r(PipelinePhase pipelinePhase, Function3 function3) {
        List h = h();
        if (this.b.isEmpty() || h == null || this.d || !TypeIntrinsics.isMutableList(h)) {
            return false;
        }
        if (Intrinsics.areEqual((Object) this.e, (Object) pipelinePhase)) {
            h.add(function3);
            return true;
        } else if (!Intrinsics.areEqual((Object) pipelinePhase, CollectionsKt.last(this.b)) && f(pipelinePhase) != CollectionsKt.getLastIndex(this.b)) {
            return false;
        } else {
            PhaseContent e2 = e(pipelinePhase);
            Intrinsics.checkNotNull(e2);
            e2.a(function3);
            h.add(function3);
            return true;
        }
    }
}
