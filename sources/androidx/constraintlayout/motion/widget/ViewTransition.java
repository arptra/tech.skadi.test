package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import com.honey.account.k.a;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class ViewTransition {
    public static String w = "ViewTransition";

    /* renamed from: a  reason: collision with root package name */
    public int f580a;
    public int b = -1;
    public boolean c = false;
    public int d = 0;
    public int e;
    public KeyFrames f;
    public ConstraintSet.Constraint g;
    public int h = -1;
    public int i = -1;
    public int j;
    public String k;
    public int l = 0;
    public String m = null;
    public int n = -1;
    public Context o;
    public int p = -1;
    public int q = -1;
    public int r = -1;
    public int s = -1;
    public int t = -1;
    public int u = -1;
    public int v = -1;

    public static class Animate {

        /* renamed from: a  reason: collision with root package name */
        public final int f582a;
        public final int b;
        public long c;
        public MotionController d;
        public int e;
        public int f;
        public KeyCache g = new KeyCache();
        public ViewTransitionController h;
        public Interpolator i;
        public boolean j = false;
        public float k;
        public float l;
        public long m;
        public Rect n = new Rect();
        public boolean o = false;

        public Animate(ViewTransitionController viewTransitionController, MotionController motionController, int i2, int i3, int i4, Interpolator interpolator, int i5, int i6) {
            this.h = viewTransitionController;
            this.d = motionController;
            this.e = i2;
            this.f = i3;
            long nanoTime = System.nanoTime();
            this.c = nanoTime;
            this.m = nanoTime;
            this.h.b(this);
            this.i = interpolator;
            this.f582a = i5;
            this.b = i6;
            if (i4 == 3) {
                this.o = true;
            }
            this.l = i2 == 0 ? Float.MAX_VALUE : 1.0f / ((float) i2);
            a();
        }

        public void a() {
            if (this.j) {
                c();
            } else {
                b();
            }
        }

        public void b() {
            long nanoTime = System.nanoTime();
            this.m = nanoTime;
            float f2 = this.k + (((float) (((double) (nanoTime - this.m)) * 1.0E-6d)) * this.l);
            this.k = f2;
            if (f2 >= 1.0f) {
                this.k = 1.0f;
            }
            Interpolator interpolator = this.i;
            float interpolation = interpolator == null ? this.k : interpolator.getInterpolation(this.k);
            MotionController motionController = this.d;
            boolean x = motionController.x(motionController.b, interpolation, nanoTime, this.g);
            if (this.k >= 1.0f) {
                if (this.f582a != -1) {
                    this.d.v().setTag(this.f582a, Long.valueOf(System.nanoTime()));
                }
                if (this.b != -1) {
                    this.d.v().setTag(this.b, (Object) null);
                }
                if (!this.o) {
                    this.h.g(this);
                }
            }
            if (this.k < 1.0f || x) {
                this.h.e();
            }
        }

        public void c() {
            long nanoTime = System.nanoTime();
            this.m = nanoTime;
            float f2 = this.k - (((float) (((double) (nanoTime - this.m)) * 1.0E-6d)) * this.l);
            this.k = f2;
            if (f2 < 0.0f) {
                this.k = 0.0f;
            }
            Interpolator interpolator = this.i;
            float interpolation = interpolator == null ? this.k : interpolator.getInterpolation(this.k);
            MotionController motionController = this.d;
            boolean x = motionController.x(motionController.b, interpolation, nanoTime, this.g);
            if (this.k <= 0.0f) {
                if (this.f582a != -1) {
                    this.d.v().setTag(this.f582a, Long.valueOf(System.nanoTime()));
                }
                if (this.b != -1) {
                    this.d.v().setTag(this.b, (Object) null);
                }
                this.h.g(this);
            }
            if (this.k > 0.0f || x) {
                this.h.e();
            }
        }

        public void d(int i2, float f2, float f3) {
            if (i2 != 1) {
                if (i2 == 2) {
                    this.d.v().getHitRect(this.n);
                    if (!this.n.contains((int) f2, (int) f3) && !this.j) {
                        e(true);
                    }
                }
            } else if (!this.j) {
                e(true);
            }
        }

        public void e(boolean z) {
            int i2;
            this.j = z;
            if (z && (i2 = this.f) != -1) {
                this.l = i2 == 0 ? Float.MAX_VALUE : 1.0f / ((float) i2);
            }
            this.h.e();
            this.m = System.nanoTime();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ViewTransition(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            r9.<init>()
            r0 = -1
            r9.b = r0
            r1 = 0
            r9.c = r1
            r9.d = r1
            r9.h = r0
            r9.i = r0
            r9.l = r1
            r2 = 0
            r9.m = r2
            r9.n = r0
            r9.p = r0
            r9.q = r0
            r9.r = r0
            r9.s = r0
            r9.t = r0
            r9.u = r0
            r9.v = r0
            r9.o = r10
            int r2 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
        L_0x002a:
            r3 = 1
            if (r2 == r3) goto L_0x00ef
            java.lang.String r4 = "ViewTransition"
            r5 = 3
            r6 = 2
            if (r2 == r6) goto L_0x0048
            if (r2 == r5) goto L_0x0037
            goto L_0x00e2
        L_0x0037:
            java.lang.String r2 = r11.getName()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            boolean r2 = r4.equals(r2)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            if (r2 == 0) goto L_0x00e2
            return
        L_0x0042:
            r9 = move-exception
            goto L_0x00e8
        L_0x0045:
            r9 = move-exception
            goto L_0x00ec
        L_0x0048:
            java.lang.String r2 = r11.getName()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            int r7 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            r8 = 4
            switch(r7) {
                case -1962203927: goto L_0x007b;
                case -1239391468: goto L_0x0071;
                case 61998586: goto L_0x0069;
                case 366511058: goto L_0x005f;
                case 1791837707: goto L_0x0055;
                default: goto L_0x0054;
            }     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
        L_0x0054:
            goto L_0x0085
        L_0x0055:
            java.lang.String r4 = "CustomAttribute"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            if (r4 == 0) goto L_0x0085
            r4 = r5
            goto L_0x0086
        L_0x005f:
            java.lang.String r4 = "CustomMethod"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            if (r4 == 0) goto L_0x0085
            r4 = r8
            goto L_0x0086
        L_0x0069:
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            if (r4 == 0) goto L_0x0085
            r4 = r1
            goto L_0x0086
        L_0x0071:
            java.lang.String r4 = "KeyFrameSet"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            if (r4 == 0) goto L_0x0085
            r4 = r3
            goto L_0x0086
        L_0x007b:
            java.lang.String r4 = "ConstraintOverride"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            if (r4 == 0) goto L_0x0085
            r4 = r6
            goto L_0x0086
        L_0x0085:
            r4 = r0
        L_0x0086:
            if (r4 == 0) goto L_0x00df
            if (r4 == r3) goto L_0x00d7
            if (r4 == r6) goto L_0x00d0
            if (r4 == r5) goto L_0x00c8
            if (r4 == r8) goto L_0x00c8
            java.lang.String r3 = w     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            java.lang.String r5 = androidx.constraintlayout.motion.widget.Debug.a()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            java.lang.String r5 = " unknown tag "
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            java.lang.String r2 = r4.toString()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            android.util.Log.e(r3, r2)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            java.lang.String r2 = w     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            java.lang.String r4 = ".xml:"
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            int r4 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            java.lang.String r3 = r3.toString()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            android.util.Log.e(r2, r3)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            goto L_0x00e2
        L_0x00c8:
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = r9.g     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            java.util.HashMap r2 = r2.g     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            androidx.constraintlayout.widget.ConstraintAttribute.i(r10, r11, r2)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            goto L_0x00e2
        L_0x00d0:
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = androidx.constraintlayout.widget.ConstraintSet.m(r10, r11)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            r9.g = r2     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            goto L_0x00e2
        L_0x00d7:
            androidx.constraintlayout.motion.widget.KeyFrames r2 = new androidx.constraintlayout.motion.widget.KeyFrames     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            r2.<init>(r10, r11)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            r9.f = r2     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            goto L_0x00e2
        L_0x00df:
            r9.l(r10, r11)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
        L_0x00e2:
            int r2 = r11.next()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            goto L_0x002a
        L_0x00e8:
            r9.printStackTrace()
            goto L_0x00ef
        L_0x00ec:
            r9.printStackTrace()
        L_0x00ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.ViewTransition.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public void b(ViewTransitionController viewTransitionController, MotionLayout motionLayout, View view) {
        MotionController motionController = new MotionController(view);
        motionController.B(view);
        this.f.a(motionController);
        motionController.I(motionLayout.getWidth(), motionLayout.getHeight(), (float) this.h, System.nanoTime());
        ViewTransitionController viewTransitionController2 = viewTransitionController;
        MotionController motionController2 = motionController;
        new Animate(viewTransitionController2, motionController2, this.h, this.i, this.b, f(motionLayout.getContext()), this.p, this.q);
    }

    public void c(ViewTransitionController viewTransitionController, MotionLayout motionLayout, int i2, ConstraintSet constraintSet, View... viewArr) {
        if (!this.c) {
            int i3 = this.e;
            if (i3 == 2) {
                b(viewTransitionController, motionLayout, viewArr[0]);
                return;
            }
            if (i3 == 1) {
                int[] constraintSetIds = motionLayout.getConstraintSetIds();
                for (int i4 : constraintSetIds) {
                    if (i4 != i2) {
                        ConstraintSet S = motionLayout.S(i4);
                        for (View id : viewArr) {
                            ConstraintSet.Constraint w2 = S.w(id.getId());
                            ConstraintSet.Constraint constraint = this.g;
                            if (constraint != null) {
                                constraint.d(w2);
                                w2.g.putAll(this.g.g);
                            }
                        }
                    }
                }
            }
            ConstraintSet constraintSet2 = new ConstraintSet();
            constraintSet2.p(constraintSet);
            for (View id2 : viewArr) {
                ConstraintSet.Constraint w3 = constraintSet2.w(id2.getId());
                ConstraintSet.Constraint constraint2 = this.g;
                if (constraint2 != null) {
                    constraint2.d(w3);
                    w3.g.putAll(this.g.g);
                }
            }
            motionLayout.q0(i2, constraintSet2);
            motionLayout.q0(R.id.view_transition, constraintSet);
            motionLayout.setState(R.id.view_transition, -1, -1);
            MotionScene.Transition transition = new MotionScene.Transition(-1, motionLayout.f563a, R.id.view_transition, i2);
            for (View n2 : viewArr) {
                n(transition, n2);
            }
            motionLayout.setTransition(transition);
            motionLayout.j0(new a(this, viewArr));
        }
    }

    public boolean d(View view) {
        int i2 = this.r;
        boolean z = i2 == -1 || view.getTag(i2) != null;
        int i3 = this.s;
        return z && (i3 == -1 || view.getTag(i3) == null);
    }

    public int e() {
        return this.f580a;
    }

    public Interpolator f(Context context) {
        int i2 = this.l;
        if (i2 == -2) {
            return AnimationUtils.loadInterpolator(context, this.n);
        }
        if (i2 == -1) {
            final Easing c2 = Easing.c(this.m);
            return new Interpolator(this) {
                public float getInterpolation(float f) {
                    return (float) c2.a((double) f);
                }
            };
        } else if (i2 == 0) {
            return new AccelerateDecelerateInterpolator();
        } else {
            if (i2 == 1) {
                return new AccelerateInterpolator();
            }
            if (i2 == 2) {
                return new DecelerateInterpolator();
            }
            if (i2 == 4) {
                return new BounceInterpolator();
            }
            if (i2 == 5) {
                return new OvershootInterpolator();
            }
            if (i2 != 6) {
                return null;
            }
            return new AnticipateInterpolator();
        }
    }

    public int g() {
        return this.t;
    }

    public int h() {
        return this.u;
    }

    public int i() {
        return this.b;
    }

    public final /* synthetic */ void j(View[] viewArr) {
        if (this.p != -1) {
            for (View tag : viewArr) {
                tag.setTag(this.p, Long.valueOf(System.nanoTime()));
            }
        }
        if (this.q != -1) {
            for (View tag2 : viewArr) {
                tag2.setTag(this.q, (Object) null);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        r5 = ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r5.getLayoutParams()).c0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean k(android.view.View r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r4.j
            r2 = -1
            if (r1 != r2) goto L_0x000e
            java.lang.String r1 = r4.k
            if (r1 != 0) goto L_0x000e
            return r0
        L_0x000e:
            boolean r1 = r4.d(r5)
            if (r1 != 0) goto L_0x0015
            return r0
        L_0x0015:
            int r1 = r5.getId()
            int r2 = r4.j
            r3 = 1
            if (r1 != r2) goto L_0x001f
            return r3
        L_0x001f:
            java.lang.String r1 = r4.k
            if (r1 != 0) goto L_0x0024
            return r0
        L_0x0024:
            android.view.ViewGroup$LayoutParams r1 = r5.getLayoutParams()
            boolean r1 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r1 == 0) goto L_0x003f
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r5 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r5
            java.lang.String r5 = r5.c0
            if (r5 == 0) goto L_0x003f
            java.lang.String r4 = r4.k
            boolean r4 = r5.matches(r4)
            if (r4 == 0) goto L_0x003f
            return r3
        L_0x003f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.ViewTransition.k(android.view.View):boolean");
    }

    public final void l(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.ViewTransition);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.ViewTransition_android_id) {
                this.f580a = obtainStyledAttributes.getResourceId(index, this.f580a);
            } else if (index == R.styleable.ViewTransition_motionTarget) {
                if (MotionLayout.K0) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.j);
                    this.j = resourceId;
                    if (resourceId == -1) {
                        this.k = obtainStyledAttributes.getString(index);
                    }
                } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                    this.k = obtainStyledAttributes.getString(index);
                } else {
                    this.j = obtainStyledAttributes.getResourceId(index, this.j);
                }
            } else if (index == R.styleable.ViewTransition_onStateTransition) {
                this.b = obtainStyledAttributes.getInt(index, this.b);
            } else if (index == R.styleable.ViewTransition_transitionDisable) {
                this.c = obtainStyledAttributes.getBoolean(index, this.c);
            } else if (index == R.styleable.ViewTransition_pathMotionArc) {
                this.d = obtainStyledAttributes.getInt(index, this.d);
            } else if (index == R.styleable.ViewTransition_duration) {
                this.h = obtainStyledAttributes.getInt(index, this.h);
            } else if (index == R.styleable.ViewTransition_upDuration) {
                this.i = obtainStyledAttributes.getInt(index, this.i);
            } else if (index == R.styleable.ViewTransition_viewTransitionMode) {
                this.e = obtainStyledAttributes.getInt(index, this.e);
            } else if (index == R.styleable.ViewTransition_motionInterpolator) {
                int i3 = obtainStyledAttributes.peekValue(index).type;
                if (i3 == 1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                    this.n = resourceId2;
                    if (resourceId2 != -1) {
                        this.l = -2;
                    }
                } else if (i3 == 3) {
                    String string = obtainStyledAttributes.getString(index);
                    this.m = string;
                    if (string == null || string.indexOf("/") <= 0) {
                        this.l = -1;
                    } else {
                        this.n = obtainStyledAttributes.getResourceId(index, -1);
                        this.l = -2;
                    }
                } else {
                    this.l = obtainStyledAttributes.getInteger(index, this.l);
                }
            } else if (index == R.styleable.ViewTransition_setsTag) {
                this.p = obtainStyledAttributes.getResourceId(index, this.p);
            } else if (index == R.styleable.ViewTransition_clearsTag) {
                this.q = obtainStyledAttributes.getResourceId(index, this.q);
            } else if (index == R.styleable.ViewTransition_ifTagSet) {
                this.r = obtainStyledAttributes.getResourceId(index, this.r);
            } else if (index == R.styleable.ViewTransition_ifTagNotSet) {
                this.s = obtainStyledAttributes.getResourceId(index, this.s);
            } else if (index == R.styleable.ViewTransition_SharedValueId) {
                this.u = obtainStyledAttributes.getResourceId(index, this.u);
            } else if (index == R.styleable.ViewTransition_SharedValue) {
                this.t = obtainStyledAttributes.getInteger(index, this.t);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public boolean m(int i2) {
        int i3 = this.b;
        return i3 == 1 ? i2 == 0 : i3 == 2 ? i2 == 1 : i3 == 3 && i2 == 0;
    }

    public final void n(MotionScene.Transition transition, View view) {
        int i2 = this.h;
        if (i2 != -1) {
            transition.E(i2);
        }
        transition.I(this.d);
        transition.G(this.l, this.m, this.n);
        int id = view.getId();
        KeyFrames keyFrames = this.f;
        if (keyFrames != null) {
            ArrayList d2 = keyFrames.d(-1);
            KeyFrames keyFrames2 = new KeyFrames();
            Iterator it = d2.iterator();
            while (it.hasNext()) {
                keyFrames2.c(((Key) it.next()).clone().i(id));
            }
            transition.t(keyFrames2);
        }
    }

    public String toString() {
        return "ViewTransition(" + Debug.c(this.o, this.f580a) + ")";
    }
}
