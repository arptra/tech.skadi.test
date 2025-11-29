package com.xjmz.myvu.bridge;

import android.app.Activity;
import com.honey.account.view.web.WebJs;
import com.xjmz.myvu.MYVUActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a4\u0010\b\u001a\u00020\u0006*\u00020\u00002!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/app/Activity;", "Lkotlin/Function1;", "Lcom/xjmz/myvu/bridge/MainActivityInterface;", "Lkotlin/ParameterName;", "name", "api", "", "action", "a", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)V", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class ActivityExtKt {
    public static final void a(Activity activity, Function1 function1) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(function1, WebJs.ACTION);
        if (activity instanceof MYVUActivity) {
            function1.invoke((MainActivityInterface) activity);
        }
    }
}
