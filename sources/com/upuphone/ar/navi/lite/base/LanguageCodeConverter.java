package com.upuphone.ar.navi.lite.base;

import android.util.Log;
import com.here.sdk.core.LanguageCode;
import com.meizu.net.pedometerprovider.util.Constants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LanguageCodeConverter {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5656a = ("NAVI-" + LanguageCodeConverter.class.getSimpleName());
    public static HashMap b;

    public static LanguageCode a(Locale locale) {
        if (b == null) {
            b();
        }
        String language = locale.getLanguage();
        locale.getCountry();
        for (Map.Entry entry : b.entrySet()) {
            Locale locale2 = (Locale) entry.getValue();
            String language2 = locale2.getLanguage();
            locale2.getCountry();
            if (language.equals(language2)) {
                return (LanguageCode) entry.getKey();
            }
        }
        Log.e(f5656a, "LanguageCode not found. Falling back to EN_US.");
        return LanguageCode.EN_US;
    }

    public static void b() {
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put(LanguageCode.EN_US, new Locale("en", "US"));
        b.put(LanguageCode.AF_ZA, new Locale("af", "ZA"));
        b.put(LanguageCode.SQ_AL, new Locale("sq", "AL"));
        b.put(LanguageCode.AM_ET, new Locale("am", "ET"));
        b.put(LanguageCode.AR_SA, new Locale("ar"));
        b.put(LanguageCode.HY_AM, new Locale("hy", "AM"));
        b.put(LanguageCode.AS_IN, new Locale("as", "IN"));
        b.put(LanguageCode.AZ_LATN_AZ, new Locale("az", "LATN_AZ"));
        b.put(LanguageCode.BN_BD, new Locale("bn", "BD"));
        b.put(LanguageCode.BN_IN, new Locale("bn", "IN"));
        b.put(LanguageCode.EU_ES, new Locale("eu", "ES"));
        b.put(LanguageCode.BE_BY, new Locale("be", "BY"));
        b.put(LanguageCode.BS_LATN_BA, new Locale("bs", "LATN_BA"));
        b.put(LanguageCode.BG_BG, new Locale("bg", "BG"));
        b.put(LanguageCode.CA_ES, new Locale("ca", "ES"));
        b.put(LanguageCode.KU_ARAB, new Locale("ku", "ARAB"));
        b.put(LanguageCode.ZH_CN, new Locale("zh", Constants.CHINA_COUNTRY));
        b.put(LanguageCode.ZH_HK, new Locale("zh", "HK"));
        b.put(LanguageCode.ZH_TW, new Locale("zh", Constants.TW_COUNTRY));
        b.put(LanguageCode.HR_HR, new Locale("hr", "HR"));
        b.put(LanguageCode.CS_CZ, new Locale("cs", "CZ"));
        b.put(LanguageCode.DA_DK, new Locale("da", "DK"));
        b.put(LanguageCode.PRS_ARAB_AF, new Locale("prs", "ARAB_AF"));
        b.put(LanguageCode.NL_NL, new Locale("nl", "NL"));
        b.put(LanguageCode.EN_GB, new Locale("en", "GB"));
        b.put(LanguageCode.ET_EE, new Locale("et", "EE"));
        b.put(LanguageCode.FA_IR, new Locale("fa", "IR"));
        b.put(LanguageCode.FIL_PH, new Locale("fil", "PH"));
        b.put(LanguageCode.FI_FI, new Locale("fi", "FI"));
        b.put(LanguageCode.FR_FR, new Locale("fr", "FR"));
        b.put(LanguageCode.FR_CA, new Locale("fr", "CA"));
        b.put(LanguageCode.GL_ES, new Locale("gl", "ES"));
        b.put(LanguageCode.KA_GE, new Locale("ka", "GE"));
        b.put(LanguageCode.DE_DE, new Locale("de", "DE"));
        b.put(LanguageCode.EL_GR, new Locale("el", "GR"));
        b.put(LanguageCode.GU_IN, new Locale("gu", "IN"));
        b.put(LanguageCode.HA_LATN_NG, new Locale("ha", "LATN_NG"));
        b.put(LanguageCode.HE_IL, new Locale("he", "IL"));
        b.put(LanguageCode.HI_IN, new Locale("hi", "IN"));
        b.put(LanguageCode.HU_HU, new Locale("hu", "HU"));
        b.put(LanguageCode.IS_IS, new Locale("is", "IS"));
        b.put(LanguageCode.IG_LATN_NG, new Locale("ig", "LATN_NG"));
        b.put(LanguageCode.ID_ID, new Locale("id", "ID"));
        b.put(LanguageCode.GA_IE, new Locale("ga", "IE"));
        b.put(LanguageCode.XH, new Locale("xh"));
        b.put(LanguageCode.ZU_ZA, new Locale("zu", "ZA"));
        b.put(LanguageCode.IT_IT, new Locale("it", "IT"));
        b.put(LanguageCode.JA_JP, new Locale("ja", "JP"));
        b.put(LanguageCode.KN_IN, new Locale("kn", "IN"));
        b.put(LanguageCode.KK_KZ, new Locale("kk", "KZ"));
        b.put(LanguageCode.KM_KH, new Locale("km", "KH"));
        b.put(LanguageCode.QUC_LATN_GT, new Locale("quc", "LATN_GT"));
        b.put(LanguageCode.RW_RW, new Locale("rw", "RW"));
        b.put(LanguageCode.SW, new Locale("sw"));
        b.put(LanguageCode.KOK_IN, new Locale("kok", "IN"));
        b.put(LanguageCode.KO_KR, new Locale("ko", "KR"));
        b.put(LanguageCode.KY_CYRL_KG, new Locale("ky", "CYRL_KG"));
        b.put(LanguageCode.LV_LV, new Locale("lv", "LV"));
        b.put(LanguageCode.LT_LT, new Locale("lt", "LT"));
        b.put(LanguageCode.LB_LU, new Locale("lb", "LU"));
        b.put(LanguageCode.MK_MK, new Locale("mk", "MK"));
        b.put(LanguageCode.MS_MY, new Locale("ms", "MY"));
        b.put(LanguageCode.ML_IN, new Locale("ml", "IN"));
        b.put(LanguageCode.MT_MT, new Locale("mt", "MT"));
        b.put(LanguageCode.MI_LATN_NZ, new Locale("mi", "LATN_NZ"));
        b.put(LanguageCode.MR_IN, new Locale("mr", "IN"));
        b.put(LanguageCode.MN_CYRL_MN, new Locale("mn", "CYRL_MN"));
        b.put(LanguageCode.NE_NP, new Locale("ne", "NP"));
        b.put(LanguageCode.NB_NO, new Locale("nb", "NO"));
        b.put(LanguageCode.NN_NO, new Locale("nn", "NO"));
        b.put(LanguageCode.OR_IN, new Locale("or", "IN"));
        b.put(LanguageCode.PL_PL, new Locale("pl", "PL"));
        b.put(LanguageCode.PT_BR, new Locale("pt", "BR"));
        b.put(LanguageCode.PT_PT, new Locale("pt", "PT"));
        b.put(LanguageCode.PA_GURU, new Locale("pa", "GURU"));
        b.put(LanguageCode.PA_ARAB, new Locale("pa", "ARAB"));
        b.put(LanguageCode.QU_LATN_PE, new Locale("qu", "LATN_PE"));
        b.put(LanguageCode.RO_RO, new Locale("ro", "RO"));
        b.put(LanguageCode.RU_RU, new Locale("ru", "RU"));
        b.put(LanguageCode.GD_LATN_GB, new Locale("gd", "LATN_GB"));
        b.put(LanguageCode.SR_CYRL_BA, new Locale("sr", "CYRL_BA"));
        b.put(LanguageCode.SR_CYRL_RS, new Locale("sr", "CYRL_RS"));
        b.put(LanguageCode.SR_LATN_RS, new Locale("sr", "LATN_RS"));
        b.put(LanguageCode.NSO_ZA, new Locale("nso", "ZA"));
        b.put(LanguageCode.TN, new Locale("tn"));
        b.put(LanguageCode.SD_ARAB, new Locale("sd", "ARAB"));
        b.put(LanguageCode.SI_LK, new Locale("si", "LK"));
        b.put(LanguageCode.SK_SK, new Locale("sk", "SK"));
        b.put(LanguageCode.SL_SI, new Locale("sl", "SI"));
        b.put(LanguageCode.ES_MX, new Locale("es", "MX"));
        b.put(LanguageCode.ES_ES, new Locale("es", "ES"));
        b.put(LanguageCode.SV_SE, new Locale("sv", "SE"));
        b.put(LanguageCode.TG_CYRL_TJ, new Locale("tg", "CYRL_TJ"));
        b.put(LanguageCode.TA, new Locale("ta"));
        b.put(LanguageCode.TT_CYRL_RU, new Locale("tt", "CYRL_RU"));
        b.put(LanguageCode.TE_IN, new Locale("te", "IN"));
        b.put(LanguageCode.TH_TH, new Locale("th", "TH"));
        b.put(LanguageCode.TI_ET, new Locale("ti", "ET"));
        b.put(LanguageCode.TR_TR, new Locale("tr", "TR"));
        b.put(LanguageCode.TK_LATN_TM, new Locale("tk", "LATN_TM"));
        b.put(LanguageCode.UK_UA, new Locale("uk", "UA"));
        b.put(LanguageCode.UR, new Locale("ur"));
        b.put(LanguageCode.UG_ARAB, new Locale("ug", "ARAB"));
        b.put(LanguageCode.UZ_CYRL_UZ, new Locale("uz", "CYRL_UZ"));
        b.put(LanguageCode.UZ_LATN_UZ, new Locale("uz", "LATN_UZ"));
        b.put(LanguageCode.CAT_ES, new Locale("cat", "ES"));
        b.put(LanguageCode.VI_VN, new Locale("vi", "VN"));
        b.put(LanguageCode.CY_GB, new Locale("cy", "GB"));
        b.put(LanguageCode.WO_LATN, new Locale("wo", "LATN"));
        b.put(LanguageCode.YO_LATN, new Locale("yo", "LATN"));
    }
}
