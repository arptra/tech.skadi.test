package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f3522a;
    public final /* synthetic */ Callback b;
    public final /* synthetic */ Throwable c;

    public /* synthetic */ b(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r1, Callback callback, Throwable th) {
        this.f3522a = r1;
        this.b = callback;
        this.c = th;
    }

    public final void run() {
        this.f3522a.lambda$onFailure$1(this.b, this.c);
    }
}
