package kotlinx.coroutines.reactive;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001eR\u0016\u0010!\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\u001e¨\u0006\""}, d2 = {"kotlinx/coroutines/reactive/AwaitKt$awaitOne$2$1", "Lorg/reactivestreams/Subscriber;", "Lorg/reactivestreams/Subscription;", "sub", "", "onSubscribe", "(Lorg/reactivestreams/Subscription;)V", "t", "onNext", "(Ljava/lang/Object;)V", "onComplete", "()V", "", "e", "onError", "(Ljava/lang/Throwable;)V", "", "signalName", "", "b", "(Ljava/lang/String;)Z", "Lkotlin/Function0;", "block", "c", "(Lkotlin/jvm/functions/Function0;)V", "a", "Lorg/reactivestreams/Subscription;", "subscription", "Ljava/lang/Object;", "value", "Z", "seenValue", "d", "inTerminalState", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 8, 0})
public final class AwaitKt$awaitOne$2$1 implements Subscriber<Object> {

    /* renamed from: a  reason: collision with root package name */
    public Subscription f3939a;
    public Object b;
    public boolean c;
    public boolean d;
    public final /* synthetic */ CancellableContinuation e;
    public final /* synthetic */ Mode f;
    public final /* synthetic */ Object g;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                kotlinx.coroutines.reactive.Mode[] r0 = kotlinx.coroutines.reactive.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.coroutines.reactive.Mode r1 = kotlinx.coroutines.reactive.Mode.FIRST     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.coroutines.reactive.Mode r1 = kotlinx.coroutines.reactive.Mode.FIRST_OR_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlinx.coroutines.reactive.Mode r1 = kotlinx.coroutines.reactive.Mode.LAST     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                kotlinx.coroutines.reactive.Mode r1 = kotlinx.coroutines.reactive.Mode.SINGLE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                kotlinx.coroutines.reactive.Mode r1 = kotlinx.coroutines.reactive.Mode.SINGLE_OR_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1.WhenMappings.<clinit>():void");
        }
    }

    public AwaitKt$awaitOne$2$1(CancellableContinuation cancellableContinuation, Mode mode, Object obj) {
        this.e = cancellableContinuation;
        this.f = mode;
        this.g = obj;
    }

    public final boolean b(String str) {
        if (this.d) {
            AwaitKt.g(this.e.getContext(), str);
            return false;
        }
        this.d = true;
        return true;
    }

    public final synchronized void c(Function0 function0) {
        function0.invoke();
    }

    public void onComplete() {
        if (b("onComplete")) {
            if (this.c) {
                Mode mode = this.f;
                if (mode != Mode.FIRST_OR_DEFAULT && mode != Mode.FIRST && this.e.isActive()) {
                    CancellableContinuation cancellableContinuation = this.e;
                    Result.Companion companion = Result.Companion;
                    cancellableContinuation.resumeWith(Result.m20constructorimpl(this.b));
                    return;
                }
                return;
            }
            Mode mode2 = this.f;
            if (mode2 == Mode.FIRST_OR_DEFAULT || mode2 == Mode.SINGLE_OR_DEFAULT) {
                CancellableContinuation cancellableContinuation2 = this.e;
                Result.Companion companion2 = Result.Companion;
                cancellableContinuation2.resumeWith(Result.m20constructorimpl(this.g));
            } else if (this.e.isActive()) {
                CancellableContinuation cancellableContinuation3 = this.e;
                Result.Companion companion3 = Result.Companion;
                cancellableContinuation3.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(new NoSuchElementException("No value received via onNext for " + this.f))));
            }
        }
    }

    public void onError(Throwable th) {
        if (b("onError")) {
            CancellableContinuation cancellableContinuation = this.e;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public void onNext(Object obj) {
        Subscription subscription = this.f3939a;
        CancellableContinuation cancellableContinuation = this.e;
        if (subscription == null) {
            CoroutineExceptionHandlerKt.a(cancellableContinuation.getContext(), new IllegalStateException("'onNext' was called before 'onSubscribe'"));
        } else if (this.d) {
            AwaitKt.g(cancellableContinuation.getContext(), "onNext");
        } else {
            int i = WhenMappings.$EnumSwitchMapping$0[this.f.ordinal()];
            if (i == 1 || i == 2) {
                if (this.c) {
                    AwaitKt.h(this.e.getContext(), this.f);
                    return;
                }
                this.c = true;
                c(new AwaitKt$awaitOne$2$1$onNext$1(subscription));
                this.e.resumeWith(Result.m20constructorimpl(obj));
            } else if (i == 3 || i == 4 || i == 5) {
                Mode mode = this.f;
                if ((mode == Mode.SINGLE || mode == Mode.SINGLE_OR_DEFAULT) && this.c) {
                    c(new AwaitKt$awaitOne$2$1$onNext$2(subscription));
                    if (this.e.isActive()) {
                        CancellableContinuation cancellableContinuation2 = this.e;
                        Result.Companion companion = Result.Companion;
                        cancellableContinuation2.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(new IllegalArgumentException("More than one onNext value for " + this.f))));
                        return;
                    }
                    return;
                }
                this.b = obj;
                this.c = true;
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (this.f3939a != null) {
            c(new AwaitKt$awaitOne$2$1$onSubscribe$1(subscription));
            return;
        }
        this.f3939a = subscription;
        this.e.E(new AwaitKt$awaitOne$2$1$onSubscribe$2(this, subscription));
        c(new AwaitKt$awaitOne$2$1$onSubscribe$3(subscription, this.f));
    }
}
