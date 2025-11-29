package com.upuphone.ar.fastrecord.phone.ext;

import android.content.Context;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.s3.a;
import com.meizu.common.widget.Switch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001aB\u0010\u0005\u001a\u00020\u0006*\u00020\u000726\u0010\b\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\t\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"TAG", "", "isRtl", "", "Landroid/content/Context;", "recordOnCheckedChange", "", "Lcom/meizu/common/widget/Switch;", "listener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "isChecked", "ar-fastrecord_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RecordViewKt {
    @NotNull
    private static final String TAG = "RecordView";

    public static final boolean isRtl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    public static final void recordOnCheckedChange(@NotNull Switch switchR, @NotNull Function2<? super Switch, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(switchR, "<this>");
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        switchR.setOnClickListener(new a(function2, switchR));
    }

    /* access modifiers changed from: private */
    public static final void recordOnCheckedChange$lambda$0(Function2 function2, Switch switchR, View view) {
        Intrinsics.checkNotNullParameter(function2, "$listener");
        Intrinsics.checkNotNullParameter(switchR, "$this_recordOnCheckedChange");
        function2.invoke(switchR, Boolean.valueOf(switchR.isChecked()));
    }
}
