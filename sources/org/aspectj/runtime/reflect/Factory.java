package org.aspectj.runtime.reflect;

import com.honey.account.constant.AccountConstantKt;
import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.AdviceSignature;
import org.aspectj.lang.reflect.CatchClauseSignature;
import org.aspectj.lang.reflect.ConstructorSignature;
import org.aspectj.lang.reflect.FieldSignature;
import org.aspectj.lang.reflect.InitializerSignature;
import org.aspectj.lang.reflect.LockSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.aspectj.lang.reflect.UnlockSignature;
import org.aspectj.runtime.reflect.JoinPointImpl;

public final class Factory {
    private static Object[] NO_ARGS = new Object[0];
    private static final String[] NO_STRINGS = new String[0];
    private static final Class[] NO_TYPES = new Class[0];
    static Hashtable<String, Class<?>> prims;
    int count = 0;
    String filename;
    Class<?> lexicalClass;
    ClassLoader lookupClassLoader;

    static {
        Hashtable<String, Class<?>> hashtable = new Hashtable<>();
        prims = hashtable;
        hashtable.put("void", Void.TYPE);
        prims.put("boolean", Boolean.TYPE);
        prims.put("byte", Byte.TYPE);
        prims.put("char", Character.TYPE);
        prims.put("short", Short.TYPE);
        prims.put("int", Integer.TYPE);
        prims.put("long", Long.TYPE);
        prims.put("float", Float.TYPE);
        prims.put("double", Double.TYPE);
    }

    public Factory(String str, Class cls) {
        this.filename = str;
        this.lexicalClass = cls;
        this.lookupClassLoader = cls.getClassLoader();
    }

