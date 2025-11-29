package com.upuphone.starrynet.strategy.protocol.starrynet;

import Starry.StarryLinkEncrypt;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.upuphone.starrynet.api.StBroadcast;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.StErrorTips;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.core.ap.WiFiApInfo;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IConnectChannel;
import com.upuphone.starrynet.strategy.channel.IMessageChannel;
import com.upuphone.starrynet.strategy.channel.IStarryNetChannel;
import com.upuphone.starrynet.strategy.channel.StarryNetChannelManager;
import com.upuphone.starrynet.strategy.channel.ap.ApChannel;
import com.upuphone.starrynet.strategy.channel.ap.StaChannel;
import com.upuphone.starrynet.strategy.channel.ble.BleServerChannel;
import com.upuphone.starrynet.strategy.channel.bredr.BrEdrChannel;
import com.upuphone.starrynet.strategy.channel.p2p.GcChannel;
import com.upuphone.starrynet.strategy.channel.spp.SppChannel;
import com.upuphone.starrynet.strategy.channel.spp.SppServerChannel;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.IStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.discovery.fastpair.FastPairUtil;
import com.upuphone.starrynet.strategy.encrypt.StarryLinkProtocolDataParseHelper;
import com.upuphone.starrynet.strategy.encrypt.StarryNetDecryptHelper;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptHelper;
import com.upuphone.starrynet.strategy.encrypt.utils.EncryptionUtil;
import com.upuphone.starrynet.strategy.netstack.XdpLinkManager;
import com.upuphone.starrynet.strategy.protocol.IProtocol;
import com.upuphone.starrynet.strategy.protocol.IProtocolCallback;
import com.upuphone.starrynet.strategy.utils.BleUtil;
import java.util.Iterator;
import java.util.Map;

