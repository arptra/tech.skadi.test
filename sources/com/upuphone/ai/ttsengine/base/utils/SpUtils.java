package com.upuphone.ai.ttsengine.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.upuphone.runasone.relay.api.IntentKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00028\u00002\b\b\u0002\u0010\n\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\fJ9\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\n\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/utils/SpUtils;", "", "<init>", "()V", "T", "Landroid/content/Context;", "context", "", "key", "default", "sp", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "value", "", "c", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SpUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final SpUtils f5529a = new SpUtils();

    public static final Object a(Context context, String str, Object obj, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(str2, "sp");
        SharedPreferences sharedPreferences = context.getSharedPreferences(str2, 0);
        return obj instanceof Integer ? Integer.valueOf(sharedPreferences.getInt(str, ((Number) obj).intValue())) : obj instanceof Long ? Long.valueOf(sharedPreferences.getLong(str, ((Number) obj).longValue())) : obj instanceof String ? sharedPreferences.getString(str, (String) obj) : obj instanceof Boolean ? Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue())) : obj instanceof Float ? Float.valueOf(sharedPreferences.getFloat(str, ((Number) obj).floatValue())) : obj;
    }

    public static /* synthetic */ Object b(Context context, String str, Object obj, String str2, int i, Object obj2) {
        if ((i & 8) != 0) {
            str2 = "version_control";
        }
        return a(context, str, obj, str2);
    }

    public static final void c(Context context, String str, Object obj, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(str2, "sp");
        SharedPreferences.Editor edit = context.getSharedPreferences(str2, 0).edit();
        if (obj instanceof Integer) {
            edit.putInt(str, ((Number) obj).intValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Number) obj).longValue());
        } else if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Number) obj).floatValue());
        }
        edit.apply();
    }

    public static /* synthetic */ void d(Context context, String str, Object obj, String str2, int i, Object obj2) {
        if ((i & 8) != 0) {
            str2 = "version_control";
        }
        c(context, str, obj, str2);
    }
}
