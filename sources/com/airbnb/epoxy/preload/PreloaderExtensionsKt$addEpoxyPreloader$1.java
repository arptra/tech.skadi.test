package com.airbnb.epoxy.preload;

import android.content.Context;
import com.airbnb.epoxy.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0003\"\n\b\u0001\u0010\u0004*\u0004\u0018\u00010\u0005\"\b\b\u0002\u0010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\n¢\u0006\u0002\b\r"}, d2 = {"<anonymous>", "", "T", "Lcom/airbnb/epoxy/EpoxyModel;", "U", "Lcom/airbnb/epoxy/preload/ViewMetadata;", "P", "Lcom/airbnb/epoxy/preload/PreloadRequestHolder;", "context", "Landroid/content/Context;", "err", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class PreloaderExtensionsKt$addEpoxyPreloader$1 extends Lambda implements Function2<Context, RuntimeException, Unit> {
    public static final PreloaderExtensionsKt$addEpoxyPreloader$1 INSTANCE = new PreloaderExtensionsKt$addEpoxyPreloader$1();

    public PreloaderExtensionsKt$addEpoxyPreloader$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Context) obj, (RuntimeException) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Context context, @NotNull RuntimeException runtimeException) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(runtimeException, "err");
        if (!UtilsKt.a(context)) {
            throw runtimeException;
        }
    }
}
