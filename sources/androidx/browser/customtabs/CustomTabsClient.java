package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsService;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class CustomTabsClient {

    /* renamed from: a  reason: collision with root package name */
    public final ICustomTabsService f407a;
    public final ComponentName b;
    public final Context c;

    /* renamed from: androidx.browser.customtabs.CustomTabsClient$1  reason: invalid class name */
    class AnonymousClass1 extends CustomTabsServiceConnection {
        public final /* synthetic */ Context b;

        public final void a(ComponentName componentName, CustomTabsClient customTabsClient) {
            customTabsClient.c(0);
            this.b.unbindService(this);
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public CustomTabsClient(ICustomTabsService iCustomTabsService, ComponentName componentName, Context context) {
        this.f407a = iCustomTabsService;
        this.b = componentName;
        this.c = context;
    }

    public static String a(Context context, List list) {
        return b(context, list, false);
    }

    public static String b(Context context, List list, boolean z) {
        ResolveInfo resolveActivity;
        PackageManager packageManager = context.getPackageManager();
        List<String> arrayList = list == null ? new ArrayList<>() : list;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://"));
        if (!z && (resolveActivity = packageManager.resolveActivity(intent, 0)) != null) {
            String str = resolveActivity.activityInfo.packageName;
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 1);
            arrayList2.add(str);
            if (list != null) {
                arrayList2.addAll(list);
            }
            arrayList = arrayList2;
        }
        Intent intent2 = new Intent("android.support.customtabs.action.CustomTabsService");
        for (String str2 : arrayList) {
            intent2.setPackage(str2);
            if (packageManager.resolveService(intent2, 0) != null) {
                return str2;
            }
        }
        if (Build.VERSION.SDK_INT < 30) {
            return null;
        }
        Log.w("CustomTabsClient", "Unable to find any Custom Tabs packages, you may need to add a <queries> element to your manifest. See the docs for CustomTabsClient#getPackageName.");
        return null;
    }

    public boolean c(long j) {
        try {
            return this.f407a.warmup(j);
        } catch (RemoteException unused) {
            return false;
        }
    }
}
