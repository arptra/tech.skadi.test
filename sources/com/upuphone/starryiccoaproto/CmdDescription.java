package com.upuphone.starryiccoaproto;

public final class CmdDescription {

    /* renamed from: a  reason: collision with root package name */
    public SourceDevice f6513a;
    public DataFormat b;
    public MessageType c;
    public CmdCategory d;
    public int e;

    static {
        UCarControlProtocol.e();
    }

    public CmdDescription(SourceDevice sourceDevice, DataFormat dataFormat, MessageType messageType, CmdCategory cmdCategory, int i) {
        this.f6513a = sourceDevice;
        this.b = dataFormat;
        this.c = messageType;
        this.d = cmdCategory;
        this.e = i;
    }

    public CmdCategory a() {
        return this.d;
    }

    public DataFormat b() {
        return this.b;
    }

    public MessageType c() {
        return this.c;
    }

    public int d() {
        return this.e;
    }

    public SourceDevice e() {
        return this.f6513a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CmdDescription)) {
            return false;
        }
        CmdDescription cmdDescription = (CmdDescription) obj;
        return ParamValidation.a(this.f6513a, cmdDescription.f6513a) && ParamValidation.a(this.b, cmdDescription.b) && ParamValidation.a(this.d, cmdDescription.d) && ParamValidation.a(this.c, cmdDescription.c) && this.e == cmdDescription.e;
    }

    public void f(SourceDevice sourceDevice, DataFormat dataFormat, MessageType messageType, CmdCategory cmdCategory, int i) {
        this.f6513a = sourceDevice;
        this.b = dataFormat;
        this.c = messageType;
        this.d = cmdCategory;
        this.e = i;
    }

    public int hashCode() {
        SourceDevice sourceDevice = this.f6513a;
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
        return "from=" + this.f6513a + "|format=" + this.b + "|type=" + this.c + "|category=" + this.d + "|method=" + UCarProtocol.b(this.d, this.e) + "(" + this.e + ")";
    }

    public CmdDescription() {
    }
}
