package io.ktor.websocket;

import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.widget.MzContactsContract;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "value", "", "Lio/ktor/websocket/WebSocketExtensionHeader;", "a", "(Ljava/lang/String;)Ljava/util/List;", "ktor-websockets"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nWebSocketExtensionHeader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebSocketExtensionHeader.kt\nio/ktor/websocket/WebSocketExtensionHeaderKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,46:1\n1549#2:47\n1620#2,2:48\n1549#2:50\n1620#2,3:51\n1622#2:54\n*S KotlinDebug\n*F\n+ 1 WebSocketExtensionHeader.kt\nio/ktor/websocket/WebSocketExtensionHeaderKt\n*L\n40#1:47\n40#1:48,2\n43#1:50\n43#1:51,3\n40#1:54\n*E\n"})
public final class WebSocketExtensionHeaderKt {
    public static final List a(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        List<String> split$default = StringsKt.split$default((CharSequence) str, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        for (String split$default2 : split$default) {
            List split$default3 = StringsKt.split$default((CharSequence) split$default2, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD}, false, 0, 6, (Object) null);
            String obj = StringsKt.trim((CharSequence) (String) CollectionsKt.first(split$default3)).toString();
            List<String> drop = CollectionsKt.drop(split$default3, 1);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(drop, 10));
            for (String trim : drop) {
                arrayList2.add(StringsKt.trim((CharSequence) trim).toString());
            }
            arrayList.add(new WebSocketExtensionHeader(obj, arrayList2));
        }
        return arrayList;
    }
}
