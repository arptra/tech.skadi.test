package io.ktor.http;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "", "Lio/ktor/http/ContentType;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class MimesKt$mimes$2 extends Lambda implements Function0<List<? extends Pair<? extends String, ? extends ContentType>>> {
    public static final MimesKt$mimes$2 INSTANCE = new MimesKt$mimes$2();

    public MimesKt$mimes$2() {
        super(0);
    }

    @NotNull
    public final List<Pair<String, ContentType>> invoke() {
        return MimesKt.c();
    }
}
