package com.upuphone.xr.sapp.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\b\b\u0000\u0012\u0004\u0018\u00010\u0002\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"com/upuphone/xr/sapp/fragment/MediaShowListFragment$MediaShowAdapter$instantiateItem$3$1", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "errorDrawable", "", "i", "(Landroid/graphics/drawable/Drawable;)V", "resource", "Lcom/bumptech/glide/request/transition/Transition;", "transition", "b", "(Landroid/graphics/Bitmap;Lcom/bumptech/glide/request/transition/Transition;)V", "placeholder", "d", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class MediaShowListFragment$MediaShowAdapter$instantiateItem$3$1 extends CustomTarget<Bitmap> {
    public final /* synthetic */ Ref.ObjectRef d;

    public MediaShowListFragment$MediaShowAdapter$instantiateItem$3$1(Ref.ObjectRef objectRef) {
        this.d = objectRef;
    }

    /* renamed from: b */
    public void e(Bitmap bitmap, Transition transition) {
        Intrinsics.checkNotNullParameter(bitmap, "resource");
        ((ImageView) this.d.element).setImageBitmap(bitmap);
    }

    public void d(Drawable drawable) {
    }

    public void i(Drawable drawable) {
    }
}
