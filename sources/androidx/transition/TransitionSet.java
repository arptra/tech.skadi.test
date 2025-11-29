package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class TransitionSet extends Transition {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f1871a = new ArrayList();
    public boolean b = true;
    public int c;
    public boolean d = false;
    public int e = 0;

    public static class TransitionSetListener extends TransitionListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public TransitionSet f1873a;

        public TransitionSetListener(TransitionSet transitionSet) {
            this.f1873a = transitionSet;
        }

        public void onTransitionEnd(Transition transition) {
            TransitionSet transitionSet = this.f1873a;
            int i = transitionSet.c - 1;
            transitionSet.c = i;
            if (i == 0) {
                transitionSet.d = false;
                transitionSet.end();
            }
            transition.removeListener(this);
        }

        public void onTransitionStart(Transition transition) {
            TransitionSet transitionSet = this.f1873a;
            if (!transitionSet.d) {
                transitionSet.start();
                this.f1873a.d = true;
            }
        }
    }

    public int A() {
        return this.f1871a.size();
    }

    /* renamed from: B */
    public TransitionSet removeListener(Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.removeListener(transitionListener);
    }

    /* renamed from: C */
    public TransitionSet removeTarget(int i) {
        for (int i2 = 0; i2 < this.f1871a.size(); i2++) {
            ((Transition) this.f1871a.get(i2)).removeTarget(i);
        }
        return (TransitionSet) super.removeTarget(i);
    }

    /* renamed from: D */
    public TransitionSet removeTarget(View view) {
        for (int i = 0; i < this.f1871a.size(); i++) {
            ((Transition) this.f1871a.get(i)).removeTarget(view);
        }
        return (TransitionSet) super.removeTarget(view);
    }

    /* renamed from: E */
    public TransitionSet removeTarget(Class cls) {
        for (int i = 0; i < this.f1871a.size(); i++) {
            ((Transition) this.f1871a.get(i)).removeTarget((Class<?>) cls);
        }
        return (TransitionSet) super.removeTarget((Class<?>) cls);
    }

    /* renamed from: F */
    public TransitionSet removeTarget(String str) {
        for (int i = 0; i < this.f1871a.size(); i++) {
            ((Transition) this.f1871a.get(i)).removeTarget(str);
        }
        return (TransitionSet) super.removeTarget(str);
    }

    public TransitionSet G(Transition transition) {
        this.f1871a.remove(transition);
        transition.mParent = null;
        return this;
    }

    /* renamed from: H */
    public TransitionSet setDuration(long j) {
        ArrayList arrayList;
        super.setDuration(j);
        if (this.mDuration >= 0 && (arrayList = this.f1871a) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Transition) this.f1871a.get(i)).setDuration(j);
            }
        }
        return this;
    }

    /* renamed from: I */
    public TransitionSet setInterpolator(TimeInterpolator timeInterpolator) {
        this.e |= 1;
        ArrayList arrayList = this.f1871a;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Transition) this.f1871a.get(i)).setInterpolator(timeInterpolator);
            }
        }
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    public TransitionSet J(int i) {
        if (i == 0) {
            this.b = true;
        } else if (i == 1) {
            this.b = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
        return this;
    }

    /* renamed from: K */
    public TransitionSet setStartDelay(long j) {
        return (TransitionSet) super.setStartDelay(j);
    }

    public final void L() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        Iterator it = this.f1871a.iterator();
        while (it.hasNext()) {
            ((Transition) it.next()).addListener(transitionSetListener);
        }
        this.c = this.f1871a.size();
    }

    public void cancel() {
        super.cancel();
        int size = this.f1871a.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.f1871a.get(i)).cancel();
        }
    }

    public void captureEndValues(TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.b)) {
            Iterator it = this.f1871a.iterator();
            while (it.hasNext()) {
                Transition transition = (Transition) it.next();
                if (transition.isValidTarget(transitionValues.b)) {
                    transition.captureEndValues(transitionValues);
                    transitionValues.c.add(transition);
                }
            }
        }
    }

    public void capturePropagationValues(TransitionValues transitionValues) {
        super.capturePropagationValues(transitionValues);
        int size = this.f1871a.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.f1871a.get(i)).capturePropagationValues(transitionValues);
        }
    }

    public void captureStartValues(TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.b)) {
            Iterator it = this.f1871a.iterator();
            while (it.hasNext()) {
                Transition transition = (Transition) it.next();
                if (transition.isValidTarget(transitionValues.b)) {
                    transition.captureStartValues(transitionValues);
                    transitionValues.c.add(transition);
                }
            }
        }
    }

    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList arrayList, ArrayList arrayList2) {
        long startDelay = getStartDelay();
        int size = this.f1871a.size();
        for (int i = 0; i < size; i++) {
            Transition transition = (Transition) this.f1871a.get(i);
            if (startDelay > 0 && (this.b || i == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    public Transition excludeTarget(View view, boolean z) {
        for (int i = 0; i < this.f1871a.size(); i++) {
            ((Transition) this.f1871a.get(i)).excludeTarget(view, z);
        }
        return super.excludeTarget(view, z);
    }

    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.f1871a.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.f1871a.get(i)).forceToEnd(viewGroup);
        }
    }

    public void pause(View view) {
        super.pause(view);
        int size = this.f1871a.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.f1871a.get(i)).pause(view);
        }
    }

    public void resume(View view) {
        super.resume(view);
        int size = this.f1871a.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.f1871a.get(i)).resume(view);
        }
    }

    public void runAnimators() {
        if (this.f1871a.isEmpty()) {
            start();
            end();
            return;
        }
        L();
        if (!this.b) {
            for (int i = 1; i < this.f1871a.size(); i++) {
                final Transition transition = (Transition) this.f1871a.get(i);
                ((Transition) this.f1871a.get(i - 1)).addListener(new TransitionListenerAdapter() {
                    public void onTransitionEnd(Transition transition) {
                        transition.runAnimators();
                        transition.removeListener(this);
                    }
                });
            }
            Transition transition2 = (Transition) this.f1871a.get(0);
            if (transition2 != null) {
                transition2.runAnimators();
                return;
            }
            return;
        }
        Iterator it = this.f1871a.iterator();
        while (it.hasNext()) {
            ((Transition) it.next()).runAnimators();
        }
    }

    /* renamed from: s */
    public TransitionSet addListener(Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.addListener(transitionListener);
    }

    public void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.f1871a.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.f1871a.get(i)).setCanRemoveViews(z);
        }
    }

    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        this.e |= 8;
        int size = this.f1871a.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.f1871a.get(i)).setEpicenterCallback(epicenterCallback);
        }
    }

    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.e |= 4;
        if (this.f1871a != null) {
            for (int i = 0; i < this.f1871a.size(); i++) {
                ((Transition) this.f1871a.get(i)).setPathMotion(pathMotion);
            }
        }
    }

    public void setPropagation(TransitionPropagation transitionPropagation) {
        super.setPropagation(transitionPropagation);
        this.e |= 2;
        int size = this.f1871a.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.f1871a.get(i)).setPropagation(transitionPropagation);
        }
    }

    /* renamed from: t */
    public TransitionSet addTarget(int i) {
        for (int i2 = 0; i2 < this.f1871a.size(); i2++) {
            ((Transition) this.f1871a.get(i2)).addTarget(i);
        }
        return (TransitionSet) super.addTarget(i);
    }

    public String toString(String str) {
        String transition = super.toString(str);
        for (int i = 0; i < this.f1871a.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(transition);
            sb.append(StringUtils.LF);
            sb.append(((Transition) this.f1871a.get(i)).toString(str + FastRecordHistoryDetailActivity.TAG_SPLIT));
            transition = sb.toString();
        }
        return transition;
    }

    /* renamed from: u */
    public TransitionSet addTarget(View view) {
        for (int i = 0; i < this.f1871a.size(); i++) {
            ((Transition) this.f1871a.get(i)).addTarget(view);
        }
        return (TransitionSet) super.addTarget(view);
    }

    /* renamed from: v */
    public TransitionSet addTarget(Class cls) {
        for (int i = 0; i < this.f1871a.size(); i++) {
            ((Transition) this.f1871a.get(i)).addTarget((Class<?>) cls);
        }
        return (TransitionSet) super.addTarget((Class<?>) cls);
    }

    /* renamed from: w */
    public TransitionSet addTarget(String str) {
        for (int i = 0; i < this.f1871a.size(); i++) {
            ((Transition) this.f1871a.get(i)).addTarget(str);
        }
        return (TransitionSet) super.addTarget(str);
    }

    public TransitionSet x(Transition transition) {
        y(transition);
        long j = this.mDuration;
        if (j >= 0) {
            transition.setDuration(j);
        }
        if ((this.e & 1) != 0) {
            transition.setInterpolator(getInterpolator());
        }
        if ((this.e & 2) != 0) {
            transition.setPropagation(getPropagation());
        }
        if ((this.e & 4) != 0) {
            transition.setPathMotion(getPathMotion());
        }
        if ((this.e & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    public final void y(Transition transition) {
        this.f1871a.add(transition);
        transition.mParent = this;
    }

    public Transition z(int i) {
        if (i < 0 || i >= this.f1871a.size()) {
            return null;
        }
        return (Transition) this.f1871a.get(i);
    }

    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.f1871a = new ArrayList();
        int size = this.f1871a.size();
        for (int i = 0; i < size; i++) {
            transitionSet.y(((Transition) this.f1871a.get(i)).clone());
        }
        return transitionSet;
    }

    public Transition excludeTarget(String str, boolean z) {
        for (int i = 0; i < this.f1871a.size(); i++) {
            ((Transition) this.f1871a.get(i)).excludeTarget(str, z);
        }
        return super.excludeTarget(str, z);
    }

    public Transition excludeTarget(int i, boolean z) {
        for (int i2 = 0; i2 < this.f1871a.size(); i2++) {
            ((Transition) this.f1871a.get(i2)).excludeTarget(i, z);
        }
        return super.excludeTarget(i, z);
    }

    public Transition excludeTarget(Class cls, boolean z) {
        for (int i = 0; i < this.f1871a.size(); i++) {
            ((Transition) this.f1871a.get(i)).excludeTarget((Class<?>) cls, z);
        }
        return super.excludeTarget((Class<?>) cls, z);
    }
}
