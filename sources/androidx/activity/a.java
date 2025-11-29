package androidx.activity;

import androidx.activity.ComponentActivity;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity.ReportFullyDrawnExecutorImpl f108a;

    public /* synthetic */ a(ComponentActivity.ReportFullyDrawnExecutorImpl reportFullyDrawnExecutorImpl) {
        this.f108a = reportFullyDrawnExecutorImpl;
    }

    public final void run() {
        ComponentActivity.ReportFullyDrawnExecutorImpl.b(this.f108a);
    }
}
