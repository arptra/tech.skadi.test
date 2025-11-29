package com.upuphone.xr.sapp.contract;

import com.honey.account.constant.AccountConstantKt;
import com.meizu.net.pedometerprovider.util.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\u0018\u0000 \u00022\u00020\u0001:\n\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/contract/RegionsEntry;", "", "a", "APP_PP", "APP_UP", "Companion", "GLASS_PP", "GLASS_UP", "RegionsEA", "RegionsEU", "RegionsOS", "RegionsSA", "RegionsZH", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class RegionsEntry {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6705a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/sapp/contract/RegionsEntry$APP_PP;", "", "pp", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getPp", "()Ljava/lang/String;", "ZH_CN", "ZH_INTL", "EN_INTL", "MS_MY", "MY_MM", "VI_VN", "TH_TH", "ID_ID", "FIL_PH", "DE_DE", "FR_FR", "IT_IT", "TR_TR", "KO_KR", "JA_JP", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum APP_PP {
        ZH_CN("privacy_policy.html"),
        ZH_INTL("privacy_policy_oversea_cn.html"),
        EN_INTL("privacy_policy_oversea.html"),
        MS_MY("privacy_policy_oversea_ms.html"),
        MY_MM("privacy_policy_oversea_mm.html"),
        VI_VN("privacy_policy_oversea_vn.html"),
        TH_TH("privacy_policy_oversea_th.html"),
        ID_ID("privacy_policy_oversea_in.html"),
        FIL_PH("privacy_policy_oversea_ph.html"),
        DE_DE("privacy_policy_oversea_de.html"),
        FR_FR("privacy_policy_oversea_fr.html"),
        IT_IT("privacy_policy_oversea_it.html"),
        TR_TR("privacy_policy_oversea_tr.html"),
        KO_KR("privacy_policy_oversea_ko.html"),
        JA_JP("privacy_policy_oversea_ja.html");
        
        @NotNull
        private final String pp;

        static {
            APP_PP[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        private APP_PP(String str) {
            this.pp = str;
        }

        @NotNull
        public static EnumEntries<APP_PP> getEntries() {
            return $ENTRIES;
        }

        @NotNull
        public final String getPp() {
            return this.pp;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/sapp/contract/RegionsEntry$APP_UP;", "", "up", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUp", "()Ljava/lang/String;", "ZH_CN", "ZH_INTL", "EN_INTL", "MS_MY", "MY_MM", "VI_VN", "TH_TH", "ID_ID", "FIL_PH", "DE_DE", "FR_FR", "IT_IT", "TR_TR", "KO_KR", "JA_JP", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum APP_UP {
        ZH_CN("user_protocol.html"),
        ZH_INTL("user_protocol_oversea_cn.html"),
        EN_INTL("user_protocol_oversea.html"),
        MS_MY("user_protocol_oversea_ms.html"),
        MY_MM("user_protocol_oversea_mm.html"),
        VI_VN("user_protocol_oversea_vn.html"),
        TH_TH("user_protocol_oversea_th.html"),
        ID_ID("user_protocol_oversea_in.html"),
        FIL_PH("user_protocol_oversea_ph.html"),
        DE_DE("user_protocol_oversea_de.html"),
        FR_FR("user_protocol_oversea_fr.html"),
        IT_IT("user_protocol_oversea_it.html"),
        TR_TR("user_protocol_oversea_tr.html"),
        KO_KR("user_protocol_oversea_ko.html"),
        JA_JP("user_protocol_oversea_ja.html");
        
        @NotNull
        private final String up;

        static {
            APP_UP[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        private APP_UP(String str) {
            this.up = str;
        }

        @NotNull
        public static EnumEntries<APP_UP> getEntries() {
            return $ENTRIES;
        }

        @NotNull
        public final String getUp() {
            return this.up;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/contract/RegionsEntry$Companion;", "", "()V", "LOCAL_ASSET", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/sapp/contract/RegionsEntry$GLASS_PP;", "", "pp", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getPp", "()Ljava/lang/String;", "ZH_CN", "ZH_INTL", "EN_INTL", "MS_MY", "MY_MM", "VI_VN", "TH_TH", "ID_ID", "FIL_PH", "DE_DE", "FR_FR", "IT_IT", "TR_TR", "KO_KR", "JA_JP", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum GLASS_PP {
        ZH_CN("privacy_policy_glass.html"),
        ZH_INTL("privacy_policy_oversea_glass_cn.html"),
        EN_INTL("privacy_policy_oversea_glass.html"),
        MS_MY("privacy_policy_oversea_glass_ms.html"),
        MY_MM("privacy_policy_oversea_glass_mm.html"),
        VI_VN("privacy_policy_oversea_glass_vn.html"),
        TH_TH("privacy_policy_oversea_glass_th.html"),
        ID_ID("privacy_policy_oversea_glass_in.html"),
        FIL_PH("privacy_policy_oversea_glass_ph.html"),
        DE_DE("privacy_policy_oversea_glass_de.html"),
        FR_FR("privacy_policy_oversea_glass_fr.html"),
        IT_IT("privacy_policy_oversea_glass_it.html"),
        TR_TR("privacy_policy_oversea_glass_tr.html"),
        KO_KR("privacy_policy_oversea_glass_ko.html"),
        JA_JP("privacy_policy_oversea_glass_ja.html");
        
        @NotNull
        private final String pp;

        static {
            GLASS_PP[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        private GLASS_PP(String str) {
            this.pp = str;
        }

        @NotNull
        public static EnumEntries<GLASS_PP> getEntries() {
            return $ENTRIES;
        }

        @NotNull
        public final String getPp() {
            return this.pp;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/sapp/contract/RegionsEntry$GLASS_UP;", "", "up", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUp", "()Ljava/lang/String;", "ZH_CN", "ZH_INTL", "en_INTL", "MS_MY", "MY_MM", "VI_VN", "TH_TH", "ID_ID", "FIL_PH", "DE_DE", "FR_FR", "IT_IT", "TR_TR", "KO_KR", "JA_JP", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum GLASS_UP {
        ZH_CN("user_protocol_glass.html"),
        ZH_INTL("user_protocol_oversea_glass_cn.html"),
        en_INTL("user_protocol_oversea_glass.html"),
        MS_MY("user_protocol_oversea_glass_ms.html"),
        MY_MM("user_protocol_oversea_glass_mm.html"),
        VI_VN("user_protocol_oversea_glass_vn.html"),
        TH_TH("user_protocol_oversea_glass_th.html"),
        ID_ID("user_protocol_oversea_glass_in.html"),
        FIL_PH("user_protocol_oversea_glass_ph.html"),
        DE_DE("user_protocol_oversea_glass_de.html"),
        FR_FR("user_protocol_oversea_glass_fr.html"),
        IT_IT("user_protocol_oversea_glass_it.html"),
        TR_TR("user_protocol_oversea_glass_tr.html"),
        KO_KR("user_protocol_oversea_glass_ko.html"),
        JA_JP("user_protocol_oversea_glass_ja.html");
        
        @NotNull
        private final String up;

        static {
            GLASS_UP[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        private GLASS_UP(String str) {
            this.up = str;
        }

        @NotNull
        public static EnumEntries<GLASS_UP> getEntries() {
            return $ENTRIES;
        }

        @NotNull
        public final String getUp() {
            return this.up;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/contract/RegionsEntry$RegionsEA;", "", "language", "", "region", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getLanguage", "()Ljava/lang/String;", "getRegion", "value", "EN_GB", "EN_US", "TR_TR", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum RegionsEA {
        EN_GB("en", "GB"),
        EN_US("en", "US"),
        TR_TR("tr", "TR");
        
        @NotNull
        private final String language;
        @NotNull
        private final String region;

        static {
            RegionsEA[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        private RegionsEA(String str, String str2) {
            this.language = str;
            this.region = str2;
        }

        @NotNull
        public static EnumEntries<RegionsEA> getEntries() {
            return $ENTRIES;
        }

        @NotNull
        public final String getLanguage() {
            return this.language;
        }

        @NotNull
        public final String getRegion() {
            return this.region;
        }

        @NotNull
        public final String value() {
            String str = this.language;
            String str2 = this.region;
            return str + AccountConstantKt.DEFAULT_SEGMENT + str2;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$¨\u0006%"}, d2 = {"Lcom/upuphone/xr/sapp/contract/RegionsEntry$RegionsEU;", "", "language", "", "region", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getLanguage", "()Ljava/lang/String;", "getRegion", "value", "DE_AT", "FR_BE", "BG_BG", "EL_CY", "HR_HR", "CS_CZ", "DA_DK", "ET_EE", "FI_FI", "FR_FR", "DE_DE", "EL_GR", "HU_HU", "EN_IE", "IT_IT", "LV_LV", "LT_LT", "FR_LU", "EN_MT", "NL_NL", "PL_PL", "PT_PT", "RO_RO", "SK_SK", "SI_SI", "ES_ES", "SV_SE", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum RegionsEU {
        DE_AT("de", "AT"),
        FR_BE("fr", "BE"),
        BG_BG("bg", "BG"),
        EL_CY("el", "CY"),
        HR_HR("hr", "HR"),
        CS_CZ("cs", "CZ"),
        DA_DK("da", "DK"),
        ET_EE("et", "EE"),
        FI_FI("fi", "FI"),
        FR_FR("fr", "FR"),
        DE_DE("de", "DE"),
        EL_GR("el", "GR"),
        HU_HU("hu", "HU"),
        EN_IE("en", "IE"),
        IT_IT("it", "IT"),
        LV_LV("lv", "LV"),
        LT_LT("lt", "LT"),
        FR_LU("fr", "LU"),
        EN_MT("en", "MT"),
        NL_NL("nl", "NL"),
        PL_PL("pl", "PL"),
        PT_PT("pt", "PT"),
        RO_RO("ro", "RO"),
        SK_SK("sk", "SK"),
        SI_SI("si", "SI"),
        ES_ES("es", "ES"),
        SV_SE("sv", "SE");
        
        @NotNull
        private final String language;
        @NotNull
        private final String region;

        static {
            RegionsEU[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        private RegionsEU(String str, String str2) {
            this.language = str;
            this.region = str2;
        }

        @NotNull
        public static EnumEntries<RegionsEU> getEntries() {
            return $ENTRIES;
        }

        @NotNull
        public final String getLanguage() {
            return this.language;
        }

        @NotNull
        public final String getRegion() {
            return this.region;
        }

        @NotNull
        public final String value() {
            String str = this.language;
            String str2 = this.region;
            return str + AccountConstantKt.DEFAULT_SEGMENT + str2;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/sapp/contract/RegionsEntry$RegionsOS;", "", "language", "", "region", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getLanguage", "()Ljava/lang/String;", "getRegion", "value", "EN_US", "MS_MY", "MY_MM", "VI_VN", "KO_KR", "JA_JP", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum RegionsOS {
        EN_US("en", "US"),
        MS_MY("ms", "MY"),
        MY_MM("my", "MM"),
        VI_VN("vi", "VN"),
        KO_KR("ko", "KR"),
        JA_JP("ja", "JP");
        
        @NotNull
        private final String language;
        @NotNull
        private final String region;

        static {
            RegionsOS[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        private RegionsOS(String str, String str2) {
            this.language = str;
            this.region = str2;
        }

        @NotNull
        public static EnumEntries<RegionsOS> getEntries() {
            return $ENTRIES;
        }

        @NotNull
        public final String getLanguage() {
            return this.language;
        }

        @NotNull
        public final String getRegion() {
            return this.region;
        }

        @NotNull
        public final String value() {
            String str = this.language;
            String str2 = this.region;
            return str + AccountConstantKt.DEFAULT_SEGMENT + str2;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/sapp/contract/RegionsEntry$RegionsSA;", "", "language", "", "region", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getLanguage", "()Ljava/lang/String;", "getRegion", "value", "TH_TH", "ID_ID", "IN_ID", "FIL_PH", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum RegionsSA {
        TH_TH("th", "TH"),
        ID_ID("id", "ID"),
        IN_ID("in", "ID"),
        FIL_PH("fil", "PH");
        
        @NotNull
        private final String language;
        @NotNull
        private final String region;

        static {
            RegionsSA[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        private RegionsSA(String str, String str2) {
            this.language = str;
            this.region = str2;
        }

        @NotNull
        public static EnumEntries<RegionsSA> getEntries() {
            return $ENTRIES;
        }

        @NotNull
        public final String getLanguage() {
            return this.language;
        }

        @NotNull
        public final String getRegion() {
            return this.region;
        }

        @NotNull
        public final String value() {
            String str = this.language;
            String str2 = this.region;
            return str + AccountConstantKt.DEFAULT_SEGMENT + str2;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/contract/RegionsEntry$RegionsZH;", "", "language", "", "region", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getLanguage", "()Ljava/lang/String;", "getRegion", "value", "ZH_CN", "ZH_TW", "ZH_HK", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum RegionsZH {
        ZH_CN("zh", Constants.CHINA_COUNTRY),
        ZH_TW("zh", Constants.TW_COUNTRY),
        ZH_HK("zh", "HK");
        
        @NotNull
        private final String language;
        @NotNull
        private final String region;

        static {
            RegionsZH[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        private RegionsZH(String str, String str2) {
            this.language = str;
            this.region = str2;
        }

        @NotNull
        public static EnumEntries<RegionsZH> getEntries() {
            return $ENTRIES;
        }

        @NotNull
        public final String getLanguage() {
            return this.language;
        }

        @NotNull
        public final String getRegion() {
            return this.region;
        }

        @NotNull
        public final String value() {
            String str = this.language;
            String str2 = this.region;
            return str + AccountConstantKt.DEFAULT_SEGMENT + str2;
        }
    }
}
