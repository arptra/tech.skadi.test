package com.xjsd.nbs.client.domain.enums;

public enum Env {
    DEV(1, "DEV"),
    FAT(2, "FAT");
    
    private final int code;
    private final String desc;

    /* renamed from: com.xjsd.nbs.client.domain.enums.Env$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f8707a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.xjsd.nbs.client.domain.enums.Env[] r0 = com.xjsd.nbs.client.domain.enums.Env.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8707a = r0
                com.xjsd.nbs.client.domain.enums.Env r1 = com.xjsd.nbs.client.domain.enums.Env.DEV     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8707a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xjsd.nbs.client.domain.enums.Env r1 = com.xjsd.nbs.client.domain.enums.Env.FAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xjsd.nbs.client.domain.enums.Env.AnonymousClass1.<clinit>():void");
        }
    }

    private Env(int i, String str) {
        this.code = i;
        this.desc = str;
    }

    public static String getBaseUrl(Env env) {
        int i = AnonymousClass1.f8707a[env.ordinal()];
        return i != 1 ? i != 2 ? "" : "https://xr-nbs-fat.xjsdtech.com/gateway" : "https://xr-nbs-dev.xjsdtech.com/gateway";
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
