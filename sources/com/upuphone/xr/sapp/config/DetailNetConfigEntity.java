package com.upuphone.xr.sapp.config;

import androidx.annotation.Keep;
import com.here.posclient.PositionEstimate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\bQ\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BÅ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005¢\u0006\u0002\u0010\u0017J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003JÉ\u0001\u0010U\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0005HÆ\u0001J\u0013\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Y\u001a\u00020ZHÖ\u0001J\t\u0010[\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0012\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001a\u0010\u0014\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\u0016\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001a\u0010\u0015\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001bR\u001a\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bR\u001a\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bR\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0019\"\u0004\b5\u0010\u001bR\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0019\"\u0004\b7\u0010\u001bR\u001a\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0019\"\u0004\b9\u0010\u001bR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0019\"\u0004\b;\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0019\"\u0004\b=\u0010\u001bR\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0019\"\u0004\b?\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0019\"\u0004\bA\u0010\u001b¨\u0006\\"}, d2 = {"Lcom/upuphone/xr/sapp/config/DetailNetConfigEntity;", "", "netConfigEntity", "Lcom/upuphone/xr/sapp/config/NetConfigEntity;", "xrDatatrack", "", "sArOta", "sAccountService", "sMyvuAuth", "sNbsSurvey", "sXrMenu", "sXrWeather", "sXrWeatherKm", "sWeather", "sWeatherKm", "sApisix", "sApisixKm", "feedbackService", "cloudAdapterService", "cloudCancelService", "myvuConfigService", "myvuRecordService", "myvuFileService", "(Lcom/upuphone/xr/sapp/config/NetConfigEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCloudAdapterService", "()Ljava/lang/String;", "setCloudAdapterService", "(Ljava/lang/String;)V", "getCloudCancelService", "setCloudCancelService", "getFeedbackService", "setFeedbackService", "getMyvuConfigService", "setMyvuConfigService", "getMyvuFileService", "setMyvuFileService", "getMyvuRecordService", "setMyvuRecordService", "getNetConfigEntity", "()Lcom/upuphone/xr/sapp/config/NetConfigEntity;", "setNetConfigEntity", "(Lcom/upuphone/xr/sapp/config/NetConfigEntity;)V", "getSAccountService", "setSAccountService", "getSApisix", "setSApisix", "getSApisixKm", "setSApisixKm", "getSArOta", "setSArOta", "getSMyvuAuth", "setSMyvuAuth", "getSNbsSurvey", "setSNbsSurvey", "getSWeather", "setSWeather", "getSWeatherKm", "setSWeatherKm", "getSXrMenu", "setSXrMenu", "getSXrWeather", "setSXrWeather", "getSXrWeatherKm", "setSXrWeatherKm", "getXrDatatrack", "setXrDatatrack", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class DetailNetConfigEntity {
    @NotNull
    private String cloudAdapterService;
    @NotNull
    private String cloudCancelService;
    @NotNull
    private String feedbackService;
    @NotNull
    private String myvuConfigService;
    @NotNull
    private String myvuFileService;
    @NotNull
    private String myvuRecordService;
    @Nullable
    private NetConfigEntity netConfigEntity;
    @NotNull
    private String sAccountService;
    @NotNull
    private String sApisix;
    @NotNull
    private String sApisixKm;
    @NotNull
    private String sArOta;
    @NotNull
    private String sMyvuAuth;
    @NotNull
    private String sNbsSurvey;
    @NotNull
    private String sWeather;
    @NotNull
    private String sWeatherKm;
    @NotNull
    private String sXrMenu;
    @NotNull
    private String sXrWeather;
    @NotNull
    private String sXrWeatherKm;
    @NotNull
    private String xrDatatrack;

    public DetailNetConfigEntity() {
        this((NetConfigEntity) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 524287, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DetailNetConfigEntity copy$default(DetailNetConfigEntity detailNetConfigEntity, NetConfigEntity netConfigEntity2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, int i, Object obj) {
        DetailNetConfigEntity detailNetConfigEntity2 = detailNetConfigEntity;
        int i2 = i;
        return detailNetConfigEntity.copy((i2 & 1) != 0 ? detailNetConfigEntity2.netConfigEntity : netConfigEntity2, (i2 & 2) != 0 ? detailNetConfigEntity2.xrDatatrack : str, (i2 & 4) != 0 ? detailNetConfigEntity2.sArOta : str2, (i2 & 8) != 0 ? detailNetConfigEntity2.sAccountService : str3, (i2 & 16) != 0 ? detailNetConfigEntity2.sMyvuAuth : str4, (i2 & 32) != 0 ? detailNetConfigEntity2.sNbsSurvey : str5, (i2 & 64) != 0 ? detailNetConfigEntity2.sXrMenu : str6, (i2 & 128) != 0 ? detailNetConfigEntity2.sXrWeather : str7, (i2 & 256) != 0 ? detailNetConfigEntity2.sXrWeatherKm : str8, (i2 & 512) != 0 ? detailNetConfigEntity2.sWeather : str9, (i2 & 1024) != 0 ? detailNetConfigEntity2.sWeatherKm : str10, (i2 & 2048) != 0 ? detailNetConfigEntity2.sApisix : str11, (i2 & 4096) != 0 ? detailNetConfigEntity2.sApisixKm : str12, (i2 & 8192) != 0 ? detailNetConfigEntity2.feedbackService : str13, (i2 & 16384) != 0 ? detailNetConfigEntity2.cloudAdapterService : str14, (i2 & 32768) != 0 ? detailNetConfigEntity2.cloudCancelService : str15, (i2 & 65536) != 0 ? detailNetConfigEntity2.myvuConfigService : str16, (i2 & 131072) != 0 ? detailNetConfigEntity2.myvuRecordService : str17, (i2 & PositionEstimate.Value.BUILDING_NAME) != 0 ? detailNetConfigEntity2.myvuFileService : str18);
    }

    @Nullable
    public final NetConfigEntity component1() {
        return this.netConfigEntity;
    }

    @NotNull
    public final String component10() {
        return this.sWeather;
    }

    @NotNull
    public final String component11() {
        return this.sWeatherKm;
    }

    @NotNull
    public final String component12() {
        return this.sApisix;
    }

    @NotNull
    public final String component13() {
        return this.sApisixKm;
    }

    @NotNull
    public final String component14() {
        return this.feedbackService;
    }

    @NotNull
    public final String component15() {
        return this.cloudAdapterService;
    }

    @NotNull
    public final String component16() {
        return this.cloudCancelService;
    }

    @NotNull
    public final String component17() {
        return this.myvuConfigService;
    }

    @NotNull
    public final String component18() {
        return this.myvuRecordService;
    }

    @NotNull
    public final String component19() {
        return this.myvuFileService;
    }

    @NotNull
    public final String component2() {
        return this.xrDatatrack;
    }

    @NotNull
    public final String component3() {
        return this.sArOta;
    }

    @NotNull
    public final String component4() {
        return this.sAccountService;
    }

    @NotNull
    public final String component5() {
        return this.sMyvuAuth;
    }

    @NotNull
    public final String component6() {
        return this.sNbsSurvey;
    }

    @NotNull
    public final String component7() {
        return this.sXrMenu;
    }

    @NotNull
    public final String component8() {
        return this.sXrWeather;
    }

    @NotNull
    public final String component9() {
        return this.sXrWeatherKm;
    }

    @NotNull
    public final DetailNetConfigEntity copy(@Nullable NetConfigEntity netConfigEntity2, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14, @NotNull String str15, @NotNull String str16, @NotNull String str17, @NotNull String str18) {
        Intrinsics.checkNotNullParameter(str, "xrDatatrack");
        Intrinsics.checkNotNullParameter(str2, "sArOta");
        Intrinsics.checkNotNullParameter(str3, "sAccountService");
        Intrinsics.checkNotNullParameter(str4, "sMyvuAuth");
        Intrinsics.checkNotNullParameter(str5, "sNbsSurvey");
        Intrinsics.checkNotNullParameter(str6, "sXrMenu");
        Intrinsics.checkNotNullParameter(str7, "sXrWeather");
        Intrinsics.checkNotNullParameter(str8, "sXrWeatherKm");
        Intrinsics.checkNotNullParameter(str9, "sWeather");
        Intrinsics.checkNotNullParameter(str10, "sWeatherKm");
        Intrinsics.checkNotNullParameter(str11, "sApisix");
        Intrinsics.checkNotNullParameter(str12, "sApisixKm");
        Intrinsics.checkNotNullParameter(str13, "feedbackService");
        Intrinsics.checkNotNullParameter(str14, "cloudAdapterService");
        Intrinsics.checkNotNullParameter(str15, "cloudCancelService");
        Intrinsics.checkNotNullParameter(str16, "myvuConfigService");
        Intrinsics.checkNotNullParameter(str17, "myvuRecordService");
        Intrinsics.checkNotNullParameter(str18, "myvuFileService");
        return new DetailNetConfigEntity(netConfigEntity2, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DetailNetConfigEntity)) {
            return false;
        }
        DetailNetConfigEntity detailNetConfigEntity = (DetailNetConfigEntity) obj;
        return Intrinsics.areEqual((Object) this.netConfigEntity, (Object) detailNetConfigEntity.netConfigEntity) && Intrinsics.areEqual((Object) this.xrDatatrack, (Object) detailNetConfigEntity.xrDatatrack) && Intrinsics.areEqual((Object) this.sArOta, (Object) detailNetConfigEntity.sArOta) && Intrinsics.areEqual((Object) this.sAccountService, (Object) detailNetConfigEntity.sAccountService) && Intrinsics.areEqual((Object) this.sMyvuAuth, (Object) detailNetConfigEntity.sMyvuAuth) && Intrinsics.areEqual((Object) this.sNbsSurvey, (Object) detailNetConfigEntity.sNbsSurvey) && Intrinsics.areEqual((Object) this.sXrMenu, (Object) detailNetConfigEntity.sXrMenu) && Intrinsics.areEqual((Object) this.sXrWeather, (Object) detailNetConfigEntity.sXrWeather) && Intrinsics.areEqual((Object) this.sXrWeatherKm, (Object) detailNetConfigEntity.sXrWeatherKm) && Intrinsics.areEqual((Object) this.sWeather, (Object) detailNetConfigEntity.sWeather) && Intrinsics.areEqual((Object) this.sWeatherKm, (Object) detailNetConfigEntity.sWeatherKm) && Intrinsics.areEqual((Object) this.sApisix, (Object) detailNetConfigEntity.sApisix) && Intrinsics.areEqual((Object) this.sApisixKm, (Object) detailNetConfigEntity.sApisixKm) && Intrinsics.areEqual((Object) this.feedbackService, (Object) detailNetConfigEntity.feedbackService) && Intrinsics.areEqual((Object) this.cloudAdapterService, (Object) detailNetConfigEntity.cloudAdapterService) && Intrinsics.areEqual((Object) this.cloudCancelService, (Object) detailNetConfigEntity.cloudCancelService) && Intrinsics.areEqual((Object) this.myvuConfigService, (Object) detailNetConfigEntity.myvuConfigService) && Intrinsics.areEqual((Object) this.myvuRecordService, (Object) detailNetConfigEntity.myvuRecordService) && Intrinsics.areEqual((Object) this.myvuFileService, (Object) detailNetConfigEntity.myvuFileService);
    }

    @NotNull
    public final String getCloudAdapterService() {
        return this.cloudAdapterService;
    }

    @NotNull
    public final String getCloudCancelService() {
        return this.cloudCancelService;
    }

    @NotNull
    public final String getFeedbackService() {
        return this.feedbackService;
    }

    @NotNull
    public final String getMyvuConfigService() {
        return this.myvuConfigService;
    }

    @NotNull
    public final String getMyvuFileService() {
        return this.myvuFileService;
    }

    @NotNull
    public final String getMyvuRecordService() {
        return this.myvuRecordService;
    }

    @Nullable
    public final NetConfigEntity getNetConfigEntity() {
        return this.netConfigEntity;
    }

    @NotNull
    public final String getSAccountService() {
        return this.sAccountService;
    }

    @NotNull
    public final String getSApisix() {
        return this.sApisix;
    }

    @NotNull
    public final String getSApisixKm() {
        return this.sApisixKm;
    }

    @NotNull
    public final String getSArOta() {
        return this.sArOta;
    }

    @NotNull
    public final String getSMyvuAuth() {
        return this.sMyvuAuth;
    }

    @NotNull
    public final String getSNbsSurvey() {
        return this.sNbsSurvey;
    }

    @NotNull
    public final String getSWeather() {
        return this.sWeather;
    }

    @NotNull
    public final String getSWeatherKm() {
        return this.sWeatherKm;
    }

    @NotNull
    public final String getSXrMenu() {
        return this.sXrMenu;
    }

    @NotNull
    public final String getSXrWeather() {
        return this.sXrWeather;
    }

    @NotNull
    public final String getSXrWeatherKm() {
        return this.sXrWeatherKm;
    }

    @NotNull
    public final String getXrDatatrack() {
        return this.xrDatatrack;
    }

    public int hashCode() {
        NetConfigEntity netConfigEntity2 = this.netConfigEntity;
        return ((((((((((((((((((((((((((((((((((((netConfigEntity2 == null ? 0 : netConfigEntity2.hashCode()) * 31) + this.xrDatatrack.hashCode()) * 31) + this.sArOta.hashCode()) * 31) + this.sAccountService.hashCode()) * 31) + this.sMyvuAuth.hashCode()) * 31) + this.sNbsSurvey.hashCode()) * 31) + this.sXrMenu.hashCode()) * 31) + this.sXrWeather.hashCode()) * 31) + this.sXrWeatherKm.hashCode()) * 31) + this.sWeather.hashCode()) * 31) + this.sWeatherKm.hashCode()) * 31) + this.sApisix.hashCode()) * 31) + this.sApisixKm.hashCode()) * 31) + this.feedbackService.hashCode()) * 31) + this.cloudAdapterService.hashCode()) * 31) + this.cloudCancelService.hashCode()) * 31) + this.myvuConfigService.hashCode()) * 31) + this.myvuRecordService.hashCode()) * 31) + this.myvuFileService.hashCode();
    }

    public final void setCloudAdapterService(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cloudAdapterService = str;
    }

    public final void setCloudCancelService(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cloudCancelService = str;
    }

    public final void setFeedbackService(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedbackService = str;
    }

    public final void setMyvuConfigService(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.myvuConfigService = str;
    }

    public final void setMyvuFileService(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.myvuFileService = str;
    }

    public final void setMyvuRecordService(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.myvuRecordService = str;
    }

    public final void setNetConfigEntity(@Nullable NetConfigEntity netConfigEntity2) {
        this.netConfigEntity = netConfigEntity2;
    }

    public final void setSAccountService(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sAccountService = str;
    }

    public final void setSApisix(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sApisix = str;
    }

    public final void setSApisixKm(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sApisixKm = str;
    }

    public final void setSArOta(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sArOta = str;
    }

    public final void setSMyvuAuth(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sMyvuAuth = str;
    }

    public final void setSNbsSurvey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sNbsSurvey = str;
    }

    public final void setSWeather(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sWeather = str;
    }

    public final void setSWeatherKm(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sWeatherKm = str;
    }

    public final void setSXrMenu(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sXrMenu = str;
    }

    public final void setSXrWeather(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sXrWeather = str;
    }

    public final void setSXrWeatherKm(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sXrWeatherKm = str;
    }

    public final void setXrDatatrack(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.xrDatatrack = str;
    }

    @NotNull
    public String toString() {
        NetConfigEntity netConfigEntity2 = this.netConfigEntity;
        String str = this.xrDatatrack;
        String str2 = this.sArOta;
        String str3 = this.sAccountService;
        String str4 = this.sMyvuAuth;
        String str5 = this.sNbsSurvey;
        String str6 = this.sXrMenu;
        String str7 = this.sXrWeather;
        String str8 = this.sXrWeatherKm;
        String str9 = this.sWeather;
        String str10 = this.sWeatherKm;
        String str11 = this.sApisix;
        String str12 = this.sApisixKm;
        String str13 = this.feedbackService;
        String str14 = this.cloudAdapterService;
        String str15 = this.cloudCancelService;
        String str16 = this.myvuConfigService;
        String str17 = this.myvuRecordService;
        String str18 = this.myvuFileService;
        return "DetailNetConfigEntity(netConfigEntity=" + netConfigEntity2 + ", xrDatatrack=" + str + ", sArOta=" + str2 + ", sAccountService=" + str3 + ", sMyvuAuth=" + str4 + ", sNbsSurvey=" + str5 + ", sXrMenu=" + str6 + ", sXrWeather=" + str7 + ", sXrWeatherKm=" + str8 + ", sWeather=" + str9 + ", sWeatherKm=" + str10 + ", sApisix=" + str11 + ", sApisixKm=" + str12 + ", feedbackService=" + str13 + ", cloudAdapterService=" + str14 + ", cloudCancelService=" + str15 + ", myvuConfigService=" + str16 + ", myvuRecordService=" + str17 + ", myvuFileService=" + str18 + ")";
    }

    public DetailNetConfigEntity(@Nullable NetConfigEntity netConfigEntity2, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14, @NotNull String str15, @NotNull String str16, @NotNull String str17, @NotNull String str18) {
        String str19 = str;
        String str20 = str2;
        String str21 = str3;
        String str22 = str4;
        String str23 = str5;
        String str24 = str6;
        String str25 = str7;
        String str26 = str8;
        String str27 = str9;
        String str28 = str10;
        String str29 = str11;
        String str30 = str12;
        String str31 = str13;
        String str32 = str14;
        String str33 = str16;
        Intrinsics.checkNotNullParameter(str19, "xrDatatrack");
        Intrinsics.checkNotNullParameter(str20, "sArOta");
        Intrinsics.checkNotNullParameter(str21, "sAccountService");
        Intrinsics.checkNotNullParameter(str22, "sMyvuAuth");
        Intrinsics.checkNotNullParameter(str23, "sNbsSurvey");
        Intrinsics.checkNotNullParameter(str24, "sXrMenu");
        Intrinsics.checkNotNullParameter(str25, "sXrWeather");
        Intrinsics.checkNotNullParameter(str26, "sXrWeatherKm");
        Intrinsics.checkNotNullParameter(str27, "sWeather");
        Intrinsics.checkNotNullParameter(str28, "sWeatherKm");
        Intrinsics.checkNotNullParameter(str29, "sApisix");
        Intrinsics.checkNotNullParameter(str30, "sApisixKm");
        Intrinsics.checkNotNullParameter(str31, "feedbackService");
        Intrinsics.checkNotNullParameter(str32, "cloudAdapterService");
        Intrinsics.checkNotNullParameter(str15, "cloudCancelService");
        Intrinsics.checkNotNullParameter(str16, "myvuConfigService");
        Intrinsics.checkNotNullParameter(str17, "myvuRecordService");
        Intrinsics.checkNotNullParameter(str18, "myvuFileService");
        this.netConfigEntity = netConfigEntity2;
        this.xrDatatrack = str19;
        this.sArOta = str20;
        this.sAccountService = str21;
        this.sMyvuAuth = str22;
        this.sNbsSurvey = str23;
        this.sXrMenu = str24;
        this.sXrWeather = str25;
        this.sXrWeatherKm = str26;
        this.sWeather = str27;
        this.sWeatherKm = str28;
        this.sApisix = str29;
        this.sApisixKm = str30;
        this.feedbackService = str31;
        this.cloudAdapterService = str32;
        this.cloudCancelService = str15;
        this.myvuConfigService = str16;
        this.myvuRecordService = str17;
        this.myvuFileService = str18;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DetailNetConfigEntity(com.upuphone.xr.sapp.config.NetConfigEntity r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, int r40, kotlin.jvm.internal.DefaultConstructorMarker r41) {
        /*
            r20 = this;
            r0 = r40
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r21
        L_0x000a:
            r2 = r0 & 2
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0012
            r2 = r3
            goto L_0x0014
        L_0x0012:
            r2 = r22
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = r3
            goto L_0x001c
        L_0x001a:
            r4 = r23
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0022
            r5 = r3
            goto L_0x0024
        L_0x0022:
            r5 = r24
        L_0x0024:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002a
            r6 = r3
            goto L_0x002c
        L_0x002a:
            r6 = r25
        L_0x002c:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0032
            r7 = r3
            goto L_0x0034
        L_0x0032:
            r7 = r26
        L_0x0034:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003a
            r8 = r3
            goto L_0x003c
        L_0x003a:
            r8 = r27
        L_0x003c:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0042
            r9 = r3
            goto L_0x0044
        L_0x0042:
            r9 = r28
        L_0x0044:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004a
            r10 = r3
            goto L_0x004c
        L_0x004a:
            r10 = r29
        L_0x004c:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0052
            r11 = r3
            goto L_0x0054
        L_0x0052:
            r11 = r30
        L_0x0054:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005a
            r12 = r3
            goto L_0x005c
        L_0x005a:
            r12 = r31
        L_0x005c:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0062
            r13 = r3
            goto L_0x0064
        L_0x0062:
            r13 = r32
        L_0x0064:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006a
            r14 = r3
            goto L_0x006c
        L_0x006a:
            r14 = r33
        L_0x006c:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0072
            r15 = r3
            goto L_0x0074
        L_0x0072:
            r15 = r34
        L_0x0074:
            r21 = r3
            r3 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x007d
            r3 = r21
            goto L_0x007f
        L_0x007d:
            r3 = r35
        L_0x007f:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0089
            r16 = r21
            goto L_0x008b
        L_0x0089:
            r16 = r36
        L_0x008b:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0094
            r17 = r21
            goto L_0x0096
        L_0x0094:
            r17 = r37
        L_0x0096:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009f
            r18 = r21
            goto L_0x00a1
        L_0x009f:
            r18 = r38
        L_0x00a1:
            r19 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r19
            if (r0 == 0) goto L_0x00aa
            r0 = r21
            goto L_0x00ac
        L_0x00aa:
            r0 = r39
        L_0x00ac:
            r21 = r1
            r22 = r2
            r23 = r4
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r8
            r28 = r9
            r29 = r10
            r30 = r11
            r31 = r12
            r32 = r13
            r33 = r14
            r34 = r15
            r35 = r3
            r36 = r16
            r37 = r17
            r38 = r18
            r39 = r0
            r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.config.DetailNetConfigEntity.<init>(com.upuphone.xr.sapp.config.NetConfigEntity, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
