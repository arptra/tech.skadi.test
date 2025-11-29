package com.upuphone.xr.sapp.contract;

import androidx.annotation.StringRes;
import com.upuphone.xr.sapp.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b$\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(¨\u0006)"}, d2 = {"Lcom/upuphone/xr/sapp/contract/ProtocolType;", "", "bindKey", "", "titleRes", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getBindKey", "()Ljava/lang/String;", "getTitleRes", "()I", "getStoreKey", "CATEGORY_AIUP", "CATEGORY_AIPP", "ACCOUNT_AUP", "ACCOUNT_PP", "ACCOUNT_PCPI", "ACCOUNT_PICL", "ACCOUNT_TISL", "CATEGORY_UP", "CATEGORY_PP", "CATEGORY_PCPI", "CATEGORY_PICL", "CATEGORY_TISL", "CATEGORY_UEIP", "CATEGORY_AIGCIN", "GLASS_STAR_UP", "GLASS_STAR_PP", "GLASS_STAR_PCPI", "GLASS_STAR_PICL", "GLASS_STAR_TISL", "GLASS_AIR_UP", "GLASS_AIR_PP", "GLASS_AIR_PCPI", "GLASS_AIR_PICL", "GLASS_AIR_TISL", "GLASS_VIEW_UP", "GLASS_VIEW_PP", "GLASS_VIEW_PCPI", "GLASS_VIEW_PICL", "GLASS_VIEW_TISL", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum ProtocolType {
    CATEGORY_AIUP("aiup", R.string.assistant_service_agreement),
    CATEGORY_AIPP("aipp", R.string.assistant_privacy_policy),
    ACCOUNT_AUP("aup", R.string.flyme_user_agreement),
    ACCOUNT_PP("pp", R.string.superapp_privacy_policy),
    ACCOUNT_PCPI("pcpi", R.string.about_children_info_protect),
    ACCOUNT_PICL("picl", R.string.account_personal_info_list),
    ACCOUNT_TISL("tisl", R.string.account_third_share_list),
    CATEGORY_UP("up", R.string.glass_service_protocol),
    CATEGORY_PP("pp", R.string.superapp_privacy_policy),
    CATEGORY_PCPI("pcpi", R.string.about_children_info_protect),
    CATEGORY_PICL("picl", R.string.super_app_personal_info_list),
    CATEGORY_TISL("tisl", R.string.super_app_third_share_list),
    CATEGORY_UEIP("ueip", R.string.user_share_title),
    CATEGORY_AIGCIN("aigcin", R.string.algorithm_principles_desp),
    GLASS_STAR_UP("up", R.string.superapp_user_protocol),
    GLASS_STAR_PP("pp", R.string.superapp_privacy_policy),
    GLASS_STAR_PCPI("pcpi", R.string.about_children_info_protect),
    GLASS_STAR_PICL("picl", R.string.account_personal_info_list),
    GLASS_STAR_TISL("tisl", R.string.account_third_share_list),
    GLASS_AIR_UP("up", R.string.superapp_user_protocol),
    GLASS_AIR_PP("pp", R.string.superapp_privacy_policy),
    GLASS_AIR_PCPI("pcpi", R.string.about_children_info_protect),
    GLASS_AIR_PICL("picl", R.string.account_personal_info_list),
    GLASS_AIR_TISL("tisl", R.string.account_third_share_list),
    GLASS_VIEW_UP("up", R.string.superapp_user_protocol),
    GLASS_VIEW_PP("pp", R.string.superapp_privacy_policy),
    GLASS_VIEW_PCPI("pcpi", R.string.about_children_info_protect),
    GLASS_VIEW_PICL("picl", R.string.account_personal_info_list),
    GLASS_VIEW_TISL("tisl", R.string.account_third_share_list);
    
    @NotNull
    private final String bindKey;
    private final int titleRes;

    static {
        ProtocolType[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
    }

    private ProtocolType(String str, @StringRes int i) {
        this.bindKey = str;
        this.titleRes = i;
    }

    @NotNull
    public static EnumEntries<ProtocolType> getEntries() {
        return $ENTRIES;
    }

    @NotNull
    public final String getBindKey() {
        return this.bindKey;
    }

    @NotNull
    public final String getStoreKey() {
        String lowerCase = name().toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return "privacy_" + lowerCase;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }
}
