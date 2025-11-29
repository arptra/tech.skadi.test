package com.here.odnp.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import com.here.services.util.HereServicesUtil;
import com.meizu.common.widget.MzContactsContract;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeviceMonitor {
    private String TAG;
    private final List<Monitor> mMonitors;
    private State mState;

    public static class AirplaneModeMonitor extends MonitorBase {
        public AirplaneModeMonitor(Context context, Listener listener) {
            super(context, listener, Listener.MonitorType.AirplaneMode);
        }

        public boolean getState() {
            return HereServicesUtil.isAirplaneModeEnabled(this.mContext);
        }

        public void onStart() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            this.mContext.registerReceiver(this.mReceiver, intentFilter);
        }

        public void onStop() {
            this.mContext.unregisterReceiver(this.mReceiver);
        }
    }

    public static class Builder {
        final Context mContext;
        final Listener mListener;
        List<String> mMccList;
        boolean mMonitorAirplaneMode = false;
        boolean mMonitorCell = false;
        boolean mMonitorCountryCode = false;
        boolean mMonitorGps = false;
        boolean mMonitorNetwokLocation = false;
        boolean mMonitorWifi = false;

        public Builder(Context context, Listener listener) {
            if (context == null) {
                throw new IllegalArgumentException("context is null");
            } else if (listener != null) {
                this.mContext = context;
                this.mListener = listener;
            } else {
                throw new IllegalArgumentException("listener is null");
            }
        }

        public DeviceMonitor build() {
            return new DeviceMonitor(this);
        }

        public Builder setMonitorAirplaneMode(boolean z) {
            this.mMonitorAirplaneMode = z;
            return this;
        }

        public Builder setMonitorCell(boolean z) {
            this.mMonitorCell = z;
            return this;
        }

        public Builder setMonitorCountryCode(boolean z, Collection<String> collection) {
            if (!z || collection == null || collection.isEmpty()) {
                this.mMonitorCountryCode = false;
                this.mMccList = null;
                return this;
            }
            this.mMonitorCountryCode = true;
            this.mMccList = new ArrayList(collection);
            return this;
        }

        public Builder setMonitorGps(boolean z) {
            this.mMonitorGps = z;
            return this;
        }

        public Builder setMonitorNetworkLocation(boolean z) {
            this.mMonitorNetwokLocation = z;
            return this;
        }

        public Builder setMonitorWifi(boolean z) {
            this.mMonitorWifi = z;
            return this;
        }
    }

    public static class CellMonitor extends MonitorBase {
        public CellMonitor(Context context, Listener listener) {
            super(context, listener, Listener.MonitorType.Cell);
        }

        public boolean getState() {
            return HereServicesUtil.isPhoneEnabled(this.mContext);
        }

        public void onStart() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            this.mContext.registerReceiver(this.mReceiver, intentFilter);
        }

        public void onStop() {
            this.mContext.unregisterReceiver(this.mReceiver);
        }
    }

    public static class CountryCodeMonitor extends MonitorBase {
        private final List<String> mMccList;
        private final PhoneStateListener mPhoneStateListener = new PhoneStateListener() {
            public void onServiceStateChanged(ServiceState serviceState) {
                int state = serviceState.getState();
                if (state == 0 || state == 2) {
                    CountryCodeMonitor countryCodeMonitor = CountryCodeMonitor.this;
                    countryCodeMonitor.setEnabled(countryCodeMonitor.getState());
                    return;
                }
                CountryCodeMonitor.this.setEnabled(false);
            }
        };

        public CountryCodeMonitor(Context context, Listener listener, List<String> list) {
            super(context, listener, Listener.MonitorType.CountryCode);
            this.mMccList = list;
            this.mEnabled = getState();
        }

        private boolean isMccOnList(String str) {
            List<String> list = this.mMccList;
            return list != null && list.contains(str);
        }

        public boolean getState() {
            return isMccOnList(HereServicesUtil.getMobileCountryCode(this.mContext));
        }

        public void onStart() {
            ((TelephonyManager) this.mContext.getSystemService("phone")).listen(this.mPhoneStateListener, 1);
        }

        public void onStop() {
            ((TelephonyManager) this.mContext.getSystemService("phone")).listen(this.mPhoneStateListener, 0);
        }
    }

    public static class GpsMonitor extends MonitorBase {
        public GpsMonitor(Context context, Listener listener) {
            super(context, listener, Listener.MonitorType.Gps);
        }

        public boolean getState() {
            return HereServicesUtil.isGpsLocationEnabled(this.mContext);
        }

        public void onStart() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mContext.registerReceiver(this.mReceiver, intentFilter);
        }

        public void onStop() {
            this.mContext.unregisterReceiver(this.mReceiver);
        }
    }

    public interface Listener {

        public enum MonitorType {
            Gps,
            NetworkLocation,
            Cell,
            Wifi,
            AirplaneMode,
            CountryCode
        }

        void onMonitorStateChanged(MonitorType monitorType, boolean z);

        void onMonitoringStarted(MonitorType monitorType, boolean z);

        void onMonitoringStopped(MonitorType monitorType);
    }

    public interface Monitor {
        void start();

        void stop();
    }

    public static abstract class MonitorBase implements Monitor {
        protected String TAG = "";
        final Context mContext;
        boolean mEnabled;
        final Listener mListener;
        final Listener.MonitorType mMonitor;
        final BroadcastReceiver mReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                Log.i(MonitorBase.this.TAG, "onReceive: %s", intent);
                MonitorBase monitorBase = MonitorBase.this;
                monitorBase.setEnabled(monitorBase.getState());
            }
        };
        private boolean mStarted;

        public MonitorBase(Context context, Listener listener, Listener.MonitorType monitorType) {
            this.mContext = context;
            this.mListener = listener;
            this.mMonitor = monitorType;
            this.mEnabled = getState();
        }

        public abstract boolean getState();

        public abstract void onStart();

        public abstract void onStop();

        public void setEnabled(boolean z) {
            if (z != this.mEnabled) {
                this.mEnabled = z;
                this.mListener.onMonitorStateChanged(this.mMonitor, z);
            }
        }

        public void start() {
            if (!this.mStarted) {
                Log.v(this.TAG, MzContactsContract.START_PARAM_KEY, new Object[0]);
                this.mStarted = true;
                onStart();
                this.mListener.onMonitoringStarted(this.mMonitor, getState());
            }
        }

        public void stop() {
            if (this.mStarted) {
                Log.v(this.TAG, "stop", new Object[0]);
                this.mStarted = false;
                onStop();
                this.mListener.onMonitoringStopped(this.mMonitor);
            }
        }
    }

    public static class NetworkLocationMonitor extends MonitorBase {
        public NetworkLocationMonitor(Context context, Listener listener) {
            super(context, listener, Listener.MonitorType.NetworkLocation);
        }

        public boolean getState() {
            boolean isNetworkLocationEnabled = HereServicesUtil.isNetworkLocationEnabled(this.mContext);
            Log.v(this.TAG, "getState: enabled: %b", Boolean.valueOf(isNetworkLocationEnabled));
            return isNetworkLocationEnabled;
        }

        public void onStart() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mContext.registerReceiver(this.mReceiver, intentFilter);
        }

        public void onStop() {
            this.mContext.unregisterReceiver(this.mReceiver);
        }
    }

    public enum State {
        Idle,
        Monitoring
    }

    public static class WifiMonitor extends MonitorBase {
        public WifiMonitor(Context context, Listener listener) {
            super(context, listener, Listener.MonitorType.Wifi);
        }

        public boolean getState() {
            return HereServicesUtil.isWifiScanEnabled(this.mContext);
        }

        public void onStart() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            this.mContext.registerReceiver(this.mReceiver, intentFilter);
        }

        public void onStop() {
            this.mContext.unregisterReceiver(this.mReceiver);
        }
    }

    public void startMonitoring() {
        if (this.mState == State.Idle) {
            for (Monitor start : this.mMonitors) {
                try {
                    start.start();
                } catch (Exception unused) {
                }
            }
            this.mState = State.Monitoring;
        }
    }

    public void stopMonitoring() {
        if (this.mState == State.Monitoring) {
            for (Monitor stop : this.mMonitors) {
                try {
                    stop.stop();
                } catch (Exception unused) {
                }
            }
            this.mState = State.Idle;
        }
    }

    private DeviceMonitor(Builder builder) {
        this.TAG = "";
        ArrayList arrayList = new ArrayList();
        this.mMonitors = arrayList;
        this.mState = State.Idle;
        if (builder.mMonitorGps) {
            if (HereServicesUtil.hasGps(builder.mContext)) {
                arrayList.add(new GpsMonitor(builder.mContext, builder.mListener));
            } else {
                Log.w(this.TAG, "GPS monitoring was requested, but device has no GPS.", new Object[0]);
            }
        }
        if (builder.mMonitorNetwokLocation) {
            arrayList.add(new NetworkLocationMonitor(builder.mContext, builder.mListener));
        }
        if (builder.mMonitorAirplaneMode) {
            arrayList.add(new AirplaneModeMonitor(builder.mContext, builder.mListener));
        }
        if (builder.mMonitorCountryCode) {
            arrayList.add(new CountryCodeMonitor(builder.mContext, builder.mListener, builder.mMccList));
        }
        if (builder.mMonitorCell) {
            arrayList.add(new CellMonitor(builder.mContext, builder.mListener));
        }
        if (!builder.mMonitorWifi) {
            return;
        }
        if (HereServicesUtil.hasWifi(builder.mContext)) {
            arrayList.add(new WifiMonitor(builder.mContext, builder.mListener));
        } else {
            Log.w(this.TAG, "Wi-Fi monitoring was requested, but device has no Wi-Fi.", new Object[0]);
        }
    }
}
