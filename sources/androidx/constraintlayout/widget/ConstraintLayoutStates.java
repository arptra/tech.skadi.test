package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class ConstraintLayoutStates {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f606a;
    public ConstraintSet b;
    public int c = -1;
    public int d = -1;
    public SparseArray e = new SparseArray();
    public SparseArray f = new SparseArray();
    public ConstraintsChangedListener g = null;

    public static class State {

        /* renamed from: a  reason: collision with root package name */
        public int f607a;
        public ArrayList b = new ArrayList();
        public int c = -1;
        public ConstraintSet d;

        public State(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.State_android_id) {
                    this.f607a = obtainStyledAttributes.getResourceId(index, this.f607a);
                } else if (index == R.styleable.State_constraints) {
                    this.c = obtainStyledAttributes.getResourceId(index, this.c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.c);
                    context.getResources().getResourceName(this.c);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.d = constraintSet;
                        constraintSet.n(context, this.c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void a(Variant variant) {
            this.b.add(variant);
        }

        public int b(float f, float f2) {
            for (int i = 0; i < this.b.size(); i++) {
                if (((Variant) this.b.get(i)).a(f, f2)) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static class Variant {

        /* renamed from: a  reason: collision with root package name */
        public float f608a = Float.NaN;
        public float b = Float.NaN;
        public float c = Float.NaN;
        public float d = Float.NaN;
        public int e = -1;
        public ConstraintSet f;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Variant_constraints) {
                    this.e = obtainStyledAttributes.getResourceId(index, this.e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f = constraintSet;
                        constraintSet.n(context, this.e);
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.d = obtainStyledAttributes.getDimension(index, this.d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.b = obtainStyledAttributes.getDimension(index, this.b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.c = obtainStyledAttributes.getDimension(index, this.c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f608a = obtainStyledAttributes.getDimension(index, this.f608a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        public boolean a(float f2, float f3) {
            if (!Float.isNaN(this.f608a) && f2 < this.f608a) {
                return false;
            }
            if (!Float.isNaN(this.b) && f3 < this.b) {
                return false;
            }
            if (Float.isNaN(this.c) || f2 <= this.c) {
                return Float.isNaN(this.d) || f3 <= this.d;
            }
            return false;
        }
    }

    public ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int i) {
        this.f606a = constraintLayout;
        a(context, i);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r8, int r9) {
        /*
            r7 = this;
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.XmlResourceParser r9 = r0.getXml(r9)
            int r0 = r9.getEventType()     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            r1 = 0
        L_0x000d:
            r2 = 1
            if (r0 == r2) goto L_0x008d
            if (r0 == 0) goto L_0x007e
            r3 = 2
            if (r0 == r3) goto L_0x0017
            goto L_0x0081
        L_0x0017:
            java.lang.String r0 = r9.getName()     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            int r4 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            r5 = 4
            r6 = 3
            switch(r4) {
                case -1349929691: goto L_0x0050;
                case 80204913: goto L_0x0046;
                case 1382829617: goto L_0x003d;
                case 1657696882: goto L_0x0033;
                case 1901439077: goto L_0x0025;
                default: goto L_0x0024;
            }     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
        L_0x0024:
            goto L_0x005a
        L_0x0025:
            java.lang.String r2 = "Variant"
            boolean r0 = r0.equals(r2)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            if (r0 == 0) goto L_0x005a
            r2 = r6
            goto L_0x005b
        L_0x002f:
            r7 = move-exception
            goto L_0x0086
        L_0x0031:
            r7 = move-exception
            goto L_0x008a
        L_0x0033:
            java.lang.String r2 = "layoutDescription"
            boolean r0 = r0.equals(r2)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            if (r0 == 0) goto L_0x005a
            r2 = 0
            goto L_0x005b
        L_0x003d:
            java.lang.String r4 = "StateSet"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            if (r0 == 0) goto L_0x005a
            goto L_0x005b
        L_0x0046:
            java.lang.String r2 = "State"
            boolean r0 = r0.equals(r2)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            if (r0 == 0) goto L_0x005a
            r2 = r3
            goto L_0x005b
        L_0x0050:
            java.lang.String r2 = "ConstraintSet"
            boolean r0 = r0.equals(r2)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            if (r0 == 0) goto L_0x005a
            r2 = r5
            goto L_0x005b
        L_0x005a:
            r2 = -1
        L_0x005b:
            if (r2 == r3) goto L_0x0071
            if (r2 == r6) goto L_0x0066
            if (r2 == r5) goto L_0x0062
            goto L_0x0081
        L_0x0062:
            r7.b(r8, r9)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            goto L_0x0081
        L_0x0066:
            androidx.constraintlayout.widget.ConstraintLayoutStates$Variant r0 = new androidx.constraintlayout.widget.ConstraintLayoutStates$Variant     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            r0.<init>(r8, r9)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            if (r1 == 0) goto L_0x0081
            r1.a(r0)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            goto L_0x0081
        L_0x0071:
            androidx.constraintlayout.widget.ConstraintLayoutStates$State r1 = new androidx.constraintlayout.widget.ConstraintLayoutStates$State     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            r1.<init>(r8, r9)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            android.util.SparseArray r0 = r7.e     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            int r2 = r1.f607a     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            r0.put(r2, r1)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            goto L_0x0081
        L_0x007e:
            r9.getName()     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
        L_0x0081:
            int r0 = r9.next()     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            goto L_0x000d
        L_0x0086:
            r7.printStackTrace()
            goto L_0x008d
        L_0x008a:
            r7.printStackTrace()
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayoutStates.a(android.content.Context, int):void");
    }

    public final void b(Context context, XmlPullParser xmlPullParser) {
        int i;
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlPullParser.getAttributeCount();
        int i2 = 0;
        while (i2 < attributeCount) {
            String attributeName = xmlPullParser.getAttributeName(i2);
            String attributeValue = xmlPullParser.getAttributeValue(i2);
            if (attributeName == null || attributeValue == null || !"id".equals(attributeName)) {
                i2++;
            } else {
                if (attributeValue.contains("/")) {
                    i = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i = -1;
                }
                if (i == -1) {
                    if (attributeValue.length() > 1) {
                        i = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                constraintSet.E(context, xmlPullParser);
                this.f.put(i, constraintSet);
                return;
            }
        }
    }

    public void c(ConstraintsChangedListener constraintsChangedListener) {
        this.g = constraintsChangedListener;
    }

    public void d(int i, float f2, float f3) {
        int b2;
        int i2 = this.c;
        if (i2 == i) {
            State state = i == -1 ? (State) this.e.valueAt(0) : (State) this.e.get(i2);
            int i3 = this.d;
            if ((i3 == -1 || !((Variant) state.b.get(i3)).a(f2, f3)) && this.d != (b2 = state.b(f2, f3))) {
                ConstraintSet constraintSet = b2 == -1 ? this.b : ((Variant) state.b.get(b2)).f;
                int i4 = b2 == -1 ? state.c : ((Variant) state.b.get(b2)).e;
                if (constraintSet != null) {
                    this.d = b2;
                    ConstraintsChangedListener constraintsChangedListener = this.g;
                    if (constraintsChangedListener != null) {
                        constraintsChangedListener.b(-1, i4);
                    }
                    constraintSet.i(this.f606a);
                    ConstraintsChangedListener constraintsChangedListener2 = this.g;
                    if (constraintsChangedListener2 != null) {
                        constraintsChangedListener2.a(-1, i4);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.c = i;
        State state2 = (State) this.e.get(i);
        int b3 = state2.b(f2, f3);
        ConstraintSet constraintSet2 = b3 == -1 ? state2.d : ((Variant) state2.b.get(b3)).f;
        int i5 = b3 == -1 ? state2.c : ((Variant) state2.b.get(b3)).e;
        if (constraintSet2 == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i + ", dim =" + f2 + ", " + f3);
            return;
        }
        this.d = b3;
        ConstraintsChangedListener constraintsChangedListener3 = this.g;
        if (constraintsChangedListener3 != null) {
            constraintsChangedListener3.b(i, i5);
        }
        constraintSet2.i(this.f606a);
        ConstraintsChangedListener constraintsChangedListener4 = this.g;
        if (constraintsChangedListener4 != null) {
            constraintsChangedListener4.a(i, i5);
        }
    }
}
