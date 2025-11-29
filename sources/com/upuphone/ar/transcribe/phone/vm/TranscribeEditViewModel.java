package com.upuphone.ar.transcribe.phone.vm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010#\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\tJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u0003J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0003J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u0019R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b8\u0006¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b$\u0010\u001fR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00140\u001b8\u0006¢\u0006\f\n\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010\u001fR\"\u0010.\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010\u0012R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060/8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u00100R\u0016\u00103\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u00102¨\u00064"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/TranscribeEditViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "", "j", "", "id", "f", "(J)V", "", "g", "(Ljava/util/List;)V", "t", "s", "", "edit", "h", "(Z)V", "v", "", "c", "x", "(I)V", "q", "()I", "p", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "a", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "l", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "modeChangeFlow", "b", "m", "selectAllFlow", "k", "deleteFlow", "d", "n", "selectCountFlow", "e", "Z", "r", "()Z", "w", "isInEditMode", "", "Ljava/util/Set;", "selectedIds", "I", "totalCount", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranscribeEditViewModel extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final MutableSharedFlow f6155a = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
    public final MutableSharedFlow b = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
    public final MutableSharedFlow c = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
    public final MutableSharedFlow d = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
    public boolean e;
    public final Set f = new LinkedHashSet();
    public int g;

    public final void f(long j) {
        this.f.add(Long.valueOf(j));
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TranscribeEditViewModel$addSelect$1(this, (Continuation<? super TranscribeEditViewModel$addSelect$1>) null), 3, (Object) null);
    }

    public final void g(List list) {
        Intrinsics.checkNotNullParameter(list, "id");
        this.f.addAll(list);
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TranscribeEditViewModel$addSelect$2(this, (Continuation<? super TranscribeEditViewModel$addSelect$2>) null), 3, (Object) null);
    }

    public final void h(boolean z) {
        this.e = z;
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TranscribeEditViewModel$changeModel$1(this, z, (Continuation<? super TranscribeEditViewModel$changeModel$1>) null), 3, (Object) null);
    }

    public final void j() {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.b(), (CoroutineStart) null, new TranscribeEditViewModel$delete$1(this, (Continuation<? super TranscribeEditViewModel$delete$1>) null), 2, (Object) null);
    }

    public final MutableSharedFlow k() {
        return this.c;
    }

    public final MutableSharedFlow l() {
        return this.f6155a;
    }

    public final MutableSharedFlow m() {
        return this.b;
    }

    public final MutableSharedFlow n() {
        return this.d;
    }

    public final int p() {
        return this.f.size();
    }

    public final int q() {
        return this.g;
    }

    public final boolean r() {
        return this.e;
    }

    public final void s() {
        this.f.clear();
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TranscribeEditViewModel$removeAll$1(this, (Continuation<? super TranscribeEditViewModel$removeAll$1>) null), 3, (Object) null);
    }

    public final void t(long j) {
        this.f.remove(Long.valueOf(j));
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TranscribeEditViewModel$removeSelect$1(this, (Continuation<? super TranscribeEditViewModel$removeSelect$1>) null), 3, (Object) null);
    }

    public final void v() {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TranscribeEditViewModel$selectAll$1(this, (Continuation<? super TranscribeEditViewModel$selectAll$1>) null), 3, (Object) null);
    }

    public final void w(boolean z) {
        this.e = z;
    }

    public final void x(int i) {
        this.g = i;
    }
}
