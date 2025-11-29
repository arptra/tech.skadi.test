package androidx.core.app;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
public abstract class JobIntentService extends Service {
    public static final Object h = new Object();
    public static final HashMap i = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public CompatJobEngine f650a;
    public WorkEnqueuer b;
    public CommandProcessor c;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public final ArrayList g = null;

    public final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        public CommandProcessor() {
        }

        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                GenericWorkItem a2 = JobIntentService.this.a();
                if (a2 == null) {
                    return null;
                }
                JobIntentService.this.d(a2.getIntent());
                a2.complete();
            }
        }

        /* renamed from: b */
        public void onCancelled(Void voidR) {
            JobIntentService.this.f();
        }

        /* renamed from: c */
        public void onPostExecute(Void voidR) {
            JobIntentService.this.f();
        }
    }

    public interface CompatJobEngine {
        IBinder a();

        GenericWorkItem b();
    }

    public static final class CompatWorkEnqueuer extends WorkEnqueuer {

        /* renamed from: a  reason: collision with root package name */
        public final PowerManager.WakeLock f652a;
        public final PowerManager.WakeLock b;
        public boolean c;
        public boolean d;

        public void a() {
            synchronized (this) {
                try {
                    if (this.d) {
                        if (this.c) {
                            this.f652a.acquire(60000);
                        }
                        this.d = false;
                        this.b.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void b() {
            synchronized (this) {
                try {
                    if (!this.d) {
                        this.d = true;
                        this.b.acquire(600000);
                        this.f652a.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void c() {
            synchronized (this) {
                this.c = false;
            }
        }
    }

    public final class CompatWorkItem implements GenericWorkItem {

        /* renamed from: a  reason: collision with root package name */
        public final Intent f653a;
        public final int b;

        public CompatWorkItem(Intent intent, int i) {
            this.f653a = intent;
            this.b = i;
        }

        public void complete() {
            JobIntentService.this.stopSelf(this.b);
        }

        public Intent getIntent() {
            return this.f653a;
        }
    }

    public interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    @RequiresApi
    public static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {

        /* renamed from: a  reason: collision with root package name */
        public final JobIntentService f654a;
        public final Object b = new Object();
        public JobParameters c;

        public final class WrapperWorkItem implements GenericWorkItem {

            /* renamed from: a  reason: collision with root package name */
            public final JobWorkItem f655a;

            public WrapperWorkItem(JobWorkItem jobWorkItem) {
                this.f655a = jobWorkItem;
            }

            public void complete() {
                synchronized (JobServiceEngineImpl.this.b) {
                    try {
                        JobParameters jobParameters = JobServiceEngineImpl.this.c;
                        if (jobParameters != null) {
                            jobParameters.completeWork(this.f655a);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            public Intent getIntent() {
                return this.f655a.getIntent();
            }
        }

        public JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f654a = jobIntentService;
        }

        public IBinder a() {
            return getBinder();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0011, code lost:
            if (r1 == null) goto L_0x0026;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            r1.getIntent().setExtrasClassLoader(r3.f654a.getClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
            return new androidx.core.app.JobIntentService.JobServiceEngineImpl.WrapperWorkItem(r3, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.core.app.JobIntentService.GenericWorkItem b() {
            /*
                r3 = this;
                java.lang.Object r0 = r3.b
                monitor-enter(r0)
                android.app.job.JobParameters r1 = r3.c     // Catch:{ all -> 0x000a }
                r2 = 0
                if (r1 != 0) goto L_0x000c
                monitor-exit(r0)     // Catch:{ all -> 0x000a }
                return r2
            L_0x000a:
                r3 = move-exception
                goto L_0x0027
            L_0x000c:
                android.app.job.JobWorkItem r1 = r1.dequeueWork()     // Catch:{ all -> 0x000a }
                monitor-exit(r0)     // Catch:{ all -> 0x000a }
                if (r1 == 0) goto L_0x0026
                android.content.Intent r0 = r1.getIntent()
                androidx.core.app.JobIntentService r2 = r3.f654a
                java.lang.ClassLoader r2 = r2.getClassLoader()
                r0.setExtrasClassLoader(r2)
                androidx.core.app.JobIntentService$JobServiceEngineImpl$WrapperWorkItem r0 = new androidx.core.app.JobIntentService$JobServiceEngineImpl$WrapperWorkItem
                r0.<init>(r1)
                return r0
            L_0x0026:
                return r2
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x000a }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.JobIntentService.JobServiceEngineImpl.b():androidx.core.app.JobIntentService$GenericWorkItem");
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.c = jobParameters;
            this.f654a.c(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean b2 = this.f654a.b();
            synchronized (this.b) {
                this.c = null;
            }
            return b2;
        }
    }

    @RequiresApi
    public static final class JobWorkEnqueuer extends WorkEnqueuer {
    }

    public static abstract class WorkEnqueuer {
        public void a() {
        }

        public void b() {
        }

        public void c() {
        }
    }

    public GenericWorkItem a() {
        CompatJobEngine compatJobEngine = this.f650a;
        if (compatJobEngine != null) {
            return compatJobEngine.b();
        }
        synchronized (this.g) {
            try {
                if (this.g.size() <= 0) {
                    return null;
                }
                GenericWorkItem genericWorkItem = (GenericWorkItem) this.g.remove(0);
                return genericWorkItem;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean b() {
        CommandProcessor commandProcessor = this.c;
        if (commandProcessor != null) {
            commandProcessor.cancel(this.d);
        }
        this.e = true;
        return e();
    }

    public void c(boolean z) {
        if (this.c == null) {
            this.c = new CommandProcessor();
            WorkEnqueuer workEnqueuer = this.b;
            if (workEnqueuer != null && z) {
                workEnqueuer.b();
            }
            this.c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public abstract void d(Intent intent);

    public boolean e() {
        return true;
    }

    public void f() {
        ArrayList arrayList = this.g;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.c = null;
                    ArrayList arrayList2 = this.g;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        c(false);
                    } else if (!this.f) {
                        this.b.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        CompatJobEngine compatJobEngine = this.f650a;
        if (compatJobEngine != null) {
            return compatJobEngine.a();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.f650a = new JobServiceEngineImpl(this);
        this.b = null;
    }

    public void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f = true;
                this.b.a();
            }
        }
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        if (this.g == null) {
            return 2;
        }
        this.b.c();
        synchronized (this.g) {
            ArrayList arrayList = this.g;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new CompatWorkItem(intent, i3));
            c(true);
        }
        return 3;
    }
}
