package io.ktor.util;

import com.honey.account.constant.AccountConstantKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "name", "", "value", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStringValues.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringValues.kt\nio/ktor/util/StringValuesKt$appendFiltered$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,422:1\n857#2,2:423\n*S KotlinDebug\n*F\n+ 1 StringValues.kt\nio/ktor/util/StringValuesKt$appendFiltered$1\n*L\n383#1:423,2\n*E\n"})
final class StringValuesKt$appendFiltered$1 extends Lambda implements Function2<String, List<? extends String>, Unit> {
    final /* synthetic */ boolean $keepEmpty;
    final /* synthetic */ Function2<String, String, Boolean> $predicate;
    final /* synthetic */ StringValuesBuilder $this_appendFiltered;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringValuesKt$appendFiltered$1(boolean z, StringValuesBuilder stringValuesBuilder, Function2<? super String, ? super String, Boolean> function2) {
        super(2);
        this.$keepEmpty = z;
        this.$this_appendFiltered = stringValuesBuilder;
        this.$predicate = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (List<String>) (List) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, AccountConstantKt.RESPONSE_VALUE);
        ArrayList arrayList = new ArrayList(list.size());
        Function2<String, String, Boolean> function2 = this.$predicate;
        for (T next : list) {
            if (function2.invoke(str, (String) next).booleanValue()) {
                arrayList.add(next);
            }
        }
        if (this.$keepEmpty || (!arrayList.isEmpty())) {
            this.$this_appendFiltered.c(str, arrayList);
        }
    }
}
