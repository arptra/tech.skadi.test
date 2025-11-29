package com.upuphone.ar.transcribe.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import com.upuphone.ar.transcribe.phone.activity.TranscribeSettingActivity;
import com.upuphone.xr.sapp.context.SdkContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b!\u0010\u001bJ\u0017\u0010\"\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\"\u0010\u001dJ\u0015\u0010#\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b#\u0010\u001dJ\u0015\u0010$\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0019¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b)\u0010\u001bJ\u0015\u0010*\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b*\u0010\u001dJ\u001d\u0010,\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\b¢\u0006\u0004\b,\u0010 ¨\u0006-"}, d2 = {"Lcom/upuphone/ar/transcribe/utils/PreferencesUtils;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "src", "", "isAir", "isIntl", "", "n", "(Landroid/content/Context;Ljava/lang/String;ZZ)V", "m", "(Landroid/content/Context;Ljava/lang/String;)V", "p", "(Landroid/content/Context;Ljava/lang/String;Z)V", "isIntlVersion", "c", "(Landroid/content/Context;ZZ)Ljava/lang/String;", "a", "(Landroid/content/Context;)Ljava/lang/String;", "d", "(Landroid/content/Context;Z)Ljava/lang/String;", "", "f", "(Landroid/content/Context;)I", "j", "(Landroid/content/Context;)Z", "need", "l", "(Landroid/content/Context;Z)V", "g", "b", "h", "k", "(Landroid/content/Context;)V", "type", "q", "(Landroid/content/Context;I)V", "e", "i", "open", "o", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPreferencesUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreferencesUtils.kt\ncom/upuphone/ar/transcribe/utils/PreferencesUtils\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,293:1\n43#2,8:294\n43#2,8:302\n43#2,8:310\n43#2,8:318\n43#2,8:326\n43#2,8:334\n43#2,8:342\n43#2,8:350\n43#2,8:358\n43#2,8:366\n*S KotlinDebug\n*F\n+ 1 PreferencesUtils.kt\ncom/upuphone/ar/transcribe/utils/PreferencesUtils\n*L\n72#1:294,8\n88#1:302,8\n162#1:310,8\n188#1:318,8\n201#1:326,8\n227#1:334,8\n252#1:342,8\n264#1:350,8\n271#1:358,8\n289#1:366,8\n*E\n"})
public final class PreferencesUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final PreferencesUtils f6190a = new PreferencesUtils();

    public static final String a(Context context) {
        String c = TranscribeConstants.f6027a.c();
        SharedPreferences sharedPreferences = context.getSharedPreferences("transcribe_sp", 0);
        sharedPreferences.getString("", "");
        if (Intrinsics.areEqual((Object) c, (Object) "cnen")) {
            c = "en";
        }
        return String.valueOf(sharedPreferences.getString("src_transcribe_intl", c));
    }

    public static final boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences("transcribe_sp", 0).getBoolean("sync_to_phone_type", true);
    }

    public static final String c(Context context, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        return z2 ? a(context) : d(context, z);
    }

    public static final String d(Context context, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("transcribe_sp", 0);
        return String.valueOf(z ? sharedPreferences.getString("src_transcribe_air", "cn") : sharedPreferences.getString("src_transcribe", "cn"));
    }

    public static final int f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences("transcribe_sp", 0).getInt("subtitle_size", 2);
    }

    public static final int g(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences("transcribe_sp", 0).getInt("translate_model_type", 4);
    }

    public static final boolean j(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences("transcribe_sp", 0).getBoolean("trans_tips", true);
    }

    public static final void l(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("transcribe_sp", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        edit.putBoolean("trans_tips", z);
        edit.commit();
    }

    public static final void m(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("transcribe_sp", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        edit.putString("src_transcribe_intl", str);
        edit.commit();
    }

    public static final void n(Context context, String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "src");
        if (z2) {
            m(context, str);
        } else {
            p(context, str, z);
        }
    }

    public static final void p(Context context, String str, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("transcribe_sp", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        if (z) {
            edit.putString("src_transcribe_air", str);
        } else {
            edit.putString("src_transcribe", str);
        }
        edit.commit();
    }

    public final int e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences("transcribe_sp", 0).getInt("screen_typ", 1);
    }

    public final boolean h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences("transcribe_sp", 0).getBoolean("db_migrated", false);
    }

    public final boolean i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences("transcribe_sp", 0).getBoolean("is_location_open", false) && SdkContext.f6675a.f().a(TranscribeSettingActivity.Companion.getLOCATION_PERMISSIONS());
    }

    public final void k(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("transcribe_sp", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        edit.putBoolean("db_migrated", true);
        edit.commit();
    }

    public final void o(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("transcribe_sp", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        edit.putBoolean("is_location_open", z);
        edit.commit();
    }

    public final void q(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("transcribe_sp", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        edit.putInt("screen_typ", i);
        edit.commit();
    }
}
