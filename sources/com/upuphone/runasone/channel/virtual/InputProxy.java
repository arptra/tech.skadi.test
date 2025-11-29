package com.upuphone.runasone.channel.virtual;

import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.upuphone.runasone.StreamType;
import com.upuphone.runasone.ability.AbilityRouterImpl;
import com.upuphone.runasone.channel.AbstractLooperWorker;
import com.upuphone.runasone.channel.ChannelManagerImpl;
import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.channel.bean.virtual.BroadcastBean;
import com.upuphone.runasone.channel.linker.EnumLinker;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.message.ChannelMessage;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.Utils;

public final class InputProxy extends AbstractLooperWorker {
    private static final int EVENT_FORWARD = 12289;
    private static final String TAG = "InputProxy";
    private static InputProxy instance;

    private InputProxy() {
    }

    private static synchronized InputProxy createInstance() {
        InputProxy inputProxy;
        synchronized (InputProxy.class) {
            try {
                if (instance == null) {
                    instance = new InputProxy();
                }
                inputProxy = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return inputProxy;
    }

    private void forward(ChannelMessage channelMessage) {
        if (channelMessage == null) {
            LogUtil.e(TAG, (Object) "forward fail, message is null");
            return;
        }
        try {
            ChannelMessage clone = channelMessage.clone();
            clone.setId(getSelfId());
            String dstId = channelMessage.getDstId();
            IChannel findChannelById = ChannelManagerImpl.getInstance().findChannelById(dstId);
            if (findChannelById != null) {
                findChannelById.output(clone);
                LogUtil.e(TAG, (Object) "sendTo forward success");
                return;
            }
            String str = TAG;
            LogUtil.e(str, (Object) "sendTo fail, channel <" + dstId + " > is not exist");
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public static InputProxy getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    private void offline(int i, StarryDevice starryDevice, IChannel iChannel) {
        IChannel findChannelById = ChannelManagerImpl.getInstance().findChannelById(starryDevice.getId());
        if (findChannelById != null && (findChannelById instanceof IVirtualChannel)) {
            IVirtualChannel iVirtualChannel = (IVirtualChannel) findChannelById;
            if (i == 3 || !iChannel.isLinkUp()) {
                StarrynetApiImpl.getBridgeConnectImpl().onBleBridgeDisconnected(starryDevice);
                iVirtualChannel.linkDown(starryDevice, EnumLinker.TYPE_LINK_BT);
                StarrynetApiImpl.getBridgeConnectImpl().onP2PBridgeDisconnected(starryDevice);
                iVirtualChannel.linkDown(starryDevice, EnumLinker.TYPE_LINK_WS);
            } else if (i == 1) {
                StarrynetApiImpl.getBridgeConnectImpl().onBleBridgeDisconnected(starryDevice);
                iVirtualChannel.linkDown(starryDevice, EnumLinker.TYPE_LINK_BT);
            } else if (i == 2) {
                StarrynetApiImpl.getBridgeConnectImpl().onP2PBridgeDisconnected(starryDevice);
                iVirtualChannel.linkDown(starryDevice, EnumLinker.TYPE_LINK_WS);
            } else {
                LogUtil.i(TAG, (Object) "V传入无效的值");
            }
        } else if (findChannelById != null) {
            String str = TAG;
            LogUtil.e(str, (Object) "V类型异常-----" + findChannelById.getChannelType());
        } else {
            LogUtil.i(TAG, (Object) "V虚拟通道已经不存在了");
        }
    }

    private void online(int i, StarryDevice starryDevice, IChannel iChannel) {
        if ((i & 2) == 2) {
            EnumLinkStrategy enumLinkStrategy = EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE;
            if (iChannel.isLinkUp(enumLinkStrategy)) {
                LogUtil.e("桥接高速通道");
                StarrynetApiImpl.getBridgeConnectImpl().onP2PBridgeConnected(starryDevice);
                IVirtualChannel allocVirtualChannel = ChannelManagerImpl.getInstance().allocVirtualChannel(starryDevice, enumLinkStrategy, iChannel);
                allocVirtualChannel.link(enumLinkStrategy, true);
                allocVirtualChannel.linkUp(starryDevice, EnumLinker.TYPE_LINK_WS);
                AbilityRouterImpl.getInstance().bindChannel(allocVirtualChannel, enumLinkStrategy);
                return;
            }
        }
        if (iChannel.isLinkUp()) {
            LogUtil.e("桥接低速通道");
            StarrynetApiImpl.getBridgeConnectImpl().onBleBridgeConnected(starryDevice);
            ChannelManagerImpl instance2 = ChannelManagerImpl.getInstance();
            EnumLinkStrategy enumLinkStrategy2 = EnumLinkStrategy.STRATEGY_DEFAULT;
            IVirtualChannel allocVirtualChannel2 = instance2.allocVirtualChannel(starryDevice, enumLinkStrategy2, iChannel);
            allocVirtualChannel2.link(enumLinkStrategy2, true);
            allocVirtualChannel2.linkUp(starryDevice, EnumLinker.TYPE_LINK_BT);
            AbilityRouterImpl.getInstance().bindChannel(allocVirtualChannel2, enumLinkStrategy2);
            return;
        }
        LogUtil.e("没有实体虚拟通道，无法构建桥接虚拟通道");
    }

    private void sendForwardMsg(ChannelMessage channelMessage) {
        try {
            ChannelMessage clone = channelMessage.clone();
            clone.setId(getSelfId());
            Message message = new Message();
            message.what = EVENT_FORWARD;
            message.obj = clone;
            sendMessage(message);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean filterInput(ChannelMessage channelMessage, IChannel iChannel) {
        StreamType messageType = channelMessage.getMessageType();
        String dstId = channelMessage.getDstId();
        String id = iChannel.getDevice().getId();
        if (messageType == null || dstId == null) {
            String str = TAG;
            LogUtil.e(str, (Object) "filterInput do nothing, un-invalid params, type:" + messageType + " dstId:" + dstId + " !!!");
            return false;
        }
        String str2 = TAG;
        LogUtil.d(str2, (Object) "filterInput message type:" + messageType + " dstId:" + dstId);
        if (!getSelfId().equals(dstId)) {
            LogUtil.d(str2, (Object) "消息转发至: " + dstId);
            sendForwardMsg(channelMessage);
            return true;
        } else if (!TextUtils.isEmpty(channelMessage.getSrcId()) && !TextUtils.equals(channelMessage.getSrcId(), id)) {
            LogUtil.d("filterInput message info --> srcId=" + channelMessage.getSrcId() + " dstId=" + channelMessage.getDstId() + " id=" + channelMessage.getId());
            IChannel findChannelById = ChannelManagerImpl.getInstance().findChannelById(channelMessage.getSrcId());
            if (findChannelById == null || !(findChannelById instanceof IVirtualChannel)) {
                LogUtil.e(findChannelById == null ? "虚拟通道不存在" : "异常，通道非虚拟通道");
                return true;
            }
            channelMessage.setId(channelMessage.getSrcId());
            ((IVirtualChannel) findChannelById).input(channelMessage);
            return true;
        } else if (TextUtils.isEmpty(channelMessage.getSrcId())) {
            LogUtil.e("信息来源不确定，无法处理");
            return true;
        } else {
            LogUtil.e("异常信息，发送给真实通道的桥接消息，无法处理");
            return true;
        }
    }

    public String getSelfId() {
        return Utils.getSelfId();
    }

    public boolean handleAction(String str, String str2, IChannel iChannel) {
        String str3 = TAG;
        LogUtil.d(str3, (Object) "Broadcast->" + str2);
        try {
            BroadcastBean broadcastBean = (BroadcastBean) new Gson().fromJson(str2, BroadcastBean.class);
            StarryDevice targetDevice = broadcastBean.getTargetDevice();
            targetDevice.setSelfId(StarrynetApiImpl.getInstance().getSelfId());
            int throughputType = broadcastBean.getThroughputType();
            int actionType = broadcastBean.getActionType();
            if (actionType == 1) {
                online(throughputType, targetDevice, iChannel);
                return true;
            } else if (actionType != 2) {
                return false;
            } else {
                offline(throughputType, targetDevice, iChannel);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(TAG, (Object) "无法解析json");
            return false;
        }
    }

    public void install() {
        startWorker(TAG);
    }

    public void looperHandler(Message message) {
        if (message.what != EVENT_FORWARD) {
            String str = TAG;
            LogUtil.e(str, (Object) "un-catch " + message.what);
            return;
        }
        forward((ChannelMessage) message.obj);
    }

    public void looperStarted() {
    }

    public void uninstall() {
        stopWorker();
    }
}
