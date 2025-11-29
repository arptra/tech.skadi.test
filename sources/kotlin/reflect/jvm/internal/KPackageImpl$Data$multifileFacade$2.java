package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPackageImpl;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Class;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class KPackageImpl$Data$multifileFacade$2 extends Lambda implements Function0<Class<?>> {
    final /* synthetic */ KPackageImpl.Data this$0;
    final /* synthetic */ KPackageImpl this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KPackageImpl$Data$multifileFacade$2(KPackageImpl.Data data, KPackageImpl kPackageImpl) {
        super(0);
        this.this$0 = data;
        this.this$1 = kPackageImpl;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = r0.getClassHeader();
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Class<?> invoke() {
        /*
            r8 = this;
            kotlin.reflect.jvm.internal.KPackageImpl$Data r0 = r8.this$0
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass r0 = r0.getKotlinClass()
            r1 = 0
            if (r0 == 0) goto L_0x0015
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r0 = r0.getClassHeader()
            if (r0 == 0) goto L_0x0015
            java.lang.String r0 = r0.getMultifileClassName()
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r1
        L_0x0016:
            if (r2 == 0) goto L_0x0037
            int r0 = r2.length()
            if (r0 <= 0) goto L_0x0037
            kotlin.reflect.jvm.internal.KPackageImpl r8 = r8.this$1
            java.lang.Class r8 = r8.getJClass()
            java.lang.ClassLoader r8 = r8.getClassLoader()
            r6 = 4
            r7 = 0
            r3 = 47
            r4 = 46
            r5 = 0
            java.lang.String r0 = kotlin.text.StringsKt.replace$default((java.lang.String) r2, (char) r3, (char) r4, (boolean) r5, (int) r6, (java.lang.Object) r7)
            java.lang.Class r1 = r8.loadClass(r0)
        L_0x0037:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KPackageImpl$Data$multifileFacade$2.invoke():java.lang.Class");
    }
}
