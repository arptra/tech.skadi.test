package io.ktor.client.engine;

import com.meizu.common.widget.MzContactsContract;
import com.upuphone.runasone.relay.api.IntentKey;
import io.ktor.http.HttpHeaders;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "key", "", "values", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\nio/ktor/client/engine/UtilsKt$mergeHeaders$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,107:1\n1855#2,2:108\n*S KotlinDebug\n*F\n+ 1 Utils.kt\nio/ktor/client/engine/UtilsKt$mergeHeaders$2\n*L\n46#1:108,2\n*E\n"})
final class UtilsKt$mergeHeaders$2 extends Lambda implements Function2<String, List<? extends String>, Unit> {
    final /* synthetic */ Function2<String, String, Unit> $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UtilsKt$mergeHeaders$2(Function2<? super String, ? super String, Unit> function2) {
        super(2);
        this.$block = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (List<String>) (List) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(list, "values");
        HttpHeaders httpHeaders = HttpHeaders.f8966a;
        if (Intrinsics.areEqual((Object) httpHeaders.j(), (Object) str) || Intrinsics.areEqual((Object) httpHeaders.k(), (Object) str)) {
            return;
        }
        if (UtilsKt.b.contains(str)) {
            Function2<String, String, Unit> function2 = this.$block;
            for (String invoke : list) {
                function2.invoke(str, invoke);
            }
            return;
        }
        this.$block.invoke(str, CollectionsKt.joinToString$default(list, Intrinsics.areEqual((Object) httpHeaders.l(), (Object) str) ? "; " : MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
    }
}
