package kotlin.reflect.jvm.internal.impl.util;

import kotlin.collections.AbstractIterator;

public final class ArrayMapImpl$iterator$1 extends AbstractIterator<T> {
    private int index = -1;
    final /* synthetic */ ArrayMapImpl<T> this$0;

    public ArrayMapImpl$iterator$1(ArrayMapImpl<T> arrayMapImpl) {
        this.this$0 = arrayMapImpl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void computeNext() {
        /*
            r2 = this;
        L_0x0000:
            int r0 = r2.index
            int r0 = r0 + 1
            r2.index = r0
            kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl<T> r1 = r2.this$0
            java.lang.Object[] r1 = r1.data
            int r1 = r1.length
            if (r0 >= r1) goto L_0x001b
            kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl<T> r0 = r2.this$0
            java.lang.Object[] r0 = r0.data
            int r1 = r2.index
            r0 = r0[r1]
            if (r0 == 0) goto L_0x0000
        L_0x001b:
            int r0 = r2.index
            kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl<T> r1 = r2.this$0
            java.lang.Object[] r1 = r1.data
            int r1 = r1.length
            if (r0 < r1) goto L_0x002a
            r2.done()
            goto L_0x003c
        L_0x002a:
            kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl<T> r0 = r2.this$0
            java.lang.Object[] r0 = r0.data
            int r1 = r2.index
            r0 = r0[r1]
            java.lang.String r1 = "null cannot be cast to non-null type T of org.jetbrains.kotlin.util.ArrayMapImpl"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            r2.setNext(r0)
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl$iterator$1.computeNext():void");
    }
}
