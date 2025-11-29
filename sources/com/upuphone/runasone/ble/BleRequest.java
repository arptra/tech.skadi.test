package com.upuphone.runasone.ble;

import java.util.UUID;

public abstract class BleRequest {
    public int requestId;

    public static class MtuRequest extends BleRequest {
        public MtuCallback mtuCallback;
        public int mtuSize;

        public MtuRequest(int i, int i2, MtuCallback mtuCallback2) {
            this.requestId = i;
            this.mtuSize = i2;
            this.mtuCallback = mtuCallback2;
        }
    }

    public static class OpenNotifyRequest extends BleRequest {
        public UUID notifyUuid;
        public OpenNotifyCallback openNotifyCallback;

        public OpenNotifyRequest(int i, UUID uuid, OpenNotifyCallback openNotifyCallback2) {
            this.requestId = i;
            this.notifyUuid = uuid;
            this.openNotifyCallback = openNotifyCallback2;
        }
    }

    public static class ReadRequest extends BleRequest {
        public ReadCallback readCallback;
        public UUID readUuid;

        public ReadRequest(int i, UUID uuid, ReadCallback readCallback2) {
            this.requestId = i;
            this.readUuid = uuid;
            this.readCallback = readCallback2;
        }
    }

    public static class WriteRequest extends BleRequest {
        public WriteCallback callback;
        public byte[] data;
        public UUID writeUuid;

        public WriteRequest(int i, UUID uuid, byte[] bArr, WriteCallback writeCallback) {
            this.requestId = i;
            this.writeUuid = uuid;
            this.data = bArr;
            this.callback = writeCallback;
        }
    }
}
