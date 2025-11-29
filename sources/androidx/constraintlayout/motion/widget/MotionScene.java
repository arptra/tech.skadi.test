package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
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
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import com.xjsd.ai.assistant.protocol.CmdCode;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class MotionScene {

    /* renamed from: a  reason: collision with root package name */
    public final MotionLayout f575a;
    public StateSet b = null;
    public Transition c = null;
    public boolean d = false;
    public ArrayList e = new ArrayList();
    public Transition f = null;
    public ArrayList g = new ArrayList();
    public SparseArray h = new SparseArray();
    public HashMap i = new HashMap();
    public SparseIntArray j = new SparseIntArray();
    public boolean k = false;
    public int l = CmdCode.CODE_WAKEUP_RECORDING;
    public int m = 0;
    public MotionEvent n;
    public boolean o = false;
    public boolean p = false;
    public MotionLayout.MotionTracker q;
    public boolean r;
    public final ViewTransitionController s;
    public float t;
    public float u;

    public MotionScene(Context context, MotionLayout motionLayout, int i2) {
        this.f575a = motionLayout;
        this.s = new ViewTransitionController(motionLayout);
        K(context, i2);
        this.h.put(R.id.motion_base, new ConstraintSet());
        this.i.put("motion_base", Integer.valueOf(R.id.motion_base));
    }

    public static String a0(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        return indexOf < 0 ? str : str.substring(indexOf + 1);
    }

    public float A() {
        Transition transition = this.c;
        if (transition == null || transition.l == null) {
            return 0.0f;
        }
        return this.c.l.l();
    }

    public float B() {
        Transition transition = this.c;
        if (transition == null || transition.l == null) {
            return 0.0f;
        }
        return this.c.l.m();
    }

    public float C() {
        Transition transition = this.c;
        if (transition == null || transition.l == null) {
            return 0.0f;
        }
        return this.c.l.n();
    }

    public float D() {
        Transition transition = this.c;
        if (transition == null || transition.l == null) {
            return 0.0f;
        }
        return this.c.l.o();
    }

    public float E() {
        Transition transition = this.c;
        if (transition != null) {
            return transition.i;
        }
        return 0.0f;
    }

    public int F() {
        Transition transition = this.c;
        if (transition == null) {
            return -1;
        }
        return transition.d;
    }

    public Transition G(int i2) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            Transition transition = (Transition) it.next();
            if (transition.f577a == i2) {
                return transition;
            }
        }
        return null;
    }

    public List H(int i2) {
        int y = y(i2);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            Transition transition = (Transition) it.next();
            if (transition.d == y || transition.c == y) {
                arrayList.add(transition);
            }
        }
        return arrayList;
    }

    public final boolean I(int i2) {
        int i3 = this.j.get(i2);
        int size = this.j.size();
        while (i3 > 0) {
            if (i3 == i2) {
                return true;
            }
            int i4 = size - 1;
            if (size < 0) {
                return true;
            }
            i3 = this.j.get(i3);
            size = i4;
        }
        return false;
    }

    public final boolean J() {
        return this.q != null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void K(android.content.Context r9, int r10) {
        /*
            r8 = this;
            android.content.res.Resources r0 = r9.getResources()
            android.content.res.XmlResourceParser r0 = r0.getXml(r10)
            int r1 = r0.getEventType()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r2 = 0
        L_0x000d:
            r3 = 1
            if (r1 == r3) goto L_0x0178
            if (r1 == 0) goto L_0x0168
            r4 = 2
            if (r1 == r4) goto L_0x0017
            goto L_0x016b
        L_0x0017:
            java.lang.String r1 = r0.getName()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            boolean r5 = r8.k     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r5 == 0) goto L_0x003c
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r7 = "parsing = "
            r6.append(r7)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r6.append(r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r6 = r6.toString()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r5.println(r6)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x003c
        L_0x0036:
            r8 = move-exception
            goto L_0x0171
        L_0x0039:
            r8 = move-exception
            goto L_0x0175
        L_0x003c:
            int r5 = r1.hashCode()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r6 = "MotionScene"
            r7 = -1
            switch(r5) {
                case -1349929691: goto L_0x00a1;
                case -1239391468: goto L_0x0096;
                case -687739768: goto L_0x008c;
                case 61998586: goto L_0x0081;
                case 269306229: goto L_0x0078;
                case 312750793: goto L_0x006e;
                case 327855227: goto L_0x0064;
                case 793277014: goto L_0x005c;
                case 1382829617: goto L_0x0052;
                case 1942574248: goto L_0x0048;
                default: goto L_0x0046;
            }
        L_0x0046:
            goto L_0x00ab
        L_0x0048:
            java.lang.String r3 = "include"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            r3 = 6
            goto L_0x00ac
        L_0x0052:
            java.lang.String r3 = "StateSet"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            r3 = 4
            goto L_0x00ac
        L_0x005c:
            boolean r1 = r1.equals(r6)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            r3 = 0
            goto L_0x00ac
        L_0x0064:
            java.lang.String r3 = "OnSwipe"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            r3 = r4
            goto L_0x00ac
        L_0x006e:
            java.lang.String r3 = "OnClick"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            r3 = 3
            goto L_0x00ac
        L_0x0078:
            java.lang.String r4 = "Transition"
            boolean r1 = r1.equals(r4)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            goto L_0x00ac
        L_0x0081:
            java.lang.String r3 = "ViewTransition"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            r3 = 9
            goto L_0x00ac
        L_0x008c:
            java.lang.String r3 = "Include"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            r3 = 7
            goto L_0x00ac
        L_0x0096:
            java.lang.String r3 = "KeyFrameSet"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            r3 = 8
            goto L_0x00ac
        L_0x00a1:
            java.lang.String r3 = "ConstraintSet"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            r3 = 5
            goto L_0x00ac
        L_0x00ab:
            r3 = r7
        L_0x00ac:
            switch(r3) {
                case 0: goto L_0x0164;
                case 1: goto L_0x0123;
                case 2: goto L_0x00e7;
                case 3: goto L_0x00e0;
                case 4: goto L_0x00d7;
                case 5: goto L_0x00d2;
                case 6: goto L_0x00cd;
                case 7: goto L_0x00cd;
                case 8: goto L_0x00bd;
                case 9: goto L_0x00b1;
                default: goto L_0x00af;
            }     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
        L_0x00af:
            goto L_0x016b
        L_0x00b1:
            androidx.constraintlayout.motion.widget.ViewTransition r1 = new androidx.constraintlayout.motion.widget.ViewTransition     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.ViewTransitionController r3 = r8.s     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r3.a(r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x016b
        L_0x00bd:
            androidx.constraintlayout.motion.widget.KeyFrames r1 = new androidx.constraintlayout.motion.widget.KeyFrames     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r2 == 0) goto L_0x016b
            java.util.ArrayList r3 = r2.k     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r3.add(r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x016b
        L_0x00cd:
            r8.N(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x016b
        L_0x00d2:
            r8.L(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x016b
        L_0x00d7:
            androidx.constraintlayout.widget.StateSet r1 = new androidx.constraintlayout.widget.StateSet     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r8.b = r1     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x016b
        L_0x00e0:
            if (r2 == 0) goto L_0x016b
            r2.u(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x016b
        L_0x00e7:
            if (r2 != 0) goto L_0x0116
            android.content.res.Resources r1 = r9.getResources()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r1 = r1.getResourceEntryName(r10)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            int r3 = r0.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r5 = " OnSwipe ("
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r4.append(r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r1 = ".xml:"
            r4.append(r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r4.append(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r1 = ")"
            r4.append(r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r1 = r4.toString()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            android.util.Log.v(r6, r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
        L_0x0116:
            if (r2 == 0) goto L_0x016b
            androidx.constraintlayout.motion.widget.TouchResponse r1 = new androidx.constraintlayout.motion.widget.TouchResponse     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r8.f575a     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.<init>(r9, r3, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.TouchResponse unused = r2.l = r1     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x016b
        L_0x0123:
            java.util.ArrayList r1 = r8.e     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.MotionScene$Transition r2 = new androidx.constraintlayout.motion.widget.MotionScene$Transition     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r2.<init>(r8, r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.add(r2)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = r8.c     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 != 0) goto L_0x014a
            boolean r1 = r2.b     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 != 0) goto L_0x014a
            r8.c = r2     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.TouchResponse r1 = r2.l     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x014a
            androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = r8.c     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.TouchResponse r1 = r1.l     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            boolean r3 = r8.r     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.x(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
        L_0x014a:
            boolean r1 = r2.b     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x016b
            int r1 = r2.c     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 != r7) goto L_0x0159
            r8.f = r2     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x015e
        L_0x0159:
            java.util.ArrayList r1 = r8.g     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.add(r2)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
        L_0x015e:
            java.util.ArrayList r1 = r8.e     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.remove(r2)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x016b
        L_0x0164:
            r8.O(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x016b
        L_0x0168:
            r0.getName()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
        L_0x016b:
            int r1 = r0.next()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x000d
        L_0x0171:
            r8.printStackTrace()
            goto L_0x0178
        L_0x0175:
            r8.printStackTrace()
        L_0x0178:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.K(android.content.Context, int):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int L(android.content.Context r17, org.xmlpull.v1.XmlPullParser r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r4 = 3
            r6 = 1
            androidx.constraintlayout.widget.ConstraintSet r7 = new androidx.constraintlayout.widget.ConstraintSet
            r7.<init>()
            r8 = 0
            r7.R(r8)
            int r9 = r18.getAttributeCount()
            r11 = r8
            r12 = -1
            r13 = -1
        L_0x0018:
            if (r11 >= r9) goto L_0x00ef
            java.lang.String r14 = r2.getAttributeName(r11)
            java.lang.String r15 = r2.getAttributeValue(r11)
            boolean r10 = r0.k
            if (r10 == 0) goto L_0x003c
            java.io.PrintStream r10 = java.lang.System.out
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "id string = "
            r3.append(r5)
            r3.append(r15)
            java.lang.String r3 = r3.toString()
            r10.println(r3)
        L_0x003c:
            r14.hashCode()
            int r3 = r14.hashCode()
            switch(r3) {
                case -1496482599: goto L_0x005e;
                case -1153153640: goto L_0x0053;
                case 3355: goto L_0x0048;
                default: goto L_0x0046;
            }
        L_0x0046:
            r3 = -1
            goto L_0x0068
        L_0x0048:
            java.lang.String r3 = "id"
            boolean r3 = r14.equals(r3)
            if (r3 != 0) goto L_0x0051
            goto L_0x0046
        L_0x0051:
            r3 = 2
            goto L_0x0068
        L_0x0053:
            java.lang.String r3 = "constraintRotate"
            boolean r3 = r14.equals(r3)
            if (r3 != 0) goto L_0x005c
            goto L_0x0046
        L_0x005c:
            r3 = r6
            goto L_0x0068
        L_0x005e:
            java.lang.String r3 = "deriveConstraintsFrom"
            boolean r3 = r14.equals(r3)
            if (r3 != 0) goto L_0x0067
            goto L_0x0046
        L_0x0067:
            r3 = r8
        L_0x0068:
            switch(r3) {
                case 0: goto L_0x00e6;
                case 1: goto L_0x0087;
                case 2: goto L_0x006c;
                default: goto L_0x006b;
            }
        L_0x006b:
            goto L_0x0083
        L_0x006c:
            int r12 = r0.r(r1, r15)
            java.util.HashMap r3 = r0.i
            java.lang.String r5 = a0(r15)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r12)
            r3.put(r5, r10)
            java.lang.String r3 = androidx.constraintlayout.motion.widget.Debug.c(r1, r12)
            r7.b = r3
        L_0x0083:
            r3 = 2
        L_0x0084:
            r5 = 4
            goto L_0x00ec
        L_0x0087:
            int r3 = java.lang.Integer.parseInt(r15)     // Catch:{ NumberFormatException -> 0x008e }
            r7.d = r3     // Catch:{ NumberFormatException -> 0x008e }
            goto L_0x0083
        L_0x008e:
            r15.hashCode()
            int r3 = r15.hashCode()
            switch(r3) {
                case -768416914: goto L_0x00c6;
                case 3317767: goto L_0x00bb;
                case 3387192: goto L_0x00b0;
                case 108511772: goto L_0x00a5;
                case 1954540437: goto L_0x009a;
                default: goto L_0x0098;
            }
        L_0x0098:
            r3 = -1
            goto L_0x00d0
        L_0x009a:
            java.lang.String r3 = "x_right"
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00a3
            goto L_0x0098
        L_0x00a3:
            r3 = 4
            goto L_0x00d0
        L_0x00a5:
            java.lang.String r3 = "right"
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00ae
            goto L_0x0098
        L_0x00ae:
            r3 = r4
            goto L_0x00d0
        L_0x00b0:
            java.lang.String r3 = "none"
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00b9
            goto L_0x0098
        L_0x00b9:
            r3 = 2
            goto L_0x00d0
        L_0x00bb:
            java.lang.String r3 = "left"
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00c4
            goto L_0x0098
        L_0x00c4:
            r3 = r6
            goto L_0x00d0
        L_0x00c6:
            java.lang.String r3 = "x_left"
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00cf
            goto L_0x0098
        L_0x00cf:
            r3 = r8
        L_0x00d0:
            switch(r3) {
                case 0: goto L_0x00e1;
                case 1: goto L_0x00dd;
                case 2: goto L_0x00da;
                case 3: goto L_0x00d7;
                case 4: goto L_0x00d4;
                default: goto L_0x00d3;
            }
        L_0x00d3:
            goto L_0x006b
        L_0x00d4:
            r7.d = r4
            goto L_0x0083
        L_0x00d7:
            r7.d = r6
            goto L_0x0083
        L_0x00da:
            r7.d = r8
            goto L_0x0083
        L_0x00dd:
            r3 = 2
            r7.d = r3
            goto L_0x0084
        L_0x00e1:
            r3 = 2
            r5 = 4
            r7.d = r5
            goto L_0x00ec
        L_0x00e6:
            r3 = 2
            r5 = 4
            int r13 = r0.r(r1, r15)
        L_0x00ec:
            int r11 = r11 + r6
            goto L_0x0018
        L_0x00ef:
            r10 = -1
            if (r12 == r10) goto L_0x010a
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.f575a
            int r3 = r3.x
            if (r3 == 0) goto L_0x00fb
            r7.S(r6)
        L_0x00fb:
            r7.E(r1, r2)
            if (r13 == r10) goto L_0x0105
            android.util.SparseIntArray r1 = r0.j
            r1.put(r12, r13)
        L_0x0105:
            android.util.SparseArray r0 = r0.h
            r0.put(r12, r7)
        L_0x010a:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.L(android.content.Context, org.xmlpull.v1.XmlPullParser):int");
    }

    public final int M(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    return L(context, xml);
                }
            }
            return -1;
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
            return -1;
        } catch (IOException e3) {
            e3.printStackTrace();
            return -1;
        }
    }

    public final void N(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.include);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.include_constraintSet) {
                M(context, obtainStyledAttributes.getResourceId(index, -1));
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final void O(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.MotionScene_defaultDuration) {
                int i3 = obtainStyledAttributes.getInt(index, this.l);
                this.l = i3;
                if (i3 < 8) {
                    this.l = 8;
                }
            } else if (index == R.styleable.MotionScene_layoutDuringTransition) {
                this.m = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public void P(float f2, float f3) {
        Transition transition = this.c;
        if (transition != null && transition.l != null) {
            this.c.l.u(f2, f3);
        }
    }

    public void Q(float f2, float f3) {
        Transition transition = this.c;
        if (transition != null && transition.l != null) {
            this.c.l.v(f2, f3);
        }
    }

    public void R(MotionEvent motionEvent, int i2, MotionLayout motionLayout) {
        MotionLayout.MotionTracker motionTracker;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.q == null) {
            this.q = this.f575a.Z();
        }
        this.q.b(motionEvent);
        if (i2 != -1) {
            int action = motionEvent.getAction();
            boolean z = false;
            if (action == 0) {
                this.t = motionEvent.getRawX();
                this.u = motionEvent.getRawY();
                this.n = motionEvent;
                this.o = false;
                if (this.c.l != null) {
                    RectF f2 = this.c.l.f(this.f575a, rectF);
                    if (f2 == null || f2.contains(this.n.getX(), this.n.getY())) {
                        RectF p2 = this.c.l.p(this.f575a, rectF);
                        if (p2 == null || p2.contains(this.n.getX(), this.n.getY())) {
                            this.p = false;
                        } else {
                            this.p = true;
                        }
                        this.c.l.w(this.t, this.u);
                        return;
                    }
                    this.n = null;
                    this.o = true;
                    return;
                }
                return;
            } else if (action == 2 && !this.o) {
                float rawY = motionEvent.getRawY() - this.u;
                float rawX = motionEvent.getRawX() - this.t;
                if ((((double) rawX) != 0.0d || ((double) rawY) != 0.0d) && (motionEvent2 = this.n) != null) {
                    Transition i3 = i(i2, rawX, rawY, motionEvent2);
                    if (i3 != null) {
                        motionLayout.setTransition(i3);
                        RectF p3 = this.c.l.p(this.f575a, rectF);
                        if (p3 != null && !p3.contains(this.n.getX(), this.n.getY())) {
                            z = true;
                        }
                        this.p = z;
                        this.c.l.z(this.t, this.u);
                    }
                } else {
                    return;
                }
            }
        }
        if (!this.o) {
            Transition transition = this.c;
            if (!(transition == null || transition.l == null || this.p)) {
                this.c.l.s(motionEvent, this.q, i2, this);
            }
            this.t = motionEvent.getRawX();
            this.u = motionEvent.getRawY();
            if (motionEvent.getAction() == 1 && (motionTracker = this.q) != null) {
                motionTracker.a();
                this.q = null;
                int i4 = motionLayout.f;
                if (i4 != -1) {
                    h(motionLayout, i4);
                }
            }
        }
    }

    public final void S(int i2, MotionLayout motionLayout) {
        ConstraintSet constraintSet = (ConstraintSet) this.h.get(i2);
        constraintSet.c = constraintSet.b;
        int i3 = this.j.get(i2);
        if (i3 > 0) {
            S(i3, motionLayout);
            ConstraintSet constraintSet2 = (ConstraintSet) this.h.get(i3);
            if (constraintSet2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.c(this.f575a.getContext(), i3));
                return;
            }
            constraintSet.c += "/" + constraintSet2.c;
            constraintSet.M(constraintSet2);
        } else {
            constraintSet.c += "  layout";
            constraintSet.L(motionLayout);
        }
        constraintSet.h(constraintSet);
    }

    public void T(MotionLayout motionLayout) {
        int i2 = 0;
        while (i2 < this.h.size()) {
            int keyAt = this.h.keyAt(i2);
            if (I(keyAt)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            } else {
                S(keyAt, motionLayout);
                i2++;
            }
        }
    }

    public void U(int i2, ConstraintSet constraintSet) {
        this.h.put(i2, constraintSet);
    }

    public void V(int i2) {
        Transition transition = this.c;
        if (transition != null) {
            transition.E(i2);
        } else {
            this.l = i2;
        }
    }

    public void W(boolean z) {
        this.r = z;
        Transition transition = this.c;
        if (transition != null && transition.l != null) {
            this.c.l.x(this.r);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r2 != -1) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void X(int r7, int r8) {
        /*
            r6 = this;
            androidx.constraintlayout.widget.StateSet r0 = r6.b
            r1 = -1
            if (r0 == 0) goto L_0x0018
            int r0 = r0.c(r7, r1, r1)
            if (r0 == r1) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r0 = r7
        L_0x000d:
            androidx.constraintlayout.widget.StateSet r2 = r6.b
            int r2 = r2.c(r8, r1, r1)
            if (r2 == r1) goto L_0x0016
            goto L_0x001a
        L_0x0016:
            r2 = r8
            goto L_0x001a
        L_0x0018:
            r0 = r7
            goto L_0x0016
        L_0x001a:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r6.c
            if (r3 == 0) goto L_0x002d
            int r3 = r3.c
            if (r3 != r8) goto L_0x002d
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r6.c
            int r3 = r3.d
            if (r3 != r7) goto L_0x002d
            return
        L_0x002d:
            java.util.ArrayList r3 = r6.e
            java.util.Iterator r3 = r3.iterator()
        L_0x0033:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x006d
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r4
            int r5 = r4.c
            if (r5 != r2) goto L_0x004b
            int r5 = r4.d
            if (r5 == r0) goto L_0x0057
        L_0x004b:
            int r5 = r4.c
            if (r5 != r8) goto L_0x0033
            int r5 = r4.d
            if (r5 != r7) goto L_0x0033
        L_0x0057:
            r6.c = r4
            if (r4 == 0) goto L_0x006c
            androidx.constraintlayout.motion.widget.TouchResponse r7 = r4.l
            if (r7 == 0) goto L_0x006c
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r6.c
            androidx.constraintlayout.motion.widget.TouchResponse r7 = r7.l
            boolean r6 = r6.r
            r7.x(r6)
        L_0x006c:
            return
        L_0x006d:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r6.f
            java.util.ArrayList r3 = r6.g
            java.util.Iterator r3 = r3.iterator()
        L_0x0075:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0089
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r4
            int r5 = r4.c
            if (r5 != r8) goto L_0x0075
            r7 = r4
            goto L_0x0075
        L_0x0089:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r8 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
            r8.<init>(r6, r7)
            int unused = r8.d = r0
            int unused = r8.c = r2
            if (r0 == r1) goto L_0x009b
            java.util.ArrayList r7 = r6.e
            r7.add(r8)
        L_0x009b:
            r6.c = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.X(int, int):void");
    }

    public void Y(Transition transition) {
        this.c = transition;
        if (transition != null && transition.l != null) {
            this.c.l.x(this.r);
        }
    }

    public void Z() {
        Transition transition = this.c;
        if (transition != null && transition.l != null) {
            this.c.l.A();
        }
    }

    public boolean b0() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            if (((Transition) it.next()).l != null) {
                return true;
            }
        }
        Transition transition = this.c;
        return (transition == null || transition.l == null) ? false : true;
    }

    public void c0(int i2, View... viewArr) {
        this.s.i(i2, viewArr);
    }

    public void f(MotionLayout motionLayout, int i2) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            Transition transition = (Transition) it.next();
            if (transition.m.size() > 0) {
                Iterator it2 = transition.m.iterator();
                while (it2.hasNext()) {
                    ((Transition.TransitionOnClick) it2.next()).c(motionLayout);
                }
            }
        }
        Iterator it3 = this.g.iterator();
        while (it3.hasNext()) {
            Transition transition2 = (Transition) it3.next();
            if (transition2.m.size() > 0) {
                Iterator it4 = transition2.m.iterator();
                while (it4.hasNext()) {
                    ((Transition.TransitionOnClick) it4.next()).c(motionLayout);
                }
            }
        }
        Iterator it5 = this.e.iterator();
        while (it5.hasNext()) {
            Transition transition3 = (Transition) it5.next();
            if (transition3.m.size() > 0) {
                Iterator it6 = transition3.m.iterator();
                while (it6.hasNext()) {
                    ((Transition.TransitionOnClick) it6.next()).a(motionLayout, i2, transition3);
                }
            }
        }
        Iterator it7 = this.g.iterator();
        while (it7.hasNext()) {
            Transition transition4 = (Transition) it7.next();
            if (transition4.m.size() > 0) {
                Iterator it8 = transition4.m.iterator();
                while (it8.hasNext()) {
                    ((Transition.TransitionOnClick) it8.next()).a(motionLayout, i2, transition4);
                }
            }
        }
    }

    public boolean g(int i2, MotionController motionController) {
        return this.s.d(i2, motionController);
    }

    public boolean h(MotionLayout motionLayout, int i2) {
        Transition transition;
        if (J() || this.d) {
            return false;
        }
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            Transition transition2 = (Transition) it.next();
            if (transition2.n != 0 && ((transition = this.c) != transition2 || !transition.D(2))) {
                if (i2 == transition2.d && (transition2.n == 4 || transition2.n == 2)) {
                    MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(transition2);
                    if (transition2.n == 4) {
                        motionLayout.i0();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.M(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.a0();
                    }
                    return true;
                } else if (i2 == transition2.c && (transition2.n == 3 || transition2.n == 1)) {
                    MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(transition2);
                    if (transition2.n == 3) {
                        motionLayout.k0();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.M(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.a0();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public Transition i(int i2, float f2, float f3, MotionEvent motionEvent) {
        RectF f4;
        int i3 = i2;
        float f5 = f2;
        float f6 = f3;
        if (i3 == -1) {
            return this.c;
        }
        List<Transition> H = H(i2);
        RectF rectF = new RectF();
        float f7 = 0.0f;
        Transition transition = null;
        for (Transition transition2 : H) {
            if (!transition2.o && transition2.l != null) {
                transition2.l.x(this.r);
                RectF p2 = transition2.l.p(this.f575a, rectF);
                if ((p2 == null || motionEvent == null || p2.contains(motionEvent.getX(), motionEvent.getY())) && ((f4 = transition2.l.f(this.f575a, rectF)) == null || motionEvent == null || f4.contains(motionEvent.getX(), motionEvent.getY()))) {
                    float a2 = transition2.l.a(f5, f6);
                    if (transition2.l.l && motionEvent != null) {
                        float x = motionEvent.getX() - transition2.l.i;
                        float y = motionEvent.getY() - transition2.l.j;
                        a2 = ((float) (Math.atan2((double) (f6 + y), (double) (f5 + x)) - Math.atan2((double) x, (double) y))) * 10.0f;
                    }
                    float f8 = a2 * (transition2.c == i3 ? -1.0f : 1.1f);
                    if (f8 > f7) {
                        transition = transition2;
                        f7 = f8;
                    }
                }
            }
        }
        return transition;
    }

    public int j() {
        Transition transition = this.c;
        if (transition != null) {
            return transition.p;
        }
        return -1;
    }

    public int k() {
        Transition transition = this.c;
        if (transition == null || transition.l == null) {
            return 0;
        }
        return this.c.l.d();
    }

    public ConstraintSet l(int i2) {
        return m(i2, -1, -1);
    }

    public ConstraintSet m(int i2, int i3, int i4) {
        int c2;
        if (this.k) {
            PrintStream printStream = System.out;
            printStream.println("id " + i2);
            printStream.println("size " + this.h.size());
        }
        StateSet stateSet = this.b;
        if (!(stateSet == null || (c2 = stateSet.c(i2, i3, i4)) == -1)) {
            i2 = c2;
        }
        if (this.h.get(i2) != null) {
            return (ConstraintSet) this.h.get(i2);
        }
        Log.e("MotionScene", "Warning could not find ConstraintSet id/" + Debug.c(this.f575a.getContext(), i2) + " In MotionScene");
        SparseArray sparseArray = this.h;
        return (ConstraintSet) sparseArray.get(sparseArray.keyAt(0));
    }

    public int[] n() {
        int size = this.h.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = this.h.keyAt(i2);
        }
        return iArr;
    }

    public ArrayList o() {
        return this.e;
    }

    public int p() {
        Transition transition = this.c;
        return transition != null ? transition.h : this.l;
    }

    public int q() {
        Transition transition = this.c;
        if (transition == null) {
            return -1;
        }
        return transition.c;
    }

    public final int r(Context context, String str) {
        int i2;
        if (str.contains("/")) {
            i2 = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.k) {
                System.out.println("id getMap res = " + i2);
            }
        } else {
            i2 = -1;
        }
        if (i2 != -1) {
            return i2;
        }
        if (str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e("MotionScene", "error in parsing id");
        return i2;
    }

    public Interpolator s() {
        int g2 = this.c.e;
        if (g2 == -2) {
            return AnimationUtils.loadInterpolator(this.f575a.getContext(), this.c.g);
        }
        if (g2 == -1) {
            final Easing c2 = Easing.c(this.c.f);
            return new Interpolator(this) {
                public float getInterpolation(float f) {
                    return (float) c2.a((double) f);
                }
            };
        } else if (g2 == 0) {
            return new AccelerateDecelerateInterpolator();
        } else {
            if (g2 == 1) {
                return new AccelerateInterpolator();
            }
            if (g2 == 2) {
                return new DecelerateInterpolator();
            }
            if (g2 == 4) {
                return new BounceInterpolator();
            }
            if (g2 == 5) {
                return new OvershootInterpolator();
            }
            if (g2 != 6) {
                return null;
            }
            return new AnticipateInterpolator();
        }
    }

    public void t(MotionController motionController) {
        Transition transition = this.c;
        if (transition == null) {
            Transition transition2 = this.f;
            if (transition2 != null) {
                Iterator it = transition2.k.iterator();
                while (it.hasNext()) {
                    ((KeyFrames) it.next()).b(motionController);
                }
                return;
            }
            return;
        }
        Iterator it2 = transition.k.iterator();
        while (it2.hasNext()) {
            ((KeyFrames) it2.next()).b(motionController);
        }
    }

    public float u() {
        Transition transition = this.c;
        if (transition == null || transition.l == null) {
            return 0.0f;
        }
        return this.c.l.g();
    }

    public float v() {
        Transition transition = this.c;
        if (transition == null || transition.l == null) {
            return 0.0f;
        }
        return this.c.l.h();
    }

    public boolean w() {
        Transition transition = this.c;
        if (transition == null || transition.l == null) {
            return false;
        }
        return this.c.l.i();
    }

    public float x(float f2, float f3) {
        Transition transition = this.c;
        if (transition == null || transition.l == null) {
            return 0.0f;
        }
        return this.c.l.j(f2, f3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r1.c(r2, -1, -1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int y(int r2) {
        /*
            r1 = this;
            androidx.constraintlayout.widget.StateSet r1 = r1.b
            if (r1 == 0) goto L_0x000c
            r0 = -1
            int r1 = r1.c(r2, r0, r0)
            if (r1 == r0) goto L_0x000c
            return r1
        L_0x000c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.y(int):int");
    }

    public int z() {
        Transition transition = this.c;
        if (transition == null || transition.l == null) {
            return 0;
        }
        return this.c.l.k();
    }

    public static class Transition {

        /* renamed from: a  reason: collision with root package name */
        public int f577a = -1;
        public boolean b = false;
        public int c = -1;
        public int d = -1;
        public int e = 0;
        public String f = null;
        public int g = -1;
        public int h = CmdCode.CODE_WAKEUP_RECORDING;
        public float i = 0.0f;
        public final MotionScene j;
        public ArrayList k = new ArrayList();
        public TouchResponse l = null;
        public ArrayList m = new ArrayList();
        public int n = 0;
        public boolean o = false;
        public int p = -1;
        public int q = 0;
        public int r = 0;

        public static class TransitionOnClick implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final Transition f578a;
            public int b = -1;
            public int c = 17;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.f578a = transition;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    if (index == R.styleable.OnClick_targetId) {
                        this.b = obtainStyledAttributes.getResourceId(index, this.b);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.c = obtainStyledAttributes.getInt(index, this.c);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            public void a(MotionLayout motionLayout, int i, Transition transition) {
                int i2 = this.b;
                View view = motionLayout;
                if (i2 != -1) {
                    view = motionLayout.findViewById(i2);
                }
                if (view == null) {
                    Log.e("MotionScene", "OnClick could not find id " + this.b);
                    return;
                }
                int c2 = transition.d;
                int a2 = transition.c;
                if (c2 == -1) {
                    view.setOnClickListener(this);
                    return;
                }
                int i3 = this.c;
                boolean z = false;
                boolean z2 = ((i3 & 1) != 0 && i == c2) | ((i3 & 1) != 0 && i == c2) | ((i3 & 256) != 0 && i == c2) | ((i3 & 16) != 0 && i == a2);
                if ((i3 & 4096) != 0 && i == a2) {
                    z = true;
                }
                if (z2 || z) {
                    view.setOnClickListener(this);
                }
            }

            public boolean b(Transition transition, MotionLayout motionLayout) {
                Transition transition2 = this.f578a;
                if (transition2 == transition) {
                    return true;
                }
                int a2 = transition2.c;
                int c2 = this.f578a.d;
                if (c2 == -1) {
                    return motionLayout.f != a2;
                }
                int i = motionLayout.f;
                return i == c2 || i == a2;
            }

            public void c(MotionLayout motionLayout) {
                int i = this.b;
                if (i != -1) {
                    View findViewById = motionLayout.findViewById(i);
                    if (findViewById == null) {
                        Log.e("MotionScene", " (*)  could not find id " + this.b);
                        return;
                    }
                    findViewById.setOnClickListener((View.OnClickListener) null);
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
            /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.view.View r8) {
                /*
                    r7 = this;
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r8 = r7.f578a
                    androidx.constraintlayout.motion.widget.MotionScene r8 = r8.j
                    androidx.constraintlayout.motion.widget.MotionLayout r8 = r8.f575a
                    boolean r0 = r8.Y()
                    if (r0 != 0) goto L_0x0011
                    return
                L_0x0011:
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.f578a
                    int r0 = r0.d
                    r1 = -1
                    if (r0 != r1) goto L_0x004a
                    int r0 = r8.getCurrentState()
                    if (r0 != r1) goto L_0x002a
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r7.f578a
                    int r7 = r7.c
                    r8.l0(r7)
                    return
                L_0x002a:
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r2 = r7.f578a
                    androidx.constraintlayout.motion.widget.MotionScene r2 = r2.j
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r7.f578a
                    r1.<init>(r2, r3)
                    int unused = r1.d = r0
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r7.f578a
                    int r7 = r7.c
                    int unused = r1.c = r7
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r1)
                    r8.i0()
                    return
                L_0x004a:
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.f578a
                    androidx.constraintlayout.motion.widget.MotionScene r0 = r0.j
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r0.c
                    int r1 = r7.c
                    r2 = r1 & 1
                    r3 = 0
                    r4 = 1
                    if (r2 != 0) goto L_0x0061
                    r2 = r1 & 256(0x100, float:3.59E-43)
                    if (r2 == 0) goto L_0x005f
                    goto L_0x0061
                L_0x005f:
                    r2 = r3
                    goto L_0x0062
                L_0x0061:
                    r2 = r4
                L_0x0062:
                    r5 = r1 & 16
                    if (r5 != 0) goto L_0x006d
                    r1 = r1 & 4096(0x1000, float:5.74E-42)
                    if (r1 == 0) goto L_0x006b
                    goto L_0x006d
                L_0x006b:
                    r1 = r3
                    goto L_0x006e
                L_0x006d:
                    r1 = r4
                L_0x006e:
                    if (r2 == 0) goto L_0x0097
                    if (r1 == 0) goto L_0x0097
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r5 = r7.f578a
                    androidx.constraintlayout.motion.widget.MotionScene r5 = r5.j
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r5 = r5.c
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r6 = r7.f578a
                    if (r5 == r6) goto L_0x0081
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r6)
                L_0x0081:
                    int r5 = r8.getCurrentState()
                    int r6 = r8.getEndState()
                    if (r5 == r6) goto L_0x0098
                    float r5 = r8.getProgress()
                    r6 = 1056964608(0x3f000000, float:0.5)
                    int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
                    if (r5 <= 0) goto L_0x0096
                    goto L_0x0098
                L_0x0096:
                    r1 = r3
                L_0x0097:
                    r3 = r2
                L_0x0098:
                    boolean r0 = r7.b(r0, r8)
                    if (r0 == 0) goto L_0x00e3
                    if (r3 == 0) goto L_0x00ae
                    int r0 = r7.c
                    r0 = r0 & r4
                    if (r0 == 0) goto L_0x00ae
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r7.f578a
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r7)
                    r8.i0()
                    goto L_0x00e3
                L_0x00ae:
                    if (r1 == 0) goto L_0x00bf
                    int r0 = r7.c
                    r0 = r0 & 16
                    if (r0 == 0) goto L_0x00bf
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r7.f578a
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r7)
                    r8.k0()
                    goto L_0x00e3
                L_0x00bf:
                    if (r3 == 0) goto L_0x00d2
                    int r0 = r7.c
                    r0 = r0 & 256(0x100, float:3.59E-43)
                    if (r0 == 0) goto L_0x00d2
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r7.f578a
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r7)
                    r7 = 1065353216(0x3f800000, float:1.0)
                    r8.setProgress(r7)
                    goto L_0x00e3
                L_0x00d2:
                    if (r1 == 0) goto L_0x00e3
                    int r0 = r7.c
                    r0 = r0 & 4096(0x1000, float:5.74E-42)
                    if (r0 == 0) goto L_0x00e3
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r7.f578a
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r7)
                    r7 = 0
                    r8.setProgress(r7)
                L_0x00e3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick.onClick(android.view.View):void");
            }
        }

        public Transition(MotionScene motionScene, Transition transition) {
            this.j = motionScene;
            this.h = motionScene.l;
            if (transition != null) {
                this.p = transition.p;
                this.e = transition.e;
                this.f = transition.f;
                this.g = transition.g;
                this.h = transition.h;
                this.k = transition.k;
                this.i = transition.i;
                this.q = transition.q;
            }
        }

        public int A() {
            return this.d;
        }

        public TouchResponse B() {
            return this.l;
        }

        public boolean C() {
            return !this.o;
        }

        public boolean D(int i2) {
            return (this.r & i2) != 0;
        }

        public void E(int i2) {
            this.h = Math.max(i2, 8);
        }

        public void F(boolean z) {
            this.o = !z;
        }

        public void G(int i2, String str, int i3) {
            this.e = i2;
            this.f = str;
            this.g = i3;
        }

        public void H(int i2) {
            TouchResponse B = B();
            if (B != null) {
                B.y(i2);
            }
        }

        public void I(int i2) {
            this.p = i2;
        }

        public void t(KeyFrames keyFrames) {
            this.k.add(keyFrames);
        }

        public void u(Context context, XmlPullParser xmlPullParser) {
            this.m.add(new TransitionOnClick(context, this, xmlPullParser));
        }

        public final void v(MotionScene motionScene, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                if (index == R.styleable.Transition_constraintSetEnd) {
                    this.c = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.c);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.D(context, this.c);
                        motionScene.h.append(this.c, constraintSet);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.c = motionScene.M(context, this.c);
                    }
                } else if (index == R.styleable.Transition_constraintSetStart) {
                    this.d = typedArray.getResourceId(index, this.d);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.d);
                    if ("layout".equals(resourceTypeName2)) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.D(context, this.d);
                        motionScene.h.append(this.d, constraintSet2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.d = motionScene.M(context, this.d);
                    }
                } else if (index == R.styleable.Transition_motionInterpolator) {
                    int i3 = typedArray.peekValue(index).type;
                    if (i3 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.g = resourceId;
                        if (resourceId != -1) {
                            this.e = -2;
                        }
                    } else if (i3 == 3) {
                        String string = typedArray.getString(index);
                        this.f = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.g = typedArray.getResourceId(index, -1);
                                this.e = -2;
                            } else {
                                this.e = -1;
                            }
                        }
                    } else {
                        this.e = typedArray.getInteger(index, this.e);
                    }
                } else if (index == R.styleable.Transition_duration) {
                    int i4 = typedArray.getInt(index, this.h);
                    this.h = i4;
                    if (i4 < 8) {
                        this.h = 8;
                    }
                } else if (index == R.styleable.Transition_staggered) {
                    this.i = typedArray.getFloat(index, this.i);
                } else if (index == R.styleable.Transition_autoTransition) {
                    this.n = typedArray.getInteger(index, this.n);
                } else if (index == R.styleable.Transition_android_id) {
                    this.f577a = typedArray.getResourceId(index, this.f577a);
                } else if (index == R.styleable.Transition_transitionDisable) {
                    this.o = typedArray.getBoolean(index, this.o);
                } else if (index == R.styleable.Transition_pathMotionArc) {
                    this.p = typedArray.getInteger(index, -1);
                } else if (index == R.styleable.Transition_layoutDuringTransition) {
                    this.q = typedArray.getInteger(index, 0);
                } else if (index == R.styleable.Transition_transitionFlags) {
                    this.r = typedArray.getInteger(index, 0);
                }
            }
            if (this.d == -1) {
                this.b = true;
            }
        }

        public final void w(MotionScene motionScene, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transition);
            v(motionScene, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public int x() {
            return this.n;
        }

        public int y() {
            return this.c;
        }

        public int z() {
            return this.q;
        }

        public Transition(int i2, MotionScene motionScene, int i3, int i4) {
            this.f577a = i2;
            this.j = motionScene;
            this.d = i3;
            this.c = i4;
            this.h = motionScene.l;
            this.q = motionScene.m;
        }

        public Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
            this.h = motionScene.l;
            this.q = motionScene.m;
            this.j = motionScene;
            w(motionScene, context, Xml.asAttributeSet(xmlPullParser));
        }
    }
}
