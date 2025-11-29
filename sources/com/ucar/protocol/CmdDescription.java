package com.ucar.protocol;

public final class CmdDescription {

    /* renamed from: a  reason: collision with root package name */
    public SourceDevice f9631a;
    public DataFormat b;
    public MessageType c;
    public CmdCategory d;
    public int e;
    public short f = 0;

    static {
        UCarRawProtocol.j();
        UCarAuthProtocol.l();
        UCarControlProtocol.y();
        UCarSensorProtocol.r();
        UCarCertProtocol.k();
    }

    public CmdDescription(SourceDevice sourceDevice, DataFormat dataFormat, MessageType messageType, CmdCategory cmdCategory, int i) {
        ParamValidation.c(sourceDevice, "sourceDevice");
        ParamValidation.c(dataFormat, "dataFormat");
        ParamValidation.c(cmdCategory, "category");
        ParamValidation.c(messageType, "messageType");
        this.f9631a = sourceDevice;
        this.b = dataFormat;
        this.c = messageType;
        this.d = cmdCategory;
        this.e = i;
    }

    public final CmdCategory a() {
        return this.d;
    }

    public final DataFormat b() {
        return this.b;
    }

    public MessageType c() {
        return this.c;
    }

    public final int d() {
        return this.e;
    }

    public final SourceDevice e() {
        return this.f9631a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CmdDescription)) {
            return false;
        }
        CmdDescription cmdDescription = (CmdDescription) obj;
        return ParamValidation.a(this.f9631a, cmdDescription.f9631a) && ParamValidation.a(this.b, cmdDescription.b) && ParamValidation.a(this.d, cmdDescription.d) && ParamValidation.a(this.c, cmdDescription.c) && this.e == cmdDescription.e;
    }

    public boolean f() {
        DataFormat dataFormat = this.b;
        return dataFormat == DataFormat.RAW || dataFormat == DataFormat.RAW_NO_ENCRYPTED;
    }

    public void g(SourceDevice sourceDevice, DataFormat dataFormat, MessageType messageType, CmdCategory cmdCategory, int i) {
        this.f9631a = sourceDevice;
        this.b = dataFormat;
        this.c = messageType;
        this.d = cmdCategory;
        this.e = i;
    }

    public void h(MessageType messageType) {
        if (messageType == null) {
            throw new ProtocolException("messageType can not be null");
        } else if (c() == MessageType.SEND && messageType == MessageType.SEND_SYNC) {
            this.c = messageType;
        } else {
            throw new ProtocolException("Only SEND MessageType can be changed");
        }
    }

    public int hashCode() {
        SourceDevice sourceDevice = this.f9631a;
        int i = 0;
        int hashCode = (sourceDevice != null ? sourceDevice.hashCode() : 0) * 31;
        DataFormat dataFormat = this.b;
        int hashCode2 = (hashCode + (dataFormat != null ? dataFormat.hashCode() : 0)) * 31;
        CmdCategory cmdCategory = this.d;
        if (cmdCategory != null) {
            i = cmdCategory.hashCode();
        }
        return ((hashCode2 + i) * 31) + Integer.hashCode(this.e);
    }

    public String toString() {
        return "from=" + this.f9631a + "|format=" + this.b + "|type=" + this.c + "|category=" + this.d + "|method=" + UCarProtocol.e(this.d, this.e) + "(" + this.e + ")";
    }
}
