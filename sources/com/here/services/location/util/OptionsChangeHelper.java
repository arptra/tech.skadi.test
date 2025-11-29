package com.here.services.location.util;

import android.content.Context;
import com.here.services.common.Types;
import com.here.services.location.OptionsChangedEvent;
import com.here.services.util.HereServicesUtil;
import java.util.EnumSet;

public class OptionsChangeHelper {

    public interface Callbacks {
        void onAirplaneModeEnabled();

        @Deprecated
        void onBluetoothLEDisabled();

        void onCellDisabled();

        void onGnssLocationDisabled();

        void onNetworkLocationDisabled();

        void onWifiScansDisabled();
    }

    public static void onOptionsChanged(Context context, Callbacks callbacks, OptionsChangedEvent optionsChangedEvent) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        } else if (callbacks != null) {
            EnumSet<Types.Source> disabledSources = optionsChangedEvent.getDisabledSources();
            if (disabledSources != null && ((disabledSources.contains(Types.Source.Offline) || disabledSources.contains(Types.Source.Online) || disabledSources.contains(Types.Source.Cache)) && !HereServicesUtil.isNetworkLocationEnabled(context))) {
                callbacks.onNetworkLocationDisabled();
            }
            EnumSet<Types.Technology> disabledTechnologies = optionsChangedEvent.getDisabledTechnologies();
            if (disabledTechnologies != null) {
                EnumSet<Types.Technology> requestedTechnologies = optionsChangedEvent.getRequestedTechnologies();
                requestedTechnologies.removeAll(disabledTechnologies);
                Types.Technology technology = Types.Technology.Wlan;
                boolean z = requestedTechnologies.contains(technology) || requestedTechnologies.contains(Types.Technology.Cell);
                if ((HereServicesUtil.hasWifi(context) || HereServicesUtil.hasCell(context)) && !z && HereServicesUtil.isAirplaneModeEnabled(context)) {
                    callbacks.onAirplaneModeEnabled();
                }
                if (HereServicesUtil.hasWifi(context) && disabledTechnologies.contains(technology)) {
                    callbacks.onWifiScansDisabled();
                }
                if (HereServicesUtil.hasCell(context) && disabledTechnologies.contains(Types.Technology.Cell)) {
                    callbacks.onCellDisabled();
                }
                if (HereServicesUtil.hasGps(context) && disabledTechnologies.contains(Types.Technology.Gnss)) {
                    callbacks.onGnssLocationDisabled();
                }
            }
        } else {
            throw new IllegalArgumentException("handler is null");
        }
    }
}
