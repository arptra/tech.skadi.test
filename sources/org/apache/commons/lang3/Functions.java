package org.apache.commons.lang3;

import com.honey.account.xb.e;
import com.honey.account.xb.f;
import com.honey.account.xb.g;
import com.honey.account.xb.h;
import com.honey.account.xb.i;
import com.honey.account.xb.j;
import com.honey.account.xb.k;
import com.honey.account.xb.l;
import com.honey.account.xb.m;
import com.honey.account.xb.n;
import com.honey.account.xb.o;
import com.honey.account.xb.p;
import com.honey.account.xb.q;
import com.honey.account.xb.r;
import com.honey.account.xb.s;
import com.honey.account.xb.t;
import com.honey.account.xb.u;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.commons.lang3.Streams;
import org.apache.commons.lang3.function.FailableBooleanSupplier;

@Deprecated
public class Functions {

    @FunctionalInterface
    @Deprecated
    public interface FailableBiConsumer<O1, O2, T extends Throwable> {
        void accept(O1 o1, O2 o2) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableBiFunction<O1, O2, R, T extends Throwable> {
        R apply(O1 o1, O2 o2) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableBiPredicate<O1, O2, T extends Throwable> {
        boolean test(O1 o1, O2 o2) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableCallable<R, T extends Throwable> {
        R call() throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableConsumer<O, T extends Throwable> {
        void accept(O o) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableFunction<I, R, T extends Throwable> {
        R apply(I i) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailablePredicate<I, T extends Throwable> {
        boolean test(I i) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableRunnable<T extends Throwable> {
        void run() throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableSupplier<R, T extends Throwable> {
        R get() throws Throwable;
    }

    public static <O1, O2, T extends Throwable> void accept(FailableBiConsumer<O1, O2, T> failableBiConsumer, O1 o1, O2 o2) {
        run(new s(failableBiConsumer, o1, o2));
    }

    public static <O1, O2, O, T extends Throwable> O apply(FailableBiFunction<O1, O2, O, T> failableBiFunction, O1 o1, O2 o2) {
        return get(new t(failableBiFunction, o1, o2));
    }

    public static <O1, O2> BiConsumer<O1, O2> asBiConsumer(FailableBiConsumer<O1, O2, ?> failableBiConsumer) {
        return new j(failableBiConsumer);
    }

    public static <O1, O2, O> BiFunction<O1, O2, O> asBiFunction(FailableBiFunction<O1, O2, O, ?> failableBiFunction) {
        return new n(failableBiFunction);
    }

    public static <O1, O2> BiPredicate<O1, O2> asBiPredicate(FailableBiPredicate<O1, O2, ?> failableBiPredicate) {
        return new f(failableBiPredicate);
    }

    public static <O> Callable<O> asCallable(FailableCallable<O, ?> failableCallable) {
        return new l(failableCallable);
    }

    public static <I> Consumer<I> asConsumer(FailableConsumer<I, ?> failableConsumer) {
        return new h(failableConsumer);
    }

    public static <I, O> Function<I, O> asFunction(FailableFunction<I, O, ?> failableFunction) {
        return new u(failableFunction);
    }

    public static <I> Predicate<I> asPredicate(FailablePredicate<I, ?> failablePredicate) {
        return new e(failablePredicate);
    }

    public static Runnable asRunnable(FailableRunnable<?> failableRunnable) {
        return new q(failableRunnable);
    }

    public static <O> Supplier<O> asSupplier(FailableSupplier<O, ?> failableSupplier) {
        return new o(failableSupplier);
    }

    public static <O, T extends Throwable> O call(FailableCallable<O, T> failableCallable) {
        failableCallable.getClass();
        return get(new k(failableCallable));
    }

    public static <O, T extends Throwable> O get(FailableSupplier<O, T> failableSupplier) {
        try {
            return failableSupplier.get();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    private static <T extends Throwable> boolean getAsBoolean(FailableBooleanSupplier<T> failableBooleanSupplier) {
        try {
            return failableBooleanSupplier.getAsBoolean();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static RuntimeException rethrow(Throwable th) {
        Objects.requireNonNull(th, "throwable");
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof IOException) {
            throw new UncheckedIOException((IOException) th);
        } else {
            throw new UndeclaredThrowableException(th);
        }
    }

    public static <T extends Throwable> void run(FailableRunnable<T> failableRunnable) {
        try {
            failableRunnable.run();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <O> Streams.FailableStream<O> stream(Collection<O> collection) {
        return new Streams.FailableStream<>(collection.stream());
    }

    public static <O1, O2, T extends Throwable> boolean test(FailableBiPredicate<O1, O2, T> failableBiPredicate, O1 o1, O2 o2) {
        return getAsBoolean(new g(failableBiPredicate, o1, o2));
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableConsumer<Throwable, ? extends Throwable> failableConsumer, FailableRunnable<? extends Throwable>... failableRunnableArr) {
        if (failableConsumer == null) {
            new r
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: CONSTRUCTOR  (r6v2 ? I:com.honey.account.xb.r) =  call: com.honey.account.xb.r.<init>():void type: CONSTRUCTOR in method: org.apache.commons.lang3.Functions.tryWithResources(org.apache.commons.lang3.Functions$FailableRunnable, org.apache.commons.lang3.Functions$FailableConsumer, org.apache.commons.lang3.Functions$FailableRunnable[]):void, dex: classes5.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r6v2 ?
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	... 34 more
                */
            /*
                if (r6 != 0) goto L_0x0007
                com.honey.account.xb.r r6 = new com.honey.account.xb.r
                r6.<init>()
            L_0x0007:
                r0 = 0
                if (r7 == 0) goto L_0x0018
                int r1 = r7.length
                r2 = r0
            L_0x000c:
                if (r2 >= r1) goto L_0x0018
                r3 = r7[r2]
                java.lang.String r4 = "runnable"
                java.util.Objects.requireNonNull(r3, r4)
                int r2 = r2 + 1
                goto L_0x000c
            L_0x0018:
                r5.run()     // Catch:{ all -> 0x001d }
                r5 = 0
                goto L_0x001e
            L_0x001d:
                r5 = move-exception
            L_0x001e:
                if (r7 == 0) goto L_0x0030
                int r1 = r7.length
            L_0x0021:
                if (r0 >= r1) goto L_0x0030
                r2 = r7[r0]
                r2.run()     // Catch:{ all -> 0x0029 }
                goto L_0x002d
            L_0x0029:
                r2 = move-exception
                if (r5 != 0) goto L_0x002d
                r5 = r2
            L_0x002d:
                int r0 = r0 + 1
                goto L_0x0021
            L_0x0030:
                if (r5 == 0) goto L_0x003c
                r6.accept(r5)     // Catch:{ all -> 0x0036 }
                goto L_0x003c
            L_0x0036:
                r5 = move-exception
                java.lang.RuntimeException r5 = rethrow(r5)
                throw r5
            L_0x003c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.Functions.tryWithResources(org.apache.commons.lang3.Functions$FailableRunnable, org.apache.commons.lang3.Functions$FailableConsumer, org.apache.commons.lang3.Functions$FailableRunnable[]):void");
        }

        public static <O, T extends Throwable> void accept(FailableConsumer<O, T> failableConsumer, O o) {
            run(new p(failableConsumer, o));
        }

        public static <I, O, T extends Throwable> O apply(FailableFunction<I, O, T> failableFunction, I i) {
            return get(new m(failableFunction, i));
        }

        public static <O> Streams.FailableStream<O> stream(Stream<O> stream) {
            return new Streams.FailableStream<>(stream);
        }

        public static <O, T extends Throwable> boolean test(FailablePredicate<O, T> failablePredicate, O o) {
            return getAsBoolean(new i(failablePredicate, o));
        }

        @SafeVarargs
        public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableRunnable<? extends Throwable>... failableRunnableArr) {
            tryWithResources(failableRunnable, (FailableConsumer<Throwable, ? extends Throwable>) null, failableRunnableArr);
        }
    }
