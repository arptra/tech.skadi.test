package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.util.Log;
import androidx.annotation.NonNull;

public class CustomTabsSessionToken {

    /* renamed from: a  reason: collision with root package name */
    public final ICustomTabsCallback f422a;
    public final PendingIntent b;
    public final CustomTabsCallback c;

    public static class MockCallback extends ICustomTabsCallback.Stub {
        public IBinder asBinder() {
            return this;
        }

        public void extraCallback(String str, Bundle bundle) {
        }

        public Bundle extraCallbackWithResult(String str, Bundle bundle) {
            return null;
        }

        public void onActivityLayout(int i, int i2, int i3, int i4, int i5, @NonNull Bundle bundle) {
        }

        public void onActivityResized(int i, int i2, Bundle bundle) {
        }

        public void onMessageChannelReady(Bundle bundle) {
        }

        public void onMinimized(@NonNull Bundle bundle) {
        }

        public void onNavigationEvent(int i, Bundle bundle) {
        }

        public void onPostMessage(String str, Bundle bundle) {
        }

        public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
        }

        public void onUnminimized(@NonNull Bundle bundle) {
        }

        public void onWarmupCompleted(Bundle bundle) {
        }
    }

    public CustomTabsSessionToken(ICustomTabsCallback iCustomTabsCallback, PendingIntent pendingIntent) {
        if (iCustomTabsCallback == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.f422a = iCustomTabsCallback;
        this.b = pendingIntent;
        this.c = iCustomTabsCallback == null ? null : new CustomTabsCallback() {
            public void a(String str, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f422a.extraCallback(str, bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            public Bundle b(String str, Bundle bundle) {
                try {
                    return CustomTabsSessionToken.this.f422a.extraCallbackWithResult(str, bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                    return null;
                }
            }

            public void c(int i, int i2, int i3, int i4, int i5, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f422a.onActivityLayout(i, i2, i3, i4, i5, bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            public void d(int i, int i2, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f422a.onActivityResized(i, i2, bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            public void e(Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f422a.onMessageChannelReady(bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            public void f(Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f422a.onMinimized(bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            public void g(int i, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f422a.onNavigationEvent(i, bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            public void h(String str, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f422a.onPostMessage(str, bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            public void i(int i, Uri uri, boolean z, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f422a.onRelationshipValidationResult(i, uri, z, bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            public void j(Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f422a.onUnminimized(bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            public void k(Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f422a.onWarmupCompleted(bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }
        };
    }

    public IBinder a() {
        ICustomTabsCallback iCustomTabsCallback = this.f422a;
        if (iCustomTabsCallback == null) {
            return null;
        }
        return iCustomTabsCallback.asBinder();
    }

    public final IBinder b() {
        ICustomTabsCallback iCustomTabsCallback = this.f422a;
        if (iCustomTabsCallback != null) {
            return iCustomTabsCallback.asBinder();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    public PendingIntent c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CustomTabsSessionToken)) {
            return false;
        }
        CustomTabsSessionToken customTabsSessionToken = (CustomTabsSessionToken) obj;
        PendingIntent c2 = customTabsSessionToken.c();
        PendingIntent pendingIntent = this.b;
        boolean z = true;
        boolean z2 = pendingIntent == null;
        if (c2 != null) {
            z = false;
        }
        if (z2 != z) {
            return false;
        }
        return pendingIntent != null ? pendingIntent.equals(c2) : b().equals(customTabsSessionToken.b());
    }

    public int hashCode() {
        PendingIntent pendingIntent = this.b;
        return pendingIntent != null ? pendingIntent.hashCode() : b().hashCode();
    }
}
