package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003J!\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/activity/result/ActivityResultCallerLauncher;", "I", "O", "Landroidx/activity/result/ActivityResultLauncher;", "", "input", "Landroidx/core/app/ActivityOptionsCompat;", "options", "f", "(Lkotlin/Unit;Landroidx/core/app/ActivityOptionsCompat;)V", "c", "()V", "a", "Landroidx/activity/result/ActivityResultLauncher;", "launcher", "Landroidx/activity/result/contract/ActivityResultContract;", "b", "Landroidx/activity/result/contract/ActivityResultContract;", "d", "()Landroidx/activity/result/contract/ActivityResultContract;", "callerContract", "Ljava/lang/Object;", "e", "()Ljava/lang/Object;", "callerInput", "activity_release"}, k = 1, mv = {1, 8, 0})
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final ActivityResultLauncher f115a;
    public final ActivityResultContract b;
    public final Object c;

    public void c() {
        this.f115a.c();
    }

    public final ActivityResultContract d() {
        return this.b;
    }

    public final Object e() {
        return this.c;
    }

    /* renamed from: f */
    public void b(Unit unit, ActivityOptionsCompat activityOptionsCompat) {
        Intrinsics.checkNotNullParameter(unit, "input");
        this.f115a.b(this.c, activityOptionsCompat);
    }
}
