package com.upuphone.runasone.channel;

import com.upuphone.runasone.ability.AbilityRouterImpl;
import com.upuphone.runasone.ability.EnumAbility;
import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.channel.bean.auth.AuthBean;
import com.upuphone.runasone.channel.bean.auth.AuthParameter;
import com.upuphone.runasone.channel.bean.stream.LinkerStatus;
import com.upuphone.runasone.channel.bean.virtual.ChannelType;
import com.upuphone.runasone.channel.linker.EnumLinker;
import com.upuphone.runasone.channel.linker.ILinker;
import com.upuphone.runasone.channel.linker.LinkerFactory;
import com.upuphone.runasone.device.DeviceManagerImpl;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.message.ChannelMessage;
import com.upuphone.runasone.utils.LogUtil;
import java.util.HashMap;
import java.util.List;

public class SimplifiedChannelImpl implements IChannel, ILinker.LinkerStreamObserver {
    private static final String TAG = "SimplifiedChannelImpl";
    private boolean bLink = false;
    private IChannel.BiObserver mBiObserver;
    private StarryDevice mDevice;
    private String mDeviceId;
    private ILinker mLinker;
    private IChannel.LinkerStateObserver mLinkerStateObserver;

    public SimplifiedChannelImpl(StarryDevice starryDevice) {
        this.mDevice = starryDevice;
        this.mDeviceId = starryDevice.getId();
        ILinker instance = LinkerFactory.getInstance(EnumLinker.TYPE_LINK_SIMPLIFIED);
        this.mLinker = instance;
        if (instance != null) {
            instance.startup(getDeviceId(), this);
            String str = TAG;
            LogUtil.d(str, (Object) "Linker <" + getDeviceId() + "> alloc success");
            return;
        }
        String str2 = TAG;
        LogUtil.e(str2, (Object) "Linker <" + getDeviceId() + "> alloc fail !!!");
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
        return ChannelType.SIMPLIFY;
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
        return null;
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

    public void input(EnumLinker enumLinker, ChannelMessage channelMessage) {
        IChannel.BiObserver biObserver = this.mBiObserver;
        if (biObserver != null) {
            biObserver.input(channelMessage);
        }
    }

    public boolean isAuthTransition() {
        return false;
    }

    public boolean isLinkUp() {
        return this.bLink;
    }

    public boolean link(EnumLinkStrategy enumLinkStrategy, boolean z) {
        if (DeviceManagerImpl.getInstance().findConnectDevice(getDeviceId()) == null) {
            String str = TAG;
            LogUtil.ePrimary(str, "findStarryDevice bypass <" + getDeviceId() + "> is null");
            return false;
        }
        LogUtil.d("device:" + getDeviceId() + "link bServer: " + z);
        this.bLink = true;
        return this.mLinker.open(z, (AuthParameter) null);
    }

    public void onRetransmission(EnumLinker enumLinker, long j, long j2) {
    }

    public void onStreamClose(EnumLinker enumLinker) {
        IChannel.LinkerStateObserver linkerStateObserver = this.mLinkerStateObserver;
        if (linkerStateObserver != null) {
            linkerStateObserver.onLinkDown(getDevice(), enumLinker);
        }
    }

    public void onStreamError(EnumLinker enumLinker, int i) {
        IChannel.LinkerStateObserver linkerStateObserver = this.mLinkerStateObserver;
        if (linkerStateObserver != null) {
            linkerStateObserver.onLinkError(getDevice(), enumLinker, i);
        }
    }

    public void onStreamOpen(EnumLinker enumLinker, AuthParameter authParameter) {
        IChannel.LinkerStateObserver linkerStateObserver = this.mLinkerStateObserver;
        if (linkerStateObserver != null) {
            linkerStateObserver.onLinkUp(getDevice(), enumLinker);
        }
    }

    public void onStreamTearDown(EnumLinker enumLinker) {
    }

    public void onUpdateQos(EnumLinker enumLinker, int i) {
    }

    public int output(ChannelMessage channelMessage) {
        this.mLinker.output(channelMessage);
        return 0;
    }

    public void release() {
        this.mLinker.shutdown();
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
        LogUtil.d("device:" + getDeviceId() + "unlink");
        this.bLink = false;
        this.mLinker.close();
    }

    public boolean isLinkUp(EnumLinkStrategy enumLinkStrategy) {
        return this.bLink;
    }
}
