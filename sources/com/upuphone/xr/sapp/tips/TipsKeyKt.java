package com.upuphone.xr.sapp.tips;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.time.DateUtils;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0001¢\u0006\u0004\b\b\u0010\t\u001a\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "Lcom/upuphone/xr/sapp/tips/TipsKey;", "d", "(Ljava/lang/String;)Lcom/upuphone/xr/sapp/tips/TipsKey;", "", "c", "(Lcom/upuphone/xr/sapp/tips/TipsKey;)Z", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$HomeTips$Builder;", "a", "(Lcom/upuphone/xr/sapp/tips/TipsKey;)Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$HomeTips$Builder;", "b", "()Z", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTipsKey.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TipsKey.kt\ncom/upuphone/xr/sapp/tips/TipsKeyKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,86:1\n1282#2,2:87\n*S KotlinDebug\n*F\n+ 1 TipsKey.kt\ncom/upuphone/xr/sapp/tips/TipsKeyKt\n*L\n31#1:87,2\n*E\n"})
public final class TipsKeyKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.upuphone.xr.sapp.tips.TipsKey[] r0 = com.upuphone.xr.sapp.tips.TipsKey.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.upuphone.xr.sapp.tips.TipsKey r1 = com.upuphone.xr.sapp.tips.TipsKey.TIPS_PERMISSION     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.upuphone.xr.sapp.tips.TipsKey r1 = com.upuphone.xr.sapp.tips.TipsKey.TIPS_SPORT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.tips.TipsKeyKt.WhenMappings.<clinit>():void");
        }
    }

    public static final AndroidAppApi.HomeTips.Builder a(TipsKey tipsKey) {
        Intrinsics.checkNotNullParameter(tipsKey, "<this>");
        AndroidAppApi.HomeTips.Builder b = new AndroidAppApi.HomeTips.Builder().c(tipsKey.name()).e("TYPE_NORMAL").b(Long.valueOf((long) tipsKey.getPriority()));
        Intrinsics.checkNotNullExpressionValue(b, "setPriority(...)");
        return b;
    }

    public static final boolean b() {
        long longValue = ((Number) DataStoreUtils.i(DataStoreUtils.e.a(), "PERMISSION_CLOSE_KEY", 0L, (Context) null, 4, (Object) null)).longValue();
        if (longValue == 0 || System.currentTimeMillis() - longValue > DateUtils.MILLIS_PER_DAY) {
            return true;
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("TipsKey", "checkPermissionTips " + longValue);
        return false;
    }

    public static final boolean c(TipsKey tipsKey) {
        Intrinsics.checkNotNullParameter(tipsKey, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[tipsKey.ordinal()];
        return i == 1 || i == 2;
    }

    public static final TipsKey d(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        for (TipsKey tipsKey : TipsKey.values()) {
            if (Intrinsics.areEqual((Object) str, (Object) tipsKey.name())) {
                return tipsKey;
            }
        }
        return null;
    }
}
