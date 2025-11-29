package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import com.honey.account.c.g;
import com.honey.account.c.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JI\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\b\u001a\u00028\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"androidx/activity/ComponentActivity$activityResultRegistry$1", "Landroidx/activity/result/ActivityResultRegistry;", "I", "O", "", "requestCode", "Landroidx/activity/result/contract/ActivityResultContract;", "contract", "input", "Landroidx/core/app/ActivityOptionsCompat;", "options", "", "i", "(ILandroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Landroidx/core/app/ActivityOptionsCompat;)V", "activity_release"}, k = 1, mv = {1, 8, 0})
public final class ComponentActivity$activityResultRegistry$1 extends ActivityResultRegistry {
    public final /* synthetic */ ComponentActivity i;

    public ComponentActivity$activityResultRegistry$1(ComponentActivity componentActivity) {
        this.i = componentActivity;
    }

    public static final void s(ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1, int i2, ActivityResultContract.SynchronousResult synchronousResult) {
        Intrinsics.checkNotNullParameter(componentActivity$activityResultRegistry$1, "this$0");
        componentActivity$activityResultRegistry$1.f(i2, synchronousResult.a());
    }

    public static final void t(ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1, int i2, IntentSender.SendIntentException sendIntentException) {
        Intrinsics.checkNotNullParameter(componentActivity$activityResultRegistry$1, "this$0");
        Intrinsics.checkNotNullParameter(sendIntentException, "$e");
        componentActivity$activityResultRegistry$1.e(i2, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", sendIntentException));
    }

    public void i(int i2, ActivityResultContract activityResultContract, Object obj, ActivityOptionsCompat activityOptionsCompat) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(activityResultContract, "contract");
        ComponentActivity componentActivity = this.i;
        ActivityResultContract.SynchronousResult b = activityResultContract.b(componentActivity, obj);
        if (b != null) {
            new Handler(Looper.getMainLooper()).post(new g(this, i2, b));
            return;
        }
        Intent a2 = activityResultContract.a(componentActivity, obj);
        if (a2.getExtras() != null) {
            Bundle extras = a2.getExtras();
            Intrinsics.checkNotNull(extras);
            if (extras.getClassLoader() == null) {
                a2.setExtrasClassLoader(componentActivity.getClassLoader());
            }
        }
        if (a2.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            Bundle bundleExtra = a2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            a2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            bundle = bundleExtra;
        } else {
            bundle = activityOptionsCompat != null ? activityOptionsCompat.b() : null;
        }
        if (Intrinsics.areEqual((Object) "androidx.activity.result.contract.action.REQUEST_PERMISSIONS", (Object) a2.getAction())) {
            String[] stringArrayExtra = a2.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            ActivityCompat.e(componentActivity, stringArrayExtra, i2);
        } else if (Intrinsics.areEqual((Object) "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST", (Object) a2.getAction())) {
            IntentSenderRequest intentSenderRequest = (IntentSenderRequest) a2.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                Intrinsics.checkNotNull(intentSenderRequest);
                ActivityCompat.k(componentActivity, intentSenderRequest.getIntentSender(), i2, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundle);
            } catch (IntentSender.SendIntentException e) {
                new Handler(Looper.getMainLooper()).post(new h(this, i2, e));
            }
        } else {
            ActivityCompat.j(componentActivity, a2, i2, bundle);
        }
    }
}
