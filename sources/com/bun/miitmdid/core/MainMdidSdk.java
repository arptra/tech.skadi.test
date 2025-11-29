package com.bun.miitmdid.core;

import android.content.Context;
import androidx.annotation.Keep;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.netease.nis.sdkwrapper.Utils;

@Keep
public class MainMdidSdk implements IIdentifierListener {
    private static final String TAG = "MDID SDK ";
    private IIdentifierListener toDeveloperListener;

    /* renamed from: com.bun.miitmdid.core.MainMdidSdk$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(2:1|2)|3|5|6|(2:7|8)|9|11|12|13|(2:15|16)|17|(2:19|20)|21|(2:23|24)|25|27|28|29|(2:31|32)|33|(2:35|36)|37|39|40|41|42|43|44|45|46|(3:47|48|50)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|1|2|3|5|6|7|8|9|11|12|13|(2:15|16)|17|19|20|21|23|24|25|27|28|29|(2:31|32)|33|35|36|37|39|40|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|1|2|3|5|6|7|8|9|11|12|13|15|16|17|19|20|21|23|24|25|27|28|29|31|32|33|35|36|37|39|40|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0015 */
        static {
            /*
                com.bun.miitmdid.content.ProviderList.DEVICE_PROVIDER.values()
                r0 = 16
                int[] r0 = new int[r0]
                $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER = r0
                r1 = 1
                r2 = 2
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000d }
            L_0x000d:
                r0 = 13
                int[] r3 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.bun.miitmdid.content.ProviderList$DEVICE_PROVIDER r4 = com.bun.miitmdid.content.ProviderList.DEVICE_PROVIDER.UNSUPPORT     // Catch:{ NoSuchFieldError -> 0x0015 }
                r3[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                int[] r2 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER     // Catch:{ NoSuchFieldError -> 0x001c }
                com.bun.miitmdid.content.ProviderList$DEVICE_PROVIDER r3 = com.bun.miitmdid.content.ProviderList.DEVICE_PROVIDER.UNSUPPORT     // Catch:{ NoSuchFieldError -> 0x001c }
                r3 = 3
                r2[r3] = r3     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r2 = 4
                int[] r3 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER     // Catch:{ NoSuchFieldError -> 0x0023 }
                com.bun.miitmdid.content.ProviderList$DEVICE_PROVIDER r4 = com.bun.miitmdid.content.ProviderList.DEVICE_PROVIDER.UNSUPPORT     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                r1 = 5
                int[] r3 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER     // Catch:{ NoSuchFieldError -> 0x002a }
                com.bun.miitmdid.content.ProviderList$DEVICE_PROVIDER r4 = com.bun.miitmdid.content.ProviderList.DEVICE_PROVIDER.UNSUPPORT     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r2] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r2 = 6
                r3 = 12
                int[] r4 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.bun.miitmdid.content.ProviderList$DEVICE_PROVIDER r5 = com.bun.miitmdid.content.ProviderList.DEVICE_PROVIDER.UNSUPPORT     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 7
                int[] r5 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER     // Catch:{ NoSuchFieldError -> 0x003a }
                com.bun.miitmdid.content.ProviderList$DEVICE_PROVIDER r6 = com.bun.miitmdid.content.ProviderList.DEVICE_PROVIDER.UNSUPPORT     // Catch:{ NoSuchFieldError -> 0x003a }
                r5[r1] = r4     // Catch:{ NoSuchFieldError -> 0x003a }
            L_0x003a:
                r1 = 8
                int[] r5 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER     // Catch:{ NoSuchFieldError -> 0x0042 }
                com.bun.miitmdid.content.ProviderList$DEVICE_PROVIDER r6 = com.bun.miitmdid.content.ProviderList.DEVICE_PROVIDER.UNSUPPORT     // Catch:{ NoSuchFieldError -> 0x0042 }
                r5[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0042 }
            L_0x0042:
                r2 = 9
                int[] r5 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER     // Catch:{ NoSuchFieldError -> 0x004a }
                com.bun.miitmdid.content.ProviderList$DEVICE_PROVIDER r6 = com.bun.miitmdid.content.ProviderList.DEVICE_PROVIDER.UNSUPPORT     // Catch:{ NoSuchFieldError -> 0x004a }
                r5[r4] = r2     // Catch:{ NoSuchFieldError -> 0x004a }
            L_0x004a:
                r4 = 10
                int[] r5 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER     // Catch:{ NoSuchFieldError -> 0x0052 }
                com.bun.miitmdid.content.ProviderList$DEVICE_PROVIDER r6 = com.bun.miitmdid.content.ProviderList.DEVICE_PROVIDER.UNSUPPORT     // Catch:{ NoSuchFieldError -> 0x0052 }
                r5[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                r1 = 11
                int[] r5 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER     // Catch:{ NoSuchFieldError -> 0x005a }
                com.bun.miitmdid.content.ProviderList$DEVICE_PROVIDER r6 = com.bun.miitmdid.content.ProviderList.DEVICE_PROVIDER.UNSUPPORT     // Catch:{ NoSuchFieldError -> 0x005a }
                r5[r2] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r2 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.bun.miitmdid.content.ProviderList$DEVICE_PROVIDER r5 = com.bun.miitmdid.content.ProviderList.DEVICE_PROVIDER.UNSUPPORT     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r2 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER     // Catch:{ NoSuchFieldError -> 0x0066 }
                com.bun.miitmdid.content.ProviderList$DEVICE_PROVIDER r3 = com.bun.miitmdid.content.ProviderList.DEVICE_PROVIDER.UNSUPPORT     // Catch:{ NoSuchFieldError -> 0x0066 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                int[] r0 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER     // Catch:{ NoSuchFieldError -> 0x006e }
                com.bun.miitmdid.content.ProviderList$DEVICE_PROVIDER r1 = com.bun.miitmdid.content.ProviderList.DEVICE_PROVIDER.UNSUPPORT     // Catch:{ NoSuchFieldError -> 0x006e }
                r1 = 14
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER     // Catch:{ NoSuchFieldError -> 0x0076 }
                com.bun.miitmdid.content.ProviderList$DEVICE_PROVIDER r1 = com.bun.miitmdid.content.ProviderList.DEVICE_PROVIDER.UNSUPPORT     // Catch:{ NoSuchFieldError -> 0x0076 }
                r1 = 15
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0076 }
            L_0x0076:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bun.miitmdid.core.MainMdidSdk.AnonymousClass1.<clinit>():void");
        }
    }

    @Keep
    public MainMdidSdk() {
    }

    private int _InnerFailed(int i, IdSupplier idSupplier) {
        return ((Integer) Utils.rL(new Object[]{this, Integer.valueOf(i), idSupplier, 24, 1606976968496L})).intValue();
    }

    @Keep
    public int OnInit(Context context, IIdentifierListener iIdentifierListener) {
        return ((Integer) Utils.rL(new Object[]{this, context, iIdentifierListener, 25, 1606976968497L})).intValue();
    }

    public void OnSupport(boolean z, IdSupplier idSupplier) {
        Utils.rL(new Object[]{this, Boolean.valueOf(z), idSupplier, 26, 1606976968498L});
    }

    @Keep
    public MainMdidSdk(boolean z) {
    }
}
