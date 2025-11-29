package com.xjsd.ai.assistant.connect;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.runasone.relay.error.RelayErrorCode;
import com.upuphone.xr.interconnect.SuperAppServiceManager;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceOperator;
import com.upuphone.xr.interconnect.api.StarryNetMessageOperator;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.DeviceBondStateListener;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.interconnect.outer.SuperServiceStateListener;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.factory.ThreadPoolFactory;
import com.xjsd.ai.assistant.core.util.DeDuplicateCopyOnWriteArrayList;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.log.ILog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

public final class InterconnectAbilityImpl implements InterconnectAbility {
    private static final String TAG = "InterconnectAbilityImpl";
    /* access modifiers changed from: private */
    public BluetoothHeadset headset;
    /* access modifiers changed from: private */
    public volatile boolean isStarryServiceEnable = false;
    /* access modifiers changed from: private */
    public volatile String mBondedDeviceId = null;
    /* access modifiers changed from: private */
    public volatile StarryNetDevice mConnectedDevice = null;
    /* access modifiers changed from: private */
    public Map<String, StarryNetDevice> mConnectedDeviceMap = new ConcurrentHashMap();
    private Context mContext;
    /* access modifiers changed from: private */
    public String mCurrentDispatchThreadName;
    private final DeviceBondStateListener mDeviceBondStateListener = new DeviceBondStateListener() {
        public void onDeviceBondStateChange(StarryNetDevice starryNetDevice, int i) throws RemoteException {
            ILog.a(InterconnectAbilityImpl.TAG, "onDeviceBondStateChange: device->" + starryNetDevice + ", state->" + i);
            if (i == 0 && starryNetDevice.getDeviceId().equals(InterconnectAbilityImpl.this.mBondedDeviceId)) {
                InterconnectAbilityImpl.this.cacheBondedDevice((String) null, true);
            }
        }
    };
    private final DeviceConnectionListener mDeviceConnectionListener = new DeviceConnectionListener() {
        public void onDeviceConnected(StarryNetDevice starryNetDevice) {
            ILog.a(InterconnectAbilityImpl.TAG, "onDeviceConnected: device->" + starryNetDevice);
            StarryNetDevice connectedDevice = InterconnectAbilityImpl.this.mDeviceOperator.getConnectedDevice();
            if (connectedDevice != null) {
                InterconnectAbilityImpl.this.mConnectedDeviceMap.put(connectedDevice.getDeviceId(), connectedDevice);
                if (InterconnectAbilityImpl.this.isMasterDevice(connectedDevice)) {
                    InterconnectAbilityImpl.this.mConnectedDevice = connectedDevice;
                    InterconnectAbilityImpl.this.cacheBondedDevice(connectedDevice.getDeviceId(), true);
                    InterconnectAbilityImpl.this.notifyDeviceStateChanged(starryNetDevice, true);
                }
            }
        }

        public void onDeviceDisconnected(StarryNetDevice starryNetDevice) {
            ILog.a(InterconnectAbilityImpl.TAG, "onDeviceDisconnected: device->" + starryNetDevice);
            InterconnectAbilityImpl.this.mConnectedDeviceMap.remove(starryNetDevice.getDeviceId());
            if (InterconnectAbilityImpl.this.mConnectedDevice != null && InterconnectAbilityImpl.this.mConnectedDevice.getDeviceId().equals(starryNetDevice.getDeviceId())) {
                InterconnectAbilityImpl.this.mConnectedDevice = null;
                InterconnectAbilityImpl.this.notifyDeviceStateChanged(starryNetDevice, false);
            }
        }
    };
    /* access modifiers changed from: private */
    public volatile StarryNetDeviceOperator mDeviceOperator;
    /* access modifiers changed from: private */
    public Map<Integer, String> mErrorMap;
    /* access modifiers changed from: private */
    public final ExecutorService mExecutorService = ThreadPoolFactory.b("MSG");
    private volatile StarryNetMessageOperator mMessageOperator;
    private final MessageReceiver mMessageReceiver = new MessageReceiver() {
        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onMessageReceive$0(OnReceiveRemoteMsgListener onReceiveRemoteMsgListener, StarryNetMessage starryNetMessage) {
            String name = Thread.currentThread().getName();
            if (!name.equals(InterconnectAbilityImpl.this.mCurrentDispatchThreadName)) {
                InterconnectAbilityImpl.this.mCurrentDispatchThreadName = name;
                ILog.j(InterconnectAbilityImpl.TAG, "当前分发互联消息线程名称->" + name);
            }
            onReceiveRemoteMsgListener.a(starryNetMessage);
        }

        public void onMessageReceive(StarryNetMessage starryNetMessage) {
            ILog.a(InterconnectAbilityImpl.TAG, "收到远端消息id->" + starryNetMessage.getId() + ", from->" + starryNetMessage.getSenderPkg() + ", message->" + starryNetMessage.getMessage());
            for (OnReceiveRemoteMsgListener aVar : InterconnectAbilityImpl.this.mOnReceiveRemoteMsgListeners) {
                InterconnectAbilityImpl.this.mExecutorService.execute(new a(this, aVar, starryNetMessage));
            }
        }
    };
    private List<OnDeviceStateChangeListener> mOnDeviceStateChangeListeners = new DeDuplicateCopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public List<OnReceiveRemoteMsgListener> mOnReceiveRemoteMsgListeners = new DeDuplicateCopyOnWriteArrayList();
    private volatile OperatorManager mOperatorManager = null;
    private final SendMessageListener mSendMessageListener = new SendMessageListener() {
        public void onFail(String str, int i) throws RemoteException {
            ILog.a(InterconnectAbilityImpl.TAG, "onFail msgId->" + str + ", errorCode->" + i);
            SendMsgCallback sendMsgCallback = (SendMsgCallback) InterconnectAbilityImpl.this.mSendMsgCallbackMap.remove(str);
            if (sendMsgCallback != null) {
                sendMsgCallback.onFail(i, (String) Optional.ofNullable((String) InterconnectAbilityImpl.this.mErrorMap.get(Integer.valueOf(i))).orElse("发送失败，请参照https://yx02k6dhtb.feishu.cn/wiki/wikcnT4DuQ2vv7NcT0YHehBALyb"));
            }
        }

        public void onSuccess(String str) throws RemoteException {
            ILog.a(InterconnectAbilityImpl.TAG, "onSuccess msgId->" + str);
            SendMsgCallback sendMsgCallback = (SendMsgCallback) InterconnectAbilityImpl.this.mSendMsgCallbackMap.remove(str);
            if (sendMsgCallback != null) {
                sendMsgCallback.onSuccess();
            }
        }
    };
    /* access modifiers changed from: private */
    public Map<String, SendMsgCallback> mSendMsgCallbackMap = new HashMap();
    private String mSenderPkg = "";

