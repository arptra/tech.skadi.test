package dagger.hilt.android.migration;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import dagger.hilt.android.internal.migration.InjectedByHilt;
import dagger.hilt.internal.Preconditions;

public final class OptionalInjectCheck {
    private OptionalInjectCheck() {
    }

    private static boolean check(@NonNull Object obj) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkArgument(obj instanceof InjectedByHilt, "'%s' is not an optionally injected android entry point. Check that you have annotated the class with both @AndroidEntryPoint and @OptionalInject.", obj.getClass());
        return ((InjectedByHilt) obj).wasInjectedByHilt();
    }

    public static boolean wasInjectedByHilt(@NonNull ComponentActivity componentActivity) {
        return check(componentActivity);
    }

    public static boolean wasInjectedByHilt(@NonNull BroadcastReceiver broadcastReceiver) {
        return check(broadcastReceiver);
    }

    public static boolean wasInjectedByHilt(@NonNull Fragment fragment) {
        return check(fragment);
    }

    public static boolean wasInjectedByHilt(@NonNull Service service) {
        return check(service);
    }

    public static boolean wasInjectedByHilt(@NonNull View view) {
        return check(view);
    }
}
