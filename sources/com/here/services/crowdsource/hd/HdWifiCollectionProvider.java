package com.here.services.crowdsource.hd;

import android.content.Context;
import com.here.odnp.util.Log;
import com.here.posclient.crowdsource.hd.ControlEvent;
import com.here.posclient.crowdsource.hd.IActivityEventDispatcher;
import com.here.services.HereLocationApiClient;
import com.here.services.common.UnsupportedMethodException;
import com.here.services.crowdsource.hd.internal.HdWifiCollectionServicesController;
import com.here.services.crowdsource.hd.internal.IHdWifiCollection;
import com.here.services.internal.ServiceController;

public class HdWifiCollectionProvider implements HdWifiCollectionApi {
    private static final String API_NOT_AVAILABLE = "HdWifiCollectionApi has been disabled.";
    private static final String TAG = "services.crowdsource.hd.HdWifiCollectionProvider";
    final ServiceController.Provider<HdWifiCollectionServicesController> mProvider;

    public HdWifiCollectionProvider(Context context, ServiceController.Provider<HdWifiCollectionServicesController> provider) {
        this.mProvider = provider;
    }

    private IHdWifiCollection getApi(HereLocationApiClient hereLocationApiClient) {
        HdWifiCollectionServicesController controller = this.mProvider.getController(hereLocationApiClient);
        if (controller != null) {
            return controller.getHdWifiCollectionClient();
        }
        Log.e(TAG, "getApi: controller is null, HD wifi collection not available", new Object[0]);
        return null;
    }

    public boolean sendEvent(HereLocationApiClient hereLocationApiClient, ControlEvent controlEvent) throws UnsupportedMethodException {
        throw new UnsupportedMethodException(API_NOT_AVAILABLE);
    }

    public boolean setWifiIntervals(HereLocationApiClient hereLocationApiClient, int i, int i2) throws UnsupportedMethodException {
        throw new UnsupportedMethodException(API_NOT_AVAILABLE);
    }

    public boolean startActivityEventListenening(HereLocationApiClient hereLocationApiClient, IActivityEventDispatcher iActivityEventDispatcher) throws UnsupportedMethodException {
        throw new UnsupportedMethodException(API_NOT_AVAILABLE);
    }

    public void stopActivityEventListenening(HereLocationApiClient hereLocationApiClient, IActivityEventDispatcher iActivityEventDispatcher) throws UnsupportedMethodException {
        throw new UnsupportedMethodException(API_NOT_AVAILABLE);
    }
}
