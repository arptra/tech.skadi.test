package com.upuphone.starrynet.strategy.message;

import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.StarryNetData;

public class SppMsgSender implements IBleMsgSender {
    private static final String TAG = "SppMsgSender";
    private final Object mSppClientDoingLock = new Object();
    private final Object mSppClientLock = new Object();
    private final Object mSppServerDoingLock = new Object();
    private final Object mSppServerLock = new Object();

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessageByClient$0(int[] iArr, int i) {
        iArr[0] = i;
        synchronized (this.mSppClientDoingLock) {
            this.mSppClientDoingLock.notify();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessageByServer$1(int[] iArr, int i) {
        iArr[0] = i;
        synchronized (this.mSppServerDoingLock) {
            this.mSppServerDoingLock.notify();
        }
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public int sendMessageByClient(com.upuphone.starrynet.strategy.message.StarryMessage r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mSppClientLock
            monitor-enter(r0)
            java.lang.String r1 = r7.getPeerBtMac()     // Catch:{ all -> 0x0011 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0011 }
            if (r1 == 0) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            r6 = 20
            return r6
        L_0x0011:
            r6 = move-exception
            goto L_0x0082
        L_0x0013:
            com.upuphone.starrynet.strategy.channel.StarryNetChannelManager r1 = com.upuphone.starrynet.strategy.channel.StarryNetChannelManager.getInstance()     // Catch:{ all -> 0x0011 }
            r2 = 23
            com.upuphone.starrynet.strategy.channel.IConnectChannel r1 = r1.getConnectChannel(r2)     // Catch:{ all -> 0x0011 }
            boolean r2 = r1 instanceof com.upuphone.starrynet.strategy.channel.spp.SppClientChannel     // Catch:{ all -> 0x0011 }
            if (r2 != 0) goto L_0x003f
            java.lang.String r6 = "SppMsgSender"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0011 }
            r1.<init>()     // Catch:{ all -> 0x0011 }
            java.lang.String r2 = "cannot find spp client by btMac = "
            r1.append(r2)     // Catch:{ all -> 0x0011 }
            java.lang.String r7 = r7.getPeerBtMac()     // Catch:{ all -> 0x0011 }
            r1.append(r7)     // Catch:{ all -> 0x0011 }
            java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x0011 }
            com.upuphone.starrynet.common.StLog.w(r6, r7)     // Catch:{ all -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            r6 = 21
            return r6
        L_0x003f:
            com.upuphone.starrynet.strategy.channel.spp.SppClientChannel r1 = (com.upuphone.starrynet.strategy.channel.spp.SppClientChannel) r1     // Catch:{ all -> 0x0011 }
            java.lang.String r2 = r7.getPeerBtMac()     // Catch:{ all -> 0x0011 }
            boolean r2 = r1.isConnected(r2)     // Catch:{ all -> 0x0011 }
            if (r2 != 0) goto L_0x0056
            java.lang.String r6 = "SppMsgSender"
            java.lang.String r7 = "client not connected"
            com.upuphone.starrynet.common.StLog.w(r6, r7)     // Catch:{ all -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            r6 = 22
            return r6
        L_0x0056:
            byte[] r2 = com.upuphone.starrynet.strategy.channel.spp.coder.SppMessageCoder.encode(r7)     // Catch:{ all -> 0x0011 }
            r3 = 24
            int[] r3 = new int[]{r3}     // Catch:{ all -> 0x0011 }
            java.lang.Object r4 = r6.mSppClientDoingLock     // Catch:{ InterruptedException -> 0x0079 }
            monitor-enter(r4)     // Catch:{ InterruptedException -> 0x0079 }
            java.lang.String r7 = r7.getPeerBtMac()     // Catch:{ all -> 0x0076 }
            com.honey.account.g7.e r5 = new com.honey.account.g7.e     // Catch:{ all -> 0x0076 }
            r5.<init>(r6, r3)     // Catch:{ all -> 0x0076 }
            r1.sendMsg(r7, r2, r5)     // Catch:{ all -> 0x0076 }
            java.lang.Object r6 = r6.mSppClientDoingLock     // Catch:{ all -> 0x0076 }
            r6.wait()     // Catch:{ all -> 0x0076 }
            monitor-exit(r4)     // Catch:{ all -> 0x0076 }
            goto L_0x007d
        L_0x0076:
            r6 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0076 }
            throw r6     // Catch:{ InterruptedException -> 0x0079 }
        L_0x0079:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x0011 }
        L_0x007d:
            r6 = 0
            r6 = r3[r6]     // Catch:{ all -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return r6
        L_0x0082:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.message.SppMsgSender.sendMessageByClient(com.upuphone.starrynet.strategy.message.StarryMessage):int");
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public int sendMessageByServer(com.upuphone.starrynet.strategy.message.StarryMessage r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mSppServerLock
            monitor-enter(r0)
            com.upuphone.starrynet.strategy.channel.StarryNetChannelManager r1 = com.upuphone.starrynet.strategy.channel.StarryNetChannelManager.getInstance()     // Catch:{ all -> 0x002f }
            r2 = 24
            com.upuphone.starrynet.strategy.channel.IConnectChannel r1 = r1.getConnectChannel(r2)     // Catch:{ all -> 0x002f }
            boolean r2 = r1 instanceof com.upuphone.starrynet.strategy.channel.spp.SppServerChannel     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x0031
            java.lang.String r6 = "SppMsgSender"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x002f }
            r1.<init>()     // Catch:{ all -> 0x002f }
            java.lang.String r2 = "cannot find spp server by btMac = "
            r1.append(r2)     // Catch:{ all -> 0x002f }
            java.lang.String r7 = r7.getPeerBtMac()     // Catch:{ all -> 0x002f }
            r1.append(r7)     // Catch:{ all -> 0x002f }
            java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x002f }
            com.upuphone.starrynet.common.StLog.w(r6, r7)     // Catch:{ all -> 0x002f }
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            r6 = 30
            return r6
        L_0x002f:
            r6 = move-exception
            goto L_0x0074
        L_0x0031:
            com.upuphone.starrynet.strategy.channel.spp.SppServerChannel r1 = (com.upuphone.starrynet.strategy.channel.spp.SppServerChannel) r1     // Catch:{ all -> 0x002f }
            java.lang.String r2 = r7.getPeerBtMac()     // Catch:{ all -> 0x002f }
            boolean r2 = r1.isConnected(r2)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x0048
            java.lang.String r6 = "SppMsgSender"
            java.lang.String r7 = "client not connected"
            com.upuphone.starrynet.common.StLog.w(r6, r7)     // Catch:{ all -> 0x002f }
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            r6 = 31
            return r6
        L_0x0048:
            byte[] r2 = com.upuphone.starrynet.strategy.channel.spp.coder.SppMessageCoder.encode(r7)     // Catch:{ all -> 0x002f }
            r3 = 33
            int[] r3 = new int[]{r3}     // Catch:{ all -> 0x002f }
            java.lang.Object r4 = r6.mSppServerDoingLock     // Catch:{ InterruptedException -> 0x006b }
            monitor-enter(r4)     // Catch:{ InterruptedException -> 0x006b }
            java.lang.String r7 = r7.getPeerBtMac()     // Catch:{ all -> 0x0068 }
            com.honey.account.g7.d r5 = new com.honey.account.g7.d     // Catch:{ all -> 0x0068 }
            r5.<init>(r6, r3)     // Catch:{ all -> 0x0068 }
            r1.sendMsg(r7, r2, r5)     // Catch:{ all -> 0x0068 }
            java.lang.Object r6 = r6.mSppServerDoingLock     // Catch:{ all -> 0x0068 }
            r6.wait()     // Catch:{ all -> 0x0068 }
            monitor-exit(r4)     // Catch:{ all -> 0x0068 }
            goto L_0x006f
        L_0x0068:
            r6 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0068 }
            throw r6     // Catch:{ InterruptedException -> 0x006b }
        L_0x006b:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x002f }
        L_0x006f:
            r6 = 0
            r6 = r3[r6]     // Catch:{ all -> 0x002f }
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r6
        L_0x0074:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.message.SppMsgSender.sendMessageByServer(com.upuphone.starrynet.strategy.message.StarryMessage):int");
    }

    public int sendSyncMessage(StarryMessage starryMessage) {
        StLog.w(TAG, "spp sendSyncMessage " + starryMessage.getPeerBtMac());
        return StarryNetData.getInstance().isBleServer() ? sendMessageByServer(starryMessage) : sendMessageByClient(starryMessage);
    }
}
