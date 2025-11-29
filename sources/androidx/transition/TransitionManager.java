package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionManager {

    /* renamed from: a  reason: collision with root package name */
    public static Transition f1868a = new AutoTransition();
    public static ThreadLocal b = new ThreadLocal();
    public static ArrayList c = new ArrayList();

    public static class MultiListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public Transition f1869a;
        public ViewGroup b;

        public MultiListener(Transition transition, ViewGroup viewGroup) {
            this.f1869a = transition;
            this.b = viewGroup;
        }

        public final void a() {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.b.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            a();
            if (!TransitionManager.c.remove(this.b)) {
                return true;
            }
            final ArrayMap c = TransitionManager.c();
            ArrayList arrayList = (ArrayList) c.get(this.b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                c.put(this.b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f1869a);
            this.f1869a.addListener(new TransitionListenerAdapter() {
                public void onTransitionEnd(Transition transition) {
                    ((ArrayList) c.get(MultiListener.this.b)).remove(transition);
                    transition.removeListener(this);
                }
            });
            this.f1869a.captureValues(this.b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).resume(this.b);
                }
            }
            this.f1869a.playTransition(this.b);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            TransitionManager.c.remove(this.b);
            ArrayList arrayList = (ArrayList) TransitionManager.c().get(this.b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).resume(this.b);
                }
            }
            this.f1869a.clearValues(true);
        }
    }

    public static void a(ViewGroup viewGroup) {
        b(viewGroup, (Transition) null);
    }

    public static void b(ViewGroup viewGroup, Transition transition) {
        if (!c.contains(viewGroup) && ViewCompat.W(viewGroup)) {
            c.add(viewGroup);
            if (transition == null) {
                transition = f1868a;
            }
            Transition clone = transition.clone();
            e(viewGroup, clone);
            Scene.c(viewGroup, (Scene) null);
            d(viewGroup, clone);
        }
    }

    public static ArrayMap c() {
        ArrayMap arrayMap;
        WeakReference weakReference = (WeakReference) b.get();
        if (weakReference != null && (arrayMap = (ArrayMap) weakReference.get()) != null) {
            return arrayMap;
        }
        ArrayMap arrayMap2 = new ArrayMap();
        b.set(new WeakReference(arrayMap2));
        return arrayMap2;
    }

    public static void d(ViewGroup viewGroup, Transition transition) {
        if (transition != null && viewGroup != null) {
            MultiListener multiListener = new MultiListener(transition, viewGroup);
            viewGroup.addOnAttachStateChangeListener(multiListener);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
        }
    }

    public static void e(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = (ArrayList) c().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Transition) it.next()).pause(viewGroup);
            }
        }
        if (transition != null) {
            transition.captureValues(viewGroup, true);
        }
        Scene b2 = Scene.b(viewGroup);
        if (b2 != null) {
            b2.a();
        }
    }
}
