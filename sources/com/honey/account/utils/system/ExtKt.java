package com.honey.account.utils.system;

import android.text.Editable;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\u0010\u0003\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00010\u0004¨\u0006\t"}, d2 = {"doAfterTextChanged", "", "Landroid/widget/EditText;", "afterTextChanged", "Lkotlin/Function1;", "Landroid/text/Editable;", "Lkotlin/ParameterName;", "name", "s", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ExtKt {
    public static final void doAfterTextChanged(@NotNull EditText editText, @NotNull Function1<? super Editable, Unit> function1) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(function1, "afterTextChanged");
        editText.addTextChangedListener(new ExtKt$doAfterTextChanged$1(function1));
    }
}
