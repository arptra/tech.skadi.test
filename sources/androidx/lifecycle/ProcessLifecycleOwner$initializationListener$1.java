package androidx.lifecycle;

import androidx.lifecycle.ReportFragment;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"androidx/lifecycle/ProcessLifecycleOwner$initializationListener$1", "Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "onCreate", "", "onResume", "onStart", "lifecycle-process_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProcessLifecycleOwner$initializationListener$1 implements ReportFragment.ActivityInitializationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProcessLifecycleOwner f1376a;

    public ProcessLifecycleOwner$initializationListener$1(ProcessLifecycleOwner processLifecycleOwner) {
        this.f1376a = processLifecycleOwner;
    }

    public void onCreate() {
    }

    public void onResume() {
        this.f1376a.d();
    }

    public void onStart() {
        this.f1376a.e();
    }
}
