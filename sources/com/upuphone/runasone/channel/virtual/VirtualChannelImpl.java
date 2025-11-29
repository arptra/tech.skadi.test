package com.upuphone.runasone.channel.virtual;

import com.upuphone.runasone.StreamType;
import com.upuphone.runasone.ability.AbilityRouterImpl;
import com.upuphone.runasone.ability.EnumAbility;
import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.channel.bean.auth.AuthBean;
import com.upuphone.runasone.channel.bean.stream.LinkerStatus;
import com.upuphone.runasone.channel.bean.virtual.ChannelType;
import com.upuphone.runasone.channel.linker.EnumLinker;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.message.ChannelMessage;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.Utils;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class VirtualChannelImpl implements IVirtualChannel {
    private static final String TAG = "VirtualChannelImpl";
    private HashMap<EnumLinker, LinkerStatus> linkerStatusMap = new HashMap<>();
    private IChannel.BiObserver mBiObserver;
    private StarryDevice mDevice;
    private String mDeviceId;
    private IChannel.LinkerStateObserver mLinkerStateObserver;
    private IChannel mainChannel;

    public VirtualChannelImpl(StarryDevice starryDevice, IChannel iChannel) {
        this.mDevice = starryDevice;
        this.mDeviceId = starryDevice.getId();
        this.mainChannel = iChannel;
    }

    private String getDeviceId() {
        return this.mDeviceId;
    }

    public List<String> getActiveAbilityList() {
        return null;
    }

    public List<EnumAbility> getActiveEnumAbilityList() {
        return null;
    }

    public ChannelType getChannelType() {
        return ChannelType.VIRTUAL;
    }

    public String getCoreCommit() {
        return null;
    }

    public String getCreateTime() {
        return null;
    }

    public long getDeltaSysTime() {
        return 0;
    }

    public StarryDevice getDevice() {
        return this.mDevice;
    }

    public long getInputTotalSize() {
        return 0;
    }

    public HashMap<EnumLinker, LinkerStatus> getLinkerStatus() {
        return this.linkerStatusMap;
    }

    public List<String> getLocalAbilityList() {
        return null;
    }

    public AuthBean getLocalAuthBean() {
        return null;
    }

    public long getOutputTotalSize() {
        return 0;
    }

    public long getPacketInput() {
        return 0;
    }

    public long getPacketLoss() {
        return 0;
    }

    public long getPacketOutput() {
        return 0;
    }

    public long getPacketRetransmission() {
        return 0;
    }

    public List<String> getRemoteAbilityList() {
        return null;
    }

    public AuthBean getRemoteAuthBean() {
        return null;
    }

    public String getVersion() {
        return null;
    }

    public void input(ChannelMessage channelMessage) {
        LogUtil.d("虚拟通道收到消息");
        IChannel.BiObserver biObserver = this.mBiObserver;
        if (biObserver != null) {
            biObserver.input(channelMessage);
        }
    }

    public boolean isAuthTransition() {
        return false;
    }

    public boolean isLinkUp() {
        return !this.linkerStatusMap.isEmpty();
    }

    public boolean link(EnumLinkStrategy enumLinkStrategy, boolean z) {
        String str = TAG;
        LogUtil.i(str, (Object) "link=" + enumLinkStrategy);
        return true;
    }

    public void linkDown(StarryDevice starryDevice, EnumLinker enumLinker) {
        IChannel.LinkerStateObserver linkerStateObserver = this.mLinkerStateObserver;
        if (linkerStateObserver != null) {
            linkerStateObserver.onLinkDown(starryDevice, enumLinker);
        }
    }

    public void linkUp(StarryDevice starryDevice, EnumLinker enumLinker) {
        LinkerStatus linkerStatus = new LinkerStatus();
        linkerStatus.setStartTime(DateFormat.getDateTimeInstance().format(new Date()));
        linkerStatus.setLinkerName(enumLinker.toString());
        linkerStatus.setType(getChannelType().toString());
        this.linkerStatusMap.put(enumLinker, linkerStatus);
        IChannel.LinkerStateObserver linkerStateObserver = this.mLinkerStateObserver;
        if (linkerStateObserver != null) {
            linkerStateObserver.onLinkUp(starryDevice, enumLinker);
        }
    }

    public int output(ChannelMessage channelMessage) {
        LogUtil.d("虚拟通道外发消息");
        channelMessage.setMessageType(StreamType.BRIDGE);
        return this.mainChannel.output(channelMessage);
    }

    public void release() {
        AbilityRouterImpl.getInstance().unbindChannel(this, EnumLinkStrategy.STRATEGY_DEFAULT);
        AbilityRouterImpl.getInstance().unbindChannel(this, EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE);
        AbilityRouterImpl.getInstance().unbindChannel(this, EnumLinkStrategy.STRATEGY_SIMPLIFIED);
        LogUtil.e("release Channel <" + getDeviceId() + ">");
    }

    public void setIoObserver(IChannel.BiObserver biObserver) {
        this.mBiObserver = biObserver;
    }

    public void setLinkerStateObserver(IChannel.LinkerStateObserver linkerStateObserver) {
        this.mLinkerStateObserver = linkerStateObserver;
    }

    public void teardown(EnumLinkStrategy enumLinkStrategy) {
    }

    public void unlink(EnumLinkStrategy enumLinkStrategy) {
        String str = TAG;
        LogUtil.i(str, (Object) "unlink=" + enumLinkStrategy);
        this.linkerStatusMap.remove(Utils.mapLinker(enumLinkStrategy));
    }

    public boolean isLinkUp(EnumLinkStrategy enumLinkStrategy) {
        return this.linkerStatusMap.get(Utils.mapLinker(enumLinkStrategy)) != null;
    }
}
