package com.google.crypto.tink.mac;

import com.google.crypto.tink.Mac;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

class MacWrapper implements PrimitiveWrapper<Mac, Mac> {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(MacWrapper.class.getName());

    public static class WrappedMac implements Mac {
        private final byte[] formatVersion;
        private final PrimitiveSet<Mac> primitives;

        public byte[] computeMac(byte[] bArr) throws GeneralSecurityException {
            return this.primitives.getPrimary().getOutputPrefixType().equals(OutputPrefixType.LEGACY) ? Bytes.concat(this.primitives.getPrimary().getIdentifier(), this.primitives.getPrimary().getPrimitive().computeMac(Bytes.concat(bArr, this.formatVersion))) : Bytes.concat(this.primitives.getPrimary().getIdentifier(), this.primitives.getPrimary().getPrimitive().computeMac(bArr));
        }

        public void verifyMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] copyOf = Arrays.copyOf(bArr, 5);
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (PrimitiveSet.Entry next : this.primitives.getPrimitive(copyOf)) {
                    try {
                        if (next.getOutputPrefixType().equals(OutputPrefixType.LEGACY)) {
                            ((Mac) next.getPrimitive()).verifyMac(copyOfRange, Bytes.concat(bArr2, this.formatVersion));
                            return;
                        } else {
                            ((Mac) next.getPrimitive()).verifyMac(copyOfRange, bArr2);
                            return;
                        }
                    } catch (GeneralSecurityException e) {
                        Logger access$000 = MacWrapper.logger;
                        access$000.info("tag prefix matches a key, but cannot verify: " + e);
                    }
                }
                for (PrimitiveSet.Entry primitive : this.primitives.getRawPrimitives()) {
                    try {
                        ((Mac) primitive.getPrimitive()).verifyMac(bArr, bArr2);
                        return;
                    } catch (GeneralSecurityException unused) {
                    }
                }
                throw new GeneralSecurityException("invalid MAC");
            }
            throw new GeneralSecurityException("tag too short");
        }

        private WrappedMac(PrimitiveSet<Mac> primitiveSet) {
            this.formatVersion = new byte[]{0};
            this.primitives = primitiveSet;
        }
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new MacWrapper());
    }

    public Class<Mac> getInputPrimitiveClass() {
        return Mac.class;
    }

    public Class<Mac> getPrimitiveClass() {
        return Mac.class;
    }

    public Mac wrap(PrimitiveSet<Mac> primitiveSet) throws GeneralSecurityException {
        return new WrappedMac(primitiveSet);
    }
}
