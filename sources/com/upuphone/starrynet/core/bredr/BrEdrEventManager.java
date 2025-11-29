package com.upuphone.starrynet.core.bredr;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadsetClientCall;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.HandlerThread;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.bredr.listener.IBrEdrActionStateCallback;
import com.upuphone.starrynet.core.bredr.listener.IBrEdrConnectStateCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BrEdrEventManager {
    private static final String TAG = "BrEdrEventManager";
    private static Context mContext;
    /* access modifiers changed from: private */
    public final List<IBrEdrActionStateCallback> mActionCallbacks;
    private final IntentFilter mAdapterIntentFilter;
    private final BroadcastReceiver mBroadcastReceiver;
    /* access modifiers changed from: private */
    public List<BluetoothHeadsetClientCall> mCallsList;
    /* access modifiers changed from: private */
    public final List<IBrEdrConnectStateCallback> mConnectCallbacks;
    /* access modifiers changed from: private */
    public final Map<String, Handler> mHandlerMap;
    /* access modifiers changed from: private */
    public android.os.Handler mWorkHandler;

    public class ActiveDeviceChangedHandler implements Handler {
        private ActiveDeviceChangedHandler() {
        }

        public void onReceive(Context context, Intent intent, BluetoothDevice bluetoothDevice) {
            int i;
            String action = intent.getAction();
            if (action != null) {
                if (bluetoothDevice == null) {
                    StLog.w(BrEdrEventManager.TAG, "ActiveDeviceChangedHandler: device is null action = " + action);
                } else {
                    StLog.d(BrEdrEventManager.TAG, "ActiveDeviceChangedHandler device = " + bluetoothDevice.getAddress() + " action = " + action);
                }
                if (action.equals("android.bluetooth.a2dp.profile.action.ACTIVE_DEVICE_CHANGED")) {
                    i = 2;
                } else if (action.equals("android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED")) {
                    i = 1;
                } else if (action.equals("android.bluetooth.hearingaid.profile.action.ACTIVE_DEVICE_CHANGED")) {
                    i = 21;
                } else {
                    return;
                }
                for (IBrEdrActionStateCallback onActiveDeviceChanged : BrEdrEventManager.this.mActionCallbacks) {
                    onActiveDeviceChanged.onActiveDeviceChanged(bluetoothDevice, i);
                }
            }
        }
    }

    public class BluetoothBroadcastReceiver extends BroadcastReceiver {
        private BluetoothBroadcastReceiver() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceive$0(String str, Context context, Intent intent, BluetoothDevice bluetoothDevice) {
            StLog.d(BrEdrEventManager.TAG, "BluetoothBroadcastReceiver handle action =" + str);
            Handler handler = (Handler) BrEdrEventManager.this.mHandlerMap.get(str);
            if (handler != null) {
                handler.onReceive(context, intent, bluetoothDevice);
            }
        }

        public void onReceive(Context context, Intent intent) {
            BrEdrEventManager.this.mWorkHandler.post(new a(this, intent.getAction(), context, intent, (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")));
        }
    }

    public class BondStateChangedHandler implements Handler {
        private BondStateChangedHandler() {
        }

        public void onReceive(Context context, Intent intent, BluetoothDevice bluetoothDevice) {
            if (bluetoothDevice != null) {
                int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
                int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", Integer.MIN_VALUE);
                StLog.d(BrEdrEventManager.TAG, "BondStateChangedHandler device = " + bluetoothDevice.getAddress() + " bondState = " + intExtra + " pre bond state = " + intExtra2);
                for (IBrEdrConnectStateCallback onBrEdrBondStateChanged : BrEdrEventManager.this.mConnectCallbacks) {
                    onBrEdrBondStateChanged.onBrEdrBondStateChanged(bluetoothDevice, intExtra, intExtra2);
                }
            }
        }
    }

    public class CallStateChangedHandler implements Handler {
        private CallStateChangedHandler() {
        }

        public void onReceive(Context context, Intent intent, BluetoothDevice bluetoothDevice) {
            BluetoothHeadsetClientCall bluetoothHeadsetClientCall;
            if (intent.getAction() == null) {
                StLog.w(BrEdrEventManager.TAG, "CallStateChangedHandler: action is null");
                return;
            }
            BluetoothHeadsetClientCall parcelableExtra = intent.getParcelableExtra("android.bluetooth.headsetclient.extra.CALL");
            if (parcelableExtra == null) {
                StLog.w(BrEdrEventManager.TAG, "CallStateChangedHandler: currentCall is null");
                return;
            }
            StLog.d(BrEdrEventManager.TAG, "state = " + parcelableExtra.getState() + ", number = " + parcelableExtra.getNumber());
            StringBuilder sb = new StringBuilder();
            sb.append("call = ");
            sb.append(parcelableExtra.toString());
            StLog.d(BrEdrEventManager.TAG, sb.toString());
            Iterator it = BrEdrEventManager.this.mCallsList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bluetoothHeadsetClientCall = null;
                    break;
                }
                bluetoothHeadsetClientCall = (BluetoothHeadsetClientCall) it.next();
                if (parcelableExtra.getNumber().equals(bluetoothHeadsetClientCall.getNumber())) {
                    break;
                }
            }
            if (bluetoothHeadsetClientCall == null) {
                BrEdrEventManager.this.mCallsList.add(parcelableExtra);
            } else if (bluetoothHeadsetClientCall.getState() != parcelableExtra.getState()) {
                BrEdrEventManager.this.mCallsList.remove(bluetoothHeadsetClientCall);
                if (parcelableExtra.getState() != 7) {
                    BrEdrEventManager.this.mCallsList.add(parcelableExtra);
                }
            } else {
                parcelableExtra = null;
            }
            if (parcelableExtra != null) {
                for (IBrEdrActionStateCallback onCallStateChanged : BrEdrEventManager.this.mActionCallbacks) {
                    onCallStateChanged.onCallStateChanged(parcelableExtra.getNumber(), BrEdrEventManager.this.getConstantCallState(parcelableExtra.getState()));
                }
            }
        }
    }

    public interface Handler {
        void onReceive(Context context, Intent intent, BluetoothDevice bluetoothDevice);
    }

    public static final class Holder {
        /* access modifiers changed from: private */
        public static final BrEdrEventManager INSTANCE = new BrEdrEventManager();

        private Holder() {
        }
    }

    public class ProfileConnectedChangedHandler implements Handler {
        private ProfileConnectedChangedHandler() {
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
            if (r4.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED") == false) goto L_0x002e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r8, android.content.Intent r9, android.bluetooth.BluetoothDevice r10) {
            /*
                r7 = this;
                r8 = 2
                r0 = 3
                r1 = 1
                r2 = 0
                java.lang.String r3 = "BrEdrEventManager"
                if (r10 != 0) goto L_0x000e
                java.lang.String r7 = "ProfileConnectedChangedHandler: device is null"
                com.upuphone.starrynet.common.StLog.w(r3, r7)
                return
            L_0x000e:
                java.lang.String r4 = r9.getAction()
                if (r4 != 0) goto L_0x001a
                java.lang.String r7 = "ProfileConnectedChangedHandler: action is null"
                com.upuphone.starrynet.common.StLog.w(r3, r7)
                return
            L_0x001a:
                java.lang.String r5 = "android.bluetooth.profile.extra.STATE"
                int r9 = r9.getIntExtra(r5, r2)
                if (r9 == r1) goto L_0x00a8
                if (r9 != r0) goto L_0x0026
                goto L_0x00a8
            L_0x0026:
                r5 = -1
                int r6 = r4.hashCode()
                switch(r6) {
                    case 40146574: goto L_0x004f;
                    case 448318136: goto L_0x0044;
                    case 545516589: goto L_0x0039;
                    case 1244161670: goto L_0x0030;
                    default: goto L_0x002e;
                }
            L_0x002e:
                r0 = r5
                goto L_0x0059
            L_0x0030:
                java.lang.String r2 = "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED"
                boolean r2 = r4.equals(r2)
                if (r2 != 0) goto L_0x0059
                goto L_0x002e
            L_0x0039:
                java.lang.String r0 = "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"
                boolean r0 = r4.equals(r0)
                if (r0 != 0) goto L_0x0042
                goto L_0x002e
            L_0x0042:
                r0 = r8
                goto L_0x0059
            L_0x0044:
                java.lang.String r0 = "android.bluetooth.headsetclient.profile.action.CONNECTION_STATE_CHANGED"
                boolean r0 = r4.equals(r0)
                if (r0 != 0) goto L_0x004d
                goto L_0x002e
            L_0x004d:
                r0 = r1
                goto L_0x0059
            L_0x004f:
                java.lang.String r0 = "android.bluetooth.a2dp-sink.profile.action.CONNECTION_STATE_CHANGED"
                boolean r0 = r4.equals(r0)
                if (r0 != 0) goto L_0x0058
                goto L_0x002e
            L_0x0058:
                r0 = r2
            L_0x0059:
                switch(r0) {
                    case 0: goto L_0x0072;
                    case 1: goto L_0x0071;
                    case 2: goto L_0x0071;
                    case 3: goto L_0x0072;
                    default: goto L_0x005c;
                }
            L_0x005c:
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = "ProfileConnectedChangedHandler: unknown action "
                r7.append(r8)
                r7.append(r4)
                java.lang.String r7 = r7.toString()
                com.upuphone.starrynet.common.StLog.w(r3, r7)
                return
            L_0x0071:
                r8 = r1
            L_0x0072:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "profile = "
                r0.append(r1)
                r0.append(r8)
                java.lang.String r1 = " state = "
                r0.append(r1)
                r0.append(r9)
                java.lang.String r0 = r0.toString()
                com.upuphone.starrynet.common.StLog.d(r3, r0)
                com.upuphone.starrynet.core.bredr.BrEdrEventManager r7 = com.upuphone.starrynet.core.bredr.BrEdrEventManager.this
                java.util.List r7 = r7.mConnectCallbacks
                java.util.Iterator r7 = r7.iterator()
            L_0x0098:
                boolean r0 = r7.hasNext()
                if (r0 == 0) goto L_0x00a8
                java.lang.Object r0 = r7.next()
                com.upuphone.starrynet.core.bredr.listener.IBrEdrConnectStateCallback r0 = (com.upuphone.starrynet.core.bredr.listener.IBrEdrConnectStateCallback) r0
                r0.onBrEdrProfileConnectStateChanged(r10, r8, r9)
                goto L_0x0098
            L_0x00a8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.core.bredr.BrEdrEventManager.ProfileConnectedChangedHandler.onReceive(android.content.Context, android.content.Intent, android.bluetooth.BluetoothDevice):void");
        }
    }

    /* access modifiers changed from: private */
    public int getConstantCallState(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            default:
                return 8;
        }
    }

    private int getConstantConnectState(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    return 0;
                }
            }
        }
        return i2;
    }

    public static BrEdrEventManager getInstance(Context context) {
        mContext = context;
        return Holder.INSTANCE;
    }

    private void registerIntentReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        mContext.registerReceiver(broadcastReceiver, intentFilter);
    }

    public void addHandler(String str, Handler handler) {
        this.mHandlerMap.put(str, handler);
        this.mAdapterIntentFilter.addAction(str);
    }

    public void brEdrServiceReady() {
        StLog.d(TAG, "brEdrServiceReady");
        for (IBrEdrConnectStateCallback onBrEdrServiceReady : this.mConnectCallbacks) {
            onBrEdrServiceReady.onBrEdrServiceReady();
        }
    }

    public Map<String, Integer> getCallList() {
        HashMap hashMap = new HashMap();
        for (BluetoothHeadsetClientCall next : this.mCallsList) {
            hashMap.put(next.getNumber(), Integer.valueOf(getConstantCallState(next.getState())));
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    public void pullPhoneBookChange(int i) {
        StLog.d(TAG, "pullPhoneBookChange");
        for (IBrEdrActionStateCallback onPullPhoneBookChanged : this.mActionCallbacks) {
            onPullPhoneBookChanged.onPullPhoneBookChanged(i);
        }
    }

    public void registerActionStateListener(IBrEdrActionStateCallback iBrEdrActionStateCallback) {
        this.mActionCallbacks.add(iBrEdrActionStateCallback);
    }

    public void registerConnectStateListener(IBrEdrConnectStateCallback iBrEdrConnectStateCallback) {
        this.mConnectCallbacks.add(iBrEdrConnectStateCallback);
    }

    public void unRegisterActionStateListener(IBrEdrActionStateCallback iBrEdrActionStateCallback) {
        this.mActionCallbacks.remove(iBrEdrActionStateCallback);
    }

    public void unRegisterConnectStateListener(IBrEdrConnectStateCallback iBrEdrConnectStateCallback) {
        this.mConnectCallbacks.remove(iBrEdrConnectStateCallback);
    }

    private BrEdrEventManager() {
        this.mActionCallbacks = new ArrayList();
        this.mConnectCallbacks = new ArrayList();
        BluetoothBroadcastReceiver bluetoothBroadcastReceiver = new BluetoothBroadcastReceiver();
        this.mBroadcastReceiver = bluetoothBroadcastReceiver;
        this.mCallsList = new ArrayList();
        this.mHandlerMap = new HashMap();
        IntentFilter intentFilter = new IntentFilter();
        this.mAdapterIntentFilter = intentFilter;
        HandlerThread handlerThread = new HandlerThread("BrEdrEventThread");
        handlerThread.start();
        this.mWorkHandler = new android.os.Handler(handlerThread.getLooper());
        addHandler("android.bluetooth.device.action.BOND_STATE_CHANGED", new BondStateChangedHandler());
        addHandler("android.bluetooth.a2dp.profile.action.ACTIVE_DEVICE_CHANGED", new ActiveDeviceChangedHandler());
        addHandler("android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED", new ActiveDeviceChangedHandler());
        addHandler("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED", new ProfileConnectedChangedHandler());
        addHandler("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED", new ProfileConnectedChangedHandler());
        addHandler("android.bluetooth.a2dp-sink.profile.action.CONNECTION_STATE_CHANGED", new ProfileConnectedChangedHandler());
        addHandler("android.bluetooth.headsetclient.profile.action.CONNECTION_STATE_CHANGED", new ProfileConnectedChangedHandler());
        if (Build.VERSION.SDK_INT < 33) {
            addHandler("android.bluetooth.headsetclient.profile.action.AG_CALL_CHANGED", new CallStateChangedHandler());
        }
        registerIntentReceiver(bluetoothBroadcastReceiver, intentFilter);
    }
}
