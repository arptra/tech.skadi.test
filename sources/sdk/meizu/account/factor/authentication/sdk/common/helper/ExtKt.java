package sdk.meizu.account.factor.authentication.sdk.common.helper;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0005\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\b¨\u0006\t"}, d2 = {"mapToType", "", "T", "Lcom/google/gson/JsonArray;", "transform", "Lkotlin/Function1;", "Lcom/google/gson/JsonObject;", "toSHA256", "", "sdk_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Ext.kt\nsdk/meizu/account/factor/authentication/sdk/common/helper/ExtKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,23:1\n1603#2,9:24\n1855#2:33\n1856#2:35\n1612#2:36\n1#3:34\n*S KotlinDebug\n*F\n+ 1 Ext.kt\nsdk/meizu/account/factor/authentication/sdk/common/helper/ExtKt\n*L\n22#1:24,9\n22#1:33\n22#1:35\n22#1:36\n22#1:34\n*E\n"})
public final class ExtKt {
    @NotNull
    public static final <T> List<T> mapToType(@NotNull JsonArray jsonArray, @NotNull Function1<? super JsonObject, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(jsonArray, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator it = jsonArray.iterator();
        while (it.hasNext()) {
            Object invoke = function1.invoke(((JsonElement) it.next()).getAsJsonObject());
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final String toSHA256(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] digest = instance.digest(bytes);
        Intrinsics.checkNotNull(digest);
        return ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) ExtKt$toSHA256$1.INSTANCE, 30, (Object) null);
    }
}
