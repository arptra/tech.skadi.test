package org.eclipse.jetty.util;

import com.meizu.common.widget.CircularProgressButton;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class TypeUtil {
    public static int CR = 13;
    public static int LF = 10;
    private static final Logger LOG = Log.getLogger((Class<?>) TypeUtil.class);
    private static final HashMap<Class<?>, String> class2Name;
    private static final HashMap<Class<?>, Method> class2Value;
    private static final HashMap<String, Class<?>> name2Class;

    static {
        HashMap<String, Class<?>> hashMap = new HashMap<>();
        name2Class = hashMap;
        Class cls = Boolean.TYPE;
        hashMap.put("boolean", cls);
        Class cls2 = Byte.TYPE;
        hashMap.put("byte", cls2);
        Class cls3 = Character.TYPE;
        hashMap.put("char", cls3);
        Class cls4 = Double.TYPE;
        hashMap.put("double", cls4);
        Class cls5 = Float.TYPE;
        hashMap.put("float", cls5);
        Class cls6 = Integer.TYPE;
        hashMap.put("int", cls6);
        Class cls7 = Long.TYPE;
        hashMap.put("long", cls7);
        String str = "valueOf";
        Class cls8 = Short.TYPE;
        hashMap.put("short", cls8);
        Class cls9 = Void.TYPE;
        hashMap.put("void", cls9);
        hashMap.put("java.lang.Boolean.TYPE", cls);
        hashMap.put("java.lang.Byte.TYPE", cls2);
        hashMap.put("java.lang.Character.TYPE", cls3);
        hashMap.put("java.lang.Double.TYPE", cls4);
        hashMap.put("java.lang.Float.TYPE", cls5);
        hashMap.put("java.lang.Integer.TYPE", cls6);
        hashMap.put("java.lang.Long.TYPE", cls7);
        hashMap.put("java.lang.Short.TYPE", cls8);
        hashMap.put("java.lang.Void.TYPE", cls9);
        Class cls10 = cls8;
        Class<Boolean> cls11 = Boolean.class;
        hashMap.put("java.lang.Boolean", cls11);
        Class cls12 = cls7;
        Class<Byte> cls13 = Byte.class;
        hashMap.put("java.lang.Byte", cls13);
        Class cls14 = cls6;
        Class<Character> cls15 = Character.class;
        hashMap.put("java.lang.Character", cls15);
        Class cls16 = cls5;
        Class<Double> cls17 = Double.class;
        hashMap.put("java.lang.Double", cls17);
        Class<Float> cls18 = Float.class;
        hashMap.put("java.lang.Float", cls18);
        Class cls19 = cls4;
        Class<Integer> cls20 = Integer.class;
        hashMap.put("java.lang.Integer", cls20);
        Class<Long> cls21 = Long.class;
        hashMap.put("java.lang.Long", cls21);
        Class cls22 = cls3;
        Class<Short> cls23 = Short.class;
        hashMap.put("java.lang.Short", cls23);
        hashMap.put("Boolean", cls11);
        hashMap.put("Byte", cls13);
        hashMap.put("Character", cls15);
        hashMap.put("Double", cls17);
        hashMap.put("Float", cls18);
        hashMap.put("Integer", cls20);
        hashMap.put("Long", cls21);
        hashMap.put("Short", cls23);
        hashMap.put((Object) null, cls9);
        Class<Short> cls24 = cls23;
        Class<String> cls25 = String.class;
        hashMap.put("string", cls25);
        hashMap.put("String", cls25);
        hashMap.put("java.lang.String", cls25);
        HashMap<Class<?>, String> hashMap2 = new HashMap<>();
        class2Name = hashMap2;
        hashMap2.put(cls, "boolean");
        hashMap2.put(cls2, "byte");
        hashMap2.put(cls22, "char");
        Class cls26 = cls19;
        hashMap2.put(cls26, "double");
        hashMap2.put(cls16, "float");
        hashMap2.put(cls14, "int");
        hashMap2.put(cls12, "long");
        Class cls27 = cls10;
        hashMap2.put(cls27, "short");
        Object obj = "void";
        hashMap2.put(cls9, obj);
        hashMap2.put(cls11, "java.lang.Boolean");
        hashMap2.put(cls13, "java.lang.Byte");
        hashMap2.put(cls15, "java.lang.Character");
        hashMap2.put(cls17, "java.lang.Double");
        hashMap2.put(cls18, "java.lang.Float");
        hashMap2.put(cls20, "java.lang.Integer");
        hashMap2.put(cls21, "java.lang.Long");
        Class<Short> cls28 = cls24;
        hashMap2.put(cls28, "java.lang.Short");
        hashMap2.put((Object) null, obj);
        hashMap2.put(cls25, "java.lang.String");
        HashMap<Class<?>, Method> hashMap3 = new HashMap<>();
        class2Value = hashMap3;
        try {
            Class[] clsArr = {cls25};
            String str2 = str;
            hashMap3.put(cls, cls11.getMethod(str2, clsArr));
            hashMap3.put(cls2, cls13.getMethod(str2, clsArr));
            hashMap3.put(cls26, cls17.getMethod(str2, clsArr));
            hashMap3.put(cls16, cls18.getMethod(str2, clsArr));
            hashMap3.put(cls14, cls20.getMethod(str2, clsArr));
            hashMap3.put(cls12, cls21.getMethod(str2, clsArr));
            hashMap3.put(cls27, cls28.getMethod(str2, clsArr));
            hashMap3.put(cls11, cls11.getMethod(str2, clsArr));
            hashMap3.put(cls13, cls13.getMethod(str2, clsArr));
            hashMap3.put(cls17, cls17.getMethod(str2, clsArr));
            hashMap3.put(cls18, cls18.getMethod(str2, clsArr));
            hashMap3.put(cls20, cls20.getMethod(str2, clsArr));
            hashMap3.put(cls21, cls21.getMethod(str2, clsArr));
            hashMap3.put(cls28, cls28.getMethod(str2, clsArr));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static <T> List<T> asList(T[] tArr) {
        return tArr == null ? Collections.emptyList() : Arrays.asList(tArr);
    }

    public static Object call(Class<?> cls, String str, Object obj, Object[] objArr) throws InvocationTargetException, NoSuchMethodException {
        Method[] methods = cls.getMethods();
        int i = 0;
        while (methods != null && i < methods.length) {
            if (methods[i].getName().equals(str) && methods[i].getParameterTypes().length == objArr.length) {
                if (Modifier.isStatic(methods[i].getModifiers()) == (obj == null) && (obj != null || methods[i].getDeclaringClass() == cls)) {
                    try {
                        return methods[i].invoke(obj, objArr);
                    } catch (IllegalAccessException e) {
                        LOG.ignore(e);
                    } catch (IllegalArgumentException e2) {
                        LOG.ignore(e2);
                    }
                }
            }
            i++;
        }
        throw new NoSuchMethodException(str);
    }

    public static byte convertHexDigit(byte b) {
        byte b2 = (byte) (((b & 31) + ((b >> 6) * 25)) - 16);
        if (b2 >= 0 && b2 <= 15) {
            return b2;
        }
        throw new IllegalArgumentException("!hex " + b);
    }

    public static void dump(Class<?> cls) {
        PrintStream printStream = System.err;
        printStream.println("Dump: " + cls);
        dump(cls.getClassLoader());
    }

    public static byte[] fromHexString(String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (Integer.parseInt(str.substring(i2, i2 + 2), 16) & 255);
            }
            return bArr;
        }
        throw new IllegalArgumentException(str);
    }

    public static Class<?> fromName(String str) {
        return name2Class.get(str);
    }

    public static URL jarFor(String str) {
        try {
            String url = Loader.getResource((Class<?>) null, str.replace('.', '/') + ".class", false).toString();
            if (url.startsWith("jar:file:")) {
                return new URL(url.substring(4, url.indexOf("!/")));
            }
        } catch (Exception e) {
            LOG.ignore(e);
        }
        return null;
    }

    public static byte[] parseBytes(String str, int i) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i2 = 0; i2 < str.length(); i2 += 2) {
            bArr[i2 / 2] = (byte) parseInt(str, i2, 2, i);
        }
        return bArr;
    }

    public static int parseInt(String str, int i, int i2, int i3) throws NumberFormatException {
        if (i2 < 0) {
            i2 = str.length() - i;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int convertHexDigit = convertHexDigit((int) str.charAt(i + i5));
            if (convertHexDigit < 0 || convertHexDigit >= i3) {
                throw new NumberFormatException(str.substring(i, i2 + i));
            }
            i4 = (i4 * i3) + convertHexDigit;
        }
        return i4;
    }

    public static byte[] readLine(InputStream inputStream) throws IOException {
        int read;
        byte[] bArr = new byte[256];
        int i = 0;
        int i2 = 0;
        while (true) {
            read = inputStream.read();
            if (read < 0) {
                break;
            }
            i++;
            if (i != 1 || read != LF) {
                if (read == CR || read == LF) {
                    break;
                }
                if (i2 >= bArr.length) {
                    byte[] bArr2 = new byte[(bArr.length + 256)];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    bArr = bArr2;
                }
                bArr[i2] = (byte) read;
                i2++;
            }
        }
        if (read == -1 && i2 == 0) {
            return null;
        }
        if (read == CR && inputStream.available() >= 1 && inputStream.markSupported()) {
            inputStream.mark(1);
            if (inputStream.read() != LF) {
                inputStream.reset();
            }
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr, 0, bArr3, 0, i2);
        return bArr3;
    }

    public static void toHex(byte b, Appendable appendable) {
        int i = ((b & 240) >> 4) & 15;
        byte b2 = 48;
        try {
            appendable.append((char) ((i > 9 ? 55 : 48) + i));
            byte b3 = b & 15;
            if (b3 > 9) {
                b2 = 55;
            }
            appendable.append((char) (b2 + b3));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toHexString(byte b) {
        return toHexString(new byte[]{b}, 0, 1);
    }

    public static String toName(Class<?> cls) {
        return class2Name.get(cls);
    }

    public static String toString(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            byte b2 = b & 255;
            int i2 = (b2 / i) % i;
            int i3 = i2 + 48;
            if (i3 > 57) {
                i3 = i2 + 87;
            }
            sb.append((char) i3);
            int i4 = b2 % i;
            int i5 = i4 + 48;
            if (i5 > 57) {
                i5 = i4 + 87;
            }
            sb.append((char) i5);
        }
        return sb.toString();
    }

    public static Object valueOf(Class<?> cls, String str) {
        Class<String> cls2 = String.class;
        try {
            if (cls.equals(cls2)) {
                return str;
            }
            Method method = class2Value.get(cls);
            if (method != null) {
                return method.invoke((Object) null, new Object[]{str});
            }
            if (!cls.equals(Character.TYPE)) {
                if (!cls.equals(Character.class)) {
                    return cls.getConstructor(new Class[]{cls2}).newInstance(new Object[]{str});
                }
            }
            return new Character(str.charAt(0));
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e) {
            if (e.getTargetException() instanceof Error) {
                throw ((Error) e.getTargetException());
            }
            return null;
        }
    }

    public static int convertHexDigit(int i) {
        int i2 = ((i & 31) + ((i >> 6) * 25)) - 16;
        if (i2 >= 0 && i2 <= 15) {
            return i2;
        }
        throw new NumberFormatException("!hex " + i);
    }

    public static String toHexString(byte[] bArr) {
        return toHexString(bArr, 0, bArr.length);
    }

    public static void dump(ClassLoader classLoader) {
        System.err.println("Dump Loaders:");
        while (classLoader != null) {
            PrintStream printStream = System.err;
            printStream.println("  loader " + classLoader);
            classLoader = classLoader.getParent();
        }
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = i; i3 < i + i2; i3++) {
            byte b = bArr[i3] & 255;
            int i4 = (b / 16) % 16;
            int i5 = i4 + 48;
            if (i5 > 57) {
                i5 = i4 + 55;
            }
            sb.append((char) i5);
            int i6 = b % 16;
            int i7 = i6 + 48;
            if (i7 > 57) {
                i7 = i6 + 87;
            }
            sb.append((char) i7);
        }
        return sb.toString();
    }

    public static void toHex(int i, Appendable appendable) throws IOException {
        int i2 = ((-268435456 & i) >> 28) & 15;
        int i3 = 48;
        appendable.append((char) ((i2 > 9 ? 55 : 48) + i2));
        int i4 = ((251658240 & i) >> 24) & 15;
        appendable.append((char) ((i4 > 9 ? 55 : 48) + i4));
        int i5 = ((15728640 & i) >> 20) & 15;
        appendable.append((char) ((i5 > 9 ? 55 : 48) + i5));
        int i6 = ((983040 & i) >> 16) & 15;
        appendable.append((char) ((i6 > 9 ? 55 : 48) + i6));
        int i7 = ((61440 & i) >> 12) & 15;
        appendable.append((char) ((i7 > 9 ? 55 : 48) + i7));
        int i8 = ((i & 3840) >> 8) & 15;
        appendable.append((char) ((i8 > 9 ? 55 : 48) + i8));
        int i9 = ((i & CircularProgressButton.MorphingAnimation.DURATION_NORMAL) >> 4) & 15;
        appendable.append((char) ((i9 > 9 ? 55 : 48) + i9));
        int i10 = i & 15;
        if (i10 > 9) {
            i3 = 55;
        }
        appendable.append((char) (i3 + i10));
        Integer.toString(0, 36);
    }

    public static int parseInt(byte[] bArr, int i, int i2, int i3) throws NumberFormatException {
        if (i2 < 0) {
            i2 = bArr.length - i;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            char c = (char) (bArr[i + i5] & 255);
            int i6 = c - '0';
            if ((i6 < 0 || i6 >= i3 || i6 >= 10) && (c - '7' < 10 || i6 >= i3)) {
                i6 = c - 'W';
            }
            if (i6 < 0 || i6 >= i3) {
                throw new NumberFormatException(new String(bArr, i, i2));
            }
            i4 = (i4 * i3) + i6;
        }
        return i4;
    }

    public static Object valueOf(String str, String str2) {
        return valueOf(fromName(str), str2);
    }

    public static void toHex(long j, Appendable appendable) throws IOException {
        toHex((int) (j >> 32), appendable);
        toHex((int) j, appendable);
    }
}
