package com.upuphone.runasone.channel;

import com.upuphone.runasone.ability.EnumAbility;
import com.upuphone.runasone.channel.bean.auth.AuthBean;
import com.upuphone.runasone.channel.bean.stream.LinkerStatus;
import com.upuphone.runasone.channel.bean.virtual.ChannelType;
import com.upuphone.runasone.channel.linker.EnumLinker;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.message.ChannelMessage;
import java.util.HashMap;
import java.util.List;

public interface IChannel {

    public interface BiObserver {
        void input(ChannelMessage channelMessage);
    }

    public interface LinkerStateObserver {
        void onLinkDown(StarryDevice starryDevice, EnumLinker enumLinker);

        void onLinkError(StarryDevice starryDevice, EnumLinker enumLinker, int i);

        void onLinkUp(StarryDevice starryDevice, EnumLinker enumLinker);
    }

    List<String> getActiveAbilityList();

    List<EnumAbility> getActiveEnumAbilityList();

    ChannelType getChannelType();

    String getCoreCommit();

    String getCreateTime();

    long getDeltaSysTime();

    StarryDevice getDevice();

    long getInputTotalSize();

    HashMap<EnumLinker, LinkerStatus> getLinkerStatus();

    List<String> getLocalAbilityList();

    AuthBean getLocalAuthBean();

    long getOutputTotalSize();

    long getPacketInput();

    long getPacketLoss();

    long getPacketOutput();

    long getPacketRetransmission();

    List<String> getRemoteAbilityList();

    AuthBean getRemoteAuthBean();

    String getVersion();

    boolean isAuthTransition();

    boolean isLinkUp();

    boolean isLinkUp(EnumLinkStrategy enumLinkStrategy);

    boolean link(EnumLinkStrategy enumLinkStrategy, boolean z);

    int output(ChannelMessage channelMessage);

    void release();

    void setIoObserver(BiObserver biObserver);

    void setLinkerStateObserver(LinkerStateObserver linkerStateObserver);

    void teardown(EnumLinkStrategy enumLinkStrategy);

    void unlink(EnumLinkStrategy enumLinkStrategy);
}
