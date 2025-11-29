package com.upuphone.xr.sapp.vu;

import android.util.Log;
import com.upuphone.xr.sapp.vu.arspace.OnServiceConnectionListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/upuphone/xr/sapp/vu/ArSpaceStarterActivity$onCreate$listener$1", "Lcom/upuphone/xr/sapp/vu/arspace/OnServiceConnectionListener;", "", "onServiceConnected", "()V", "a", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ArSpaceStarterActivity$onCreate$listener$1 implements OnServiceConnectionListener {
    public void a() {
        Log.d("ArSpaceStarterActivity", "onServiceDisconnected");
    }

    public void onServiceConnected() {
        Log.d("ArSpaceStarterActivity", "onServiceConnected");
    }
}
