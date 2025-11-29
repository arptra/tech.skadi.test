package com.upuphone.xr.sapp.context;

import androidx.fragment.app.FragmentActivity;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.permission.PermissionHelper;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJA\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\fj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\r2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ]\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\fj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\r2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017JA\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0018\u001a\u00020\u00072\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/upuphone/xr/sapp/context/PermissionContextImpl;", "Lcom/upuphone/xr/sapp/context/PermissionContext;", "<init>", "()V", "", "", "permissions", "", "a", "([Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "(Landroid/content/Context;[Ljava/lang/String;)Ljava/util/HashMap;", "Landroidx/fragment/app/FragmentActivity;", "activity", "permissionNote", "Lkotlin/Function1;", "", "callback", "d", "(Landroidx/fragment/app/FragmentActivity;[Ljava/lang/String;Ljava/util/HashMap;Lkotlin/jvm/functions/Function1;)V", "showRejectDialog", "c", "(Landroidx/fragment/app/FragmentActivity;[Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PermissionContextImpl implements PermissionContext {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6674a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/context/PermissionContextImpl$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public boolean a(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        return PermissionHelper.f7819a.n(GlobalExtKt.f(), strArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r1 = r1.k(r2, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.HashMap b(android.content.Context r2, java.lang.String[] r3) {
        /*
            r1 = this;
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r1 = "permissions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            com.upuphone.xr.sapp.permission.PermissionHelper r1 = com.upuphone.xr.sapp.permission.PermissionHelper.f7819a
            com.upuphone.xr.sapp.entity.PermissionNote r0 = r1.e(r2, r3)
            if (r0 == 0) goto L_0x0040
            com.upuphone.xr.sapp.entity.PermissionNote r1 = r1.k(r2, r3)
            if (r1 == 0) goto L_0x0040
            java.lang.String r2 = "title"
            java.lang.String r3 = r0.getTitle()
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r3)
            java.lang.String r3 = "content"
            java.lang.String r0 = r0.getContent()
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r0)
            java.lang.String r0 = "rejectTitle"
            java.lang.String r1 = r1.getTitle()
            kotlin.Pair r1 = kotlin.TuplesKt.to(r0, r1)
            kotlin.Pair[] r1 = new kotlin.Pair[]{r2, r3, r1}
            java.util.HashMap r1 = kotlin.collections.MapsKt.hashMapOf(r1)
            return r1
        L_0x0040:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.context.PermissionContextImpl.b(android.content.Context, java.lang.String[]):java.util.HashMap");
    }

    public void c(FragmentActivity fragmentActivity, String[] strArr, boolean z, Function1 function1) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(function1, "callback");
        ULog.Delegate delegate = ULog.f6446a;
        String arrays = Arrays.toString(strArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
        delegate.a("PermissionContextImpl", "requestPermission, permissions: " + arrays + ", showRejectDialog: " + z);
        PermissionHelper.f7819a.r(fragmentActivity, strArr, z, function1);
    }

    public void d(FragmentActivity fragmentActivity, String[] strArr, HashMap hashMap, Function1 function1) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(hashMap, "permissionNote");
        Intrinsics.checkNotNullParameter(function1, "callback");
        ULog.Delegate delegate = ULog.f6446a;
        String arrays = Arrays.toString(strArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
        delegate.a("PermissionContextImpl", "requestPermission, permissions: " + arrays + ", permissionNote: " + hashMap);
        c(fragmentActivity, strArr, true, function1);
    }
}
