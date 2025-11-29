package com.here.odnp.adaptations;

import android.location.GnssMeasurementsEvent;
import android.location.Location;
import android.util.Pair;
import com.here.odnp.cell.ICellManager;
import com.here.odnp.gnss.IGnssManager;
import com.here.odnp.util.Log;
import com.here.odnp.wifi.IWifiFilter;
import com.here.odnp.wifi.IWifiManager;
import com.here.odnp.wifi.WifiFilterTimestamp;
import com.here.posclient.CellMeasurement;
import com.here.posclient.CellNetworkType;
import com.here.posclient.CellularStatus;
import com.here.posclient.GnssStatus;
import com.here.posclient.IMeasurementProvider;
import com.here.posclient.MeasurementType;
import com.here.posclient.PositionEstimate;
import com.here.posclient.Status;
import com.here.posclient.WifiMeasurement;
import com.here.posclient.WifiStatus;
import java.util.List;

public class MeasurementProvider implements IMeasurementProvider {
    private static final String TAG = "odnp.adaptations.MeasurementProvider";
    private final ICellManager.ICellListener mCellListener = new ICellManager.ICellListener() {
        public void onCellMeasurementChanged(CellMeasurement cellMeasurement) {
            Log.v(MeasurementProvider.TAG, "ICellListener.onCellMeasurementChanged", new Object[0]);
            MeasurementProvider.this.mMeasResultHandler.handleCellularScanResult(cellMeasurement, cellMeasurement.simulated);
        }

        public void onCellScanFailed() {
            Log.v(MeasurementProvider.TAG, "ICellListener.onCellScanFailed", new Object[0]);
            MeasurementProvider.this.mMeasResultHandler.handleRequestError(MeasurementType.MSMTYPE_CELLULAR, Status.GeneralError);
        }

        public void onCellularStatusChanged(CellularStatus cellularStatus) {
            Log.v(MeasurementProvider.TAG, "ICellListener.onCellularStatusChanged: status: %s", Long.valueOf(cellularStatus.status));
            MeasurementProvider.this.mMeasResultHandler.handleCellularStatusChange(cellularStatus);
        }
    };
    private ICellManager mCellManager;
    private final IGnssManager.IGnnsListener mGnssListener = new IGnssManager.IGnnsListener() {
        public void onGnssLocationChanged(Location location, boolean z) {
            Log.v(MeasurementProvider.TAG, "IGnnsListener.onGnssLocationChanged: %s, simulated: %b", location, Boolean.valueOf(z));
            MeasurementProvider.this.mMeasResultHandler.handleGnssLocationUpdate(PositionEstimate.fromAndroidLocation(location), z);
        }

        public void onGnssMeasurementsReceived(Object obj) {
            Log.v(MeasurementProvider.TAG, "IGnnsListener.onGnssMeasurementsReceived: %s", (GnssMeasurementsEvent) obj);
            MeasurementProvider.this.mMeasResultHandler.handleGnssMeasurements(obj);
        }

        public void onGnssStatusChanged(GnssStatus gnssStatus) {
            Log.v(MeasurementProvider.TAG, "IGnnsListener.onGnssStatusChanged: %s", gnssStatus);
            MeasurementProvider.this.mMeasResultHandler.handleGnssStatus(gnssStatus);
        }

        public void onGnssStatusReceived(long j, Object obj) {
            Log.v(MeasurementProvider.TAG, "IGnnsListener.onGnssStatusReceived: %s", (android.location.GnssStatus) obj);
            MeasurementProvider.this.mMeasResultHandler.handleAndroidGnssStatus(j, obj);
        }
    };
    private IGnssManager mGnssManager;
    /* access modifiers changed from: private */
    public final IMeasurementResultHandler mMeasResultHandler;
    private boolean mStartGnssCalled;
    /* access modifiers changed from: private */
    public IWifiFilter mWifiFilter;
    private final IWifiManager.IWifiListener mWifiListener = new IWifiManager.IWifiListener() {
        public void onScanResultsAvailable(IWifiManager.WifiScanResultContainer wifiScanResultContainer) {
            if (MeasurementProvider.this.mWifiFilter == null) {
                Log.w(MeasurementProvider.TAG, "IWifiListener.onScanResultsAvailable: Wi-Fi filter is null -> scanresult ignored.", new Object[0]);
                return;
            }
            Log.v(MeasurementProvider.TAG, "IWifiListener.onScanResultsAvailable", new Object[0]);
            MeasurementProvider.this.mWifiFilter.updateMeasurements(wifiScanResultContainer.scanResultList);
            MeasurementProvider.this.mMeasResultHandler.handleWifiScanResult(wifiScanResultContainer.measurementId, MeasurementProvider.this.mWifiFilter.getFilteredMeasurements(), false, wifiScanResultContainer.simulated);
        }

        public void onWifiScanFailed() {
            Log.v(MeasurementProvider.TAG, "IWifiListener.onWifiScanFailed", new Object[0]);
            MeasurementProvider.this.mMeasResultHandler.handleRequestError(MeasurementType.MSMTYPE_WLAN, Status.GeneralError);
        }

        public void onWifiStateChanged(WifiStatus wifiStatus) {
            Log.v(MeasurementProvider.TAG, "IWifiListener.onWifiStateChanged: %s", wifiStatus);
            MeasurementProvider.this.mMeasResultHandler.handleWifiStateChanged(wifiStatus);
        }
    };
    private IWifiManager mWifiManager;

