package com.upuphone.star.httplib;

import androidx.annotation.Keep;
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0004J$\u0010\r\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/upuphone/star/httplib/SignUtils;", "", "()V", "ALGORITHM_HMacSha256", "", "KEY_ENCODED", "encryptWithHMacSha256", "", "input", "key", "Ljavax/crypto/SecretKey;", "generateSecretKey", "algorithm", "signWithHMacSha256", "params", "", "secretKey", "super-http-lib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSignUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SignUtils.kt\ncom/upuphone/star/httplib/SignUtils\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,51:1\n125#2:52\n152#2,3:53\n*S KotlinDebug\n*F\n+ 1 SignUtils.kt\ncom/upuphone/star/httplib/SignUtils\n*L\n28#1:52\n28#1:53,3\n*E\n"})
@Keep
public final class SignUtils {
    @NotNull
    private static final String ALGORITHM_HMacSha256 = "HmacSHA256";
    @NotNull
    public static final SignUtils INSTANCE = new SignUtils();
    @NotNull
    private static final String KEY_ENCODED = "wufW8W8VIrTiRnzOl2BULFjMfHAq40HC0IAouuK2zmI=";

    private SignUtils() {
    }

    public static /* synthetic */ String signWithHMacSha256$default(SignUtils signUtils, Map map, SecretKey secretKey, int i, Object obj) {
        if ((i & 2) != 0) {
            byte[] bytes = KEY_ENCODED.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            secretKey = signUtils.generateSecretKey(bytes, ALGORITHM_HMacSha256);
        }
        return signUtils.signWithHMacSha256(map, secretKey);
    }

    @NotNull
    public final byte[] encryptWithHMacSha256(@NotNull String str, @NotNull SecretKey secretKey) {
        Intrinsics.checkNotNullParameter(str, "input");
        Intrinsics.checkNotNullParameter(secretKey, IntentKey.ACTIVITY.ACTION_KEY);
        Mac instance = Mac.getInstance(ALGORITHM_HMacSha256);
        instance.init(secretKey);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] doFinal = instance.doFinal(bytes);
        Intrinsics.checkNotNullExpressionValue(doFinal, "getInstance(ALGORITHM_HM….toByteArray())\n        }");
        return doFinal;
    }

    @NotNull
    public final SecretKey generateSecretKey(@NotNull byte[] bArr, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bArr, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(str, "algorithm");
        return new SecretKeySpec(bArr, str);
    }

    @NotNull
    public final String signWithHMacSha256(@NotNull Map<String, String> map, @NotNull SecretKey secretKey) {
        Intrinsics.checkNotNullParameter(map, PayloadConstant.KEY_PARAMS);
        Intrinsics.checkNotNullParameter(secretKey, "secretKey");
        SortedMap<String, String> sortedMap = map instanceof SortedMap ? (SortedMap) map : MapsKt.toSortedMap(map);
        ArrayList arrayList = new ArrayList(sortedMap.size());
        for (Map.Entry next : sortedMap.entrySet()) {
            arrayList.add(((String) next.getKey()) + '=' + ((String) next.getValue()));
        }
        return UtilExtKt.d(encryptWithHMacSha256(CollectionsKt.joinToString$default(arrayList, "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), secretKey));
    }
}
