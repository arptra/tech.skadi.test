package androidx.core.content.res;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/core/content/res/TypedArrayApi26ImplKt;", "", "<init>", "()V", "Landroid/content/res/TypedArray;", "typedArray", "", "index", "Landroid/graphics/Typeface;", "a", "(Landroid/content/res/TypedArray;I)Landroid/graphics/Typeface;", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
final class TypedArrayApi26ImplKt {

    /* renamed from: a  reason: collision with root package name */
    public static final TypedArrayApi26ImplKt f706a = new TypedArrayApi26ImplKt();

    @JvmStatic
    @NotNull
    @DoNotInline
    public static final Typeface a(@NotNull TypedArray typedArray, @StyleableRes int i) {
        Typeface font = typedArray.getFont(i);
        Intrinsics.checkNotNull(font);
        return font;
    }
}
