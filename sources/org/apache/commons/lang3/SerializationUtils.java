package org.apache.commons.lang3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SerializationUtils {

    public static class ClassLoaderAwareObjectInputStream extends ObjectInputStream {
        private static final Map<String, Class<?>> primitiveTypes;
        private final ClassLoader classLoader;

        static {
            HashMap hashMap = new HashMap();
            primitiveTypes = hashMap;
            hashMap.put("byte", Byte.TYPE);
            hashMap.put("short", Short.TYPE);
            hashMap.put("int", Integer.TYPE);
            hashMap.put("long", Long.TYPE);
            hashMap.put("float", Float.TYPE);
            hashMap.put("double", Double.TYPE);
            hashMap.put("boolean", Boolean.TYPE);
            hashMap.put("char", Character.TYPE);
            hashMap.put("void", Void.TYPE);
        }

        public ClassLoaderAwareObjectInputStream(InputStream inputStream, ClassLoader classLoader2) throws IOException {
            super(inputStream);
            this.classLoader = classLoader2;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
            return java.lang.Class.forName(r2, false, java.lang.Thread.currentThread().getContextClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
            r2 = primitiveTypes.get(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
            if (r2 != null) goto L_0x0024;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Class<?> resolveClass(java.io.ObjectStreamClass r2) throws java.io.IOException, java.lang.ClassNotFoundException {
            /*
                r1 = this;
                java.lang.String r2 = r2.getName()
                r0 = 0
                java.lang.ClassLoader r1 = r1.classLoader     // Catch:{ ClassNotFoundException -> 0x000c }
                java.lang.Class r1 = java.lang.Class.forName(r2, r0, r1)     // Catch:{ ClassNotFoundException -> 0x000c }
                return r1
            L_0x000c:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ ClassNotFoundException -> 0x0019 }
                java.lang.ClassLoader r1 = r1.getContextClassLoader()     // Catch:{ ClassNotFoundException -> 0x0019 }
                java.lang.Class r1 = java.lang.Class.forName(r2, r0, r1)     // Catch:{ ClassNotFoundException -> 0x0019 }
                return r1
            L_0x0019:
                r1 = move-exception
                java.util.Map<java.lang.String, java.lang.Class<?>> r0 = primitiveTypes
                java.lang.Object r2 = r0.get(r2)
                java.lang.Class r2 = (java.lang.Class) r2
                if (r2 == 0) goto L_0x0025
                return r2
            L_0x0025:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.SerializationUtils.ClassLoaderAwareObjectInputStream.resolveClass(java.io.ObjectStreamClass):java.lang.Class");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends java.io.Serializable> T clone(T r2) {
        /*
            if (r2 != 0) goto L_0x0004
            r2 = 0
            return r2
        L_0x0004:
            byte[] r0 = serialize(r2)
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r0)
            org.apache.commons.lang3.SerializationUtils$ClassLoaderAwareObjectInputStream r0 = new org.apache.commons.lang3.SerializationUtils$ClassLoaderAwareObjectInputStream     // Catch:{ ClassNotFoundException -> 0x0026, IOException -> 0x0024 }
            java.lang.Class r2 = r2.getClass()     // Catch:{ ClassNotFoundException -> 0x0026, IOException -> 0x0024 }
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0026, IOException -> 0x0024 }
            r0.<init>(r1, r2)     // Catch:{ ClassNotFoundException -> 0x0026, IOException -> 0x0024 }
            java.lang.Object r2 = r0.readObject()     // Catch:{ all -> 0x0028 }
            java.io.Serializable r2 = (java.io.Serializable) r2     // Catch:{ all -> 0x0028 }
            r0.close()     // Catch:{ ClassNotFoundException -> 0x0026, IOException -> 0x0024 }
            return r2
        L_0x0024:
            r2 = move-exception
            goto L_0x0034
        L_0x0026:
            r2 = move-exception
            goto L_0x003c
        L_0x0028:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x002a }
        L_0x002a:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r0 = move-exception
            r2.addSuppressed(r0)     // Catch:{ ClassNotFoundException -> 0x0026, IOException -> 0x0024 }
        L_0x0033:
            throw r1     // Catch:{ ClassNotFoundException -> 0x0026, IOException -> 0x0024 }
        L_0x0034:
            org.apache.commons.lang3.SerializationException r0 = new org.apache.commons.lang3.SerializationException
            java.lang.String r1 = "IOException while reading or closing cloned object data"
            r0.<init>(r1, r2)
            throw r0
        L_0x003c:
            org.apache.commons.lang3.SerializationException r0 = new org.apache.commons.lang3.SerializationException
            java.lang.String r1 = "ClassNotFoundException while reading cloned object data"
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.SerializationUtils.clone(java.io.Serializable):java.io.Serializable");
    }

    public static <T> T deserialize(byte[] bArr) {
        Validate.notNull(bArr, "objectData", new Object[0]);
        return deserialize((InputStream) new ByteArrayInputStream(bArr));
    }

    public static <T extends Serializable> T roundtrip(T t) {
        return (Serializable) deserialize(serialize(t));
    }

    public static byte[] serialize(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        serialize(serializable, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T deserialize(java.io.InputStream r2) {
        /*
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "inputStream"
            org.apache.commons.lang3.Validate.notNull(r2, r1, r0)
            java.io.ObjectInputStream r0 = new java.io.ObjectInputStream     // Catch:{ IOException | ClassNotFoundException -> 0x0015 }
            r0.<init>(r2)     // Catch:{ IOException | ClassNotFoundException -> 0x0015 }
            java.lang.Object r2 = r0.readObject()     // Catch:{ all -> 0x0017 }
            r0.close()     // Catch:{ IOException | ClassNotFoundException -> 0x0015 }
            return r2
        L_0x0015:
            r2 = move-exception
            goto L_0x0023
        L_0x0017:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0019 }
        L_0x0019:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x001e }
            goto L_0x0022
        L_0x001e:
            r0 = move-exception
            r2.addSuppressed(r0)     // Catch:{ IOException | ClassNotFoundException -> 0x0015 }
        L_0x0022:
            throw r1     // Catch:{ IOException | ClassNotFoundException -> 0x0015 }
        L_0x0023:
            org.apache.commons.lang3.SerializationException r0 = new org.apache.commons.lang3.SerializationException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.SerializationUtils.deserialize(java.io.InputStream):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void serialize(java.io.Serializable r2, java.io.OutputStream r3) {
        /*
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "outputStream"
            org.apache.commons.lang3.Validate.notNull(r3, r1, r0)
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0014 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0014 }
            r0.writeObject(r2)     // Catch:{ all -> 0x0016 }
            r0.close()     // Catch:{ IOException -> 0x0014 }
            return
        L_0x0014:
            r2 = move-exception
            goto L_0x0022
        L_0x0016:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0018 }
        L_0x0018:
            r3 = move-exception
            r0.close()     // Catch:{ all -> 0x001d }
            goto L_0x0021
        L_0x001d:
            r0 = move-exception
            r2.addSuppressed(r0)     // Catch:{ IOException -> 0x0014 }
        L_0x0021:
            throw r3     // Catch:{ IOException -> 0x0014 }
        L_0x0022:
            org.apache.commons.lang3.SerializationException r3 = new org.apache.commons.lang3.SerializationException
            r3.<init>((java.lang.Throwable) r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.SerializationUtils.serialize(java.io.Serializable, java.io.OutputStream):void");
    }
}
