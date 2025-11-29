package com.upuphone.starrynet.core.ble.channel;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.honey.account.s6.a;
import com.honey.account.s6.b;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.core.ble.BluetoothContextManager;
import com.upuphone.starrynet.core.ble.channel.Timer;
import com.upuphone.starrynet.core.ble.channel.packet.ACKPacket;
import com.upuphone.starrynet.core.ble.channel.packet.CTRPacket;
import com.upuphone.starrynet.core.ble.channel.packet.DataPacket;
import com.upuphone.starrynet.core.ble.channel.packet.FastAckPacket;
import com.upuphone.starrynet.core.ble.channel.packet.FastCTRPacket;
import com.upuphone.starrynet.core.ble.channel.packet.MixCTRPacket;
import com.upuphone.starrynet.core.ble.channel.packet.Packet;
import com.upuphone.starrynet.core.ble.channel.packet.SingleACKPacket;
import com.upuphone.starrynet.core.ble.channel.packet.SingleNoAckPacket;
import com.upuphone.starrynet.core.ble.channel.packet.SinglePacket;
import com.upuphone.starrynet.core.ble.proxy.ProxyBulk;
import com.upuphone.starrynet.core.ble.proxy.ProxyInterceptor;
import com.upuphone.starrynet.core.ble.proxy.ProxyUtils;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import com.upuphone.starrynet.core.ble.utils.MessageHandlerThread;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

public abstract class Channel implements IChannel, ProxyInterceptor {
    private static final long CMD_TIMEOUT = 3000;
    public static final boolean DEBUG = (!BluetoothContextManager.isReleaseBuild());
    private static final int MSG_WRITE_CALLBACK = 1;
    private static final String TAG = "Channel";
    private static final long TIMEOUT = 6000;
    private static final String TIMER_EXCEPTION = "exception";
    public static final int WANTED_MAX_PACKAGE_NUM = 6;
    private byte[] mBytesToWrite;
    private final Handler.Callback mCallback;
    private IChannel mChannel;
    /* access modifiers changed from: private */
    public ChannelCallback mChannelCallback;
    private final IChannel mChannelImpl;
    private ChannelState mCurrentState;
    /* access modifiers changed from: private */
    public List<Short> mCurrentSync = new ArrayList();
    /* access modifiers changed from: private */
    public int mFrameCount;
    /* access modifiers changed from: private */
    public byte[] mMixHeaderData;
    /* access modifiers changed from: private */
    public int mPackageType;
    /* access modifiers changed from: private */
    public SparseArray<Packet> mPacketRecv;
    private final IChannelStateHandler mRecvACKHandler;
    private final IChannelStateHandler mRecvCTRHandler;
    private final IChannelStateHandler mRecvDataHandler;
    private final IChannelStateHandler mRecvFastACKHandler;
    private final IChannelStateHandler mRecvFastCTRHandler;
    private final IChannelStateHandler mRecvFastDataHandler;
    private final IChannelStateHandler mRecvMixCTRHandler;
    private final IChannelStateHandler mRecvSINGLEACKHandler;
    private final IChannelStateHandler mRecvSingleCTRHandler;
    private final IChannelStateHandler mRecvSingleNoAckCTRHandler;
    private final IChannelStateHandler mSyncPacketHandler;
    private final Timer.TimerCallback mTimeoutHandler;
    /* access modifiers changed from: private */
    public Timer mTimer;
    private int mTotalBytes;
    private final IChannelStateHandler mWaitStartACKHandler;
    private final IChannelStateHandler mWaitStartFastACKHandler;
    private final IChannelStateHandler mWaitStartMngACKHandler;
    private final IChannelStateHandler mWaitStartSingleACKHandler;
    /* access modifiers changed from: private */
    public Handler mWorkerHandler;
    private final ChannelStateBlock[] stateMachine;

    public static class AssertLooperException extends RuntimeException {
        public AssertLooperException(String str) {
            super(str);
        }
    }

    public class RecvCallback implements Runnable {
        private byte[] bytes;
        private int packageType;

        public RecvCallback(byte[] bArr, int i) {
            this.bytes = bArr;
            this.packageType = i;
        }

        public void run() {
            Channel.this.onRecv(this.bytes, this.packageType);
        }
    }

