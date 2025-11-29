package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class StateSet {

    /* renamed from: a  reason: collision with root package name */
    public int f622a = -1;
    public int b = -1;
    public int c = -1;
    public SparseArray d = new SparseArray();
    public SparseArray e = new SparseArray();
    public ConstraintsChangedListener f = null;

    public static class State {

        /* renamed from: a  reason: collision with root package name */
        public int f623a;
        public ArrayList b = new ArrayList();
        public int c = -1;
        public boolean d;

        public State(Context context, XmlPullParser xmlPullParser) {
            this.d = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.State_android_id) {
                    this.f623a = obtainStyledAttributes.getResourceId(index, this.f623a);
                } else if (index == R.styleable.State_constraints) {
                    this.c = obtainStyledAttributes.getResourceId(index, this.c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.c);
                    context.getResources().getResourceName(this.c);
                    if ("layout".equals(resourceTypeName)) {
                        this.d = true;
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
        public float f624a = Float.NaN;
        public float b = Float.NaN;
        public float c = Float.NaN;
        public float d = Float.NaN;
        public int e = -1;
        public boolean f;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            this.f = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Variant_constraints) {
                    this.e = obtainStyledAttributes.getResourceId(index, this.e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if ("layout".equals(resourceTypeName)) {
                        this.f = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.d = obtainStyledAttributes.getDimension(index, this.d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.b = obtainStyledAttributes.getDimension(index, this.b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.c = obtainStyledAttributes.getDimension(index, this.c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f624a = obtainStyledAttributes.getDimension(index, this.f624a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        public boolean a(float f2, float f3) {
            if (!Float.isNaN(this.f624a) && f2 < this.f624a) {
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

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        b(context, xmlPullParser);
    }

    public int a(int i, int i2, float f2, float f3) {
        State state = (State) this.d.get(i2);
        if (state == null) {
            return i2;
        }
        if (f2 != -1.0f && f3 != -1.0f) {
            Iterator it = state.b.iterator();
            Variant variant = null;
            while (it.hasNext()) {
                Variant variant2 = (Variant) it.next();
                if (variant2.a(f2, f3)) {
                    if (i == variant2.e) {
                        return i;
                    }
                    variant = variant2;
                }
            }
            return variant != null ? variant.e : state.c;
        } else if (state.c == i) {
            return i;
        } else {
            Iterator it2 = state.b.iterator();
            while (it2.hasNext()) {
                if (i == ((Variant) it2.next()).e) {
                    return i;
                }
            }
            return state.c;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10) {
        /*
            r8 = this;
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r10)
            int[] r1 = androidx.constraintlayout.widget.R.styleable.StateSet
            android.content.res.TypedArray r0 = r9.obtainStyledAttributes(r0, r1)
            int r1 = r0.getIndexCount()
            r2 = 0
            r3 = r2
        L_0x0010:
            if (r3 >= r1) goto L_0x0025
            int r4 = r0.getIndex(r3)
            int r5 = androidx.constraintlayout.widget.R.styleable.StateSet_defaultState
            if (r4 != r5) goto L_0x0022
            int r5 = r8.f622a
            int r4 = r0.getResourceId(r4, r5)
            r8.f622a = r4
        L_0x0022:
            int r3 = r3 + 1
            goto L_0x0010
        L_0x0025:
            r0.recycle()
            int r0 = r10.getEventType()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            r1 = 0
        L_0x002d:
            r3 = 1
            if (r0 == r3) goto L_0x00a9
            if (r0 == 0) goto L_0x009a
            java.lang.String r4 = "StateSet"
            r5 = 3
            r6 = 2
            if (r0 == r6) goto L_0x004b
            if (r0 == r5) goto L_0x003c
            goto L_0x009d
        L_0x003c:
            java.lang.String r0 = r10.getName()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            boolean r0 = r4.equals(r0)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            if (r0 == 0) goto L_0x009d
            return
        L_0x0047:
            r8 = move-exception
            goto L_0x00a2
        L_0x0049:
            r8 = move-exception
            goto L_0x00a6
        L_0x004b:
            java.lang.String r0 = r10.getName()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            int r7 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            switch(r7) {
                case 80204913: goto L_0x0072;
                case 1301459538: goto L_0x0068;
                case 1382829617: goto L_0x0061;
                case 1901439077: goto L_0x0057;
                default: goto L_0x0056;
            }     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
        L_0x0056:
            goto L_0x007c
        L_0x0057:
            java.lang.String r3 = "Variant"
            boolean r0 = r0.equals(r3)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            if (r0 == 0) goto L_0x007c
            r3 = r5
            goto L_0x007d
        L_0x0061:
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            if (r0 == 0) goto L_0x007c
            goto L_0x007d
        L_0x0068:
            java.lang.String r3 = "LayoutDescription"
            boolean r0 = r0.equals(r3)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            if (r0 == 0) goto L_0x007c
            r3 = r2
            goto L_0x007d
        L_0x0072:
            java.lang.String r3 = "State"
            boolean r0 = r0.equals(r3)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            if (r0 == 0) goto L_0x007c
            r3 = r6
            goto L_0x007d
        L_0x007c:
            r3 = -1
        L_0x007d:
            if (r3 == r6) goto L_0x008d
            if (r3 == r5) goto L_0x0082
            goto L_0x009d
        L_0x0082:
            androidx.constraintlayout.widget.StateSet$Variant r0 = new androidx.constraintlayout.widget.StateSet$Variant     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            r0.<init>(r9, r10)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            if (r1 == 0) goto L_0x009d
            r1.a(r0)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            goto L_0x009d
        L_0x008d:
            androidx.constraintlayout.widget.StateSet$State r1 = new androidx.constraintlayout.widget.StateSet$State     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            r1.<init>(r9, r10)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            android.util.SparseArray r0 = r8.d     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            int r3 = r1.f623a     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            r0.put(r3, r1)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            goto L_0x009d
        L_0x009a:
            r10.getName()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
        L_0x009d:
            int r0 = r10.next()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            goto L_0x002d
        L_0x00a2:
            r8.printStackTrace()
            goto L_0x00a9
        L_0x00a6:
            r8.printStackTrace()
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.StateSet.b(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public int c(int i, int i2, int i3) {
        return d(-1, i, (float) i2, (float) i3);
    }

    public int d(int i, int i2, float f2, float f3) {
        int b2;
        if (i == i2) {
            State state = i2 == -1 ? (State) this.d.valueAt(0) : (State) this.d.get(this.b);
            if (state == null) {
                return -1;
            }
            return ((this.c == -1 || !((Variant) state.b.get(i)).a(f2, f3)) && i != (b2 = state.b(f2, f3))) ? b2 == -1 ? state.c : ((Variant) state.b.get(b2)).e : i;
        }
        State state2 = (State) this.d.get(i2);
        if (state2 == null) {
            return -1;
        }
        int b3 = state2.b(f2, f3);
        return b3 == -1 ? state2.c : ((Variant) state2.b.get(b3)).e;
    }
}
