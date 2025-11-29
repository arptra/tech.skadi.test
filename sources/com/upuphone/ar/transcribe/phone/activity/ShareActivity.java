package com.upuphone.ar.transcribe.phone.activity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.honey.account.v4.f;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.databinding.ActivityTranscribeShareBinding;
import com.upuphone.ar.transcribe.ext.ContextExtKt;
import com.upuphone.ar.transcribe.phone.view.TransTitleBar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/ShareActivity;", "Lcom/upuphone/ar/transcribe/phone/activity/TranscribeBaseActivity;", "()V", "binding", "Lcom/upuphone/ar/transcribe/databinding/ActivityTranscribeShareBinding;", "shareImageUri", "Landroid/net/Uri;", "getMaxBitmapSize", "", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nShareActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShareActivity.kt\ncom/upuphone/ar/transcribe/phone/activity/ShareActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,92:1\n1#2:93\n*E\n"})
public final class ShareActivity extends TranscribeBaseActivity {
    @NotNull
    public static final String BITMAP_URL_KEY = "image_url";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "ShareActivity";
    /* access modifiers changed from: private */
    public ActivityTranscribeShareBinding binding;
    @Nullable
    private Uri shareImageUri;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/ShareActivity$Companion;", "", "()V", "BITMAP_URL_KEY", "", "TAG", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final int getMaxBitmapSize() {
        return 104857600;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initData() {
        /*
            r9 = this;
            java.lang.String r0 = "ShareActivity"
            android.content.Intent r1 = r9.getIntent()
            java.lang.String r2 = "image_url"
            android.os.Parcelable r1 = r1.getParcelableExtra(r2)
            android.net.Uri r1 = (android.net.Uri) r1
            r9.shareImageUri = r1
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x002e
            androidx.lifecycle.LifecycleCoroutineScope r3 = androidx.lifecycle.LifecycleOwnerKt.a(r9)     // Catch:{ all -> 0x002c }
            kotlinx.coroutines.CoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.b()     // Catch:{ all -> 0x002c }
            com.upuphone.ar.transcribe.phone.activity.ShareActivity$initData$1$1$1 r6 = new com.upuphone.ar.transcribe.phone.activity.ShareActivity$initData$1$1$1     // Catch:{ all -> 0x002c }
            r2 = 0
            r6.<init>(r9, r1, r2)     // Catch:{ all -> 0x002c }
            r7 = 2
            r8 = 0
            r5 = 0
            kotlinx.coroutines.Job r9 = kotlinx.coroutines.BuildersKt__Builders_commonKt.d(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x002c }
            if (r9 != 0) goto L_0x0036
            goto L_0x002e
        L_0x002c:
            r9 = move-exception
            goto L_0x003b
        L_0x002e:
            java.lang.String r9 = "url is null error"
            com.upuphone.ar.transcribe.ext.LogExt.e(r9, r0)     // Catch:{ all -> 0x002c }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002c }
        L_0x0036:
            java.lang.Object r9 = kotlin.Result.m20constructorimpl(r9)     // Catch:{ all -> 0x002c }
            goto L_0x0045
        L_0x003b:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m20constructorimpl(r9)
        L_0x0045:
            java.lang.Throwable r9 = kotlin.Result.m23exceptionOrNullimpl(r9)
            if (r9 == 0) goto L_0x0063
            java.lang.String r9 = r9.getMessage()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "failed: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.upuphone.ar.transcribe.ext.LogExt.e(r9, r0)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.activity.ShareActivity.initData():void");
    }

    private final void initView() {
        ActivityTranscribeShareBinding activityTranscribeShareBinding = this.binding;
        ActivityTranscribeShareBinding activityTranscribeShareBinding2 = null;
        if (activityTranscribeShareBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeShareBinding = null;
        }
        TransTitleBar transTitleBar = activityTranscribeShareBinding.e;
        String string = getString(R.string.fast_record_share);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        transTitleBar.setBarTitle(string);
        ActivityTranscribeShareBinding activityTranscribeShareBinding3 = this.binding;
        if (activityTranscribeShareBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeShareBinding3 = null;
        }
        activityTranscribeShareBinding3.e.setIconMenu2Visible(false);
        ActivityTranscribeShareBinding activityTranscribeShareBinding4 = this.binding;
        if (activityTranscribeShareBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeShareBinding4 = null;
        }
        activityTranscribeShareBinding4.e.setIconMenuVisible(false);
        ActivityTranscribeShareBinding activityTranscribeShareBinding5 = this.binding;
        if (activityTranscribeShareBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeShareBinding5 = null;
        }
        activityTranscribeShareBinding5.e.setBarTitleVisible(true);
        ActivityTranscribeShareBinding activityTranscribeShareBinding6 = this.binding;
        if (activityTranscribeShareBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeShareBinding6 = null;
        }
        activityTranscribeShareBinding6.e.l(new ShareActivity$initView$1(this));
        ActivityTranscribeShareBinding activityTranscribeShareBinding7 = this.binding;
        if (activityTranscribeShareBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeShareBinding7 = null;
        }
        activityTranscribeShareBinding7.c.setOnClickListener(new f(this));
        ActivityTranscribeShareBinding activityTranscribeShareBinding8 = this.binding;
        if (activityTranscribeShareBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTranscribeShareBinding2 = activityTranscribeShareBinding8;
        }
        activityTranscribeShareBinding2.d.setAdjustViewBounds(true);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$1(ShareActivity shareActivity, View view) {
        Intrinsics.checkNotNullParameter(shareActivity, "this$0");
        Uri uri = shareActivity.shareImageUri;
        if (uri != null) {
            ContextExtKt.g(shareActivity, uri, (String) null, 2, (Object) null);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityTranscribeShareBinding c = ActivityTranscribeShareBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.binding = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        setContentView((View) c.getRoot());
        initView();
        initData();
    }
}
