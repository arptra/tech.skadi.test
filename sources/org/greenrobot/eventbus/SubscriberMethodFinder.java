package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.Typography;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

class SubscriberMethodFinder {
    public static final Map d = new ConcurrentHashMap();
    public static final FindState[] e = new FindState[4];

    /* renamed from: a  reason: collision with root package name */
    public List f3378a;
    public final boolean b;
    public final boolean c;

    public static class FindState {

        /* renamed from: a  reason: collision with root package name */
        public final List f3379a = new ArrayList();
        public final Map b = new HashMap();
        public final Map c = new HashMap();
        public final StringBuilder d = new StringBuilder(128);
        public Class e;
        public Class f;
        public boolean g;
        public SubscriberInfo h;

        public boolean a(Method method, Class cls) {
            Object put = this.b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (b((Method) put, cls)) {
                    this.b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        public final boolean b(Method method, Class cls) {
            this.d.setLength(0);
            this.d.append(method.getName());
            StringBuilder sb = this.d;
            sb.append(Typography.greater);
            sb.append(cls.getName());
            String sb2 = this.d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class cls2 = (Class) this.c.put(sb2, declaringClass);
            if (cls2 == null || cls2.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.c.put(sb2, cls2);
            return false;
        }

        public void c(Class cls) {
            this.f = cls;
            this.e = cls;
            this.g = false;
            this.h = null;
        }

        public void d() {
            if (this.g) {
                this.f = null;
                return;
            }
            Class superclass = this.f.getSuperclass();
            this.f = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.") || name.startsWith("androidx.")) {
                this.f = null;
            }
        }

        public void e() {
            this.f3379a.clear();
            this.b.clear();
            this.c.clear();
            this.d.setLength(0);
            this.e = null;
            this.f = null;
            this.g = false;
            this.h = null;
        }
    }

    public SubscriberMethodFinder(List list, boolean z, boolean z2) {
        this.f3378a = list;
        this.b = z;
        this.c = z2;
    }

    public List a(Class cls) {
        Map map = d;
        List list = (List) map.get(cls);
        if (list != null) {
            return list;
        }
        List c2 = this.c ? c(cls) : b(cls);
        if (!c2.isEmpty()) {
            map.put(cls, c2);
            return c2;
        }
        throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    public final List b(Class cls) {
        FindState g = g();
        g.c(cls);
        while (g.f != null) {
            SubscriberInfo f = f(g);
            g.h = f;
            if (f != null) {
                for (SubscriberMethod subscriberMethod : f.a()) {
                    if (g.a(subscriberMethod.f3377a, subscriberMethod.c)) {
                        g.f3379a.add(subscriberMethod);
                    }
                }
            } else {
                d(g);
            }
            g.d();
        }
        return e(g);
    }

    public final List c(Class cls) {
        FindState g = g();
        g.c(cls);
        while (g.f != null) {
            d(g);
            g.d();
        }
        return e(g);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ea, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00eb, code lost:
        r15 = "Could not inspect methods of " + r15.f.getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0104, code lost:
        if (r14.c != false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0106, code lost:
        r14 = r15 + ". Please consider using EventBus annotation processor to avoid reflection.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0118, code lost:
        r14 = r15 + ". Please make this class visible to EventBus annotation processor to avoid reflection.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x012e, code lost:
        throw new org.greenrobot.eventbus.EventBusException(r14, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        r1 = r15.f.getMethods();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r15.g = true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0008 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(org.greenrobot.eventbus.SubscriberMethodFinder.FindState r15) {
        /*
            r14 = this;
            r0 = 1
            java.lang.Class r1 = r15.f     // Catch:{ all -> 0x0008 }
            java.lang.reflect.Method[] r1 = r1.getDeclaredMethods()     // Catch:{ all -> 0x0008 }
            goto L_0x0010
        L_0x0008:
            java.lang.Class r1 = r15.f     // Catch:{ LinkageError -> 0x00ea }
            java.lang.reflect.Method[] r1 = r1.getMethods()     // Catch:{ LinkageError -> 0x00ea }
            r15.g = r0
        L_0x0010:
            int r2 = r1.length
            r3 = 0
            r4 = r3
        L_0x0013:
            if (r4 >= r2) goto L_0x00e9
            r6 = r1[r4]
            int r5 = r6.getModifiers()
            r7 = r5 & 1
            java.lang.String r8 = "."
            java.lang.Class<org.greenrobot.eventbus.Subscribe> r9 = org.greenrobot.eventbus.Subscribe.class
            if (r7 == 0) goto L_0x00a5
            r5 = r5 & 5192(0x1448, float:7.276E-42)
            if (r5 != 0) goto L_0x00a5
            java.lang.Class[] r5 = r6.getParameterTypes()
            int r7 = r5.length
            if (r7 != r0) goto L_0x005b
            java.lang.annotation.Annotation r7 = r6.getAnnotation(r9)
            org.greenrobot.eventbus.Subscribe r7 = (org.greenrobot.eventbus.Subscribe) r7
            if (r7 == 0) goto L_0x00e5
            r8 = r5[r3]
            boolean r5 = r15.a(r6, r8)
            if (r5 == 0) goto L_0x00e5
            org.greenrobot.eventbus.ThreadMode r9 = r7.threadMode()
            java.util.List r11 = r15.f3379a
            org.greenrobot.eventbus.SubscriberMethod r12 = new org.greenrobot.eventbus.SubscriberMethod
            int r10 = r7.priority()
            boolean r13 = r7.sticky()
            r5 = r12
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r13
            r5.<init>(r6, r7, r8, r9, r10)
            r11.add(r12)
            goto L_0x00e5
        L_0x005b:
            boolean r7 = r14.b
            if (r7 == 0) goto L_0x00e5
            boolean r7 = r6.isAnnotationPresent(r9)
            if (r7 != 0) goto L_0x0067
            goto L_0x00e5
        L_0x0067:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.Class r15 = r6.getDeclaringClass()
            java.lang.String r15 = r15.getName()
            r14.append(r15)
            r14.append(r8)
            java.lang.String r15 = r6.getName()
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            org.greenrobot.eventbus.EventBusException r15 = new org.greenrobot.eventbus.EventBusException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "@Subscribe method "
            r0.append(r1)
            r0.append(r14)
            java.lang.String r14 = "must have exactly 1 parameter but has "
            r0.append(r14)
            int r14 = r5.length
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            r15.<init>((java.lang.String) r14)
            throw r15
        L_0x00a5:
            boolean r5 = r14.b
            if (r5 == 0) goto L_0x00e5
            boolean r5 = r6.isAnnotationPresent(r9)
            if (r5 != 0) goto L_0x00b0
            goto L_0x00e5
        L_0x00b0:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.Class r15 = r6.getDeclaringClass()
            java.lang.String r15 = r15.getName()
            r14.append(r15)
            r14.append(r8)
            java.lang.String r15 = r6.getName()
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            org.greenrobot.eventbus.EventBusException r15 = new org.greenrobot.eventbus.EventBusException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r14)
            java.lang.String r14 = " is a illegal @Subscribe method: must be public, non-static, and non-abstract"
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            r15.<init>((java.lang.String) r14)
            throw r15
        L_0x00e5:
            int r4 = r4 + 1
            goto L_0x0013
        L_0x00e9:
            return
        L_0x00ea:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Could not inspect methods of "
            r1.append(r2)
            java.lang.Class r15 = r15.f
            java.lang.String r15 = r15.getName()
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            boolean r14 = r14.c
            if (r14 == 0) goto L_0x0118
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r15)
            java.lang.String r15 = ". Please consider using EventBus annotation processor to avoid reflection."
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            goto L_0x0129
        L_0x0118:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r15)
            java.lang.String r15 = ". Please make this class visible to EventBus annotation processor to avoid reflection."
            r14.append(r15)
            java.lang.String r14 = r14.toString()
        L_0x0129:
            org.greenrobot.eventbus.EventBusException r15 = new org.greenrobot.eventbus.EventBusException
            r15.<init>(r14, r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.SubscriberMethodFinder.d(org.greenrobot.eventbus.SubscriberMethodFinder$FindState):void");
    }

    public final List e(FindState findState) {
        ArrayList arrayList = new ArrayList(findState.f3379a);
        findState.e();
        synchronized (e) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                }
                try {
                    FindState[] findStateArr = e;
                    if (findStateArr[i] == null) {
                        findStateArr[i] = findState;
                        break;
                    }
                    i++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return arrayList;
    }

    public final SubscriberInfo f(FindState findState) {
        SubscriberInfo subscriberInfo = findState.h;
        if (!(subscriberInfo == null || subscriberInfo.c() == null)) {
            SubscriberInfo c2 = findState.h.c();
            if (findState.f == c2.b()) {
                return c2;
            }
        }
        List<SubscriberInfoIndex> list = this.f3378a;
        if (list == null) {
            return null;
        }
        for (SubscriberInfoIndex a2 : list) {
            SubscriberInfo a3 = a2.a(findState.f);
            if (a3 != null) {
                return a3;
            }
        }
        return null;
    }

    public final FindState g() {
        synchronized (e) {
            int i = 0;
            while (i < 4) {
                try {
                    FindState[] findStateArr = e;
                    FindState findState = findStateArr[i];
                    if (findState != null) {
                        findStateArr[i] = null;
                        return findState;
                    }
                    i++;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            return new FindState();
        }
    }
}