@SuppressLint({"NewApi"})
abstract class StarryNetProtocolMessage implements IProtocol {
    protected static final int CREATE_BOND_WAIT_RETRY_TIMES = 20;
    protected static final int DELAY_CREATE_BOND_WAIT = 200;
    protected static final int DELAY_TIMEOUT_AUTH = 120000;
    protected static final int DELAY_XR_TIMEOUT_AUTH = 25000;
    protected static final int MSG_ON_AUTH = 3;
    protected static final int MSG_ON_AUTH_TIMEOUT = 2;
    protected static final int MSG_ON_CREATE_BOND_WAIT = 4;
    protected static final int MSG_STARR_NET = 1;
    protected static final String TAG = "StarryNetMessage";
    protected IProtocolCallback mCallback;
    protected final Context mContext = StarryNetData.getInstance().getApplicationContext();
    protected int mCreateBondWaitRetry = 20;
    protected final Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(@NonNull Message message) {
            StarryNetProtocolMessage.this.dealWithMessage(message);
        }
    };

    /* renamed from: com.upuphone.starrynet.strategy.protocol.starrynet.StarryNetProtocolMessage$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$Starry$StarryLinkEncrypt$COMMAND;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                Starry.StarryLinkEncrypt$COMMAND[] r0 = Starry.StarryLinkEncrypt.COMMAND.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$Starry$StarryLinkEncrypt$COMMAND = r0
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.AUTH_MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x001d }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.UN_BONDED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x0028 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.DISCONNECT_BLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x0033 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.SYNC_3RD_MAC     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x003e }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.CREATE_AP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x0049 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.CONNECT_AP     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x0054 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.CONNECTED_AP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x0060 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.DISCONNECT_AP     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x006c }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.DISCONNECTED_AP     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x0078 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.CONNECT_GO     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x0084 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.CONNECT_GC     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x0090 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.DISCONNECT_P2P     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x009c }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.PEERS_DISABLE_WIFI     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x00a8 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.PEERS_NAME_CHANGE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x00b4 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.SYNC_GC_IP     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x00c0 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.STARRY_NET_STACK     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.protocol.starrynet.StarryNetProtocolMessage.AnonymousClass3.<clinit>():void");
        }
    }

    private void dealConnectApMsg(StConnectDevice stConnectDevice, byte[] bArr) {
        StaChannel staChannel = (StaChannel) StarryNetChannelManager.getInstance().getConnectChannel(13);
        if (staChannel != null) {
            if (bArr == null) {
                StLog.d(TAG, "CONNECT_AP de data is null");
                return;
            }
            StarryLinkEncrypt.WifiApInfo parseWifiApInfo = StarryLinkProtocolDataParseHelper.parseWifiApInfo(bArr);
            if (parseWifiApInfo != null) {
                WiFiApInfo wiFiApInfo = new WiFiApInfo(parseWifiApInfo.getSsid(), parseWifiApInfo.getPsk(), parseWifiApInfo.getPort());
                wiFiApInfo.setIp(parseWifiApInfo.getIp());
                wiFiApInfo.setPeerId(stConnectDevice.getIdentifier());
                staChannel.connect(wiFiApInfo);
            }
        }
    }

    private void dealConnectGoMsg(StConnectDevice stConnectDevice, byte[] bArr) {
        if (isP2PGoRole()) {
            StErrorTips.showErrorTips(StErrorTips.ErrorTips.P2P_ALL_GO);
        }
        if (stConnectDevice == null) {
            StLog.d(TAG, "onConnectP2p device is null");
        } else if (bArr == null) {
            StLog.d(TAG, "onConnectP2p de data is null");
        } else {
            StarryLinkEncrypt.WifiGoInfo parseWifiGoInfoData = StarryLinkProtocolDataParseHelper.parseWifiGoInfoData(bArr);
            if (parseWifiGoInfoData == null) {
                StLog.d(TAG, "onConnectP2p goInfo is null");
                return;
            }
            String mac = parseWifiGoInfoData.getMac();
            String ssid = parseWifiGoInfoData.getSsid();
            String psk = parseWifiGoInfoData.getPsk();
            int freq = parseWifiGoInfoData.getFreq();
            int port = parseWifiGoInfoData.getPort();
            String address = parseWifiGoInfoData.getAddress();
            stConnectDevice.setWifiMac(mac);
            stConnectDevice.setPort(port);
            stConnectDevice.setFreq(freq);
            stConnectDevice.setSsid(ssid);
            stConnectDevice.setPwd(psk);
            stConnectDevice.setAddress(address);
            sysP2pMacAddress(stConnectDevice, parseWifiGoInfoData.getGcMac());
            IProtocolCallback iProtocolCallback = this.mCallback;
            if (iProtocolCallback != null) {
                iProtocolCallback.dealConnectP2P(stConnectDevice, this);
            }
        }
    }

    private void dealConnectedApMsg(StConnectDevice stConnectDevice, byte[] bArr) {
        if (((ApChannel) StarryNetChannelManager.getInstance().getConnectChannel(12)) != null) {
            if (bArr == null) {
                StLog.d(TAG, "onApConnected de data is null");
                return;
            }
            StarryLinkEncrypt.WifiStaInfo parseWifiStaInfo = StarryLinkProtocolDataParseHelper.parseWifiStaInfo(bArr);
            if (parseWifiStaInfo != null) {
                stConnectDevice.setAddress(parseWifiStaInfo.getIp());
                stConnectDevice.setWifiMac(parseWifiStaInfo.getMac());
                onConnected(stConnectDevice, 16);
            }
        }
    }

    private void dealCreateApMsg(StConnectDevice stConnectDevice) {
        ApChannel apChannel = (ApChannel) StarryNetChannelManager.getInstance().getConnectChannel(12);
        if (apChannel != null) {
            apChannel.createAp(stConnectDevice);
        }
    }

    private void dealDisconnectApMsg(StConnectDevice stConnectDevice, byte[] bArr) {
        StaChannel staChannel = (StaChannel) StarryNetChannelManager.getInstance().getConnectChannel(13);
        if (staChannel != null) {
            if (bArr == null) {
                StLog.d(TAG, "DISCONNECT_AP de data is null");
                return;
            }
            StarryLinkEncrypt.WifiApInfo parseWifiApInfo = StarryLinkProtocolDataParseHelper.parseWifiApInfo(bArr);
            if (parseWifiApInfo != null) {
                WiFiApInfo wiFiApInfo = new WiFiApInfo(parseWifiApInfo.getSsid(), parseWifiApInfo.getPsk(), parseWifiApInfo.getPort());
                wiFiApInfo.setPeerId(stConnectDevice.getIdentifier());
                staChannel.disconnect(wiFiApInfo.getSsid());
            }
        }
    }

    private void dealDisconnectedApMsg(StConnectDevice stConnectDevice, byte[] bArr) {
        if (((ApChannel) StarryNetChannelManager.getInstance().getConnectChannel(12)) != null) {
            if (bArr == null) {
                StLog.d(TAG, "onApConnected de data is null");
                return;
            }
            StarryLinkEncrypt.WifiStaInfo parseWifiStaInfo = StarryLinkProtocolDataParseHelper.parseWifiStaInfo(bArr);
            if (parseWifiStaInfo != null) {
                stConnectDevice.setAddress(parseWifiStaInfo.getIp());
                onDisconnected(stConnectDevice, 16);
            }
        }
    }

    private void dealGcConnectMsg(StConnectDevice stConnectDevice, byte[] bArr) {
        IProtocolCallback iProtocolCallback;
        if (!isP2PGoRole()) {
            StErrorTips.showErrorTips(StErrorTips.ErrorTips.P2P_ALL_GC);
        }
        if (bArr == null) {
            StLog.d(TAG, "CONNECT_GC de data is null");
            return;
        }
        StarryLinkEncrypt.WifiGcInfo parseWifiGcInfoData = StarryLinkProtocolDataParseHelper.parseWifiGcInfoData(bArr);
        if (parseWifiGcInfoData != null) {
            String mac = parseWifiGcInfoData.getMac();
            if (mac != null) {
                String lowerCase = mac.toLowerCase();
                StLog.d(TAG, "gc mac = " + lowerCase);
                stConnectDevice.setWifiMac(lowerCase);
            }
            if (parseWifiGcInfoData.getIsConnected() && (iProtocolCallback = this.mCallback) != null) {
                iProtocolCallback.dealConnectP2P(stConnectDevice, this);
            }
        }
    }

    private void dealGcDisconnectMsg(StConnectDevice stConnectDevice) {
        if (stConnectDevice == null) {
            StLog.d(TAG, "onConnectP2p info is null");
        } else {
            disconnect(stConnectDevice.getDevice(), 11);
        }
    }

    private void dealOnAuthMsg(Message message) {
        StConnectDevice stConnectDevice;
        byte[] data;
        this.mHandler.removeMessages(2);
        MsgObj msgObj = (MsgObj) message.obj;
        if (msgObj != null && (stConnectDevice = msgObj.device) != null) {
            StarryNetDecryptHelper starryNetDecryptHelper = msgObj.helper;
            if (!(starryNetDecryptHelper == null || (data = starryNetDecryptHelper.getData()) == null || data.length <= 0)) {
                stConnectDevice.setDeviceName(new String(data));
            }
            StarryDeviceManager.getInstance().updateBondInfo(stConnectDevice, 1);
            int i = StarryNetData.getInstance().getOwnDevice().getTerminalType() == 2 ? DELAY_XR_TIMEOUT_AUTH : 120000;
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(Message.obtain(handler, 2, msgObj), (long) i);
            StarryDeviceManager.getInstance().authDevice(stConnectDevice.getDevice());
        }
    }

    private void dealOnAuthTimeout(Message message) {
        StConnectDevice stConnectDevice;
        MsgObj msgObj = (MsgObj) message.obj;
        if (msgObj != null && (stConnectDevice = msgObj.device) != null) {
            IMessageChannel iMessageChannel = msgObj.channel;
            StDevice device = stConnectDevice.getDevice();
            if (iMessageChannel instanceof IConnectChannel) {
                ((IConnectChannel) iMessageChannel).disconnect(device);
            }
            StarryDeviceManager.getInstance().connectFail(device, StErrorCode.CONNECT_STRATEGY_BLE_AUTH_TIMEOUT, 1);
        }
    }

    private boolean dealStarryNetStackCmd(StConnectDevice stConnectDevice, byte[] bArr) {
        byte b = 0;
        if (!XdpLinkManager.getInstance().isSupportStarryNetStack()) {
            StLog.i(TAG, "self device don't support StarryNetStack! SKIP!");
            return false;
        }
        if (bArr != null && bArr.length > 0) {
            b = (byte) Utils.byteArrayToInt(bArr);
        }
        StLog.i(TAG, "dealStarryNetStackCmd remote device capacity:" + b);
        StarryDeviceManager.getInstance().getConnectDevice(stConnectDevice.getIdentifier()).setStarryNetStackCap(b);
        return true;
    }

    private void dealSyncThirdMac(StConnectDevice stConnectDevice, byte[] bArr) {
        BluetoothDevice bluetoothDevice;
        int i;
        if (StarryNetData.getInstance().getOwnDevice().getTerminalType() != 4) {
            BrEdrChannel brEdrChannel = (BrEdrChannel) StarryNetChannelManager.getInstance().getConnectChannel(21);
            if (brEdrChannel != null) {
                Map<BluetoothDevice, Integer> brEdrConnectedDeviceList = brEdrChannel.getBrEdrConnectedDeviceList();
                if (brEdrConnectedDeviceList == null || brEdrConnectedDeviceList.size() != 0) {
                    Iterator<Map.Entry<BluetoothDevice, Integer>> it = brEdrConnectedDeviceList.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            bluetoothDevice = null;
                            i = 0;
                            break;
                        }
                        Map.Entry next = it.next();
                        bluetoothDevice = (BluetoothDevice) next.getKey();
                        Integer num = (Integer) next.getValue();
                        if (bluetoothDevice != null && num != null && num.intValue() != 0) {
                            i = num.intValue();
                            break;
                        }
                    }
                    if (bluetoothDevice != null) {
                        String address = bluetoothDevice.getAddress();
                        if (!address.equals(BleUtil.DEFAULT_ADDRESS)) {
                            stConnectDevice.setBrEdrMac(address);
                            StarryDeviceManager.getInstance().updateBondInfo(stConnectDevice);
                            IStarryNetChannel readyChannel = getReadyChannel(stConnectDevice.getIdentifier2String());
                            if (readyChannel != null) {
                                readyChannel.sendMsg(stConnectDevice.getDevice(), StarryNetEncryptHelper.generate3rdBrEdrMac(EncryptionUtil.encrypt(Utils.getBytesFromAddress(address), stConnectDevice.getSecret(), stConnectDevice.getParam(), stConnectDevice.getEncrypt())), 10);
                            }
                        }
                        if ((i & 512) != 0) {
                            onConnected(stConnectDevice, 64);
                        }
                        if ((i & 1024) != 0) {
                            onConnected(stConnectDevice, 128);
                        }
                        if ((i & 2048) != 0) {
                            onConnected(stConnectDevice, 256);
                        }
                        StarryDeviceManager.getInstance().updateBondInfo(stConnectDevice, 48);
                    }
                }
            }
        } else if (bArr.length != 0) {
            byte[] decryptInfo = StarryNetDecryptHelper.decryptInfo(bArr, stConnectDevice.getCipher(), stConnectDevice.getEncrypt());
            if (decryptInfo == null) {
                StLog.d(TAG, "dealSyncThirdMac de data is null");
                return;
            }
            String addressStringFromByte = Utils.getAddressStringFromByte(decryptInfo);
            StLog.d(TAG, "dealSyncThirdMac owner br/edr mac = " + addressStringFromByte);
            if (!TextUtils.equals(addressStringFromByte, BleUtil.DEFAULT_ADDRESS)) {
                StarryNetData.getInstance().setBtMac(addressStringFromByte);
            }
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void dealWithMessage(Message message) {
        StConnectDevice stConnectDevice;
        int i = message.what;
        if (i == 1) {
            MsgObj msgObj = (MsgObj) message.obj;
            if (msgObj != null && (stConnectDevice = msgObj.device) != null) {
                dealStarryNetMsg(stConnectDevice, msgObj.channel, msgObj.helper);
            }
        } else if (i == 2) {
            dealOnAuthTimeout(message);
        } else if (i == 3) {
            dealOnAuthMsg(message);
        } else if (!onHandleMessage(message)) {
            StLog.d(TAG, "something maybe wrong, no handler deal with msg.what =" + message.what);
        }
    }

    public abstract int connect(StDevice stDevice, int i);

    public void dealGcIpMsg(StConnectDevice stConnectDevice, byte[] bArr) {
        String str = new String(bArr);
        StLog.d(TAG, "gc ip = " + str);
    }

    public void dealPeerNameChange(StConnectDevice stConnectDevice, byte[] bArr) {
        if (stConnectDevice == null) {
            StLog.d(TAG, "dealPeerNameChange info is null");
            return;
        }
        String str = new String(bArr);
        stConnectDevice.setDeviceName(str);
        StarryDeviceManager.getInstance().updateBondInfo(stConnectDevice);
        if (StarryNetData.getInstance().getOwnDevice().getTerminalType() != 4) {
            BluetoothUtils.setBluetoothDeviceAliasName(stConnectDevice.getBrEdrMac(), str);
        }
        Intent intent = new Intent();
        intent.setAction(StBroadcast.ACTION_STARRY_NET_DEVICE_NAME_CHANGED);
        intent.putExtra(StBroadcast.EXTRA_DEVICE_ID, stConnectDevice.getIdentifier2String());
        intent.putExtra(StBroadcast.EXTRA_DEVICE_NAME, stConnectDevice.getDeviceName());
        this.mContext.sendBroadcast(intent);
        StLog.d(TAG, "dealPeerNameChange, peerName = " + str);
    }

    public void dealPeerWifiDisable(StConnectDevice stConnectDevice) {
        if (stConnectDevice == null) {
            StLog.d(TAG, "onPeerWifiDisable info is null");
            return;
        }
        StLog.d(TAG, "onPeerWifiDisable");
        if (stConnectDevice.isProtocolConnected(4)) {
            disconnect(stConnectDevice.getDevice(), 10);
        }
        disconnect(stConnectDevice.getDevice(), 11);
    }

    public void dealStarryNetMsg(final StConnectDevice stConnectDevice, IMessageChannel iMessageChannel, StarryNetDecryptHelper starryNetDecryptHelper) {
        switch (AnonymousClass3.$SwitchMap$Starry$StarryLinkEncrypt$COMMAND[starryNetDecryptHelper.getCommand().ordinal()]) {
            case 1:
                StarryDeviceManager.getInstance().authDeviceMessage(stConnectDevice.getDevice(), starryNetDecryptHelper.getData());
                return;
            case 2:
                if (stConnectDevice.getTerminalType() == 6) {
                    this.mHandler.postDelayed(new Runnable() {
                        public void run() {
                            StLog.d(StarryNetProtocolMessage.TAG, "延时200ms 通知解绑消息，原因：立即解绑的化，收到un_bonded 的ack在iPhone可能不会及时收到");
                            StarryDeviceManager.getInstance().updateBondInfo(stConnectDevice, 0);
                        }
                    }, 200);
                    return;
                } else {
                    StarryDeviceManager.getInstance().updateBondInfo(stConnectDevice, 0);
                    return;
                }
            case 3:
                if (iMessageChannel instanceof BleServerChannel) {
                    IStarryNetDiscoverer discoveryManager = StarryNetData.getInstance().getDiscoveryManager();
                    discoveryManager.setCarActiveDisconnect(stConnectDevice.getIdentifier2String());
                    if (stConnectDevice.getTerminalType() == 9) {
                        discoveryManager.disableFastConnect();
                        discoveryManager.enableFastConnect();
                        return;
                    }
                    return;
                }
                return;
            case 4:
                dealSyncThirdMac(stConnectDevice, starryNetDecryptHelper.getData());
                return;
            case 5:
                dealCreateApMsg(stConnectDevice);
                return;
            case 6:
                dealConnectApMsg(stConnectDevice, starryNetDecryptHelper.getData(stConnectDevice.getCipher(), stConnectDevice.getEncrypt()));
                return;
            case 7:
                dealConnectedApMsg(stConnectDevice, starryNetDecryptHelper.getData(stConnectDevice.getCipher(), stConnectDevice.getEncrypt()));
                return;
            case 8:
                dealDisconnectApMsg(stConnectDevice, starryNetDecryptHelper.getData(stConnectDevice.getCipher(), stConnectDevice.getEncrypt()));
                return;
            case 9:
                dealDisconnectedApMsg(stConnectDevice, starryNetDecryptHelper.getData(stConnectDevice.getCipher(), stConnectDevice.getEncrypt()));
                return;
            case 10:
                dealConnectGoMsg(stConnectDevice, starryNetDecryptHelper.getData(stConnectDevice.getCipher(), stConnectDevice.getEncrypt()));
                return;
            case 11:
                dealGcConnectMsg(stConnectDevice, starryNetDecryptHelper.getData(stConnectDevice.getCipher(), stConnectDevice.getEncrypt()));
                return;
            case 12:
                dealGcDisconnectMsg(stConnectDevice);
                return;
            case 13:
                dealPeerWifiDisable(stConnectDevice);
                return;
            case 14:
                dealPeerNameChange(stConnectDevice, starryNetDecryptHelper.getData());
                return;
            case 15:
                dealGcIpMsg(stConnectDevice, starryNetDecryptHelper.getData());
                return;
            case 16:
                dealStarryNetStackCmd(stConnectDevice, starryNetDecryptHelper.getData());
                return;
            default:
                return;
        }
    }

    public abstract int disconnect(StDevice stDevice, int i);

    public boolean filterFastPairFlag(StConnectDevice stConnectDevice) {
        if (stConnectDevice != null && !TextUtils.isEmpty(stConnectDevice.getBrEdrMac())) {
            byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
            byte terminalType2 = stConnectDevice.getTerminalType();
            if (terminalType != 3 && terminalType2 != 3) {
                return (terminalType2 == 4 || terminalType2 == 6) ? false : true;
            }
            if (stConnectDevice.getBrEdrMac().equals(FastPairUtil.getFastPairFlag(this.mContext))) {
                FastPairUtil.saveFastPairFlag(this.mContext, (String) null);
            }
        }
        return false;
    }

    public String getP2pMacAddress() {
        GcChannel gcChannel = (GcChannel) StarryNetChannelManager.getInstance().getConnectChannel(11);
        if (gcChannel == null) {
            return null;
        }
        return gcChannel.getP2pMacAddress();
    }

    public abstract IStarryNetChannel getReadyChannel(String str);

    public boolean isP2PGoRole() {
        return false;
    }

    public void onConnected(StConnectDevice stConnectDevice, int i) {
        if (stConnectDevice != null) {
            StLog.v(TAG, "protocol onConnected device " + stConnectDevice + "  profile " + i);
            StarryDeviceManager.getInstance().deviceConnected(stConnectDevice, i);
            if ((i == 2 || i == 1) && filterFastPairFlag(stConnectDevice)) {
                StLog.d(TAG, "saveFastPairFlag");
                FastPairUtil.saveFastPairFlag(this.mContext, stConnectDevice.getBrEdrMac());
            }
            IProtocolCallback iProtocolCallback = this.mCallback;
            if (iProtocolCallback != null) {
                iProtocolCallback.onConnected(stConnectDevice, i, this);
            }
        }
    }

    public void onDisconnected(StConnectDevice stConnectDevice, int i) {
        if (stConnectDevice != null) {
            if (!stConnectDevice.isProtocolConnected(i)) {
                StLog.v(TAG, "protocol onDisconnected not connect, profile " + i);
                if (i == 2 || i == 1) {
                    StarryDeviceManager.getInstance().connectFail(stConnectDevice.getDevice(), StErrorCode.CONNECT_STRATEGY_BLE_BOND_FAIL, 1);
                }
            } else {
                StLog.v(TAG, "protocol onDisconnected device " + stConnectDevice + "  profile " + i);
                StarryDeviceManager.getInstance().deviceDisconnected(stConnectDevice, i);
                if (stConnectDevice.getBleBondStatus() == 0) {
                    StarryDeviceManager.getInstance().notifyBondChange(stConnectDevice, 0, 4);
                }
            }
            IProtocolCallback iProtocolCallback = this.mCallback;
            if (iProtocolCallback != null) {
                iProtocolCallback.onDisconnected(stConnectDevice, i, this);
            }
        }
    }

    public boolean onHandleMessage(Message message) {
        return false;
    }

    public void startSppServerListen(StConnectDevice stConnectDevice) {
        IConnectChannel connectChannel = StarryNetChannelManager.getInstance().getConnectChannel(24);
        if (connectChannel instanceof SppServerChannel) {
            ((SppServerChannel) connectChannel).startSppServerListen(stConnectDevice.getDevice());
        }
    }

    public void stopSppChannel(StConnectDevice stConnectDevice, int i) {
        IConnectChannel connectChannel = StarryNetChannelManager.getInstance().getConnectChannel(i);
        if (connectChannel instanceof SppChannel) {
            ((SppChannel) connectChannel).onBleDisconnected(stConnectDevice.getDevice());
        }
    }

    public void sysP2pMacAddress(StConnectDevice stConnectDevice, String str) {
        if (stConnectDevice == null || stConnectDevice.getCipher() == null) {
            StLog.i(TAG, "sysP2pMacAddress bond info is null");
        } else if (!SysActionManager.getInstance().isBtOn()) {
            StLog.i(TAG, "sysP2pMacAddress isBtOn off");
        } else {
            String p2pMacAddress = getP2pMacAddress();
            if (p2pMacAddress == null || p2pMacAddress.equals(str)) {
                StLog.i(TAG, "sysP2pMacAddress same or null,  mac = " + p2pMacAddress);
                return;
            }
            IStarryNetChannel readyChannel = getReadyChannel(stConnectDevice.getIdentifier2String());
            if (readyChannel != null) {
                readyChannel.sendMsg(stConnectDevice.getDevice(), StarryNetEncryptHelper.generateConnectGc(stConnectDevice.getCipher(), p2pMacAddress, false, stConnectDevice.getEncrypt()), 10);
            }
        }
    }

    public static class MsgObj {
        IMessageChannel channel;
        StConnectDevice device;
        StarryNetDecryptHelper helper;

        public MsgObj(StConnectDevice stConnectDevice, IMessageChannel iMessageChannel) {
            this.device = stConnectDevice;
            this.channel = iMessageChannel;
        }

        public MsgObj(StConnectDevice stConnectDevice, IMessageChannel iMessageChannel, StarryNetDecryptHelper starryNetDecryptHelper) {
            this.device = stConnectDevice;
            this.channel = iMessageChannel;
            this.helper = starryNetDecryptHelper;
        }
    }
}