    /* renamed from: com.here.odnp.adaptations.MeasurementProvider$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$here$posclient$MeasurementType;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.here.posclient.MeasurementType[] r0 = com.here.posclient.MeasurementType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$here$posclient$MeasurementType = r0
                com.here.posclient.MeasurementType r1 = com.here.posclient.MeasurementType.MSMTYPE_CELLULAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$here$posclient$MeasurementType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.here.posclient.MeasurementType r1 = com.here.posclient.MeasurementType.MSMTYPE_WLAN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$here$posclient$MeasurementType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.here.posclient.MeasurementType r1 = com.here.posclient.MeasurementType.MSMTYPE_GNSS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$here$posclient$MeasurementType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.here.posclient.MeasurementType r1 = com.here.posclient.MeasurementType.MSMTYPE_GNSS_OBSERVATION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$here$posclient$MeasurementType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.here.posclient.MeasurementType r1 = com.here.posclient.MeasurementType.MSMTYPE_ALL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.here.odnp.adaptations.MeasurementProvider.AnonymousClass4.<clinit>():void");
        }
    }

    public MeasurementProvider(IMeasurementResultHandler iMeasurementResultHandler) {
        Log.v(TAG, "MeasurementProvider.ctor", new Object[0]);
        this.mMeasResultHandler = iMeasurementResultHandler;
    }

    private boolean isCellMeasurementSupported() {
        ICellManager iCellManager = this.mCellManager;
        return iCellManager != null && iCellManager.isCellSupported();
    }

    private boolean isCellNeighborMeasurementSupported() {
        ICellManager iCellManager = this.mCellManager;
        return iCellManager != null && iCellManager.isCellNeighborSupported();
    }

    private boolean isGnssMeasurementSupported() {
        IGnssManager iGnssManager = this.mGnssManager;
        return iGnssManager != null && iGnssManager.isGnssSupported();
    }

    private boolean isWifiMeasurementSupported() {
        IWifiManager iWifiManager = this.mWifiManager;
        return iWifiManager != null && iWifiManager.isWifiSupported();
    }

    private void registerCellScanResults() {
        ICellManager iCellManager = this.mCellManager;
        if (iCellManager != null) {
            iCellManager.open(this.mCellListener);
        }
    }

    private void registerGnssUpdates() {
        IGnssManager iGnssManager = this.mGnssManager;
        if (iGnssManager != null) {
            iGnssManager.startListening(this.mGnssListener, 500);
            if (this.mStartGnssCalled) {
                this.mGnssManager.startGnss();
            }
        }
    }

    private void registerWifiScanResults() {
        IWifiManager iWifiManager = this.mWifiManager;
        if (iWifiManager != null) {
            setInitialScanResult(iWifiManager.getLastScanResult());
            this.mWifiManager.open(this.mWifiListener);
        }
    }

    private void setInitialScanResult(Pair<Long, List<WifiMeasurement>> pair) {
        IWifiFilter iWifiFilter;
        if (pair != null && (iWifiFilter = this.mWifiFilter) != null) {
            iWifiFilter.setInitialMeasurements((List) pair.second);
        }
    }

    private void unregisterCellScanResults() {
        ICellManager iCellManager = this.mCellManager;
        if (iCellManager != null) {
            iCellManager.close();
        }
    }

    private void unregisterGnssUpdates() {
        IGnssManager iGnssManager = this.mGnssManager;
        if (iGnssManager != null) {
            iGnssManager.stopListening();
            if (this.mStartGnssCalled) {
                this.mGnssManager.stopGnss();
            }
        }
    }

    private void unregisterWifiScanResults() {
        IWifiManager iWifiManager = this.mWifiManager;
        if (iWifiManager != null) {
            iWifiManager.close();
        }
    }

    public void cancelCellularScan() {
        Log.v(TAG, "cancelCellularScan", new Object[0]);
        ICellManager iCellManager = this.mCellManager;
        if (iCellManager != null) {
            iCellManager.cancelCellScan();
        }
    }

    public void cancelWifiScan() {
        Log.v(TAG, "cancelWifiScan", new Object[0]);
        IWifiManager iWifiManager = this.mWifiManager;
        if (iWifiManager != null) {
            iWifiManager.cancelWifiScan();
        }
    }

    public void close() {
        unsubscribe(MeasurementType.MSMTYPE_ALL);
    }

    public ICellManager getCellManager() {
        return this.mCellManager;
    }

    public IGnssManager getGnssManager() {
        return this.mGnssManager;
    }

    public PositionEstimate getLastKnownPosition() {
        Location lastKnownLocation;
        Log.v(TAG, "getLastKnownPosition", new Object[0]);
        IGnssManager iGnssManager = this.mGnssManager;
        if (iGnssManager == null || (lastKnownLocation = iGnssManager.getLastKnownLocation()) == null) {
            return null;
        }
        return PositionEstimate.fromAndroidLocation(lastKnownLocation);
    }

    public IWifiManager getWifiManager() {
        return this.mWifiManager;
    }

    public int requestCurrentWlanList() {
        Log.v(TAG, "requestCurrentWlanList", new Object[0]);
        IWifiManager iWifiManager = this.mWifiManager;
        if (iWifiManager == null) {
            return Status.GeneralError.toInt();
        }
        Pair<Long, List<WifiMeasurement>> lastScanResult = iWifiManager.getLastScanResult();
        long longValue = ((Long) lastScanResult.first).longValue();
        List list = (List) lastScanResult.second;
        WifiFilterBase.filterDuplicates(list);
        if (!WifiFilterTimestamp.updateTimestamps(list)) {
            return Status.NotSupportedError.toInt();
        }
        this.mMeasResultHandler.handleWifiScanResult(longValue, (WifiMeasurement[]) list.toArray(new WifiMeasurement[list.size()]), true, false);
        return Status.Ok.toInt();
    }

    public void reset() {
        IWifiFilter iWifiFilter = this.mWifiFilter;
        if (iWifiFilter != null) {
            IWifiManager iWifiManager = this.mWifiManager;
            if (iWifiManager != null) {
                setInitialScanResult(iWifiManager.getLastScanResult());
            } else {
                iWifiFilter.reset();
            }
        }
    }

    public MeasurementProvider setCellManager(ICellManager iCellManager) {
        return setCellManager(iCellManager, false);
    }

    public MeasurementProvider setGnssManager(IGnssManager iGnssManager) {
        return setGnssManager(iGnssManager, false);
    }

    public MeasurementProvider setWifiFilter(IWifiFilter iWifiFilter) {
        if (iWifiFilter != null) {
            this.mWifiFilter = iWifiFilter;
            reset();
            return this;
        }
        throw new IllegalArgumentException("wifiFilter is null");
    }

    public MeasurementProvider setWifiManager(IWifiManager iWifiManager) {
        return setWifiManager(iWifiManager, false);
    }

    public boolean startCellularScan() {
        Log.v(TAG, "startCellularScan", new Object[0]);
        ICellManager iCellManager = this.mCellManager;
        if (iCellManager == null) {
            return false;
        }
        return iCellManager.startCellScan();
    }

    public int startGnss() {
        Log.v(TAG, "startGnss", new Object[0]);
        this.mStartGnssCalled = true;
        IGnssManager iGnssManager = this.mGnssManager;
        if (iGnssManager == null) {
            return Status.GeneralError.toInt();
        }
        Status startGnss = iGnssManager.startGnss();
        return startGnss == null ? Status.GeneralError.toInt() : startGnss.toInt();
    }

    public int startGnssMeasurements() {
        Log.v(TAG, "startGnssMeasurements", new Object[0]);
        IGnssManager iGnssManager = this.mGnssManager;
        if (iGnssManager == null) {
            return Status.GeneralError.toInt();
        }
        Status startGnssMeasurements = iGnssManager.startGnssMeasurements();
        return startGnssMeasurements == null ? Status.GeneralError.toInt() : startGnssMeasurements.toInt();
    }

    public boolean startWifiScan() {
        Log.v(TAG, "startWifiScan", new Object[0]);
        IWifiManager iWifiManager = this.mWifiManager;
        if (iWifiManager != null) {
            return iWifiManager.startWifiScan();
        }
        return false;
    }

    public void stopGnss() {
        Log.v(TAG, "stopGnss", new Object[0]);
        this.mStartGnssCalled = false;
        IGnssManager iGnssManager = this.mGnssManager;
        if (iGnssManager != null) {
            iGnssManager.stopGnss();
        }
    }

    public void stopGnssMeasurements() {
        Log.v(TAG, "stopGnssMeasurements", new Object[0]);
        IGnssManager iGnssManager = this.mGnssManager;
        if (iGnssManager != null) {
            iGnssManager.stopGnssMeasurements();
        }
    }

    public int subscribe(int i) {
        int i2 = Status.Ok.toInt();
        int i3 = AnonymousClass4.$SwitchMap$com$here$posclient$MeasurementType[MeasurementType.fromInt(i).ordinal()];
        if (i3 == 1) {
            registerCellScanResults();
            return i2;
        } else if (i3 == 2) {
            registerWifiScanResults();
            return i2;
        } else if (i3 == 3) {
            registerGnssUpdates();
            return i2;
        } else if (i3 == 4) {
            return i2;
        } else {
            if (i3 != 5) {
                Log.w(TAG, "subscribe: invalid msmType: %d", Integer.valueOf(i));
                return Status.InvalidArgumentError.toInt();
            }
            registerCellScanResults();
            registerWifiScanResults();
            registerGnssUpdates();
            return i2;
        }
    }

    public int supportedCellMeasurementTypes() {
        return (isCellNeighborMeasurementSupported() ? CellNetworkType.CELL_NW_TYPE_ALL_GSM_NEIGHBOR.value : CellNetworkType.CELL_NW_TYPE_ALL_GSM_SERVING.value) | CellNetworkType.CELL_NW_TYPE_UNKNOWN.value | CellNetworkType.CELL_NW_TYPE_CDMA.value;
    }

    public int supportedMeasurementTypes() {
        int i = MeasurementType.MSMTYPE_UNKNOWN.value;
        if (isCellMeasurementSupported()) {
            i |= MeasurementType.MSMTYPE_CELLULAR.value;
        }
        if (isWifiMeasurementSupported()) {
            i = i | MeasurementType.MSMTYPE_WLAN.value | MeasurementType.MSMTYPE_CACHED_WLAN.value;
        }
        if (!isGnssMeasurementSupported()) {
            return i;
        }
        return MeasurementType.MSMTYPE_GNSS_OBSERVATION.value | MeasurementType.MSMTYPE_GNSS.value | i;
    }

    public void unsubscribe(int i) {
        unsubscribe(MeasurementType.fromInt(i));
    }

    private void unsubscribe(MeasurementType measurementType) {
        Log.v(TAG, "unsubscribe: msmType: %s", measurementType);
        int i = AnonymousClass4.$SwitchMap$com$here$posclient$MeasurementType[measurementType.ordinal()];
        if (i == 1) {
            unregisterCellScanResults();
        } else if (i == 2) {
            unregisterWifiScanResults();
        } else if (i == 3) {
            unregisterGnssUpdates();
        } else if (i == 4) {
        } else {
            if (i != 5) {
                Log.w(TAG, "unsubscribe: invalid msmType: %s", measurementType);
                return;
            }
            unregisterCellScanResults();
            unregisterWifiScanResults();
            unregisterGnssUpdates();
        }
    }

    public MeasurementProvider setCellManager(ICellManager iCellManager, boolean z) {
        unregisterCellScanResults();
        if (iCellManager != null) {
            this.mCellManager = iCellManager;
            if (z) {
                registerCellScanResults();
            }
            return this;
        }
        throw new IllegalArgumentException("cellManager is null");
    }

    public MeasurementProvider setGnssManager(IGnssManager iGnssManager, boolean z) {
        unregisterGnssUpdates();
        if (iGnssManager != null) {
            this.mGnssManager = iGnssManager;
            if (z) {
                registerGnssUpdates();
            }
            return this;
        }
        throw new IllegalArgumentException("gnssManager is null");
    }

    public MeasurementProvider setWifiManager(IWifiManager iWifiManager, boolean z) {
        unregisterWifiScanResults();
        if (iWifiManager != null) {
            this.mWifiManager = iWifiManager;
            if (z) {
                registerWifiScanResults();
            }
            return this;
        }
        throw new IllegalArgumentException("wifiManager is null");
    }
}
