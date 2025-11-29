package com.upuphone.runasone.service;

import android.content.Context;
import android.os.Bundle;
import com.honey.account.k6.a;
import com.upuphone.runasone.channel.virtual.IBridgeConnectCallback;
import com.upuphone.runasone.connection.gateway.IGateWay;
import com.upuphone.runasone.device.IDeviceListenerInner;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.Utils;
import com.upuphone.starrynet.api.ILanConnectCallback;
import com.upuphone.starrynet.api.IPublisher;
import com.upuphone.starrynet.api.IStarryDiscoveryCallback;
import com.upuphone.starrynet.api.IStarryNetApiCallback;
import com.upuphone.starrynet.api.IStarryOperateCallback;
import com.upuphone.starrynet.api.IStarryService;
import com.upuphone.starrynet.api.StarryNetApi;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.api.bean.DiscoverySettings;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.api.bean.StMessage;
import com.upuphone.starrynet.api.message.IMessageResponseListener;
import com.upuphone.starrynet.api.message.IReceiveMessageListener;
import com.upuphone.starrynet.api.message.IReceivePayloadMessageListener;
import java.util.List;

public class StarrynetApiImpl {
    private static StarrynetApiImpl apiImpl = new StarrynetApiImpl();
    private static StarryConnectCallback connectCallback = new StarryConnectCallback();
    private static DirectConnectCallBack directConnectCallBack = new DirectConnectCallBack();
    private static RunAsOnePublisher publisher = new RunAsOnePublisher();
    private static IStarryService starryNetApi = StarryNetApi.getStarryService();
    public static IPublisher.IHandler starryNetHandler = null;

    private StarrynetApiImpl() {
    }

    public static IBridgeConnectCallback getBridgeConnectImpl() {
        return connectCallback;
    }

    public static ILanConnectCallback getConnectImpl() {
        return connectCallback;
    }

    public static StarrynetApiImpl getInstance() {
        return apiImpl;
    }

    public static IPublisher.IHandler getStarryNetHandler() {
        return starryNetHandler;
    }

