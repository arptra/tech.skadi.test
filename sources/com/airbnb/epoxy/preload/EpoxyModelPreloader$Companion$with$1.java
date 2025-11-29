package com.airbnb.epoxy.preload;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010\u0002\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\f\b\u0002\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0003\"\n\b\u0003\u0010\u0006*\u0004\u0018\u00010\u0001\"\b\b\u0004\u0010\u0004*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lcom/airbnb/epoxy/preload/ViewMetadata;", "T", "Lcom/airbnb/epoxy/EpoxyModel;", "P", "Lcom/airbnb/epoxy/preload/PreloadRequestHolder;", "U", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
@SourceDebugExtension({"SMAP\nEpoxyModelPreloader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EpoxyModelPreloader.kt\ncom/airbnb/epoxy/preload/EpoxyModelPreloader$Companion$with$1\n*L\n1#1,131:1\n*E\n"})
public final class EpoxyModelPreloader$Companion$with$1 extends Lambda implements Function1<View, ViewMetadata> {
    public static final EpoxyModelPreloader$Companion$with$1 INSTANCE = new EpoxyModelPreloader$Companion$with$1();

    public EpoxyModelPreloader$Companion$with$1() {
        super(1);
    }

    @Nullable
    public final ViewMetadata invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        return ViewMetadata.f2331a.a(view);
    }
}
