package kotlinx.coroutines.debug.internal;

import _COROUTINE.ArtificialStackFrames;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.Job;

@SourceDebugExtension({"SMAP\nDebugProbesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,620:1\n150#1:638\n151#1,4:640\n156#1,5:645\n150#1:650\n151#1,4:652\n156#1,5:657\n1#2:621\n1#2:639\n1#2:651\n766#3:622\n857#3,2:623\n1208#3,2:625\n1238#3,4:627\n1855#3,2:665\n350#3,7:673\n1819#3,8:680\n603#4:631\n603#4:644\n603#4:656\n603#4:662\n1295#4,2:663\n37#5,2:632\n37#5,2:634\n37#5,2:636\n1627#6,6:667\n1735#6,6:688\n*S KotlinDebug\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n245#1:638\n245#1:640,4\n245#1:645,5\n252#1:650\n252#1:652,4\n252#1:657,5\n245#1:639\n252#1:651\n110#1:622\n110#1:623,2\n111#1:625,2\n111#1:627,4\n307#1:665,2\n416#1:673,7\n506#1:680,8\n154#1:631\n245#1:644\n252#1:656\n287#1:662\n288#1:663,2\n211#1:632,2\n212#1:634,2\n213#1:636,2\n355#1:667,6\n558#1:688,6\n*E\n"})
@PublishedApi
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001:\u00012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\r\u001a\u0004\u0018\u00010\f*\u00020\fH\u0010¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\u00020\u00062\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u001c\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00050\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\"\u0010#\u001a\u00020\u00058\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010%\u001a\u00020\u00058\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001d\u0010 \"\u0004\b$\u0010\"R\"\u0010(\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b&\u0010 \"\u0004\b'\u0010\"R\"\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010)R \u0010-\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020+0\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010\u001bR\u000b\u0010/\u001a\u00020.8\u0002X\u0004R\u000b\u00101\u001a\u0002008\u0002X\u0004¨\u00063"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "", "<init>", "()V", "Lkotlin/Function1;", "", "", "d", "()Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "f", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Z", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "h", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "owner", "g", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)V", "Ljava/lang/StackTraceElement;", "b", "Ljava/lang/StackTraceElement;", "ARTIFICIAL_FRAME", "Ljava/text/SimpleDateFormat;", "c", "Ljava/text/SimpleDateFormat;", "dateFormat", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "capturedCoroutinesMap", "e", "Z", "getSanitizeStackTraces$kotlinx_coroutines_core", "()Z", "setSanitizeStackTraces$kotlinx_coroutines_core", "(Z)V", "sanitizeStackTraces", "setEnableCreationStackTraces$kotlinx_coroutines_core", "enableCreationStackTraces", "getIgnoreCoroutinesWithEmptyContext", "setIgnoreCoroutinesWithEmptyContext", "ignoreCoroutinesWithEmptyContext", "Lkotlin/jvm/functions/Function1;", "dynamicAttach", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "i", "callerInfoCache", "Lkotlinx/atomicfu/AtomicInt;", "installations", "Lkotlinx/atomicfu/AtomicLong;", "sequenceNumber", "CoroutineOwner", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
public final class DebugProbesImpl {

    /* renamed from: a  reason: collision with root package name */
    public static final DebugProbesImpl f3772a;
    public static final StackTraceElement b = new ArtificialStackFrames().b();
    public static final SimpleDateFormat c = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public static final ConcurrentWeakMap d = new ConcurrentWeakMap(false, 1, (DefaultConstructorMarker) null);
    public static boolean e = true;
    public static boolean f = true;
    public static boolean g = true;
    public static final Function1 h;
    public static final ConcurrentWeakMap i = new ConcurrentWeakMap(true);
    public static final DebugProbesImpl$Installations$kotlinx$VolatileWrapper j = new DebugProbesImpl$Installations$kotlinx$VolatileWrapper((DefaultConstructorMarker) null);
    public static final DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper k = new DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001d8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u001e\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", "", "resumeWith", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "a", "Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "b", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "info", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "frame", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public static final class CoroutineOwner<T> implements Continuation<T>, CoroutineStackFrame {

        /* renamed from: a  reason: collision with root package name */
        public final Continuation f3773a;
        public final DebugCoroutineInfoImpl b;

        public final StackTraceFrame a() {
            return this.b.d();
        }

        public CoroutineStackFrame getCallerFrame() {
            StackTraceFrame a2 = a();
            if (a2 != null) {
                return a2.getCallerFrame();
            }
            return null;
        }

        public CoroutineContext getContext() {
            return this.f3773a.getContext();
        }

        public StackTraceElement getStackTraceElement() {
            StackTraceFrame a2 = a();
            if (a2 != null) {
                return a2.getStackTraceElement();
            }
            return null;
        }

        public void resumeWith(Object obj) {
            DebugProbesImpl.f3772a.g(this);
            this.f3773a.resumeWith(obj);
        }

        public String toString() {
            return this.f3773a.toString();
        }
    }

    static {
        DebugProbesImpl debugProbesImpl = new DebugProbesImpl();
        f3772a = debugProbesImpl;
        h = debugProbesImpl.d();
    }

    public final Function1 d() {
        Object obj;
        Function1 function1 = null;
        try {
            Result.Companion companion = Result.Companion;
            Object newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance((Object[]) null);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            obj = Result.m20constructorimpl((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(newInstance, 1));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m26isFailureimpl(obj)) {
            function1 = obj;
        }
        return function1;
    }

    public final boolean e() {
        return f;
    }

    public final boolean f(CoroutineOwner coroutineOwner) {
        Job job;
        CoroutineContext c2 = coroutineOwner.b.c();
        if (c2 == null || (job = (Job) c2.get(Job.b0)) == null || !job.isCompleted()) {
            return false;
        }
        d.remove(coroutineOwner);
        return true;
    }

    public final void g(CoroutineOwner coroutineOwner) {
        CoroutineStackFrame h2;
        d.remove(coroutineOwner);
        CoroutineStackFrame f2 = coroutineOwner.b.f();
        if (f2 != null && (h2 = h(f2)) != null) {
            i.remove(h2);
        }
    }

    public final CoroutineStackFrame h(CoroutineStackFrame coroutineStackFrame) {
        do {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        } while (coroutineStackFrame.getStackTraceElement() == null);
        return coroutineStackFrame;
    }
}
