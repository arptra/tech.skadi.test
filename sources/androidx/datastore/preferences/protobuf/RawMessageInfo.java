package androidx.datastore.preferences.protobuf;

final class RawMessageInfo implements MessageInfo {

    /* renamed from: a  reason: collision with root package name */
    public final MessageLite f1130a;
    public final String b;
    public final Object[] c;
    public final int d;

    public RawMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        this.f1130a = messageLite;
        this.b = str;
        this.c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.d = charAt;
            return;
        }
        char c2 = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c2 |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.d = c2 | (charAt2 << i);
                return;
            }
        }
    }

    public Object[] a() {
        return this.c;
    }

    public String b() {
        return this.b;
    }

    public MessageLite getDefaultInstance() {
        return this.f1130a;
    }

    public ProtoSyntax getSyntax() {
        return (this.d & 1) == 1 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
    }

    public boolean isMessageSetWireFormat() {
        return (this.d & 2) == 2;
    }
}
