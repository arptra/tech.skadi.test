package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo
public final class ResourceManagerInternal {
    public static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
    public static ResourceManagerInternal i;
    public static final ColorFilterLruCache j = new ColorFilterLruCache(6);

    /* renamed from: a  reason: collision with root package name */
    public WeakHashMap f334a;
    public SimpleArrayMap b;
    public SparseArrayCompat c;
    public final WeakHashMap d = new WeakHashMap(0);
    public TypedValue e;
    public boolean f;
    public ResourceManagerHooks g;

    public static class AsldcInflateDelegate implements InflateDelegate {
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedStateListDrawableCompat.m(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    public static class AvdcInflateDelegate implements InflateDelegate {
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.b(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    public static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i) {
            super(i);
        }

        public static int b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter c(int i, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(b(i, mode)));
        }

        public PorterDuffColorFilter d(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(b(i, mode)), porterDuffColorFilter);
        }
    }

    public static class DrawableDelegate implements InflateDelegate {
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) DrawableDelegate.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
                    Compatibility.Api21Impl.c(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (Exception e) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e);
                }
            }
            return null;
        }
    }

    public interface InflateDelegate {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    @RestrictTo
    public interface ResourceManagerHooks {
        Drawable a(ResourceManagerInternal resourceManagerInternal, Context context, int i);

        ColorStateList b(Context context, int i);

        PorterDuff.Mode c(int i);

        boolean d(Context context, int i, Drawable drawable);

        boolean e(Context context, int i, Drawable drawable);
    }

    public static class VdcInflateDelegate implements InflateDelegate {
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return VectorDrawableCompat.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    public static long d(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    public static PorterDuffColorFilter f(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return k(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized ResourceManagerInternal g() {
        ResourceManagerInternal resourceManagerInternal;
        synchronized (ResourceManagerInternal.class) {
            try {
                if (i == null) {
                    ResourceManagerInternal resourceManagerInternal2 = new ResourceManagerInternal();
                    i = resourceManagerInternal2;
                    o(resourceManagerInternal2);
                }
                resourceManagerInternal = i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return resourceManagerInternal;
    }

    public static synchronized PorterDuffColorFilter k(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter c2;
        synchronized (ResourceManagerInternal.class) {
            ColorFilterLruCache colorFilterLruCache = j;
            c2 = colorFilterLruCache.c(i2, mode);
            if (c2 == null) {
                c2 = new PorterDuffColorFilter(i2, mode);
                colorFilterLruCache.d(i2, mode, c2);
            }
        }
        return c2;
    }

    public static void o(ResourceManagerInternal resourceManagerInternal) {
    }

    public static boolean p(Drawable drawable) {
        return (drawable instanceof VectorDrawableCompat) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    public static void v(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        int[] state = drawable.getState();
        if (!DrawableUtils.a(drawable) || drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z = tintInfo.d;
            if (z || tintInfo.c) {
                drawable.setColorFilter(f(z ? tintInfo.f364a : null, tintInfo.c ? tintInfo.b : h, iArr));
            } else {
                drawable.clearColorFilter();
            }
        } else {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
        }
    }

    public final synchronized boolean a(Context context, long j2, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            LongSparseArray longSparseArray = (LongSparseArray) this.d.get(context);
            if (longSparseArray == null) {
                longSparseArray = new LongSparseArray();
                this.d.put(context, longSparseArray);
            }
            longSparseArray.put(j2, new WeakReference(constantState));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b(Context context, int i2, ColorStateList colorStateList) {
        if (this.f334a == null) {
            this.f334a = new WeakHashMap();
        }
        SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) this.f334a.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat();
            this.f334a.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.b(i2, colorStateList);
    }

    public final void c(Context context) {
        if (!this.f) {
            this.f = true;
            Drawable i2 = i(context, R.drawable.abc_vector_test);
            if (i2 == null || !p(i2)) {
                this.f = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    public final Drawable e(Context context, int i2) {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        context.getResources().getValue(i2, typedValue, true);
        long d2 = d(typedValue);
        Drawable h2 = h(context, d2);
        if (h2 != null) {
            return h2;
        }
        ResourceManagerHooks resourceManagerHooks = this.g;
        Drawable a2 = resourceManagerHooks == null ? null : resourceManagerHooks.a(this, context, i2);
        if (a2 != null) {
            a2.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, d2, a2);
        }
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.graphics.drawable.Drawable h(android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap r0 = r3.d     // Catch:{ all -> 0x0028 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0028 }
            androidx.collection.LongSparseArray r0 = (androidx.collection.LongSparseArray) r0     // Catch:{ all -> 0x0028 }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.get(r5)     // Catch:{ all -> 0x0028 }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0028 }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x002a
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x0028 }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x0028 }
            monitor-exit(r3)
            return r4
        L_0x0028:
            r4 = move-exception
            goto L_0x002f
        L_0x002a:
            r0.remove(r5)     // Catch:{ all -> 0x0028 }
        L_0x002d:
            monitor-exit(r3)
            return r1
        L_0x002f:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.h(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public synchronized Drawable i(Context context, int i2) {
        return j(context, i2, false);
    }

    public synchronized Drawable j(Context context, int i2, boolean z) {
        Drawable q;
        try {
            c(context);
            q = q(context, i2);
            if (q == null) {
                q = e(context, i2);
            }
            if (q == null) {
                q = ContextCompat.getDrawable(context, i2);
            }
            if (q != null) {
                q = u(context, i2, z, q);
            }
            if (q != null) {
                DrawableUtils.b(q);
            }
        } catch (Throwable th) {
            throw th;
        }
        return q;
    }

    public synchronized ColorStateList l(Context context, int i2) {
        ColorStateList m;
        m = m(context, i2);
        if (m == null) {
            ResourceManagerHooks resourceManagerHooks = this.g;
            m = resourceManagerHooks == null ? null : resourceManagerHooks.b(context, i2);
            if (m != null) {
                b(context, i2, m);
            }
        }
        return m;
    }

    public final ColorStateList m(Context context, int i2) {
        SparseArrayCompat sparseArrayCompat;
        WeakHashMap weakHashMap = this.f334a;
        if (weakHashMap == null || (sparseArrayCompat = (SparseArrayCompat) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) sparseArrayCompat.g(i2);
    }

    public PorterDuff.Mode n(int i2) {
        ResourceManagerHooks resourceManagerHooks = this.g;
        if (resourceManagerHooks == null) {
            return null;
        }
        return resourceManagerHooks.c(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073 A[Catch:{ Exception -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009c A[Catch:{ Exception -> 0x008f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.Drawable q(android.content.Context r11, int r12) {
        /*
            r10 = this;
            androidx.collection.SimpleArrayMap r0 = r10.b
            r1 = 0
            if (r0 == 0) goto L_0x00b3
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b3
            androidx.collection.SparseArrayCompat r0 = r10.c
            java.lang.String r2 = "appcompat_skip_skip"
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r0.g(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto L_0x0027
            if (r0 == 0) goto L_0x002f
            androidx.collection.SimpleArrayMap r3 = r10.b
            java.lang.Object r0 = r3.get(r0)
            if (r0 != 0) goto L_0x002f
        L_0x0027:
            return r1
        L_0x0028:
            androidx.collection.SparseArrayCompat r0 = new androidx.collection.SparseArrayCompat
            r0.<init>()
            r10.c = r0
        L_0x002f:
            android.util.TypedValue r0 = r10.e
            if (r0 != 0) goto L_0x003a
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r10.e = r0
        L_0x003a:
            android.util.TypedValue r0 = r10.e
            android.content.res.Resources r1 = r11.getResources()
            r3 = 1
            r1.getValue(r12, r0, r3)
            long r4 = d(r0)
            android.graphics.drawable.Drawable r6 = r10.h(r11, r4)
            if (r6 == 0) goto L_0x004f
            return r6
        L_0x004f:
            java.lang.CharSequence r7 = r0.string
            if (r7 == 0) goto L_0x00ab
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = ".xml"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x00ab
            android.content.res.XmlResourceParser r1 = r1.getXml(r12)     // Catch:{ Exception -> 0x008f }
            android.util.AttributeSet r7 = android.util.Xml.asAttributeSet(r1)     // Catch:{ Exception -> 0x008f }
        L_0x0067:
            int r8 = r1.next()     // Catch:{ Exception -> 0x008f }
            r9 = 2
            if (r8 == r9) goto L_0x0071
            if (r8 == r3) goto L_0x0071
            goto L_0x0067
        L_0x0071:
            if (r8 != r9) goto L_0x009c
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x008f }
            androidx.collection.SparseArrayCompat r8 = r10.c     // Catch:{ Exception -> 0x008f }
            r8.b(r12, r3)     // Catch:{ Exception -> 0x008f }
            androidx.collection.SimpleArrayMap r8 = r10.b     // Catch:{ Exception -> 0x008f }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ Exception -> 0x008f }
            androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate r3 = (androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate) r3     // Catch:{ Exception -> 0x008f }
            if (r3 == 0) goto L_0x0091
            android.content.res.Resources$Theme r8 = r11.getTheme()     // Catch:{ Exception -> 0x008f }
            android.graphics.drawable.Drawable r6 = r3.a(r11, r1, r7, r8)     // Catch:{ Exception -> 0x008f }
            goto L_0x0091
        L_0x008f:
            r11 = move-exception
            goto L_0x00a4
        L_0x0091:
            if (r6 == 0) goto L_0x00ab
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x008f }
            r6.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x008f }
            r10.a(r11, r4, r6)     // Catch:{ Exception -> 0x008f }
            goto L_0x00ab
        L_0x009c:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x008f }
            java.lang.String r0 = "No start tag found"
            r11.<init>(r0)     // Catch:{ Exception -> 0x008f }
            throw r11     // Catch:{ Exception -> 0x008f }
        L_0x00a4:
            java.lang.String r0 = "ResourceManagerInternal"
            java.lang.String r1 = "Exception while inflating drawable"
            android.util.Log.e(r0, r1, r11)
        L_0x00ab:
            if (r6 != 0) goto L_0x00b2
            androidx.collection.SparseArrayCompat r10 = r10.c
            r10.b(r12, r2)
        L_0x00b2:
            return r6
        L_0x00b3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.q(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    public synchronized void r(Context context) {
        LongSparseArray longSparseArray = (LongSparseArray) this.d.get(context);
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public synchronized Drawable s(Context context, VectorEnabledTintResources vectorEnabledTintResources, int i2) {
        try {
            Drawable q = q(context, i2);
            if (q == null) {
                q = vectorEnabledTintResources.a(i2);
            }
            if (q == null) {
                return null;
            }
            return u(context, i2, false, q);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void t(ResourceManagerHooks resourceManagerHooks) {
        this.g = resourceManagerHooks;
    }

    public final Drawable u(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList l = l(context, i2);
        if (l != null) {
            if (DrawableUtils.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable r = DrawableCompat.r(drawable);
            DrawableCompat.o(r, l);
            PorterDuff.Mode n = n(i2);
            if (n == null) {
                return r;
            }
            DrawableCompat.p(r, n);
            return r;
        }
        ResourceManagerHooks resourceManagerHooks = this.g;
        if ((resourceManagerHooks == null || !resourceManagerHooks.d(context, i2, drawable)) && !w(context, i2, drawable) && z) {
            return null;
        }
        return drawable;
    }

    public boolean w(Context context, int i2, Drawable drawable) {
        ResourceManagerHooks resourceManagerHooks = this.g;
        return resourceManagerHooks != null && resourceManagerHooks.e(context, i2, drawable);
    }
}