    public InterconnectAbilityImpl() {
        HashMap hashMap = new HashMap();
        this.mErrorMap = hashMap;
        hashMap.put(Integer.valueOf(RelayErrorCode.UN_INIT), RelayErrorCode.UN_INIT_TEXT);
        this.mErrorMap.put(Integer.valueOf(RelayErrorCode.BINDER_UN_CONNECT), "对端设备应用未启动");
        this.mErrorMap.put(Integer.valueOf(RelayErrorCode.START_REMOTE_TIMEOUT), RelayErrorCode.START_REMOTE_TIMEOUT_TEXT);
        this.mErrorMap.put(Integer.valueOf(RelayErrorCode.NOT_FOUND_ACTIVITY), RelayErrorCode.NOT_FOUND_ACTIVITY_TEXT);
        this.mErrorMap.put(Integer.valueOf(RelayErrorCode.SEND_MESSAGE_TIMEOUT), RelayErrorCode.SEND_MESSAGE_TIMEOUT_TEXT);
        this.mErrorMap.put(Integer.valueOf(RelayErrorCode.DEVICE_DISCONNECT), RelayErrorCode.DEVICE_DISCONNECT_TEXT);
        this.mErrorMap.put(Integer.valueOf(RelayErrorCode.APP_NOT_INSTALL), RelayErrorCode.APP_NOT_INSTALL_TEXT);
        this.mErrorMap.put(Integer.valueOf(RelayErrorCode.APP_UNINSTALL), RelayErrorCode.APP_UNINSTALL_TEXT);
        this.mErrorMap.put(Integer.valueOf(RelayErrorCode.MSG_TOO_LONG), RelayErrorCode.MSG_TOO_LONG_TEXT);
        this.mErrorMap.put(Integer.valueOf(RelayErrorCode.BINDER_ERROR), "binder方法调用失败");
        this.mErrorMap.put(Integer.valueOf(RelayErrorCode.MESSAGE_IS_NULL), "发送消息为空");
        this.mErrorMap.put(Integer.valueOf(RelayErrorCode.STARRY_TAG_IS_NULL), RelayErrorCode.STARRY_TAG_IS_NULL_TEXT);
    }

