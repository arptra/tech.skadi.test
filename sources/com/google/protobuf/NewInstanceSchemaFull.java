package com.google.protobuf;

import com.google.protobuf.GeneratedMessageV3;

final class NewInstanceSchemaFull implements NewInstanceSchema {
    public Object newInstance(Object obj) {
        return ((GeneratedMessageV3) obj).newInstance(GeneratedMessageV3.UnusedPrivateParameter.INSTANCE);
    }
}
