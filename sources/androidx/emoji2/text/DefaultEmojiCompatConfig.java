package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.provider.FontRequest;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DefaultEmojiCompatConfig {

    @RestrictTo
    public static class DefaultEmojiCompatConfigFactory {

        /* renamed from: a  reason: collision with root package name */
        public final DefaultEmojiCompatConfigHelper f1191a;

        public DefaultEmojiCompatConfigFactory(DefaultEmojiCompatConfigHelper defaultEmojiCompatConfigHelper) {
            this.f1191a = defaultEmojiCompatConfigHelper == null ? e() : defaultEmojiCompatConfigHelper;
        }

        public static DefaultEmojiCompatConfigHelper e() {
            return new DefaultEmojiCompatConfigHelper_API28();
        }

        public final EmojiCompat.Config a(Context context, FontRequest fontRequest) {
            if (fontRequest == null) {
                return null;
            }
            return new FontRequestEmojiCompatConfig(context, fontRequest);
        }

        public final List b(Signature[] signatureArr) {
            ArrayList arrayList = new ArrayList();
            for (Signature byteArray : signatureArr) {
                arrayList.add(byteArray.toByteArray());
            }
            return Collections.singletonList(arrayList);
        }

        public EmojiCompat.Config c(Context context) {
            return a(context, h(context));
        }

        public final FontRequest d(ProviderInfo providerInfo, PackageManager packageManager) {
            String str = providerInfo.authority;
            String str2 = providerInfo.packageName;
            return new FontRequest(str, str2, "emojicompat-emoji-font", b(this.f1191a.b(packageManager, str2)));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
            r0 = r1.applicationInfo;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean f(android.content.pm.ProviderInfo r1) {
            /*
                r0 = this;
                if (r1 == 0) goto L_0x000d
                android.content.pm.ApplicationInfo r0 = r1.applicationInfo
                if (r0 == 0) goto L_0x000d
                int r0 = r0.flags
                r1 = 1
                r0 = r0 & r1
                if (r0 != r1) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                r1 = 0
            L_0x000e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory.f(android.content.pm.ProviderInfo):boolean");
        }

        public final ProviderInfo g(PackageManager packageManager) {
            for (ResolveInfo a2 : this.f1191a.c(packageManager, new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0)) {
                ProviderInfo a3 = this.f1191a.a(a2);
                if (f(a3)) {
                    return a3;
                }
            }
            return null;
        }

        public FontRequest h(Context context) {
            PackageManager packageManager = context.getPackageManager();
            Preconditions.i(packageManager, "Package manager required to locate emoji font provider");
            ProviderInfo g = g(packageManager);
            if (g == null) {
                return null;
            }
            try {
                return d(g, packageManager);
            } catch (PackageManager.NameNotFoundException e) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e);
                return null;
            }
        }
    }

    @RestrictTo
    public static class DefaultEmojiCompatConfigHelper {
        public ProviderInfo a(ResolveInfo resolveInfo) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        public Signature[] b(PackageManager packageManager, String str) {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        public List c(PackageManager packageManager, Intent intent, int i) {
            return Collections.emptyList();
        }
    }

    @RequiresApi
    @RestrictTo
    public static class DefaultEmojiCompatConfigHelper_API19 extends DefaultEmojiCompatConfigHelper {
        public ProviderInfo a(ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        public List c(PackageManager packageManager, Intent intent, int i) {
            return packageManager.queryIntentContentProviders(intent, i);
        }
    }

    @RequiresApi
    @RestrictTo
    public static class DefaultEmojiCompatConfigHelper_API28 extends DefaultEmojiCompatConfigHelper_API19 {
        public Signature[] b(PackageManager packageManager, String str) {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    public static FontRequestEmojiCompatConfig a(Context context) {
        return (FontRequestEmojiCompatConfig) new DefaultEmojiCompatConfigFactory((DefaultEmojiCompatConfigHelper) null).c(context);
    }
}
