package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

public class ActivityOptionsCompat {

    public static class ActivityOptionsCompatImpl extends ActivityOptionsCompat {

        /* renamed from: a  reason: collision with root package name */
        public final ActivityOptions f641a;

        public ActivityOptionsCompatImpl(ActivityOptions activityOptions) {
            this.f641a = activityOptions;
        }

        public Bundle b() {
            return this.f641a.toBundle();
        }
    }

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static ActivityOptions a(Activity activity, View view, String str) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, view, str);
        }

        @DoNotInline
        @SafeVarargs
        public static ActivityOptions b(Activity activity, Pair<View, String>... pairArr) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, pairArr);
        }

        @DoNotInline
        public static ActivityOptions c() {
            return ActivityOptions.makeTaskLaunchBehind();
        }
    }

    @RequiresApi
    public static class Api23Impl {
        @DoNotInline
        public static ActivityOptions a() {
            return ActivityOptions.makeBasic();
        }

        @DoNotInline
        public static ActivityOptions b(View view, int i, int i2, int i3, int i4) {
            return ActivityOptions.makeClipRevealAnimation(view, i, i2, i3, i4);
        }

        @DoNotInline
        public static void c(ActivityOptions activityOptions, PendingIntent pendingIntent) {
            activityOptions.requestUsageTimeReport(pendingIntent);
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static Rect a(ActivityOptions activityOptions) {
            return activityOptions.getLaunchBounds();
        }

        @DoNotInline
        public static ActivityOptions b(ActivityOptions activityOptions, Rect rect) {
            return activityOptions.setLaunchBounds(rect);
        }
    }

    @RequiresApi
    public static class Api34Impl {
        @DoNotInline
        public static ActivityOptions a(ActivityOptions activityOptions, boolean z) {
            return activityOptions.setShareIdentityEnabled(z);
        }
    }

    public static ActivityOptionsCompat a(Activity activity, View view, String str) {
        return new ActivityOptionsCompatImpl(Api21Impl.a(activity, view, str));
    }

    public Bundle b() {
        return null;
    }
}
