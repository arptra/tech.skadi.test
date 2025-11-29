package com.honey.account.bridge;

import android.text.TextUtils;
import android.util.Pair;
import com.honey.account.c2.a;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.utils.encrypt.Base64Coder;
import com.honey.account.utils.encrypt.Base64Encoder;
import com.honey.account.utils.encrypt.MD5Kt;
import com.honey.account.utils.encrypt.XORUtil;
import com.honey.account.utils.log.LogUtils;
import com.meizu.common.util.LunarCalendar;
import com.meizu.common.widget.MzContactsContract;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public final class OAuthManager {
    private static final String TAG = "OAuthManager";
    private static final String UTF_8_CODE = "UTF-8";
    private static final Comparator<Pair<String, String>> mConparator = new a();

    private static String constructRequestURL(String str) {
        int indexOf = str.indexOf("?");
        if (-1 != indexOf) {
            str = str.substring(0, indexOf);
        }
        int indexOf2 = str.indexOf("/", 8);
        String lowerCase = str.substring(0, indexOf2).toLowerCase(Locale.US);
        int indexOf3 = lowerCase.indexOf(AccountConstantKt.CODE_SEPARTOR, 8);
        if (-1 != indexOf3) {
            if (lowerCase.startsWith("http://") && lowerCase.endsWith(":80")) {
                lowerCase = lowerCase.substring(0, indexOf3);
            } else if (lowerCase.startsWith("https://") && lowerCase.endsWith(":443")) {
                lowerCase = lowerCase.substring(0, indexOf3);
            }
        }
        return lowerCase + str.substring(indexOf2);
    }

    private static String encode(String str) {
        String str2;
        int i;
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            str2 = null;
        }
        StringBuffer stringBuffer = new StringBuffer(str2.length());
        int i2 = 0;
        while (i2 < str2.length()) {
            char charAt = str2.charAt(i2);
            if (charAt == '*') {
                stringBuffer.append("%2A");
            } else if (charAt == '+') {
                stringBuffer.append("%20");
            } else {
                if (charAt == '%' && (i = i2 + 1) < str2.length() && str2.charAt(i) == '7') {
                    int i3 = i2 + 2;
                    if (str2.charAt(i3) == 'E') {
                        stringBuffer.append('~');
                        i2 = i3;
                    }
                }
                stringBuffer.append(charAt);
            }
            i2++;
        }
        return stringBuffer.toString();
    }

    private static String encodeParameters(List<Pair<String, String>> list, String str, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Pair next : list) {
                if (stringBuffer.length() != 0) {
                    if (z) {
                        stringBuffer.append("\"");
                    }
                    stringBuffer.append(str);
                }
                stringBuffer.append(encode((String) next.first));
                stringBuffer.append("=");
                if (z) {
                    stringBuffer.append("\"");
                }
                stringBuffer.append(encode((String) next.second));
            }
            if (stringBuffer.length() != 0 && z) {
                stringBuffer.append("\"");
            }
        } catch (Exception e) {
            LogUtils logUtils = LogUtils.INSTANCE;
            logUtils.e(TAG, "[] error = " + e.getMessage());
        }
        return stringBuffer.toString();
    }

    private static String generateAuthorizationHeader(String str, String str2, String str3, String str4, List<Pair<String, String>> list, String str5, String str6) {
        if (list == null) {
            list = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("oauth_consumer_key", str));
        arrayList.add(new Pair("oauth_signature_method", MessageDigestAlgorithms.MD5));
        arrayList.add(new Pair("oauth_timestamp", str6));
        arrayList.add(new Pair("oauth_nonce", str5));
        arrayList.add(new Pair("oauth_version", "1.0"));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        arrayList2.addAll(list);
        parseGetParameters(str4, arrayList2);
        StringBuffer stringBuffer = new StringBuffer(str3);
        stringBuffer.append("&");
        stringBuffer.append(encode(constructRequestURL(str4)));
        stringBuffer.append("&");
        Collections.sort(arrayList2, mConparator);
        stringBuffer.append(encode(encodeParameters(arrayList2, "&", false)));
        arrayList.add(new Pair("oauth_signature", generateSignature(str2, stringBuffer.toString())));
        return "OAuth " + encodeParameters(arrayList, MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA, true);
    }

    private static String generateSignature(String str, String str2) {
        return Base64Coder.encode2String(MD5Kt.MD5Encode((str2 + ("&" + encode(str) + "&")).getBytes()));
    }

    public static String getAuthorization(String str, String str2, String str3, boolean z, HashMap<String, String> hashMap) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long nextInt = ((long) new Random().nextInt()) + currentTimeMillis;
        ArrayList arrayList = new ArrayList();
        for (String next : hashMap.keySet()) {
            arrayList.add(new Pair(next, hashMap.get(next)));
        }
        return generateAuthorizationHeader(str2, str3, z ? "POST" : "GET", str, arrayList, String.valueOf(nextInt), String.valueOf(currentTimeMillis));
    }

    public static Pair<String, String> getXSValue(String str) {
        String[] strArr = {String.valueOf(randomInt(10000000)), String.valueOf(randomInt(10000000))};
        return new Pair<>(Base64Encoder.encode((strArr[0] + LunarCalendar.DATE_SEPARATOR + strArr[1]).getBytes()), XORUtil.EncryptBySeeds(str, strArr));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(Pair pair, Pair pair2) {
        if (TextUtils.isEmpty((CharSequence) pair.first)) {
            return -1;
        }
        int compareTo = ((String) pair.first).compareTo((String) pair2.first);
        if (compareTo != 0) {
            return compareTo;
        }
        if (TextUtils.isEmpty((CharSequence) pair.second)) {
            return -1;
        }
        return ((String) pair.second).compareTo((String) pair2.second);
    }

    private static void parseGetParameters(String str, List<Pair<String, String>> list) {
        int indexOf = str.indexOf("?");
        if (-1 != indexOf) {
            try {
                for (String split : str.substring(indexOf + 1).split("&")) {
                    String[] split2 = split.split("=");
                    if (split2.length == 2) {
                        list.add(new Pair(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8")));
                    } else {
                        list.add(new Pair(URLDecoder.decode(split2[0], "UTF-8"), ""));
                    }
                }
            } catch (UnsupportedEncodingException | Exception unused) {
            }
        }
    }

    public static int randomInt(int i) {
        return new Random().nextInt(i);
    }
}
