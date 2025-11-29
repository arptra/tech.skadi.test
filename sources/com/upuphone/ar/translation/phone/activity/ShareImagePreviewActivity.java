package com.upuphone.ar.translation.phone.activity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.honey.account.d5.a;
import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.phone.databinding.ActivityShareImagePreviewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/upuphone/ar/translation/phone/activity/ShareImagePreviewActivity;", "Lcom/upuphone/ar/translation/phone/activity/TranslatorBaseActivity;", "()V", "mBinding", "Lcom/upuphone/ar/translation/phone/databinding/ActivityShareImagePreviewBinding;", "mShareUri", "Landroid/net/Uri;", "displayImage", "", "uri", "initData", "initListener", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ShareImagePreviewActivity extends TranslatorBaseActivity {
    private ActivityShareImagePreviewBinding mBinding;
    @Nullable
    private Uri mShareUri;

    private final void displayImage(Uri uri) {
        RequestBuilder o0 = Glide.u(this).q(uri).b(new RequestOptions().j());
        ActivityShareImagePreviewBinding activityShareImagePreviewBinding = this.mBinding;
        if (activityShareImagePreviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityShareImagePreviewBinding = null;
        }
        o0.z0(activityShareImagePreviewBinding.c);
    }

    private final void initData() {
        Uri data = getIntent().getData();
        if (data != null) {
            this.mShareUri = data;
            displayImage(data);
        }
    }

    private final void initListener() {
        ActivityShareImagePreviewBinding activityShareImagePreviewBinding = this.mBinding;
        ActivityShareImagePreviewBinding activityShareImagePreviewBinding2 = null;
        if (activityShareImagePreviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityShareImagePreviewBinding = null;
        }
        activityShareImagePreviewBinding.d.l(new ShareImagePreviewActivity$initListener$1(this));
        ActivityShareImagePreviewBinding activityShareImagePreviewBinding3 = this.mBinding;
        if (activityShareImagePreviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityShareImagePreviewBinding2 = activityShareImagePreviewBinding3;
        }
        activityShareImagePreviewBinding2.b.setOnClickListener(new a(this));
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$2(ShareImagePreviewActivity shareImagePreviewActivity, View view) {
        Intrinsics.checkNotNullParameter(shareImagePreviewActivity, "this$0");
        Uri uri = shareImagePreviewActivity.mShareUri;
        if (uri != null) {
            ContextExtKt.D(shareImagePreviewActivity, uri, (String) null, 2, (Object) null);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityShareImagePreviewBinding c = ActivityShareImagePreviewBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.mBinding = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            c = null;
        }
        setContentView((View) c.getRoot());
        initData();
        initListener();
    }
}
