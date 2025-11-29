package com.xjsd.ai.assistant.phone;

import android.text.TextUtils;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.xr.interconnect.api.NaviAbilityOperator;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.api.SappAbilityAction;
import com.upuphone.xr.interconnect.api.SappAbilityOperator;
import com.upuphone.xr.interconnect.api.SappAbilityType;
import com.upuphone.xr.interconnect.api.TransAbilityOperator;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;
import com.upuphone.xr.interconnect.listener.NaviLocationCallback;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.nlu.bean.LocationInfo;

public class SuperAppAbilityManager {

    /* renamed from: a  reason: collision with root package name */
    public OperatorManager f8523a;
    public NaviAbilityOperator b;
    public TransAbilityOperator c;
    public long d;

    /* renamed from: com.xjsd.ai.assistant.phone.SuperAppAbilityManager$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f8524a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.xjsd.ai.assistant.phone.SuperAppAbilityManager$SAppAbilityEnum[] r0 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.SAppAbilityEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8524a = r0
                com.xjsd.ai.assistant.phone.SuperAppAbilityManager$SAppAbilityEnum r1 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.SAppAbilityEnum.NAVI     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8524a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xjsd.ai.assistant.phone.SuperAppAbilityManager$SAppAbilityEnum r1 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.SAppAbilityEnum.AR_MEDIA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8524a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xjsd.ai.assistant.phone.SuperAppAbilityManager$SAppAbilityEnum r1 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.SAppAbilityEnum.AR_CARD     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8524a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.xjsd.ai.assistant.phone.SuperAppAbilityManager$SAppAbilityEnum r1 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.SAppAbilityEnum.TRANSLATION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8524a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.xjsd.ai.assistant.phone.SuperAppAbilityManager$SAppAbilityEnum r1 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.SAppAbilityEnum.AR_LIFE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8524a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.xjsd.ai.assistant.phone.SuperAppAbilityManager$SAppAbilityEnum r1 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.SAppAbilityEnum.NOT_DISTURB     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.SuperAppAbilityManager.AnonymousClass2.<clinit>():void");
        }
    }

    public static class Holder {

        /* renamed from: a  reason: collision with root package name */
        public static final SuperAppAbilityManager f8525a = new SuperAppAbilityManager();
    }

    public enum SAppAbilityEnum {
        NAVI(SappAbilityType.NAVI),
        AR_MEDIA("抖音"),
        AR_CARD(SappAbilityType.AR_CARD),
        TRANSLATION("同传互译"),
        AR_LIFE("生活圈"),
        NOT_DISTURB(SappAbilityType.NOT_DISTURB);
        
        String value;

        private SAppAbilityEnum(String str) {
            this.value = str;
        }
    }

    public static SuperAppAbilityManager e() {
        return Holder.f8525a;
    }

    public void d(SAppAbilityEnum sAppAbilityEnum) {
        OperatorManager operatorManager = this.f8523a;
        if (operatorManager != null) {
            SappAbilityOperator sappAbilityOperator = operatorManager.getSappAbilityOperator();
            if (sappAbilityOperator == null || sAppAbilityEnum == null) {
                ILog.g("SuperAppAbilityManager", "closeApp sappAbilityOperator == null");
                return;
            }
            switch (AnonymousClass2.f8524a[sAppAbilityEnum.ordinal()]) {
                case 1:
                    sappAbilityOperator.callAbility(SappAbilityType.NAVI, SappAbilityAction.CLOSE);
                    return;
                case 2:
                    sappAbilityOperator.callAbility(SappAbilityType.AR_MEDIA, SappAbilityAction.CLOSE);
                    return;
                case 3:
                    sappAbilityOperator.callAbility(SappAbilityType.AR_CARD, SappAbilityAction.CLOSE);
                    return;
                case 4:
                    sappAbilityOperator.callAbility(SappAbilityType.TRANSLATION, SappAbilityAction.CLOSE);
                    return;
                case 5:
                    sappAbilityOperator.callAbility(SappAbilityType.AR_LIFE, SappAbilityAction.CLOSE);
                    return;
                case 6:
                    sappAbilityOperator.callAbility(SappAbilityType.NOT_DISTURB, SappAbilityAction.CLOSE);
                    return;
                default:
                    ILog.g("SuperAppAbilityManager", "closeApp Unexpected value: " + sAppAbilityEnum);
                    return;
            }
        } else {
            ILog.g("SuperAppAbilityManager", "closeApp operatorManager == null");
        }
    }

    public NaviAbilityOperator f() {
        return this.b;
    }

    public TransAbilityOperator g() {
        return this.c;
    }

    public boolean h(SAppAbilityEnum sAppAbilityEnum) {
        OperatorManager operatorManager = this.f8523a;
        if (operatorManager != null) {
            SappAbilityOperator sappAbilityOperator = operatorManager.getSappAbilityOperator();
            if (sappAbilityOperator == null || sAppAbilityEnum == null) {
                ILog.g("SuperAppAbilityManager", "isAppOpened sappAbilityOperator == null");
                return false;
            }
            switch (AnonymousClass2.f8524a[sAppAbilityEnum.ordinal()]) {
                case 1:
                    return sappAbilityOperator.callAbility(SappAbilityType.NAVI, SappAbilityAction.STATE);
                case 2:
                    return sappAbilityOperator.callAbility(SappAbilityType.AR_MEDIA, SappAbilityAction.STATE);
                case 3:
                    return sappAbilityOperator.callAbility(SappAbilityType.AR_CARD, SappAbilityAction.STATE);
                case 4:
                    return sappAbilityOperator.callAbility(SappAbilityType.TRANSLATION, SappAbilityAction.STATE);
                case 5:
                    return sappAbilityOperator.callAbility(SappAbilityType.AR_LIFE, SappAbilityAction.STATE);
                case 6:
                    return sappAbilityOperator.callAbility(SappAbilityType.NOT_DISTURB, SappAbilityAction.STATE);
                default:
                    ILog.g("SuperAppAbilityManager", "isAppOpened Unexpected value: " + sAppAbilityEnum);
                    return false;
            }
        } else {
            ILog.g("SuperAppAbilityManager", "isAppOpened operatorManager == null");
            return false;
        }
    }

    public final boolean i(NaviLocationInfo naviLocationInfo) {
        return TextUtils.equals(naviLocationInfo.getErrorInfo(), "success");
    }

    public void j(SAppAbilityEnum sAppAbilityEnum) {
        OperatorManager operatorManager = this.f8523a;
        if (operatorManager != null) {
            SappAbilityOperator sappAbilityOperator = operatorManager.getSappAbilityOperator();
            if (sappAbilityOperator == null || sAppAbilityEnum == null) {
                ILog.g("SuperAppAbilityManager", "sappAbilityOperator == null");
                return;
            }
            switch (AnonymousClass2.f8524a[sAppAbilityEnum.ordinal()]) {
                case 1:
                    sappAbilityOperator.callAbility(SappAbilityType.NAVI, "open");
                    return;
                case 2:
                    sappAbilityOperator.callAbility(SappAbilityType.AR_MEDIA, "open");
                    return;
                case 3:
                    sappAbilityOperator.callAbility(SappAbilityType.AR_CARD, "open");
                    return;
                case 4:
                    sappAbilityOperator.callAbility(SappAbilityType.TRANSLATION, "open");
                    return;
                case 5:
                    sappAbilityOperator.callAbility(SappAbilityType.AR_LIFE, "open");
                    return;
                case 6:
                    sappAbilityOperator.callAbility(SappAbilityType.NOT_DISTURB, "open");
                    return;
                default:
                    ILog.g("SuperAppAbilityManager", "openApp Unexpected value: " + sAppAbilityEnum);
                    return;
            }
        } else {
            ILog.g("SuperAppAbilityManager", "operatorManager == null");
        }
    }

    public void k(OperatorManager operatorManager) {
        this.f8523a = operatorManager;
        this.b = operatorManager.getNaviAbilityOperator();
        this.c = operatorManager.getTransAbilityOperator();
    }

    public void l() {
        if (this.b != null && System.currentTimeMillis() - this.d > 600000) {
            this.b.startLocation(new NaviLocationCallback() {
                public void onLocationChanged(NaviLocationInfo naviLocationInfo) {
                    if (naviLocationInfo != null && SuperAppAbilityManager.this.i(naviLocationInfo)) {
                        String valueOf = String.valueOf(naviLocationInfo.getLongitude());
                        String valueOf2 = String.valueOf(naviLocationInfo.getLatitude());
                        ILog.a("SuperAppAbilityManager", "收到地理坐标更新->" + valueOf2 + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + valueOf);
                        LocationInfo locationInfo = new LocationInfo(valueOf, valueOf2);
                        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
                        cacheAbility.cache("locationInfo", locationInfo);
                        cacheAbility.cache("longitude", locationInfo.getLongitude());
                        cacheAbility.cache("latitude", locationInfo.getLatitude());
                        SuperAppAbilityManager.this.d = System.currentTimeMillis();
                    }
                    SuperAppAbilityManager.this.b.stopLocation(this);
                }
            });
        }
    }

    public SuperAppAbilityManager() {
        this.d = 0;
    }
}
