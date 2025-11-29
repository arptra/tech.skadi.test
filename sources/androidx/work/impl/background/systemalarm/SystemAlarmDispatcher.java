package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncher;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

@RestrictTo
public class SystemAlarmDispatcher implements ExecutionListener {
    public static final String l = Logger.i("SystemAlarmDispatcher");

    /* renamed from: a  reason: collision with root package name */
    public final Context f2126a;
    public final TaskExecutor b;
    public final WorkTimer c;
    public final Processor d;
    public final WorkManagerImpl e;
    public final CommandHandler f;
    public final List g;
    public Intent h;
    public CommandsCompletedListener i;
    public StartStopTokens j;
    public final WorkLauncher k;

    public static class AddRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final SystemAlarmDispatcher f2128a;
        public final Intent b;
        public final int c;

        public AddRunnable(SystemAlarmDispatcher systemAlarmDispatcher, Intent intent, int i) {
            this.f2128a = systemAlarmDispatcher;
            this.b = intent;
            this.c = i;
        }

        public void run() {
            this.f2128a.a(this.b, this.c);
        }
    }

    public interface CommandsCompletedListener {
        void b();
    }

    public static class DequeueAndCheckForCompletion implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final SystemAlarmDispatcher f2129a;

        public DequeueAndCheckForCompletion(SystemAlarmDispatcher systemAlarmDispatcher) {
            this.f2129a = systemAlarmDispatcher;
        }

        public void run() {
            this.f2129a.d();
        }
    }

    public SystemAlarmDispatcher(Context context) {
        this(context, (Processor) null, (WorkManagerImpl) null, (WorkLauncher) null);
    }

    public boolean a(Intent intent, int i2) {
        Logger e2 = Logger.e();
        String str = l;
        e2.a(str, "Adding command " + intent + " (" + i2 + ")");
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            Logger.e().k(str, "Unknown command. Ignoring");
            return false;
        } else if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && j("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        } else {
            intent.putExtra("KEY_START_ID", i2);
            synchronized (this.g) {
                try {
                    boolean z = !this.g.isEmpty();
                    this.g.add(intent);
                    if (!z) {
                        l();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
    }

    public final void b() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public void c(WorkGenerationalId workGenerationalId, boolean z) {
        this.b.c().execute(new AddRunnable(this, CommandHandler.d(this.f2126a, workGenerationalId, z), 0));
    }

    public void d() {
        Logger e2 = Logger.e();
        String str = l;
        e2.a(str, "Checking if commands are complete.");
        b();
        synchronized (this.g) {
            try {
                if (this.h != null) {
                    Logger e3 = Logger.e();
                    e3.a(str, "Removing command " + this.h);
                    if (((Intent) this.g.remove(0)).equals(this.h)) {
                        this.h = null;
                    } else {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                }
                SerialExecutor d2 = this.b.d();
                if (!this.f.o() && this.g.isEmpty() && !d2.z()) {
                    Logger.e().a(str, "No more commands & intents.");
                    CommandsCompletedListener commandsCompletedListener = this.i;
                    if (commandsCompletedListener != null) {
                        commandsCompletedListener.b();
                    }
                } else if (!this.g.isEmpty()) {
                    l();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Processor e() {
        return this.d;
    }

    public TaskExecutor f() {
        return this.b;
    }

    public WorkManagerImpl g() {
        return this.e;
    }

    public WorkTimer h() {
        return this.c;
    }

    public WorkLauncher i() {
        return this.k;
    }

    public final boolean j(String str) {
        b();
        synchronized (this.g) {
            try {
                for (Intent action : this.g) {
                    if (str.equals(action.getAction())) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void k() {
        Logger.e().a(l, "Destroying SystemAlarmDispatcher");
        this.d.p(this);
        this.i = null;
    }

    public final void l() {
        b();
        PowerManager.WakeLock b2 = WakeLocks.b(this.f2126a, "ProcessCommand");
        try {
            b2.acquire();
            this.e.q().b(new Runnable() {
                public void run() {
                    Executor c;
                    DequeueAndCheckForCompletion dequeueAndCheckForCompletion;
                    synchronized (SystemAlarmDispatcher.this.g) {
                        SystemAlarmDispatcher systemAlarmDispatcher = SystemAlarmDispatcher.this;
                        systemAlarmDispatcher.h = (Intent) systemAlarmDispatcher.g.get(0);
                    }
                    Intent intent = SystemAlarmDispatcher.this.h;
                    if (intent != null) {
                        String action = intent.getAction();
                        int intExtra = SystemAlarmDispatcher.this.h.getIntExtra("KEY_START_ID", 0);
                        Logger e = Logger.e();
                        String str = SystemAlarmDispatcher.l;
                        e.a(str, "Processing command " + SystemAlarmDispatcher.this.h + ", " + intExtra);
                        Context context = SystemAlarmDispatcher.this.f2126a;
                        PowerManager.WakeLock b = WakeLocks.b(context, action + " (" + intExtra + ")");
                        try {
                            Logger e2 = Logger.e();
                            e2.a(str, "Acquiring operation wake lock (" + action + ") " + b);
                            b.acquire();
                            SystemAlarmDispatcher systemAlarmDispatcher2 = SystemAlarmDispatcher.this;
                            systemAlarmDispatcher2.f.p(systemAlarmDispatcher2.h, intExtra, systemAlarmDispatcher2);
                            Logger e3 = Logger.e();
                            e3.a(str, "Releasing operation wake lock (" + action + ") " + b);
                            b.release();
                            c = SystemAlarmDispatcher.this.b.c();
                            dequeueAndCheckForCompletion = new DequeueAndCheckForCompletion(SystemAlarmDispatcher.this);
                        } catch (Throwable th) {
                            Logger e4 = Logger.e();
                            String str2 = SystemAlarmDispatcher.l;
                            e4.a(str2, "Releasing operation wake lock (" + action + ") " + b);
                            b.release();
                            SystemAlarmDispatcher.this.b.c().execute(new DequeueAndCheckForCompletion(SystemAlarmDispatcher.this));
                            throw th;
                        }
                        c.execute(dequeueAndCheckForCompletion);
                    }
                }
            });
        } finally {
            b2.release();
        }
    }

    public void m(CommandsCompletedListener commandsCompletedListener) {
        if (this.i != null) {
            Logger.e().c(l, "A completion listener for SystemAlarmDispatcher already exists.");
        } else {
            this.i = commandsCompletedListener;
        }
    }

    public SystemAlarmDispatcher(Context context, Processor processor, WorkManagerImpl workManagerImpl, WorkLauncher workLauncher) {
        Context applicationContext = context.getApplicationContext();
        this.f2126a = applicationContext;
        this.j = new StartStopTokens();
        workManagerImpl = workManagerImpl == null ? WorkManagerImpl.k(context) : workManagerImpl;
        this.e = workManagerImpl;
        this.f = new CommandHandler(applicationContext, workManagerImpl.i().a(), this.j);
        this.c = new WorkTimer(workManagerImpl.i().k());
        processor = processor == null ? workManagerImpl.m() : processor;
        this.d = processor;
        TaskExecutor q = workManagerImpl.q();
        this.b = q;
        this.k = workLauncher == null ? new WorkLauncherImpl(processor, q) : workLauncher;
        processor.e(this);
        this.g = new ArrayList();
        this.h = null;
    }
}