    public Channel() {
        ChannelState channelState = ChannelState.IDLE;
        this.mCurrentState = channelState;
        AnonymousClass1 r2 = new IChannelStateHandler() {
            public void handleState(Object... objArr) {
                Channel.this.assertRuntime(false);
                DataPacket dataPacket = objArr[0];
                short seq = (short) dataPacket.getSeq();
                if (!Channel.this.mCurrentSync.contains(Short.valueOf(seq))) {
                    if (Channel.DEBUG) {
                        Channel.this.logError("sync packet not matched!!", new Object[0]);
                    }
                } else if (Channel.this.onDataPacketRecvd(dataPacket)) {
                    Channel.this.mCurrentSync.remove(Short.valueOf(seq));
                    if (Channel.this.mCurrentSync.isEmpty()) {
                        Channel.this.startSyncPacket();
                    }
                } else if (Channel.DEBUG) {
                    Channel.this.logError("sync packet repeated!!", new Object[0]);
                }
            }
        };
        this.mSyncPacketHandler = r2;
        AnonymousClass2 r3 = new IChannelStateHandler() {
            public void handleState(Object... objArr) {
                Channel.this.assertRuntime(false);
                DataPacket dataPacket = objArr[0];
                if (!Channel.this.onDataPacketRecvd(dataPacket)) {
                    if (Channel.DEBUG) {
                        Channel.this.logError("dataPacket repeated!!", new Object[0]);
                    }
                } else if (dataPacket.getSeq() == Channel.this.mFrameCount) {
                    Channel.this.startSyncPacket();
                } else {
                    Channel.this.startTimer(Channel.TIMEOUT, new Timer.TimerCallback("WaitData") {
                        public void onTimerCallback() {
                            Channel.this.startSyncPacket();
                        }

                        public void resetCallback() {
                            Channel.this.mTimer.resetCallback();
                        }
                    });
                }
            }
        };
        this.mRecvDataHandler = r3;
        AnonymousClass3 r4 = new IChannelStateHandler() {
            public void handleState(Object... objArr) {
                Channel.this.assertRuntime(false);
                DataPacket dataPacket = objArr[0];
                if (!Channel.this.onDataPacketRecvd(dataPacket)) {
                    if (Channel.DEBUG) {
                        Channel.this.logError("dataPacket repeated!!", new Object[0]);
                    }
                } else if (dataPacket.getSeq() != Channel.this.mFrameCount) {
                } else {
                    if (Channel.this.mPacketRecv.size() == Channel.this.mFrameCount) {
                        byte[] access$800 = Channel.this.getTotalRecvdBytes();
                        if (!ByteUtils.isEmpty(access$800)) {
                            Channel.this.assertRuntime(false);
                            Channel.this.resetChannelStatus();
                            Channel.this.dispatchOnReceive(access$800);
                            return;
                        }
                        Channel.this.resetChannelStatus();
                        return;
                    }
                    Channel channel = Channel.this;
                    channel.logError("receive last packet ,but receive packets size not equal total frame count, lost packet size =%d", Integer.valueOf(channel.mFrameCount - Channel.this.mPacketRecv.size()));
                    Channel.this.resetChannelStatus();
                }
            }
        };
        this.mRecvFastDataHandler = r4;
        AnonymousClass4 r5 = new IChannelStateHandler() {
            public void handleState(Object... objArr) {
                Channel.this.assertRuntime(false);
                CTRPacket cTRPacket = objArr[0];
                int unused = Channel.this.mFrameCount = cTRPacket.getFrameCount();
                ACKPacket aCKPacket = new ACKPacket(1);
                int unused2 = Channel.this.mPackageType = cTRPacket.getPackageType();
                Channel.this.setCurrentState(ChannelState.READY);
                Channel.this.performWrite(aCKPacket, new ChannelCallback() {
                    public void onCallback(int i) {
                        Channel.this.assertRuntime(false);
                        if (i == 0) {
                            Channel.this.startTimer();
                        } else {
                            Channel.this.resetChannelStatus();
                        }
                    }
                });
                Channel.this.setCurrentState(ChannelState.READING);
            }
        };
        this.mRecvCTRHandler = r5;
        AnonymousClass5 r6 = new IChannelStateHandler() {
            public void handleState(Object... objArr) {
                Channel.this.assertRuntime(false);
                FastCTRPacket fastCTRPacket = objArr[0];
                int unused = Channel.this.mFrameCount = fastCTRPacket.getFrameCount();
                int unused2 = Channel.this.mPackageType = fastCTRPacket.getPackageType();
                Channel.this.setCurrentState(ChannelState.FAST_READING);
            }
        };
        this.mRecvFastCTRHandler = r6;
        this.mMixHeaderData = null;
        AnonymousClass6 r7 = new IChannelStateHandler() {
            public void handleState(Object... objArr) {
                Channel.this.assertRuntime(false);
                MixCTRPacket mixCTRPacket = objArr[0];
                int unused = Channel.this.mFrameCount = mixCTRPacket.getFrameCount();
                int unused2 = Channel.this.mPackageType = mixCTRPacket.getPackageType();
                byte[] data = mixCTRPacket.getData();
                Channel.access$1412(Channel.this, data.length);
                byte[] unused3 = Channel.this.mMixHeaderData = data;
                Channel.this.setCurrentState(ChannelState.MIX_READING);
            }
        };
        this.mRecvMixCTRHandler = r7;
        AnonymousClass7 r8 = new IChannelStateHandler() {
            public void handleState(Object... objArr) {
                Channel.this.assertRuntime(false);
                SinglePacket singlePacket = objArr[0];
                byte[] data = singlePacket.getData();
                final byte[] handleTotalReceiveBytes = Channel.this.handleTotalReceiveBytes(ByteBuffer.wrap(data), data.length);
                int unused = Channel.this.mPackageType = singlePacket.getPackageType();
                SingleACKPacket singleACKPacket = new SingleACKPacket(0);
                Channel.this.setCurrentState(ChannelState.READY);
                Channel.this.performWrite(singleACKPacket, new ChannelCallback() {
                    public void onCallback(int i) {
                        Channel.this.assertRuntime(false);
                        Channel.this.resetChannelStatus();
                        Channel.this.dispatchOnReceive(handleTotalReceiveBytes);
                    }
                });
            }
        };
        this.mRecvSingleCTRHandler = r8;
        AnonymousClass8 r9 = new IChannelStateHandler() {
            public void handleState(Object... objArr) {
                Channel.this.assertRuntime(false);
                SingleNoAckPacket singleNoAckPacket = objArr[0];
                byte[] data = singleNoAckPacket.getData();
                byte[] handleTotalReceiveBytes = Channel.this.handleTotalReceiveBytes(ByteBuffer.wrap(data), data.length);
                int unused = Channel.this.mPackageType = singleNoAckPacket.getPackageType();
                Channel.this.resetChannelStatus();
                Channel.this.dispatchOnReceive(handleTotalReceiveBytes);
            }
        };
        this.mRecvSingleNoAckCTRHandler = r9;
        AnonymousClass9 r10 = new IChannelStateHandler() {
            public void handleState(Object... objArr) {
                Channel.this.assertRuntime(false);
                Channel.this.setCurrentState(ChannelState.WAIT_START_ACK);
                Channel.this.startTimer();
            }
        };
        this.mWaitStartACKHandler = r10;
        AnonymousClass10 r11 = new IChannelStateHandler() {
            public void handleState(Object... objArr) {
                Channel.this.assertRuntime(false);
                Channel.this.setCurrentState(ChannelState.WAIT_START_FAST_ACK);
                Channel.this.startTimer();
            }
        };
        this.mWaitStartFastACKHandler = r11;
        AnonymousClass11 r12 = new IChannelStateHandler() {
            public void handleState(Object... objArr) {
                Channel.this.assertRuntime(false);
                Channel.this.setCurrentState(ChannelState.WAIT_MNG_ACK);
                Channel.this.startTimer();
            }
        };
        this.mWaitStartMngACKHandler = r12;
        AnonymousClass12 r13 = new IChannelStateHandler() {
            public void handleState(Object... objArr) {
                Channel.this.assertRuntime(false);
                Channel.this.setCurrentState(ChannelState.WAIT_SINGLE_ACK);
                Channel.this.startTimer();
            }
        };
        this.mWaitStartSingleACKHandler = r13;
        this.mTimeoutHandler = new Timer.TimerCallback(getClass().getSimpleName()) {
            public void onTimerCallback() {
                Channel.this.assertRuntime(false);
                Channel.this.onSendCallback(-2);
                Channel.this.resetChannelStatus();
            }

            public void resetCallback() {
                Channel.this.mTimer.resetCallback();
            }
        };
        AnonymousClass14 r14 = new IChannelStateHandler() {
            public void handleState(Object... objArr) {
                Channel.this.assertRuntime(false);
                int status = objArr[0].getStatus();
                if (status == 0) {
                    Channel.this.onSendCallback(0);
                    Channel.this.resetChannelStatus();
                } else if (status != 2) {
                    Channel.this.onSendCallback(-1);
                    Channel.this.resetChannelStatus();
                } else {
                    Channel.this.stopTimer();
                    Channel.this.onSendCallback(-3);
                    Channel.this.resetChannelStatus();
                }
            }
        };
        this.mRecvSINGLEACKHandler = r14;
        AnonymousClass15 r15 = new IChannelStateHandler() {
            public void handleState(Object... objArr) {
                Channel.this.assertRuntime(false);
                FastAckPacket fastAckPacket = objArr[0];
                if (fastAckPacket.getStatus() == 1) {
                    Channel.this.stopTimer();
                    Channel.this.startSendFastData();
                    return;
                }
                Channel channel = Channel.this;
                channel.log("mRecvFastACKHandler receive unexpected status =" + fastAckPacket.getStatus(), new Object[0]);
                Channel.this.onSendCallback(-1);
                Channel.this.resetChannelStatus();
            }
        };
        this.mRecvFastACKHandler = r15;
        AnonymousClass1 r16 = r2;
        AnonymousClass16 r22 = new IChannelStateHandler() {
            public void handleState(Object... objArr) {
                Channel.this.assertRuntime(false);
                ACKPacket aCKPacket = objArr[0];
                int status = aCKPacket.getStatus();
                if (status == 0) {
                    Channel.this.onSendCallback(0);
                    Channel.this.resetChannelStatus();
                } else if (status == 1) {
                    Channel.this.stopTimer();
                    Channel.this.setCurrentState(ChannelState.WRITING);
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < Channel.this.mFrameCount; i++) {
                        arrayList.add(Integer.valueOf(i));
                    }
                    Channel.this.sendDataPacket(arrayList, false);
                } else if (status != 5) {
                    Channel.this.onSendCallback(-1);
                    Channel.this.resetChannelStatus();
                } else {
                    List<Short> seq = aCKPacket.getSeq();
                    if (!seq.isEmpty()) {
                        ArrayList arrayList2 = new ArrayList();
                        for (Short shortValue : seq) {
                            arrayList2.add(Integer.valueOf(shortValue.shortValue() - 1));
                        }
                        Channel.this.sendDataPacket(arrayList2, true);
                    }
                }
            }
        };
        this.mRecvACKHandler = r22;
        ChannelStateBlock channelStateBlock = r0;
        AnonymousClass3 r34 = r4;
        ChannelState channelState2 = ChannelState.READY;
        AnonymousClass2 r32 = r3;
        ChannelStateBlock channelStateBlock2 = new ChannelStateBlock(channelState2, ChannelEvent.SEND_CTR, r10);
        ChannelStateBlock channelStateBlock3 = r0;
        ChannelStateBlock channelStateBlock4 = new ChannelStateBlock(channelState2, ChannelEvent.SEND_FAST_CTR, r11);
        ChannelStateBlock channelStateBlock5 = r0;
        ChannelStateBlock channelStateBlock6 = new ChannelStateBlock(channelState2, ChannelEvent.SEND_MNG, r12);
        ChannelStateBlock channelStateBlock7 = r0;
        ChannelStateBlock channelStateBlock8 = new ChannelStateBlock(channelState2, ChannelEvent.SEND_SINGLE_CTR, r13);
        ChannelStateBlock channelStateBlock9 = r0;
        ChannelState channelState3 = ChannelState.WAIT_START_ACK;
        ChannelEvent channelEvent = ChannelEvent.RECV_ACK;
        ChannelStateBlock channelStateBlock10 = new ChannelStateBlock(channelState3, channelEvent, r22);
        ChannelStateBlock channelStateBlock11 = r0;
        ChannelStateBlock channelStateBlock12 = new ChannelStateBlock(ChannelState.WAIT_START_FAST_ACK, ChannelEvent.RECEIVE_FAST_ACK, r15);
        ChannelStateBlock channelStateBlock13 = r0;
        ChannelStateBlock channelStateBlock14 = new ChannelStateBlock(ChannelState.WAIT_SINGLE_ACK, ChannelEvent.RECV_SINGLE_ACK, r14);
        ChannelStateBlock channelStateBlock15 = r0;
        ChannelStateBlock channelStateBlock16 = new ChannelStateBlock(ChannelState.SYNC, channelEvent, r22);
        ChannelStateBlock channelStateBlock17 = r0;
        ChannelStateBlock channelStateBlock18 = new ChannelStateBlock(ChannelState.WRITING, channelEvent, r22);
        ChannelStateBlock channelStateBlock19 = r0;
        ChannelStateBlock channelStateBlock20 = new ChannelStateBlock(channelState, ChannelEvent.RECV_CTR, r5);
        ChannelStateBlock channelStateBlock21 = r0;
        ChannelStateBlock channelStateBlock22 = new ChannelStateBlock(channelState, ChannelEvent.RECEIVE_FAST_CTR, r6);
        ChannelStateBlock channelStateBlock23 = r0;
        ChannelStateBlock channelStateBlock24 = new ChannelStateBlock(channelState, ChannelEvent.RECV_SINGLE_CTR, r8);
        ChannelStateBlock channelStateBlock25 = r0;
        ChannelStateBlock channelStateBlock26 = new ChannelStateBlock(channelState, ChannelEvent.RECEIVE_MIX_CTR, r7);
        ChannelStateBlock channelStateBlock27 = r0;
        ChannelStateBlock channelStateBlock28 = new ChannelStateBlock(channelState, ChannelEvent.RECEIVE_SINGLE_CMD_NO_ACK, r9);
        ChannelStateBlock channelStateBlock29 = r0;
        ChannelState channelState4 = ChannelState.READING;
        ChannelEvent channelEvent2 = ChannelEvent.RECV_DATA;
        ChannelStateBlock channelStateBlock30 = new ChannelStateBlock(channelState4, channelEvent2, r32);
        ChannelStateBlock channelStateBlock31 = r0;
        AnonymousClass3 r42 = r34;
        ChannelStateBlock channelStateBlock32 = new ChannelStateBlock(ChannelState.FAST_READING, ChannelEvent.RECV_FAST_DATA, r42);
        ChannelStateBlock channelStateBlock33 = r0;
        ChannelStateBlock channelStateBlock34 = new ChannelStateBlock(ChannelState.MIX_READING, ChannelEvent.RECV_MIX_DATA, r42);
        ChannelStateBlock channelStateBlock35 = r0;
        ChannelStateBlock channelStateBlock36 = new ChannelStateBlock(ChannelState.SYNC_ACK, channelEvent2, r16);
        this.stateMachine = new ChannelStateBlock[]{channelStateBlock, channelStateBlock3, channelStateBlock5, channelStateBlock7, channelStateBlock9, channelStateBlock11, channelStateBlock13, channelStateBlock15, channelStateBlock17, channelStateBlock19, channelStateBlock21, channelStateBlock23, channelStateBlock25, channelStateBlock27, channelStateBlock29, channelStateBlock31, channelStateBlock33, channelStateBlock35};
        AnonymousClass22 r0 = new IChannel() {
            public void onRead(byte[] bArr) {
                Channel.this.performOnRead(bArr);
            }

            public void onReadPacket(Packet packet, IChannelPacketReadResult iChannelPacketReadResult) {
                Channel.this.receivePacket(packet, iChannelPacketReadResult);
            }

            public void onRecv(byte[] bArr, int i) {
                throw new UnsupportedOperationException();
            }

            public void reset(int i) {
                if (i == 1) {
                    Channel.this.onSendCallback(-8);
                    Channel.this.mWorkerHandler.removeCallbacksAndMessages((Object) null);
                    Channel.this.mWorkerHandler.getLooper().quitSafely();
                }
                Channel.this.resetChannelStatus();
            }

            public void send(byte[] bArr, int i, ChannelCallback channelCallback) {
                Channel.this.performSend(6, bArr, i, channelCallback);
            }

            public void write(byte[] bArr, ChannelCallback channelCallback, boolean z) {
                throw new UnsupportedOperationException();
            }

            public void writeBatchData(List<byte[]> list, ChannelCallback channelCallback) {
                throw new UnsupportedOperationException();
            }

            public void send(int i, byte[] bArr, int i2, ChannelCallback channelCallback) {
                Channel.this.performSend(i, bArr, i2, channelCallback);
            }
        };
        this.mChannelImpl = r0;
        b bVar = new b(this);
        this.mCallback = bVar;
        this.mTimer = Timer.newInstance();
        this.mPacketRecv = new SparseArray<>();
        this.mChannel = (IChannel) ProxyUtils.getProxy(r0, this);
        MessageHandlerThread messageHandlerThread = new MessageHandlerThread(getClass().getSimpleName());
        messageHandlerThread.start();
        this.mWorkerHandler = new Handler(messageHandlerThread.getLooper(), bVar);
    }

    public static /* synthetic */ int access$1412(Channel channel, int i) {
        int i2 = channel.mTotalBytes + i;
        channel.mTotalBytes = i2;
        return i2;
    }

    /* access modifiers changed from: private */
    public void assertRuntime(boolean z) {
        if (Looper.myLooper() != this.mWorkerHandler.getLooper()) {
            log("warning: assertRuntime ,looper not match, will reset state!", new Object[0]);
            resetOnException();
            throw new AssertLooperException("current looper not equal target looper!");
        }
    }

    private boolean checkCRC32(byte[] bArr, byte[] bArr2) {
        return ByteUtils.equals(bArr2, CRC32.get(bArr));
    }

    /* access modifiers changed from: private */
    public void dispatchOnReceive(byte[] bArr) {
        if (DEBUG) {
            log(">>> receive,length=%d", Integer.valueOf(bArr.length));
        }
        BluetoothContextManager.post(new RecvCallback(bArr, this.mPackageType));
    }

    private int getFrameCount(int i) {
        if (needCRC32Verify()) {
            i += 4;
        }
        return ((i - 1) / getDMTU()) + 1;
    }

    /* access modifiers changed from: private */
    public byte[] getTotalRecvdBytes() {
        assertRuntime(false);
        if (this.mPacketRecv.size() == this.mFrameCount) {
            if (needCRC32Verify()) {
                log("getTotalRecvdBytes: totalBytes = %d (include 4 Bytes crc)", Integer.valueOf(this.mTotalBytes));
            } else {
                log("getTotalRecvdBytes: totalBytes = %d", Integer.valueOf(this.mTotalBytes));
            }
            ByteBuffer allocate = ByteBuffer.allocate(this.mTotalBytes);
            byte[] bArr = this.mMixHeaderData;
            if (bArr != null && bArr.length > 0) {
                allocate.put(bArr);
            }
            for (int i = 1; i <= this.mFrameCount; i++) {
                ((DataPacket) this.mPacketRecv.get(i)).fillByteBuffer(allocate);
            }
            return handleTotalReceiveBytes(allocate, this.mTotalBytes);
        }
        resetOnException();
        throw new IllegalStateException();
    }

    private boolean isExceptionTimerOn() {
        return TIMER_EXCEPTION.equals(this.mTimer.getName());
    }

    private boolean isTimerOn() {
        return this.mTimer.isRunning();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$2(Message message) {
        if (message.what == 1) {
            if (isExceptionTimerOn()) {
                stopTimer();
            }
            ((ChannelCallback) message.obj).onCallback(message.arg1);
            return false;
        }
        ProxyBulk.safeInvoke(message.obj);
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$performBatchWrite$1(List list, ChannelCallback channelCallback) {
        log("perform batch write", new Object[0]);
        writeBatchData(list, new WriteCallback(channelCallback));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$performWrite$0(byte[] bArr, WriteCallback writeCallback, boolean z) {
        write(bArr, writeCallback, z);
    }

    private boolean needCRC32Verify() {
        return this.mPackageType == 1;
    }

    /* access modifiers changed from: private */
    public boolean onDataPacketRecvd(DataPacket dataPacket) {
        assertRuntime(false);
        if (this.mPacketRecv.get(dataPacket.getSeq()) != null) {
            return false;
        }
        this.mPacketRecv.put(dataPacket.getSeq(), dataPacket);
        this.mTotalBytes += dataPacket.getDataLength();
        stopTimer();
        return true;
    }

    private boolean onPostState(ChannelEvent channelEvent, Object... objArr) {
        boolean z = false;
        assertRuntime(false);
        ChannelStateBlock[] channelStateBlockArr = this.stateMachine;
        int length = channelStateBlockArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            ChannelStateBlock channelStateBlock = channelStateBlockArr[i];
            if (channelStateBlock.state == this.mCurrentState && channelStateBlock.event == channelEvent) {
                channelStateBlock.handler.handleState(objArr);
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            logError("onPostState: state = %s, event = %s, not handled!!!", this.mCurrentState, channelEvent);
        }
        return z;
    }

    /* access modifiers changed from: private */
    public void onSendCallback(int i) {
        assertRuntime(false);
        if (i == 0) {
            wf("onSendCallback, code = %d", Integer.valueOf(i));
        } else {
            log("onSendCallback, code = %d", Integer.valueOf(i));
        }
        ChannelCallback channelCallback = this.mChannelCallback;
        if (channelCallback != null) {
            channelCallback.onCallback(i);
        }
    }

    private void performBatchWrite(List<byte[]> list, ChannelCallback channelCallback) {
        assertRuntime(false);
        if (channelCallback != null) {
            if (!isTimerOn()) {
                startExceptionTimer();
            }
            BluetoothContextManager.post(new a(this, list, channelCallback));
            return;
        }
        resetOnException();
        throw new NullPointerException("callback can't be null");
    }

    /* access modifiers changed from: private */
    public void performOnRead(byte[] bArr) {
        receivePacket(Packet.getPacket(bArr), (IChannelPacketReadResult) null);
    }

    /* access modifiers changed from: private */
    public void performSend(int i, byte[] bArr, int i2, ChannelCallback channelCallback) {
        assertRuntime(false);
        if (this.mCurrentState != ChannelState.IDLE) {
            log("preform send ,but channelState is not idle", new Object[0]);
            channelCallback.onCallback(-3);
            return;
        }
        this.mPackageType = i2;
        this.mCurrentState = ChannelState.READY;
        this.mChannelCallback = (ChannelCallback) ProxyUtils.getUIProxy(channelCallback);
        if (i == 8) {
            if (bArr.length > getDMTU() - 4) {
                sendMixControlData(bArr, i2);
                return;
            }
            i = 6;
        }
        int length = bArr.length;
        this.mTotalBytes = length;
        this.mFrameCount = getFrameCount(length);
        if (needCRC32Verify()) {
            this.mBytesToWrite = Arrays.copyOf(bArr, bArr.length + 4);
            byte[] bArr2 = CRC32.get(bArr);
            System.arraycopy(bArr2, 0, this.mBytesToWrite, bArr.length, 4);
            if (DEBUG) {
                log("performSend CRC32 = " + ByteUtils.byteToString(bArr2), new Object[0]);
            }
        } else {
            this.mBytesToWrite = Arrays.copyOf(bArr, bArr.length);
        }
        if (this.mFrameCount == 1 && i == 0) {
            i = 2;
        }
        sendStartFlowPacket(i, i2, this.mBytesToWrite);
    }

    /* access modifiers changed from: private */
    public void performWrite(Packet packet, ChannelCallback channelCallback) {
        performWrite(packet, channelCallback, false);
    }

    /* access modifiers changed from: private */
    public void receivePacket(Packet packet, IChannelPacketReadResult iChannelPacketReadResult) {
        boolean z = false;
        assertRuntime(false);
        wf("channel=> onReceive from device, packet name =%s", packet.getName());
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
            case 108262:
                if (name.equals(Packet.MNG_CMD)) {
                    c = 3;
                    break;
                }
                break;
            case 3076010:
                if (name.equals("data")) {
                    c = 4;
                    break;
                }
                break;
            case 913950738:
                if (name.equals(Packet.SINGLE_ACK)) {
                    c = 5;
                    break;
                }
                break;
            case 913953194:
                if (name.equals(Packet.SINGLE_CMD)) {
                    c = 6;
                    break;
                }
                break;
            case 968946214:
                if (name.equals(Packet.FAST_ACK)) {
                    c = 7;
                    break;
                }
                break;
            case 968948670:
                if (name.equals(Packet.FAST_CTR)) {
                    c = 8;
                    break;
                }
                break;
            case 1073465790:
                if (name.equals(Packet.MIX_CTR)) {
                    c = 9;
                    break;
                }
                break;
            case 1200909232:
                if (name.equals(Packet.MNG_ACK)) {
                    c = 10;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                z = onPostState(ChannelEvent.RECEIVE_SINGLE_CMD_NO_ACK, packet);
                break;
            case 1:
                z = onPostState(ChannelEvent.RECV_ACK, packet);
                break;
            case 2:
                z = onPostState(ChannelEvent.RECV_CTR, packet);
                break;
            case 3:
                z = onPostState(ChannelEvent.RECV_MNG, packet);
                break;
            case 4:
                ChannelState channelState = this.mCurrentState;
                if (channelState != ChannelState.FAST_READING) {
                    if (channelState != ChannelState.MIX_READING) {
                        z = onPostState(ChannelEvent.RECV_DATA, packet);
                        break;
                    } else {
                        z = onPostState(ChannelEvent.RECV_MIX_DATA, packet);
                        break;
                    }
                } else {
                    z = onPostState(ChannelEvent.RECV_FAST_DATA, packet);
                    break;
                }
            case 5:
                z = onPostState(ChannelEvent.RECV_SINGLE_ACK, packet);
                break;
            case 6:
                z = onPostState(ChannelEvent.RECV_SINGLE_CTR, packet);
                break;
            case 7:
                z = onPostState(ChannelEvent.RECEIVE_FAST_ACK, packet);
                break;
            case 8:
                z = onPostState(ChannelEvent.RECEIVE_FAST_CTR, packet);
                break;
            case 9:
                z = onPostState(ChannelEvent.RECEIVE_MIX_CTR, packet);
                break;
            case 10:
                z = onPostState(ChannelEvent.RECV_MNG_ACK, packet);
                break;
        }
        if (iChannelPacketReadResult != null) {
            iChannelPacketReadResult.onResult(packet, z);
        }
    }

    private void resetOnException() {
        log("resetOnException", new Object[0]);
        stopTimer();
        this.mCurrentState = ChannelState.IDLE;
        this.mBytesToWrite = null;
        this.mFrameCount = 0;
        this.mChannelCallback = null;
        this.mPacketRecv.clear();
        this.mCurrentSync.clear();
        this.mTotalBytes = 0;
    }

    /* access modifiers changed from: private */
    public void sendDataPacket(List<Integer> list, final boolean z) {
        assertRuntime(false);
        int dmtu = getDMTU();
        log("sendDataPacket list= " + list.toString(), new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : list) {
            int intValue2 = intValue.intValue();
            if (intValue2 < this.mFrameCount) {
                int i = intValue2 * dmtu;
                int i2 = intValue2 + 1;
                arrayList.add(new DataPacket(i2, this.mBytesToWrite, i, Math.min(this.mBytesToWrite.length, i2 * dmtu)).toBytes());
            }
        }
        if (!arrayList.isEmpty()) {
            performBatchWrite(arrayList, new ChannelCallback() {
                public void onCallback(int i) {
                    if (!z) {
                        if (Channel.this.mChannelCallback == null) {
                            Channel.this.log("send Data packet onCallback, channelCallback is null ,return", new Object[0]);
                            return;
                        }
                        Channel.this.log("receive batch write callback ,start sync", new Object[0]);
                        Channel.this.setCurrentState(ChannelState.SYNC);
                        Channel.this.startTimer(18000);
                    }
                }
            });
        }
    }

    private void sendFastDataPacket(List<Integer> list) {
        assertRuntime(false);
        int dmtu = getDMTU();
        log("sendDataPacket list= " + list.toString(), new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : list) {
            int intValue2 = intValue.intValue();
            if (intValue2 < this.mFrameCount) {
                int i = intValue2 * dmtu;
                int i2 = intValue2 + 1;
                int min = Math.min(this.mBytesToWrite.length, i2 * dmtu);
                if (i < min) {
                    arrayList.add(new DataPacket(i2, this.mBytesToWrite, i, min).toBytes());
                }
            }
        }
        if (!arrayList.isEmpty()) {
            performBatchWrite(arrayList, new ChannelCallback() {
                public void onCallback(int i) {
                    if (Channel.this.mChannelCallback == null) {
                        Channel.this.log("send Data packet onCallback, channelCallback is null ,return", new Object[0]);
                        return;
                    }
                    Channel channel = Channel.this;
                    channel.log("receive sendFastDataPacket callback ,code=" + i, new Object[0]);
                    Channel.this.onSendCallback(i);
                    Channel.this.resetChannelStatus();
                }
            });
        }
    }

    private void sendMixControlData(byte[] bArr, int i) {
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, getDMTU() - 4);
        int length = copyOfRange.length;
        boolean needCRC32Verify = needCRC32Verify();
        this.mFrameCount = getFrameCount(bArr.length - length);
        if (needCRC32Verify) {
            byte[] bArr2 = CRC32.get(bArr);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, length, bArr.length + 4);
            this.mBytesToWrite = copyOfRange2;
            System.arraycopy(bArr2, 0, copyOfRange2, copyOfRange2.length - 4, 4);
        } else {
            this.mBytesToWrite = Arrays.copyOfRange(bArr, length, bArr.length);
        }
        log("prepare send MixFlowPacket, frame count = %d,package type =%d, value length =%d", Integer.valueOf(this.mFrameCount), Integer.valueOf(i), Integer.valueOf(bArr.length));
        sendStartMixFlowPacket(i, copyOfRange, this.mBytesToWrite);
    }

    private void sendStartFlowPacket(final int i, int i2, byte[] bArr) {
        Packet packet;
        assertRuntime(false);
        int i3 = this.mFrameCount;
        if (i3 > 1) {
            if (i == 6) {
                packet = new FastCTRPacket(i3, i2);
                log("prepare send FastCTRPacket, frame count = %d,package type =%d, value length =%d", Integer.valueOf(this.mFrameCount), Integer.valueOf(i2), Integer.valueOf(bArr.length));
            } else {
                packet = new CTRPacket(i3, i2);
                log("prepare send CTRPacket, frame count = %d,package type =%d, value length =%d", Integer.valueOf(this.mFrameCount), Integer.valueOf(i2), Integer.valueOf(bArr.length));
            }
        } else if (i == 9) {
            packet = new SingleNoAckPacket(i2, bArr);
            log("prepare send SingleNoAckPacket, frame count = %d,package type =%d, value length =%d", Integer.valueOf(this.mFrameCount), Integer.valueOf(i2), Integer.valueOf(bArr.length));
        } else if (i == 2) {
            packet = new SinglePacket(i2, bArr);
            log("prepare send SinglePacket, frame count = %d,package type =%d, value length =%d", Integer.valueOf(this.mFrameCount), Integer.valueOf(i2), Integer.valueOf(bArr.length));
        } else if (i == 6) {
            packet = new FastCTRPacket(i3, i2);
            log("prepare send FastCTRPacket, frame count = %d,package type =%d, value length =%d", Integer.valueOf(this.mFrameCount), Integer.valueOf(i2), Integer.valueOf(bArr.length));
        } else {
            packet = null;
        }
        if (packet == null) {
            logError("send start flow packet, opcode =" + i + ",packageType=" + i2 + ",but build flow packet is null", new Object[0]);
            return;
        }
        performWrite(packet, new ChannelCallback() {
            /* access modifiers changed from: private */
            public /* synthetic */ void lambda$onCallback$0() {
                Channel.this.startSendFastData();
            }

            public void onCallback(int i) {
                Channel.this.assertRuntime(false);
                if (i != 0) {
                    Channel.this.onSendCallback(-1);
                    Channel.this.resetChannelStatus();
                    return;
                }
                if (Channel.this.mFrameCount >= 1 && i == 6) {
                    Channel.this.mWorkerHandler.postDelayed(new b(this), 6);
                }
                if (i == 9) {
                    Channel.this.onSendCallback(0);
                    Channel.this.resetChannelStatus();
                }
            }
        });
        if (this.mFrameCount > 1) {
            if (i != 6) {
                onPostState(ChannelEvent.SEND_CTR, new Object[0]);
            }
        } else if (i == 2) {
            onPostState(ChannelEvent.SEND_SINGLE_CTR, new Object[0]);
        } else if (i == 4) {
            onPostState(ChannelEvent.SEND_MNG, new Object[0]);
        }
    }

    private void sendStartMixFlowPacket(int i, byte[] bArr, byte[] bArr2) {
        assertRuntime(false);
        performWrite(new MixCTRPacket(this.mFrameCount, i, bArr), new ChannelCallback() {
            /* access modifiers changed from: private */
            public /* synthetic */ void lambda$onCallback$0() {
                Channel.this.startSendFastData();
            }

            public void onCallback(int i) {
                if (i != 0) {
                    Channel.this.onSendCallback(-1);
                    Channel.this.resetChannelStatus();
                    return;
                }
                Channel.this.mWorkerHandler.postDelayed(new c(this), 6);
            }
        });
    }

    /* access modifiers changed from: private */
    public void setCurrentState(ChannelState channelState) {
        assertRuntime(false);
        wf("setCurrentState: state = %s", channelState);
        this.mCurrentState = channelState;
    }

    private void startExceptionTimer() {
        startTimer(TIMEOUT, new Timer.TimerCallback(TIMER_EXCEPTION) {
            public void onTimerCallback() throws TimeoutException {
                throw new TimeoutException();
            }

            public void resetCallback() {
                Channel.this.mTimer.resetCallback();
            }
        });
    }

    /* access modifiers changed from: private */
    public void startSendFastData() {
        setCurrentState(ChannelState.WRITING);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mFrameCount; i++) {
            arrayList.add(Integer.valueOf(i));
        }
        sendFastDataPacket(arrayList);
    }

    /* access modifiers changed from: private */
    public void startSyncPacket() {
        assertRuntime(false);
        log("startSyncPacket", new Object[0]);
        startTimer();
        setCurrentState(ChannelState.SYNC);
        if (!syncLostPacket()) {
            final byte[] totalRecvdBytes = getTotalRecvdBytes();
            if (!ByteUtils.isEmpty(totalRecvdBytes)) {
                performWrite(new ACKPacket(0), new ChannelCallback() {
                    public void onCallback(int i) {
                        Channel.this.assertRuntime(false);
                        Channel.this.resetChannelStatus();
                        if (i == 0) {
                            Channel.this.dispatchOnReceive(totalRecvdBytes);
                        }
                    }
                });
            } else {
                resetChannelStatus();
            }
        }
    }

    /* access modifiers changed from: private */
    public void startTimer() {
        startTimer(TIMEOUT);
    }

    /* access modifiers changed from: private */
    public void stopTimer() {
        if (DEBUG) {
            wf("stopTimer", new Object[0]);
        }
        this.mTimer.stop();
    }

    private boolean syncLostPacket() {
        assertRuntime(false);
        if (DEBUG) {
            log("syncLostPacket", new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        int maxPackageNum = getMaxPackageNum();
        for (int i = 1; i <= this.mFrameCount; i++) {
            if (this.mPacketRecv.get(i) == null) {
                arrayList.add(Short.valueOf((short) i));
            }
            if (arrayList.size() >= maxPackageNum) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        log("exit lost seq,start sync packet", new Object[0]);
        this.mCurrentSync = arrayList;
        performWrite(new ACKPacket(5, arrayList), new ChannelCallback() {
            public void onCallback(int i) {
                Channel.this.assertRuntime(false);
                if (i == 0) {
                    Channel.this.startTimer();
                } else {
                    Channel.this.resetChannelStatus();
                }
            }
        });
        setCurrentState(ChannelState.SYNC_ACK);
        return true;
    }

    public abstract int getDMTU();

    public abstract int getMaxPackageNum();

    public byte[] handleTotalReceiveBytes(ByteBuffer byteBuffer, int i) {
        if (!needCRC32Verify()) {
            return byteBuffer.array();
        }
        int i2 = i - 4;
        byte[] bArr = {byteBuffer.get(i2), byteBuffer.get(i - 3), byteBuffer.get(i - 2), byteBuffer.get(i - 1)};
        byte[] bArr2 = new byte[i2];
        System.arraycopy(byteBuffer.array(), 0, bArr2, 0, i2);
        if (checkCRC32(bArr2, bArr)) {
            return bArr2;
        }
        if (DEBUG) {
            logError("check crc failed!!", new Object[0]);
        }
        return ByteUtils.EMPTY_BYTES;
    }

    public void log(String str, Object... objArr) {
        BluetoothLog.log(TAG, str, objArr);
    }

    public void logError(String str, Object... objArr) {
        BluetoothLog.error(TAG, str, objArr);
    }

    public boolean onIntercept(Object obj, Method method, Object[] objArr) {
        this.mWorkerHandler.obtainMessage(0, new ProxyBulk(obj, method, objArr)).sendToTarget();
        return true;
    }

    public void onRead(byte[] bArr) {
        this.mChannel.onRead(bArr);
    }

    public void onReadPacket(Packet packet, IChannelPacketReadResult iChannelPacketReadResult) {
        this.mChannel.onReadPacket(packet, iChannelPacketReadResult);
    }

    public void reset(int i) {
        this.mChannel.reset(i);
    }

    public void resetChannelStatus() {
        assertRuntime(false);
        wf("resetChannelStatus", new Object[0]);
        stopTimer();
        setCurrentState(ChannelState.IDLE);
        this.mBytesToWrite = null;
        this.mFrameCount = 0;
        this.mChannelCallback = null;
        this.mMixHeaderData = null;
        this.mPacketRecv.clear();
        this.mCurrentSync.clear();
        this.mTotalBytes = 0;
    }

    public void send(int i, byte[] bArr, int i2, ChannelCallback channelCallback) {
        this.mChannel.send(i, bArr, i2, channelCallback);
    }

    public abstract boolean useCrc32Verify();

    public void wf(String str, Object... objArr) {
        BluetoothLog.df(TAG, str, objArr);
    }

    private void performWrite(Packet packet, ChannelCallback channelCallback, boolean z) {
        assertRuntime(false);
        if (channelCallback != null) {
            WriteCallback writeCallback = new WriteCallback(channelCallback, TIMER_EXCEPTION);
            if (!isTimerOn()) {
                startTimer(CMD_TIMEOUT, writeCallback);
            }
            byte[] bytes = packet.toBytes();
            wf("performWrite, bytes length=" + bytes.length, new Object[0]);
            BluetoothContextManager.post(new a(this, bytes, writeCallback, z));
            return;
        }
        resetOnException();
        throw new NullPointerException("callback can't be null");
    }

    /* access modifiers changed from: private */
    public void startTimer(long j) {
        startTimer(j, this.mTimeoutHandler);
    }

    public final void send(byte[] bArr, int i, ChannelCallback channelCallback) {
        this.mChannel.send(bArr, i, channelCallback);
    }

    /* access modifiers changed from: private */
    public void startTimer(long j, Timer.TimerCallback timerCallback) {
        wf("startTimer: duration = %d", Long.valueOf(j));
        this.mTimer.start(timerCallback, j);
    }

    public class WriteCallback extends Timer.TimerCallback implements ChannelCallback {
        ChannelCallback callback;
        private boolean isTimeout = false;

        public WriteCallback(ChannelCallback channelCallback, String str) {
            super(str);
            this.callback = channelCallback;
        }

        public void onCallback(int i) {
            if (!this.isTimeout) {
                Channel.this.mWorkerHandler.obtainMessage(1, i, 0, this.callback).sendToTarget();
            } else {
                Channel.this.logError("WriteCallback onCallback ,has trigger timeout, so ignore it!", new Object[0]);
            }
        }

        public void onTimerCallback() {
            Channel.this.logError("do performWrite happen Timer timeout!", new Object[0]);
            this.isTimeout = true;
            Channel.this.mWorkerHandler.obtainMessage(1, -2, 0, this.callback).sendToTarget();
        }

        public void resetCallback() {
            Channel.this.mTimer.resetCallback();
        }

        public WriteCallback(ChannelCallback channelCallback) {
            super("None");
            this.callback = channelCallback;
        }
    }
}
