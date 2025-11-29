package com.upuphone.xr.sapp.vu.arspace;

import android.content.SharedPreferences;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001c\u0010\u0018J\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001e\u0010\u0013J\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001f\u0010\u0016J\u000f\u0010 \u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010\u0018J\u0017\u0010!\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\tH\u0002¢\u0006\u0004\b!\u0010\u001bJ\u000f\u0010\"\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\"\u0010\u0013J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b#\u0010\u0016J)\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020%2\u0006\u0010*\u001a\u00020%H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020%2\u0006\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\u0004¢\u0006\u0004\b3\u0010\u0003R\u0014\u00107\u001a\u0002048\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010ER\u0016\u0010J\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010ER\u001c\u0010O\u001a\n L*\u0004\u0018\u00010K0K8\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006P"}, d2 = {"Lcom/upuphone/xr/sapp/vu/arspace/WebsiteBlackListHelper;", "", "<init>", "()V", "", "s", "M", "", "type", "", "N", "(I)Z", "q", "r", "K", "J", "L", "", "x", "()J", "time", "I", "(J)V", "B", "()Z", "success", "H", "(Z)V", "z", "D", "v", "E", "A", "F", "w", "G", "pageNum", "", "url", "Lorg/json/JSONArray;", "y", "(ILjava/lang/String;I)Lorg/json/JSONArray;", "str", "C", "(Ljava/lang/String;)Ljava/lang/String;", "", "bytes", "p", "([B)Ljava/lang/String;", "u", "(Ljava/lang/String;)I", "t", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lcom/upuphone/xr/sapp/vu/arspace/WebsiteBlackListDatabaseHelper;", "c", "Lcom/upuphone/xr/sapp/vu/arspace/WebsiteBlackListDatabaseHelper;", "database", "Ljava/security/MessageDigest;", "d", "Ljava/security/MessageDigest;", "digest", "Lokhttp3/OkHttpClient;", "e", "Lokhttp3/OkHttpClient;", "okhttpClient", "f", "Z", "isIncrementUpdating", "g", "isCompleteBlackUpdating", "h", "isCompleteDangerUpdating", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "i", "Landroid/content/SharedPreferences;", "sp", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class WebsiteBlackListHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final WebsiteBlackListHelper f8056a = new WebsiteBlackListHelper();
    public static final CoroutineScope b = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    public static final WebsiteBlackListDatabaseHelper c;
    public static final MessageDigest d;
    public static final OkHttpClient e = new OkHttpClient();
    public static boolean f;
    public static boolean g;
    public static boolean h;
    public static final SharedPreferences i;

    static {
        MainApplication.Companion companion = MainApplication.k;
        c = new WebsiteBlackListDatabaseHelper(companion.f());
        MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
        d = instance;
        i = companion.f().getSharedPreferences("blacklist", 0);
    }

    public final boolean A() {
        return i.getBoolean("is_last_complete_danger_update_success", false);
    }

    public final boolean B() {
        return i.getBoolean("last_increment_update_success", false);
    }

    public final String C(String str) {
        MessageDigest messageDigest = d;
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] digest = messageDigest.digest(bytes);
        Intrinsics.checkNotNull(digest);
        return p(digest);
    }

    public final void D(boolean z) {
        i.edit().putBoolean("is_last_complete_black_update_success", z).apply();
    }

    public final void E(long j) {
        i.edit().putLong("last_complete_black_update_time", j).apply();
    }

    public final void F(boolean z) {
        i.edit().putBoolean("is_last_complete_danger_update_success", z).apply();
    }

    public final void G(long j) {
        i.edit().putLong("last_complete_danger_update_time", j).apply();
    }

    public final void H(boolean z) {
        i.edit().putBoolean("last_increment_update_success", z).apply();
    }

    public final void I(long j) {
        i.edit().putLong("last_increment_update_time", j).apply();
    }

    public final void J() {
        ULog.f6446a.g("WebsiteBlackListHelper", "updateCompleteBlack: ");
        Job unused = BuildersKt__Builders_commonKt.d(b, (CoroutineContext) null, (CoroutineStart) null, new WebsiteBlackListHelper$updateCompleteBlack$1((Continuation<? super WebsiteBlackListHelper$updateCompleteBlack$1>) null), 3, (Object) null);
    }

    public final void K() {
        ULog.f6446a.g("WebsiteBlackListHelper", "updateCompleteDanger: ");
        Job unused = BuildersKt__Builders_commonKt.d(b, (CoroutineContext) null, (CoroutineStart) null, new WebsiteBlackListHelper$updateCompleteDanger$1((Continuation<? super WebsiteBlackListHelper$updateCompleteDanger$1>) null), 3, (Object) null);
    }

    public final boolean L(int i2) {
        int i3 = 1;
        while (true) {
            JSONArray y = y(i3, "https://bro.flyme.cn/ar/listFull", i2);
            ULog.f6446a.g("WebsiteBlackListHelper", "updateCompleteType:type: " + i2 + ", page: " + i3 + ", " + (y != null ? Integer.valueOf(y.length()) : null));
            if (y == null) {
                return false;
            }
            if (y.length() == 0) {
                return true;
            }
            c.u(y, i2);
            i3++;
        }
    }

    public final void M() {
        ULog.f6446a.g("WebsiteBlackListHelper", "updateIncrement: ");
        Job unused = BuildersKt__Builders_commonKt.d(b, (CoroutineContext) null, (CoroutineStart) null, new WebsiteBlackListHelper$updateIncrement$1((Continuation<? super WebsiteBlackListHelper$updateIncrement$1>) null), 3, (Object) null);
    }

    public final boolean N(int i2) {
        int i3 = 1;
        while (true) {
            JSONArray y = y(i3, "https://bro.flyme.cn/ar/listIncr", i2);
            ULog.f6446a.g("WebsiteBlackListHelper", "updateIncrementType:type: " + i2 + ", page: " + i3 + ", " + (y != null ? Integer.valueOf(y.length()) : null));
            if (y == null) {
                return false;
            }
            if (y.length() == 0) {
                return true;
            }
            c.v(y, i2);
            i3++;
        }
    }

    public final String p(byte[] bArr) {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        char[] cArr = new char[(bArr.length * 2)];
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            byte b2 = bArr[i2];
            int i3 = i2 * 2;
            cArr[i3] = charArray[(b2 & 255) >>> 4];
            cArr[i3 + 1] = charArray[b2 & 15];
        }
        return new String(cArr);
    }

    public final void q() {
        if (g) {
            ULog.f6446a.g("WebsiteBlackListHelper", "checkCompleteBlackUpdate: isCompleteBlackUpdating");
            return;
        }
        boolean z = true;
        if (z() && System.currentTimeMillis() - v() <= 172800000) {
            z = false;
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("WebsiteBlackListHelper", "checkCompleteBlackUpdate: " + z);
        if (z) {
            J();
        }
    }

    public final void r() {
        if (h) {
            ULog.f6446a.g("WebsiteBlackListHelper", "checkCompleteDangerUpdate: isCompleteDangerUpdating");
            return;
        }
        boolean z = true;
        if (A() && System.currentTimeMillis() - w() <= 172800000) {
            z = false;
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("WebsiteBlackListHelper", "checkCompleteDangerUpdate: " + z);
        if (z) {
            K();
        }
    }

    public final void s() {
        if (f) {
            ULog.f6446a.g("WebsiteBlackListHelper", "checkIncrementUpdate: isIncrementUpdating");
            return;
        }
        boolean z = true;
        if (B() && System.currentTimeMillis() - x() <= 3600000) {
            z = false;
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("WebsiteBlackListHelper", "checkIncrementUpdate: " + z);
        if (z) {
            M();
        }
    }

    public final void t() {
        Job unused = BuildersKt__Builders_commonKt.d(b, (CoroutineContext) null, (CoroutineStart) null, new WebsiteBlackListHelper$checkUpdate$1((Continuation<? super WebsiteBlackListHelper$checkUpdate$1>) null), 3, (Object) null);
    }

    public final int u(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        try {
            int g2 = c.g(str);
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("WebsiteBlackListHelper", "query: " + str + ", " + g2);
            return g2;
        } catch (Exception e2) {
            e2.printStackTrace();
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.g("WebsiteBlackListHelper", "query: " + str + ", -1");
            Job unused = BuildersKt__Builders_commonKt.d(b, (CoroutineContext) null, (CoroutineStart) null, new WebsiteBlackListHelper$checkUrl$1((Continuation<? super WebsiteBlackListHelper$checkUrl$1>) null), 3, (Object) null);
            return -1;
        }
    }

    public final long v() {
        return i.getLong("last_complete_black_update_time", 0);
    }

    public final long w() {
        return i.getLong("last_complete_danger_update_time", 0);
    }

    public final long x() {
        return i.getLong("last_increment_update_time", 0);
    }

    public final JSONArray y(int i2, String str, int i3) {
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        String C = C("pageNum=" + i2 + "&ts=" + currentTimeMillis + ":0afFy0Qwawgqe8Vro7sOc1mnmcJAlpKsmi2f0uWDlyYoxK2eLvWUfkIiLavPusLrZlWdP5LPsVkvK3bzK3AJDyqCvPfl8IRDHaGF6rWNbGatUoNYPJXUmnWFSLqNzIAB");
        int i4 = 3;
        while (i4 > 0) {
            try {
                ResponseBody body = e.newCall(new Request.Builder().url(str).post(new FormBody.Builder((Charset) null, 1, (DefaultConstructorMarker) null).add("pageNum", String.valueOf(i2)).add("ts", String.valueOf(currentTimeMillis)).add("dataType", String.valueOf(i3)).add(AccountConstantKt.REQUEST_HEADER_SIGN, C).build()).build()).execute().body();
                if (body != null) {
                    str2 = body.string();
                    if (str2 == null) {
                    }
                    return new JSONObject(str2).getJSONArray(AccountConstantKt.RESPONSE_VALUE);
                }
                str2 = "";
                return new JSONObject(str2).getJSONArray(AccountConstantKt.RESPONSE_VALUE);
            } catch (Exception e2) {
                e2.printStackTrace();
                i4--;
            }
        }
        return null;
    }

    public final boolean z() {
        return i.getBoolean("is_last_complete_black_update_success", false);
    }
}
