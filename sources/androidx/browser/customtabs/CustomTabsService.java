package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class CustomTabsService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap f420a = new SimpleArrayMap();
    public ICustomTabsService.Stub b = new ICustomTabsService.Stub() {
        @Nullable
        private PendingIntent getSessionIdFromBundle(@Nullable Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
            bundle.remove("android.support.customtabs.extra.SESSION_ID");
            return pendingIntent;
        }

        @Nullable
        private Uri getTargetOriginFromBundle(@Nullable Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            return Build.VERSION.SDK_INT >= 33 ? (Uri) Api33Impl.a(bundle, "target_origin", Uri.class) : (Uri) bundle.getParcelable("target_origin");
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$newSessionInternal$0(CustomTabsSessionToken customTabsSessionToken) {
            CustomTabsService.this.a(customTabsSessionToken);
        }

        private boolean newSessionInternal(@NonNull ICustomTabsCallback iCustomTabsCallback, @Nullable PendingIntent pendingIntent) {
            CustomTabsSessionToken customTabsSessionToken = new CustomTabsSessionToken(iCustomTabsCallback, pendingIntent);
            try {
                a aVar = new a(this, customTabsSessionToken);
                synchronized (CustomTabsService.this.f420a) {
                    iCustomTabsCallback.asBinder().linkToDeath(aVar, 0);
                    CustomTabsService.this.f420a.put(iCustomTabsCallback.asBinder(), aVar);
                }
                return CustomTabsService.this.e(customTabsSessionToken);
            } catch (RemoteException unused) {
                return false;
            }
        }

        public Bundle extraCommand(@NonNull String str, @Nullable Bundle bundle) {
            return CustomTabsService.this.b(str, bundle);
        }

        public boolean isEngagementSignalsApiAvailable(ICustomTabsCallback iCustomTabsCallback, @NonNull Bundle bundle) {
            return CustomTabsService.this.c(new CustomTabsSessionToken(iCustomTabsCallback, getSessionIdFromBundle(bundle)), bundle);
        }

        public boolean mayLaunchUrl(@Nullable ICustomTabsCallback iCustomTabsCallback, @Nullable Uri uri, @Nullable Bundle bundle, @Nullable List<Bundle> list) {
            return CustomTabsService.this.d(new CustomTabsSessionToken(iCustomTabsCallback, getSessionIdFromBundle(bundle)), uri, bundle, list);
        }

        public boolean newSession(@NonNull ICustomTabsCallback iCustomTabsCallback) {
            return newSessionInternal(iCustomTabsCallback, (PendingIntent) null);
        }

        public boolean newSessionWithExtras(@NonNull ICustomTabsCallback iCustomTabsCallback, @Nullable Bundle bundle) {
            return newSessionInternal(iCustomTabsCallback, getSessionIdFromBundle(bundle));
        }

        public int postMessage(@NonNull ICustomTabsCallback iCustomTabsCallback, @NonNull String str, @Nullable Bundle bundle) {
            return CustomTabsService.this.f(new CustomTabsSessionToken(iCustomTabsCallback, getSessionIdFromBundle(bundle)), str, bundle);
        }

        public boolean receiveFile(@NonNull ICustomTabsCallback iCustomTabsCallback, @NonNull Uri uri, int i, @Nullable Bundle bundle) {
            return CustomTabsService.this.g(new CustomTabsSessionToken(iCustomTabsCallback, getSessionIdFromBundle(bundle)), uri, i, bundle);
        }

        public boolean requestPostMessageChannel(@NonNull ICustomTabsCallback iCustomTabsCallback, @NonNull Uri uri) {
            return CustomTabsService.this.i(new CustomTabsSessionToken(iCustomTabsCallback, (PendingIntent) null), uri, (Uri) null, new Bundle());
        }

        public boolean requestPostMessageChannelWithExtras(@NonNull ICustomTabsCallback iCustomTabsCallback, @NonNull Uri uri, @NonNull Bundle bundle) {
            return CustomTabsService.this.i(new CustomTabsSessionToken(iCustomTabsCallback, getSessionIdFromBundle(bundle)), uri, getTargetOriginFromBundle(bundle), bundle);
        }

        public boolean setEngagementSignalsCallback(@NonNull ICustomTabsCallback iCustomTabsCallback, @NonNull IBinder iBinder, @NonNull Bundle bundle) {
            return CustomTabsService.this.j(new CustomTabsSessionToken(iCustomTabsCallback, getSessionIdFromBundle(bundle)), EngagementSignalsCallbackRemote.a(iBinder), bundle);
        }

        public boolean updateVisuals(@NonNull ICustomTabsCallback iCustomTabsCallback, @Nullable Bundle bundle) {
            return CustomTabsService.this.k(new CustomTabsSessionToken(iCustomTabsCallback, getSessionIdFromBundle(bundle)), bundle);
        }

        public boolean validateRelationship(@NonNull ICustomTabsCallback iCustomTabsCallback, int i, @NonNull Uri uri, @Nullable Bundle bundle) {
            return CustomTabsService.this.l(new CustomTabsSessionToken(iCustomTabsCallback, getSessionIdFromBundle(bundle)), i, uri, bundle);
        }

        public boolean warmup(long j) {
            return CustomTabsService.this.m(j);
        }
    };

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface FilePurpose {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Relation {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Result {
    }

    public boolean a(CustomTabsSessionToken customTabsSessionToken) {
        try {
            synchronized (this.f420a) {
                IBinder a2 = customTabsSessionToken.a();
                if (a2 == null) {
                    return false;
                }
                a2.unlinkToDeath((IBinder.DeathRecipient) this.f420a.get(a2), 0);
                this.f420a.remove(a2);
                return true;
            }
        } catch (NoSuchElementException unused) {
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public abstract Bundle b(String str, Bundle bundle);

    public boolean c(CustomTabsSessionToken customTabsSessionToken, Bundle bundle) {
        return false;
    }

    public abstract boolean d(CustomTabsSessionToken customTabsSessionToken, Uri uri, Bundle bundle, List list);

    public abstract boolean e(CustomTabsSessionToken customTabsSessionToken);

    public abstract int f(CustomTabsSessionToken customTabsSessionToken, String str, Bundle bundle);

    public abstract boolean g(CustomTabsSessionToken customTabsSessionToken, Uri uri, int i, Bundle bundle);

    public abstract boolean h(CustomTabsSessionToken customTabsSessionToken, Uri uri);

    public boolean i(CustomTabsSessionToken customTabsSessionToken, Uri uri, Uri uri2, Bundle bundle) {
        return h(customTabsSessionToken, uri);
    }

    public boolean j(CustomTabsSessionToken customTabsSessionToken, EngagementSignalsCallback engagementSignalsCallback, Bundle bundle) {
        return false;
    }

    public abstract boolean k(CustomTabsSessionToken customTabsSessionToken, Bundle bundle);

    public abstract boolean l(CustomTabsSessionToken customTabsSessionToken, int i, Uri uri, Bundle bundle);

    public abstract boolean m(long j);

    public IBinder onBind(Intent intent) {
        return this.b;
    }
}
