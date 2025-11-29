package com.upuphone.xr.sapp.vu;

import android.util.Log;
import com.upuphone.xr.sapp.vu.arspace.OnRequestPermissionResultListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/vu/ArSpaceStarterActivity$setupPermission$1", "Lcom/upuphone/xr/sapp/vu/arspace/OnRequestPermissionResultListener;", "onRequestPermissionResult", "", "requestTag", "", "result", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ArSpaceStarterActivity$setupPermission$1 implements OnRequestPermissionResultListener {
    public void onRequestPermissionResult(String str, boolean z) {
        Log.d("ArSpaceStarterActivity", "onRequestPermissionResult: " + str + ", " + z);
    }
}
