package com.upuphone.xr.sapp.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/sapp/config/RequestNetConfigHelper;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/config/DetailNetConfigEntity;", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "b", "()Ljava/lang/String;", "Lcom/upuphone/xr/sapp/config/NetConfigResult;", "netConfigResult", "c", "(Lcom/upuphone/xr/sapp/config/NetConfigResult;)Lcom/upuphone/xr/sapp/config/DetailNetConfigEntity;", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class RequestNetConfigHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6668a = new Companion((DefaultConstructorMarker) null);
    public static int b = Integer.MIN_VALUE;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b&\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000b8\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0014\u0010\u0016\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0014\u0010\u0017\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0014\u0010\u0018\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0018\u0010\rR\u0014\u0010\u0019\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0019\u0010\rR\u0014\u0010\u001a\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u001a\u0010\rR\u0014\u0010\u001b\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u001b\u0010\rR\u0014\u0010\u001c\u001a\u00020\u000b8\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\rR\u0014\u0010\u001d\u001a\u00020\u000b8\u0006XT¢\u0006\u0006\n\u0004\b\u001d\u0010\rR\u0014\u0010\u001e\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u001e\u0010\rR\u0014\u0010\u001f\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u001f\u0010\rR\u0014\u0010 \u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b \u0010\rR\u0014\u0010!\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b!\u0010\rR\u0014\u0010\"\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\"\u0010\rR\u0014\u0010#\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b#\u0010\rR\u0014\u0010$\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b$\u0010\rR\u0014\u0010%\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b%\u0010\rR\u0014\u0010&\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b&\u0010\rR\u0014\u0010'\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b'\u0010\rR\u0014\u0010(\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b(\u0010\rR\u0014\u0010)\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b)\u0010\rR\u0014\u0010*\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b*\u0010\rR\u0014\u0010+\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b+\u0010\rR\u0014\u0010,\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b,\u0010\rR\u0014\u0010-\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b-\u0010\rR\u0014\u0010.\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b.\u0010\rR\u0014\u0010/\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b/\u0010\rR\u0014\u00100\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b0\u0010\r¨\u00061"}, d2 = {"Lcom/upuphone/xr/sapp/config/RequestNetConfigHelper$Companion;", "", "<init>", "()V", "", "netConfigVersion", "I", "a", "()I", "setNetConfigVersion", "(I)V", "", "BASE_URL_PROD", "Ljava/lang/String;", "BASE_URL_PROD_INTL", "BASE_URL_UAT", "BASE_URL_UAT_INTL", "CHINA_PROD", "CHINA_UAT", "D_AIRECORD", "D_GW", "D_KM", "D_KMCM", "D_MIXTURE", "D_NBS", "D_POLICY", "D_SUPPORT", "D_SURVEY", "INTL_PROD", "INTL_UAT", "S_ACCOUNT_SERVICE", "S_AI_RECORDS", "S_APISIX", "S_APISIX_KM", "S_AR_OTA", "S_CLOUD_ADAPTER", "S_CLOUD_CANCEL", "S_FEEDBACK_SERVICE", "S_MYVU_AUTH", "S_MYVU_CONFIG", "S_MYVU_FILE", "S_NBS_SURVEY", "S_WEATHER", "S_WEATHER_KM", "S_XR_DATATRACK", "S_XR_MENU", "S_XR_WEATHER", "S_XR_WEATHER_KM", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return RequestNetConfigHelper.b;
        }

        public Companion() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0051 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b() {
        /*
            r3 = this;
            com.upuphone.xr.sapp.config.NetConfig$Companion r3 = com.upuphone.xr.sapp.config.NetConfig.f6666a
            java.lang.String r3 = r3.j()
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "env:"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "RequestNetConfigHelper"
            r0.g(r2, r1)
            int r0 = r3.hashCode()
            switch(r0) {
                case -1250810561: goto L_0x0049;
                case -40344448: goto L_0x003d;
                case 576316038: goto L_0x0032;
                case 685795321: goto L_0x0026;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x0051
        L_0x0026:
            java.lang.String r0 = "intl_prod"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x002f
            goto L_0x0051
        L_0x002f:
            java.lang.String r3 = "https://gw-global.myvu.cn/config/"
            goto L_0x0056
        L_0x0032:
            java.lang.String r0 = "intl_uat"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0051
            java.lang.String r3 = "https://gw-global-uat.myvu.cn/config/"
            goto L_0x0056
        L_0x003d:
            java.lang.String r0 = "china_uat"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0046
            goto L_0x0051
        L_0x0046:
            java.lang.String r3 = "https://gw-uat.myvu.cn/config/"
            goto L_0x0056
        L_0x0049:
            java.lang.String r0 = "china_prod"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0054
        L_0x0051:
            java.lang.String r3 = ""
            goto L_0x0056
        L_0x0054:
            java.lang.String r3 = "https://gw.myvu.cn/config/"
        L_0x0056:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.config.RequestNetConfigHelper.b():java.lang.String");
    }

    public final DetailNetConfigEntity c(NetConfigResult netConfigResult) {
        if (netConfigResult.getCount() <= 0) {
            return null;
        }
        DetailNetConfigEntity detailNetConfigEntity = new DetailNetConfigEntity((NetConfigEntity) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 524287, (DefaultConstructorMarker) null);
        String str = "";
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        for (NetConfigSubItem next : netConfigResult.getList()) {
            String name = next.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -2080236745:
                        if (name.equals("s-ai-records")) {
                            detailNetConfigEntity.setMyvuRecordService("https://" + next.getUrl());
                            break;
                        } else {
                            break;
                        }
                    case -1857334604:
                        if (name.equals("s-xr-weather-km")) {
                            detailNetConfigEntity.setSXrWeatherKm("https://" + next.getUrl());
                            break;
                        } else {
                            break;
                        }
                    case -1568577758:
                        if (name.equals("s-apisix")) {
                            detailNetConfigEntity.setSApisix("https://" + next.getUrl());
                            break;
                        } else {
                            break;
                        }
                    case -1568521702:
                        if (name.equals("s-ar-ota")) {
                            detailNetConfigEntity.setSArOta("https://" + next.getUrl());
                            break;
                        } else {
                            break;
                        }
                    case -1512335685:
                        if (name.equals("d-policy")) {
                            str5 = "https://" + next.getUrl();
                            break;
                        } else {
                            break;
                        }
                    case -1432253475:
                        if (name.equals("s-cloud-adapter")) {
                            detailNetConfigEntity.setCloudAdapterService("https://" + next.getUrl());
                            break;
                        } else {
                            break;
                        }
                    case -1420715805:
                        if (name.equals("d-survey")) {
                            str4 = "https://" + next.getUrl();
                            break;
                        } else {
                            break;
                        }
                    case -1251457605:
                        if (name.equals("s-xr-weather")) {
                            detailNetConfigEntity.setSXrWeather("https://" + next.getUrl());
                            break;
                        } else {
                            break;
                        }
                    case -1174093963:
                        if (name.equals("s-weather-km")) {
                            detailNetConfigEntity.setSWeatherKm("https://" + next.getUrl());
                            break;
                        } else {
                            break;
                        }
                    case -1094533274:
                        if (name.equals("d-support")) {
                            next.getUrl();
                            break;
                        } else {
                            break;
                        }
                    case -964922949:
                        if (name.equals("s-account-service")) {
                            detailNetConfigEntity.setSAccountService("https://" + next.getUrl());
                            break;
                        } else {
                            break;
                        }
                    case -255761427:
                        if (name.equals("s-apisix-km")) {
                            detailNetConfigEntity.setSApisixKm("https://" + next.getUrl());
                            break;
                        } else {
                            break;
                        }
                    case -53522932:
                        if (name.equals("d-km-cm")) {
                            str6 = "wss://" + next.getUrl();
                            break;
                        } else {
                            break;
                        }
                    case 3025657:
                        if (name.equals("d-gw")) {
                            next.getUrl();
                            break;
                        } else {
                            break;
                        }
                    case 3025771:
                        if (name.equals("d-km")) {
                            str2 = "https://" + next.getUrl();
                            break;
                        } else {
                            break;
                        }
                    case 93801558:
                        if (name.equals("d-nbs")) {
                            str = "https://" + next.getUrl();
                            break;
                        } else {
                            break;
                        }
                    case 474286402:
                        if (name.equals("s-nbs-survey")) {
                            detailNetConfigEntity.setSNbsSurvey("https://" + next.getUrl());
                            break;
                        } else {
                            break;
                        }
                    case 476977055:
                        if (name.equals("s-cloud-feedback-service")) {
                            detailNetConfigEntity.setFeedbackService("https://" + next.getUrl());
                            break;
                        } else {
                            break;
                        }
                    case 641661082:
                        if (name.equals("s-weather")) {
                            detailNetConfigEntity.setSWeather("https://" + next.getUrl());
                            break;
                        } else {
                            break;
                        }
                    case 676932490:
                        if (name.equals("s-myvu-config")) {
                            detailNetConfigEntity.setMyvuConfigService("https://" + next.getUrl());
                            break;
                        } else {
                            break;
                        }
                    case 690877416:
                        if (name.equals("s-xr-datatrack")) {
                            detailNetConfigEntity.setXrDatatrack("https://" + next.getUrl());
                            break;
                        } else {
                            break;
                        }
                    case 983889904:
                        if (name.equals("s-myvu-auth")) {
                            detailNetConfigEntity.setSMyvuAuth("https://" + next.getUrl());
                            break;
                        } else {
                            break;
                        }
                    case 984027076:
                        if (name.equals("s-myvu-file")) {
                            detailNetConfigEntity.setMyvuFileService("https://" + next.getUrl());
                            break;
                        } else {
                            break;
                        }
                    case 1404988866:
                        if (name.equals("d-airecord")) {
                            str7 = "https://" + next.getUrl();
                            break;
                        } else {
                            break;
                        }
                    case 1809775660:
                        if (name.equals("s-cloud-cancel")) {
                            detailNetConfigEntity.setCloudCancelService("https://" + next.getUrl());
                            break;
                        } else {
                            break;
                        }
                    case 1834342503:
                        if (name.equals("d-mixture")) {
                            str3 = "https://" + next.getUrl();
                            break;
                        } else {
                            break;
                        }
                    case 1853109496:
                        if (name.equals("s-xr-menu")) {
                            detailNetConfigEntity.setSXrMenu("https://" + next.getUrl());
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        detailNetConfigEntity.setNetConfigEntity(new NetConfigEntity(str, str2, str3, str4, str5, str6, str7, (String) null, (String) null, (String) null, (String) null, (String) null, Utf8.MASK_2BYTES, (DefaultConstructorMarker) null));
        return detailNetConfigEntity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(kotlin.coroutines.Continuation r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.upuphone.xr.sapp.config.RequestNetConfigHelper$requestNetConfig$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.upuphone.xr.sapp.config.RequestNetConfigHelper$requestNetConfig$1 r0 = (com.upuphone.xr.sapp.config.RequestNetConfigHelper$requestNetConfig$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0014
            int r1 = r1 - r2
            r0.label = r1
        L_0x0012:
            r4 = r0
            goto L_0x001a
        L_0x0014:
            com.upuphone.xr.sapp.config.RequestNetConfigHelper$requestNetConfig$1 r0 = new com.upuphone.xr.sapp.config.RequestNetConfigHelper$requestNetConfig$1
            r0.<init>(r8, r9)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            java.lang.String r7 = "RequestNetConfigHelper"
            if (r1 == 0) goto L_0x003c
            if (r1 != r2) goto L_0x0034
            java.lang.Object r8 = r4.L$0
            com.upuphone.xr.sapp.config.RequestNetConfigHelper r8 = (com.upuphone.xr.sapp.config.RequestNetConfigHelper) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ Exception -> 0x0031 }
            goto L_0x0073
        L_0x0031:
            r8 = move-exception
            goto L_0x00b3
        L_0x0034:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.String r9 = r8.b()     // Catch:{ Exception -> 0x0031 }
            retrofit2.Retrofit$Builder r1 = new retrofit2.Retrofit$Builder     // Catch:{ Exception -> 0x0031 }
            r1.<init>()     // Catch:{ Exception -> 0x0031 }
            retrofit2.Retrofit$Builder r9 = r1.baseUrl((java.lang.String) r9)     // Catch:{ Exception -> 0x0031 }
            retrofit2.converter.gson.GsonConverterFactory r1 = retrofit2.converter.gson.GsonConverterFactory.create()     // Catch:{ Exception -> 0x0031 }
            retrofit2.Retrofit$Builder r9 = r9.addConverterFactory(r1)     // Catch:{ Exception -> 0x0031 }
            retrofit2.Retrofit r9 = r9.build()     // Catch:{ Exception -> 0x0031 }
            java.lang.Class<com.upuphone.xr.sapp.config.NetConfigInterface> r1 = com.upuphone.xr.sapp.config.NetConfigInterface.class
            java.lang.Object r9 = r9.create(r1)     // Catch:{ Exception -> 0x0031 }
            r1 = r9
            com.upuphone.xr.sapp.config.NetConfigInterface r1 = (com.upuphone.xr.sapp.config.NetConfigInterface) r1     // Catch:{ Exception -> 0x0031 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ Exception -> 0x0031 }
            r4.L$0 = r8     // Catch:{ Exception -> 0x0031 }
            r4.label = r2     // Catch:{ Exception -> 0x0031 }
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            java.lang.Object r9 = com.upuphone.xr.sapp.config.NetConfigInterface.DefaultImpls.a(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0031 }
            if (r9 != r0) goto L_0x0073
            return r0
        L_0x0073:
            com.upuphone.xr.sapp.config.NetConfigResult r9 = (com.upuphone.xr.sapp.config.NetConfigResult) r9     // Catch:{ Exception -> 0x0031 }
            int r0 = r9.getVer()     // Catch:{ Exception -> 0x0031 }
            b = r0     // Catch:{ Exception -> 0x0031 }
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x0031 }
            com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0031 }
            r1.<init>()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r1 = r1.toJson((java.lang.Object) r9)     // Catch:{ Exception -> 0x0031 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0031 }
            r2.<init>()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r3 = "result:"
            r2.append(r3)     // Catch:{ Exception -> 0x0031 }
            r2.append(r1)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0031 }
            r0.g(r7, r1)     // Catch:{ Exception -> 0x0031 }
            com.upuphone.xr.sapp.config.DetailNetConfigEntity r8 = r8.c(r9)     // Catch:{ Exception -> 0x0031 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0031 }
            r9.<init>()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r1 = "requestNetConfig -> netConfigEntity:"
            r9.append(r1)     // Catch:{ Exception -> 0x0031 }
            r9.append(r8)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0031 }
            r0.g(r7, r9)     // Catch:{ Exception -> 0x0031 }
            goto L_0x00bd
        L_0x00b3:
            com.upuphone.star.core.log.ULog$Delegate r9 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r8 = r8.getMessage()
            r9.c(r7, r8)
            r8 = 0
        L_0x00bd:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.config.RequestNetConfigHelper.d(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
