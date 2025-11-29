package com.upuphone.runasone.channel;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.channel.IChannelManager;
import com.upuphone.runasone.channel.bean.debug.ChannelBean;
import com.upuphone.runasone.channel.bean.debug.DebugInfoBean;
import com.upuphone.runasone.channel.bean.stream.LinkerStatus;
import com.upuphone.runasone.channel.linker.EnumLinker;
import com.upuphone.runasone.channel.linker.websocket.server.WsServer;
import com.upuphone.runasone.channel.virtual.IVirtualChannel;
import com.upuphone.runasone.channel.virtual.InputProxy;
import com.upuphone.runasone.channel.virtual.VirtualChannelImpl;
import com.upuphone.runasone.connection.LanDirectConnector;
import com.upuphone.runasone.device.DeviceManagerImpl;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ChannelManagerImpl implements IChannelManager, IChannel.LinkerStateObserver {
    private static final String TAG = "ChannelManagerImpl";
    private static ChannelManagerImpl mInstance = new ChannelManagerImpl();
    private ConcurrentHashMap<String, IChannel> mChannelMap = new ConcurrentHashMap<>();
    private IChannelManager.ChannelObserver mChannelObserver;
    private ConcurrentHashMap<String, IChannel> mHighLinkedChannelMap = new ConcurrentHashMap<>();
    private HandlerThread mPrintThread;
    private PowerManager.WakeLock wakeLock;

    private ChannelManagerImpl() {
    }

    public static ChannelManagerImpl getInstance() {
        return mInstance;
    }

    private void release(String str) {
        IChannel iChannel = this.mChannelMap.get(str);
        if (iChannel != null) {
            iChannel.release();
            this.mChannelMap.remove(str);
            String str2 = TAG;
            LogUtil.d(str2, (Object) "release Channel <" + str + "> success");
            return;
        }
        String str3 = TAG;
        LogUtil.e(str3, (Object) "Channel <" + str + "> is un-valid, no need release");
    }

    private void releaseAllChannel() {
        for (Map.Entry<String, IChannel> key : this.mChannelMap.entrySet()) {
            release((String) key.getKey());
        }
        LogUtil.d(TAG, (Object) "release all Channel success");
        trackStatusOrNot();
    }

    private void trackStatusOrNot() {
        try {
            getStatus();
        } catch (Exception e) {
            e.printStackTrace();
        }
        synchronized (this) {
            try {
                if (this.mChannelMap.isEmpty()) {
                    HandlerThread handlerThread = this.mPrintThread;
                    if (handlerThread != null) {
                        handlerThread.quitSafely();
                        this.mPrintThread = null;
                    }
                } else if (this.mPrintThread == null) {
                    HandlerThread handlerThread2 = new HandlerThread("Channel-Status-Print-Thread");
                    this.mPrintThread = handlerThread2;
                    handlerThread2.start();
                    new Handler(this.mPrintThread.getLooper()) {
                        public void handleMessage(@NonNull Message message) {
                            try {
                                ChannelManagerImpl.this.getStatus();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            sendEmptyMessageDelayed(1, 10000);
                        }
                    }.sendEmptyMessageDelayed(1, 10000);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized IChannel allocChannel(StarryDevice starryDevice, EnumLinkStrategy enumLinkStrategy) {
        IChannel iChannel;
        IChannel channelImpl;
        try {
            String id = starryDevice.getId();
            iChannel = this.mChannelMap.get(id);
            if (iChannel == null) {
                if (EnumLinkStrategy.STRATEGY_SIMPLIFIED == enumLinkStrategy) {
                    String str = TAG;
                    LogUtil.d(str, (Object) "Create Channel for Device <" + id + "> bSimplified:ture");
                    channelImpl = new SimplifiedChannelImpl(starryDevice);
                } else {
                    String str2 = TAG;
                    LogUtil.d(str2, (Object) "Create Channel for Device <" + id + "> bSimplified：false");
                    channelImpl = new ChannelImpl(starryDevice);
                }
                iChannel = channelImpl;
                iChannel.setLinkerStateObserver(this);
                this.mChannelMap.put(id, iChannel);
            } else {
                String str3 = TAG;
                LogUtil.e(str3, (Object) "Channel <" + id + "> is already alloc");
            }
            trackStatusOrNot();
        } catch (Throwable th) {
            throw th;
        }
        return iChannel;
    }

    public synchronized IVirtualChannel allocVirtualChannel(StarryDevice starryDevice, EnumLinkStrategy enumLinkStrategy, IChannel iChannel) {
        IChannel iChannel2;
        try {
            String id = starryDevice.getId();
            iChannel2 = this.mChannelMap.get(id);
            if (iChannel2 != null) {
                if (iChannel2 instanceof IVirtualChannel) {
                    String str = TAG;
                    LogUtil.e(str, (Object) "虚拟 Channel <" + id + " " + iChannel2.getChannelType() + "> is already alloc");
                }
            }
            if (iChannel2 != null) {
                LogUtil.e("异常--不应该存在这样的Channel");
                releaseChannel(iChannel2.getDevice().getId());
            }
            iChannel2 = new VirtualChannelImpl(starryDevice, iChannel);
            iChannel2.setLinkerStateObserver(this);
            this.mChannelMap.put(id, iChannel2);
        } catch (Throwable th) {
            throw th;
        }
        return (IVirtualChannel) iChannel2;
    }

    public void checkAndWakeLockOrRelease() {
        if ((Utils.isPad() || Utils.isPhone()) && Utils.getContext() != null) {
            long currentTimeMillis = System.currentTimeMillis();
            PowerManager.WakeLock wakeLock2 = this.wakeLock;
            if (!this.mHighLinkedChannelMap.isEmpty()) {
                if (wakeLock2 == null) {
                    wakeLock2 = ((PowerManager) Utils.getContext().getSystemService("power")).newWakeLock(1, "com.upuphone.starrynet:channel_wakelock");
                    wakeLock2.acquire();
                    LogUtil.i("ChannelLock", (Object) "Lock pad when high channel connect");
                }
            } else if (wakeLock2 != null) {
                if (wakeLock2.isHeld()) {
                    wakeLock2.release();
                    LogUtil.i("ChannelLock", (Object) "Unlock pad when high channel disconnect");
                }
                wakeLock2 = null;
            }
            this.wakeLock = wakeLock2;
            StringBuilder sb = new StringBuilder();
            sb.append(wakeLock2 == null ? "Unlock" : "Lock");
            sb.append(" process block ");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            sb.append("ms");
            LogUtil.i("ChannelLock", (Object) sb.toString());
        }
    }

    public Map<String, IChannel> findAllChannel() {
        return new ConcurrentHashMap(this.mChannelMap);
    }

    public IChannel findChannelById(String str) {
        return this.mChannelMap.get(str);
    }

    public String getStatus() {
        ChannelManagerImpl channelManagerImpl = this;
        Gson gson = new Gson();
        String str = TAG;
        LogUtil.d(str, (Object) " --------------------------------------------- ");
        if (channelManagerImpl.mChannelMap.isEmpty()) {
            LogUtil.d("no channel valid");
            return "un-invalid";
        }
        String selfId = DeviceManagerImpl.getInstance().getSelfDevice().getSelfId();
        String name = DeviceManagerImpl.getInstance().getSelfDevice().getName();
        LogUtil.d(str, (Object) " - selfId: " + selfId);
        LogUtil.d(str, (Object) " - selfName: " + name);
        LogUtil.d(str, (Object) " - Direct:" + LanDirectConnector.getInstance().getStatus());
        LogUtil.d(str, (Object) " --------------- 当前可用通道列表 --------------- ");
        DebugInfoBean debugInfoBean = new DebugInfoBean();
        debugInfoBean.setSelfId(selfId);
        debugInfoBean.setSelfName(name);
        debugInfoBean.setVersion(Utils.getVersionName());
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, IChannel> key : channelManagerImpl.mChannelMap.entrySet()) {
            String str2 = (String) key.getKey();
            IChannel iChannel = channelManagerImpl.mChannelMap.get(str2);
            if (!iChannel.isLinkUp()) {
                LogUtil.e("channel <" + str2 + "> is unlink");
                LogUtil.d(TAG, (Object) " --------------------------------------------- ");
            } else {
                String name2 = iChannel.getDevice().getName();
                String str3 = TAG;
                LogUtil.d(str3, (Object) " - channel <" + str2 + ">  name:" + name2);
                LogUtil.d(str3, (Object) " - linkup:" + iChannel.isLinkUp() + " createTime:" + iChannel.getCreateTime());
                long deltaSysTime = iChannel.getDeltaSysTime();
                if (deltaSysTime > 0) {
                    LogUtil.d(str3, (Object) " - 本端系统时钟超前对端 " + deltaSysTime + " ms");
                } else {
                    LogUtil.d(str3, (Object) " - 本端系统时钟滞后对端 " + (0 - deltaSysTime) + " ms");
                }
                HashMap<EnumLinker, LinkerStatus> linkerStatus = iChannel.getLinkerStatus();
                if (linkerStatus == null) {
                    LogUtil.e(str3, (Object) "getLinkerStatus null");
                } else {
                    ChannelBean channelBean = new ChannelBean();
                    ChannelBean.Status status = new ChannelBean.Status();
                    channelBean.setChannelId(str2);
                    channelBean.setDeviceType(DeviceManagerImpl.getInstance().findConnectDevice(str2).getStarryDevice().getDeviceType());
                    channelBean.setDeviceName(name2);
                    channelBean.setDeltaSystemTime(deltaSysTime);
                    channelBean.setVersion(iChannel.getVersion());
                    channelBean.setCoreCommit(iChannel.getCoreCommit());
                    channelBean.setRemoteAbilityList(iChannel.getRemoteAbilityList());
                    channelBean.setLocalAbilityList(iChannel.getLocalAbilityList());
                    channelBean.setActiveAbilityList(iChannel.getActiveAbilityList());
                    status.setLinkUp(iChannel.isLinkUp());
                    status.setCreateTime(iChannel.getCreateTime());
                    ArrayList arrayList2 = new ArrayList();
                    for (Map.Entry next : linkerStatus.entrySet()) {
                        EnumLinker enumLinker = (EnumLinker) next.getKey();
                        String type = ((LinkerStatus) next.getValue()).getType();
                        String str4 = TAG;
                        LogUtil.d(str4, (Object) " - EnumLinker: " + enumLinker);
                        StringBuilder sb = new StringBuilder();
                        sb.append(" - ChannelType: ");
                        if (type == null) {
                            type = "REAL";
                        }
                        sb.append(type);
                        LogUtil.d(str4, (Object) sb.toString());
                        arrayList2.add(linkerStatus.get(enumLinker));
                    }
                    status.setLinkerList(arrayList2);
                    String str5 = TAG;
                    LogUtil.d(str5, (Object) " - OutputTotalSize:" + iChannel.getOutputTotalSize() + " packetOutput:" + iChannel.getPacketOutput() + " packetRetransmission:" + iChannel.getPacketRetransmission());
                    LogUtil.d(str5, (Object) " - InputTotalSize:" + iChannel.getInputTotalSize() + " packetInput:" + iChannel.getPacketInput() + " packetLoss:" + iChannel.getPacketLoss());
                    status.setOutputTotalSize(iChannel.getOutputTotalSize());
                    status.setInputTotalSize(iChannel.getInputTotalSize());
                    channelBean.setStatus(status);
                    String json = gson.toJson((Object) channelBean);
                    if (!Utils.isHQ()) {
                        LogUtil.d(str5, (Object) " - Status: " + json);
                    }
                    LogUtil.d(str5, (Object) " --------------------------------------------- ");
                    arrayList.add(channelBean);
                }
                channelManagerImpl = this;
            }
        }
        debugInfoBean.setChannelBeanList(arrayList);
        return gson.toJson((Object) debugInfoBean);
    }

    public synchronized void initServer(int i) {
        WsServer.getInstance().init(i);
    }

    public void install() {
        LogUtil.d("install");
        InputProxy.getInstance().install();
    }

    public boolean isAuthTransition(String str) {
        IChannel iChannel = this.mChannelMap.get(str);
        if (iChannel != null) {
            return iChannel.isAuthTransition();
        }
        LogUtil.e("isAuthTransition fail");
        return false;
    }

    public void onLinkDown(StarryDevice starryDevice, EnumLinker enumLinker) {
        String str = TAG;
        LogUtil.d(str, (Object) "onLinkDown device:" + starryDevice.getName() + " id:" + starryDevice.getId() + " type:" + enumLinker);
        IChannelManager.ChannelObserver channelObserver = this.mChannelObserver;
        if (channelObserver != null) {
            channelObserver.onChannelLinkDown(starryDevice, Utils.mapLinkStrategy(enumLinker));
        }
        if (enumLinker == EnumLinker.TYPE_LINK_WS && !TextUtils.isEmpty(starryDevice.getId())) {
            this.mHighLinkedChannelMap.remove(starryDevice.getId());
        }
        checkAndWakeLockOrRelease();
    }

    public void onLinkError(StarryDevice starryDevice, EnumLinker enumLinker, int i) {
        String str = TAG;
        LogUtil.d(str, (Object) "onError device:" + starryDevice.getName() + " id:" + starryDevice.getId() + " errorCode:" + i);
        IChannelManager.ChannelObserver channelObserver = this.mChannelObserver;
        if (channelObserver != null) {
            channelObserver.onChannelError(starryDevice, Utils.mapLinkStrategy(enumLinker), i);
        }
        if (enumLinker == EnumLinker.TYPE_LINK_WS && !TextUtils.isEmpty(starryDevice.getId())) {
            this.mHighLinkedChannelMap.remove(starryDevice.getId());
        }
        checkAndWakeLockOrRelease();
    }

    public void onLinkUp(StarryDevice starryDevice, EnumLinker enumLinker) {
        String str = TAG;
        LogUtil.d(str, (Object) "onLinkUp  device:" + starryDevice.getName() + " id:" + starryDevice.getId() + " type:" + enumLinker);
        IChannelManager.ChannelObserver channelObserver = this.mChannelObserver;
        if (channelObserver != null) {
            channelObserver.onChannelLinkUp(starryDevice, Utils.mapLinkStrategy(enumLinker));
        }
        if (enumLinker == EnumLinker.TYPE_LINK_WS && !TextUtils.isEmpty(starryDevice.getId())) {
            this.mHighLinkedChannelMap.put(starryDevice.getId(), findChannelById(starryDevice.getId()));
        }
        checkAndWakeLockOrRelease();
    }

    public synchronized void releaseChannel(String str) {
        release(str);
        trackStatusOrNot();
    }

    public void setChannelObserver(IChannelManager.ChannelObserver channelObserver) {
        this.mChannelObserver = channelObserver;
    }

    public void uninstall() {
        releaseAllChannel();
        InputProxy.getInstance().uninstall();
    }
}
