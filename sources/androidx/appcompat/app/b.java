package androidx.appcompat.app;

import androidx.appcompat.app.AppLocalesStorageHelper;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppLocalesStorageHelper.SerialExecutor f198a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ b(AppLocalesStorageHelper.SerialExecutor serialExecutor, Runnable runnable) {
        this.f198a = serialExecutor;
        this.b = runnable;
    }

    public final void run() {
        this.f198a.b(this.b);
    }
}
