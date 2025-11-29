package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.GlideSuppliers;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

final class SingletonConnectivityReceiver {
    public static volatile SingletonConnectivityReceiver d;

    /* renamed from: a  reason: collision with root package name */
    public final FrameworkConnectivityMonitor f2684a;
    public final Set b = new HashSet();
    public boolean c;

    public interface FrameworkConnectivityMonitor {
        void a();

        boolean register();
    }

    @RequiresApi
    public static final class FrameworkConnectivityMonitorPostApi24 implements FrameworkConnectivityMonitor {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2687a;
        public final ConnectivityMonitor.ConnectivityListener b;
        public final GlideSuppliers.GlideSupplier c;
        public final ConnectivityManager.NetworkCallback d = new ConnectivityManager.NetworkCallback() {
            public void a(boolean z) {
                Util.b();
                FrameworkConnectivityMonitorPostApi24 frameworkConnectivityMonitorPostApi24 = FrameworkConnectivityMonitorPostApi24.this;
                boolean z2 = frameworkConnectivityMonitorPostApi24.f2687a;
                frameworkConnectivityMonitorPostApi24.f2687a = z;
                if (z2 != z) {
                    frameworkConnectivityMonitorPostApi24.b.a(z);
                }
            }

            public final void b(final boolean z) {
                Util.w(new Runnable() {
                    public void run() {
                        AnonymousClass1.this.a(z);
                    }
                });
            }

            public void onAvailable(Network network) {
                b(true);
            }

            public void onLost(Network network) {
                b(false);
            }
        };

        public FrameworkConnectivityMonitorPostApi24(GlideSuppliers.GlideSupplier glideSupplier, ConnectivityMonitor.ConnectivityListener connectivityListener) {
            this.c = glideSupplier;
            this.b = connectivityListener;
        }

        public void a() {
            ((ConnectivityManager) this.c.get()).unregisterNetworkCallback(this.d);
        }

        public boolean register() {
            this.f2687a = ((ConnectivityManager) this.c.get()).getActiveNetwork() != null;
            try {
                ((ConnectivityManager) this.c.get()).registerDefaultNetworkCallback(this.d);
                return true;
            } catch (RuntimeException e) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register callback", e);
                }
                return false;
            }
        }
    }

    public static final class FrameworkConnectivityMonitorPreApi24 implements FrameworkConnectivityMonitor {
        public static final Executor g = AsyncTask.SERIAL_EXECUTOR;

        /* renamed from: a  reason: collision with root package name */
        public final Context f2690a;
        public final ConnectivityMonitor.ConnectivityListener b;
        public final GlideSuppliers.GlideSupplier c;
        public volatile boolean d;
        public volatile boolean e;
        public final BroadcastReceiver f;

        /* renamed from: com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24$1  reason: invalid class name */
        public class AnonymousClass1 extends BroadcastReceiver {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ FrameworkConnectivityMonitorPreApi24 f2691a;

            public void onReceive(Context context, Intent intent) {
                this.f2691a.d();
            }
        }

        public void a() {
            g.execute(new Runnable() {
                public void run() {
                    if (FrameworkConnectivityMonitorPreApi24.this.e) {
                        FrameworkConnectivityMonitorPreApi24.this.e = false;
                        FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi24 = FrameworkConnectivityMonitorPreApi24.this;
                        frameworkConnectivityMonitorPreApi24.f2690a.unregisterReceiver(frameworkConnectivityMonitorPreApi24.f);
                    }
                }
            });
        }

        public boolean b() {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.c.get()).getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            } catch (RuntimeException e2) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e2);
                }
                return true;
            }
        }

        public void c(final boolean z) {
            Util.w(new Runnable() {
                public void run() {
                    FrameworkConnectivityMonitorPreApi24.this.b.a(z);
                }
            });
        }

        public void d() {
            g.execute(new Runnable() {
                public void run() {
                    boolean z = FrameworkConnectivityMonitorPreApi24.this.d;
                    FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi24 = FrameworkConnectivityMonitorPreApi24.this;
                    frameworkConnectivityMonitorPreApi24.d = frameworkConnectivityMonitorPreApi24.b();
                    if (z != FrameworkConnectivityMonitorPreApi24.this.d) {
                        if (Log.isLoggable("ConnectivityMonitor", 3)) {
                            Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + FrameworkConnectivityMonitorPreApi24.this.d);
                        }
                        FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi242 = FrameworkConnectivityMonitorPreApi24.this;
                        frameworkConnectivityMonitorPreApi242.c(frameworkConnectivityMonitorPreApi242.d);
                    }
                }
            });
        }

        public boolean register() {
            g.execute(new Runnable() {
                public void run() {
                    FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi24 = FrameworkConnectivityMonitorPreApi24.this;
                    frameworkConnectivityMonitorPreApi24.d = frameworkConnectivityMonitorPreApi24.b();
                    try {
                        FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi242 = FrameworkConnectivityMonitorPreApi24.this;
                        frameworkConnectivityMonitorPreApi242.f2690a.registerReceiver(frameworkConnectivityMonitorPreApi242.f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                        FrameworkConnectivityMonitorPreApi24.this.e = true;
                    } catch (SecurityException e) {
                        if (Log.isLoggable("ConnectivityMonitor", 5)) {
                            Log.w("ConnectivityMonitor", "Failed to register", e);
                        }
                        FrameworkConnectivityMonitorPreApi24.this.e = false;
                    }
                }
            });
            return true;
        }
    }

    public SingletonConnectivityReceiver(final Context context) {
        this.f2684a = new FrameworkConnectivityMonitorPostApi24(GlideSuppliers.a(new GlideSuppliers.GlideSupplier<ConnectivityManager>() {
            /* renamed from: a */
            public ConnectivityManager get() {
                return (ConnectivityManager) context.getSystemService("connectivity");
            }
        }), new ConnectivityMonitor.ConnectivityListener() {
            public void a(boolean z) {
                ArrayList<ConnectivityMonitor.ConnectivityListener> arrayList;
                Util.b();
                synchronized (SingletonConnectivityReceiver.this) {
                    arrayList = new ArrayList<>(SingletonConnectivityReceiver.this.b);
                }
                for (ConnectivityMonitor.ConnectivityListener a2 : arrayList) {
                    a2.a(z);
                }
            }
        });
    }

    public static SingletonConnectivityReceiver a(Context context) {
        if (d == null) {
            synchronized (SingletonConnectivityReceiver.class) {
                try {
                    if (d == null) {
                        d = new SingletonConnectivityReceiver(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public final void b() {
        if (!this.c && !this.b.isEmpty()) {
            this.c = this.f2684a.register();
        }
    }

    public final void c() {
        if (this.c && this.b.isEmpty()) {
            this.f2684a.a();
            this.c = false;
        }
    }

    public synchronized void d(ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.b.add(connectivityListener);
        b();
    }

    public synchronized void e(ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.b.remove(connectivityListener);
        c();
    }
}
