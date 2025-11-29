package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/activity/result/ActivityResultRegistry$register$2", "Landroidx/activity/result/ActivityResultLauncher;", "input", "Landroidx/core/app/ActivityOptionsCompat;", "options", "", "b", "(Ljava/lang/Object;Landroidx/core/app/ActivityOptionsCompat;)V", "c", "()V", "activity_release"}, k = 1, mv = {1, 8, 0})
public final class ActivityResultRegistry$register$2 extends ActivityResultLauncher<Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivityResultRegistry f120a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ActivityResultContract c;

    public ActivityResultRegistry$register$2(ActivityResultRegistry activityResultRegistry, String str, ActivityResultContract activityResultContract) {
        this.f120a = activityResultRegistry;
        this.b = str;
        this.c = activityResultContract;
    }

    public void b(Object obj, ActivityOptionsCompat activityOptionsCompat) {
        Object obj2 = this.f120a.b.get(this.b);
        ActivityResultContract activityResultContract = this.c;
        if (obj2 != null) {
            int intValue = ((Number) obj2).intValue();
            this.f120a.d.add(this.b);
            try {
                this.f120a.i(intValue, this.c, obj, activityOptionsCompat);
            } catch (Exception e) {
                this.f120a.d.remove(this.b);
                throw e;
            }
        } else {
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }
    }

    public void c() {
        this.f120a.p(this.b);
    }
}
