package com.upuphone.runasone.ble;

import com.upuphone.runasone.ble.BleRequest;
import com.upuphone.runasone.utils.BleLogger;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class RequestDispatcher {
    private static final String TAG = "RequestDispatcher";
    private List<BleRequest> bleRequestList = new LinkedList();
    private BleRequest currentRequest = null;
    private int requestId = 1;
    private BleInternalSession session;

    public RequestDispatcher(BleInternalSession bleInternalSession) {
        this.session = bleInternalSession;
    }

    private void doNext() {
        if (this.bleRequestList.isEmpty()) {
            BleLogger.d(TAG, (Object) "doNext ble request list is empty");
        } else if (this.currentRequest != null) {
            BleLogger.d(TAG, (Object) "doNext current request is on going " + this.currentRequest.requestId);
        } else {
            BleRequest remove = this.bleRequestList.remove(0);
            this.currentRequest = remove;
            if (remove instanceof BleRequest.WriteRequest) {
                writeImpl((BleRequest.WriteRequest) remove);
            } else if (remove instanceof BleRequest.ReadRequest) {
                readImpl((BleRequest.ReadRequest) remove);
            } else if (remove instanceof BleRequest.OpenNotifyRequest) {
                openNotifyImpl((BleRequest.OpenNotifyRequest) remove);
            } else if (remove instanceof BleRequest.MtuRequest) {
                setMtuImpl((BleRequest.MtuRequest) remove);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("not support BleRequest, currentRequest=");
                BleRequest bleRequest = this.currentRequest;
                sb.append(bleRequest == null ? "null" : bleRequest.getClass().getName());
                BleLogger.e(TAG, (Object) sb.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    public void finishRequest() {
        this.currentRequest = null;
        doNext();
    }

    private void openNotifyImpl(final BleRequest.OpenNotifyRequest openNotifyRequest) {
        if (this.session != null) {
            BleLogger.d(TAG, (Object) "openNotifyImpl, request id =" + openNotifyRequest.requestId);
            this.session.openNotify(openNotifyRequest.notifyUuid, new OpenNotifyCallback() {
                public void onOpen(int i) {
                    openNotifyRequest.openNotifyCallback.onOpen(i);
                    RequestDispatcher.this.finishRequest();
                }
            });
            return;
        }
        BleLogger.w(TAG, (Object) "write fail, you need connect first!");
    }

    private void readImpl(final BleRequest.ReadRequest readRequest) {
        if (this.session != null) {
            BleLogger.d(TAG, (Object) "readImpl, request id =" + readRequest.requestId);
            this.session.read(readRequest.readUuid, new ReadCallback() {
                public void onRead(int i, byte[] bArr) {
                    readRequest.readCallback.onRead(i, bArr);
                    RequestDispatcher.this.finishRequest();
                }
            });
            return;
        }
        BleLogger.w(TAG, (Object) "read fail, you need connect first!");
    }

    private void setMtuImpl(final BleRequest.MtuRequest mtuRequest) {
        if (this.session != null) {
            BleLogger.d(TAG, (Object) "setMtuImpl, request id =" + mtuRequest.requestId);
            this.session.setMtu(mtuRequest.mtuSize, new MtuCallback() {
                public void onMtuChange(int i, int i2) {
                    mtuRequest.mtuCallback.onMtuChange(i, i2);
                    RequestDispatcher.this.finishRequest();
                }
            });
            return;
        }
        BleLogger.w(TAG, (Object) "setMtu fail, you need bind BleSession Object first!");
    }

    private void writeImpl(final BleRequest.WriteRequest writeRequest) {
        if (this.session != null) {
            BleLogger.d(TAG, (Object) "writeImpl, request id =" + writeRequest.requestId);
            this.session.write(writeRequest.writeUuid, writeRequest.data, new WriteCallback() {
                public void onWrite(int i) {
                    writeRequest.callback.onWrite(i);
                    RequestDispatcher.this.finishRequest();
                }
            });
            return;
        }
        BleLogger.w(TAG, (Object) "write fail, you need connect first!");
    }

    public void openNotify(UUID uuid, OpenNotifyCallback openNotifyCallback) {
        List<BleRequest> list = this.bleRequestList;
        int i = this.requestId;
        this.requestId = i + 1;
        list.add(new BleRequest.OpenNotifyRequest(i, uuid, openNotifyCallback));
        doNext();
    }

    public void read(UUID uuid, ReadCallback readCallback) {
        List<BleRequest> list = this.bleRequestList;
        int i = this.requestId;
        this.requestId = i + 1;
        list.add(new BleRequest.ReadRequest(i, uuid, readCallback));
        doNext();
    }

    public void release() {
        BleLogger.d(TAG, (Object) "release");
        this.bleRequestList.clear();
        this.currentRequest = null;
    }

    public void setMtu(int i, MtuCallback mtuCallback) {
        List<BleRequest> list = this.bleRequestList;
        int i2 = this.requestId;
        this.requestId = i2 + 1;
        list.add(new BleRequest.MtuRequest(i2, i, mtuCallback));
        doNext();
    }

    public void write(UUID uuid, byte[] bArr, WriteCallback writeCallback) {
        List<BleRequest> list = this.bleRequestList;
        int i = this.requestId;
        this.requestId = i + 1;
        list.add(new BleRequest.WriteRequest(i, uuid, bArr, writeCallback));
        doNext();
    }
}
