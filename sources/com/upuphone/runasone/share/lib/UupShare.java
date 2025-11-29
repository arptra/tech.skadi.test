package com.upuphone.runasone.share.lib;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ProtocolStringList;
import com.honey.account.m6.e;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.AbilityMessage;
import com.upuphone.runasone.host.core.api.ComponentProperty;
import com.upuphone.runasone.host.core.api.IAbilitySlot;
import com.upuphone.runasone.share.api.IHubUupShareAdapter;
import com.upuphone.runasone.share.lib.ShareApi;
import com.upuphone.runasone.share.lib.listener.IShareMessageListener;
import com.upuphone.runasone.share.lib.utils.LogUtil;
import com.upuphone.runasone.share.lib.utils.Utils;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

public class UupShare implements IAbilitySlot {
    private static final String TAG = "UupShare";
    private static UupShare instance = new UupShare();
    private IHubUupShareAdapter adapter;
    public UupShareService mService;
    private IAbilitySlot.SlotObserver mSlotObserver;
    private StarryDevice mStarryDevice;
    private Map<String, IAbilitySlot.SlotObserver> slotObserverMap = new HashMap();

    /* renamed from: com.upuphone.runasone.share.lib.UupShare$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$upuphone$runasone$share$lib$ShareApi$StreamType;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.upuphone.runasone.share.lib.ShareApi$StreamType[] r0 = com.upuphone.runasone.share.lib.ShareApi.StreamType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$upuphone$runasone$share$lib$ShareApi$StreamType = r0
                com.upuphone.runasone.share.lib.ShareApi$StreamType r1 = com.upuphone.runasone.share.lib.ShareApi.StreamType.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$upuphone$runasone$share$lib$ShareApi$StreamType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.upuphone.runasone.share.lib.ShareApi$StreamType r1 = com.upuphone.runasone.share.lib.ShareApi.StreamType.PULL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$upuphone$runasone$share$lib$ShareApi$StreamType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.upuphone.runasone.share.lib.ShareApi$StreamType r1 = com.upuphone.runasone.share.lib.ShareApi.StreamType.SIGNAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$upuphone$runasone$share$lib$ShareApi$StreamType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.upuphone.runasone.share.lib.ShareApi$StreamType r1 = com.upuphone.runasone.share.lib.ShareApi.StreamType.CANCEL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$upuphone$runasone$share$lib$ShareApi$StreamType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.upuphone.runasone.share.lib.ShareApi$StreamType r1 = com.upuphone.runasone.share.lib.ShareApi.StreamType.SENDER_SYN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$upuphone$runasone$share$lib$ShareApi$StreamType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.upuphone.runasone.share.lib.ShareApi$StreamType r1 = com.upuphone.runasone.share.lib.ShareApi.StreamType.RECEIVER_ACK     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$upuphone$runasone$share$lib$ShareApi$StreamType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.upuphone.runasone.share.lib.ShareApi$StreamType r1 = com.upuphone.runasone.share.lib.ShareApi.StreamType.SENDER_DATA     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$upuphone$runasone$share$lib$ShareApi$StreamType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.upuphone.runasone.share.lib.ShareApi$StreamType r1 = com.upuphone.runasone.share.lib.ShareApi.StreamType.SENDER_FINISH     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$upuphone$runasone$share$lib$ShareApi$StreamType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.upuphone.runasone.share.lib.ShareApi$StreamType r1 = com.upuphone.runasone.share.lib.ShareApi.StreamType.RECEIVER_FINISH     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$upuphone$runasone$share$lib$ShareApi$StreamType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.upuphone.runasone.share.lib.ShareApi$StreamType r1 = com.upuphone.runasone.share.lib.ShareApi.StreamType.SENDER_CANCEL     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$upuphone$runasone$share$lib$ShareApi$StreamType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.upuphone.runasone.share.lib.ShareApi$StreamType r1 = com.upuphone.runasone.share.lib.ShareApi.StreamType.RECEIVER_CANCEL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$upuphone$runasone$share$lib$ShareApi$StreamType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.upuphone.runasone.share.lib.ShareApi$StreamType r1 = com.upuphone.runasone.share.lib.ShareApi.StreamType.SENDER_FAIL     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$upuphone$runasone$share$lib$ShareApi$StreamType     // Catch:{ NoSuchFieldError -> 0x009c }
                com.upuphone.runasone.share.lib.ShareApi$StreamType r1 = com.upuphone.runasone.share.lib.ShareApi.StreamType.RECEIVER_FAIL     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$upuphone$runasone$share$lib$ShareApi$StreamType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.upuphone.runasone.share.lib.ShareApi$StreamType r1 = com.upuphone.runasone.share.lib.ShareApi.StreamType.RECEIVE_OTA_FINISH     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$upuphone$runasone$share$lib$ShareApi$StreamType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.upuphone.runasone.share.lib.ShareApi$StreamType r1 = com.upuphone.runasone.share.lib.ShareApi.StreamType.RECEIVER_DATA_ACK     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.share.lib.UupShare.AnonymousClass1.<clinit>():void");
        }
    }

    public static class shareMessageListener implements IShareMessageListener {
        private WeakReference<UupShare> mReferShare;

        public shareMessageListener(UupShare uupShare) {
            this.mReferShare = new WeakReference<>(uupShare);
        }

        public boolean sendMessageToShare(Bundle bundle) {
            UupShare uupShare;
            Log.d(UupShare.TAG, "sendMessageToShare");
            WeakReference<UupShare> weakReference = this.mReferShare;
            if (weakReference == null || (uupShare = weakReference.get()) == null) {
                return false;
            }
            return uupShare.sendMessageToShare(bundle);
        }

        public void startSendFile(String str) {
            UupShare uupShare;
            Log.d(UupShare.TAG, "startSendFile");
            WeakReference<UupShare> weakReference = this.mReferShare;
            if (weakReference != null && (uupShare = weakReference.get()) != null) {
                uupShare.startSendFile(str);
            }
        }

        public boolean startShare(Bundle bundle) {
            UupShare uupShare;
            Log.d(UupShare.TAG, "startShare");
            WeakReference<UupShare> weakReference = this.mReferShare;
            if (weakReference == null || (uupShare = weakReference.get()) == null) {
                return false;
            }
            return uupShare.startShare(bundle);
        }
    }

    private UupShare() {
    }

    public static UupShare getInstance() {
        return instance;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$changeDeviceBleMode$0(Object obj) {
    }

    public void appStateChanged(int i, String str, String str2, int i2) {
    }

    public void attach(StarryDevice starryDevice, IAbilitySlot.SlotObserver slotObserver, ComponentProperty componentProperty) {
        LogUtil.d(TAG, "attach" + starryDevice.getId());
        this.mStarryDevice = starryDevice;
        this.mSlotObserver = slotObserver;
        this.slotObserverMap.put(starryDevice.getId(), this.mSlotObserver);
        BleTransferSendDelegate.getInstance().attachObserver(this.mStarryDevice);
    }

    public void changeDeviceBleMode(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(RtspHeaders.Values.MODE, i);
        IAbilitySlot.SlotObserver slotObserver = this.slotObserverMap.get(str);
        if (slotObserver == null) {
            slotObserver = this.mSlotObserver;
        }
        if (slotObserver == null) {
            LogUtil.d(TAG, "the slotObserver is null ,must be something wrong");
        } else {
            slotObserver.commonFun(1, bundle, new e());
        }
    }

    public void detach(StarryDevice starryDevice) {
        LogUtil.d(TAG, "detach");
        this.slotObserverMap.remove(starryDevice.getId());
        BleTransferSendDelegate.getInstance().detachObserver(this.mStarryDevice);
    }

    public IAbilitySlot.SlotObserver getmSlotObserver(String str) {
        IAbilitySlot.SlotObserver slotObserver = this.slotObserverMap.get(str);
        return slotObserver == null ? this.mSlotObserver : slotObserver;
    }

    public void input(StarryDevice starryDevice, AbilityMessage abilityMessage) {
        LogUtil.d(TAG, "input");
        try {
            ShareApi.Message parseFrom = ShareApi.Message.parseFrom(abilityMessage.getBypass());
            switch (AnonymousClass1.$SwitchMap$com$upuphone$runasone$share$lib$ShareApi$StreamType[parseFrom.getType().ordinal()]) {
                case 1:
                    OtaTransferReceiverDelegate.getInstance().callBackStart(parseFrom, starryDevice);
                    return;
                case 2:
                    ProtocolStringList<String> pathsList = parseFrom.getPathsList();
                    Uri[] uriArr = new Uri[pathsList.size()];
                    int i = 0;
                    for (String str : pathsList) {
                        uriArr[i] = Uri.parse("file:" + str);
                        i++;
                    }
                    String taskId = parseFrom.getTaskId();
                    String ipAddress = TextUtils.isEmpty(starryDevice.getAddress()) ? parseFrom.getIpAddress() : starryDevice.getAddress();
                    OtaTransferSendDelegate.getIntense().putStorage(taskId, parseFrom.getDirPath());
                    OtaTransferSendDelegate.getIntense().setFiles(uriArr, taskId);
                    OtaTransferSendDelegate.getIntense().connectToServer(taskId, ipAddress, parseFrom.getPort());
                    OtaTransferSendDelegate.getIntense().sendFiles(taskId, "");
                    return;
                case 3:
                    String ipAddress2 = TextUtils.isEmpty(starryDevice.getAddress()) ? parseFrom.getIpAddress() : starryDevice.getAddress();
                    int port = parseFrom.getPort();
                    String fileResumeInfo = parseFrom.getFileResumeInfo();
                    OtaTransferSendDelegate.getIntense().connectToServer(parseFrom.getTaskId(), ipAddress2, port);
                    OtaTransferSendDelegate.getIntense().sendFiles(parseFrom.getTaskId(), fileResumeInfo);
                    return;
                case 4:
                    if (parseFrom.getStatus() == 3) {
                        OtaTransferSendDelegate.getIntense().notifyCancel(parseFrom.getTaskId());
                        return;
                    } else {
                        OtaTransferReceiverDelegate.getInstance().notifyCancel(parseFrom.getTaskId());
                        return;
                    }
                case 5:
                    BleTransferReceiverDelegate.getInstance().processSynMessage(parseFrom, starryDevice);
                    return;
                case 6:
                    BleTransferSendDelegate.getInstance().processAckMessage(parseFrom);
                    return;
                case 7:
                    BleTransferReceiverDelegate.getInstance().processChunkData(parseFrom);
                    return;
                case 8:
                    BleTransferReceiverDelegate.getInstance().processCompleteMessage(parseFrom);
                    return;
                case 9:
                    BleTransferSendDelegate.getInstance().processReceiveFinishMessage(parseFrom);
                    return;
                case 10:
                    BleTransferReceiverDelegate.getInstance().processSendCancelMessage(parseFrom);
                    return;
                case 11:
                    BleTransferSendDelegate.getInstance().processReceiverCancelMessage(parseFrom);
                    return;
                case 12:
                    BleTransferReceiverDelegate.getInstance().processSendFailMessage(parseFrom);
                    return;
                case 13:
                    BleTransferSendDelegate.getInstance().processReceiverFailMessage(parseFrom);
                    return;
                case 14:
                    OtaTransferSendDelegate.getIntense().processReceiverFinishMessage(parseFrom.getTaskId());
                    return;
                case 15:
                    BleTransferSendDelegate.getInstance().sendNextChunkData(parseFrom.getTaskId(), parseFrom.getChunkEnd());
                    return;
                default:
                    return;
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

    public void install(Context context) {
        UupShareService uupShareService = new UupShareService(context.getApplicationContext(), new shareMessageListener(this));
        this.mService = uupShareService;
        this.adapter = new IHubUupShareAdapter(uupShareService);
    }

    public void outputMessage(StarryDevice starryDevice, ShareApi.Message message) {
        if (starryDevice == null) {
            starryDevice = this.mStarryDevice;
        }
        IAbilitySlot.SlotObserver slotObserver = this.slotObserverMap.get(starryDevice.getId());
        if (slotObserver == null) {
            LogUtil.d(TAG, "the slotObserver is null ,must be something wrong");
        } else {
            slotObserver.output(starryDevice, new AbilityMessage(message.toByteArray()));
        }
    }

    public void sendMessageOfCancel(String str, int i) {
        StarryDevice deviceByTaskId = OtaTransferReceiverDelegate.getInstance().getDeviceByTaskId(str);
        if (deviceByTaskId == null) {
            deviceByTaskId = this.mStarryDevice;
        }
        IAbilitySlot.SlotObserver slotObserver = this.slotObserverMap.get(deviceByTaskId.getId());
        if (slotObserver == null) {
            slotObserver = this.mSlotObserver;
        }
        slotObserver.output(deviceByTaskId, new AbilityMessage(ShareApi.Message.newBuilder().setType(ShareApi.StreamType.CANCEL).setStatus(i).setTaskId(str).build().toByteArray()));
    }

    public boolean sendMessageToShare(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, bundle.getStringArray("paths"));
        String string = bundle.getString("dirPath");
        String string2 = bundle.getString("taskId");
        OtaTransferReceiverDelegate.getInstance().callBackStart(ShareApi.Message.newBuilder().setTaskId(string2).setPackageName(bundle.getString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME)).build(), this.mStarryDevice);
        OtaTransferReceiverDelegate.getInstance().confirmReceive(string2);
        ShareApi.Message build = ShareApi.Message.newBuilder().setType(ShareApi.StreamType.PULL).setOperator(1).setDirPath(string).setTaskId(string2).setPort(OtaTransferReceiverDelegate.getInstance().getServerPort()).setIpAddress(Utils.getInstance().getP2PIpAddress()).addAllPaths(arrayList).build();
        IAbilitySlot.SlotObserver slotObserver = this.mSlotObserver;
        if (slotObserver == null) {
            LogUtil.d(TAG, "the slotObserver is null ,must be something wrong");
            return false;
        }
        slotObserver.output(this.mStarryDevice, new AbilityMessage(build.toByteArray()));
        return true;
    }

    public void sendReceiverFinishMessage(String str) {
        StarryDevice deviceByTaskId = OtaTransferReceiverDelegate.getInstance().getDeviceByTaskId(str);
        if (deviceByTaskId == null) {
            deviceByTaskId = this.mStarryDevice;
        }
        IAbilitySlot.SlotObserver slotObserver = this.slotObserverMap.get(deviceByTaskId.getId());
        if (slotObserver == null) {
            slotObserver = this.mSlotObserver;
        }
        slotObserver.output(deviceByTaskId, new AbilityMessage(ShareApi.Message.newBuilder().setType(ShareApi.StreamType.RECEIVE_OTA_FINISH).setTaskId(str).build().toByteArray()));
    }

    public void startSendFile(String str) {
        if (!TextUtils.isEmpty(str) && !OtaTransferReceiverDelegate.getInstance().isTransferring(str)) {
            String fileResumeInfoById = OtaTransferReceiverDelegate.getInstance().getFileResumeInfoById(str);
            if (TextUtils.isEmpty(fileResumeInfoById)) {
                fileResumeInfoById = "";
            }
            ShareApi.Message build = ShareApi.Message.newBuilder().setType(ShareApi.StreamType.SIGNAL).setIpAddress(Utils.getInstance().getP2PIpAddress()).setPort(OtaTransferReceiverDelegate.getInstance().getServerPort()).setFileResumeInfo(fileResumeInfoById).setTaskId(str).build();
            StarryDevice deviceByTaskId = OtaTransferReceiverDelegate.getInstance().getDeviceByTaskId(str);
            if (deviceByTaskId == null) {
                deviceByTaskId = this.mStarryDevice;
            }
            LogUtil.d(TAG, "confirm target devices : " + deviceByTaskId.getId());
            IAbilitySlot.SlotObserver slotObserver = this.slotObserverMap.get(deviceByTaskId.getId());
            if (slotObserver == null) {
                slotObserver = this.mSlotObserver;
            }
            slotObserver.output(deviceByTaskId, new AbilityMessage(build.toByteArray()));
            OtaTransferReceiverDelegate.getInstance().confirmReceive(str);
        }
    }

    public boolean startShare(Bundle bundle) {
        String string = bundle.getString("taskId");
        String string2 = bundle.getString("dirPath");
        String string3 = bundle.getString("extra");
        String string4 = bundle.getString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        OtaTransferSendDelegate.getIntense().putStorage(string, string2);
        ShareApi.Message build = ShareApi.Message.newBuilder().setType(ShareApi.StreamType.DEFAULT).setTaskId(string).setDirPath(string2).setExtra(string3).setPackageName(string4).setFileInfos(OtaTransferSendDelegate.getIntense().getFileInfos(string)).build();
        OtaTransferSendDelegate.getIntense().callBackStart(string, string3);
        IAbilitySlot.SlotObserver slotObserver = this.mSlotObserver;
        if (slotObserver == null) {
            LogUtil.d(TAG, "the slotObserver is null ,must be something wrong");
            return false;
        }
        slotObserver.output(this.mStarryDevice, new AbilityMessage(build.toByteArray()));
        return true;
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        this.adapter.adapt(bundle, bundle2);
    }
}
