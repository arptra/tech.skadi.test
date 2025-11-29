package com.upuphone.starrynet.core.ble.channel;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.honey.account.s6.c;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.channel.ReceiveChannel;
import com.upuphone.starrynet.core.ble.channel.packet.Packet;
import com.upuphone.starrynet.core.ble.client.response.BleResponse;
import com.upuphone.starrynet.core.ble.manager.BleReceiveMsgManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SendChannel extends Channel {
    public static final int ATT_HEADER = 3;
    public static final int DEFAULT_MTU_SIZE = 23;
    public static final int DMTU_OFFSET = 5;
    private static final int HANDLE_CTR_TIMEOUT_INTERVAL = 5000;
    public static final int MAX_MTU_SIZE = 512;
    public static final int MAX_PACKAGE_NUM = 6;
    private static final int MSG_ADD_PACKET = 3;
    private static final int MSG_HANDLE_CTR_TIMEOUT = 2;
    private static final int MSG_HANDLE_PACKET = 1;
    private ChannelManager channelManager;
    private AtomicBoolean isReceivingCTR = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public Handler mHandler;
    private Handler.Callback mMsgCallback = new c(this);
    public ReceiveChannel mReceiveChannel;
    private LinkedList<Packet> mReceiveQueue = new LinkedList<>();
    /* access modifiers changed from: private */
    public List<IBleChannelReader> readers;
    /* access modifiers changed from: private */
    public ChannelTag tag;
    private boolean useCrc32;
    IBleChannelWriter writer;

    public SendChannel(final ChannelTag channelTag, final ChannelManager channelManager2, boolean z) {
        this.tag = channelTag;
        this.channelManager = channelManager2;
        this.useCrc32 = z;
        HandlerThread handlerThread = new HandlerThread("SendChannel");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.mMsgCallback);
        this.readers = new ArrayList();
        this.writer = new IBleChannelWriter() {
            public void write(byte[] bArr, int i, final BleResponse<Bundle> bleResponse) {
                SendChannel.this.send(bArr, i, new ChannelCallback() {
                    public void onCallback(int i) {
                        BleResponse bleResponse = bleResponse;
                        if (bleResponse != null) {
                            bleResponse.onResponse(i, null);
                        }
                    }
                });
            }

            public void writeWithOpCode(int i, byte[] bArr, int i2, final BleResponse<Bundle> bleResponse) {
                SendChannel.this.send(i, bArr, i2, new ChannelCallback() {
                    public void onCallback(int i) {
                        BleResponse bleResponse = bleResponse;
                        if (bleResponse != null) {
                            bleResponse.onResponse(i, null);
                        }
                    }
                });
            }
        };
        this.mReceiveChannel = new ReceiveChannel(this, new ReceiveChannel.ReceiveMessageListener() {
            public void onReceive(byte[] bArr, int i) {
                SendChannel.this.mHandler.removeMessages(2);
                SendChannel.this.mHandler.sendEmptyMessage(1);
                SendChannel sendChannel = SendChannel.this;
                sendChannel.log("onReceive tag=" + channelTag + ", packageType = " + i + ", bytes length =" + bArr.length + ", readers size=" + SendChannel.this.readers.size(), new Object[0]);
                if (BluetoothConstants.STARRY_NET_MULTI_WRITE_UUID.equals(channelTag.getCharacter())) {
                    if (i == 0 || i == 1) {
                        BleReceiveMsgManager.getInstance().notifyStickyDataDone(channelManager2.isClient(), SendChannel.this.tag.getBleMac(), i, bArr);
                        return;
                    }
                    BleReceiveMsgManager.getInstance().notifyStickyDataDone(SendChannel.this.tag.getBleMac());
                }
                for (IBleChannelReader iBleChannelReader : SendChannel.this.readers) {
                    if (iBleChannelReader != null) {
                        try {
                            iBleChannelReader.onRead(SendChannel.this.tag, bArr, i);
                        } catch (Exception e) {
                            SendChannel.this.logError("receive channel onReceive message exception, detail=%s", e.getMessage());
                        }
                    }
                }
            }
        });
    }

    private void handleReceivePacket() {
        if (!this.mReceiveQueue.isEmpty()) {
            final boolean z = !this.mReceiveQueue.getFirst().getName().equals("data");
            if (!this.isReceivingCTR.get() || !z) {
                if (z) {
                    this.isReceivingCTR.set(true);
                    this.mHandler.sendEmptyMessageDelayed(2, 5000);
                }
                Packet removeFirst = this.mReceiveQueue.removeFirst();
                log("Receive channel handle packet:" + removeFirst.getName(), new Object[0]);
                this.mReceiveChannel.onReadPacket(removeFirst, new IChannelPacketReadResult() {
                    public void onResult(Packet packet, boolean z) {
                        if (!z) {
                            SendChannel.this.logError("onReadResult packet isHandled=false, packet name = %s", packet.getName());
                            if (z) {
                                SendChannel.this.mHandler.removeMessages(2);
                                SendChannel.this.mHandler.sendEmptyMessage(1);
                            }
                        }
                    }
                });
                if (!this.mReceiveQueue.isEmpty()) {
                    handleReceivePacket();
                    return;
                }
                return;
            }
            log("handleReceivePacket wait", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i == 2) {
                log("handle ctr timeout", new Object[0]);
                if (this.isReceivingCTR.get()) {
                    this.isReceivingCTR.set(false);
                    this.mReceiveChannel.reset(0);
                    if (!this.mReceiveQueue.isEmpty()) {
                        handleReceivePacket();
                    }
                }
            } else if (i == 3) {
                Packet packet = (Packet) message.obj;
                log("onRead, add packet=" + packet.getName(), new Object[0]);
                this.mReceiveQueue.add(packet);
                handleReceivePacket();
            }
        } else if (this.isReceivingCTR.get()) {
            this.isReceivingCTR.set(false);
            if (!this.mReceiveQueue.isEmpty()) {
                handleReceivePacket();
            }
        }
        return true;
    }

    public void addReader(IBleChannelReader iBleChannelReader) {
        if (iBleChannelReader != null) {
            Iterator<IBleChannelReader> it = this.readers.iterator();
            while (it.hasNext()) {
                IBleChannelReader next = it.next();
                if (next != null && next == iBleChannelReader) {
                    return;
                }
                if (next == null) {
                    it.remove();
                }
            }
            this.readers.add(iBleChannelReader);
        }
    }

    public void destroy() {
        List<IBleChannelReader> list = this.readers;
        if (list != null && !list.isEmpty()) {
            this.readers.clear();
        }
        this.mHandler.removeCallbacksAndMessages((Object) null);
        this.mHandler.getLooper().quitSafely();
        this.channelManager = null;
    }

    public int getDMTU() {
        ChannelManager channelManager2 = this.channelManager;
        if (channelManager2 != null) {
            return channelManager2.getDMTU(this.tag.getBleMac());
        }
        return 18;
    }

    public int getMaxPackageNum() {
        return getDMTU() == 18 ? 1 : 6;
    }

    public void onRead(byte[] bArr) {
        Packet packet = Packet.getPacket(bArr);
        String name = packet.getName();
        name.hashCode();
        char c = 65535;
        switch (name.hashCode()) {
            case -1360464572:
                if (name.equals(Packet.SINGLE_CMD_NO_ACK)) {
                    c = 0;
                    break;
                }
                break;
            case 96393:
                if (name.equals(Packet.ACK)) {
                    c = 1;
                    break;
                }
                break;
            case 98849:
                if (name.equals(Packet.CTR)) {
                    c = 2;
                    break;
                }
                break;
            case 3076010:
                if (name.equals("data")) {
                    c = 3;
                    break;
                }
                break;
            case 913950738:
                if (name.equals(Packet.SINGLE_ACK)) {
                    c = 4;
                    break;
                }
                break;
            case 913953194:
                if (name.equals(Packet.SINGLE_CMD)) {
                    c = 5;
                    break;
                }
                break;
            case 968946214:
                if (name.equals(Packet.FAST_ACK)) {
                    c = 6;
                    break;
                }
                break;
            case 968948670:
                if (name.equals(Packet.FAST_CTR)) {
                    c = 7;
                    break;
                }
                break;
            case 1073465790:
                if (name.equals(Packet.MIX_CTR)) {
                    c = 8;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
                this.mHandler.obtainMessage(3, packet).sendToTarget();
                return;
            case 1:
            case 4:
            case 6:
                if (BluetoothConstants.STARRY_NET_MULTI_WRITE_UUID.equals(this.tag.getCharacter())) {
                    BleReceiveMsgManager.getInstance().notifyStickyDataDone(this.tag.getBleMac());
                }
                log("SendChannel handle packet:" + name, new Object[0]);
                onReadPacket(packet, (IChannelPacketReadResult) null);
                return;
            default:
                return;
        }
    }

    public void onRecv(byte[] bArr, int i) {
        logError("something may be  wrong, SendChannel no need to receive message", new Object[0]);
    }

    public void removeReader(IBleChannelReader iBleChannelReader) {
        if (iBleChannelReader != null) {
            this.readers.remove(iBleChannelReader);
        }
    }

    public void reset(int i) {
        super.reset(i);
        this.mReceiveChannel.reset(i);
    }

    public boolean useCrc32Verify() {
        return this.useCrc32;
    }

    public void write(byte[] bArr, ChannelCallback channelCallback, boolean z) {
        ChannelManager channelManager2 = this.channelManager;
        if (channelManager2 != null) {
            channelManager2.writeBle(this.tag, bArr, channelCallback, z);
        } else {
            logError("write ,channel manager is null", new Object[0]);
        }
    }

    public void writeBatchData(List<byte[]> list, ChannelCallback channelCallback) {
        ChannelManager channelManager2 = this.channelManager;
        if (channelManager2 != null) {
            channelManager2.writeBatchBleData(this.tag, list, channelCallback);
        } else {
            logError("writeBatchData ,channel manager is null", new Object[0]);
        }
    }
}
