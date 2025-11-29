package com.upuphone.ar.transcribe.phone.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import com.honey.account.v4.e0;
import com.honey.account.v4.f0;
import com.honey.account.v4.g0;
import com.honey.account.v4.h0;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.databinding.ActivityTranscribeSettingBinding;
import com.upuphone.ar.transcribe.ext.ActivityExtKt;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.interconnect.entity.InterConnectMessage;
import com.upuphone.ar.transcribe.phone.TranscribeManager;
import com.upuphone.ar.transcribe.phone.helper.InterConnectHelper;
import com.upuphone.ar.transcribe.utils.JsonUtils;
import com.upuphone.ar.transcribe.utils.PreferencesUtils;
import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.upuphone.xr.sapp.context.IGlassInfo;
import com.upuphone.xr.sapp.context.PermissionContext;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.utils.VersionExtKt;
import flyme.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/TranscribeSettingActivity;", "Lcom/upuphone/ar/transcribe/phone/activity/TranscribeBaseActivity;", "()V", "binding", "Lcom/upuphone/ar/transcribe/databinding/ActivityTranscribeSettingBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "showLocationReminder", "syncScreenType", "type", "", "Companion", "ScreenType", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTranscribeSettingActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeSettingActivity.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeSettingActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,136:1\n262#2,2:137\n*S KotlinDebug\n*F\n+ 1 TranscribeSettingActivity.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeSettingActivity\n*L\n63#1:137,2\n*E\n"})
public final class TranscribeSettingActivity extends TranscribeBaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final String[] LOCATION_PERMISSIONS = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    private static final int SCREEN_TYPE_FULL = 1;
    private static final int SCREEN_TYPE_HALF = 2;
    /* access modifiers changed from: private */
    public ActivityTranscribeSettingBinding binding;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/TranscribeSettingActivity$Companion;", "", "()V", "LOCATION_PERMISSIONS", "", "", "getLOCATION_PERMISSIONS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SCREEN_TYPE_FULL", "", "SCREEN_TYPE_HALF", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String[] getLOCATION_PERMISSIONS() {
            return TranscribeSettingActivity.LOCATION_PERMISSIONS;
        }

        private Companion() {
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/TranscribeSettingActivity$ScreenType;", "", "screenType", "", "(I)V", "getScreenType", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ScreenType {
        private final int screenType;

        public ScreenType() {
            this(0, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ScreenType copy$default(ScreenType screenType2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = screenType2.screenType;
            }
            return screenType2.copy(i);
        }

        public final int component1() {
            return this.screenType;
        }

        @NotNull
        public final ScreenType copy(int i) {
            return new ScreenType(i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ScreenType) && this.screenType == ((ScreenType) obj).screenType;
        }

        public final int getScreenType() {
            return this.screenType;
        }

        public int hashCode() {
            return Integer.hashCode(this.screenType);
        }

        @NotNull
        public String toString() {
            int i = this.screenType;
            return "ScreenType(screenType=" + i + ")";
        }

        public ScreenType(int i) {
            this.screenType = i;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ScreenType(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 1 : i);
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(TranscribeSettingActivity transcribeSettingActivity, View view) {
        Intrinsics.checkNotNullParameter(transcribeSettingActivity, "this$0");
        view.setSelected(true);
        ActivityTranscribeSettingBinding activityTranscribeSettingBinding = transcribeSettingActivity.binding;
        if (activityTranscribeSettingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeSettingBinding = null;
        }
        activityTranscribeSettingBinding.b.setSelected(false);
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(transcribeSettingActivity), Dispatchers.b(), (CoroutineStart) null, new TranscribeSettingActivity$onCreate$2$1(transcribeSettingActivity, (Continuation<? super TranscribeSettingActivity$onCreate$2$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(TranscribeSettingActivity transcribeSettingActivity, View view) {
        Intrinsics.checkNotNullParameter(transcribeSettingActivity, "this$0");
        view.setSelected(true);
        ActivityTranscribeSettingBinding activityTranscribeSettingBinding = transcribeSettingActivity.binding;
        if (activityTranscribeSettingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeSettingBinding = null;
        }
        activityTranscribeSettingBinding.c.setSelected(false);
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(transcribeSettingActivity), Dispatchers.b(), (CoroutineStart) null, new TranscribeSettingActivity$onCreate$3$1(transcribeSettingActivity, (Continuation<? super TranscribeSettingActivity$onCreate$3$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void showLocationReminder() {
        AlertDialog create = new AlertDialog.Builder(this).setPositiveButton(R.string.trsb_turn_on, (DialogInterface.OnClickListener) new g0(this)).setNegativeButton(R.string.trsb_refuse, (DialogInterface.OnClickListener) new h0(this)).create();
        ActivityTranscribeSettingBinding activityTranscribeSettingBinding = this.binding;
        if (activityTranscribeSettingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeSettingBinding = null;
        }
        activityTranscribeSettingBinding.d.setSettingChecked(false);
        Intrinsics.checkNotNull(create);
        ActivityExtKt.a(create);
        create.setTitle(R.string.trsb_location_open_tips);
        create.show();
    }

    /* access modifiers changed from: private */
    public static final void showLocationReminder$lambda$2(TranscribeSettingActivity transcribeSettingActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(transcribeSettingActivity, "this$0");
        SdkContext sdkContext = SdkContext.f6675a;
        PermissionContext f = sdkContext.f();
        String[] strArr = LOCATION_PERMISSIONS;
        if (f.a(strArr)) {
            ActivityTranscribeSettingBinding activityTranscribeSettingBinding = transcribeSettingActivity.binding;
            if (activityTranscribeSettingBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityTranscribeSettingBinding = null;
            }
            activityTranscribeSettingBinding.d.setSettingChecked(true);
            PreferencesUtils preferencesUtils = PreferencesUtils.f6190a;
            Context applicationContext = transcribeSettingActivity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            preferencesUtils.o(applicationContext, true);
        } else {
            sdkContext.f().c(transcribeSettingActivity, strArr, true, new TranscribeSettingActivity$showLocationReminder$1$1(transcribeSettingActivity));
        }
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void showLocationReminder$lambda$3(TranscribeSettingActivity transcribeSettingActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(transcribeSettingActivity, "this$0");
        ActivityTranscribeSettingBinding activityTranscribeSettingBinding = transcribeSettingActivity.binding;
        if (activityTranscribeSettingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeSettingBinding = null;
        }
        activityTranscribeSettingBinding.d.setSettingChecked(false);
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public final void syncScreenType(int i) {
        PreferencesUtils preferencesUtils = PreferencesUtils.f6190a;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        preferencesUtils.q(applicationContext, i);
        if (!TranscribeManager.j.a().h().i()) {
            InterConnectHelper.x(InterConnectHelper.c.a(), new InterConnectMessage(69, JsonUtils.b(new ScreenType(i))), (byte[]) null, 2, (Object) null);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        String str;
        String romVersion;
        String d;
        super.onCreate(bundle);
        ActivityTranscribeSettingBinding c = ActivityTranscribeSettingBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.binding = c;
        ActivityTranscribeSettingBinding activityTranscribeSettingBinding = null;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        setContentView((View) c.getRoot());
        ActivityTranscribeSettingBinding activityTranscribeSettingBinding2 = this.binding;
        if (activityTranscribeSettingBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeSettingBinding2 = null;
        }
        activityTranscribeSettingBinding2.f.l(new TranscribeSettingActivity$onCreate$1(this));
        ActivityTranscribeSettingBinding activityTranscribeSettingBinding3 = this.binding;
        if (activityTranscribeSettingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeSettingBinding3 = null;
        }
        activityTranscribeSettingBinding3.c.setOnClickListener(new e0(this));
        ActivityTranscribeSettingBinding activityTranscribeSettingBinding4 = this.binding;
        if (activityTranscribeSettingBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeSettingBinding4 = null;
        }
        activityTranscribeSettingBinding4.b.setOnClickListener(new f0(this));
        IGlassInfo a2 = SdkContext.f6675a.e().a();
        if (a2 == null || (romVersion = a2.getRomVersion()) == null || (d = GlassInfoExtKt.d(romVersion)) == null || (str = GlassInfoExtKt.c(d)) == null) {
            str = "0.0.1";
        }
        LogExt.d("glass version: " + str, "AccessibilityOperateUtil");
        ActivityTranscribeSettingBinding activityTranscribeSettingBinding5 = this.binding;
        if (activityTranscribeSettingBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeSettingBinding5 = null;
        }
        ConstraintLayout constraintLayout = activityTranscribeSettingBinding5.e;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "screenType");
        int i = 0;
        if (!(VersionExtKt.a(str, "1.1.3") >= 0)) {
            i = 8;
        }
        constraintLayout.setVisibility(i);
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.b(), (CoroutineStart) null, new TranscribeSettingActivity$onCreate$4(this, (Continuation<? super TranscribeSettingActivity$onCreate$4>) null), 2, (Object) null);
        ActivityTranscribeSettingBinding activityTranscribeSettingBinding6 = this.binding;
        if (activityTranscribeSettingBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTranscribeSettingBinding = activityTranscribeSettingBinding6;
        }
        activityTranscribeSettingBinding.d.setSettingCallback(new TranscribeSettingActivity$onCreate$5(this));
    }
}
