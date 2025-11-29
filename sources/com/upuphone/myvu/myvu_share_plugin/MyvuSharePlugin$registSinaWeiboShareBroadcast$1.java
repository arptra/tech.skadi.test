package com.upuphone.myvu.myvu_share_plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/myvu/myvu_share_plugin/MyvuSharePlugin$registSinaWeiboShareBroadcast$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "myvu_share_plugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MyvuSharePlugin$registSinaWeiboShareBroadcast$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f6429a;
    public final /* synthetic */ MyvuSharePlugin b;
    public final /* synthetic */ String c;

    public MyvuSharePlugin$registSinaWeiboShareBroadcast$1(MethodChannel.Result result, MyvuSharePlugin myvuSharePlugin, String str) {
        this.f6429a = result;
        this.b = myvuSharePlugin;
        this.c = str;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual((Object) intent.getAction(), (Object) "com.upuphone.star.launcher.action_weibo_share_result")) {
            boolean booleanExtra = intent.getBooleanExtra("share_success", true);
            Log.i("MyvuSharePlugin", "收到微博广播 onReceive: " + booleanExtra);
            if (!booleanExtra) {
                this.f6429a.success(this.b.b(2, intent.getStringExtra("error_msg")));
            } else {
                this.f6429a.success(MyvuSharePlugin.c(this.b, 1, (String) null, 2, (Object) null));
            }
            new File(this.c).delete();
            context.unregisterReceiver(this);
        }
    }
}
