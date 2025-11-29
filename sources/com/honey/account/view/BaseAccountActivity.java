package com.honey.account.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0004J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0004¨\u0006\u000b"}, d2 = {"Lcom/honey/account/view/BaseAccountActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "getRoundedBitmapDrawable", "Landroidx/core/graphics/drawable/RoundedBitmapDrawable;", "res", "Landroid/content/res/Resources;", "bitmap", "Landroid/graphics/Bitmap;", "filepath", "", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BaseAccountActivity extends AppCompatActivity {
    @NotNull
    public final RoundedBitmapDrawable getRoundedBitmapDrawable(@NotNull Resources resources, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(resources, "res");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        RoundedBitmapDrawable a2 = RoundedBitmapDrawableFactory.a(resources, bitmap);
        Intrinsics.checkNotNullExpressionValue(a2, "create(...)");
        return a2;
    }

    @NotNull
    public final RoundedBitmapDrawable getRoundedBitmapDrawable(@NotNull Resources resources, @NotNull String str) {
        Intrinsics.checkNotNullParameter(resources, "res");
        Intrinsics.checkNotNullParameter(str, "filepath");
        RoundedBitmapDrawable b = RoundedBitmapDrawableFactory.b(resources, str);
        Intrinsics.checkNotNullExpressionValue(b, "create(...)");
        return b;
    }
}
