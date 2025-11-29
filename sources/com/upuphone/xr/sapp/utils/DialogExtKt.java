package com.upuphone.xr.sapp.utils;

import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.entity.DialogTextBean;
import com.xjmz.myvu.dialog.NormalTwoBtnDialog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H@¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u0000H@¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0014\u0010\b\u001a\u00020\u0003*\u00020\u0000H@¢\u0006\u0004\b\b\u0010\u0007\u001a\u0014\u0010\t\u001a\u00020\u0003*\u00020\u0000H@¢\u0006\u0004\b\t\u0010\u0007\u001a\u0014\u0010\n\u001a\u00020\u0003*\u00020\u0000H@¢\u0006\u0004\b\n\u0010\u0007\u001a\u0014\u0010\u000b\u001a\u00020\u0003*\u00020\u0000H@¢\u0006\u0004\b\u000b\u0010\u0007\u001a\u0014\u0010\f\u001a\u00020\u0003*\u00020\u0000H@¢\u0006\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", "Lcom/upuphone/xr/sapp/entity/DialogTextBean;", "dialogText", "Lcom/upuphone/xr/sapp/utils/DialogResult;", "c", "(Landroidx/fragment/app/FragmentActivity;Lcom/upuphone/xr/sapp/entity/DialogTextBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e", "f", "b", "a", "g", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDialogExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DialogExt.kt\ncom/upuphone/xr/sapp/utils/DialogExtKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,160:1\n314#2,11:161\n*S KotlinDebug\n*F\n+ 1 DialogExt.kt\ncom/upuphone/xr/sapp/utils/DialogExtKt\n*L\n28#1:161,11\n*E\n"})
public final class DialogExtKt {
    public static final Object a(FragmentActivity fragmentActivity, Continuation continuation) {
        String string = fragmentActivity.getString(R.string.location_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = Build.VERSION.SDK_INT < 31 ? fragmentActivity.getString(R.string.flyme_internal_app_permission_location_text_android_r) : fragmentActivity.getString(R.string.flyme_internal_app_permission_location_text);
        Intrinsics.checkNotNull(string2);
        String string3 = fragmentActivity.getString(R.string.agree);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = fragmentActivity.getString(R.string.permission_refuse);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        return c(fragmentActivity, new DialogTextBean(string, string2, string3, string4), continuation);
    }

    public static final Object b(FragmentActivity fragmentActivity, Continuation continuation) {
        String string = fragmentActivity.getString(R.string.permission_reminder_title_bluetooth);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = fragmentActivity.getString(R.string.flyme_internal_app_permission_nearby_devices_text);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = fragmentActivity.getString(R.string.open_notification);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = fragmentActivity.getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        return c(fragmentActivity, new DialogTextBean(string, string2, string3, string4), continuation);
    }

    public static final Object c(FragmentActivity fragmentActivity, DialogTextBean dialogTextBean, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        FragmentActivity fragmentActivity2 = fragmentActivity;
        cancellableContinuationImpl.E(new DialogExtKt$waitForDialogResult$2$1(NormalTwoBtnDialog.k.a(fragmentActivity2, dialogTextBean.getTitle(), dialogTextBean.getContent(), dialogTextBean.getConfirmText(), dialogTextBean.getRefuseText(), new DialogExtKt$waitForDialogResult$2$confirmCallback$1(cancellableContinuationImpl), new DialogExtKt$waitForDialogResult$2$refuseCallback$1(cancellableContinuationImpl), new DialogExtKt$waitForDialogResult$2$cancelCallback$1(cancellableContinuationImpl), false, false)));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public static final Object d(FragmentActivity fragmentActivity, Continuation continuation) {
        String string = fragmentActivity.getString(R.string.please_open_bluetooth);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = fragmentActivity.getString(R.string.please_open_bluetooth_tips);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = fragmentActivity.getString(R.string.open_notification);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = fragmentActivity.getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        return c(fragmentActivity, new DialogTextBean(string, string2, string3, string4), continuation);
    }

    public static final Object e(FragmentActivity fragmentActivity, Continuation continuation) {
        String string = fragmentActivity.getString(R.string.location_permission_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = Build.VERSION.SDK_INT < 31 ? fragmentActivity.getString(R.string.flyme_internal_app_permission_location_text_android_r) : fragmentActivity.getString(R.string.flyme_internal_app_permission_location_text);
        Intrinsics.checkNotNull(string2);
        String string3 = fragmentActivity.getString(R.string.open_notification);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = fragmentActivity.getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        return c(fragmentActivity, new DialogTextBean(string, string2, string3, string4), continuation);
    }

    public static final Object f(FragmentActivity fragmentActivity, Continuation continuation) {
        String string = fragmentActivity.getString(R.string.permission_reminder_title_location);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = Build.VERSION.SDK_INT < 31 ? fragmentActivity.getString(R.string.flyme_internal_app_permission_location_text_android_r) : fragmentActivity.getString(R.string.flyme_internal_app_permission_location_text);
        Intrinsics.checkNotNull(string2);
        String string3 = fragmentActivity.getString(R.string.open_notification);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = fragmentActivity.getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        return c(fragmentActivity, new DialogTextBean(string, string2, string3, string4), continuation);
    }

    public static final Object g(FragmentActivity fragmentActivity, Continuation continuation) {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        String string = bool.booleanValue() ? fragmentActivity.getString(R.string.notice_permission_title_oversea) : fragmentActivity.getString(R.string.notice_permission_title);
        Intrinsics.checkNotNull(string);
        String string2 = fragmentActivity.getString(R.string.notice_permission_content);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = fragmentActivity.getString(R.string.permission_confirm);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = fragmentActivity.getString(R.string.permission_refuse);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        return c(fragmentActivity, new DialogTextBean(string, string2, string3, string4), continuation);
    }
}
