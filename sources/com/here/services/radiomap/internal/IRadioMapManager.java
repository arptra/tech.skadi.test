package com.here.services.radiomap.internal;

import android.os.Bundle;
import com.here.posclient.RadioMapManager;
import com.here.services.internal.Manager;
import com.here.services.radiomap.common.GeoArea;
import java.util.List;

public interface IRadioMapManager extends Manager {
    public static final int RM_CONNECTION_ERROR = 13;
    public static final int RM_DATA_TRANSFER_ERROR = 14;
    public static final int RM_NO_CONNECTION_FOUND_ERROR = 20;
    public static final int RM_READ_WRITE_ERROR = 12;
    public static final int RM_STATUS_ERROR = 1;
    public static final int RM_STATUS_OK = 0;

    public interface IRadioMapActionListener {
        void onRadioMapActionProgress(int i);

        void onRadioMapQueryActionComplete(int i, long j);

        void onRadioMapStorageActionComplete(int i);

        void onSessionClosed();
    }

    void close();

    boolean startRadioMapQuery(List<GeoArea> list, int i, RadioMapManager.RadioMapQueryAction radioMapQueryAction, IRadioMapActionListener iRadioMapActionListener);

    boolean startRadioMapUpdate(List<GeoArea> list, RadioMapManager.RadioMapStorageAction radioMapStorageAction, Bundle bundle, IRadioMapActionListener iRadioMapActionListener);

    void stopRadioMapAction(IRadioMapActionListener iRadioMapActionListener);
}
