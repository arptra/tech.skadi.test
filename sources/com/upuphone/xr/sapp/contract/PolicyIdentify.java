package com.upuphone.xr.sapp.contract;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/contract/PolicyIdentify;", "", "PHONE_INTL", "PHONE_MARS", "PHONE_THIRD", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PolicyIdentify {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/contract/PolicyIdentify$PHONE_INTL;", "", "language", "", "md5", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getLanguage", "()Ljava/lang/String;", "getMd5", "ZH_MD5", "EN_MD5", "MS_MD5", "MY_MD5", "VI_MD5", "TH_MD5", "ID_MD5", "FIL_MD5", "FR_MD5", "DE_MD5", "IT_MD5", "TR_MD5", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum PHONE_INTL {
        ZH_MD5("zh", "62c19b5c4f8755b94e0feb59c5ffcc03"),
        EN_MD5("en", "54b189c67b17d6536e60a68904652c34"),
        MS_MD5("ms", "d086448e57dac050332c91244d6d45e3"),
        MY_MD5("my", "54b189c67b17d6536e60a68904652c34"),
        VI_MD5("vi", "e023826ca9d7491f7b02b666c4c74a9f"),
        TH_MD5("th", "69733419dacb4189e7db2866defc95f3"),
        ID_MD5("id", "8d924ffccb5be630b9ce807f65675e2d"),
        FIL_MD5("fil", "54b189c67b17d6536e60a68904652c34"),
        FR_MD5("fr", "8b00f1acb78015ded3493a5b61e829b6"),
        DE_MD5("de", "199afa0588f440afc5784da94ad1a2c3"),
        IT_MD5("it", "7b691671a6e5de683dec4cf885d098a2"),
        TR_MD5("tr", "56e0c4871f03a63afb1b8a4dc605df84");
        
        @NotNull
        private final String language;
        @NotNull
        private final String md5;

        static {
            PHONE_INTL[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        private PHONE_INTL(String str, String str2) {
            this.language = str;
            this.md5 = str2;
        }

        @NotNull
        public static EnumEntries<PHONE_INTL> getEntries() {
            return $ENTRIES;
        }

        @NotNull
        public final String getLanguage() {
            return this.language;
        }

        @NotNull
        public final String getMd5() {
            return this.md5;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/contract/PolicyIdentify$PHONE_MARS;", "", "language", "", "md5", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getLanguage", "()Ljava/lang/String;", "getMd5", "ZH_MD5", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum PHONE_MARS {
        ZH_MD5("zh", "f5a17b6b75ab65c1ab6a64c2389b9af2");
        
        @NotNull
        private final String language;
        @NotNull
        private final String md5;

        static {
            PHONE_MARS[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        private PHONE_MARS(String str, String str2) {
            this.language = str;
            this.md5 = str2;
        }

        @NotNull
        public static EnumEntries<PHONE_MARS> getEntries() {
            return $ENTRIES;
        }

        @NotNull
        public final String getLanguage() {
            return this.language;
        }

        @NotNull
        public final String getMd5() {
            return this.md5;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/contract/PolicyIdentify$PHONE_THIRD;", "", "language", "", "md5", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getLanguage", "()Ljava/lang/String;", "getMd5", "ZH_MD5", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum PHONE_THIRD {
        ZH_MD5("zh", "f5a17b6b75ab65c1ab6a64c2389b9af2");
        
        @NotNull
        private final String language;
        @NotNull
        private final String md5;

        static {
            PHONE_THIRD[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        private PHONE_THIRD(String str, String str2) {
            this.language = str;
            this.md5 = str2;
        }

        @NotNull
        public static EnumEntries<PHONE_THIRD> getEntries() {
            return $ENTRIES;
        }

        @NotNull
        public final String getLanguage() {
            return this.language;
        }

        @NotNull
        public final String getMd5() {
            return this.md5;
        }
    }
}