    /* access modifiers changed from: private */
    public void cacheBondedDevice(String str, boolean z) {
        this.mBondedDeviceId = str;
        DeviceUtils.k(this.mBondedDeviceId);
        if (z) {
            this.mContext.getSharedPreferences("assistant", 0).edit().putString("bondedDeviceId", this.mBondedDeviceId);
        }
    }

    private void getBondedDevice() {
        cacheBondedDevice(this.mContext.getSharedPreferences("assistant", 0).getString("bondedDeviceId", (String) null), false);
    }

    private void initProfileProxy(Context context) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            defaultAdapter.getProfileProxy(context, new BluetoothProfile.ServiceListener() {
                public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                    ILog.a(InterconnectAbilityImpl.TAG, "bluetooth profile onServiceConnected, profile->" + i);
                    if (i == 1) {
                        InterconnectAbilityImpl.this.headset = (BluetoothHeadset) bluetoothProfile;
                    }
                }

                public void onServiceDisconnected(int i) {
                    ILog.a(InterconnectAbilityImpl.TAG, "bluetooth profile onServiceDisconnected, profile->" + i);
                    if (i == 1) {
                        InterconnectAbilityImpl.this.headset = null;
                    }
                }
            }, 1);
        }
    }

    /* access modifiers changed from: private */
    public boolean isMasterDevice(StarryNetDevice starryNetDevice) {
        byte terminalType = starryNetDevice.getTerminalType();
        return terminalType == 1 || terminalType == 2 || terminalType == 4 || terminalType == 6;
    }

    private boolean isReady() {
        return this.isStarryServiceEnable && this.mConnectedDevice != null;
    }

    /* access modifiers changed from: private */
    public void notifyDeviceStateChanged(StarryNetDevice starryNetDevice, boolean z) {
        if (z) {
            DeviceUtils.m(starryNetDevice.getModelId());
            DeviceUtils.l(starryNetDevice.getDeviceId());
        } else {
            DeviceUtils.m("");
            DeviceUtils.l("");
        }
        for (OnDeviceStateChangeListener a2 : this.mOnDeviceStateChangeListeners) {
            a2.a(starryNetDevice, z);
        }
    }

    @SuppressLint({"MissingPermission"})
    public Boolean bluetoothScoState() {
        if (this.headset == null || this.mConnectedDevice == null) {
            return Boolean.FALSE;
        }
        int connectionState = this.headset.getConnectionState(BluetoothAdapter.getDefaultAdapter().getRemoteDevice(this.mConnectedDevice.getBleMac()));
        ILog.a(TAG, "bluetooth Sco State: " + connectionState);
        return Boolean.valueOf(connectionState == 2);
    }

    public OperatorManager getOperatorManager() {
        return this.mOperatorManager;
    }

    public void init(Context context, @Nullable String str, int i) {
        this.mContext = context;
        getBondedDevice();
        if (i == 0) {
            ILog.j(TAG, "独立应用初始化互联服务");
            this.mSenderPkg = context.getPackageName();
            this.mOperatorManager = SuperAppServiceManager.getInstance().init(context, new SuperServiceStateListener() {
                public void onServiceConnected() {
                    ILog.a(InterconnectAbilityImpl.TAG, "interconnect service is connected");
                    InterconnectAbilityImpl.this.isStarryServiceEnable = true;
                }

                public void onServiceDied() {
                    ILog.a(InterconnectAbilityImpl.TAG, "interconnect service is died");
                    InterconnectAbilityImpl.this.isStarryServiceEnable = false;
                }
            }, 1);
            register(this.mOperatorManager);
        } else if (i == 1) {
            ILog.j(TAG, "模块（非独立进程）初始化互联服务");
            this.mSenderPkg = str;
            this.mOperatorManager = SuperAppServiceManager.getInstance().init(str);
            register(this.mOperatorManager);
            this.isStarryServiceEnable = true;
        } else if (i == 2) {
            ILog.j(TAG, "模块（独立进程）初始化互联服务");
            this.mSenderPkg = str;
            this.mOperatorManager = SuperAppServiceManager.getInstance().init(context, str, (SuperServiceStateListener) new SuperServiceStateListener() {
                public void onServiceConnected() {
                    ILog.j(InterconnectAbilityImpl.TAG, "interconnect service is connected");
                    InterconnectAbilityImpl.this.isStarryServiceEnable = true;
                }

                public void onServiceDied() {
                    ILog.j(InterconnectAbilityImpl.TAG, "interconnect service is died");
                    InterconnectAbilityImpl.this.isStarryServiceEnable = false;
                }
            }, 1);
            register(this.mOperatorManager);
        }
    }

    public /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    public /* bridge */ /* synthetic */ void register() {
        super.register();
    }

    public void registerOnDeviceStateChangeListener(@NonNull OnDeviceStateChangeListener onDeviceStateChangeListener) {
        this.mOnDeviceStateChangeListeners.add(onDeviceStateChangeListener);
        if (this.mConnectedDevice != null) {
            onDeviceStateChangeListener.a(this.mConnectedDevice, true);
        }
    }

    public void registerOnReceiveRemoteMsgListener(@NonNull OnReceiveRemoteMsgListener onReceiveRemoteMsgListener) {
        ILog.a(TAG, "registerOnReceiveRemoteMsgListener->" + onReceiveRemoteMsgListener);
        this.mOnReceiveRemoteMsgListeners.add(onReceiveRemoteMsgListener);
    }

    public void send(@NonNull String str, @Nullable SendMsgCallback sendMsgCallback) {
        if (isReady()) {
            StarryNetMessage starryNetMessage = new StarryNetMessage();
            starryNetMessage.setReceiverPkg(this.mSenderPkg);
            starryNetMessage.setMessage(str);
            send(starryNetMessage, sendMsgCallback);
            return;
        }
        ILog.a(TAG, "no connected device currently");
        if (sendMsgCallback != null) {
            sendMsgCallback.onFail(-1, "无设备连接，不能发送消息");
        }
    }

    public void unregisterOnDeviceStateChangeListener(@NonNull OnDeviceStateChangeListener onDeviceStateChangeListener) {
        this.mOnDeviceStateChangeListeners.remove(onDeviceStateChangeListener);
    }

    public void unregisterOnReceiveRemoteMsgListener(@NonNull OnReceiveRemoteMsgListener onReceiveRemoteMsgListener) {
        ILog.a(TAG, "unregisterOnReceiveRemoteMsgListener->" + onReceiveRemoteMsgListener);
        this.mOnReceiveRemoteMsgListeners.remove(onReceiveRemoteMsgListener);
    }

    private void register(OperatorManager operatorManager) {
        this.mDeviceOperator = operatorManager.getDeviceOperator();
        this.mMessageOperator = operatorManager.getMessageOperator();
        this.mDeviceOperator.registerDeviceConnectionListener(this.mDeviceConnectionListener);
        this.mDeviceOperator.registerDeviceBondStateListener(this.mDeviceBondStateListener);
        this.mMessageOperator.registerMessageReceiver(this.mMessageReceiver);
        initProfileProxy(ContextHelper.a());
    }

    public void send(@NonNull byte[] bArr, @Nullable SendMsgCallback sendMsgCallback) {
        if (isReady()) {
            StarryNetMessage starryNetMessage = new StarryNetMessage();
            starryNetMessage.setReceiverPkg(this.mSenderPkg);
            starryNetMessage.setMessage("");
            starryNetMessage.setData(bArr);
            send(starryNetMessage, sendMsgCallback);
            return;
        }
        ILog.a(TAG, "no connected device currently");
        if (sendMsgCallback != null) {
            sendMsgCallback.onFail(-1, "无设备连接，不能发送消息");
        }
    }

    public void send(@NonNull StarryNetMessage starryNetMessage, @Nullable SendMsgCallback sendMsgCallback) {
        if (isReady()) {
            if (starryNetMessage.getMessage() != null) {
                ILog.a(TAG, "send message: " + starryNetMessage.getMessage());
            }
            if (starryNetMessage.getData() != null) {
                ILog.a(TAG, "send byte[] len: " + starryNetMessage.getData().length);
            }
            if (sendMsgCallback != null) {
                String sendMessage2 = this.mMessageOperator.sendMessage2(starryNetMessage, this.mSendMessageListener);
                if ("-1".equals(sendMessage2)) {
                    sendMsgCallback.onFail(-1, "调用xr-sdk失败");
                } else {
                    this.mSendMsgCallbackMap.put(sendMessage2, sendMsgCallback);
                }
            } else {
                this.mMessageOperator.sendMessage2(starryNetMessage, (SendMessageListener) null);
            }
        } else {
            ILog.a(TAG, "no connected device currently");
            if (sendMsgCallback != null) {
                sendMsgCallback.onFail(-1, "无设备连接，不能发送消息");
            }
        }
    }
}
