package com.upuphone.starryiccoaproto;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

public class UCarMessage implements Parcelable {
    public static final Parcelable.Creator<UCarMessage> CREATOR = new Parcelable.Creator<UCarMessage>() {
        /* renamed from: a */
        public UCarMessage createFromParcel(Parcel parcel) {
            return new UCarMessage(parcel);
        }

        /* renamed from: b */
        public UCarMessage[] newArray(int i) {
            return new UCarMessage[i];
        }
    };
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;
    private byte[] mBodyBuff;
    private int mBodyLength;
    private byte[] mHeader;

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
    }

    public UCarMessage(byte[] bArr, byte[] bArr2) {
        this(bArr, bArr2, bArr2.length);
    }

    public static UCarMessageBuilder newBuilder() {
        return new UCarMessageBuilder();
    }

    public static UCarMessage obtainAckMessage(int i) {
        MessageHeader messageHeader = new MessageHeader(20, new CmdDescription(SourceDevice.PHONE, DataFormat.RAW, MessageType.RES, CmdCategory.ACK, 0));
        messageHeader.l(i);
        return new UCarMessage(messageHeader.i(), new byte[0], 0);
    }

    public int describeContents() {
        return 0;
    }

    public int getBodyLength() {
        return this.mBodyLength;
    }

    public byte[] getmBodyBuff() {
        return this.mBodyBuff;
    }

    public byte[] getmHeader() {
        return this.mHeader;
    }

    public final byte[] updateBodyLength(int i) {
        MessageHeader b = MessageHeader.b(this.mHeader);
        b.j(i);
        this.mBodyLength = i;
        return b.i();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.mHeader);
        parcel.writeByteArray(this.mBodyBuff);
        parcel.writeInt(this.mBodyLength);
    }

    public UCarMessage(byte[] bArr, byte[] bArr2, int i) {
        this.mHeader = bArr;
        this.mBodyLength = i;
        this.mBodyBuff = bArr2;
    }

    public UCarMessage(Parcel parcel) {
        this.mHeader = parcel.createByteArray();
        this.mBodyBuff = parcel.createByteArray();
        this.mBodyLength = parcel.readInt();
    }
}
