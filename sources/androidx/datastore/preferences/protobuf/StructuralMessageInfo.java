package androidx.datastore.preferences.protobuf;

final class StructuralMessageInfo implements MessageInfo {

    /* renamed from: a  reason: collision with root package name */
    public final ProtoSyntax f1146a;
    public final boolean b;
    public final int[] c;
    public final FieldInfo[] d;
    public final MessageLite e;

    public static final class Builder {
    }

    public int[] a() {
        return this.c;
    }

    public FieldInfo[] b() {
        return this.d;
    }

    public MessageLite getDefaultInstance() {
        return this.e;
    }

    public ProtoSyntax getSyntax() {
        return this.f1146a;
    }

    public boolean isMessageSetWireFormat() {
        return this.b;
    }
}
