package androidx.activity;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f109a;

    public /* synthetic */ b(ComponentActivity componentActivity) {
        this.f109a = componentActivity;
    }

    public final void run() {
        ComponentActivity$onBackPressedDispatcher$2.invoke$lambda$0(this.f109a);
    }
}
