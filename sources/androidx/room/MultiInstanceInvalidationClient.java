package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.InvalidationTracker;
import com.honey.account.c0.d;
import com.honey.account.c0.e;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\n \u001d*\u0004\u0018\u00010\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001eR\"\u0010%\u001a\u00020 8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010!\u001a\u0004\b\u0019\u0010\"\"\u0004\b#\u0010$R\"\u0010,\u001a\u00020&8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+R$\u00104\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0017\u00109\u001a\u0002058\u0006¢\u0006\f\n\u0004\b0\u00106\u001a\u0004\b7\u00108R\u0017\u0010?\u001a\u00020:8\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0017\u0010D\u001a\u00020@8\u0006¢\u0006\f\n\u0004\b=\u0010A\u001a\u0004\bB\u0010CR\u0017\u0010I\u001a\u00020E8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\b;\u0010HR\u0017\u0010J\u001a\u00020E8\u0006¢\u0006\f\n\u0004\b*\u0010G\u001a\u0004\b.\u0010H¨\u0006K"}, d2 = {"Landroidx/room/MultiInstanceInvalidationClient;", "", "Landroid/content/Context;", "context", "", "name", "Landroid/content/Intent;", "serviceIntent", "Landroidx/room/InvalidationTracker;", "invalidationTracker", "Ljava/util/concurrent/Executor;", "executor", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroidx/room/InvalidationTracker;Ljava/util/concurrent/Executor;)V", "", "o", "()V", "a", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "b", "Landroidx/room/InvalidationTracker;", "e", "()Landroidx/room/InvalidationTracker;", "c", "Ljava/util/concurrent/Executor;", "d", "()Ljava/util/concurrent/Executor;", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "appContext", "", "I", "()I", "setClientId", "(I)V", "clientId", "Landroidx/room/InvalidationTracker$Observer;", "f", "Landroidx/room/InvalidationTracker$Observer;", "()Landroidx/room/InvalidationTracker$Observer;", "l", "(Landroidx/room/InvalidationTracker$Observer;)V", "observer", "Landroidx/room/IMultiInstanceInvalidationService;", "g", "Landroidx/room/IMultiInstanceInvalidationService;", "h", "()Landroidx/room/IMultiInstanceInvalidationService;", "m", "(Landroidx/room/IMultiInstanceInvalidationService;)V", "service", "Landroidx/room/IMultiInstanceInvalidationCallback;", "Landroidx/room/IMultiInstanceInvalidationCallback;", "getCallback", "()Landroidx/room/IMultiInstanceInvalidationCallback;", "callback", "Ljava/util/concurrent/atomic/AtomicBoolean;", "i", "Ljava/util/concurrent/atomic/AtomicBoolean;", "j", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "stopped", "Landroid/content/ServiceConnection;", "Landroid/content/ServiceConnection;", "getServiceConnection", "()Landroid/content/ServiceConnection;", "serviceConnection", "Ljava/lang/Runnable;", "k", "Ljava/lang/Runnable;", "()Ljava/lang/Runnable;", "setUpRunnable", "removeObserverRunnable", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMultiInstanceInvalidationClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiInstanceInvalidationClient.kt\nandroidx/room/MultiInstanceInvalidationClient\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,130:1\n37#2,2:131\n*S KotlinDebug\n*F\n+ 1 MultiInstanceInvalidationClient.kt\nandroidx/room/MultiInstanceInvalidationClient\n*L\n95#1:131,2\n*E\n"})
public final class MultiInstanceInvalidationClient {

    /* renamed from: a  reason: collision with root package name */
    public final String f1740a;
    public final InvalidationTracker b;
    public final Executor c;
    public final Context d;
    public int e;
    public InvalidationTracker.Observer f;
    public IMultiInstanceInvalidationService g;
    public final IMultiInstanceInvalidationCallback h = new MultiInstanceInvalidationClient$callback$1(this);
    public final AtomicBoolean i = new AtomicBoolean(false);
    public final ServiceConnection j;
    public final Runnable k;
    public final Runnable l;

    public MultiInstanceInvalidationClient(Context context, String str, Intent intent, InvalidationTracker invalidationTracker, Executor executor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(intent, "serviceIntent");
        Intrinsics.checkNotNullParameter(invalidationTracker, "invalidationTracker");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.f1740a = str;
        this.b = invalidationTracker;
        this.c = executor;
        Context applicationContext = context.getApplicationContext();
        this.d = applicationContext;
        MultiInstanceInvalidationClient$serviceConnection$1 multiInstanceInvalidationClient$serviceConnection$1 = new MultiInstanceInvalidationClient$serviceConnection$1(this);
        this.j = multiInstanceInvalidationClient$serviceConnection$1;
        this.k = new d(this);
        this.l = new e(this);
        l(new InvalidationTracker.Observer(this, (String[]) invalidationTracker.k().keySet().toArray(new String[0])) {
            public final /* synthetic */ MultiInstanceInvalidationClient b;

            {
                this.b = r1;
            }

            public boolean b() {
                return true;
            }

            public void c(Set set) {
                Intrinsics.checkNotNullParameter(set, "tables");
                if (!this.b.j().get()) {
                    try {
                        IMultiInstanceInvalidationService h = this.b.h();
                        if (h != null) {
                            h.broadcastInvalidation(this.b.c(), (String[]) set.toArray(new String[0]));
                        }
                    } catch (RemoteException e) {
                        Log.w("ROOM", "Cannot broadcast invalidation", e);
                    }
                }
            }
        });
        applicationContext.bindService(intent, multiInstanceInvalidationClient$serviceConnection$1, 1);
    }

    public static final void k(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        Intrinsics.checkNotNullParameter(multiInstanceInvalidationClient, "this$0");
        multiInstanceInvalidationClient.b.q(multiInstanceInvalidationClient.f());
    }

    public static final void n(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        Intrinsics.checkNotNullParameter(multiInstanceInvalidationClient, "this$0");
        try {
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.g;
            if (iMultiInstanceInvalidationService != null) {
                multiInstanceInvalidationClient.e = iMultiInstanceInvalidationService.registerCallback(multiInstanceInvalidationClient.h, multiInstanceInvalidationClient.f1740a);
                multiInstanceInvalidationClient.b.c(multiInstanceInvalidationClient.f());
            }
        } catch (RemoteException e2) {
            Log.w("ROOM", "Cannot register multi-instance invalidation callback", e2);
        }
    }

    public final int c() {
        return this.e;
    }

    public final Executor d() {
        return this.c;
    }

    public final InvalidationTracker e() {
        return this.b;
    }

    public final InvalidationTracker.Observer f() {
        InvalidationTracker.Observer observer = this.f;
        if (observer != null) {
            return observer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observer");
        return null;
    }

    public final Runnable g() {
        return this.l;
    }

    public final IMultiInstanceInvalidationService h() {
        return this.g;
    }

    public final Runnable i() {
        return this.k;
    }

    public final AtomicBoolean j() {
        return this.i;
    }

    public final void l(InvalidationTracker.Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "<set-?>");
        this.f = observer;
    }

    public final void m(IMultiInstanceInvalidationService iMultiInstanceInvalidationService) {
        this.g = iMultiInstanceInvalidationService;
    }

    public final void o() {
        if (this.i.compareAndSet(false, true)) {
            this.b.q(f());
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.g;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(this.h, this.e);
                }
            } catch (RemoteException e2) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e2);
            }
            this.d.unbindService(this.j);
        }
    }
}
