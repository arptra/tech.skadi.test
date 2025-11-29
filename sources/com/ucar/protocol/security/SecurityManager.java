package com.ucar.protocol.security;

import com.google.common.primitives.Bytes;
import com.ucar.protocol.MemUtil;
import com.ucar.protocol.ProtocolConfig;
import com.ucar.protocol.log.ProtocolLogger;
import com.upuphone.starrynet.strategy.encrypt.utils.EncryptionUtil;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class SecurityManager {
    public static final Map e = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    public String f9652a;
    public SecureRandom b;
    public Cipher c;
    public Cipher d;

    public SecurityManager(String str) {
        try {
            this.f9652a = str;
            this.c = Cipher.getInstance(EncryptionUtil.KEY_SYMMETRIC_V3);
            this.d = Cipher.getInstance(EncryptionUtil.KEY_SYMMETRIC_V3);
            this.b = SecureRandom.getInstance("SHA1PRNG");
        } catch (Exception e2) {
            ProtocolConfig.b().e("SecurityManager", "Init SecurityManager error.", e2);
        }
    }

    public static void g(byte[] bArr, String str) {
        e.put(str, new SecretKeySpec(bArr, "AES"));
    }

    public static byte[] h(int i) {
        return ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(i).array();
    }

    public static int i(byte[] bArr, int i, int i2) {
        return ByteBuffer.wrap(bArr, i, i2).order(ByteOrder.BIG_ENDIAN).getInt();
    }

    public final void a(SecretKey secretKey) {
        if (secretKey == null) {
            throw new SecurityException("no session key: " + this.f9652a);
        } else if (this.d == null) {
            throw new SecurityException("encryption cipher is not created");
        } else if (this.b == null) {
            throw new SecurityException("random generator is not created");
        }
    }

    public ByteBuffer b(ByteBuffer byteBuffer) {
        return c(byteBuffer, true);
    }

    public ByteBuffer c(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer == null || byteBuffer.remaining() == 0) {
            return MemUtil.b;
        }
        SecretKey secretKey = (SecretKey) e.get(this.f9652a);
        synchronized (this) {
            try {
                a(secretKey);
                int i = byteBuffer.getInt();
                byte[] e2 = MemUtil.e(i);
                byteBuffer.get(e2, 0, i);
                this.d.init(2, secretKey, new GCMParameterSpec(128, e2, 0, i));
                int i2 = byteBuffer.getInt();
                byte[] e3 = MemUtil.e(i2);
                byteBuffer.get(e3, 0, i2);
                int outputSize = this.d.getOutputSize(i2);
                ByteBuffer allocate = z ? ByteBuffer.allocate(outputSize) : MemUtil.f(outputSize);
                if (allocate == null) {
                    ProtocolLogger b2 = ProtocolConfig.b();
                    b2.e("SecurityManager", "decrypt: allocate buffer error:" + outputSize);
                    ByteBuffer byteBuffer2 = MemUtil.b;
                    return byteBuffer2;
                }
                this.d.doFinal(ByteBuffer.wrap(e3, 0, i2), allocate);
                allocate.flip();
                return allocate;
            } catch (Exception e4) {
                ProtocolConfig.b().e("SecurityManager", "decrypt error.", e4);
                return MemUtil.b;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public byte[] d(byte[] bArr) {
        byte[] byteArray;
        SecretKey secretKey = (SecretKey) e.get(this.f9652a);
        synchronized (this) {
            try {
                a(secretKey);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i = 0;
                while (i < bArr.length) {
                    int i2 = i(bArr, i, 4);
                    int i3 = i + 4;
                    this.d.init(2, secretKey, new GCMParameterSpec(128, bArr, i3, i2));
                    int i4 = i3 + i2;
                    int i5 = i(bArr, i4, 4);
                    byteArrayOutputStream.write(this.d.doFinal(bArr, i4 + 4, i5));
                    i += i2 + 8 + i5;
                }
                byteArray = byteArrayOutputStream.toByteArray();
            } catch (Exception e2) {
                ProtocolConfig.b().e("SecurityManager", "decrypt error.", e2);
                return new byte[0];
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return byteArray;
    }

    public ByteBuffer e(ByteBuffer byteBuffer) {
        SecretKey secretKey = (SecretKey) e.get(this.f9652a);
        if (byteBuffer == null || byteBuffer.remaining() == 0) {
            return MemUtil.b;
        }
        synchronized (this) {
            try {
                a(secretKey);
                this.c.init(1, secretKey, this.b);
                byte[] iv = this.c.getIV();
                int outputSize = this.c.getOutputSize(byteBuffer.remaining());
                if (iv == null) {
                    throw new SecurityException("invalid IV for encryption");
                } else if (outputSize > 0) {
                    int length = iv.length + 8 + outputSize;
                    ByteBuffer f = MemUtil.f(length);
                    if (f == null) {
                        ProtocolLogger b2 = ProtocolConfig.b();
                        b2.e("SecurityManager", "encrypt: alloc buffer error:" + length);
                        ByteBuffer byteBuffer2 = MemUtil.b;
                        return byteBuffer2;
                    }
                    f.putInt(iv.length);
                    f.put(iv);
                    f.putInt(outputSize);
                    this.c.doFinal(byteBuffer, f);
                    f.flip();
                    return f;
                } else {
                    throw new SecurityException("encryption returns nothing");
                }
            } catch (Exception e2) {
                ProtocolConfig.b().e("SecurityManager", "encrypt error.", e2);
                return MemUtil.b;
            }
        }
    }

    public byte[] f(byte[] bArr) {
        byte[] concat;
        SecretKey secretKey = (SecretKey) e.get(this.f9652a);
        synchronized (this) {
            try {
                a(secretKey);
                this.c.init(1, secretKey, this.b);
                byte[] iv = this.c.getIV();
                byte[] doFinal = this.c.doFinal(bArr);
                if (iv == null) {
                    throw new SecurityException("invalid IV for encryption");
                } else if (doFinal != null) {
                    concat = Bytes.concat(h(iv.length), iv, h(doFinal.length), doFinal);
                } else {
                    throw new SecurityException("encryption returns nothing");
                }
            } catch (Exception e2) {
                ProtocolConfig.b().e("SecurityManager", "encrypt error.", e2);
                return new byte[0];
            }
        }
        return concat;
    }

    public SecurityManager() {
        this("session_key");
    }
}
