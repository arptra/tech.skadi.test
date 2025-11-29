package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0005*\u0001\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "androidx/activity/result/ActivityResultCallerLauncher$resultContract$2$1", "I", "O", "invoke", "()Landroidx/activity/result/ActivityResultCallerLauncher$resultContract$2$1;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class ActivityResultCallerLauncher$resultContract$2 extends Lambda implements Function0 {
    final /* synthetic */ ActivityResultCallerLauncher<Object, Object> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityResultCallerLauncher$resultContract$2(ActivityResultCallerLauncher<Object, Object> activityResultCallerLauncher) {
        super(0);
        this.this$0 = activityResultCallerLauncher;
    }

    @NotNull
    public final AnonymousClass1 invoke() {
        final ActivityResultCallerLauncher<Object, Object> activityResultCallerLauncher = this.this$0;
        return new ActivityResultContract<Unit, Object>() {
            public Object c(int i, Intent intent) {
                return activityResultCallerLauncher.d().c(i, intent);
            }

            /* renamed from: d */
            public Intent a(Context context, Unit unit) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(unit, "input");
                return activityResultCallerLauncher.d().a(context, activityResultCallerLauncher.e());
            }
        };
    }
}
