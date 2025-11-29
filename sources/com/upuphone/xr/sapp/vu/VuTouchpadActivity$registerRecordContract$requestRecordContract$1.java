package com.upuphone.xr.sapp.vu;

import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J!\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/upuphone/xr/sapp/vu/VuTouchpadActivity$registerRecordContract$requestRecordContract$1", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/content/Intent;", "Landroid/content/Context;", "context", "input", "d", "(Landroid/content/Context;Lkotlin/Unit;)Landroid/content/Intent;", "", "resultCode", "intent", "e", "(ILandroid/content/Intent;)Landroid/content/Intent;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuTouchpadActivity$registerRecordContract$requestRecordContract$1 extends ActivityResultContract<Unit, Intent> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuTouchpadActivity f8037a;

    public VuTouchpadActivity$registerRecordContract$requestRecordContract$1(VuTouchpadActivity vuTouchpadActivity) {
        this.f8037a = vuTouchpadActivity;
    }

    /* renamed from: d */
    public Intent a(Context context, Unit unit) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent createScreenCaptureIntent = ((MediaProjectionManager) this.f8037a.getSystemService(MediaProjectionManager.class)).createScreenCaptureIntent();
        Intrinsics.checkNotNullExpressionValue(createScreenCaptureIntent, "createScreenCaptureIntent(...)");
        return createScreenCaptureIntent;
    }

    /* renamed from: e */
    public Intent c(int i, Intent intent) {
        if (i == -1) {
            return intent;
        }
        return null;
    }
}
