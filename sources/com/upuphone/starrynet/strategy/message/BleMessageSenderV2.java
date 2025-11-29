package com.upuphone.starrynet.strategy.message;

import android.os.Bundle;
import androidx.core.util.Consumer;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.channel.ChannelTag;
import com.upuphone.starrynet.core.ble.channel.IBleChannelWriter;
import com.upuphone.starrynet.core.ble.client.response.BleResponse;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.message.channelmanager.ClientChannelManager;
import com.upuphone.starrynet.strategy.message.channelmanager.ServerChannelManager;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersionsCache;
import java.util.UUID;

public class BleMessageSenderV2 implements IBleMsgSender {
    private static final String TAG = "BleMessageSenderV2";
    /* access modifiers changed from: private */
    public final Object externalDoingLock = new Object();
    private final Object externalLock = new Object();
    protected UUID externalNormalUUID;
    /* access modifiers changed from: private */
    public final Object externalUrgentDoingLock = new Object();
    private final Object externalUrgentLock = new Object();
    protected UUID externalUrgentUUID;
    /* access modifiers changed from: private */
    public final Object internalDoingLock = new Object();
    private final Object internalLock = new Object();
    protected UUID internalUUID;
    protected MessageHandler messageHandler = new MessageHandler();

    public BleMessageSenderV2(UUID uuid, UUID uuid2, UUID uuid3) {
        this.externalNormalUUID = uuid;
        this.externalUrgentUUID = uuid2;
        this.internalUUID = uuid3;
    }

    private boolean isSupportBleVersionV2(StarryMessage starryMessage) {
        return ProtocolVersionsCache.isSupportBleVersionV2Plus(StDevice.bytes2HexString(starryMessage.getId()));
    }

