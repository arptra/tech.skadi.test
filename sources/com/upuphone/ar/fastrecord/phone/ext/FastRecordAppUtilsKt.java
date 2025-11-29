package com.upuphone.ar.fastrecord.phone.ext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r¨\u0006\u000e"}, d2 = {"inflate", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewId", "", "parent", "Landroid/view/ViewGroup;", "attachToRoot", "", "asLiveData", "Landroidx/lifecycle/LiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "ar-fastrecord_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class FastRecordAppUtilsKt {
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull MutableLiveData<T> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
        return mutableLiveData;
    }

    @NotNull
    public static final View inflate(@NotNull Context context, int i, @Nullable ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(i, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public static /* synthetic */ View inflate$default(Context context, int i, ViewGroup viewGroup, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            viewGroup = null;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        return inflate(context, i, viewGroup, z);
    }
}
