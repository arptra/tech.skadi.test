package io.ktor.utils.io;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00006\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a)\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\bj\u0004\u0018\u0001`\t2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\u000f\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a\"\u0010\u0012\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\f2\b\b\u0002\u0010\u0011\u001a\u00020\rH\u0010¢\u0006\u0004\b\u0012\u0010\u0010\"\u0014\u0010\u0014\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0013\"\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016\":\u0010\u001b\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000\f\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\bj\u0002`\t0\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a*(\b\u0002\u0010\u001c\"\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\b2\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\b¨\u0006\u001d"}, d2 = {"", "E", "exception", "cause", "e", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Ljava/lang/reflect/Constructor;", "constructor", "Lkotlin/Function1;", "Lio/ktor/utils/io/Ctor;", "a", "(Ljava/lang/reflect/Constructor;)Lkotlin/jvm/functions/Function1;", "Ljava/lang/Class;", "", "defaultValue", "d", "(Ljava/lang/Class;I)I", "accumulator", "b", "I", "throwableFields", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "cacheLock", "Ljava/util/WeakHashMap;", "c", "Ljava/util/WeakHashMap;", "exceptionCtors", "Ctor", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nExceptionUtilsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionUtilsJvm.kt\nio/ktor/utils/io/ExceptionUtilsJvmKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,101:1\n90#1:104\n90#1:105\n90#1:106\n90#1:107\n1#2:102\n6523#3:103\n12904#3,3:108\n*S KotlinDebug\n*F\n+ 1 ExceptionUtilsJvm.kt\nio/ktor/utils/io/ExceptionUtilsJvmKt\n*L\n74#1:104\n79#1:105\n81#1:106\n84#1:107\n59#1:103\n96#1:108,3\n*E\n"})
public final class ExceptionUtilsJvmKt {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9083a = d(Throwable.class, -1);
    public static final ReentrantReadWriteLock b = new ReentrantReadWriteLock();
    public static final WeakHashMap c = new WeakHashMap();

    public static final Function1 a(Constructor constructor) {
        Class[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new ExceptionUtilsJvmKt$createConstructor$$inlined$safeCtor$4(constructor);
        }
        Class<Throwable> cls = Throwable.class;
        Class<String> cls2 = String.class;
        if (length == 1) {
            Class cls3 = parameterTypes[0];
            if (Intrinsics.areEqual((Object) cls3, (Object) cls)) {
                return new ExceptionUtilsJvmKt$createConstructor$$inlined$safeCtor$2(constructor);
            }
            if (Intrinsics.areEqual((Object) cls3, (Object) cls2)) {
                return new ExceptionUtilsJvmKt$createConstructor$$inlined$safeCtor$3(constructor);
            }
            return null;
        } else if (length == 2 && Intrinsics.areEqual((Object) parameterTypes[0], (Object) cls2) && Intrinsics.areEqual((Object) parameterTypes[1], (Object) cls)) {
            return new ExceptionUtilsJvmKt$createConstructor$$inlined$safeCtor$1(constructor);
        } else {
            return null;
        }
    }

