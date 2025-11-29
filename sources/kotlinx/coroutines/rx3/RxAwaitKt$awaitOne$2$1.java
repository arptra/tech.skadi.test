package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\b\u00028\u0000H\u0016ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018ø\u0001\u0000\u0002\u0004\n\u0002\b9¨\u0006\u001a"}, d2 = {"kotlinx/coroutines/rx3/RxAwaitKt$awaitOne$2$1", "Lio/reactivex/rxjava3/core/Observer;", "Lio/reactivex/rxjava3/disposables/Disposable;", "sub", "", "onSubscribe", "(Lio/reactivex/rxjava3/disposables/Disposable;)V", "t", "onNext", "(Ljava/lang/Object;)V", "onComplete", "()V", "", "e", "onError", "(Ljava/lang/Throwable;)V", "a", "Lio/reactivex/rxjava3/disposables/Disposable;", "subscription", "b", "Ljava/lang/Object;", "value", "", "c", "Z", "seenValue", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 8, 0})
public final class RxAwaitKt$awaitOne$2$1 implements Observer<Object> {

    /* renamed from: a  reason: collision with root package name */
    public Disposable f3952a;
    public Object b;
    public boolean c;
    public final /* synthetic */ CancellableContinuation d;
    public final /* synthetic */ Mode e;
    public final /* synthetic */ Object f;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                kotlinx.coroutines.rx3.Mode[] r0 = kotlinx.coroutines.rx3.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.coroutines.rx3.Mode r1 = kotlinx.coroutines.rx3.Mode.FIRST     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.coroutines.rx3.Mode r1 = kotlinx.coroutines.rx3.Mode.FIRST_OR_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlinx.coroutines.rx3.Mode r1 = kotlinx.coroutines.rx3.Mode.LAST     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                kotlinx.coroutines.rx3.Mode r1 = kotlinx.coroutines.rx3.Mode.SINGLE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.RxAwaitKt$awaitOne$2$1.WhenMappings.<clinit>():void");
        }
    }

    public RxAwaitKt$awaitOne$2$1(CancellableContinuation cancellableContinuation, Mode mode, Object obj) {
        this.d = cancellableContinuation;
        this.e = mode;
        this.f = obj;
    }

    public void onComplete() {
        if (this.c) {
            if (this.d.isActive()) {
                CancellableContinuation cancellableContinuation = this.d;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m20constructorimpl(this.b));
            }
        } else if (this.e == Mode.FIRST_OR_DEFAULT) {
            CancellableContinuation cancellableContinuation2 = this.d;
            Result.Companion companion2 = Result.Companion;
            cancellableContinuation2.resumeWith(Result.m20constructorimpl(this.f));
        } else if (this.d.isActive()) {
            CancellableContinuation cancellableContinuation3 = this.d;
            Result.Companion companion3 = Result.Companion;
            cancellableContinuation3.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(new NoSuchElementException("No value received via onNext for " + this.e))));
        }
    }

    public void onError(Throwable th) {
        CancellableContinuation cancellableContinuation = this.d;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(th)));
    }

    public void onNext(Object obj) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.e.ordinal()];
        Disposable disposable = null;
        if (i == 1 || i == 2) {
            if (!this.c) {
                this.c = true;
                this.d.resumeWith(Result.m20constructorimpl(obj));
                Disposable disposable2 = this.f3952a;
                if (disposable2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subscription");
                } else {
                    disposable = disposable2;
                }
                disposable.dispose();
            }
        } else if (i != 3 && i != 4) {
        } else {
            if (this.e != Mode.SINGLE || !this.c) {
                this.b = obj;
                this.c = true;
                return;
            }
            if (this.d.isActive()) {
                CancellableContinuation cancellableContinuation = this.d;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(new IllegalArgumentException("More than one onNext value for " + this.e))));
            }
            Disposable disposable3 = this.f3952a;
            if (disposable3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscription");
            } else {
                disposable = disposable3;
            }
            disposable.dispose();
        }
    }

    public void onSubscribe(Disposable disposable) {
        this.f3952a = disposable;
        this.d.E(new RxAwaitKt$awaitOne$2$1$onSubscribe$1(disposable));
    }
}
