package org.apache.tika.metadata;

public interface MachineMetadata {

    public static final class Endian {
        public static final Endian c = new Endian("Little", false);
        public static final Endian d = new Endian("Big", true);

        /* renamed from: a  reason: collision with root package name */
        public final String f7109a;
        public final boolean b;

        public Endian(String str, boolean z) {
            this.f7109a = str;
            this.b = z;
        }
    }
}
