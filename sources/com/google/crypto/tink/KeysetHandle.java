package com.google.crypto.tink;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.crypto.tink.tinkkey.KeyHandle;
import java.io.IOException;
import java.security.GeneralSecurityException;

public final class KeysetHandle {
    private final Keyset keyset;

    private KeysetHandle(Keyset keyset2) {
        this.keyset = keyset2;
    }

    public static void assertEnoughEncryptedKeyMaterial(EncryptedKeyset encryptedKeyset) throws GeneralSecurityException {
        if (encryptedKeyset == null || encryptedKeyset.getEncryptedKeyset().size() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public static void assertEnoughKeyMaterial(Keyset keyset2) throws GeneralSecurityException {
        if (keyset2 == null || keyset2.getKeyCount() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void assertNoSecretKeyMaterial(com.google.crypto.tink.proto.Keyset r3) throws java.security.GeneralSecurityException {
        /*
            java.util.List r3 = r3.getKeyList()
            java.util.Iterator r3 = r3.iterator()
        L_0x0008:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x005d
            java.lang.Object r0 = r3.next()
            com.google.crypto.tink.proto.Keyset$Key r0 = (com.google.crypto.tink.proto.Keyset.Key) r0
            com.google.crypto.tink.proto.KeyData r1 = r0.getKeyData()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r1 = r1.getKeyMaterialType()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r2 = com.google.crypto.tink.proto.KeyData.KeyMaterialType.UNKNOWN_KEYMATERIAL
            if (r1 == r2) goto L_0x0039
            com.google.crypto.tink.proto.KeyData r1 = r0.getKeyData()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r1 = r1.getKeyMaterialType()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r2 = com.google.crypto.tink.proto.KeyData.KeyMaterialType.SYMMETRIC
            if (r1 == r2) goto L_0x0039
            com.google.crypto.tink.proto.KeyData r1 = r0.getKeyData()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r1 = r1.getKeyMaterialType()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r2 = com.google.crypto.tink.proto.KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE
            if (r1 == r2) goto L_0x0039
            goto L_0x0008
        L_0x0039:
            java.security.GeneralSecurityException r3 = new java.security.GeneralSecurityException
            com.google.crypto.tink.proto.KeyData r1 = r0.getKeyData()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r1 = r1.getKeyMaterialType()
            java.lang.String r1 = r1.name()
            com.google.crypto.tink.proto.KeyData r0 = r0.getKeyData()
            java.lang.String r0 = r0.getTypeUrl()
            java.lang.Object[] r0 = new java.lang.Object[]{r1, r0}
            java.lang.String r1 = "keyset contains key material of type %s for type url %s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r3.<init>(r0)
            throw r3
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.KeysetHandle.assertNoSecretKeyMaterial(com.google.crypto.tink.proto.Keyset):void");
    }

    public static final KeysetHandle createFromKey(KeyHandle keyHandle, KeyAccess keyAccess) throws GeneralSecurityException {
        KeysetManager add = KeysetManager.withEmptyKeyset().add(keyHandle, keyAccess);
        add.setPrimary(add.getKeysetHandle().getKeysetInfo().getKeyInfo(0).getKeyId());
        return add.getKeysetHandle();
    }

    private static KeyData createPublicKeyData(KeyData keyData) throws GeneralSecurityException {
        if (keyData.getKeyMaterialType() == KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) {
            KeyData publicKeyData = Registry.getPublicKeyData(keyData.getTypeUrl(), keyData.getValue());
            validate(publicKeyData);
            return publicKeyData;
        }
        throw new GeneralSecurityException("The keyset contains a non-private key");
    }

    private static Keyset decrypt(EncryptedKeyset encryptedKeyset, Aead aead) throws GeneralSecurityException {
        try {
            Keyset parseFrom = Keyset.parseFrom(aead.decrypt(encryptedKeyset.getEncryptedKeyset().toByteArray(), new byte[0]), ExtensionRegistryLite.getEmptyRegistry());
            assertEnoughKeyMaterial(parseFrom);
            return parseFrom;
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private static EncryptedKeyset encrypt(Keyset keyset2, Aead aead) throws GeneralSecurityException {
        byte[] encrypt = aead.encrypt(keyset2.toByteArray(), new byte[0]);
        try {
            if (Keyset.parseFrom(aead.decrypt(encrypt, new byte[0]), ExtensionRegistryLite.getEmptyRegistry()).equals(keyset2)) {
                return (EncryptedKeyset) EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(encrypt)).setKeysetInfo(Util.getKeysetInfo(keyset2)).build();
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    public static final KeysetHandle fromKeyset(Keyset keyset2) throws GeneralSecurityException {
        assertEnoughKeyMaterial(keyset2);
        return new KeysetHandle(keyset2);
    }

    @Deprecated
    public static final KeysetHandle generateNew(KeyTemplate keyTemplate) throws GeneralSecurityException {
        return KeysetManager.withEmptyKeyset().rotate(keyTemplate).getKeysetHandle();
    }

    private <B, P> P getPrimitiveWithKnownInputPrimitive(Class<P> cls, Class<B> cls2) throws GeneralSecurityException {
        Util.validateKeyset(this.keyset);
        PrimitiveSet<P> newPrimitiveSet = PrimitiveSet.newPrimitiveSet(cls2);
        for (Keyset.Key next : this.keyset.getKeyList()) {
            if (next.getStatus() == KeyStatusType.ENABLED) {
                PrimitiveSet.Entry<P> addPrimitive = newPrimitiveSet.addPrimitive(Registry.getPrimitive(next.getKeyData(), cls2), next);
                if (next.getKeyId() == this.keyset.getPrimaryKeyId()) {
                    newPrimitiveSet.setPrimary(addPrimitive);
                }
            }
        }
        return Registry.wrap(newPrimitiveSet, cls);
    }

    public static final KeysetHandle read(KeysetReader keysetReader, Aead aead) throws GeneralSecurityException, IOException {
        EncryptedKeyset readEncrypted = keysetReader.readEncrypted();
        assertEnoughEncryptedKeyMaterial(readEncrypted);
        return new KeysetHandle(decrypt(readEncrypted, aead));
    }

    public static final KeysetHandle readNoSecret(KeysetReader keysetReader) throws GeneralSecurityException, IOException {
        try {
            Keyset read = keysetReader.read();
            assertNoSecretKeyMaterial(read);
            return fromKeyset(read);
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    private static void validate(KeyData keyData) throws GeneralSecurityException {
        Registry.getPrimitive(keyData);
    }

    public Keyset getKeyset() {
        return this.keyset;
    }

    public KeysetInfo getKeysetInfo() {
        return Util.getKeysetInfo(this.keyset);
    }

    public <P> P getPrimitive(Class<P> cls) throws GeneralSecurityException {
        Class<?> inputPrimitive = Registry.getInputPrimitive(cls);
        if (inputPrimitive != null) {
            return getPrimitiveWithKnownInputPrimitive(cls, inputPrimitive);
        }
        throw new GeneralSecurityException("No wrapper found for " + cls.getName());
    }

    public KeysetHandle getPublicKeysetHandle() throws GeneralSecurityException {
        if (this.keyset != null) {
            Keyset.Builder newBuilder = Keyset.newBuilder();
            for (Keyset.Key next : this.keyset.getKeyList()) {
                newBuilder.addKey((Keyset.Key) ((Keyset.Key.Builder) Keyset.Key.newBuilder().mergeFrom(next)).setKeyData(createPublicKeyData(next.getKeyData())).build());
            }
            newBuilder.setPrimaryKeyId(this.keyset.getPrimaryKeyId());
            return new KeysetHandle((Keyset) newBuilder.build());
        }
        throw new GeneralSecurityException("cleartext keyset is not available");
    }

    public KeyHandle primaryKey() throws GeneralSecurityException {
        int primaryKeyId = this.keyset.getPrimaryKeyId();
        for (Keyset.Key next : this.keyset.getKeyList()) {
            if (next.getKeyId() == primaryKeyId) {
                return KeyHandle.createFromKey(next.getKeyData(), KeyTemplate.fromProto(next.getOutputPrefixType()));
            }
        }
        throw new GeneralSecurityException("No primary key found in keyset.");
    }

    public String toString() {
        return getKeysetInfo().toString();
    }

    public void write(KeysetWriter keysetWriter, Aead aead) throws GeneralSecurityException, IOException {
        keysetWriter.write(encrypt(this.keyset, aead));
    }

    public void writeNoSecret(KeysetWriter keysetWriter) throws GeneralSecurityException, IOException {
        assertNoSecretKeyMaterial(this.keyset);
        keysetWriter.write(this.keyset);
    }

    public static final KeysetHandle generateNew(KeyTemplate keyTemplate) throws GeneralSecurityException {
        return KeysetManager.withEmptyKeyset().rotate(keyTemplate.getProto()).getKeysetHandle();
    }

    public static final KeysetHandle readNoSecret(byte[] bArr) throws GeneralSecurityException {
        try {
            Keyset parseFrom = Keyset.parseFrom(bArr, ExtensionRegistryLite.getEmptyRegistry());
            assertNoSecretKeyMaterial(parseFrom);
            return fromKeyset(parseFrom);
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
