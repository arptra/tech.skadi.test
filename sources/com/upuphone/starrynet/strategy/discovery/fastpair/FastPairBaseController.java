package com.upuphone.starrynet.strategy.discovery.fastpair;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.fastpair.appfastpair.BleAppJudgment;
import java.util.List;

public abstract class FastPairBaseController {
    public static final int RSSI_RECONNECT_MIN = -90;
    public static final String TAG = "FastPairBaseController";
    protected Context mContext;
    protected StarryDeviceManager mDeviceManager = StarryDeviceManager.getInstance();
    protected StarryDeviceManager mDiscoveryDeviceManager = StarryDeviceManager.getInstance();
    public FastPairHandler mHandler = new FastPairHandler(Looper.getMainLooper());
    protected HandlerThread mHandlerThread;

    public class FastPairHandler extends Handler {
        public FastPairHandler(Looper looper) {
            super(looper);
        }

        @SuppressLint({"MissingPermission"})
        public void handleMessage(@NonNull Message message) {
            StLog.d(FastPairBaseController.TAG, "handleMessage: msg = " + message.what);
            switch (message.what) {
                case 1:
                    FastPairBaseController.this.dealShowWindowMessage(message);
                    return;
                case 2:
                    FastPairBaseController.this.dealDismissWindowMessage(message);
                    return;
                case 3:
                    break;
                case 4:
                    FastPairBaseController.this.dealClickCancelMessage(message);
                    return;
                case 5:
                    FastPairBaseController.this.dealBondOkMessage(message);
                    return;
                case 6:
                case 12:
                    FastPairBaseController.this.dealBondFailMessage(message);
                    return;
                case 7:
                    FastPairBaseController.this.dealClassicBondMessage(message);
                    return;
                case 8:
                    FastPairBaseController.this.dealConnectTimeoutMessage(message);
                    return;
                case 9:
                    FastPairBaseController.this.dealAutoConnectTimeoutMessage(message);
                    return;
                case 10:
                    FastPairBaseController.this.dealDispatchToAppMessage(message);
                    return;
                case 11:
                    FastPairBaseController.this.dealRemoveBondMessage(message);
                    return;
                case 13:
                    StDevice stDevice = (StDevice) message.obj;
                    List<StConnectDevice> bondedInfo = StarryDeviceManager.getInstance().getBondedInfo();
                    if (bondedInfo != null && bondedInfo.size() != 0) {
                        for (StConnectDevice next : bondedInfo) {
                            if (next.getIdentifier().equals(stDevice.getIdentifier()) && next.getBleBondStatus() != 4) {
                                StLog.w(FastPairBaseController.TAG, "%s: already remove bond, no need to reconnect", stDevice.getDeviceName());
                                return;
                            }
                        }
                        break;
                    } else {
                        StLog.e(FastPairBaseController.TAG, "%s: no bonded device, should not happen", stDevice.getDeviceName());
                        return;
                    }
                default:
                    return;
            }
            FastPairBaseController.this.dealClickConnectMessage(message);
        }
    }

    public FastPairBaseController(Context context) {
        HandlerThread handlerThread = new HandlerThread("FastPair Handler");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mContext = context.getApplicationContext();
        SysActionManager.getInstance().registerSysAction(new SysActionManager.StateChangeSimpleCallback() {
            public void onBluetoothDisabled() {
                FastPairBaseController.this.onBluetoothDisabled();
            }
        });
    }

    public boolean checkFastPair(StDiscoveryDevice stDiscoveryDevice) {
        if (getPairing() || stDiscoveryDevice.getRssi() < -90 || FastPairRecord.getInstance().getPairRecord(stDiscoveryDevice.getIdentifier()) == stDiscoveryDevice.getBeaconId()) {
            return true;
        }
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDiscoveryDevice.getIdentifier());
        if (connectDevice == null) {
            return false;
        }
        return connectDevice.getDevice().isBleConnected() || connectDevice.getDevice().isP2pConnected();
    }

    public abstract void connectStDevice(StDevice stDevice);

    public abstract void dealAutoConnectTimeoutMessage(Message message);

    public abstract void dealBondFailMessage(Message message);

    public abstract void dealBondOkMessage(Message message);

    public abstract void dealClassicBondMessage(Message message);

    public abstract void dealClickCancelMessage(Message message);

    public abstract void dealClickConnectMessage(Message message);

    public abstract void dealConnectTimeoutMessage(Message message);

    public abstract void dealDismissWindowMessage(Message message);

    public abstract void dealDispatchToAppMessage(Message message);

    public abstract void dealRemoveBondMessage(Message message);

    public abstract void dealShowWindowMessage(Message message);

    public abstract boolean getPairing();

    public boolean isPopOrConnect(StDiscoveryDevice stDiscoveryDevice, int i) {
        if (i == 1) {
            StLog.d(TAG, "Direct Setup Connect");
            setPairing(true);
            this.mHandler.obtainMessage(3, stDiscoveryDevice).sendToTarget();
        } else if (i == 2) {
            StLog.d(TAG, "Trigger the Discovery toast");
            setPairing(true);
            FastPairRecord.getInstance().addPairRecord(stDiscoveryDevice.getIdentifier(), stDiscoveryDevice.getBeaconId());
            FastPairHandler fastPairHandler = this.mHandler;
            fastPairHandler.sendMessage(fastPairHandler.obtainMessage(1, stDiscoveryDevice));
        } else if (i != 3) {
            return i != 4;
        } else {
            FastPairHandler fastPairHandler2 = this.mHandler;
            fastPairHandler2.sendMessage(fastPairHandler2.obtainMessage(10, stDiscoveryDevice));
        }
    }

    public void onBluetoothDisabled() {
    }

    public abstract void setPairing(boolean z);

    public boolean startFastPair(StDiscoveryDevice stDiscoveryDevice) {
        if (checkFastPair(stDiscoveryDevice)) {
            return true;
        }
        return isPopOrConnect(stDiscoveryDevice, new BleAppJudgment(stDiscoveryDevice).isBlePop());
    }
}
