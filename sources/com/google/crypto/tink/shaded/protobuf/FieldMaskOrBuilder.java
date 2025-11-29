package com.google.crypto.tink.shaded.protobuf;

import java.util.List;

public interface FieldMaskOrBuilder extends MessageOrBuilder {
    String getPaths(int i);

    ByteString getPathsBytes(int i);

    int getPathsCount();

    List<String> getPathsList();
}
