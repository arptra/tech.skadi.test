package com.upuphone.xr.sapp.vu;

import android.util.Log;
import com.upuphone.xr.sapp.vu.arspace.OnCaptureScreenListener;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nArSpaceStarterActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArSpaceStarterActivity.kt\ncom/upuphone/xr/sapp/vu/ArSpaceStarterActivity$setupScreenRecord$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,240:1\n1#2:241\n*E\n"})
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/upuphone/xr/sapp/vu/ArSpaceStarterActivity$setupScreenRecord$1", "Lcom/upuphone/xr/sapp/vu/arspace/OnCaptureScreenListener;", "onCaptureScreenEnd", "", "file", "", "onCaptureScreenStart", "onPrepare", "countDown", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ArSpaceStarterActivity$setupScreenRecord$1 implements OnCaptureScreenListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArSpaceStarterActivity f8022a;

    public ArSpaceStarterActivity$setupScreenRecord$1(ArSpaceStarterActivity arSpaceStarterActivity) {
        this.f8022a = arSpaceStarterActivity;
    }

    public void onCaptureScreenEnd(String str) {
        Log.d("ArSpaceStarterActivity", "onCaptureScreenEnd: " + str);
        if (str != null) {
            this.f8022a.Z0(str);
        }
    }

    public void onCaptureScreenStart() {
        Log.d("ArSpaceStarterActivity", "onCaptureScreenStart");
    }

    public void onPrepare(int i) {
        Log.d("ArSpaceStarterActivity", "capture prepare: " + i);
    }
}
