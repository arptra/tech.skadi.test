package androidx.datastore.preferences.protobuf;

import java.util.List;

public interface LazyStringList extends ProtocolStringList {
    void g(ByteString byteString);

    Object getRaw(int i);

    List getUnderlyingElements();

    LazyStringList getUnmodifiableView();
}
