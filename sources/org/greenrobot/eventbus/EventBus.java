package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.android.AndroidDependenciesDetector;

public class EventBus {
    public static volatile EventBus s;
    public static final EventBusBuilder t = new EventBusBuilder();
    public static final Map u = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final Map f3366a;
    public final Map b;
    public final Map c;
    public final ThreadLocal d;
    public final MainThreadSupport e;
    public final Poster f;
    public final BackgroundPoster g;
    public final AsyncPoster h;
    public final SubscriberMethodFinder i;
    public final ExecutorService j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final int q;
    public final Logger r;

    /* renamed from: org.greenrobot.eventbus.EventBus$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3368a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.greenrobot.eventbus.ThreadMode[] r0 = org.greenrobot.eventbus.ThreadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3368a = r0
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.POSTING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3368a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.MAIN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3368a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.MAIN_ORDERED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3368a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.BACKGROUND     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3368a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.ASYNC     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.EventBus.AnonymousClass2.<clinit>():void");
        }
    }

    public interface PostCallback {
    }

    public static final class PostingThreadState {

        /* renamed from: a  reason: collision with root package name */
        public final List f3369a = new ArrayList();
        public boolean b;
        public boolean c;
        public Subscription d;
        public Object e;
        public boolean f;
    }

    public EventBus() {
        this(t);
    }

    public static void a(List list, Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public static EventBus c() {
        EventBus eventBus = s;
        if (eventBus == null) {
            synchronized (EventBus.class) {
                try {
                    eventBus = s;
                    if (eventBus == null) {
                        eventBus = new EventBus();
                        s = eventBus;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return eventBus;
    }

    public static List j(Class cls) {
        List list;
        Map map = u;
        synchronized (map) {
            try {
                list = (List) map.get(cls);
                if (list == null) {
                    list = new ArrayList();
                    for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                        list.add(cls2);
                        a(list, cls2.getInterfaces());
                    }
                    u.put(cls, list);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return list;
    }

    public final void b(Subscription subscription, Object obj) {
        if (obj != null) {
            n(subscription, obj, i());
        }
    }

    public ExecutorService d() {
        return this.j;
    }

    public Logger e() {
        return this.r;
    }

    public final void f(Subscription subscription, Object obj, Throwable th) {
        if (obj instanceof SubscriberExceptionEvent) {
            if (this.l) {
                Logger logger = this.r;
                Level level = Level.SEVERE;
                logger.b(level, "SubscriberExceptionEvent subscriber " + subscription.f3380a.getClass() + " threw an exception", th);
                SubscriberExceptionEvent subscriberExceptionEvent = (SubscriberExceptionEvent) obj;
                Logger logger2 = this.r;
                logger2.b(level, "Initial event " + subscriberExceptionEvent.c + " caused exception in " + subscriberExceptionEvent.d, subscriberExceptionEvent.b);
            }
        } else if (!this.k) {
            if (this.l) {
                Logger logger3 = this.r;
                Level level2 = Level.SEVERE;
                logger3.b(level2, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + subscription.f3380a.getClass(), th);
            }
            if (this.n) {
                k(new SubscriberExceptionEvent(this, th, obj, subscription.f3380a));
            }
        } else {
            throw new EventBusException("Invoking subscriber failed", th);
        }
    }

    public void g(PendingPost pendingPost) {
        Object obj = pendingPost.f3374a;
        Subscription subscription = pendingPost.b;
        PendingPost.b(pendingPost);
        if (subscription.c) {
            h(subscription, obj);
        }
    }

    public void h(Subscription subscription, Object obj) {
        try {
            subscription.b.f3377a.invoke(subscription.f3380a, new Object[]{obj});
        } catch (InvocationTargetException e2) {
            f(subscription, obj, e2.getCause());
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unexpected exception", e3);
        }
    }

    public final boolean i() {
        MainThreadSupport mainThreadSupport = this.e;
        return mainThreadSupport == null || mainThreadSupport.a();
    }

    public void k(Object obj) {
        PostingThreadState postingThreadState = (PostingThreadState) this.d.get();
        List list = postingThreadState.f3369a;
        list.add(obj);
        if (!postingThreadState.b) {
            postingThreadState.c = i();
            postingThreadState.b = true;
            if (!postingThreadState.f) {
                while (!list.isEmpty()) {
                    try {
                        l(list.remove(0), postingThreadState);
                    } finally {
                        postingThreadState.b = false;
                        postingThreadState.c = false;
                    }
                }
                return;
            }
            throw new EventBusException("Internal error. Abort state was not reset");
        }
    }

    public final void l(Object obj, PostingThreadState postingThreadState) {
        boolean z;
        Class<?> cls = obj.getClass();
        if (this.p) {
            List j2 = j(cls);
            int size = j2.size();
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                z |= m(obj, postingThreadState, (Class) j2.get(i2));
            }
        } else {
            z = m(obj, postingThreadState, cls);
        }
        if (!z) {
            if (this.m) {
                this.r.a(Level.FINE, "No subscribers registered for event " + cls);
            }
            if (this.o && cls != NoSubscriberEvent.class && cls != SubscriberExceptionEvent.class) {
                k(new NoSubscriberEvent(this, obj));
            }
        }
    }

    public final boolean m(Object obj, PostingThreadState postingThreadState, Class cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.f3366a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            Subscription subscription = (Subscription) it.next();
            postingThreadState.e = obj;
            postingThreadState.d = subscription;
            try {
                n(subscription, obj, postingThreadState.c);
                if (postingThreadState.f) {
                    return true;
                }
            } finally {
                postingThreadState.e = null;
                postingThreadState.d = null;
                postingThreadState.f = false;
            }
        }
        return true;
    }

    public final void n(Subscription subscription, Object obj, boolean z) {
        int i2 = AnonymousClass2.f3368a[subscription.b.b.ordinal()];
        if (i2 == 1) {
            h(subscription, obj);
        } else if (i2 != 2) {
            if (i2 == 3) {
                Poster poster = this.f;
                if (poster != null) {
                    poster.a(subscription, obj);
                } else {
                    h(subscription, obj);
                }
            } else if (i2 != 4) {
                if (i2 == 5) {
                    this.h.a(subscription, obj);
                    return;
                }
                throw new IllegalStateException("Unknown thread mode: " + subscription.b.b);
            } else if (z) {
                this.g.a(subscription, obj);
            } else {
                h(subscription, obj);
            }
        } else if (z) {
            h(subscription, obj);
        } else {
            this.f.a(subscription, obj);
        }
    }

    public void o(Object obj) {
        if (!AndroidDependenciesDetector.c() || AndroidDependenciesDetector.a()) {
            List<SubscriberMethod> a2 = this.i.a(obj.getClass());
            synchronized (this) {
                try {
                    for (SubscriberMethod p2 : a2) {
                        p(obj, p2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        throw new RuntimeException("It looks like you are using EventBus on Android, make sure to add the \"eventbus\" Android library to your dependencies.");
    }

    public final void p(Object obj, SubscriberMethod subscriberMethod) {
        Class cls = subscriberMethod.c;
        Subscription subscription = new Subscription(obj, subscriberMethod);
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f3366a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f3366a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(subscription)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 > size) {
                break;
            } else if (i2 == size || subscriberMethod.d > ((Subscription) copyOnWriteArrayList.get(i2)).b.d) {
                copyOnWriteArrayList.add(i2, subscription);
            } else {
                i2++;
            }
        }
        copyOnWriteArrayList.add(i2, subscription);
        List list = (List) this.b.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.b.put(obj, list);
        }
        list.add(cls);
        if (!subscriberMethod.e) {
            return;
        }
        if (this.p) {
            for (Map.Entry entry : this.c.entrySet()) {
                if (cls.isAssignableFrom((Class) entry.getKey())) {
                    b(subscription, entry.getValue());
                }
            }
            return;
        }
        b(subscription, this.c.get(cls));
    }

    public synchronized void q(Object obj) {
        try {
            List<Class> list = (List) this.b.get(obj);
            if (list != null) {
                for (Class r2 : list) {
                    r(obj, r2);
                }
                this.b.remove(obj);
            } else {
                Logger logger = this.r;
                Level level = Level.WARNING;
                logger.a(level, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void r(Object obj, Class cls) {
        List list = (List) this.f3366a.get(cls);
        if (list != null) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                Subscription subscription = (Subscription) list.get(i2);
                if (subscription.f3380a == obj) {
                    subscription.c = false;
                    list.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.q + ", eventInheritance=" + this.p + "]";
    }

    public EventBus(EventBusBuilder eventBusBuilder) {
        this.d = new ThreadLocal<PostingThreadState>() {
            /* renamed from: a */
            public PostingThreadState initialValue() {
                return new PostingThreadState();
            }
        };
        this.r = eventBusBuilder.a();
        this.f3366a = new HashMap();
        this.b = new HashMap();
        this.c = new ConcurrentHashMap();
        MainThreadSupport b2 = eventBusBuilder.b();
        this.e = b2;
        this.f = b2 != null ? b2.b(this) : null;
        this.g = new BackgroundPoster(this);
        this.h = new AsyncPoster(this);
        List list = eventBusBuilder.j;
        this.q = list != null ? list.size() : 0;
        this.i = new SubscriberMethodFinder(eventBusBuilder.j, eventBusBuilder.h, eventBusBuilder.g);
        this.l = eventBusBuilder.f3370a;
        this.m = eventBusBuilder.b;
        this.n = eventBusBuilder.c;
        this.o = eventBusBuilder.d;
        this.k = eventBusBuilder.e;
        this.p = eventBusBuilder.f;
        this.j = eventBusBuilder.i;
    }
}
