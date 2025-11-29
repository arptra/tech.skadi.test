package com.upuphone.myvu.myvu_share_plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.sina.weibo.sdk.api.MultiImageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import com.sina.weibo.sdk.share.WbShareCallback;
import java.io.File;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J#\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001a\u0010 ¨\u0006$"}, d2 = {"Lcom/upuphone/myvu/myvu_share_plugin/SinaActivity;", "Landroid/app/Activity;", "Lcom/sina/weibo/sdk/share/WbShareCallback;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onComplete", "Lcom/sina/weibo/sdk/common/UiError;", "error", "onError", "(Lcom/sina/weibo/sdk/common/UiError;)V", "onCancel", "", "isSuccess", "", "a", "(ZLjava/lang/String;)V", "imagePath", "c", "(Ljava/lang/String;)V", "Lcom/sina/weibo/sdk/openapi/IWBAPI;", "Lcom/sina/weibo/sdk/openapi/IWBAPI;", "mWBAPI", "b", "Companion", "myvu_share_plugin_release"}, k = 1, mv = {1, 7, 1})
public final class SinaActivity extends Activity implements WbShareCallback {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public IWBAPI f6434a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/myvu/myvu_share_plugin/SinaActivity$Companion;", "", "()V", "ACTION_WEIBO_SHARE_RESULT", "", "TAG", "myvu_share_plugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static /* synthetic */ void b(SinaActivity sinaActivity, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        sinaActivity.a(z, str);
    }

    public final void a(boolean z, String str) {
        Intent intent = new Intent("com.upuphone.star.launcher.action_weibo_share_result");
        intent.putExtra("share_success", z);
        if (str != null) {
            intent.putExtra("error_msg", str);
        }
        sendBroadcast(intent);
    }

    public final void c(String str) {
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        MultiImageObject multiImageObject = new MultiImageObject();
        String packageName = getPackageName();
        multiImageObject.imageList = CollectionsKt.arrayListOf(FileProvider.getUriForFile(this, packageName + ".shareFileProvider", new File(str)));
        weiboMultiMessage.multiImageObject = multiImageObject;
        IWBAPI iwbapi = this.f6434a;
        if (iwbapi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWBAPI");
            iwbapi = null;
        }
        iwbapi.shareMessage(this, weiboMultiMessage, true);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onActivityResult(i, i2, intent);
        IWBAPI iwbapi = this.f6434a;
        IWBAPI iwbapi2 = null;
        if (iwbapi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWBAPI");
            iwbapi = null;
        }
        if (iwbapi.isShareResult(i, i2, intent)) {
            IWBAPI iwbapi3 = this.f6434a;
            if (iwbapi3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWBAPI");
            } else {
                iwbapi2 = iwbapi3;
            }
            iwbapi2.doResultIntent(intent, this);
        }
    }

    public void onCancel() {
        Log.i("SinaActivity", "微博分享取消");
        b(this, false, (String) null, 2, (Object) null);
        finish();
    }

    public void onComplete() {
        Log.i("SinaActivity", "微博分享成功");
        b(this, true, (String) null, 2, (Object) null);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IWBAPI createWBAPI = WBAPIFactory.createWBAPI(this);
        Intrinsics.checkNotNullExpressionValue(createWBAPI, "createWBAPI(this)");
        this.f6434a = createWBAPI;
        String stringExtra = getIntent().getStringExtra("image_path");
        if (stringExtra != null) {
            c(stringExtra);
        }
    }

    public void onError(UiError uiError) {
        Intrinsics.checkNotNullParameter(uiError, "error");
        String str = uiError.errorMessage;
        Log.i("SinaActivity", "微博分享错误: error" + str);
        a(false, uiError.errorMessage);
        finish();
    }
}