    public static Class<?> makeClass(String str, ClassLoader classLoader) {
        if (str.equals("*")) {
            return null;
        }
        Class<?> cls = prims.get(str);
        if (cls != null) {
            return cls;
        }
        if (classLoader != null) {
            return Class.forName(str, false, classLoader);
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return ClassNotFoundException.class;
        }
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [org.aspectj.lang.Signature] */
    /* JADX WARNING: type inference failed for: r0v10, types: [org.aspectj.runtime.reflect.ConstructorSignatureImpl] */
    /* JADX WARNING: type inference failed for: r0v11, types: [org.aspectj.runtime.reflect.MethodSignatureImpl] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.aspectj.lang.JoinPoint.StaticPart makeEncSJP(java.lang.reflect.Member r9) {
        /*
            boolean r0 = r9 instanceof java.lang.reflect.Method
            if (r0 == 0) goto L_0x002e
            java.lang.reflect.Method r9 = (java.lang.reflect.Method) r9
            org.aspectj.runtime.reflect.MethodSignatureImpl r8 = new org.aspectj.runtime.reflect.MethodSignatureImpl
            int r1 = r9.getModifiers()
            java.lang.String r2 = r9.getName()
            java.lang.Class r3 = r9.getDeclaringClass()
            java.lang.Class[] r4 = r9.getParameterTypes()
            java.lang.Class[] r0 = r9.getParameterTypes()
            int r0 = r0.length
            java.lang.String[] r5 = new java.lang.String[r0]
            java.lang.Class[] r6 = r9.getExceptionTypes()
            java.lang.Class r7 = r9.getReturnType()
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            java.lang.String r9 = "method-execution"
            goto L_0x0053
        L_0x002e:
            boolean r0 = r9 instanceof java.lang.reflect.Constructor
            if (r0 == 0) goto L_0x005b
            java.lang.reflect.Constructor r9 = (java.lang.reflect.Constructor) r9
            org.aspectj.runtime.reflect.ConstructorSignatureImpl r8 = new org.aspectj.runtime.reflect.ConstructorSignatureImpl
            int r1 = r9.getModifiers()
            java.lang.Class r2 = r9.getDeclaringClass()
            java.lang.Class[] r3 = r9.getParameterTypes()
            java.lang.Class[] r0 = r9.getParameterTypes()
            int r0 = r0.length
            java.lang.String[] r4 = new java.lang.String[r0]
            java.lang.Class[] r5 = r9.getExceptionTypes()
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            java.lang.String r9 = "constructor-execution"
        L_0x0053:
            org.aspectj.runtime.reflect.JoinPointImpl$EnclosingStaticPartImpl r0 = new org.aspectj.runtime.reflect.JoinPointImpl$EnclosingStaticPartImpl
            r1 = -1
            r2 = 0
            r0.<init>(r1, r9, r8, r2)
            return r0
        L_0x005b:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "member must be either a method or constructor"
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.aspectj.runtime.reflect.Factory.makeEncSJP(java.lang.reflect.Member):org.aspectj.lang.JoinPoint$StaticPart");
    }

    public static JoinPoint makeJP(JoinPoint.StaticPart staticPart, Object obj, Object obj2) {
        return new JoinPointImpl(staticPart, obj, obj2, NO_ARGS);
    }

    public JoinPoint.EnclosingStaticPart makeAdviceESJP(String str, int i, String str2, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2, int i2) {
        AdviceSignatureImpl adviceSignatureImpl = new AdviceSignatureImpl(i, str2, cls, clsArr == null ? NO_TYPES : clsArr, strArr == null ? NO_STRINGS : strArr, clsArr2 == null ? NO_TYPES : clsArr2, cls2 == null ? Void.TYPE : cls2);
        int i3 = this.count;
        this.count = i3 + 1;
        String str3 = str;
        return new JoinPointImpl.EnclosingStaticPartImpl(i3, str, adviceSignatureImpl, makeSourceLoc(i2, -1));
    }

    public JoinPoint.StaticPart makeAdviceSJP(String str, int i, String str2, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2, int i2) {
        AdviceSignatureImpl adviceSignatureImpl = new AdviceSignatureImpl(i, str2, cls, clsArr == null ? NO_TYPES : clsArr, strArr == null ? NO_STRINGS : strArr, clsArr2 == null ? NO_TYPES : clsArr2, cls2 == null ? Void.TYPE : cls2);
        int i3 = this.count;
        this.count = i3 + 1;
        String str3 = str;
        return new JoinPointImpl.StaticPartImpl(i3, str, adviceSignatureImpl, makeSourceLoc(i2, -1));
    }

    public AdviceSignature makeAdviceSig(String str) {
        AdviceSignatureImpl adviceSignatureImpl = new AdviceSignatureImpl(str);
        adviceSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return adviceSignatureImpl;
    }

    public JoinPoint.EnclosingStaticPart makeCatchClauseESJP(String str, Class cls, Class cls2, String str2, int i) {
        if (str2 == null) {
            str2 = "";
        }
        CatchClauseSignatureImpl catchClauseSignatureImpl = new CatchClauseSignatureImpl(cls, cls2, str2);
        int i2 = this.count;
        this.count = i2 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i2, str, catchClauseSignatureImpl, makeSourceLoc(i, -1));
    }

    public JoinPoint.StaticPart makeCatchClauseSJP(String str, Class cls, Class cls2, String str2, int i) {
        if (str2 == null) {
            str2 = "";
        }
        CatchClauseSignatureImpl catchClauseSignatureImpl = new CatchClauseSignatureImpl(cls, cls2, str2);
        int i2 = this.count;
        this.count = i2 + 1;
        return new JoinPointImpl.StaticPartImpl(i2, str, catchClauseSignatureImpl, makeSourceLoc(i, -1));
    }

    public CatchClauseSignature makeCatchClauseSig(String str) {
        CatchClauseSignatureImpl catchClauseSignatureImpl = new CatchClauseSignatureImpl(str);
        catchClauseSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return catchClauseSignatureImpl;
    }

    public JoinPoint.EnclosingStaticPart makeConstructorESJP(String str, int i, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, int i2) {
        if (clsArr == null) {
            clsArr = NO_TYPES;
        }
        Class[] clsArr3 = clsArr;
        if (strArr == null) {
            strArr = NO_STRINGS;
        }
        String[] strArr2 = strArr;
        if (clsArr2 == null) {
            clsArr2 = NO_TYPES;
        }
        ConstructorSignatureImpl constructorSignatureImpl = new ConstructorSignatureImpl(i, cls, clsArr3, strArr2, clsArr2);
        int i3 = this.count;
        this.count = i3 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i3, str, constructorSignatureImpl, makeSourceLoc(i2, -1));
    }

    public JoinPoint.StaticPart makeConstructorSJP(String str, int i, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, int i2) {
        if (clsArr == null) {
            clsArr = NO_TYPES;
        }
        Class[] clsArr3 = clsArr;
        if (strArr == null) {
            strArr = NO_STRINGS;
        }
        String[] strArr2 = strArr;
        if (clsArr2 == null) {
            clsArr2 = NO_TYPES;
        }
        ConstructorSignatureImpl constructorSignatureImpl = new ConstructorSignatureImpl(i, cls, clsArr3, strArr2, clsArr2);
        int i3 = this.count;
        this.count = i3 + 1;
        return new JoinPointImpl.StaticPartImpl(i3, str, constructorSignatureImpl, makeSourceLoc(i2, -1));
    }

    public ConstructorSignature makeConstructorSig(String str) {
        ConstructorSignatureImpl constructorSignatureImpl = new ConstructorSignatureImpl(str);
        constructorSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return constructorSignatureImpl;
    }

    public JoinPoint.EnclosingStaticPart makeESJP(String str, Signature signature, SourceLocation sourceLocation) {
        int i = this.count;
        this.count = i + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i, str, signature, sourceLocation);
    }

    public JoinPoint.EnclosingStaticPart makeFieldESJP(String str, int i, String str2, Class cls, Class cls2, int i2) {
        FieldSignatureImpl fieldSignatureImpl = new FieldSignatureImpl(i, str2, cls, cls2);
        int i3 = this.count;
        this.count = i3 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i3, str, fieldSignatureImpl, makeSourceLoc(i2, -1));
    }

    public JoinPoint.StaticPart makeFieldSJP(String str, int i, String str2, Class cls, Class cls2, int i2) {
        FieldSignatureImpl fieldSignatureImpl = new FieldSignatureImpl(i, str2, cls, cls2);
        int i3 = this.count;
        this.count = i3 + 1;
        return new JoinPointImpl.StaticPartImpl(i3, str, fieldSignatureImpl, makeSourceLoc(i2, -1));
    }

    public FieldSignature makeFieldSig(String str) {
        FieldSignatureImpl fieldSignatureImpl = new FieldSignatureImpl(str);
        fieldSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return fieldSignatureImpl;
    }

    public JoinPoint.EnclosingStaticPart makeInitializerESJP(String str, int i, Class cls, int i2) {
        InitializerSignatureImpl initializerSignatureImpl = new InitializerSignatureImpl(i, cls);
        int i3 = this.count;
        this.count = i3 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i3, str, initializerSignatureImpl, makeSourceLoc(i2, -1));
    }

    public JoinPoint.StaticPart makeInitializerSJP(String str, int i, Class cls, int i2) {
        InitializerSignatureImpl initializerSignatureImpl = new InitializerSignatureImpl(i, cls);
        int i3 = this.count;
        this.count = i3 + 1;
        return new JoinPointImpl.StaticPartImpl(i3, str, initializerSignatureImpl, makeSourceLoc(i2, -1));
    }

    public InitializerSignature makeInitializerSig(String str) {
        InitializerSignatureImpl initializerSignatureImpl = new InitializerSignatureImpl(str);
        initializerSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return initializerSignatureImpl;
    }

    public JoinPoint.EnclosingStaticPart makeLockESJP(String str, Class cls, int i) {
        LockSignatureImpl lockSignatureImpl = new LockSignatureImpl((Class<?>) cls);
        int i2 = this.count;
        this.count = i2 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i2, str, lockSignatureImpl, makeSourceLoc(i, -1));
    }

    public JoinPoint.StaticPart makeLockSJP(String str, Class cls, int i) {
        LockSignatureImpl lockSignatureImpl = new LockSignatureImpl((Class<?>) cls);
        int i2 = this.count;
        this.count = i2 + 1;
        return new JoinPointImpl.StaticPartImpl(i2, str, lockSignatureImpl, makeSourceLoc(i, -1));
    }

    public LockSignature makeLockSig(String str) {
        LockSignatureImpl lockSignatureImpl = new LockSignatureImpl(str);
        lockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return lockSignatureImpl;
    }

    public JoinPoint.EnclosingStaticPart makeMethodESJP(String str, int i, String str2, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2, int i2) {
        MethodSignature makeMethodSig = makeMethodSig(i, str2, cls, clsArr == null ? NO_TYPES : clsArr, strArr == null ? NO_STRINGS : strArr, clsArr2 == null ? NO_TYPES : clsArr2, cls2 == null ? Void.TYPE : cls2);
        int i3 = this.count;
        this.count = i3 + 1;
        String str3 = str;
        return new JoinPointImpl.EnclosingStaticPartImpl(i3, str, makeMethodSig, makeSourceLoc(i2, -1));
    }

    public JoinPoint.StaticPart makeMethodSJP(String str, int i, String str2, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2, int i2) {
        MethodSignature makeMethodSig = makeMethodSig(i, str2, cls, clsArr == null ? NO_TYPES : clsArr, strArr == null ? NO_STRINGS : strArr, clsArr2 == null ? NO_TYPES : clsArr2, cls2 == null ? Void.TYPE : cls2);
        int i3 = this.count;
        this.count = i3 + 1;
        String str3 = str;
        return new JoinPointImpl.StaticPartImpl(i3, str, makeMethodSig, makeSourceLoc(i2, -1));
    }

    public MethodSignature makeMethodSig(String str) {
        MethodSignatureImpl methodSignatureImpl = new MethodSignatureImpl(str);
        methodSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return methodSignatureImpl;
    }

    public JoinPoint.StaticPart makeSJP(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        MethodSignature makeMethodSig = makeMethodSig(str2, str3, str4, str5, str6, str7, str8);
        int i2 = this.count;
        this.count = i2 + 1;
        String str9 = str;
        return new JoinPointImpl.StaticPartImpl(i2, str, makeMethodSig, makeSourceLoc(i, -1));
    }

    public SourceLocation makeSourceLoc(int i, int i2) {
        return new SourceLocationImpl(this.lexicalClass, this.filename, i);
    }

    public JoinPoint.EnclosingStaticPart makeUnlockESJP(String str, Class cls, int i) {
        UnlockSignatureImpl unlockSignatureImpl = new UnlockSignatureImpl((Class<?>) cls);
        int i2 = this.count;
        this.count = i2 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i2, str, unlockSignatureImpl, makeSourceLoc(i, -1));
    }

    public JoinPoint.StaticPart makeUnlockSJP(String str, Class cls, int i) {
        UnlockSignatureImpl unlockSignatureImpl = new UnlockSignatureImpl((Class<?>) cls);
        int i2 = this.count;
        this.count = i2 + 1;
        return new JoinPointImpl.StaticPartImpl(i2, str, unlockSignatureImpl, makeSourceLoc(i, -1));
    }

    public UnlockSignature makeUnlockSig(String str) {
        UnlockSignatureImpl unlockSignatureImpl = new UnlockSignatureImpl(str);
        unlockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return unlockSignatureImpl;
    }

    public static JoinPoint makeJP(JoinPoint.StaticPart staticPart, Object obj, Object obj2, Object obj3) {
        return new JoinPointImpl(staticPart, obj, obj2, new Object[]{obj3});
    }

    public JoinPoint.EnclosingStaticPart makeESJP(String str, Signature signature, int i, int i2) {
        int i3 = this.count;
        this.count = i3 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i3, str, signature, makeSourceLoc(i, i2));
    }

    public static JoinPoint makeJP(JoinPoint.StaticPart staticPart, Object obj, Object obj2, Object obj3, Object obj4) {
        return new JoinPointImpl(staticPart, obj, obj2, new Object[]{obj3, obj4});
    }

    public AdviceSignature makeAdviceSig(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8 = str;
        int parseInt = Integer.parseInt(str, 16);
        String str9 = str3;
        Class<?> makeClass = makeClass(str3, this.lookupClassLoader);
        String str10 = str4;
        StringTokenizer stringTokenizer = new StringTokenizer(str4, AccountConstantKt.CODE_SEPARTOR);
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = makeClass(stringTokenizer.nextToken(), this.lookupClassLoader);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str5, AccountConstantKt.CODE_SEPARTOR);
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i2 = 0; i2 < countTokens2; i2++) {
            strArr[i2] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str6, AccountConstantKt.CODE_SEPARTOR);
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i3 = 0; i3 < countTokens3; i3++) {
            clsArr2[i3] = makeClass(stringTokenizer3.nextToken(), this.lookupClassLoader);
        }
        AdviceSignatureImpl adviceSignatureImpl = new AdviceSignatureImpl(parseInt, str2, makeClass, clsArr, strArr, clsArr2, makeClass(str7, this.lookupClassLoader));
        adviceSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return adviceSignatureImpl;
    }

    public CatchClauseSignature makeCatchClauseSig(String str, String str2, String str3) {
        CatchClauseSignatureImpl catchClauseSignatureImpl = new CatchClauseSignatureImpl(makeClass(str, this.lookupClassLoader), makeClass(new StringTokenizer(str2, AccountConstantKt.CODE_SEPARTOR).nextToken(), this.lookupClassLoader), new StringTokenizer(str3, AccountConstantKt.CODE_SEPARTOR).nextToken());
        catchClauseSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return catchClauseSignatureImpl;
    }

    public ConstructorSignature makeConstructorSig(String str, String str2, String str3, String str4, String str5) {
        int parseInt = Integer.parseInt(str, 16);
        Class<?> makeClass = makeClass(str2, this.lookupClassLoader);
        StringTokenizer stringTokenizer = new StringTokenizer(str3, AccountConstantKt.CODE_SEPARTOR);
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = makeClass(stringTokenizer.nextToken(), this.lookupClassLoader);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str4, AccountConstantKt.CODE_SEPARTOR);
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i2 = 0; i2 < countTokens2; i2++) {
            strArr[i2] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str5, AccountConstantKt.CODE_SEPARTOR);
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i3 = 0; i3 < countTokens3; i3++) {
            clsArr2[i3] = makeClass(stringTokenizer3.nextToken(), this.lookupClassLoader);
        }
        ConstructorSignatureImpl constructorSignatureImpl = new ConstructorSignatureImpl(parseInt, makeClass, clsArr, strArr, clsArr2);
        constructorSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return constructorSignatureImpl;
    }

    public JoinPoint.EnclosingStaticPart makeESJP(String str, Signature signature, int i) {
        int i2 = this.count;
        this.count = i2 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i2, str, signature, makeSourceLoc(i, -1));
    }

    public FieldSignature makeFieldSig(String str, String str2, String str3, String str4) {
        FieldSignatureImpl fieldSignatureImpl = new FieldSignatureImpl(Integer.parseInt(str, 16), str2, makeClass(str3, this.lookupClassLoader), makeClass(str4, this.lookupClassLoader));
        fieldSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return fieldSignatureImpl;
    }

    public InitializerSignature makeInitializerSig(String str, String str2) {
        InitializerSignatureImpl initializerSignatureImpl = new InitializerSignatureImpl(Integer.parseInt(str, 16), makeClass(str2, this.lookupClassLoader));
        initializerSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return initializerSignatureImpl;
    }

    public LockSignature makeLockSig() {
        LockSignatureImpl lockSignatureImpl = new LockSignatureImpl(makeClass("Ljava/lang/Object;", this.lookupClassLoader));
        lockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return lockSignatureImpl;
    }

    public MethodSignature makeMethodSig(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return makeMethodSig(str, str2, (Class) makeClass(str3, this.lookupClassLoader), str4, str5, str6, str7);
    }

    public JoinPoint.StaticPart makeSJP(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        MethodSignature makeMethodSig = makeMethodSig(str2, str3, str4, str5, str6, "", str7);
        int i2 = this.count;
        this.count = i2 + 1;
        String str8 = str;
        return new JoinPointImpl.StaticPartImpl(i2, str, makeMethodSig, makeSourceLoc(i, -1));
    }

    public UnlockSignature makeUnlockSig() {
        UnlockSignatureImpl unlockSignatureImpl = new UnlockSignatureImpl(makeClass("Ljava/lang/Object;", this.lookupClassLoader));
        unlockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return unlockSignatureImpl;
    }

    public static JoinPoint makeJP(JoinPoint.StaticPart staticPart, Object obj, Object obj2, Object[] objArr) {
        return new JoinPointImpl(staticPart, obj, obj2, objArr);
    }

    public MethodSignature makeMethodSig(String str, String str2, Class cls, String str3, String str4, String str5, String str6) {
        String str7 = str;
        int parseInt = Integer.parseInt(str, 16);
        String str8 = str3;
        StringTokenizer stringTokenizer = new StringTokenizer(str3, AccountConstantKt.CODE_SEPARTOR);
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = makeClass(stringTokenizer.nextToken(), this.lookupClassLoader);
        }
        String str9 = str4;
        StringTokenizer stringTokenizer2 = new StringTokenizer(str4, AccountConstantKt.CODE_SEPARTOR);
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i2 = 0; i2 < countTokens2; i2++) {
            strArr[i2] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str5, AccountConstantKt.CODE_SEPARTOR);
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i3 = 0; i3 < countTokens3; i3++) {
            clsArr2[i3] = makeClass(stringTokenizer3.nextToken(), this.lookupClassLoader);
        }
        return new MethodSignatureImpl(parseInt, str2, cls, clsArr, strArr, clsArr2, makeClass(str6, this.lookupClassLoader));
    }

    public JoinPoint.StaticPart makeSJP(String str, Signature signature, SourceLocation sourceLocation) {
        int i = this.count;
        this.count = i + 1;
        return new JoinPointImpl.StaticPartImpl(i, str, signature, sourceLocation);
    }

    public LockSignature makeLockSig(Class cls) {
        LockSignatureImpl lockSignatureImpl = new LockSignatureImpl((Class<?>) cls);
        lockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return lockSignatureImpl;
    }

    public JoinPoint.StaticPart makeSJP(String str, Signature signature, int i, int i2) {
        int i3 = this.count;
        this.count = i3 + 1;
        return new JoinPointImpl.StaticPartImpl(i3, str, signature, makeSourceLoc(i, i2));
    }

    public UnlockSignature makeUnlockSig(Class cls) {
        UnlockSignatureImpl unlockSignatureImpl = new UnlockSignatureImpl((Class<?>) cls);
        unlockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return unlockSignatureImpl;
    }

    public InitializerSignature makeInitializerSig(int i, Class cls) {
        InitializerSignatureImpl initializerSignatureImpl = new InitializerSignatureImpl(i, cls);
        initializerSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return initializerSignatureImpl;
    }

    public JoinPoint.StaticPart makeSJP(String str, Signature signature, int i) {
        int i2 = this.count;
        this.count = i2 + 1;
        return new JoinPointImpl.StaticPartImpl(i2, str, signature, makeSourceLoc(i, -1));
    }

    public FieldSignature makeFieldSig(int i, String str, Class cls, Class cls2) {
        FieldSignatureImpl fieldSignatureImpl = new FieldSignatureImpl(i, str, cls, cls2);
        fieldSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return fieldSignatureImpl;
    }

    public CatchClauseSignature makeCatchClauseSig(Class cls, Class cls2, String str) {
        CatchClauseSignatureImpl catchClauseSignatureImpl = new CatchClauseSignatureImpl(cls, cls2, str);
        catchClauseSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return catchClauseSignatureImpl;
    }

    public ConstructorSignature makeConstructorSig(int i, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        ConstructorSignatureImpl constructorSignatureImpl = new ConstructorSignatureImpl(i, cls, clsArr, strArr, clsArr2);
        constructorSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return constructorSignatureImpl;
    }

    public AdviceSignature makeAdviceSig(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        AdviceSignatureImpl adviceSignatureImpl = new AdviceSignatureImpl(i, str, cls, clsArr, strArr, clsArr2, cls2);
        adviceSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return adviceSignatureImpl;
    }

    public MethodSignature makeMethodSig(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        MethodSignatureImpl methodSignatureImpl = new MethodSignatureImpl(i, str, cls, clsArr == null ? NO_TYPES : clsArr, strArr, clsArr2 == null ? NO_TYPES : clsArr2, cls2);
        methodSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return methodSignatureImpl;
    }
}
