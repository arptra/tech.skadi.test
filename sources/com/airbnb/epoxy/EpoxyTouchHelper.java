package com.airbnb.epoxy;

import android.graphics.Canvas;
import android.view.View;
import java.util.List;

public abstract class EpoxyTouchHelper {

    public static class DragBuilder {
    }

    public static class DragBuilder2 {
    }

    public static class DragBuilder3 {
    }

    public static class DragBuilder4<U extends EpoxyModel> {

        /* renamed from: a  reason: collision with root package name */
        public final int f2298a;
        public final List b;

        /* renamed from: com.airbnb.epoxy.EpoxyTouchHelper$DragBuilder4$1  reason: invalid class name */
        class AnonymousClass1 extends EpoxyModelTouchCallback<EpoxyModel> {
            public final /* synthetic */ DragCallbacks e;
            public final /* synthetic */ DragBuilder4 f;

            public int a(EpoxyModel epoxyModel, int i) {
                return this.f.f2298a;
            }

            public void q(EpoxyModel epoxyModel, View view) {
                this.e.b(epoxyModel, view);
            }

            public boolean r(EpoxyModel epoxyModel) {
                return (this.f.b.size() == 1 ? super.r(epoxyModel) : this.f.b.contains(epoxyModel.getClass())) && this.e.c(epoxyModel);
            }

            public void t(EpoxyModel epoxyModel, View view) {
                this.e.d(epoxyModel, view);
            }

            public void u(EpoxyModel epoxyModel, View view, int i) {
                this.e.e(epoxyModel, view, i);
            }

            public void v(int i, int i2, EpoxyModel epoxyModel, View view) {
                this.e.f(i, i2, epoxyModel, view);
            }
        }
    }

    public static abstract class DragCallbacks<T extends EpoxyModel> implements EpoxyDragCallback<T> {
        public void b(EpoxyModel epoxyModel, View view) {
        }

        public boolean c(EpoxyModel epoxyModel) {
            return true;
        }

        public void d(EpoxyModel epoxyModel, View view) {
        }

        public void e(EpoxyModel epoxyModel, View view, int i) {
        }

        public abstract void f(int i, int i2, EpoxyModel epoxyModel, View view);
    }

    public static class SwipeBuilder {
    }

    public static class SwipeBuilder2 {
    }

    public static class SwipeBuilder3<U extends EpoxyModel> {

        /* renamed from: a  reason: collision with root package name */
        public final int f2299a;
        public final List b;

        /* renamed from: com.airbnb.epoxy.EpoxyTouchHelper$SwipeBuilder3$1  reason: invalid class name */
        class AnonymousClass1 extends EpoxyModelTouchCallback<EpoxyModel> {
            public final /* synthetic */ SwipeCallbacks e;
            public final /* synthetic */ SwipeBuilder3 f;

            public int a(EpoxyModel epoxyModel, int i) {
                return this.f.f2299a;
            }

            public void q(EpoxyModel epoxyModel, View view) {
                this.e.b(epoxyModel, view);
            }

            public boolean r(EpoxyModel epoxyModel) {
                return (this.f.b.size() == 1 ? super.r(epoxyModel) : this.f.b.contains(epoxyModel.getClass())) && this.e.c(epoxyModel);
            }

            public void w(EpoxyModel epoxyModel, View view, int i, int i2) {
                this.e.d(epoxyModel, view, i, i2);
            }

            public void x(EpoxyModel epoxyModel, View view, float f2, Canvas canvas) {
                this.e.e(epoxyModel, view, f2, canvas);
            }

            public void y(EpoxyModel epoxyModel, View view) {
                this.e.f(epoxyModel, view);
            }

            public void z(EpoxyModel epoxyModel, View view, int i) {
                this.e.g(epoxyModel, view, i);
            }
        }
    }

    public static abstract class SwipeCallbacks<T extends EpoxyModel> implements EpoxySwipeCallback<T> {
        public void b(EpoxyModel epoxyModel, View view) {
        }

        public boolean c(EpoxyModel epoxyModel) {
            return true;
        }

        public abstract void d(EpoxyModel epoxyModel, View view, int i, int i2);

        public void e(EpoxyModel epoxyModel, View view, float f, Canvas canvas) {
        }

        public void f(EpoxyModel epoxyModel, View view) {
        }

        public void g(EpoxyModel epoxyModel, View view, int i) {
        }
    }
}