    public static final int b(Class cls, int i) {
        do {
            Field[] declaredFields = cls.getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "declaredFields");
            int length = declaredFields.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (!Modifier.isStatic(declaredFields[i3].getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }

    public static /* synthetic */ int c(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return b(cls, i);
    }

    public static final int d(Class cls, int i) {
        Integer num;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.Companion;
            num = Result.m20constructorimpl(Integer.valueOf(c(cls, 0, 1, (Object) null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.m26isFailureimpl(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static final java.lang.Throwable e(java.lang.Throwable r8, java.lang.Throwable r9) {
        /*
            java.lang.String r0 = "exception"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "cause"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            boolean r0 = r8 instanceof kotlinx.coroutines.CopyableThrowable
            r1 = 0
            if (r0 == 0) goto L_0x0032
            kotlin.Result$Companion r9 = kotlin.Result.Companion     // Catch:{ all -> 0x001c }
            kotlinx.coroutines.CopyableThrowable r8 = (kotlinx.coroutines.CopyableThrowable) r8     // Catch:{ all -> 0x001c }
            java.lang.Throwable r8 = r8.createCopy()     // Catch:{ all -> 0x001c }
            java.lang.Object r8 = kotlin.Result.m20constructorimpl(r8)     // Catch:{ all -> 0x001c }
            goto L_0x0027
        L_0x001c:
            r8 = move-exception
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m20constructorimpl(r8)
        L_0x0027:
            boolean r9 = kotlin.Result.m26isFailureimpl(r8)
            if (r9 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r1 = r8
        L_0x002f:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            return r1
        L_0x0032:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = b
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r0.readLock()
            r2.lock()
            java.util.WeakHashMap r3 = c     // Catch:{ all -> 0x012e }
            java.lang.Class r4 = r8.getClass()     // Catch:{ all -> 0x012e }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x012e }
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3     // Catch:{ all -> 0x012e }
            r2.unlock()
            if (r3 == 0) goto L_0x0053
            java.lang.Object r8 = r3.invoke(r8)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            return r8
        L_0x0053:
            int r2 = f9083a
            java.lang.Class r3 = r8.getClass()
            r4 = 0
            int r3 = d(r3, r4)
            if (r2 == r3) goto L_0x00a6
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r9 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            if (r2 != 0) goto L_0x006f
            int r2 = r0.getReadHoldCount()
            goto L_0x0070
        L_0x006f:
            r2 = r4
        L_0x0070:
            r3 = r4
        L_0x0071:
            if (r3 >= r2) goto L_0x0079
            r9.unlock()
            int r3 = r3 + 1
            goto L_0x0071
        L_0x0079:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.util.WeakHashMap r3 = c     // Catch:{ all -> 0x0099 }
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x0099 }
            io.ktor.utils.io.ExceptionUtilsJvmKt$tryCopyException$4$1 r5 = io.ktor.utils.io.ExceptionUtilsJvmKt$tryCopyException$4$1.INSTANCE     // Catch:{ all -> 0x0099 }
            r3.put(r8, r5)     // Catch:{ all -> 0x0099 }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0099 }
        L_0x008d:
            if (r4 >= r2) goto L_0x0095
            r9.lock()
            int r4 = r4 + 1
            goto L_0x008d
        L_0x0095:
            r0.unlock()
            return r1
        L_0x0099:
            r8 = move-exception
        L_0x009a:
            if (r4 >= r2) goto L_0x00a2
            r9.lock()
            int r4 = r4 + 1
            goto L_0x009a
        L_0x00a2:
            r0.unlock()
            throw r8
        L_0x00a6:
            java.lang.Class r0 = r8.getClass()
            java.lang.reflect.Constructor[] r0 = r0.getConstructors()
            java.lang.String r2 = "exception.javaClass.constructors"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            io.ktor.utils.io.ExceptionUtilsJvmKt$tryCopyException$$inlined$sortedByDescending$1 r2 = new io.ktor.utils.io.ExceptionUtilsJvmKt$tryCopyException$$inlined$sortedByDescending$1
            r2.<init>()
            java.util.List r0 = kotlin.collections.ArraysKt.sortedWith((T[]) r0, r2)
            java.util.Iterator r0 = r0.iterator()
            r2 = r1
        L_0x00c1:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00d8
            java.lang.Object r2 = r0.next()
            java.lang.reflect.Constructor r2 = (java.lang.reflect.Constructor) r2
            java.lang.String r3 = "constructor"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            kotlin.jvm.functions.Function1 r2 = a(r2)
            if (r2 == 0) goto L_0x00c1
        L_0x00d8:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = b
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r3 = r0.readLock()
            int r5 = r0.getWriteHoldCount()
            if (r5 != 0) goto L_0x00e9
            int r5 = r0.getReadHoldCount()
            goto L_0x00ea
        L_0x00e9:
            r5 = r4
        L_0x00ea:
            r6 = r4
        L_0x00eb:
            if (r6 >= r5) goto L_0x00f3
            r3.unlock()
            int r6 = r6 + 1
            goto L_0x00eb
        L_0x00f3:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.util.WeakHashMap r6 = c     // Catch:{ all -> 0x0105 }
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x0105 }
            if (r2 != 0) goto L_0x0107
            io.ktor.utils.io.ExceptionUtilsJvmKt$tryCopyException$5$1 r7 = io.ktor.utils.io.ExceptionUtilsJvmKt$tryCopyException$5$1.INSTANCE     // Catch:{ all -> 0x0105 }
            goto L_0x0108
        L_0x0105:
            r8 = move-exception
            goto L_0x0122
        L_0x0107:
            r7 = r2
        L_0x0108:
            r6.put(r8, r7)     // Catch:{ all -> 0x0105 }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0105 }
        L_0x010d:
            if (r4 >= r5) goto L_0x0115
            r3.lock()
            int r4 = r4 + 1
            goto L_0x010d
        L_0x0115:
            r0.unlock()
            if (r2 == 0) goto L_0x0121
            java.lang.Object r8 = r2.invoke(r9)
            r1 = r8
            java.lang.Throwable r1 = (java.lang.Throwable) r1
        L_0x0121:
            return r1
        L_0x0122:
            if (r4 >= r5) goto L_0x012a
            r3.lock()
            int r4 = r4 + 1
            goto L_0x0122
        L_0x012a:
            r0.unlock()
            throw r8
        L_0x012e:
            r8 = move-exception
            r2.unlock()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ExceptionUtilsJvmKt.e(java.lang.Throwable, java.lang.Throwable):java.lang.Throwable");
    }
}
