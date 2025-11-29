package com.upuphone.xr.sapp.ability;

import android.content.Context;
import com.upuphone.ar.transcribe.TranscribeApp;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.PhoneTransAbilityImpl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0017¢\u0006\u0004\b\r\u0010\u000eJ3\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\r\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u001d\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/upuphone/xr/sapp/ability/PhoneTransAbility;", "Lcom/upuphone/xr/interconnect/api/PhoneTransAbilityImpl$ITransAbilityResponse;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "isTransStarted", "()Z", "", "src", "dst", "", "switchLang", "(Ljava/lang/String;Ljava/lang/String;)I", "isAir", "transType", "(ZILjava/lang/String;Ljava/lang/String;)I", "startTranslation", "(I)I", "stopTranslation", "getTransCurrentState", "()I", "isSupportLanguage", "(ZILjava/lang/String;Ljava/lang/String;)Z", "", "a", "()V", "c", "d", "Landroid/content/Context;", "b", "()Landroid/content/Context;", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PhoneTransAbility implements PhoneTransAbilityImpl.ITransAbilityResponse {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f6602a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/ability/PhoneTransAbility$Companion;", "", "()V", "START_TRANS_ERROR", "", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public PhoneTransAbility(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f6602a = context;
        d();
    }

    public final void a() {
        InterconnectManager.getInstance().getPhoneTransAbility().registerTransResponse(this);
    }

    public final Context b() {
        return this.f6602a;
    }

    public final boolean c() {
        return TranscribeConstants.f6027a.j();
    }

    public final void d() {
        Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, Dispatchers.b(), (CoroutineStart) null, new PhoneTransAbility$migrateDb$1(this, (Continuation<? super PhoneTransAbility$migrateDb$1>) null), 2, (Object) null);
    }

    public int getTransCurrentState() {
        ULog.f6446a.g("Sapp-PhoneTransAbility", "getTransCurrentState");
        return c() ? TranscribeApp.getTransCurrentState(this.f6602a) | TranslationApp.getTransCurrentState() : TranslationApp.getTransCurrentState();
    }

    public boolean isSupportLanguage(boolean z, int i, String str, String str2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("Sapp-PhoneTransAbility", "isSupportLanguage isAir=" + z + ", transType=" + i + ", src=" + str + ", dst=" + str2);
        if (str == null || StringsKt.isBlank(str) || str2 == null || StringsKt.isBlank(str2)) {
            return false;
        }
        return (!c() || i != 1) ? TranslationApp.isSupportLanguage(z, i, str, str2) : TranscribeApp.isSupportLanguage(z, str, str2);
    }

    public boolean isTransStarted() {
        ULog.f6446a.g("Sapp-PhoneTransAbility", "isTransStarted");
        return TranscribeApp.isServiceOn() || TranslationApp.isServiceOn();
    }

    public int startTranslation(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("Sapp-PhoneTransAbility", "startTranslation transType=" + i);
        return (!c() || i != 1) ? TranslationApp.startTranslation(this.f6602a, i) : TranscribeApp.startTranslation(this.f6602a);
    }

    public int stopTranslation(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("Sapp-PhoneTransAbility", "stopTranslation transType=" + i);
        return (!c() || i != 1) ? TranslationApp.stopTranslation(i) : TranscribeApp.stopTranslation();
    }

    public int switchLang(String str, String str2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("Sapp-PhoneTransAbility", "switchLang src=" + str + " ,dst=" + str2);
        if (str == null || StringsKt.isBlank(str) || str2 == null || StringsKt.isBlank(str2)) {
            return -1;
        }
        return TranslationApp.switchLang(this.f6602a, str, str2);
    }

    public int switchLang(boolean z, int i, String str, String str2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("Sapp-PhoneTransAbility", "switchLanguage isAir=" + z + ", transType=" + i + ", src=" + str + " ,dst=" + str2);
        if (str == null || StringsKt.isBlank(str) || str2 == null || StringsKt.isBlank(str2)) {
            return -1;
        }
        if (!c() || i != 1) {
            return TranslationApp.switchLang(this.f6602a, z, i, str, str2);
        }
        return TranscribeApp.switchLang(this.f6602a, z, str, str2);
    }
}
