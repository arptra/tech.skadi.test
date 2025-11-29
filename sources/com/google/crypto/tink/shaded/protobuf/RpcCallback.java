package com.google.crypto.tink.shaded.protobuf;

public interface RpcCallback<ParameterType> {
    void run(ParameterType parametertype);
}
