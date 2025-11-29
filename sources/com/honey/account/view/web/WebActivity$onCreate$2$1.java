package com.honey.account.view.web;

import android.content.DialogInterface;
import android.util.Log;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.appcompat.app.ActionBar;
import com.honey.account.AccountHelper;
import com.honey.account.R;
import com.honey.account.o2.b;
import com.honey.account.o2.c;
import flyme.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/honey/account/view/web/WebActivity$onCreate$2$1", "Landroid/webkit/WebChromeClient;", "onPermissionRequest", "", "request", "Landroid/webkit/PermissionRequest;", "onProgressChanged", "view", "Landroid/webkit/WebView;", "newProgress", "", "onReceivedTitle", "title", "", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WebActivity$onCreate$2$1 extends WebChromeClient {
    final /* synthetic */ WebView $this_apply;
    final /* synthetic */ WebActivity this$0;

    public WebActivity$onCreate$2$1(WebActivity webActivity, WebView webView) {
        this.this$0 = webActivity;
        this.$this_apply = webView;
    }

    /* access modifiers changed from: private */
    public static final void onPermissionRequest$lambda$0(PermissionRequest permissionRequest, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(permissionRequest, "$request");
        Log.i("WebActivity", "allow video capture permission");
        permissionRequest.grant(permissionRequest.getResources());
    }

    /* access modifiers changed from: private */
    public static final void onPermissionRequest$lambda$1(PermissionRequest permissionRequest, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(permissionRequest, "$request");
        Log.i("WebActivity", "deny video capture permission");
        permissionRequest.deny();
    }

    public void onPermissionRequest(@NotNull PermissionRequest permissionRequest) {
        String str;
        Intrinsics.checkNotNullParameter(permissionRequest, "request");
        String[] resources = permissionRequest.getResources();
        if (resources == null || resources.length == 0) {
            Log.i("WebActivity", "permission request, permission empty, pass");
            permissionRequest.grant(permissionRequest.getResources());
            return;
        }
        String[] resources2 = permissionRequest.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
        for (String str2 : resources2) {
            Intrinsics.checkNotNull(str2);
            Log.i("WebActivity", "permission request, item permission: " + str2);
            if (Intrinsics.areEqual((Object) str2, (Object) "android.webkit.resource.VIDEO_CAPTURE")) {
                permissionRequest.grant(permissionRequest.getResources());
            } else {
                String packageName = AccountHelper.INSTANCE.getMApplicationContext().getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                String url = this.$this_apply.getUrl();
                if (url == null || !StringsKt.contains$default((CharSequence) url, (CharSequence) "/action/trtc/pre", false, 2, (Object) null)) {
                    str = "";
                } else {
                    packageName = this.this$0.getString(R.string.e_sign_app);
                    Intrinsics.checkNotNullExpressionValue(packageName, "getString(...)");
                    str = this.this$0.getString(R.string.e_sign_hint);
                    Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
                }
                new AlertDialog.Builder(this.this$0).setTitle((CharSequence) packageName + this.this$0.getString(R.string.video_capture_permission)).setMessage((CharSequence) str).setPositiveButton(flyme.support.v7.appcompat.R.string.mz_permission_allow, (DialogInterface.OnClickListener) new b(permissionRequest)).setNegativeButton(flyme.support.v7.appcompat.R.string.mz_permission_deny, (DialogInterface.OnClickListener) new c(permissionRequest)).setCancelable(false).create().show();
            }
        }
    }

    public void onProgressChanged(@Nullable WebView webView, int i) {
        super.onProgressChanged(webView, i);
    }

    public void onReceivedTitle(@Nullable WebView webView, @Nullable String str) {
        ActionBar supportActionBar;
        String stringExtra = this.this$0.getIntent().getStringExtra("param_title");
        if ((stringExtra == null || stringExtra.length() == 0) && (supportActionBar = this.this$0.getSupportActionBar()) != null) {
            supportActionBar.x(str);
        }
    }
}