    private void sendMessageImpl(final ChannelTag channelTag, int i, int i2, byte[] bArr, final Consumer<Integer> consumer) {
        StLog.d(TAG, "sendMessageImpl ,tag =%s, opcode =%d, msgType = %d, content length =%d", channelTag, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length));
        IBleChannelWriter writerByMac = StarryNetData.getInstance().isBleServer() ? ServerChannelManager.getInstance().getWriterByMac(channelTag) : ClientChannelManager.getInstance().getWriterByMac(channelTag);
        if (writerByMac != null) {
            writerByMac.writeWithOpCode(i, bArr, i2, new BleResponse<Bundle>() {
                public void onResponse(int i, Bundle bundle) {
                    StLog.v(BleMessageSenderV2.TAG, "sendMessageImpl onResponse ,tag =%s, code =%d", channelTag, Integer.valueOf(i));
                    consumer.accept(Integer.valueOf(i));
                }
            });
            return;
        }
        StLog.w(TAG, "cannot find channel write by channel tag:" + channelTag);
        consumer.accept(8);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private int sendSyncExternalMessage(com.upuphone.starrynet.strategy.message.StarryMessage r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.externalLock
            monitor-enter(r0)
            com.upuphone.starrynet.core.ble.channel.ChannelTag r2 = new com.upuphone.starrynet.core.ble.channel.ChannelTag     // Catch:{ all -> 0x0021 }
            java.lang.String r1 = r10.getPeerBleMac()     // Catch:{ all -> 0x0021 }
            java.util.UUID r3 = r9.externalNormalUUID     // Catch:{ all -> 0x0021 }
            r2.<init>(r1, r3)     // Catch:{ all -> 0x0021 }
            r9.prepareMessage(r10)     // Catch:{ all -> 0x0021 }
            boolean r1 = r10.isShortMessage()     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0023
            boolean r1 = r9.isSupportBleVersionV2(r10)     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0023
            r1 = 9
        L_0x001f:
            r3 = r1
            goto L_0x0026
        L_0x0021:
            r9 = move-exception
            goto L_0x0051
        L_0x0023:
            r1 = 8
            goto L_0x001f
        L_0x0026:
            r1 = -1
            int[] r7 = new int[]{r1}     // Catch:{ all -> 0x0021 }
            java.lang.Object r8 = r9.externalDoingLock     // Catch:{ InterruptedException -> 0x0048 }
            monitor-enter(r8)     // Catch:{ InterruptedException -> 0x0048 }
            byte[] r5 = r10.getContent()     // Catch:{ all -> 0x0045 }
            com.upuphone.starrynet.strategy.message.BleMessageSenderV2$3 r6 = new com.upuphone.starrynet.strategy.message.BleMessageSenderV2$3     // Catch:{ all -> 0x0045 }
            r6.<init>(r7)     // Catch:{ all -> 0x0045 }
            r4 = 0
            r1 = r9
            r1.sendMessageImpl(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0045 }
            java.lang.Object r9 = r9.externalDoingLock     // Catch:{ all -> 0x0045 }
            long r1 = com.upuphone.starrynet.strategy.message.BleMessageSenderV1.timeOut     // Catch:{ all -> 0x0045 }
            r9.wait(r1)     // Catch:{ all -> 0x0045 }
            monitor-exit(r8)     // Catch:{ all -> 0x0045 }
            goto L_0x004c
        L_0x0045:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0045 }
            throw r9     // Catch:{ InterruptedException -> 0x0048 }
        L_0x0048:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ all -> 0x0021 }
        L_0x004c:
            r9 = 0
            r9 = r7[r9]     // Catch:{ all -> 0x0021 }
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return r9
        L_0x0051:
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.message.BleMessageSenderV2.sendSyncExternalMessage(com.upuphone.starrynet.strategy.message.StarryMessage):int");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private int sendSyncExternalUrgentMessage(com.upuphone.starrynet.strategy.message.StarryMessage r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.externalUrgentLock
            monitor-enter(r0)
            com.upuphone.starrynet.core.ble.channel.ChannelTag r2 = new com.upuphone.starrynet.core.ble.channel.ChannelTag     // Catch:{ all -> 0x0021 }
            java.lang.String r1 = r10.getPeerBleMac()     // Catch:{ all -> 0x0021 }
            java.util.UUID r3 = r9.externalUrgentUUID     // Catch:{ all -> 0x0021 }
            r2.<init>(r1, r3)     // Catch:{ all -> 0x0021 }
            r9.prepareMessage(r10)     // Catch:{ all -> 0x0021 }
            boolean r1 = r10.isShortMessage()     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0023
            boolean r1 = r9.isSupportBleVersionV2(r10)     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0023
            r1 = 9
        L_0x001f:
            r3 = r1
            goto L_0x0026
        L_0x0021:
            r9 = move-exception
            goto L_0x0051
        L_0x0023:
            r1 = 8
            goto L_0x001f
        L_0x0026:
            r1 = -1
            int[] r7 = new int[]{r1}     // Catch:{ all -> 0x0021 }
            java.lang.Object r8 = r9.externalUrgentDoingLock     // Catch:{ InterruptedException -> 0x0048 }
            monitor-enter(r8)     // Catch:{ InterruptedException -> 0x0048 }
            byte[] r5 = r10.getContent()     // Catch:{ all -> 0x0045 }
            com.upuphone.starrynet.strategy.message.BleMessageSenderV2$2 r6 = new com.upuphone.starrynet.strategy.message.BleMessageSenderV2$2     // Catch:{ all -> 0x0045 }
            r6.<init>(r7)     // Catch:{ all -> 0x0045 }
            r4 = 0
            r1 = r9
            r1.sendMessageImpl(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0045 }
            java.lang.Object r9 = r9.externalUrgentDoingLock     // Catch:{ all -> 0x0045 }
            long r1 = com.upuphone.starrynet.strategy.message.BleMessageSenderV1.timeOut     // Catch:{ all -> 0x0045 }
            r9.wait(r1)     // Catch:{ all -> 0x0045 }
            monitor-exit(r8)     // Catch:{ all -> 0x0045 }
            goto L_0x004c
        L_0x0045:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0045 }
            throw r9     // Catch:{ InterruptedException -> 0x0048 }
        L_0x0048:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ all -> 0x0021 }
        L_0x004c:
            r9 = 0
            r9 = r7[r9]     // Catch:{ all -> 0x0021 }
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return r9
        L_0x0051:
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.message.BleMessageSenderV2.sendSyncExternalUrgentMessage(com.upuphone.starrynet.strategy.message.StarryMessage):int");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private int sendSyncInternalMessage(com.upuphone.starrynet.strategy.message.StarryMessage r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.internalLock
            monitor-enter(r0)
            com.upuphone.starrynet.core.ble.channel.ChannelTag r2 = new com.upuphone.starrynet.core.ble.channel.ChannelTag     // Catch:{ all -> 0x003a }
            java.lang.String r1 = r10.getPeerBleMac()     // Catch:{ all -> 0x003a }
            java.util.UUID r3 = r9.internalUUID     // Catch:{ all -> 0x003a }
            r2.<init>(r1, r3)     // Catch:{ all -> 0x003a }
            r9.prepareMessage(r10)     // Catch:{ all -> 0x003a }
            int r3 = r10.getOpCode()     // Catch:{ all -> 0x003a }
            int r4 = r10.getPacketType()     // Catch:{ all -> 0x003a }
            r1 = -1
            int[] r7 = new int[]{r1}     // Catch:{ all -> 0x003a }
            java.lang.Object r8 = r9.internalDoingLock     // Catch:{ InterruptedException -> 0x003c }
            monitor-enter(r8)     // Catch:{ InterruptedException -> 0x003c }
            byte[] r5 = r10.getContent()     // Catch:{ all -> 0x0037 }
            com.upuphone.starrynet.strategy.message.BleMessageSenderV2$1 r6 = new com.upuphone.starrynet.strategy.message.BleMessageSenderV2$1     // Catch:{ all -> 0x0037 }
            r6.<init>(r7)     // Catch:{ all -> 0x0037 }
            r1 = r9
            r1.sendMessageImpl(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0037 }
            java.lang.Object r9 = r9.internalDoingLock     // Catch:{ all -> 0x0037 }
            long r1 = com.upuphone.starrynet.strategy.message.BleMessageSenderV1.timeOut     // Catch:{ all -> 0x0037 }
            r9.wait(r1)     // Catch:{ all -> 0x0037 }
            monitor-exit(r8)     // Catch:{ all -> 0x0037 }
            goto L_0x0040
        L_0x0037:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0037 }
            throw r9     // Catch:{ InterruptedException -> 0x003c }
        L_0x003a:
            r9 = move-exception
            goto L_0x0045
        L_0x003c:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ all -> 0x003a }
        L_0x0040:
            r9 = 0
            r9 = r7[r9]     // Catch:{ all -> 0x003a }
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return r9
        L_0x0045:
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.message.BleMessageSenderV2.sendSyncInternalMessage(com.upuphone.starrynet.strategy.message.StarryMessage):int");
    }

    public void prepareMessage(StarryMessage starryMessage) {
        this.messageHandler.prepareMessageV2(starryMessage);
    }

    public int sendSyncMessage(StarryMessage starryMessage) {
        return starryMessage.isInternalMessage() ? sendSyncInternalMessage(starryMessage) : sendSyncExternalMessage(starryMessage);
    }

    public BleMessageSenderV2() {
    }
}
