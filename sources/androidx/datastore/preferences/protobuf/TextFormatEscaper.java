package androidx.datastore.preferences.protobuf;

import org.apache.commons.io.IOUtils;

final class TextFormatEscaper {

    /* renamed from: androidx.datastore.preferences.protobuf.TextFormatEscaper$2  reason: invalid class name */
    final class AnonymousClass2 implements ByteSequence {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ byte[] f1149a;

        public byte byteAt(int i) {
            return this.f1149a[i];
        }

        public int size() {
            return this.f1149a.length;
        }
    }

    public interface ByteSequence {
        byte byteAt(int i);

        int size();
    }

    public static String a(final ByteString byteString) {
        return b(new ByteSequence() {
            public byte byteAt(int i) {
                return byteString.byteAt(i);
            }

            public int size() {
                return byteString.size();
            }
        });
    }

    public static String b(ByteSequence byteSequence) {
        StringBuilder sb = new StringBuilder(byteSequence.size());
        for (int i = 0; i < byteSequence.size(); i++) {
            byte byteAt = byteSequence.byteAt(i);
            if (byteAt == 34) {
                sb.append("\\\"");
            } else if (byteAt == 39) {
                sb.append("\\'");
            } else if (byteAt != 92) {
                switch (byteAt) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (byteAt >= 32 && byteAt <= 126) {
                            sb.append((char) byteAt);
                            break;
                        } else {
                            sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                            sb.append((char) (((byteAt >>> 6) & 3) + 48));
                            sb.append((char) (((byteAt >>> 3) & 7) + 48));
                            sb.append((char) ((byteAt & 7) + 48));
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static String c(String str) {
        return a(ByteString.copyFromUtf8(str));
    }
}
