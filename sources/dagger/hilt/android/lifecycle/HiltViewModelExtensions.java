package dagger.hilt.android.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u001a$\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\b"}, d2 = {"addCreationCallback", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VMF", "Landroidx/lifecycle/viewmodel/MutableCreationExtras;", "callback", "Lkotlin/Function1;", "Landroidx/lifecycle/ViewModel;", "withCreationCallback", "java_dagger_hilt_android_lifecycle-hilt_view_model_extensions_internal_kt"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "HiltViewModelExtensions")
public final class HiltViewModelExtensions {
    @NotNull
    public static final <VMF> CreationExtras addCreationCallback(@NotNull MutableCreationExtras mutableCreationExtras, @NotNull Function1<? super VMF, ? extends ViewModel> function1) {
        Intrinsics.checkNotNullParameter(mutableCreationExtras, "<this>");
        Intrinsics.checkNotNullParameter(function1, "callback");
        CreationExtras.Key<Function1<Object, ViewModel>> key = HiltViewModelFactory.CREATION_CALLBACK_KEY;
        Intrinsics.checkNotNullExpressionValue(key, "CREATION_CALLBACK_KEY");
        mutableCreationExtras.c(key, new HiltViewModelExtensions$addCreationCallback$1$1(function1));
        return mutableCreationExtras;
    }

    @NotNull
    public static final <VMF> CreationExtras withCreationCallback(@NotNull CreationExtras creationExtras, @NotNull Function1<? super VMF, ? extends ViewModel> function1) {
        Intrinsics.checkNotNullParameter(creationExtras, "<this>");
        Intrinsics.checkNotNullParameter(function1, "callback");
        return addCreationCallback(new MutableCreationExtras(creationExtras), function1);
    }
}
