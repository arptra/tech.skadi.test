package com.upuphone.starrynet.strategy.message;

import com.upuphone.runasone.utils.log.LogManager;

public class BleMessageSenderV1 implements IBleMsgSender {
    private static final String TAG = "BleMessageSenderV1";
    public static long timeOut = 5000;
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public final Object lockDoing = new Object();
    private MessageHandler mMessageHandler = new MessageHandler();
    private BleMessageSender oldBleSender = new BleMessageSender();

    public BleMessageSenderV1() {
        log("init BleMessageSenderV1", new Object[0]);
    }

    /* access modifiers changed from: private */
    public void log(String str, Object... objArr) {
        LogManager.d(TAG, (byte) 15, str, objArr);
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
    public int sendSyncMessage(com.upuphone.starrynet.strategy.message.StarryMessage r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.lock
            monitor-enter(r0)
            boolean r1 = r7.isInternalMessage()     // Catch:{ all -> 0x000f }
            if (r1 != 0) goto L_0x0011
            com.upuphone.starrynet.strategy.message.MessageHandler r1 = r6.mMessageHandler     // Catch:{ all -> 0x000f }
            r1.prepareMessage(r7)     // Catch:{ all -> 0x000f }
            goto L_0x0011
        L_0x000f:
            r6 = move-exception
            goto L_0x003f
        L_0x0011:
            r1 = -1
            int[] r1 = new int[]{r1}     // Catch:{ all -> 0x000f }
            r2 = 0
            java.lang.Object r3 = r6.lockDoing     // Catch:{ InterruptedException -> 0x0037 }
            monitor-enter(r3)     // Catch:{ InterruptedException -> 0x0037 }
            com.upuphone.starrynet.strategy.message.BleMessageSender r4 = r6.oldBleSender     // Catch:{ all -> 0x0034 }
            com.upuphone.starrynet.strategy.message.BleMessageSenderV1$1 r5 = new com.upuphone.starrynet.strategy.message.BleMessageSenderV1$1     // Catch:{ all -> 0x0034 }
            r5.<init>(r1)     // Catch:{ all -> 0x0034 }
            r4.sendMessage(r7, r5)     // Catch:{ all -> 0x0034 }
            java.lang.String r7 = "sendSyncMessage await"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x0034 }
            r6.log(r7, r4)     // Catch:{ all -> 0x0034 }
            java.lang.Object r6 = r6.lockDoing     // Catch:{ all -> 0x0034 }
            long r4 = timeOut     // Catch:{ all -> 0x0034 }
            r6.wait(r4)     // Catch:{ all -> 0x0034 }
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            goto L_0x003b
        L_0x0034:
            r6 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            throw r6     // Catch:{ InterruptedException -> 0x0037 }
        L_0x0037:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x000f }
        L_0x003b:
            r6 = r1[r2]     // Catch:{ all -> 0x000f }
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r6
        L_0x003f:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.message.BleMessageSenderV1.sendSyncMessage(com.upuphone.starrynet.strategy.message.StarryMessage):int");
    }
}
