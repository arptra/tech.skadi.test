package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.crypto.tink.tinkkey.KeyHandle;
import com.google.crypto.tink.tinkkey.ProtoKey;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.annotation.concurrent.GuardedBy;

public final class KeysetManager {
    @GuardedBy
    private final Keyset.Builder keysetBuilder;

    private KeysetManager(Keyset.Builder builder) {
        this.keysetBuilder = builder;
    }

    private synchronized Keyset.Key createKeysetKey(KeyData keyData, OutputPrefixType outputPrefixType) throws GeneralSecurityException {
        int newKeyId;
        newKeyId = newKeyId();
        if (outputPrefixType != OutputPrefixType.UNKNOWN_PREFIX) {
        } else {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return (Keyset.Key) Keyset.Key.newBuilder().setKeyData(keyData).setKeyId(newKeyId).setStatus(KeyStatusType.ENABLED).setOutputPrefixType(outputPrefixType).build();
    }

    private synchronized boolean keyIdExists(int i) {
        for (Keyset.Key keyId : this.keysetBuilder.getKeyList()) {
            if (keyId.getKeyId() == i) {
                return true;
            }
        }
        return false;
    }

    private synchronized Keyset.Key newKey(KeyTemplate keyTemplate) throws GeneralSecurityException {
        return createKeysetKey(Registry.newKeyData(keyTemplate), keyTemplate.getOutputPrefixType());
    }

    private synchronized int newKeyId() {
        int randPositiveInt;
        randPositiveInt = randPositiveInt();
        while (keyIdExists(randPositiveInt)) {
            randPositiveInt = randPositiveInt();
        }
        return randPositiveInt;
    }

    private static int randPositiveInt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        byte b = 0;
        while (b == 0) {
            secureRandom.nextBytes(bArr);
            b = ((bArr[0] & Byte.MAX_VALUE) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return b;
    }

    public static KeysetManager withEmptyKeyset() {
        return new KeysetManager(Keyset.newBuilder());
    }

    public static KeysetManager withKeysetHandle(KeysetHandle keysetHandle) {
        return new KeysetManager((Keyset.Builder) keysetHandle.getKeyset().toBuilder());
    }

    @Deprecated
    public synchronized KeysetManager add(KeyTemplate keyTemplate) throws GeneralSecurityException {
        addNewKey(keyTemplate, false);
        return this;
    }

    @Deprecated
    public synchronized int addNewKey(KeyTemplate keyTemplate, boolean z) throws GeneralSecurityException {
        Keyset.Key newKey;
        try {
            newKey = newKey(keyTemplate);
            this.keysetBuilder.addKey(newKey);
            if (z) {
                this.keysetBuilder.setPrimaryKeyId(newKey.getKeyId());
            }
        } catch (Throwable th) {
            throw th;
        }
        return newKey.getKeyId();
    }

    public synchronized KeysetManager delete(int i) throws GeneralSecurityException {
        if (i != this.keysetBuilder.getPrimaryKeyId()) {
            int i2 = 0;
            while (i2 < this.keysetBuilder.getKeyCount()) {
                if (this.keysetBuilder.getKey(i2).getKeyId() == i) {
                    this.keysetBuilder.removeKey(i2);
                } else {
                    i2++;
                }
            }
            throw new GeneralSecurityException("key not found: " + i);
        }
        throw new GeneralSecurityException("cannot delete the primary key");
        return this;
    }

    public synchronized KeysetManager destroy(int i) throws GeneralSecurityException {
        try {
            if (i != this.keysetBuilder.getPrimaryKeyId()) {
                int i2 = 0;
                while (i2 < this.keysetBuilder.getKeyCount()) {
                    Keyset.Key key = this.keysetBuilder.getKey(i2);
                    if (key.getKeyId() == i) {
                        if (!(key.getStatus() == KeyStatusType.ENABLED || key.getStatus() == KeyStatusType.DISABLED)) {
                            if (key.getStatus() != KeyStatusType.DESTROYED) {
                                throw new GeneralSecurityException("cannot destroy key with id " + i);
                            }
                        }
                        this.keysetBuilder.setKey(i2, (Keyset.Key) ((Keyset.Key.Builder) key.toBuilder()).setStatus(KeyStatusType.DESTROYED).clearKeyData().build());
                    } else {
                        i2++;
                    }
                }
                throw new GeneralSecurityException("key not found: " + i);
            }
            throw new GeneralSecurityException("cannot destroy the primary key");
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized KeysetManager disable(int i) throws GeneralSecurityException {
        try {
            if (i != this.keysetBuilder.getPrimaryKeyId()) {
                int i2 = 0;
                while (i2 < this.keysetBuilder.getKeyCount()) {
                    Keyset.Key key = this.keysetBuilder.getKey(i2);
                    if (key.getKeyId() == i) {
                        if (key.getStatus() != KeyStatusType.ENABLED) {
                            if (key.getStatus() != KeyStatusType.DISABLED) {
                                throw new GeneralSecurityException("cannot disable key with id " + i);
                            }
                        }
                        this.keysetBuilder.setKey(i2, (Keyset.Key) ((Keyset.Key.Builder) key.toBuilder()).setStatus(KeyStatusType.DISABLED).build());
                    } else {
                        i2++;
                    }
                }
                throw new GeneralSecurityException("key not found: " + i);
            }
            throw new GeneralSecurityException("cannot disable the primary key");
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized KeysetManager enable(int i) throws GeneralSecurityException {
        int i2 = 0;
        while (i2 < this.keysetBuilder.getKeyCount()) {
            try {
                Keyset.Key key = this.keysetBuilder.getKey(i2);
                if (key.getKeyId() == i) {
                    KeyStatusType status = key.getStatus();
                    KeyStatusType keyStatusType = KeyStatusType.ENABLED;
                    if (status != keyStatusType) {
                        if (key.getStatus() != KeyStatusType.DISABLED) {
                            throw new GeneralSecurityException("cannot enable key with id " + i);
                        }
                    }
                    this.keysetBuilder.setKey(i2, (Keyset.Key) ((Keyset.Key.Builder) key.toBuilder()).setStatus(keyStatusType).build());
                } else {
                    i2++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        throw new GeneralSecurityException("key not found: " + i);
        return this;
    }

    public synchronized KeysetHandle getKeysetHandle() throws GeneralSecurityException {
        return KeysetHandle.fromKeyset((Keyset) this.keysetBuilder.build());
    }

    @Deprecated
    public synchronized KeysetManager promote(int i) throws GeneralSecurityException {
        return setPrimary(i);
    }

    @Deprecated
    public synchronized KeysetManager rotate(KeyTemplate keyTemplate) throws GeneralSecurityException {
        addNewKey(keyTemplate, true);
        return this;
    }

    public synchronized KeysetManager setPrimary(int i) throws GeneralSecurityException {
        int i2 = 0;
        while (i2 < this.keysetBuilder.getKeyCount()) {
            Keyset.Key key = this.keysetBuilder.getKey(i2);
            if (key.getKeyId() != i) {
                i2++;
            } else if (key.getStatus().equals(KeyStatusType.ENABLED)) {
                this.keysetBuilder.setPrimaryKeyId(i);
            } else {
                throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i);
            }
        }
        throw new GeneralSecurityException("key not found: " + i);
        return this;
    }

    public synchronized KeysetManager add(KeyTemplate keyTemplate) throws GeneralSecurityException {
        addNewKey(keyTemplate.getProto(), false);
        return this;
    }

    public synchronized KeysetManager add(KeyHandle keyHandle, KeyAccess keyAccess) throws GeneralSecurityException {
        try {
            ProtoKey protoKey = (ProtoKey) keyHandle.getKey(keyAccess);
            this.keysetBuilder.addKey(createKeysetKey(protoKey.getProtoKey(), KeyTemplate.toProto(protoKey.getOutputPrefixType())));
        } catch (ClassCastException e) {
            throw new UnsupportedOperationException("KeyHandles which contain TinkKeys that are not ProtoKeys are not yet supported.", e);
        }
        return this;
    }
}
