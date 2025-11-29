package com.upuphone.runasone.relay.lib.device;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.protobuf.ByteString;
import com.google.protobuf.ProtocolStringList;
import com.upuphone.hub.HubException;
import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.RelayApi;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.AbilityMessage;
import com.upuphone.runasone.host.core.api.IAbilitySlot;
import com.upuphone.runasone.relay.StarryParam;
import com.upuphone.runasone.relay.StarryTag;
import com.upuphone.runasone.relay.api.RelayCallback;
import com.upuphone.runasone.relay.api.SendRelayMessageCallBack;
import com.upuphone.runasone.relay.error.RelayErrorCode;
import com.upuphone.runasone.relay.lib.BuildConfig;
import com.upuphone.runasone.relay.lib.RelayPort;
import com.upuphone.runasone.relay.lib.bean.CallBackData;
import com.upuphone.runasone.relay.lib.manager.AppConfigManager;
import com.upuphone.runasone.relay.lib.myconst.OpenConst;
import com.upuphone.runasone.relay.lib.track.RelayTrackManager;
import com.upuphone.runasone.relay.lib.utils.LogUtil;
import com.upuphone.runasone.relay.lib.utils.UtilUse;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MessageManager {
    private static final String EASY_SHARE = "com.upuphone.easyshare";
    private static final int MSG_FILTER = 100000;
    /* access modifiers changed from: private */
    public static final String TAG = "MessageManager";
    private static MessageManager manager;
    private Context context;
    public TimeOutHandler timeOut;
    private Set<String> versionMatch = new HashSet();

    /* renamed from: com.upuphone.runasone.relay.lib.device.MessageManager$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$upuphone$runasone$RelayApi$StreamType;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.upuphone.runasone.RelayApi$StreamType[] r0 = com.upuphone.runasone.RelayApi.StreamType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$upuphone$runasone$RelayApi$StreamType = r0
                com.upuphone.runasone.RelayApi$StreamType r1 = com.upuphone.runasone.RelayApi.StreamType.SEND_LIST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$upuphone$runasone$RelayApi$StreamType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.upuphone.runasone.RelayApi$StreamType r1 = com.upuphone.runasone.RelayApi.StreamType.OPEN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$upuphone$runasone$RelayApi$StreamType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.upuphone.runasone.RelayApi$StreamType r1 = com.upuphone.runasone.RelayApi.StreamType.CLOSE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$upuphone$runasone$RelayApi$StreamType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.upuphone.runasone.RelayApi$StreamType r1 = com.upuphone.runasone.RelayApi.StreamType.SEND_MSG     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$upuphone$runasone$RelayApi$StreamType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.upuphone.runasone.RelayApi$StreamType r1 = com.upuphone.runasone.RelayApi.StreamType.MSG_SUCCESS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$upuphone$runasone$RelayApi$StreamType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.upuphone.runasone.RelayApi$StreamType r1 = com.upuphone.runasone.RelayApi.StreamType.MSG_FAILED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$upuphone$runasone$RelayApi$StreamType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.upuphone.runasone.RelayApi$StreamType r1 = com.upuphone.runasone.RelayApi.StreamType.REMOTE_SUCCESS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$upuphone$runasone$RelayApi$StreamType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.upuphone.runasone.RelayApi$StreamType r1 = com.upuphone.runasone.RelayApi.StreamType.REMOTE_FAILED     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$upuphone$runasone$RelayApi$StreamType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.upuphone.runasone.RelayApi$StreamType r1 = com.upuphone.runasone.RelayApi.StreamType.BINDER_LIST     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$upuphone$runasone$RelayApi$StreamType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.upuphone.runasone.RelayApi$StreamType r1 = com.upuphone.runasone.RelayApi.StreamType.OPEN_ACTIVITY     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$upuphone$runasone$RelayApi$StreamType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.upuphone.runasone.RelayApi$StreamType r1 = com.upuphone.runasone.RelayApi.StreamType.CMD     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.relay.lib.device.MessageManager.AnonymousClass1.<clinit>():void");
        }
    }

    public class TimeOutHandler {
        private static final int ABILITY_TIME_OUT = 3;
        private static final int MESSAGE_TIME_OUT = 1;
        private static final int REMOTE_TIME_OUT = 2;
        private static final int SEND_FAILED_CALLBACK = 5;
        private static final int SEND_SUCCESS_CALLBACK = 4;
        private static final int TIME_ABILITY = 1800;
        private static final int TIME_OUT = 10000;
        private LinkedList<CallBackData> list = new LinkedList<>();
        private int maxPool = 25;
        Map<String, String> msgMap = new ConcurrentHashMap();
        Thread msgThread;
        /* access modifiers changed from: private */
        public Handler newThreadHandler;
        Object obj = new Object();

        public TimeOutHandler() {
        }

        public CallBackData obtain(StarryTag starryTag, String str) {
            CallBackData poll;
            synchronized (this.obj) {
                poll = this.list.poll();
            }
            if (poll == null || poll.isUsing()) {
                CallBackData callBackData = new CallBackData(starryTag, str);
                callBackData.setUsing(true);
                return callBackData;
            }
            poll.setStarryTag(starryTag);
            poll.setUniqueKey(str);
            poll.setUsing(true);
            return poll;
        }

        public void recycleData(CallBackData callBackData) {
            callBackData.setUniqueKey((String) null);
            callBackData.setStarryTag((StarryTag) null);
            callBackData.setUsing(false);
            synchronized (this.obj) {
                try {
                    if (this.list.size() < this.maxPool) {
                        this.list.addLast(callBackData);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void sendFailedCallBack(StarryTag starryTag, String str, int i, boolean z) {
            if (z) {
                Thread thread = this.msgThread;
                if (thread == null || !thread.isAlive()) {
                    startThread();
                }
                Handler handler = this.newThreadHandler;
                if (handler != null) {
                    Message obtain = Message.obtain(handler, 5);
                    obtain.obj = obtain(starryTag, str);
                    obtain.arg1 = i;
                    this.newThreadHandler.sendMessage(obtain);
                }
            }
        }

        public void sendRemoveMessage(boolean z, String str) {
            Thread thread = this.msgThread;
            if (thread == null || !thread.isAlive() || this.newThreadHandler == null) {
                startThread();
            }
            if (this.newThreadHandler != null) {
                if (z) {
                    this.msgMap.put(str, str);
                    String access$100 = MessageManager.TAG;
                    LogUtil.dPrimary(access$100, "----sendHandler  uniqueKey= " + str);
                    this.newThreadHandler.sendMessageDelayed(Message.obtain(this.newThreadHandler, 1, str), 10000);
                    return;
                }
                String access$1002 = MessageManager.TAG;
                LogUtil.dPrimary(access$1002, "----removeHandler  uniqueKey= " + str);
                String remove = this.msgMap.remove(str);
                if (remove != null) {
                    this.newThreadHandler.removeMessages(1, remove);
                }
            }
        }

        public void sendRemoveRemote(boolean z, String str, int i) {
            Thread thread = this.msgThread;
            if (thread == null || !thread.isAlive() || this.newThreadHandler == null) {
                startThread();
            }
            Handler handler = this.newThreadHandler;
            if (handler != null) {
                if (z) {
                    Message obtain = Message.obtain(handler, 2, str);
                    obtain.arg1 = i;
                    this.newThreadHandler.sendMessageDelayed(obtain, 10000);
                    return;
                }
                handler.removeMessages(2);
            }
        }

        public void sendSuccessCallBack(StarryTag starryTag, String str, boolean z) {
            if (z) {
                Thread thread = this.msgThread;
                if (thread == null || !thread.isAlive() || this.newThreadHandler == null) {
                    startThread();
                }
                Handler handler = this.newThreadHandler;
                if (handler != null) {
                    Message obtain = Message.obtain(handler, 4);
                    obtain.obj = obtain(starryTag, str);
                    this.newThreadHandler.sendMessage(obtain);
                }
            }
        }

        public void startThread() {
            AnonymousClass1 r0 = new Thread() {
                /* access modifiers changed from: private */
                public /* synthetic */ boolean lambda$run$0(Message message) {
                    StarryParam starryParam;
                    Object obj;
                    int i = message.what;
                    if (i == 1) {
                        Object obj2 = message.obj;
                        if (obj2 != null) {
                            TimeOutHandler.this.msgMap.remove((String) obj2);
                            RelayDeviceManager.getInstance().callSendMessageListener((String) message.obj, RelayErrorCode.SEND_MESSAGE_TIMEOUT, false);
                        }
                    } else if (i != 2) {
                        if (i == 4) {
                            Object obj3 = message.obj;
                            if (obj3 != null) {
                                CallBackData callBackData = (CallBackData) obj3;
                                MessageManager.getInstance().sendMessageSuccess(callBackData.getStarryTag(), callBackData.getUniqueKey());
                                TimeOutHandler.this.recycleData(callBackData);
                            }
                        } else if (i == 5 && (obj = message.obj) != null) {
                            CallBackData callBackData2 = (CallBackData) obj;
                            MessageManager.getInstance().sendMessageFailed(callBackData2.getStarryTag(), callBackData2.getUniqueKey(), message.arg1);
                            TimeOutHandler.this.recycleData(callBackData2);
                        }
                    } else if (message.obj != null) {
                        if (message.arg1 == 0) {
                            starryParam = new StarryParam();
                            starryParam.setListenerId(message.arg1);
                        } else {
                            starryParam = null;
                        }
                        RelayDeviceManager.getInstance().callRemoteListener((String) message.obj, RelayErrorCode.START_REMOTE_TIMEOUT, false, starryParam);
                    }
                    return false;
                }

                public void run() {
                    Looper.prepare();
                    Handler unused = TimeOutHandler.this.newThreadHandler = new Handler(Looper.myLooper(), new a(this));
                    Looper.loop();
                    super.run();
                }
            };
            this.msgThread = r0;
            r0.start();
        }
    }

    private MessageManager() {
    }

    public static MessageManager getInstance() {
        if (manager == null) {
            manager = new MessageManager();
        }
        return manager;
    }

    private void onAbilityChange(StarryDevice starryDevice, RelayApi.Message message) {
        String str = TAG;
        LogUtil.dPrimary(str, "------UPDATE_ABILITY=" + message.getAbilityKeyList());
        ProtocolStringList abilityKeyList = message.getAbilityKeyList();
        if (message.getAppUniteCodeType() == RelayApi.AppUniteCodeType.ADD) {
            RelayDeviceManager.getInstance().addAppUniteCodeList(starryDevice.getId(), abilityKeyList, message.getAbilityKeyMapMap(), true);
        } else if (message.getAppUniteCodeType() == RelayApi.AppUniteCodeType.DEL) {
            RelayDeviceManager.getInstance().removeAppUniteCodeList(starryDevice.getId(), abilityKeyList, false);
        }
    }

    @Deprecated
    private void onReceiveAbilityList(StarryDevice starryDevice, RelayApi.Message message) {
        abilityListSuccess(starryDevice);
    }

    private void onReceiveMessage(StarryDevice starryDevice, RelayApi.Message message) {
        String str;
        String str2;
        StarryParam starryParam;
        boolean z;
        String str3;
        String str4;
        StarryTag starryTag;
        boolean needCallBack = message.getNeedCallBack();
        String msgUniqueKey = message.getMsgUniqueKey();
        boolean supportMap = message.getSupportMap();
        String str5 = TAG;
        LogUtil.dPrimary(str5, "------run-R-msg------   deviceId=" + starryDevice.getId() + "  uniqueKey=" + msgUniqueKey + "   needCallback=" + needCallBack + "   receive= " + message.getReceiveAppUniteCode() + "  send= " + message.getSendAppUniteCode() + "   sendCode= " + message.getReceiveAUCNum() + "   receiveCode= " + message.getSendAUCNum() + "   SupportMap= " + supportMap);
        AbilityBean deviceById = RelayDeviceManager.getInstance().getDeviceById(starryDevice.getId());
        if (supportMap) {
            String receiveAUC = AppConfigManager.getInstance().getReceiveAUC(message.getReceiveAUCNum());
            str2 = RelayDeviceManager.getInstance().getSendMappingAuc(deviceById, message.getSendAUCNum());
            str = receiveAUC;
        } else {
            String receiveAppUniteCode = message.getReceiveAppUniteCode();
            String sendAppUniteCode = message.getSendAppUniteCode();
            if (UtilUse.isAppUniteCodeSame(message.getSendAppUniteCode(), message.getReceiveAppUniteCode())) {
                receiveAppUniteCode = message.getSendAppUniteCode();
            }
            str = receiveAppUniteCode;
            str2 = sendAppUniteCode;
        }
        ByteString msg = message.getMsg();
        StarryTag starryTag2 = new StarryTag(starryDevice.getId(), str2, str);
        RelayCallback relayListener = RelayDeviceManager.getInstance().getRelayListener(str2, str);
        LogUtil.dPrimary(str5, "------run-R-msg------   receive= " + str + "  send= " + str2);
        if (str2 == null || str == null) {
            boolean z2 = supportMap;
            String str6 = str;
            String str7 = "";
            StarryTag starryTag3 = starryTag2;
            LogUtil.dPrimary(str5, "------MAPPING_ERROR203013   needCallback=" + needCallBack);
            this.timeOut.sendFailedCallBack(starryTag3, msgUniqueKey, RelayErrorCode.MAPPING_ERROR, needCallBack);
            RelayTrackManager.getSIntance().trackReceive(starryTag3.getDeviceId(), msgUniqueKey, starryTag3.getSendAppUniteCode(), str6, msg.size() + str7, z2 + str7, needCallBack + str7, "203013");
            return;
        }
        if (!BuildConfig.IS_THIRD.booleanValue() && !"com.upuphone.easyshare".equals(str)) {
            if (!AppConfigManager.getInstance().hasAppUniteCode(str)) {
                LogUtil.dPrimary(str5, "------APP_NOT_INSTALL203007   needCallback=" + needCallBack);
                this.timeOut.sendFailedCallBack(starryTag2, msgUniqueKey, RelayErrorCode.APP_NOT_INSTALL, needCallBack);
                RelayTrackManager.getSIntance().trackReceive(starryTag2.getDeviceId(), msgUniqueKey, starryTag2.getSendAppUniteCode(), str, msg.size() + "", supportMap + "", needCallBack + "", "203007");
                return;
            } else if (!RelayPort.getInstance().isBinderExit(str)) {
                LogUtil.dPrimary(str5, "------BINDER_ERROR203010   needCallback=" + needCallBack);
                this.timeOut.sendFailedCallBack(starryTag2, msgUniqueKey, RelayErrorCode.BINDER_ERROR, needCallBack);
                RelayTrackManager.getSIntance().trackReceive(starryTag2.getDeviceId(), msgUniqueKey, starryTag2.getSendAppUniteCode(), str, msg.size() + "", supportMap + "", needCallBack + "", "203010");
                return;
            }
        }
        if (relayListener == null) {
            LogUtil.dPrimary(str5, "------UN_INIT203001   needCallback=" + needCallBack);
            this.timeOut.sendFailedCallBack(starryTag2, msgUniqueKey, RelayErrorCode.UN_INIT, needCallBack);
            RelayTrackManager.getSIntance().trackReceive(starryTag2.getDeviceId(), msgUniqueKey, starryTag2.getSendAppUniteCode(), str, msg.size() + "", supportMap + "", needCallBack + "", "203001");
            return;
        }
        byte[] byteArray = msg.toByteArray();
        if (message.getListenerId() > 0) {
            starryParam = new StarryParam();
            starryParam.setListenerId(message.getListenerId());
        } else {
            starryParam = null;
        }
        try {
            relayListener.onReceiveMessage(starryTag2, new ArrayData(byteArray), starryParam);
            this.timeOut.sendSuccessCallBack(starryTag2, msgUniqueKey, needCallBack);
            String str8 = supportMap + "";
            String str9 = str;
            str3 = str;
            str4 = "";
            z = supportMap;
            starryTag = starryTag2;
            try {
                RelayTrackManager.getSIntance().trackReceive(starryTag2.getDeviceId(), msgUniqueKey, starryTag2.getSendAppUniteCode(), str9, msg.size() + "", str8, needCallBack + "", "");
            } catch (HubException e) {
                e = e;
            }
        } catch (HubException e2) {
            e = e2;
            z = supportMap;
            str3 = str;
            str4 = "";
            starryTag = starryTag2;
            e.printStackTrace();
            this.timeOut.sendFailedCallBack(starryTag, msgUniqueKey, RelayErrorCode.BINDER_DIED, needCallBack);
            RelayTrackManager.getSIntance().trackReceive(starryTag.getDeviceId(), msgUniqueKey, starryTag.getSendAppUniteCode(), str3, msg.size() + str4, z + str4, needCallBack + str4, "203017");
        }
    }

    private void openApplication(Context context2, StarryTag starryTag, byte[] bArr) {
        if (RelayPort.getInstance().isBinderExit(starryTag.getReceiveAppUniteCode())) {
            sendRemoteSuccess(starryTag);
            return;
        }
        String packageName = AppConfigManager.getInstance().getPackageName(starryTag.getReceiveAppUniteCode());
        if (packageName == null) {
            sendRemoteFailed(starryTag, RelayErrorCode.APP_NOT_INSTALL);
            return;
        }
        try {
            UtilUse.openApplication(context2, packageName, bArr);
            sendRemoteSuccess(starryTag);
        } catch (Exception e) {
            sendRemoteFailed(starryTag, RelayErrorCode.NOT_FOUND_ACTIVITY);
            e.printStackTrace();
        }
    }

    public void UpdateAbility(Map<String, Integer> map, RelayApi.AppUniteCodeType appUniteCodeType) {
        for (StarryDevice next : RelayDeviceManager.getInstance().getDeviceList()) {
            IAbilitySlot.SlotObserver observer = RelayDeviceManager.getInstance().getDeviceById(next.getId()).getObserver();
            if (observer != null) {
                observer.output(next, new AbilityMessage(RelayApi.Message.newBuilder().setType(RelayApi.StreamType.CMD).addAllAbilityKey(map.keySet()).putAllAbilityKeyMap(map).setAppUniteCodeType(appUniteCodeType).build().toByteArray()));
            }
        }
    }

    public void abilityListSuccess(StarryDevice starryDevice) {
        String str = TAG;
        LogUtil.dPrimary(str, "------abilityListSuccess   deviceid=" + starryDevice.getId());
        IAbilitySlot.SlotObserver observer = RelayDeviceManager.getInstance().getDeviceById(starryDevice.getId()).getObserver();
        if (observer != null) {
            observer.output(starryDevice, new AbilityMessage(RelayApi.Message.newBuilder().setType(RelayApi.StreamType.LIST_SUCCESS).build().toByteArray()));
        }
    }

    public void bindService(StarryTag starryTag, String str, byte[] bArr) {
        if (AppConfigManager.getInstance().getPackageName(starryTag.getReceiveAppUniteCode()) == null) {
            sendRemoteFailed(starryTag, RelayErrorCode.APP_NOT_INSTALL);
            return;
        }
        String str2 = TAG;
        LogUtil.dPrimary(str2, "------openActivityWithParams bindService:" + str + " Send=" + starryTag.getSendAppUniteCode() + "   Receive=" + starryTag.getReceiveAppUniteCode());
        try {
            UtilUse.bindService(this.context, str, OpenConst.ACTION_BIND, bArr);
            if (RelayPort.getInstance().isBinderExit(starryTag.getReceiveAppUniteCode())) {
                sendRemoteSuccess(starryTag);
            } else {
                sendRemoteFailed(starryTag, RelayErrorCode.NOT_FOUND_SERVICE);
            }
        } catch (Exception unused) {
            sendRemoteFailed(starryTag, RelayErrorCode.NOT_FOUND_SERVICE);
        }
    }

    public void input(StarryDevice starryDevice, RelayApi.Message message) {
        StarryParam starryParam;
        IAbilitySlot.SlotObserver observer = RelayDeviceManager.getInstance().getDeviceById(starryDevice.getId()).getObserver();
        String receiveAppUniteCode = message.getReceiveAppUniteCode();
        if (UtilUse.isAppUniteCodeSame(message.getSendAppUniteCode(), message.getReceiveAppUniteCode())) {
            receiveAppUniteCode = message.getSendAppUniteCode();
        }
        String devAuc = UtilUse.getDevAuc(starryDevice.getId(), message.getSendAppUniteCode(), receiveAppUniteCode);
        if (message.getListenerId() > 0) {
            starryParam = new StarryParam();
            starryParam.setListenerId(message.getListenerId());
        } else {
            starryParam = null;
        }
        if (observer != null) {
            switch (AnonymousClass1.$SwitchMap$com$upuphone$runasone$RelayApi$StreamType[message.getType().ordinal()]) {
                case 1:
                    onReceiveAbilityList(starryDevice, message);
                    return;
                case 2:
                    LogUtil.dPrimary(TAG, "------OPEN");
                    StarryTag starryTag = new StarryTag(starryDevice.getId(), message.getSendAppUniteCode(), receiveAppUniteCode);
                    RelayTrackManager.getSIntance().trackOpen(starryTag.getDeviceId(), starryTag.getSendAppUniteCode(), starryTag.getReceiveAppUniteCode(), "", "-1");
                    openApplication(this.context, starryTag, message.getMsg().toByteArray());
                    return;
                case 3:
                    String str = TAG;
                    LogUtil.dPrimary(str, "------REMOTE_CLOSE" + devAuc);
                    RelayDeviceManager.getInstance().callRemoteListener(devAuc, 0, true, starryParam);
                    return;
                case 4:
                    onReceiveMessage(starryDevice, message);
                    return;
                case 5:
                    RelayDeviceManager.getInstance().callSendMessageListener(message.getMsgUniqueKey(), -1, true);
                    return;
                case 6:
                    RelayDeviceManager.getInstance().callSendMessageListener(message.getMsgUniqueKey(), message.getErrorCode(), true);
                    return;
                case 7:
                    String str2 = TAG;
                    LogUtil.dPrimary(str2, "------REMOTE_SUCCESS" + devAuc);
                    RelayDeviceManager.getInstance().callRemoteListener(devAuc, -1, true, starryParam);
                    return;
                case 8:
                    String str3 = TAG;
                    LogUtil.dPrimary(str3, "------REMOTE_FAILED:" + message.getErrorCode() + " devAuc= " + devAuc);
                    RelayDeviceManager.getInstance().callRemoteListener(devAuc, message.getErrorCode(), true, starryParam);
                    return;
                case 10:
                    StarryTag starryTag2 = new StarryTag(starryDevice.getId(), message.getSendAppUniteCode(), receiveAppUniteCode);
                    RelayTrackManager sIntance = RelayTrackManager.getSIntance();
                    String deviceId = starryTag2.getDeviceId();
                    String sendAppUniteCode = starryTag2.getSendAppUniteCode();
                    String receiveAppUniteCode2 = starryTag2.getReceiveAppUniteCode();
                    String msgUniqueKey = message.getMsgUniqueKey();
                    sIntance.trackOpen(deviceId, sendAppUniteCode, receiveAppUniteCode2, msgUniqueKey, message.getOpenType() + "");
                    if (message.getOpenType() == 1) {
                        startService(starryTag2, message.getMsgUniqueKey(), message.getMsg().toByteArray());
                        return;
                    } else if (message.getOpenType() == 0) {
                        openActivityWithParams(starryTag2, message.getMsgUniqueKey(), message.getMsg().toByteArray());
                        return;
                    } else if (message.getOpenType() == 2) {
                        bindService(starryTag2, message.getMsgUniqueKey(), message.getMsg().toByteArray());
                        return;
                    } else {
                        return;
                    }
                case 11:
                    onAbilityChange(starryDevice, message);
                    return;
                default:
                    return;
            }
        }
    }

    public void install(Context context2) {
        this.context = context2;
        TimeOutHandler timeOutHandler = new TimeOutHandler();
        this.timeOut = timeOutHandler;
        timeOutHandler.startThread();
    }

    public void openActivityWithParams(StarryTag starryTag, String str, byte[] bArr) {
        if (AppConfigManager.getInstance().getPackageName(starryTag.getReceiveAppUniteCode()) == null) {
            sendRemoteFailed(starryTag, RelayErrorCode.APP_NOT_INSTALL);
            return;
        }
        String str2 = TAG;
        LogUtil.dPrimary(str2, "------openActivityWithParams:" + str + " Send=" + starryTag.getSendAppUniteCode() + "   Receive=" + starryTag.getReceiveAppUniteCode());
        try {
            UtilUse.openActivityWithParams(this.context, str, OpenConst.ACTIVITY_ACTION, bArr);
            if (RelayPort.getInstance().isBinderExit(starryTag.getReceiveAppUniteCode())) {
                sendRemoteSuccess(starryTag);
            } else {
                sendRemoteFailed(starryTag, RelayErrorCode.NOT_FOUND_ACTIVITY);
            }
        } catch (Exception e) {
            e.printStackTrace();
            sendRemoteFailed(starryTag, RelayErrorCode.NOT_FOUND_ACTIVITY);
        }
    }

    public void sendMessage(StarryTag starryTag, byte[] bArr, int i, StarryParam starryParam, SendRelayMessageCallBack sendRelayMessageCallBack) {
        sendMessage(starryTag, bArr, 0, bArr == null ? 0 : bArr.length, i, starryParam, sendRelayMessageCallBack);
    }

    public void sendMessageFailed(StarryTag starryTag, String str, int i) {
        IAbilitySlot.SlotObserver observer;
        String str2 = TAG;
        LogUtil.dPrimary(str2, "------sendMessageFailed  DeviceId=" + starryTag.getDeviceId() + "   uniqueKey=" + str);
        AbilityBean deviceById = RelayDeviceManager.getInstance().getDeviceById(starryTag.getDeviceId());
        if (deviceById != null && (observer = deviceById.getObserver()) != null) {
            observer.output(deviceById.getDevice(), new AbilityMessage(RelayApi.Message.newBuilder().setType(RelayApi.StreamType.MSG_FAILED).setMsgUniqueKey(str).setErrorCode(i).build().toByteArray()));
        }
    }

    public void sendMessageSuccess(StarryTag starryTag, String str) {
        IAbilitySlot.SlotObserver observer;
        String str2 = TAG;
        LogUtil.dPrimary(str2, "------sendMessageSuccess  DeviceId=" + starryTag.getDeviceId() + "   uniqueKey=" + str);
        AbilityBean deviceById = RelayDeviceManager.getInstance().getDeviceById(starryTag.getDeviceId());
        if (deviceById != null && (observer = deviceById.getObserver()) != null) {
            observer.output(deviceById.getDevice(), new AbilityMessage(RelayApi.Message.newBuilder().setType(RelayApi.StreamType.MSG_SUCCESS).setMsgUniqueKey(str).build().toByteArray()));
        }
    }

    public void sendRemoteFailed(StarryTag starryTag, int i) {
        IAbilitySlot.SlotObserver observer;
        String str;
        String str2;
        String str3 = TAG;
        LogUtil.dPrimary(str3, "------sendRemoteFailed  DeviceId=" + starryTag.getDeviceId() + "  SendAppUniteCode=" + starryTag.getSendAppUniteCode() + "  ReceiveAppUniteCode=" + starryTag.getReceiveAppUniteCode() + "  errorCode=" + i);
        AbilityBean deviceById = RelayDeviceManager.getInstance().getDeviceById(starryTag.getDeviceId());
        if (deviceById != null && (observer = deviceById.getObserver()) != null) {
            if (UtilUse.isAppUniteCodeSame(starryTag.getSendAppUniteCode(), starryTag.getReceiveAppUniteCode())) {
                str = starryTag.getSendAppUniteCode();
                str2 = "";
            } else {
                String receiveAppUniteCode = starryTag.getReceiveAppUniteCode();
                str2 = starryTag.getSendAppUniteCode();
                str = receiveAppUniteCode;
            }
            observer.output(deviceById.getDevice(), new AbilityMessage(RelayApi.Message.newBuilder().setType(RelayApi.StreamType.REMOTE_FAILED).setSendAppUniteCode(str).setReceiveAppUniteCode(str2).setErrorCode(i).build().toByteArray()));
        }
    }

    public void sendRemoteSuccess(StarryTag starryTag) {
        IAbilitySlot.SlotObserver observer;
        String str;
        String str2;
        String str3 = TAG;
        LogUtil.dPrimary(str3, "------sendRemoteSuccess  DeviceId=" + starryTag.getDeviceId() + "  SendAppUniteCode=" + starryTag.getSendAppUniteCode() + "  ReceiveAppUniteCode=" + starryTag.getReceiveAppUniteCode());
        AbilityBean deviceById = RelayDeviceManager.getInstance().getDeviceById(starryTag.getDeviceId());
        if (deviceById != null && (observer = deviceById.getObserver()) != null) {
            if (UtilUse.isAppUniteCodeSame(starryTag.getSendAppUniteCode(), starryTag.getReceiveAppUniteCode())) {
                str = starryTag.getSendAppUniteCode();
                str2 = "";
            } else {
                String receiveAppUniteCode = starryTag.getReceiveAppUniteCode();
                str2 = starryTag.getSendAppUniteCode();
                str = receiveAppUniteCode;
            }
            observer.output(deviceById.getDevice(), new AbilityMessage(RelayApi.Message.newBuilder().setType(RelayApi.StreamType.REMOTE_SUCCESS).setSendAppUniteCode(str).setReceiveAppUniteCode(str2).build().toByteArray()));
        }
    }

    public void startRemote(StarryTag starryTag, String str, byte[] bArr, int i, StarryParam starryParam) {
        String receiveAppUniteCode = starryTag.getReceiveAppUniteCode();
        if (UtilUse.isAppUniteCodeSame(starryTag.getSendAppUniteCode(), receiveAppUniteCode)) {
            receiveAppUniteCode = starryTag.getSendAppUniteCode();
        }
        String str2 = TAG;
        LogUtil.dPrimary(str2, "------startRemote  DeviceId=" + starryTag.getDeviceId() + "  SendAppUniteCode=" + starryTag.getSendAppUniteCode() + "  ReceiveAppUniteCode=" + receiveAppUniteCode + "  host=" + str);
        AbilityBean deviceById = RelayDeviceManager.getInstance().getDeviceById(starryTag.getDeviceId());
        if (deviceById == null) {
            RelayCallback relayListener = RelayDeviceManager.getInstance().getRelayListener(starryTag.getSendAppUniteCode(), receiveAppUniteCode);
            if (relayListener != null) {
                relayListener.onRemoteError(starryTag, RelayErrorCode.DEVICE_ERROR, RelayErrorCode.getErrorText(RelayErrorCode.DEVICE_ERROR), starryParam);
                return;
            }
            return;
        }
        IAbilitySlot.SlotObserver observer = deviceById.getObserver();
        if (observer != null) {
            int i2 = 0;
            int listenerId = (starryParam == null || starryParam.getListenerId() <= 0) ? 0 : starryParam.getListenerId();
            if (receiveAppUniteCode.equals(starryTag.getSendAppUniteCode())) {
                receiveAppUniteCode = "";
            }
            if (str != null) {
                RelayApi.Message.Builder msg = RelayApi.Message.newBuilder().setType(RelayApi.StreamType.OPEN_ACTIVITY).setSendAppUniteCode(starryTag.getSendAppUniteCode()).setReceiveAppUniteCode(receiveAppUniteCode).setOpenType(i).setMsgUniqueKey(str).setMsg(ByteString.copyFrom(bArr));
                if (listenerId > 0) {
                    msg.setListenerId(listenerId);
                }
                observer.output(deviceById.getDevice(), new AbilityMessage(msg.build().toByteArray()));
            } else {
                RelayApi.Message.Builder msg2 = RelayApi.Message.newBuilder().setType(RelayApi.StreamType.OPEN).setSendAppUniteCode(starryTag.getSendAppUniteCode()).setReceiveAppUniteCode(receiveAppUniteCode).setOpenType(i).setMsg(ByteString.copyFrom(bArr));
                if (listenerId > 0) {
                    msg2.setListenerId(listenerId);
                }
                observer.output(deviceById.getDevice(), new AbilityMessage(msg2.build().toByteArray()));
            }
            TimeOutHandler timeOutHandler = this.timeOut;
            String devAuc = UtilUse.getDevAuc(starryTag);
            if (starryParam != null) {
                i2 = starryParam.getListenerId();
            }
            timeOutHandler.sendRemoveRemote(true, devAuc, i2);
        }
    }

    public void startService(StarryTag starryTag, String str, byte[] bArr) {
        String packageName = AppConfigManager.getInstance().getPackageName(starryTag.getReceiveAppUniteCode());
        if (packageName == null) {
            sendRemoteFailed(starryTag, RelayErrorCode.APP_NOT_INSTALL);
            return;
        }
        String str2 = TAG;
        LogUtil.dPrimary(str2, "------openActivityWithParams: startService" + str + " Send=" + starryTag.getSendAppUniteCode() + "   Receive=" + starryTag.getReceiveAppUniteCode());
        try {
            UtilUse.startService(this.context, packageName, str, OpenConst.ACTION_OPEN, bArr);
            if (RelayPort.getInstance().isBinderExit(starryTag.getReceiveAppUniteCode())) {
                sendRemoteSuccess(starryTag);
            } else {
                sendRemoteFailed(starryTag, RelayErrorCode.NOT_FOUND_SERVICE);
            }
        } catch (Exception unused) {
            sendRemoteFailed(starryTag, RelayErrorCode.NOT_FOUND_SERVICE);
        }
    }

    public void stopRemote(StarryTag starryTag, StarryParam starryParam) {
        String receiveAppUniteCode = starryTag.getReceiveAppUniteCode();
        if (UtilUse.isAppUniteCodeSame(starryTag.getSendAppUniteCode(), receiveAppUniteCode)) {
            receiveAppUniteCode = starryTag.getSendAppUniteCode();
        }
        String str = TAG;
        LogUtil.dPrimary(str, "------stopRemote  DeviceId=" + starryTag.getDeviceId() + "  SendAppUniteCode=" + starryTag.getSendAppUniteCode() + "  ReceiveAppUniteCode=" + receiveAppUniteCode);
        AbilityBean deviceById = RelayDeviceManager.getInstance().getDeviceById(starryTag.getDeviceId());
        if (deviceById == null) {
            RelayCallback relayListener = RelayDeviceManager.getInstance().getRelayListener(starryTag.getSendAppUniteCode(), receiveAppUniteCode);
            if (relayListener != null) {
                relayListener.onRemoteError(starryTag, RelayErrorCode.DEVICE_ERROR, RelayErrorCode.getErrorText(RelayErrorCode.DEVICE_ERROR), starryParam);
                return;
            }
            return;
        }
        IAbilitySlot.SlotObserver observer = deviceById.getObserver();
        if (observer != null) {
            int i = 0;
            int listenerId = (starryParam == null || starryParam.getListenerId() <= 0) ? 0 : starryParam.getListenerId();
            if (starryTag.getSendAppUniteCode().equals(receiveAppUniteCode)) {
                receiveAppUniteCode = "";
            }
            RelayApi.Message.Builder receiveAppUniteCode2 = RelayApi.Message.newBuilder().setType(RelayApi.StreamType.CLOSE).setSendAppUniteCode(starryTag.getSendAppUniteCode()).setReceiveAppUniteCode(receiveAppUniteCode);
            if (listenerId > 0) {
                receiveAppUniteCode2.setListenerId(listenerId);
            }
            observer.output(deviceById.getDevice(), new AbilityMessage(receiveAppUniteCode2.build().toByteArray()));
            TimeOutHandler timeOutHandler = this.timeOut;
            String devAuc = UtilUse.getDevAuc(starryTag);
            if (starryParam != null) {
                i = starryParam.getListenerId();
            }
            timeOutHandler.sendRemoveRemote(true, devAuc, i);
        }
    }

    public void unInstall() {
        manager = null;
    }

    public void sendMessage(StarryTag starryTag, byte[] bArr, int i, int i2, int i3, StarryParam starryParam, SendRelayMessageCallBack sendRelayMessageCallBack) {
        String str;
        byte[] bArr2 = bArr;
        int i4 = i3;
        SendRelayMessageCallBack sendRelayMessageCallBack2 = sendRelayMessageCallBack;
        String uniqueKey = UtilUse.getUniqueKey();
        if (starryTag != null) {
            String receiveAppUniteCode = starryTag.getReceiveAppUniteCode();
            String sendAppUniteCode = starryTag.getSendAppUniteCode();
            if (UtilUse.isAppUniteCodeSame(sendAppUniteCode, receiveAppUniteCode)) {
                receiveAppUniteCode = sendAppUniteCode;
            }
            if (receiveAppUniteCode == null) {
                receiveAppUniteCode = "";
            }
            String str2 = TAG;
            LogUtil.dPrimary(str2, "------sendMessage1  DeviceId=" + starryTag.getDeviceId() + "  SendAppUniteCode=" + sendAppUniteCode + "  ReceiveAppUniteCode=" + receiveAppUniteCode);
            AbilityBean deviceById = RelayDeviceManager.getInstance().getDeviceById(starryTag.getDeviceId());
            if (deviceById == null) {
                LogUtil.dPrimary(str2, "------SEND_ERROR203101");
                if (sendRelayMessageCallBack2 != null) {
                    sendRelayMessageCallBack2.onError(RelayErrorCode.DEVICE_ERROR, RelayErrorCode.getErrorText(RelayErrorCode.DEVICE_ERROR));
                }
            } else if (sendRelayMessageCallBack2 == null || bArr2 != null) {
                if (sendRelayMessageCallBack2 != null) {
                    RelayDeviceManager.getInstance().addSendMessageListener(uniqueKey, sendRelayMessageCallBack2);
                }
                int listenerId = (starryParam == null || starryParam.getListenerId() <= 0) ? 0 : starryParam.getListenerId();
                IAbilitySlot.SlotObserver observer = deviceById.getObserver();
                if (observer != null) {
                    boolean z = sendRelayMessageCallBack2 != null;
                    RelayApi.Message.Builder msg = RelayApi.Message.newBuilder().setType(RelayApi.StreamType.SEND_MSG).setMsg(ByteString.copyFrom(bArr, i, i2));
                    if (receiveAppUniteCode.equals(sendAppUniteCode)) {
                        str = "";
                    } else {
                        str = receiveAppUniteCode;
                    }
                    msg.setSendAppUniteCode(sendAppUniteCode);
                    msg.setReceiveAppUniteCode(str);
                    if (listenerId > 0) {
                        msg.setListenerId(starryParam.getListenerId());
                    }
                    if (z) {
                        msg.setMsgUniqueKey(uniqueKey).setNeedCallBack(true);
                    }
                    RelayApi.Message build = msg.build();
                    LogUtil.dPrimary(str2, "------sendMessage2 uniqueKey=" + uniqueKey + "  SendAppUniteCode=" + starryTag.getSendAppUniteCode() + "  ReceiveAppUniteCode=" + str + "  msg.length=" + bArr2.length + "  listenerId=" + listenerId + "  supportMap=" + false + " needCallback=" + z);
                    if (z) {
                        RelayTrackManager.getSIntance().trackSendMessage(starryTag.getDeviceId(), uniqueKey, starryTag.getSendAppUniteCode(), str, bArr2.length + "", false + "");
                    }
                    AbilityMessage.Qos qos = AbilityMessage.Qos.AM_QOS_0;
                    if (i4 == 1) {
                        qos = AbilityMessage.Qos.AM_QOS_1;
                    } else if (i4 == 2) {
                        qos = AbilityMessage.Qos.AM_QOS_2;
                    } else if (i4 == 3) {
                        qos = AbilityMessage.Qos.AM_QOS_3;
                    }
                    observer.output(deviceById.getDevice(), new AbilityMessage(build.toByteArray(), qos));
                    if (z) {
                        this.timeOut.sendRemoveMessage(true, uniqueKey);
                    }
                }
            } else {
                LogUtil.dPrimary(str2, "------SEND_ERROR203011");
                sendRelayMessageCallBack2.onError(RelayErrorCode.MESSAGE_IS_NULL, RelayErrorCode.getErrorText(RelayErrorCode.MESSAGE_IS_NULL));
            }
        } else if (sendRelayMessageCallBack2 != null) {
            sendRelayMessageCallBack2.onError(RelayErrorCode.STARRY_TAG_IS_NULL, RelayErrorCode.getErrorText(RelayErrorCode.STARRY_TAG_IS_NULL));
        }
    }
}
