package com.upuphone.runasone.channel.core;

import com.google.gson.Gson;
import com.upuphone.runasone.StreamType;
import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.channel.core.bean.ActionBean;
import com.upuphone.runasone.channel.proxy.config.VpnConfigUtils;
import com.upuphone.runasone.channel.virtual.InputProxy;
import com.upuphone.runasone.host.core.api.AbilityMessage;
import com.upuphone.runasone.message.ChannelMessage;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.starrynet.api.IPublisher;
import java.util.Base64;

public final class InputCore {
    private static final String TAG = "InputCore";
    private static InputCore instance;

    /* renamed from: com.upuphone.runasone.channel.core.InputCore$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$upuphone$runasone$StreamType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.upuphone.runasone.StreamType[] r0 = com.upuphone.runasone.StreamType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$upuphone$runasone$StreamType = r0
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.ACTION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.BRIDGE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.core.InputCore.AnonymousClass1.<clinit>():void");
        }
    }

    private InputCore() {
    }

    private static synchronized InputCore createInstance() {
        InputCore inputCore;
        synchronized (InputCore.class) {
            try {
                if (instance == null) {
                    instance = new InputCore();
                }
                inputCore = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return inputCore;
    }

    public static InputCore getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    private boolean handleAction(String str, AbilityMessage abilityMessage, IChannel iChannel) {
        String str2 = new String(abilityMessage.getBypass());
        String str3 = TAG;
        LogUtil.d(str3, (Object) "message->" + str2);
        try {
            ActionBean actionBean = (ActionBean) new Gson().fromJson(str2, ActionBean.class);
            int actionType = actionBean.getActionType();
            if (actionType == 1 || actionType == 2) {
                return InputProxy.getInstance().handleAction(str, actionBean.getData(), iChannel);
            }
            if (actionType == 3) {
                return handlerStarryNetMessage(str, actionBean.getData());
            }
            if (actionType != 4) {
                return false;
            }
            return VpnConfigUtils.handle(str, actionBean.getData());
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(TAG, (Object) "无法解析json");
            return false;
        }
    }

    public boolean filterInput(ChannelMessage channelMessage, IChannel iChannel) {
        StreamType messageType = channelMessage.getMessageType();
        String dstId = channelMessage.getDstId();
        if (messageType == null) {
            String str = TAG;
            LogUtil.e(str, (Object) "filterInput do nothing, un-invalid params, type:" + messageType + " dstId:" + dstId + " !!!");
            return false;
        }
        String str2 = TAG;
        LogUtil.d(str2, (Object) "filterInput message type:" + messageType + " dstId:" + dstId);
        int i = AnonymousClass1.$SwitchMap$com$upuphone$runasone$StreamType[messageType.ordinal()];
        if (i == 1) {
            return handleAction(channelMessage.getId(), channelMessage.getAbilityMessage(), iChannel);
        }
        if (i == 2) {
            return InputProxy.getInstance().filterInput(channelMessage, iChannel);
        }
        LogUtil.e("filterInput un-catch: " + messageType);
        return false;
    }

    public boolean handlerStarryNetMessage(String str, String str2) {
        byte[] decode = Base64.getDecoder().decode(str2);
        IPublisher.IHandler starryNetHandler = StarrynetApiImpl.getStarryNetHandler();
        if (starryNetHandler != null) {
            starryNetHandler.onHandle(str, decode);
            return true;
        }
        String str3 = TAG;
        LogUtil.d(str3, (Object) "ChannelId=" + str + " is not finish init！");
        return false;
    }
}
