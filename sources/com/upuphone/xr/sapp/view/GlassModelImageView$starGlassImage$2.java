package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.upuphone.xr.sapp.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GlassModelImageView$starGlassImage$2 extends Lambda implements Function0<Drawable> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassModelImageView$starGlassImage$2(Context context) {
        super(0);
        this.$context = context;
    }

    @NotNull
    public final Drawable invoke() {
        Drawable b = AppCompatResources.b(this.$context, R.mipmap.ic_glass_model_star);
        Intrinsics.checkNotNull(b);
        return b;
    }
}
