package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.honey.account.constant.AccountConstantKt;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.bb;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class H5JavaScriptInterface {

    /* renamed from: a  reason: collision with root package name */
    private static HashSet<Integer> f9509a = new HashSet<>();
    private String b = null;
    private Thread c = null;
    private String d = null;
    private Map<String, String> e = null;

    private H5JavaScriptInterface() {
    }

    private static bb a(String str) {
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                bb bbVar = new bb();
                String string = jSONObject.getString("projectRoot");
                bbVar.f9560a = string;
                if (string == null) {
                    return null;
                }
                String string2 = jSONObject.getString("context");
                bbVar.b = string2;
                if (string2 == null) {
                    return null;
                }
                String string3 = jSONObject.getString("url");
                bbVar.c = string3;
                if (string3 == null) {
                    return null;
                }
                String string4 = jSONObject.getString("userAgent");
                bbVar.d = string4;
                if (string4 == null) {
                    return null;
                }
                String string5 = jSONObject.getString("language");
                bbVar.e = string5;
                if (string5 == null) {
                    return null;
                }
                String string6 = jSONObject.getString("name");
                bbVar.f = string6;
                if (string6 != null) {
                    if (!string6.equals("null")) {
                        String string7 = jSONObject.getString("stacktrace");
                        if (string7 == null) {
                            return null;
                        }
                        int indexOf = string7.indexOf(StringUtils.LF);
                        if (indexOf < 0) {
                            al.d("H5 crash stack's format is wrong!", new Object[0]);
                            return null;
                        }
                        bbVar.h = string7.substring(indexOf + 1);
                        String substring = string7.substring(0, indexOf);
                        bbVar.g = substring;
                        int indexOf2 = substring.indexOf(AccountConstantKt.CODE_SEPARTOR);
                        if (indexOf2 > 0) {
                            bbVar.g = bbVar.g.substring(indexOf2 + 1);
                        }
                        bbVar.i = jSONObject.getString("file");
                        if (bbVar.f == null) {
                            return null;
                        }
                        long j = jSONObject.getLong("lineNumber");
                        bbVar.j = j;
                        if (j < 0) {
                            return null;
                        }
                        long j2 = jSONObject.getLong("columnNumber");
                        bbVar.k = j2;
                        if (j2 < 0) {
                            return null;
                        }
                        al.a("H5 crash information is following: ", new Object[0]);
                        al.a("[projectRoot]: " + bbVar.f9560a, new Object[0]);
                        al.a("[context]: " + bbVar.b, new Object[0]);
                        al.a("[url]: " + bbVar.c, new Object[0]);
                        al.a("[userAgent]: " + bbVar.d, new Object[0]);
                        al.a("[language]: " + bbVar.e, new Object[0]);
                        al.a("[name]: " + bbVar.f, new Object[0]);
                        al.a("[message]: " + bbVar.g, new Object[0]);
                        al.a("[stacktrace]: \n" + bbVar.h, new Object[0]);
                        al.a("[file]: " + bbVar.i, new Object[0]);
                        al.a("[lineNumber]: " + bbVar.j, new Object[0]);
                        al.a("[columnNumber]: " + bbVar.k, new Object[0]);
                        return bbVar;
                    }
                }
                return null;
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static H5JavaScriptInterface getInstance(CrashReport.a aVar) {
        String str = null;
        if (aVar == null || f9509a.contains(Integer.valueOf(aVar.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f9509a.add(Integer.valueOf(aVar.hashCode()));
        Thread currentThread = Thread.currentThread();
        h5JavaScriptInterface.c = currentThread;
        if (currentThread != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(StringUtils.LF);
            for (int i = 2; i < currentThread.getStackTrace().length; i++) {
                StackTraceElement stackTraceElement = currentThread.getStackTrace()[i];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    sb.append(stackTraceElement.toString());
                    sb.append(StringUtils.LF);
                }
            }
            str = sb.toString();
        }
        h5JavaScriptInterface.d = str;
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(aVar.c());
        hashMap.put("[WebView] ContentDescription", sb2.toString());
        h5JavaScriptInterface.e = hashMap;
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        al.d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            al.d("Payload from JS is null.", new Object[0]);
            return;
        }
        String c2 = ap.c(str.getBytes());
        String str2 = this.b;
        if (str2 == null || !str2.equals(c2)) {
            this.b = c2;
            al.d("Handling JS exception ...", new Object[0]);
            bb a2 = a(str);
            if (a2 == null) {
                al.d("Failed to parse payload.", new Object[0]);
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            String str3 = a2.f9560a;
            if (str3 != null) {
                linkedHashMap2.put("[JS] projectRoot", str3);
            }
            String str4 = a2.b;
            if (str4 != null) {
                linkedHashMap2.put("[JS] context", str4);
            }
            String str5 = a2.c;
            if (str5 != null) {
                linkedHashMap2.put("[JS] url", str5);
            }
            String str6 = a2.d;
            if (str6 != null) {
                linkedHashMap2.put("[JS] userAgent", str6);
            }
            String str7 = a2.i;
            if (str7 != null) {
                linkedHashMap2.put("[JS] file", str7);
            }
            long j = a2.j;
            if (j != 0) {
                linkedHashMap2.put("[JS] lineNumber", Long.toString(j));
            }
            linkedHashMap.putAll(linkedHashMap2);
            linkedHashMap.putAll(this.e);
            linkedHashMap.put("Java Stack", this.d);
            InnerApi.postH5CrashAsync(this.c, a2.f, a2.g, a2.h, linkedHashMap);
            return;
        }
        al.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
    }
}
