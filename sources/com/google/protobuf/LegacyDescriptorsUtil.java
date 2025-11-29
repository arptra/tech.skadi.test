package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.upuphone.starrynet.common.StarryNetConstant;

public final class LegacyDescriptorsUtil {

    /* renamed from: com.google.protobuf.LegacyDescriptorsUtil$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.protobuf.Descriptors$FileDescriptor$Syntax[] r0 = com.google.protobuf.Descriptors.FileDescriptor.Syntax.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax = r0
                com.google.protobuf.Descriptors$FileDescriptor$Syntax r1 = com.google.protobuf.Descriptors.FileDescriptor.Syntax.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.Descriptors$FileDescriptor$Syntax r1 = com.google.protobuf.Descriptors.FileDescriptor.Syntax.PROTO2     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.Descriptors$FileDescriptor$Syntax r1 = com.google.protobuf.Descriptors.FileDescriptor.Syntax.PROTO3     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.LegacyDescriptorsUtil.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class LegacyFileDescriptor {

        public enum Syntax {
            UNKNOWN(StarryNetConstant.DEVICE_NAME_UNKNOWN),
            PROTO2("proto2"),
            PROTO3("proto3");
            
            final String name;

            private Syntax(String str) {
                this.name = str;
            }
        }

        private LegacyFileDescriptor() {
        }

        public static Syntax getSyntax(Descriptors.FileDescriptor fileDescriptor) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax[fileDescriptor.getSyntax().ordinal()];
            if (i == 1) {
                return Syntax.UNKNOWN;
            }
            if (i == 2) {
                return Syntax.PROTO2;
            }
            if (i == 3) {
                return Syntax.PROTO3;
            }
            throw new IllegalArgumentException("Unexpected syntax");
        }
    }

    public static final class LegacyOneofDescriptor {
        private LegacyOneofDescriptor() {
        }

        public static boolean isSynthetic(Descriptors.OneofDescriptor oneofDescriptor) {
            return oneofDescriptor.isSynthetic();
        }
    }

    private LegacyDescriptorsUtil() {
    }
}
