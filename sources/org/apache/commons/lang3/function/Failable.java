package org.apache.commons.lang3.function;

import com.honey.account.dc.a;
import com.honey.account.dc.b;
import com.honey.account.dc.c;
import com.honey.account.dc.d;
import com.honey.account.dc.e;
import com.honey.account.dc.f;
import com.honey.account.dc.g;
import com.honey.account.dc.h;
import com.honey.account.dc.i;
import com.honey.account.dc.j;
import com.honey.account.dc.k;
import com.honey.account.dc.l;
import com.honey.account.dc.m;
import com.honey.account.dc.n;
import com.honey.account.dc.o;
import com.honey.account.dc.p;
import com.honey.account.dc.q;
import com.honey.account.dc.r;
import com.honey.account.dc.s;
import com.honey.account.dc.t;
import com.honey.account.dc.u;
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
import org.apache.commons.lang3.stream.Streams;

public class Failable {
    private Failable() {
    }

    public static <T, U, E extends Throwable> void accept(FailableBiConsumer<T, U, E> failableBiConsumer, T t, U u) {
        run(new t(failableBiConsumer, t, u));
    }

    public static <T, U, R, E extends Throwable> R apply(FailableBiFunction<T, U, R, E> failableBiFunction, T t, U u) {
        return get(new u(failableBiFunction, t, u));
    }

    public static <E extends Throwable> double applyAsDouble(FailableDoubleBinaryOperator<E> failableDoubleBinaryOperator, double d, double d2) {
        return getAsDouble(new l(failableDoubleBinaryOperator, d, d2));
    }

    public static <T, U> BiConsumer<T, U> asBiConsumer(FailableBiConsumer<T, U, ?> failableBiConsumer) {
        return new o(failableBiConsumer);
    }

    public static <T, U, R> BiFunction<T, U, R> asBiFunction(FailableBiFunction<T, U, R, ?> failableBiFunction) {
        return new h(failableBiFunction);
    }

    public static <T, U> BiPredicate<T, U> asBiPredicate(FailableBiPredicate<T, U, ?> failableBiPredicate) {
        return new a(failableBiPredicate);
    }

    public static <V> Callable<V> asCallable(FailableCallable<V, ?> failableCallable) {
        return new j(failableCallable);
    }

    public static <T> Consumer<T> asConsumer(FailableConsumer<T, ?> failableConsumer) {
        return new r(failableConsumer);
    }

    public static <T, R> Function<T, R> asFunction(FailableFunction<T, R, ?> failableFunction) {
        return new n(failableFunction);
    }

    public static <T> Predicate<T> asPredicate(FailablePredicate<T, ?> failablePredicate) {
        return new q(failablePredicate);
    }

    public static Runnable asRunnable(FailableRunnable<?> failableRunnable) {
        return new i(failableRunnable);
    }

    public static <T> Supplier<T> asSupplier(FailableSupplier<T, ?> failableSupplier) {
        return new f(failableSupplier);
    }

    public static <V, E extends Throwable> V call(FailableCallable<V, E> failableCallable) {
        failableCallable.getClass();
        return get(new m(failableCallable));
    }

    public static <T, E extends Throwable> T get(FailableSupplier<T, E> failableSupplier) {
        try {
            return failableSupplier.get();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> boolean getAsBoolean(FailableBooleanSupplier<E> failableBooleanSupplier) {
        try {
            return failableBooleanSupplier.getAsBoolean();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> double getAsDouble(FailableDoubleSupplier<E> failableDoubleSupplier) {
        try {
            return failableDoubleSupplier.getAsDouble();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> int getAsInt(FailableIntSupplier<E> failableIntSupplier) {
        try {
            return failableIntSupplier.getAsInt();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> long getAsLong(FailableLongSupplier<E> failableLongSupplier) {
        try {
            return failableLongSupplier.getAsLong();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> short getAsShort(FailableShortSupplier<E> failableShortSupplier) {
        try {
            return failableShortSupplier.getAsShort();
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

    public static <E extends Throwable> void run(FailableRunnable<E> failableRunnable) {
        try {
            failableRunnable.run();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E> Streams.FailableStream<E> stream(Collection<E> collection) {
        return new Streams.FailableStream<>(collection.stream());
    }

    public static <T, U, E extends Throwable> boolean test(FailableBiPredicate<T, U, E> failableBiPredicate, T t, U u) {
        return getAsBoolean(new g(failableBiPredicate, t, u));
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableConsumer<Throwable, ? extends Throwable> failableConsumer, FailableRunnable<? extends Throwable>... failableRunnableArr) {
        if (failableConsumer == null) {
            new e
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: CONSTRUCTOR  (r6v2 ? I:com.honey.account.dc.e) =  call: com.honey.account.dc.e.<init>():void type: CONSTRUCTOR in method: org.apache.commons.lang3.function.Failable.tryWithResources(org.apache.commons.lang3.function.FailableRunnable, org.apache.commons.lang3.function.FailableConsumer, org.apache.commons.lang3.function.FailableRunnable[]):void, dex: classes5.dex
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
                com.honey.account.dc.e r6 = new com.honey.account.dc.e
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
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.function.Failable.tryWithResources(org.apache.commons.lang3.function.FailableRunnable, org.apache.commons.lang3.function.FailableConsumer, org.apache.commons.lang3.function.FailableRunnable[]):void");
        }

        public static <T, E extends Throwable> void accept(FailableConsumer<T, E> failableConsumer, T t) {
            run(new k(failableConsumer, t));
        }

        public static <T, R, E extends Throwable> R apply(FailableFunction<T, R, E> failableFunction, T t) {
            return get(new s(failableFunction, t));
        }

        public static <T> Streams.FailableStream<T> stream(Stream<T> stream) {
            return new Streams.FailableStream<>(stream);
        }

        public static <T, E extends Throwable> boolean test(FailablePredicate<T, E> failablePredicate, T t) {
            return getAsBoolean(new d(failablePredicate, t));
        }

        public static <E extends Throwable> void accept(FailableDoubleConsumer<E> failableDoubleConsumer, double d) {
            run(new c(failableDoubleConsumer, d));
        }

        public static <E extends Throwable> void accept(FailableIntConsumer<E> failableIntConsumer, int i) {
            run(new p(failableIntConsumer, i));
        }

        public static <E extends Throwable> void accept(FailableLongConsumer<E> failableLongConsumer, long j) {
            run(new b(failableLongConsumer, j));
        }

        @SafeVarargs
        public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableRunnable<? extends Throwable>... failableRunnableArr) {
            tryWithResources(failableRunnable, (FailableConsumer<Throwable, ? extends Throwable>) null, failableRunnableArr);
        }
    }
