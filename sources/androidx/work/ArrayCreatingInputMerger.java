package androidx.work;

import androidx.work.Data;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.relay.api.IntentKey;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0014\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/work/ArrayCreatingInputMerger;", "Landroidx/work/InputMerger;", "<init>", "()V", "", "Landroidx/work/Data;", "inputs", "a", "(Ljava/util/List;)Landroidx/work/Data;", "", "array1", "array2", "c", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "array", "obj", "Ljava/lang/Class;", "valueClass", "b", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "d", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class ArrayCreatingInputMerger extends InputMerger {
    public Data a(List list) {
        Intrinsics.checkNotNullParameter(list, "inputs");
        Data.Builder builder = new Data.Builder();
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map h = ((Data) it.next()).h();
            Intrinsics.checkNotNullExpressionValue(h, "input.keyValueMap");
            Iterator it2 = h.entrySet().iterator();
            while (true) {
                if (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    Class cls = value != null ? value.getClass() : String.class;
                    Object obj = hashMap.get(str);
                    Intrinsics.checkNotNullExpressionValue(str, IntentKey.ACTIVITY.ACTION_KEY);
                    if (obj != null) {
                        Class<?> cls2 = obj.getClass();
                        if (Intrinsics.areEqual((Object) cls2, (Object) cls)) {
                            Intrinsics.checkNotNullExpressionValue(value, AccountConstantKt.RESPONSE_VALUE);
                            value = c(obj, value);
                        } else if (Intrinsics.areEqual((Object) cls2.getComponentType(), (Object) cls)) {
                            value = b(obj, value, cls);
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } else if (!cls.isArray()) {
                        value = d(value, cls);
                    }
                    Intrinsics.checkNotNullExpressionValue(value, "if (existingValue == nul…      }\n                }");
                    hashMap.put(str, value);
                }
            }
        }
        builder.c(hashMap);
        Data a2 = builder.a();
        Intrinsics.checkNotNullExpressionValue(a2, "output.build()");
        return a2;
    }

    public final Object b(Object obj, Object obj2, Class cls) {
        int length = Array.getLength(obj);
        Object newInstance = Array.newInstance(cls, length + 1);
        System.arraycopy(obj, 0, newInstance, 0, length);
        Array.set(newInstance, length, obj2);
        Intrinsics.checkNotNullExpressionValue(newInstance, "newArray");
        return newInstance;
    }

    public final Object c(Object obj, Object obj2) {
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2);
        Class<?> componentType = obj.getClass().getComponentType();
        Intrinsics.checkNotNull(componentType);
        Object newInstance = Array.newInstance(componentType, length + length2);
        System.arraycopy(obj, 0, newInstance, 0, length);
        System.arraycopy(obj2, 0, newInstance, length, length2);
        Intrinsics.checkNotNullExpressionValue(newInstance, "newArray");
        return newInstance;
    }

    public final Object d(Object obj, Class cls) {
        Object newInstance = Array.newInstance(cls, 1);
        Array.set(newInstance, 0, obj);
        Intrinsics.checkNotNullExpressionValue(newInstance, "newArray");
        return newInstance;
    }
}
