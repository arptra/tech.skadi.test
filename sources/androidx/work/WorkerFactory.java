package androidx.work;

import android.content.Context;

public abstract class WorkerFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2074a = Logger.i("WorkerFactory");

    public static WorkerFactory c() {
        return new WorkerFactory() {
            public ListenableWorker a(Context context, String str, WorkerParameters workerParameters) {
                return null;
            }
        };
    }

    public abstract ListenableWorker a(Context context, String str, WorkerParameters workerParameters);

    public final ListenableWorker b(Context context, String str, WorkerParameters workerParameters) {
        Class<? extends U> cls;
        ListenableWorker a2 = a(context, str, workerParameters);
        if (a2 == null) {
            try {
                cls = Class.forName(str).asSubclass(ListenableWorker.class);
            } catch (Throwable th) {
                Logger e = Logger.e();
                String str2 = f2074a;
                e.d(str2, "Invalid class: " + str, th);
                cls = null;
            }
            if (cls != null) {
                try {
                    a2 = (ListenableWorker) cls.getDeclaredConstructor(new Class[]{Context.class, WorkerParameters.class}).newInstance(new Object[]{context, workerParameters});
                } catch (Throwable th2) {
                    Logger e2 = Logger.e();
                    String str3 = f2074a;
                    e2.d(str3, "Could not instantiate " + str, th2);
                }
            }
        }
        if (a2 == null || !a2.k()) {
            return a2;
        }
        String name = getClass().getName();
        throw new IllegalStateException("WorkerFactory (" + name + ") returned an instance of a ListenableWorker (" + str + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    }
}
