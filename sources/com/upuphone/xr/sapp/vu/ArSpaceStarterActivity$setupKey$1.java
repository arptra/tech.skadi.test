package com.upuphone.xr.sapp.vu;

import android.util.Log;
import com.upuphone.xr.sapp.vu.arspace.OnKeyListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/vu/ArSpaceStarterActivity$setupKey$1", "Lcom/upuphone/xr/sapp/vu/arspace/OnKeyListener;", "onKeyEvent", "", "keyCode", "", "action", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ArSpaceStarterActivity$setupKey$1 implements OnKeyListener {
    public void onKeyEvent(int i, int i2) {
        Log.d("ArSpaceStarterActivity", "onGlassesKeyEvent: " + i + ", " + i2);
    }
}
