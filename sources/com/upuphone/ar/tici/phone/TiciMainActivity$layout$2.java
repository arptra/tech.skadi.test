package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/ar/tici/databinding/TiciMainActivityLayoutBinding;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TiciMainActivity$layout$2 extends Lambda implements Function0<TiciMainActivityLayoutBinding> {
    final /* synthetic */ TiciMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciMainActivity$layout$2(TiciMainActivity ticiMainActivity) {
        super(0);
        this.this$0 = ticiMainActivity;
    }

    @NotNull
    public final TiciMainActivityLayoutBinding invoke() {
        return TiciMainActivityLayoutBinding.c(this.this$0.getLayoutInflater());
    }
}
