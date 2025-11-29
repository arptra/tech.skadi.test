package com.airbnb.epoxy;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/content/Context;", "", "a", "(Landroid/content/Context;)Z", "epoxy-adapter_release"}, k = 2, mv = {1, 8, 0})
public final class ActivityRecyclerPoolKt {
    public static final boolean a(Context context) {
        Context baseContext;
        if (context == null) {
            return true;
        }
        if (!(context instanceof Activity)) {
            ContextWrapper contextWrapper = context instanceof ContextWrapper ? (ContextWrapper) context : null;
            if (contextWrapper == null || (baseContext = contextWrapper.getBaseContext()) == null) {
                return false;
            }
            return a(baseContext);
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing()) {
            return true;
        }
        return activity.isDestroyed();
    }
}
