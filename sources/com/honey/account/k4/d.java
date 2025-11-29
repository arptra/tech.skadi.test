package com.honey.account.k4;

import com.here.sdk.maploader.PersistentMapRepairError;
import com.here.sdk.maploader.RepairPersistentMapCallback;
import com.upuphone.ar.navi.lite.offlinemap.HereOfflineMap;

public final /* synthetic */ class d implements RepairPersistentMapCallback {
    public final void onCompleted(PersistentMapRepairError persistentMapRepairError) {
        HereOfflineMap.B(persistentMapRepairError);
    }
}
