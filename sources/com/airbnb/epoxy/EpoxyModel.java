package com.airbnb.epoxy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.airbnb.epoxy.EpoxyController;
import java.util.List;

public abstract class EpoxyModel<T> {
    public static long k = -1;

    /* renamed from: a  reason: collision with root package name */
    public long f2287a;
    public int b;
    public boolean c;
    public boolean d;
    public EpoxyController e;
    public EpoxyController f;
    public boolean g;
    public int h;
    public boolean i;
    public SpanSizeOverrideCallback j;

    public interface AddPredicate {
    }

    public interface SpanSizeOverrideCallback {
        int a(int i, int i2, int i3);
    }

    public EpoxyModel(long j2) {
        this.c = true;
        E(j2);
    }

    public static int z(EpoxyController epoxyController, EpoxyModel epoxyModel) {
        return epoxyController.isBuildingModels() ? epoxyController.getFirstIndexOfModelInBuildingList(epoxyModel) : epoxyController.getAdapter().I(epoxyModel);
    }

    public int A(int i2, int i3, int i4) {
        return 1;
    }

    public int B() {
        return y();
    }

    public boolean C() {
        return this.i;
    }

    public long D() {
        return this.f2287a;
    }

    public EpoxyModel E(long j2) {
        if ((this.d || this.e != null) && j2 != this.f2287a) {
            throw new IllegalEpoxyUsage("Cannot change a model's id after it has been added to the adapter.");
        }
        this.i = false;
        this.f2287a = j2;
        return this;
    }

    public EpoxyModel F(CharSequence charSequence) {
        E(IdUtils.a(charSequence));
        return this;
    }

    public boolean G() {
        return this.e != null;
    }

    public boolean H() {
        return this.c;
    }

    public boolean I(Object obj) {
        return false;
    }

    public final void J() {
        if (!G() || this.g) {
            EpoxyController epoxyController = this.f;
            if (epoxyController != null) {
                epoxyController.setStagedModel(this);
                return;
            }
            return;
        }
        throw new ImmutableModelException(this, z(this.e, this));
    }

    public void K(Object obj) {
    }

    public void L(Object obj) {
    }

    public void M(float f2, float f3, int i2, int i3, Object obj) {
    }

    public void N(int i2, Object obj) {
    }

    public void O(Object obj, EpoxyModel epoxyModel) {
    }

    public boolean P() {
        return false;
    }

    public final int Q(int i2, int i3, int i4) {
        SpanSizeOverrideCallback spanSizeOverrideCallback = this.j;
        return spanSizeOverrideCallback != null ? spanSizeOverrideCallback.a(i2, i3, i4) : A(i2, i3, i4);
    }

    public void R(Object obj) {
    }

    public final void S(String str, int i2) {
        if (G() && !this.g && this.h != hashCode()) {
            throw new ImmutableModelException(this, str, i2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EpoxyModel)) {
            return false;
        }
        EpoxyModel epoxyModel = (EpoxyModel) obj;
        if (this.f2287a == epoxyModel.f2287a && B() == epoxyModel.B()) {
            return this.c == epoxyModel.c;
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f2287a;
        return (((((int) (j2 ^ (j2 >>> 32))) * 31) + B()) * 31) + (this.c ? 1 : 0);
    }

    public void r(EpoxyController epoxyController) {
        epoxyController.addInternal(this);
    }

    public final void s(EpoxyController epoxyController) {
        if (epoxyController == null) {
            throw new IllegalArgumentException("Controller cannot be null");
        } else if (epoxyController.isModelAddedMultipleTimes(this)) {
            throw new IllegalEpoxyUsage("This model was already added to the controller at position " + epoxyController.getFirstIndexOfModelInBuildingList(this));
        } else if (this.e == null) {
            this.e = epoxyController;
            this.h = hashCode();
            epoxyController.addAfterInterceptorCallback(new EpoxyController.ModelInterceptorCallback() {
                public void a(EpoxyController epoxyController) {
                    EpoxyModel epoxyModel = EpoxyModel.this;
                    int unused = epoxyModel.h = epoxyModel.hashCode();
                    boolean unused2 = EpoxyModel.this.g = false;
                }

                public void b(EpoxyController epoxyController) {
                    boolean unused = EpoxyModel.this.g = true;
                }
            });
        }
    }

    public void t(Object obj) {
    }

    public String toString() {
        return getClass().getSimpleName() + "{id=" + this.f2287a + ", viewType=" + B() + ", shown=" + this.c + ", addedToAdapter=" + this.d + '}';
    }

    public void u(Object obj, EpoxyModel epoxyModel) {
        t(obj);
    }

    public void v(Object obj, List list) {
        t(obj);
    }

    public View w(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(y(), viewGroup, false);
    }

    public abstract int x();

    public final int y() {
        int i2 = this.b;
        return i2 == 0 ? x() : i2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public EpoxyModel() {
        /*
            r4 = this;
            long r0 = k
            r2 = 1
            long r2 = r0 - r2
            k = r2
            r4.<init>(r0)
            r0 = 1
            r4.i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.epoxy.EpoxyModel.<init>():void");
    }
}
