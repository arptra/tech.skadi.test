package com.xjmz.myvu.flutter.pigeon.impl;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.sapp.MainApplication;
import com.xjmz.myvu.flutter.pigeon.AndroidIntentApi;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/IntentApiHandler;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidIntentApi$IntentApi;", "<init>", "()V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidIntentApi$IntentParams;", "params", "", "i", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidIntentApi$IntentParams;)V", "h", "g", "Landroid/content/Intent;", "l", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidIntentApi$IntentParams;)Landroid/content/Intent;", "n", "intent", "m", "(Landroid/content/Intent;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nIntentApiHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntentApiHandler.kt\ncom/xjmz/myvu/flutter/pigeon/impl/IntentApiHandler\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Uri.kt\nandroidx/core/net/UriKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,85:1\n1#2:86\n29#3:87\n215#4,2:88\n*S KotlinDebug\n*F\n+ 1 IntentApiHandler.kt\ncom/xjmz/myvu/flutter/pigeon/impl/IntentApiHandler\n*L\n58#1:87\n63#1:88,2\n*E\n"})
public final class IntentApiHandler implements AndroidIntentApi.IntentApi {
    public void g(AndroidIntentApi.IntentParams intentParams) {
        Intrinsics.checkNotNullParameter(intentParams, PayloadConstant.KEY_PARAMS);
        Intent l = l(intentParams);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("IntentApiHandler", "sendBroadCast: " + l);
        MainApplication.k.d().sendBroadcast(l);
    }

    public void h() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("IntentApiHandler", "检查SOS联系人");
        Uri withAppendedPath = Uri.withAppendedPath(Uri.parse("content://com.meizu.dialer"), "sos_contacts_amount");
        MainApplication.Companion companion = MainApplication.k;
        companion.d().grantUriPermission("com.android.dialer", withAppendedPath, 1);
        ContentResolver contentResolver = companion.d().getContentResolver();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(withAppendedPath, (String[]) null, (String) null, (String[]) null, (String) null);
            if (cursor == null || !cursor.moveToFirst()) {
                delegate.g("IntentApiHandler", "cursor == null or cursor is empty");
                n();
            } else {
                int i = cursor.getInt(cursor.getColumnIndexOrThrow("amount"));
                delegate.g("IntentApiHandler", "紧急联系人数量: " + i);
                if (i <= 0) {
                    delegate.g("IntentApiHandler", "紧急联系人数量小于1，跳转设置紧急联系人页面");
                    n();
                }
            }
            if (cursor == null) {
                return;
            }
        } catch (Exception e) {
            ULog.f6446a.g("IntentApiHandler", "检查SOS联系人信息出错");
            e.printStackTrace();
            if (cursor == null) {
                return;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
    }

    public void i(AndroidIntentApi.IntentParams intentParams) {
        Intrinsics.checkNotNullParameter(intentParams, PayloadConstant.KEY_PARAMS);
        m(l(intentParams));
    }

    public final Intent l(AndroidIntentApi.IntentParams intentParams) {
        Intent intent = new Intent(intentParams.b());
        String c = intentParams.c();
        if (c != null) {
            intent.setData(Uri.parse(c));
        }
        String h = intentParams.h();
        if (h != null) {
            intent.setType(h);
        }
        String f = intentParams.f();
        if (f != null) {
            intent.setIdentifier(f);
        }
        String g = intentParams.g();
        if (g != null) {
            intent.setPackage(g);
        }
        Long e = intentParams.e();
        if (e != null) {
            intent.setFlags((int) e.longValue());
        }
        Map d = intentParams.d();
        if (d != null) {
            for (Map.Entry entry : d.entrySet()) {
                intent.putExtra((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return intent;
    }

    public final void m(Intent intent) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("IntentApiHandler", "openIntent: " + intent);
        MainApplication.Companion companion = MainApplication.k;
        List q = companion.f().q();
        if (q.isEmpty()) {
            intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            companion.d().startActivity(intent);
            return;
        }
        ((Activity) CollectionsKt.last(q)).startActivity(intent);
    }

    public final void n() {
        m(new Intent("android.intent.action.SOS_PERMISSION_ADD_EMERGENCY_CONTACTS"));
    }
}
