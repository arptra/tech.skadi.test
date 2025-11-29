package com.xjsd.ai.assistant.phone.session.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002<=B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\nJ\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u0013J\u0015\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b \u0010\u001fJ!\u0010#\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b#\u0010$R:\u0010*\u001a&\u0012\u0004\u0012\u00020\u000e\u0012\b\u0012\u00060&R\u00020\u00000%j\u0012\u0012\u0004\u0012\u00020\u000e\u0012\b\u0012\u00060&R\u00020\u0000`'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010.R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u00103R\u0016\u00105\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u00103R$\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u000606j\b\u0012\u0004\u0012\u00020\u0006`78\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u00108R\u0014\u0010;\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010:¨\u0006>"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/utils/ASyncLifecycleRegistry;", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/LifecycleOwner;", "provider", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/lifecycle/Lifecycle$State;", "next", "", "l", "(Landroidx/lifecycle/Lifecycle$State;)V", "", "j", "()Z", "Landroidx/lifecycle/LifecycleObserver;", "observer", "g", "(Landroidx/lifecycle/LifecycleObserver;)Landroidx/lifecycle/Lifecycle$State;", "m", "()V", "state", "n", "lifecycleOwner", "h", "f", "o", "Landroidx/lifecycle/Lifecycle$Event;", "event", "i", "(Landroidx/lifecycle/Lifecycle$Event;)V", "a", "(Landroidx/lifecycle/LifecycleObserver;)V", "d", "state1", "state2", "k", "(Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/Lifecycle$State;)Landroidx/lifecycle/Lifecycle$State;", "Ljava/util/LinkedHashMap;", "Lcom/xjsd/ai/assistant/phone/session/utils/ASyncLifecycleRegistry$ObserverWithState;", "Lkotlin/collections/LinkedHashMap;", "b", "Ljava/util/LinkedHashMap;", "observerMap", "c", "Landroidx/lifecycle/Lifecycle$State;", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "", "e", "I", "addingObserverCounter", "Z", "handlingEvent", "newEventOccurred", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "parentStates", "()Landroidx/lifecycle/Lifecycle$State;", "currentState", "Companion", "ObserverWithState", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ASyncLifecycleRegistry extends Lifecycle {
    public static final Companion i = new Companion((DefaultConstructorMarker) null);
    public LinkedHashMap b = new LinkedHashMap();
    public Lifecycle.State c = Lifecycle.State.INITIALIZED;
    public WeakReference d;
    public int e;
    public boolean f;
    public boolean g;
    public final ArrayList h = new ArrayList();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/utils/ASyncLifecycleRegistry$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/utils/ASyncLifecycleRegistry$ObserverWithState;", "", "Landroidx/lifecycle/LifecycleObserver;", "observer", "Landroidx/lifecycle/Lifecycle$State;", "state", "<init>", "(Lcom/xjsd/ai/assistant/phone/session/utils/ASyncLifecycleRegistry;Landroidx/lifecycle/LifecycleObserver;Landroidx/lifecycle/Lifecycle$State;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "a", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "Landroidx/lifecycle/LifecycleObserver;", "b", "Landroidx/lifecycle/Lifecycle$State;", "()Landroidx/lifecycle/Lifecycle$State;", "setState", "(Landroidx/lifecycle/Lifecycle$State;)V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class ObserverWithState {

        /* renamed from: a  reason: collision with root package name */
        public final LifecycleObserver f8601a;
        public Lifecycle.State b;
        public final /* synthetic */ ASyncLifecycleRegistry c;

        public ObserverWithState(ASyncLifecycleRegistry aSyncLifecycleRegistry, LifecycleObserver lifecycleObserver, Lifecycle.State state) {
            Intrinsics.checkNotNullParameter(lifecycleObserver, "observer");
            Intrinsics.checkNotNullParameter(state, "state");
            this.c = aSyncLifecycleRegistry;
            this.f8601a = lifecycleObserver;
            this.b = state;
        }

        public final void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Lifecycle.State targetState = event.getTargetState();
            this.b = this.c.k(this.b, targetState);
            LifecycleObserver lifecycleObserver = this.f8601a;
            Intrinsics.checkNotNull(lifecycleObserver, "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");
            Intrinsics.checkNotNull(lifecycleOwner);
            ((LifecycleEventObserver) lifecycleObserver).onStateChanged(lifecycleOwner, event);
            this.b = targetState;
        }

        public final Lifecycle.State b() {
            return this.b;
        }
    }

    public ASyncLifecycleRegistry(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "provider");
        this.d = new WeakReference(lifecycleOwner);
    }

    private final void f(LifecycleOwner lifecycleOwner) {
        Iterator d2 = ASyncLifecycleRegistryKt.d(this.b);
        while (d2.hasNext() && !this.g) {
            Map.Entry entry = (Map.Entry) d2.next();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.b().compareTo(this.c) > 0 && !this.g && this.b.containsKey(entry.getKey())) {
                Lifecycle.Event a2 = Lifecycle.Event.Companion.a(observerWithState.b());
                if (a2 != null) {
                    n(a2.getTargetState());
                    observerWithState.a(lifecycleOwner, a2);
                    m();
                } else {
                    Lifecycle.State b2 = observerWithState.b();
                    throw new IllegalStateException("no event down from " + b2);
                }
            }
        }
    }

    private final Lifecycle.State g(LifecycleObserver lifecycleObserver) {
        ObserverWithState observerWithState = (ObserverWithState) ASyncLifecycleRegistryKt.a(this.b, lifecycleObserver);
        Lifecycle.State state = null;
        Lifecycle.State b2 = observerWithState != null ? observerWithState.b() : null;
        if (!this.h.isEmpty()) {
            ArrayList arrayList = this.h;
            state = (Lifecycle.State) arrayList.get(arrayList.size() - 1);
        }
        return k(k(this.c, b2), state);
    }

    private final void h(LifecycleOwner lifecycleOwner) {
        Iterator it = this.b.entrySet().iterator();
        while (it.hasNext() && !this.g) {
            Map.Entry entry = (Map.Entry) it.next();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.b().compareTo(this.c) < 0 && !this.g && this.b.containsKey(entry.getKey())) {
                n(observerWithState.b());
                Lifecycle.Event c2 = Lifecycle.Event.Companion.c(observerWithState.b());
                if (c2 != null) {
                    observerWithState.a(lifecycleOwner, c2);
                    m();
                } else {
                    Lifecycle.State b2 = observerWithState.b();
                    throw new IllegalStateException("no event up from " + b2);
                }
            }
        }
    }

    private final boolean j() {
        if (this.b.size() == 0) {
            return true;
        }
        ObserverWithState observerWithState = (ObserverWithState) ASyncLifecycleRegistryKt.b(this.b);
        Lifecycle.State state = null;
        Lifecycle.State b2 = observerWithState != null ? observerWithState.b() : null;
        ObserverWithState observerWithState2 = (ObserverWithState) ASyncLifecycleRegistryKt.c(this.b);
        if (observerWithState2 != null) {
            state = observerWithState2.b();
        }
        return b2 == state && this.c == state;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0064, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void l(androidx.lifecycle.Lifecycle.State r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            androidx.lifecycle.Lifecycle$State r0 = r5.c     // Catch:{ all -> 0x001e }
            if (r0 != r6) goto L_0x0020
            java.lang.String r0 = "ASyncLifecycleRegistry"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x001e }
            r1.<init>()     // Catch:{ all -> 0x001e }
            java.lang.String r2 = "state is alread been "
            r1.append(r2)     // Catch:{ all -> 0x001e }
            r1.append(r6)     // Catch:{ all -> 0x001e }
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x001e }
            com.xjsd.ai.assistant.log.ILog.a(r0, r6)     // Catch:{ all -> 0x001e }
            monitor-exit(r5)
            return
        L_0x001e:
            r6 = move-exception
            goto L_0x0089
        L_0x0020:
            androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.INITIALIZED     // Catch:{ all -> 0x001e }
            if (r0 != r1) goto L_0x0042
            androidx.lifecycle.Lifecycle$State r0 = androidx.lifecycle.Lifecycle.State.DESTROYED     // Catch:{ all -> 0x001e }
            if (r6 == r0) goto L_0x0029
            goto L_0x0042
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x001e }
            androidx.lifecycle.Lifecycle$State r0 = r5.c     // Catch:{ all -> 0x001e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x001e }
            r1.<init>()     // Catch:{ all -> 0x001e }
            java.lang.String r2 = "no event down from "
            r1.append(r2)     // Catch:{ all -> 0x001e }
            r1.append(r0)     // Catch:{ all -> 0x001e }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x001e }
            r6.<init>(r0)     // Catch:{ all -> 0x001e }
            throw r6     // Catch:{ all -> 0x001e }
        L_0x0042:
            r5.c = r6     // Catch:{ all -> 0x001e }
            boolean r6 = r5.f     // Catch:{ all -> 0x001e }
            r0 = 1
            if (r6 != 0) goto L_0x0065
            int r1 = r5.e     // Catch:{ all -> 0x001e }
            if (r1 == 0) goto L_0x004e
            goto L_0x0065
        L_0x004e:
            r5.f = r0     // Catch:{ all -> 0x001e }
            r5.o()     // Catch:{ all -> 0x001e }
            r6 = 0
            r5.f = r6     // Catch:{ all -> 0x001e }
            androidx.lifecycle.Lifecycle$State r6 = r5.c     // Catch:{ all -> 0x001e }
            androidx.lifecycle.Lifecycle$State r0 = androidx.lifecycle.Lifecycle.State.DESTROYED     // Catch:{ all -> 0x001e }
            if (r6 != r0) goto L_0x0063
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap     // Catch:{ all -> 0x001e }
            r6.<init>()     // Catch:{ all -> 0x001e }
            r5.b = r6     // Catch:{ all -> 0x001e }
        L_0x0063:
            monitor-exit(r5)
            return
        L_0x0065:
            java.lang.String r1 = "ASyncLifecycleRegistry"
            int r2 = r5.e     // Catch:{ all -> 0x001e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x001e }
            r3.<init>()     // Catch:{ all -> 0x001e }
            java.lang.String r4 = "handlingEvent: "
            r3.append(r4)     // Catch:{ all -> 0x001e }
            r3.append(r6)     // Catch:{ all -> 0x001e }
            java.lang.String r6 = ", addingObserverCounter: "
            r3.append(r6)     // Catch:{ all -> 0x001e }
            r3.append(r2)     // Catch:{ all -> 0x001e }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x001e }
            com.xjsd.ai.assistant.log.ILog.a(r1, r6)     // Catch:{ all -> 0x001e }
            r5.g = r0     // Catch:{ all -> 0x001e }
            monitor-exit(r5)
            return
        L_0x0089:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.session.utils.ASyncLifecycleRegistry.l(androidx.lifecycle.Lifecycle$State):void");
    }

    private final void m() {
        ArrayList arrayList = this.h;
        arrayList.remove(arrayList.size() - 1);
    }

    private final void n(Lifecycle.State state) {
        this.h.add(state);
    }

    private final void o() {
        LifecycleOwner lifecycleOwner;
        WeakReference weakReference = this.d;
        if (weakReference == null || (lifecycleOwner = (LifecycleOwner) weakReference.get()) == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (!j()) {
            this.g = false;
            Lifecycle.State state = this.c;
            ObserverWithState observerWithState = (ObserverWithState) ASyncLifecycleRegistryKt.b(this.b);
            Lifecycle.State state2 = null;
            Lifecycle.State b2 = observerWithState != null ? observerWithState.b() : null;
            Intrinsics.checkNotNull(b2);
            if (state.compareTo(b2) < 0) {
                f(lifecycleOwner);
            }
            if (!this.g) {
                Lifecycle.State state3 = this.c;
                ObserverWithState observerWithState2 = (ObserverWithState) ASyncLifecycleRegistryKt.c(this.b);
                if (observerWithState2 != null) {
                    state2 = observerWithState2.b();
                }
                Intrinsics.checkNotNull(state2);
                if (state3.compareTo(state2) > 0) {
                    h(lifecycleOwner);
                }
            }
        }
        this.g = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009f, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0058 A[Catch:{ all -> 0x003a }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0093 A[Catch:{ all -> 0x003a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(androidx.lifecycle.LifecycleObserver r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = "observer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)     // Catch:{ all -> 0x003a }
            androidx.lifecycle.Lifecycle$State r0 = r6.c     // Catch:{ all -> 0x003a }
            androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.DESTROYED     // Catch:{ all -> 0x003a }
            if (r0 != r1) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.INITIALIZED     // Catch:{ all -> 0x003a }
        L_0x000f:
            com.xjsd.ai.assistant.phone.session.utils.ASyncLifecycleRegistry$ObserverWithState r0 = new com.xjsd.ai.assistant.phone.session.utils.ASyncLifecycleRegistry$ObserverWithState     // Catch:{ all -> 0x003a }
            r0.<init>(r6, r7, r1)     // Catch:{ all -> 0x003a }
            java.util.LinkedHashMap r1 = r6.b     // Catch:{ all -> 0x003a }
            java.lang.Object r1 = r1.putIfAbsent(r7, r0)     // Catch:{ all -> 0x003a }
            com.xjsd.ai.assistant.phone.session.utils.ASyncLifecycleRegistry$ObserverWithState r1 = (com.xjsd.ai.assistant.phone.session.utils.ASyncLifecycleRegistry.ObserverWithState) r1     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0020
            monitor-exit(r6)
            return
        L_0x0020:
            java.lang.ref.WeakReference r1 = r6.d     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x009e
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x003a }
            androidx.lifecycle.LifecycleOwner r1 = (androidx.lifecycle.LifecycleOwner) r1     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x002e
            goto L_0x009e
        L_0x002e:
            int r2 = r6.e     // Catch:{ all -> 0x003a }
            r3 = 1
            if (r2 != 0) goto L_0x003c
            boolean r2 = r6.f     // Catch:{ all -> 0x003a }
            if (r2 == 0) goto L_0x0038
            goto L_0x003c
        L_0x0038:
            r2 = 0
            goto L_0x003d
        L_0x003a:
            r7 = move-exception
            goto L_0x00a0
        L_0x003c:
            r2 = r3
        L_0x003d:
            androidx.lifecycle.Lifecycle$State r4 = r6.g(r7)     // Catch:{ all -> 0x003a }
            int r5 = r6.e     // Catch:{ all -> 0x003a }
            int r5 = r5 + r3
            r6.e = r5     // Catch:{ all -> 0x003a }
        L_0x0046:
            androidx.lifecycle.Lifecycle$State r3 = r0.b()     // Catch:{ all -> 0x003a }
            int r3 = r3.compareTo(r4)     // Catch:{ all -> 0x003a }
            if (r3 >= 0) goto L_0x0091
            java.util.LinkedHashMap r3 = r6.b     // Catch:{ all -> 0x003a }
            boolean r3 = r3.containsKey(r7)     // Catch:{ all -> 0x003a }
            if (r3 == 0) goto L_0x0091
            androidx.lifecycle.Lifecycle$State r3 = r0.b()     // Catch:{ all -> 0x003a }
            r6.n(r3)     // Catch:{ all -> 0x003a }
            androidx.lifecycle.Lifecycle$Event$Companion r3 = androidx.lifecycle.Lifecycle.Event.Companion     // Catch:{ all -> 0x003a }
            androidx.lifecycle.Lifecycle$State r4 = r0.b()     // Catch:{ all -> 0x003a }
            androidx.lifecycle.Lifecycle$Event r3 = r3.c(r4)     // Catch:{ all -> 0x003a }
            if (r3 == 0) goto L_0x0076
            r0.a(r1, r3)     // Catch:{ all -> 0x003a }
            r6.m()     // Catch:{ all -> 0x003a }
            androidx.lifecycle.Lifecycle$State r4 = r6.g(r7)     // Catch:{ all -> 0x003a }
            goto L_0x0046
        L_0x0076:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x003a }
            androidx.lifecycle.Lifecycle$State r0 = r0.b()     // Catch:{ all -> 0x003a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
            r1.<init>()     // Catch:{ all -> 0x003a }
            java.lang.String r2 = "no event up from "
            r1.append(r2)     // Catch:{ all -> 0x003a }
            r1.append(r0)     // Catch:{ all -> 0x003a }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x003a }
            r7.<init>(r0)     // Catch:{ all -> 0x003a }
            throw r7     // Catch:{ all -> 0x003a }
        L_0x0091:
            if (r2 != 0) goto L_0x0096
            r6.o()     // Catch:{ all -> 0x003a }
        L_0x0096:
            int r7 = r6.e     // Catch:{ all -> 0x003a }
            int r7 = r7 + -1
            r6.e = r7     // Catch:{ all -> 0x003a }
            monitor-exit(r6)
            return
        L_0x009e:
            monitor-exit(r6)
            return
        L_0x00a0:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.session.utils.ASyncLifecycleRegistry.a(androidx.lifecycle.LifecycleObserver):void");
    }

    public Lifecycle.State b() {
        return this.c;
    }

    public synchronized void d(LifecycleObserver lifecycleObserver) {
        Intrinsics.checkNotNullParameter(lifecycleObserver, "observer");
        this.b.remove(lifecycleObserver);
    }

    public final void i(Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        l(event.getTargetState());
    }

    public final Lifecycle.State k(Lifecycle.State state, Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }
}
