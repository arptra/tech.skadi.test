package com.upuphone.ar.tici.phone.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001c\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/content/Context;", "", "path", "a", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
public final class ContextExtKt {
    public static final Object a(Context context, String str, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new ContextExtKt$readAssetsToString$2(context, str, (Continuation<? super ContextExtKt$readAssetsToString$2>) null), continuation);
    }
}