    public static void init(Context context, IStarryNetApiCallback iStarryNetApiCallback) {
        StarryNetApi.init(context, new a(iStarryNetApiCallback));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$init$0(IStarryNetApiCallback iStarryNetApiCallback) {
        if (iStarryNetApiCallback != null) {
            iStarryNetApiCallback.onInit();
        }
        starryNetApi.getStarryConnectManager().setConnectionStateChangeCallback(connectCallback);
        starryNetApi.getStarryConnectManager().setDirectConnectCallBack(directConnectCallBack);
        starryNetHandler = starryNetApi.getStarryConnectManager().registerPublisher(publisher);
        starryNetApi.startUp();
    }

    public void addConnectCallback(IGateWay.OnGateWayStateChanged onGateWayStateChanged) {
        connectCallback.addConnectCallback(onGateWayStateChanged);
    }

    public int cancelAuth(byte[] bArr) {
        return starryNetApi.getStarryConnectManager().cancelAuth(bArr);
    }

    public boolean connect(StDevice stDevice, int i) {
        int connect = starryNetApi.getStarryConnectManager().connect(stDevice, i);
        LogUtil.d("ret = " + connect);
        return true;
    }

    public void createBond(byte[] bArr) {
        starryNetApi.getStarryConnectManager().createBond(bArr);
    }

    public void dial(String str) {
        starryNetApi.getStarryOperateManager().dial(str);
    }

    public boolean disConnectWifiAp(StDevice stDevice) {
        int disconnect = starryNetApi.getStarryConnectManager().disconnect(stDevice, 4);
        LogUtil.d("ret = " + disconnect);
        return true;
    }

    public void disableFastConnect() {
        starryNetApi.getStarryDiscoveryManager().disableFastConnect();
    }

    public boolean disconnect(StDevice stDevice, int i) {
        int disconnect = starryNetApi.getStarryConnectManager().disconnect(stDevice, i);
        LogUtil.d("ret = " + disconnect);
        return true;
    }

    public boolean disconnectP2p(StDevice stDevice) {
        int disconnect = starryNetApi.getStarryConnectManager().disconnect(stDevice, 2);
        LogUtil.d("ret = " + disconnect);
        return true;
    }

    public void enableFastConnect() {
        starryNetApi.getStarryDiscoveryManager().enableFastConnect();
    }

    public int enableFastConnectWithTimeOut(long j) {
        return starryNetApi.getStarryDiscoveryManager().enableFastConnectWithTimeOut(j);
    }

    public StDevice getAudioPlayDevice() {
        return starryNetApi.getStarryOperateManager().getAudioPlayDevice();
    }

    public List<StDevice> getBondedDevices() {
        return starryNetApi.getBondedDevices();
    }

    public int getCharacterCategory(String str) {
        return starryNetApi.getStarryTransferManager().getDeviceCharacterCategory(str);
    }

    public int getCharacterCategoryByIdt(byte[] bArr) {
        return starryNetApi.getStarryTransferManager().getDeviceCharacterCategoryByIdt(bArr);
    }

    public List<StDevice> getConnectedDevices(int i) {
        return starryNetApi.getConnectedDevices(i);
    }

    public int getDeviceConnectable(byte[] bArr) {
        return starryNetApi.getStarryConnectManager().getDeviceConnectable(bArr);
    }

    public String getDeviceDetailInfo(byte[] bArr, int i) {
        return starryNetApi.getDeviceDetailInfo(bArr, i);
    }

    public int getDeviceState(byte[] bArr, int i) {
        return starryNetApi.getDeviceState(bArr, i);
    }

    public StDevice getOwnDevice() {
        return starryNetApi.getOwnDevice();
    }

    public String getSelfId() {
        StDevice ownDevice = getOwnDevice();
        if (ownDevice != null) {
            return Utils.bytes2HexString(ownDevice.getIdentifier());
        }
        return null;
    }

    public void operateAction(int i, int i2) {
        starryNetApi.getStarryOperateManager().operateAction(i, i2);
    }

    public void registerDeviceListener(IDeviceListenerInner iDeviceListenerInner) {
        connectCallback.registerDeviceListener(iDeviceListenerInner);
    }

    public void registerOperateCallback(IStarryOperateCallback iStarryOperateCallback) {
        starryNetApi.getStarryOperateManager().registerOperateCallback(iStarryOperateCallback);
    }

    public void registerReceiveMessageListener(String str, IReceiveMessageListener iReceiveMessageListener) {
        starryNetApi.getStarryTransferManager().registerReceiveMessageListener(str, iReceiveMessageListener);
    }

    public void registerReceivePayloadMessageListener(IReceivePayloadMessageListener iReceivePayloadMessageListener) {
        starryNetApi.getStarryTransferManager().registerReceivePayloadMessageListener(iReceivePayloadMessageListener);
    }

    public void removeBond(byte[] bArr) {
        starryNetApi.getStarryConnectManager().removeBond(bArr);
    }

    public void requestAuth(byte[] bArr, byte[] bArr2) {
        starryNetApi.getStarryConnectManager().requestAuth(bArr, bArr2);
    }

    public int requestConnect(byte[] bArr) {
        return starryNetApi.getStarryDiscoveryManager().requestConnect(bArr);
    }

    public int requestConnectWithTime(byte[] bArr, long j) {
        return starryNetApi.getStarryDiscoveryManager().requestConnectWithTime(bArr, j);
    }

    public int sendMessage(StMessage stMessage) {
        return starryNetApi.getStarryTransferManager().sendSyncMessage(stMessage);
    }

    public void sendPayloadMessage(Bundle bundle, IMessageResponseListener iMessageResponseListener) {
        starryNetApi.getStarryTransferManager().sendPayloadMessage(bundle, iMessageResponseListener);
    }

    public int sendSyncMessage(StMessage stMessage) {
        return starryNetApi.getStarryTransferManager().sendSyncMessage(stMessage);
    }

    public int setAdvertiseEnableMode(int i) {
        return starryNetApi.getStarryDiscoveryManager().setAdvertiseEnableMode(i);
    }

    public void setDefaultPort(int i) {
        starryNetApi.getStarryConnectManager().setDefaultPort(i);
    }

    public int setDeviceConnectable(boolean z, int i, String str) {
        return starryNetApi.getStarryDiscoveryManager().setDeviceConnectable(z, i, str);
    }

    public void setDiscoveryFilter(DiscoveryFilter discoveryFilter) {
        starryNetApi.getStarryDiscoveryManager().setDiscoveryFilter(discoveryFilter);
    }

    public int setFastConnectProcess(int i) {
        return starryNetApi.getStarryDiscoveryManager().setFastConnectProcess(i);
    }

    public int setReconnectEnable(boolean z) {
        return starryNetApi.getStarryDiscoveryManager().setReconnectEnable(z);
    }

    public boolean starryNetStackActionCmd(int i, Bundle bundle, StDevice stDevice) {
        return starryNetApi.getStarryConnectManager().starryNetStackActionCmd(i, bundle, stDevice);
    }

    public void startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, IStarryDiscoveryCallback iStarryDiscoveryCallback) {
        starryNetApi.getStarryDiscoveryManager().startDiscovery(discoveryFilter, discoverySettings, iStarryDiscoveryCallback);
    }

    public int startMultiDeviceFound() {
        return starryNetApi.getStarryDiscoveryManager().startMultiDeviceFound();
    }

    public void stopDiscovery(String str) {
        starryNetApi.getStarryDiscoveryManager().stopDiscovery(str);
    }

    public int stopMultiDeviceFound(boolean z) {
        return starryNetApi.getStarryDiscoveryManager().stopMultiDeviceFound(z);
    }

    public int switchAudioPlayDevice(StarryDevice starryDevice) {
        return starryNetApi.getStarryOperateManager().switchAudioPlayDevice(starryDevice.getStarryDevice());
    }

    public int updateAdvParams(byte[] bArr) {
        return starryNetApi.getStarryDiscoveryManager().updateAdvParams(bArr);
    }
}
