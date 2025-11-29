package com.upuphone.xr.sapp.context;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J]\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011JA\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001a\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH&¢\u0006\u0004\b\u0013\u0010\u0014JA\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\b2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/context/PermissionContext;", "", "Landroidx/fragment/app/FragmentActivity;", "activity", "", "", "permissions", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "permissionNote", "Lkotlin/Function1;", "", "", "callback", "d", "(Landroidx/fragment/app/FragmentActivity;[Ljava/lang/String;Ljava/util/HashMap;Lkotlin/jvm/functions/Function1;)V", "a", "([Ljava/lang/String;)Z", "showRejectDialog", "c", "(Landroidx/fragment/app/FragmentActivity;[Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "Landroid/content/Context;", "context", "b", "(Landroid/content/Context;[Ljava/lang/String;)Ljava/util/HashMap;", "lib_context_release"}, k = 1, mv = {1, 9, 0})
public interface PermissionContext {
    boolean a(String[] strArr);

    HashMap b(Context context, String[] strArr);

    void c(FragmentActivity fragmentActivity, String[] strArr, boolean z, Function1 function1);

    void d(FragmentActivity fragmentActivity, String[] strArr, HashMap hashMap, Function1 function1);
}
