package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;
import java.util.HashMap;

public class KeyCache {

    /* renamed from: a  reason: collision with root package name */
    public HashMap f499a = new HashMap();

    public float a(Object obj, String str, int i) {
        HashMap hashMap;
        float[] fArr;
        if (this.f499a.containsKey(obj) && (hashMap = (HashMap) this.f499a.get(obj)) != null && hashMap.containsKey(str) && (fArr = (float[]) hashMap.get(str)) != null && fArr.length > i) {
            return fArr[i];
        }
        return Float.NaN;
    }

    public void b(Object obj, String str, int i, float f) {
        if (!this.f499a.containsKey(obj)) {
            HashMap hashMap = new HashMap();
            float[] fArr = new float[(i + 1)];
            fArr[i] = f;
            hashMap.put(str, fArr);
            this.f499a.put(obj, hashMap);
            return;
        }
        HashMap hashMap2 = (HashMap) this.f499a.get(obj);
        if (hashMap2 == null) {
            hashMap2 = new HashMap();
        }
        if (!hashMap2.containsKey(str)) {
            float[] fArr2 = new float[(i + 1)];
            fArr2[i] = f;
            hashMap2.put(str, fArr2);
            this.f499a.put(obj, hashMap2);
            return;
        }
        float[] fArr3 = (float[]) hashMap2.get(str);
        if (fArr3 == null) {
            fArr3 = new float[0];
        }
        if (fArr3.length <= i) {
            fArr3 = Arrays.copyOf(fArr3, i + 1);
        }
        fArr3[i] = f;
        hashMap2.put(str, fArr3);
    }
}
