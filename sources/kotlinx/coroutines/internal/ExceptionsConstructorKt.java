package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000(\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a9\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0002`\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a5\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0002`\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0004H\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\r\u001a\u00020\u000b*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\"\u0010\u0010\u001a\u00020\u000b*\u0006\u0012\u0002\b\u00030\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000bH\u0010¢\u0006\u0004\b\u0010\u0010\u000e\"\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015*(\b\u0002\u0010\u0017\"\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00042\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004¨\u0006\u0018"}, d2 = {"", "E", "Ljava/lang/Class;", "clz", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "b", "(Ljava/lang/Class;)Lkotlin/jvm/functions/Function1;", "block", "f", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "", "defaultValue", "e", "(Ljava/lang/Class;I)I", "accumulator", "c", "a", "I", "throwableFields", "Lkotlinx/coroutines/internal/CtorCache;", "Lkotlinx/coroutines/internal/CtorCache;", "ctorCache", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,116:1\n1#2:117\n11335#3:118\n11670#3,3:119\n12904#3,3:136\n1963#4,14:122\n*S KotlinDebug\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n*L\n45#1:118\n45#1:119,3\n82#1:136,3\n63#1:122,14\n*E\n"})
public final class ExceptionsConstructorKt {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3914a = e(Throwable.class, -1);
    public static final CtorCache b;

    static {
        CtorCache ctorCache;
        try {
            ctorCache = FastServiceLoaderKt.a() ? WeakMapCtorCache.f3938a : ClassValueCtorCache.f3907a;
        } catch (Throwable unused) {
            ctorCache = WeakMapCtorCache.f3938a;
        }
        b = ctorCache;
    }

    public static final Function1 b(Class cls) {
        Object obj;
        Function1 function1;
        Pair pair;
        ExceptionsConstructorKt$createConstructor$nullResult$1 exceptionsConstructorKt$createConstructor$nullResult$1 = ExceptionsConstructorKt$createConstructor$nullResult$1.INSTANCE;
        if (f3914a != e(cls, 0)) {
            return exceptionsConstructorKt$createConstructor$nullResult$1;
        }
        Constructor[] constructors = cls.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.length);
        int length = constructors.length;
        int i = 0;
        while (true) {
            obj = null;
            if (i >= length) {
                break;
            }
            Constructor constructor = constructors[i];
            Class[] parameterTypes = constructor.getParameterTypes();
            int length2 = parameterTypes.length;
            if (length2 != 0) {
                Class<Throwable> cls2 = Throwable.class;
                Class<String> cls3 = String.class;
                if (length2 != 1) {
                    pair = length2 != 2 ? TuplesKt.to(null, -1) : (!Intrinsics.areEqual((Object) parameterTypes[0], (Object) cls3) || !Intrinsics.areEqual((Object) parameterTypes[1], (Object) cls2)) ? TuplesKt.to(null, -1) : TuplesKt.to(f(new ExceptionsConstructorKt$createConstructor$1$1(constructor)), 3);
                } else {
                    Class cls4 = parameterTypes[0];
                    pair = Intrinsics.areEqual((Object) cls4, (Object) cls3) ? TuplesKt.to(f(new ExceptionsConstructorKt$createConstructor$1$2(constructor)), 2) : Intrinsics.areEqual((Object) cls4, (Object) cls2) ? TuplesKt.to(f(new ExceptionsConstructorKt$createConstructor$1$3(constructor)), 1) : TuplesKt.to(null, -1);
                }
            } else {
                pair = TuplesKt.to(f(new ExceptionsConstructorKt$createConstructor$1$4(constructor)), 0);
            }
            arrayList.add(pair);
            i++;
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            obj = it.next();
            if (it.hasNext()) {
                int intValue = ((Number) ((Pair) obj).getSecond()).intValue();
                do {
                    Object next = it.next();
                    int intValue2 = ((Number) ((Pair) next).getSecond()).intValue();
                    if (intValue < intValue2) {
                        obj = next;
                        intValue = intValue2;
                    }
                } while (it.hasNext());
            }
        }
        Pair pair2 = (Pair) obj;
        return (pair2 == null || (function1 = (Function1) pair2.getFirst()) == null) ? exceptionsConstructorKt$createConstructor$nullResult$1 : function1;
    }

    public static final int c(Class cls, int i) {
        do {
            Field[] declaredFields = cls.getDeclaredFields();
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

    public static /* synthetic */ int d(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return c(cls, i);
    }

    public static final int e(Class cls, int i) {
        Integer num;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.Companion;
            num = Result.m20constructorimpl(Integer.valueOf(d(cls, 0, 1, (Object) null)));
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

    public static final Function1 f(Function1 function1) {
        return new ExceptionsConstructorKt$safeCtor$1(function1);
    }
}
