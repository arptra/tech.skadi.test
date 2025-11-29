package com.upuphone.ar.tici.phone.starrynet.msg;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.ar.tici.phone.utils.JsonUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\f\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReply;", "", "a", "(Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReply;)Ljava/lang/String;", "Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReplyV2;", "b", "(Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReplyV2;)Ljava/lang/String;", "", "Lcom/upuphone/ar/tici/phone/starrynet/msg/ParagraphItem;", "d", "(Ljava/lang/String;)Ljava/util/List;", "", "c", "(Ljava/util/List;)Ljava/lang/String;", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nOpenTiciMsgReply.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OpenTiciMsgReply.kt\ncom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReplyKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 JsonUtils.kt\ncom/upuphone/ar/tici/phone/utils/JsonUtils\n*L\n1#1,135:1\n1855#2,2:136\n59#3,2:138\n*S KotlinDebug\n*F\n+ 1 OpenTiciMsgReply.kt\ncom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReplyKt\n*L\n98#1:136,2\n108#1:138,2\n*E\n"})
public final class OpenTiciMsgReplyKt {
    public static final String a(OpenTiciMsgReply openTiciMsgReply) {
        Intrinsics.checkNotNullParameter(openTiciMsgReply, "<this>");
        return JsonUtils.f5992a.c(openTiciMsgReply.getParagraphIndexes());
    }

    public static final String b(OpenTiciMsgReplyV2 openTiciMsgReplyV2) {
        Intrinsics.checkNotNullParameter(openTiciMsgReplyV2, "<this>");
        JsonArray jsonArray = new JsonArray();
        for (Integer[] numArr : openTiciMsgReplyV2.getParagraphIndexes()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(MzContactsContract.START_PARAM_KEY, (Number) numArr[0]);
            jsonObject.addProperty("end", (Number) numArr[1]);
            jsonArray.add((JsonElement) jsonObject);
        }
        String jsonElement = jsonArray.toString();
        Intrinsics.checkNotNullExpressionValue(jsonElement, "toString(...)");
        return jsonElement;
    }

    public static final String c(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        JsonArray jsonArray = new JsonArray();
        int intValue = ((Number) list.get(0)).intValue();
        int size = list.size();
        for (int i = 1; i < size; i++) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(MzContactsContract.START_PARAM_KEY, (Number) Integer.valueOf(intValue));
            jsonObject.addProperty("end", (Number) list.get(i));
            jsonArray.add((JsonElement) jsonObject);
            intValue = ((Number) list.get(i)).intValue();
        }
        String jsonElement = jsonArray.toString();
        Intrinsics.checkNotNullExpressionValue(jsonElement, "toString(...)");
        return jsonElement;
    }

    public static final List d(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        List list = (List) JsonUtils.f5992a.b().fromJson(str, new OpenTiciMsgReplyKt$toParagraphItemArray$$inlined$fromJsonList$1().getType());
        return list == null ? CollectionsKt.emptyList() : list;
    }
}
