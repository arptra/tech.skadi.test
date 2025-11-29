package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.ConstraintsState;
import kotlin.Metadata;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"androidx/work/impl/constraints/controllers/ConstraintController$track$1$listener$1", "Landroidx/work/impl/constraints/ConstraintListener;", "newValue", "", "a", "(Ljava/lang/Object;)V", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class ConstraintController$track$1$listener$1 implements ConstraintListener<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConstraintController f2143a;
    public final /* synthetic */ ProducerScope b;

    public ConstraintController$track$1$listener$1(ConstraintController constraintController, ProducerScope producerScope) {
        this.f2143a = constraintController;
        this.b = producerScope;
    }

    public void a(Object obj) {
        this.b.b().q(this.f2143a.e(obj) ? new ConstraintsState.ConstraintsNotMet(this.f2143a.b()) : ConstraintsState.ConstraintsMet.f2135a);
    }
}
