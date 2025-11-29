package com.xingin.xhssharesdk.r;

public final /* synthetic */ class a {
    public static /* synthetic */ int a(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 3;
        }
        if (i == 5) {
            return 4;
        }
        if (i == 6) {
            return -1;
        }
        throw null;
    }

    public static /* synthetic */ String b(int i) {
        return i == 1 ? "DEFAULT_ACTION" : i == 2 ? "IMPRESSION" : i == 3 ? "CLICK" : i == 4 ? "PAGE_VIEW" : i == 5 ? "PAGE_END" : i == 6 ? "UNRECOGNIZED" : "null";
    }
}
