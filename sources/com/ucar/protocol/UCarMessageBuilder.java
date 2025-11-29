package com.ucar.protocol;

import com.google.protobuf.GeneratedMessageV3;

public class UCarMessageBuilder {

    /* renamed from: a  reason: collision with root package name */
    public SourceDevice f9639a = ProtocolConfig.e();
    public CmdCategory b;
    public MessageType c = MessageType.SEND;
    public DataFormat d = DataFormat.RAW;
    public int e;

    public UCarMessage a(GeneratedMessageV3 generatedMessageV3) {
        ParamValidation.c(generatedMessageV3, "protobufMessage");
        c(DataFormat.PB3);
        byte[] byteArray = generatedMessageV3.toByteArray();
        return new UCarMessage(new MessageHeader(byteArray.length + 20, new CmdDescription(this.f9639a, this.d, this.c, this.b, this.e)), byteArray);
    }

    public UCarMessageBuilder b(CmdCategory cmdCategory) {
        ParamValidation.c(cmdCategory, "cmdCategory");
        this.b = cmdCategory;
        return this;
    }

    public UCarMessageBuilder c(DataFormat dataFormat) {
        ParamValidation.c(dataFormat, "dataFormat");
        this.d = dataFormat;
        return this;
    }

    public UCarMessageBuilder d(MessageType messageType) {
        ParamValidation.c(this.d, "dataFormat");
        this.c = messageType;
        return this;
    }

    public UCarMessageBuilder e(int i) {
        this.e = i;
        return this;
    }

    public UCarMessageBuilder f(SourceDevice sourceDevice) {
        ParamValidation.c(sourceDevice, "sourceDevice");
        this.f9639a = sourceDevice;
        return this;
    }
}
