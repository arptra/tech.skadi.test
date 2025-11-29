package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.widget.R;

public class MotionEffect extends MotionHelper {
    public float n = 0.1f;
    public int o = 49;
    public int p = 50;
    public int q = 0;
    public int r = 0;
    public boolean s = true;
    public int t = -1;
    public int u = -1;

    public MotionEffect(Context context) {
        super(context);
    }

    private void F(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionEffect);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.MotionEffect_motionEffect_start) {
                    int i2 = obtainStyledAttributes.getInt(index, this.o);
                    this.o = i2;
                    this.o = Math.max(Math.min(i2, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_end) {
                    int i3 = obtainStyledAttributes.getInt(index, this.p);
                    this.p = i3;
                    this.p = Math.max(Math.min(i3, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationX) {
                    this.q = obtainStyledAttributes.getDimensionPixelOffset(index, this.q);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationY) {
                    this.r = obtainStyledAttributes.getDimensionPixelOffset(index, this.r);
                } else if (index == R.styleable.MotionEffect_motionEffect_alpha) {
                    this.n = obtainStyledAttributes.getFloat(index, this.n);
                } else if (index == R.styleable.MotionEffect_motionEffect_move) {
                    this.u = obtainStyledAttributes.getInt(index, this.u);
                } else if (index == R.styleable.MotionEffect_motionEffect_strict) {
                    this.s = obtainStyledAttributes.getBoolean(index, this.s);
                } else if (index == R.styleable.MotionEffect_motionEffect_viewTransition) {
                    this.t = obtainStyledAttributes.getResourceId(index, this.t);
                }
            }
            int i4 = this.o;
            int i5 = this.p;
            if (i4 == i5) {
                if (i4 > 0) {
                    this.o = i4 - 1;
                } else {
                    this.p = i5 + 1;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0185, code lost:
        if (r14 == 0.0f) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0199, code lost:
        if (r14 == 0.0f) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01a9, code lost:
        if (r15 == 0.0f) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01b9, code lost:
        if (r15 == 0.0f) goto L_0x0161;
     */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void D(androidx.constraintlayout.motion.widget.MotionLayout r23, java.util.HashMap r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            android.view.ViewParent r2 = r22.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            android.view.View[] r2 = r0.n(r2)
            if (r2 != 0) goto L_0x002b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = androidx.constraintlayout.motion.widget.Debug.a()
            r0.append(r1)
            java.lang.String r1 = " views = null"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "FadeMove"
            android.util.Log.v(r1, r0)
            return
        L_0x002b:
            androidx.constraintlayout.motion.widget.KeyAttributes r3 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r3.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r4 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r4.<init>()
            float r5 = r0.n
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.String r6 = "alpha"
            r3.R(r6, r5)
            float r5 = r0.n
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r4.R(r6, r5)
            int r5 = r0.o
            r3.g(r5)
            int r5 = r0.p
            r4.g(r5)
            androidx.constraintlayout.motion.widget.KeyPosition r5 = new androidx.constraintlayout.motion.widget.KeyPosition
            r5.<init>()
            int r6 = r0.o
            r5.g(r6)
            r6 = 0
            r5.m(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r8 = "percentX"
            r5.n(r8, r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r9 = "percentY"
            r5.n(r9, r7)
            androidx.constraintlayout.motion.widget.KeyPosition r7 = new androidx.constraintlayout.motion.widget.KeyPosition
            r7.<init>()
            int r10 = r0.p
            r7.g(r10)
            r7.m(r6)
            r10 = 1
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            r7.n(r8, r11)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)
            r7.n(r9, r8)
            int r8 = r0.q
            r9 = 0
            if (r8 <= 0) goto L_0x00bc
            androidx.constraintlayout.motion.widget.KeyAttributes r8 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r8.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r11 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r11.<init>()
            int r12 = r0.q
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "translationX"
            r8.R(r13, r12)
            int r12 = r0.p
            r8.g(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            r11.R(r13, r12)
            int r12 = r0.p
            int r12 = r12 - r10
            r11.g(r12)
            goto L_0x00be
        L_0x00bc:
            r8 = r9
            r11 = r8
        L_0x00be:
            int r12 = r0.r
            if (r12 <= 0) goto L_0x00ea
            androidx.constraintlayout.motion.widget.KeyAttributes r9 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r9.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r12 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r12.<init>()
            int r13 = r0.r
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.String r14 = "translationY"
            r9.R(r14, r13)
            int r13 = r0.p
            r9.g(r13)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)
            r12.R(r14, r13)
            int r13 = r0.p
            int r13 = r13 - r10
            r12.g(r13)
            goto L_0x00eb
        L_0x00ea:
            r12 = r9
        L_0x00eb:
            int r13 = r0.u
            r14 = -1
            r17 = 0
            if (r13 != r14) goto L_0x0153
            r13 = 4
            int[] r14 = new int[r13]
            r13 = r6
        L_0x00f6:
            int r15 = r2.length
            if (r13 >= r15) goto L_0x0143
            r15 = r2[r13]
            java.lang.Object r15 = r1.get(r15)
            androidx.constraintlayout.motion.widget.MotionController r15 = (androidx.constraintlayout.motion.widget.MotionController) r15
            if (r15 != 0) goto L_0x0104
            goto L_0x0140
        L_0x0104:
            float r20 = r15.n()
            float r21 = r15.t()
            float r20 = r20 - r21
            float r21 = r15.o()
            float r15 = r15.u()
            float r21 = r21 - r15
            int r15 = (r21 > r17 ? 1 : (r21 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x0121
            r15 = r14[r10]
            int r15 = r15 + r10
            r14[r10] = r15
        L_0x0121:
            int r15 = (r21 > r17 ? 1 : (r21 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x012a
            r15 = r14[r6]
            int r15 = r15 + r10
            r14[r6] = r15
        L_0x012a:
            int r15 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x0135
            r15 = 3
            r19 = r14[r15]
            int r19 = r19 + 1
            r14[r15] = r19
        L_0x0135:
            int r15 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x0140
            r15 = 2
            r16 = r14[r15]
            int r16 = r16 + 1
            r14[r15] = r16
        L_0x0140:
            int r13 = r13 + 1
            goto L_0x00f6
        L_0x0143:
            r13 = r14[r6]
            r15 = r13
            r13 = r6
        L_0x0147:
            r6 = 4
            if (r10 >= r6) goto L_0x0153
            r6 = r14[r10]
            if (r15 >= r6) goto L_0x0150
            r15 = r6
            r13 = r10
        L_0x0150:
            int r10 = r10 + 1
            goto L_0x0147
        L_0x0153:
            r6 = 0
        L_0x0154:
            int r10 = r2.length
            if (r6 >= r10) goto L_0x01ef
            r10 = r2[r6]
            java.lang.Object r10 = r1.get(r10)
            androidx.constraintlayout.motion.widget.MotionController r10 = (androidx.constraintlayout.motion.widget.MotionController) r10
            if (r10 != 0) goto L_0x0166
        L_0x0161:
            r1 = r23
            r15 = -1
            goto L_0x01e9
        L_0x0166:
            float r14 = r10.n()
            float r15 = r10.t()
            float r14 = r14 - r15
            float r15 = r10.o()
            float r18 = r10.u()
            float r15 = r15 - r18
            if (r13 != 0) goto L_0x018c
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x0188
            boolean r15 = r0.s
            if (r15 == 0) goto L_0x018a
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0188
            goto L_0x018a
        L_0x0188:
            r1 = 3
            goto L_0x01bc
        L_0x018a:
            r1 = 3
            goto L_0x01bb
        L_0x018c:
            r1 = 1
            if (r13 != r1) goto L_0x019c
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x0188
            boolean r15 = r0.s
            if (r15 == 0) goto L_0x018a
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0188
            goto L_0x018a
        L_0x019c:
            r1 = 2
            if (r13 != r1) goto L_0x01ac
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 >= 0) goto L_0x0188
            boolean r14 = r0.s
            if (r14 == 0) goto L_0x018a
            int r14 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0188
            goto L_0x018a
        L_0x01ac:
            r1 = 3
            if (r13 != r1) goto L_0x01bc
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 <= 0) goto L_0x01bc
            boolean r14 = r0.s
            if (r14 == 0) goto L_0x0161
            int r14 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x01bc
        L_0x01bb:
            goto L_0x0161
        L_0x01bc:
            int r14 = r0.t
            r15 = -1
            if (r14 != r15) goto L_0x01e4
            r10.a(r3)
            r10.a(r4)
            r10.a(r5)
            r10.a(r7)
            int r14 = r0.q
            if (r14 <= 0) goto L_0x01d7
            r10.a(r8)
            r10.a(r11)
        L_0x01d7:
            int r14 = r0.r
            if (r14 <= 0) goto L_0x01e1
            r10.a(r9)
            r10.a(r12)
        L_0x01e1:
            r1 = r23
            goto L_0x01e9
        L_0x01e4:
            r1 = r23
            r1.F(r14, r10)
        L_0x01e9:
            int r6 = r6 + 1
            r1 = r24
            goto L_0x0154
        L_0x01ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.D(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }

    public boolean x() {
        return true;
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        F(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        F(context, attributeSet);
    }
}
