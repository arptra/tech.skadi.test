package androidx.activity;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f110a;
    public final /* synthetic */ OnBackPressedDispatcher b;

    public /* synthetic */ c(ComponentActivity componentActivity, OnBackPressedDispatcher onBackPressedDispatcher) {
        this.f110a = componentActivity;
        this.b = onBackPressedDispatcher;
    }

    public final void run() {
        ComponentActivity$onBackPressedDispatcher$2.invoke$lambda$2$lambda$1(this.f110a, this.b);
    }
}
