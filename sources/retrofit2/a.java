package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f3521a;
    public final /* synthetic */ Callback b;
    public final /* synthetic */ Response c;

    public /* synthetic */ a(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r1, Callback callback, Response response) {
        this.f3521a = r1;
        this.b = callback;
        this.c = response;
    }

    public final void run() {
        this.f3521a.lambda$onResponse$0(this.b, this.c);
    }
}
