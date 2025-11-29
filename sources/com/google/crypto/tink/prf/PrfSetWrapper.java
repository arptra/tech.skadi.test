package com.google.crypto.tink.prf;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Immutable
public class PrfSetWrapper implements PrimitiveWrapper<Prf, PrfSet> {

    public static class WrappedPrfSet extends PrfSet {
        private final Map<Integer, Prf> keyIdToPrfMap;
        private final int primaryKeyId;

        public Map<Integer, Prf> getPrfs() throws GeneralSecurityException {
            return this.keyIdToPrfMap;
        }

        public int getPrimaryId() {
            return this.primaryKeyId;
        }

        private WrappedPrfSet(PrimitiveSet<Prf> primitiveSet) throws GeneralSecurityException {
            if (primitiveSet.getRawPrimitives().isEmpty()) {
                throw new GeneralSecurityException("No primitives provided.");
            } else if (primitiveSet.getPrimary() != null) {
                this.primaryKeyId = primitiveSet.getPrimary().getKeyId();
                List<PrimitiveSet.Entry<Prf>> rawPrimitives = primitiveSet.getRawPrimitives();
                HashMap hashMap = new HashMap();
                for (PrimitiveSet.Entry next : rawPrimitives) {
                    if (next.getOutputPrefixType().equals(OutputPrefixType.RAW)) {
                        hashMap.put(Integer.valueOf(next.getKeyId()), (Prf) next.getPrimitive());
                    } else {
                        throw new GeneralSecurityException("Key " + next.getKeyId() + " has non raw prefix type");
                    }
                }
                this.keyIdToPrfMap = Collections.unmodifiableMap(hashMap);
            } else {
                throw new GeneralSecurityException("Primary key not set.");
            }
        }
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new PrfSetWrapper());
    }

    public Class<Prf> getInputPrimitiveClass() {
        return Prf.class;
    }

    public Class<PrfSet> getPrimitiveClass() {
        return PrfSet.class;
    }

    public PrfSet wrap(PrimitiveSet<Prf> primitiveSet) throws GeneralSecurityException {
        return new WrappedPrfSet(primitiveSet);
    }
}
