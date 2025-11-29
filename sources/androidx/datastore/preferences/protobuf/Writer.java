package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MapEntryLite;
import java.util.List;
import java.util.Map;

interface Writer {

    public enum FieldOrder {
        ASCENDING,
        DESCENDING
    }

    void a(int i, ByteString byteString);

    void b(int i, Object obj, Schema schema);

    void c(int i, MapEntryLite.Metadata metadata, Map map);

    void d(int i, List list, Schema schema);

    void e(int i, Object obj, Schema schema);

    void f(int i, List list, Schema schema);

    FieldOrder fieldOrder();

    void writeBool(int i, boolean z);

    void writeBoolList(int i, List list, boolean z);

    void writeBytesList(int i, List list);

    void writeDouble(int i, double d);

    void writeDoubleList(int i, List list, boolean z);

    void writeEndGroup(int i);

    void writeEnum(int i, int i2);

    void writeEnumList(int i, List list, boolean z);

    void writeFixed32(int i, int i2);

    void writeFixed32List(int i, List list, boolean z);

    void writeFixed64(int i, long j);

    void writeFixed64List(int i, List list, boolean z);

    void writeFloat(int i, float f);

    void writeFloatList(int i, List list, boolean z);

    void writeInt32(int i, int i2);

    void writeInt32List(int i, List list, boolean z);

    void writeInt64(int i, long j);

    void writeInt64List(int i, List list, boolean z);

    void writeMessage(int i, Object obj);

    void writeMessageSetItem(int i, Object obj);

    void writeSFixed32(int i, int i2);

    void writeSFixed32List(int i, List list, boolean z);

    void writeSFixed64(int i, long j);

    void writeSFixed64List(int i, List list, boolean z);

    void writeSInt32(int i, int i2);

    void writeSInt32List(int i, List list, boolean z);

    void writeSInt64(int i, long j);

    void writeSInt64List(int i, List list, boolean z);

    void writeStartGroup(int i);

    void writeString(int i, String str);

    void writeStringList(int i, List list);

    void writeUInt32(int i, int i2);

    void writeUInt32List(int i, List list, boolean z);

    void writeUInt64(int i, long j);

    void writeUInt64List(int i, List list, boolean z);
}
