package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import androidx.media.MediaSessionManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    public static final boolean h = Log.isLoggable("MBServiceCompat", 3);

    /* renamed from: a  reason: collision with root package name */
    public MediaBrowserServiceImpl f1430a;
    public final ConnectionRecord b = new ConnectionRecord("android.media.session.MediaController", -1, -1, (Bundle) null, (ServiceCallbacks) null);
    public final ArrayList c = new ArrayList();
    public final ArrayMap d = new ArrayMap();
    public ConnectionRecord e;
    public final ServiceHandler f = new ServiceHandler();
    public MediaSessionCompat.Token g;

    public static final class BrowserRoot {

        /* renamed from: a  reason: collision with root package name */
        public final String f1431a;
        public final Bundle b;

        public BrowserRoot(String str, Bundle bundle) {
            if (str != null) {
                this.f1431a = str;
                this.b = bundle;
                return;
            }
            throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
        }

        public Bundle c() {
            return this.b;
        }

        public String d() {
            return this.f1431a;
        }
    }

    public class ConnectionRecord implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        public final String f1432a;
        public final int b;
        public final int c;
        public final MediaSessionManager.RemoteUserInfo d;
        public final Bundle e;
        public final ServiceCallbacks f;
        public final HashMap g = new HashMap();
        public BrowserRoot h;

        public ConnectionRecord(String str, int i2, int i3, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            this.f1432a = str;
            this.b = i2;
            this.c = i3;
            this.d = new MediaSessionManager.RemoteUserInfo(str, i2, i3);
            this.e = bundle;
            this.f = serviceCallbacks;
        }

        public void binderDied() {
            MediaBrowserServiceCompat.this.f.post(new Runnable() {
                public void run() {
                    ConnectionRecord connectionRecord = ConnectionRecord.this;
                    MediaBrowserServiceCompat.this.d.remove(connectionRecord.f.asBinder());
                }
            });
        }
    }

    public interface MediaBrowserServiceImpl {
        IBinder a(Intent intent);

        void onCreate();
    }

    @RequiresApi
    public class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl {

        /* renamed from: a  reason: collision with root package name */
        public final List f1434a = new ArrayList();
        public MediaBrowserService b;
        public Messenger c;

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$1  reason: invalid class name */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ MediaSessionCompat.Token f1435a;
            public final /* synthetic */ MediaBrowserServiceImplApi21 b;

            public void run() {
                if (!this.b.f1434a.isEmpty()) {
                    IMediaSession extraBinder = this.f1435a.getExtraBinder();
                    if (extraBinder != null) {
                        for (Bundle b2 : this.b.f1434a) {
                            BundleCompat.b(b2, "extra_session_binder", extraBinder.asBinder());
                        }
                    }
                    this.b.f1434a.clear();
                }
                this.b.b.setSessionToken((MediaSession.Token) this.f1435a.getToken());
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3  reason: invalid class name */
        class AnonymousClass3 implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f1436a;
            public final /* synthetic */ Bundle b;
            public final /* synthetic */ MediaBrowserServiceImplApi21 c;

            public void run() {
                for (IBinder iBinder : MediaBrowserServiceCompat.this.d.keySet()) {
                    ArrayMap arrayMap = MediaBrowserServiceCompat.this.d;
                    this.c.b((ConnectionRecord) arrayMap.get(iBinder), this.f1436a, this.b);
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$4  reason: invalid class name */
        class AnonymousClass4 implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ MediaSessionManager.RemoteUserInfo f1437a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Bundle c;
            public final /* synthetic */ MediaBrowserServiceImplApi21 d;

            public void run() {
                for (int i = 0; i < MediaBrowserServiceCompat.this.d.size(); i++) {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.d.n(i);
                    if (connectionRecord.d.equals(this.f1437a)) {
                        this.d.b(connectionRecord, this.b, this.c);
                    }
                }
            }
        }

        public class MediaBrowserServiceApi21 extends MediaBrowserService {
            public MediaBrowserServiceApi21(Context context) {
                attachBaseContext(context);
            }

            public MediaBrowserService.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                BrowserRoot c = MediaBrowserServiceImplApi21.this.c(str, i, bundle == null ? null : new Bundle(bundle));
                if (c == null) {
                    return null;
                }
                return new MediaBrowserService.BrowserRoot(c.f1431a, c.b);
            }

            public void onLoadChildren(String str, MediaBrowserService.Result result) {
                MediaBrowserServiceImplApi21.this.d(str, new ResultWrapper(result));
            }
        }

        public MediaBrowserServiceImplApi21() {
        }

        public IBinder a(Intent intent) {
            return this.b.onBind(intent);
        }

        public void b(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair> list = (List) connectionRecord.g.get(str);
            if (list != null) {
                for (Pair pair : list) {
                    if (MediaBrowserCompatUtils.b(bundle, (Bundle) pair.b)) {
                        MediaBrowserServiceCompat.this.m(str, connectionRecord, (Bundle) pair.b, bundle);
                    }
                }
            }
        }

        public BrowserRoot c(String str, int i, Bundle bundle) {
            Bundle bundle2;
            int i2 = -1;
            if (bundle == null || bundle.getInt("extra_client_version", 0) == 0) {
                bundle2 = null;
            } else {
                bundle.remove("extra_client_version");
                this.c = new Messenger(MediaBrowserServiceCompat.this.f);
                bundle2 = new Bundle();
                bundle2.putInt("extra_service_version", 2);
                BundleCompat.b(bundle2, "extra_messenger", this.c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.g;
                if (token != null) {
                    IMediaSession extraBinder = token.getExtraBinder();
                    BundleCompat.b(bundle2, "extra_session_binder", extraBinder == null ? null : extraBinder.asBinder());
                } else {
                    this.f1434a.add(bundle2);
                }
                i2 = bundle.getInt("extra_calling_pid", -1);
                bundle.remove("extra_calling_pid");
            }
            ConnectionRecord connectionRecord = new ConnectionRecord(str, i2, i, bundle, (ServiceCallbacks) null);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.e = connectionRecord;
            BrowserRoot e = mediaBrowserServiceCompat.e(str, i, bundle);
            MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat2.e = null;
            if (e == null) {
                return null;
            }
            if (this.c != null) {
                mediaBrowserServiceCompat2.c.add(connectionRecord);
            }
            if (bundle2 == null) {
                bundle2 = e.c();
            } else if (e.c() != null) {
                bundle2.putAll(e.c());
            }
            return new BrowserRoot(e.d(), bundle2);
        }

        public void d(String str, final ResultWrapper resultWrapper) {
            AnonymousClass2 r0 = new Result<List<MediaBrowserCompat.MediaItem>>(str) {
                /* renamed from: h */
                public void d(List list) {
                    ArrayList arrayList;
                    if (list != null) {
                        arrayList = new ArrayList();
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            Parcel obtain = Parcel.obtain();
                            ((MediaBrowserCompat.MediaItem) it.next()).writeToParcel(obtain, 0);
                            arrayList.add(obtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    resultWrapper.b(arrayList);
                }
            };
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.e = mediaBrowserServiceCompat.b;
            mediaBrowserServiceCompat.f(str, r0);
            MediaBrowserServiceCompat.this.e = null;
        }

        public void onCreate() {
            MediaBrowserServiceApi21 mediaBrowserServiceApi21 = new MediaBrowserServiceApi21(MediaBrowserServiceCompat.this);
            this.b = mediaBrowserServiceApi21;
            mediaBrowserServiceApi21.onCreate();
        }
    }

    @RequiresApi
    public class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 {

        public class MediaBrowserServiceApi23 extends MediaBrowserServiceImplApi21.MediaBrowserServiceApi21 {
            public MediaBrowserServiceApi23(Context context) {
                super(context);
            }

            public void onLoadItem(String str, MediaBrowserService.Result result) {
                MediaBrowserServiceImplApi23.this.e(str, new ResultWrapper(result));
            }
        }

        public MediaBrowserServiceImplApi23() {
            super();
        }

        public void e(String str, final ResultWrapper resultWrapper) {
            AnonymousClass1 r0 = new Result<MediaBrowserCompat.MediaItem>(str) {
                /* renamed from: h */
                public void d(MediaBrowserCompat.MediaItem mediaItem) {
                    if (mediaItem == null) {
                        resultWrapper.b((Object) null);
                        return;
                    }
                    Parcel obtain = Parcel.obtain();
                    mediaItem.writeToParcel(obtain, 0);
                    resultWrapper.b(obtain);
                }
            };
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.e = mediaBrowserServiceCompat.b;
            mediaBrowserServiceCompat.h(str, r0);
            MediaBrowserServiceCompat.this.e = null;
        }

        public void onCreate() {
            MediaBrowserServiceApi23 mediaBrowserServiceApi23 = new MediaBrowserServiceApi23(MediaBrowserServiceCompat.this);
            this.b = mediaBrowserServiceApi23;
            mediaBrowserServiceApi23.onCreate();
        }
    }

    @RequiresApi
    public class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 {

        public class MediaBrowserServiceApi26 extends MediaBrowserServiceImplApi23.MediaBrowserServiceApi23 {
            public MediaBrowserServiceApi26(Context context) {
                super(context);
            }

            public void onLoadChildren(String str, MediaBrowserService.Result result, Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                MediaBrowserServiceImplApi26 mediaBrowserServiceImplApi26 = MediaBrowserServiceImplApi26.this;
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.e = mediaBrowserServiceCompat.b;
                mediaBrowserServiceImplApi26.f(str, new ResultWrapper(result), bundle);
                MediaBrowserServiceCompat.this.e = null;
            }
        }

        public MediaBrowserServiceImplApi26() {
            super();
        }

        public void f(String str, final ResultWrapper resultWrapper, final Bundle bundle) {
            AnonymousClass1 r0 = new Result<List<MediaBrowserCompat.MediaItem>>(str) {
                /* renamed from: h */
                public void d(List<MediaBrowserCompat.MediaItem> list) {
                    if (list == null) {
                        resultWrapper.b((Object) null);
                        return;
                    }
                    if ((a() & 1) != 0) {
                        list = MediaBrowserServiceCompat.this.b(list, bundle);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (MediaBrowserCompat.MediaItem writeToParcel : list) {
                        Parcel obtain = Parcel.obtain();
                        writeToParcel.writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                    resultWrapper.b(arrayList);
                }
            };
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.e = mediaBrowserServiceCompat.b;
            mediaBrowserServiceCompat.g(str, r0, bundle);
            MediaBrowserServiceCompat.this.e = null;
        }

        public void onCreate() {
            MediaBrowserServiceApi26 mediaBrowserServiceApi26 = new MediaBrowserServiceApi26(MediaBrowserServiceCompat.this);
            this.b = mediaBrowserServiceApi26;
            mediaBrowserServiceApi26.onCreate();
        }
    }

    @RequiresApi
    public class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
        public MediaBrowserServiceImplApi28() {
            super();
        }
    }

    public class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {

        /* renamed from: a  reason: collision with root package name */
        public Messenger f1439a;
        public final /* synthetic */ MediaBrowserServiceCompat b;

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1  reason: invalid class name */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ MediaSessionCompat.Token f1440a;
            public final /* synthetic */ MediaBrowserServiceImplBase b;

            public void run() {
                Iterator it = this.b.b.d.values().iterator();
                while (it.hasNext()) {
                    ConnectionRecord connectionRecord = (ConnectionRecord) it.next();
                    try {
                        connectionRecord.f.b(connectionRecord.h.d(), this.f1440a, connectionRecord.h.c());
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "Connection for " + connectionRecord.f1432a + " is no longer valid.");
                        it.remove();
                    }
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$2  reason: invalid class name */
        class AnonymousClass2 implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f1441a;
            public final /* synthetic */ Bundle b;
            public final /* synthetic */ MediaBrowserServiceImplBase c;

            public void run() {
                for (IBinder iBinder : this.c.b.d.keySet()) {
                    ArrayMap arrayMap = this.c.b.d;
                    this.c.b((ConnectionRecord) arrayMap.get(iBinder), this.f1441a, this.b);
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3  reason: invalid class name */
        class AnonymousClass3 implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ MediaSessionManager.RemoteUserInfo f1442a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Bundle c;
            public final /* synthetic */ MediaBrowserServiceImplBase d;

            public void run() {
                for (int i = 0; i < this.d.b.d.size(); i++) {
                    ConnectionRecord connectionRecord = (ConnectionRecord) this.d.b.d.n(i);
                    if (connectionRecord.d.equals(this.f1442a)) {
                        this.d.b(connectionRecord, this.b, this.c);
                        return;
                    }
                }
            }
        }

        public IBinder a(Intent intent) {
            if ("android.media.browse.MediaBrowserService".equals(intent.getAction())) {
                return this.f1439a.getBinder();
            }
            return null;
        }

        public void b(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair> list = (List) connectionRecord.g.get(str);
            if (list != null) {
                for (Pair pair : list) {
                    if (MediaBrowserCompatUtils.b(bundle, (Bundle) pair.b)) {
                        this.b.m(str, connectionRecord, (Bundle) pair.b, bundle);
                    }
                }
            }
        }

        public void onCreate() {
            this.f1439a = new Messenger(this.b.f);
        }
    }

    public static class Result<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f1443a;
        public boolean b;
        public boolean c;
        public boolean d;
        public int e;

        public Result(Object obj) {
            this.f1443a = obj;
        }

        public int a() {
            return this.e;
        }

        public boolean b() {
            return this.b || this.c || this.d;
        }

        public void c(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f1443a);
        }

        public void d(Object obj) {
        }

        public void e(Bundle bundle) {
            if (this.c || this.d) {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f1443a);
            }
            this.d = true;
            c(bundle);
        }

        public void f(Object obj) {
            if (this.c || this.d) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f1443a);
            }
            this.c = true;
            d(obj);
        }

        public void g(int i) {
            this.e = i;
        }
    }

    @RequiresApi
    public static class ResultWrapper<T> {

        /* renamed from: a  reason: collision with root package name */
        public MediaBrowserService.Result f1444a;

        public ResultWrapper(MediaBrowserService.Result result) {
            this.f1444a = result;
        }

        public List a(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Parcel parcel = (Parcel) it.next();
                parcel.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }

        public void b(Object obj) {
            if (obj instanceof List) {
                this.f1444a.sendResult(a((List) obj));
            } else if (obj instanceof Parcel) {
                Parcel parcel = (Parcel) obj;
                parcel.setDataPosition(0);
                this.f1444a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            } else {
                this.f1444a.sendResult((Object) null);
            }
        }
    }

    public class ServiceBinderImpl {
        public ServiceBinderImpl() {
        }

        public void a(String str, IBinder iBinder, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
            final String str2 = str;
            final IBinder iBinder2 = iBinder;
            final Bundle bundle2 = bundle;
            MediaBrowserServiceCompat.this.f.a(new Runnable() {
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.d.get(serviceCallbacks2.asBinder());
                    if (connectionRecord == null) {
                        Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + str2);
                        return;
                    }
                    MediaBrowserServiceCompat.this.a(str2, connectionRecord, iBinder2, bundle2);
                }
            });
        }

        public void b(String str, int i, int i2, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            if (MediaBrowserServiceCompat.this.c(str, i2)) {
                final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
                final String str2 = str;
                final int i3 = i;
                final int i4 = i2;
                final Bundle bundle2 = bundle;
                MediaBrowserServiceCompat.this.f.a(new Runnable() {
                    public void run() {
                        IBinder asBinder = serviceCallbacks2.asBinder();
                        MediaBrowserServiceCompat.this.d.remove(asBinder);
                        ConnectionRecord connectionRecord = new ConnectionRecord(str2, i3, i4, bundle2, serviceCallbacks2);
                        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                        mediaBrowserServiceCompat.e = connectionRecord;
                        BrowserRoot e2 = mediaBrowserServiceCompat.e(str2, i4, bundle2);
                        connectionRecord.h = e2;
                        MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
                        mediaBrowserServiceCompat2.e = null;
                        if (e2 == null) {
                            Log.i("MBServiceCompat", "No root for client " + str2 + " from service " + getClass().getName());
                            try {
                                serviceCallbacks2.onConnectFailed();
                            } catch (RemoteException unused) {
                                Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + str2);
                            }
                        } else {
                            try {
                                mediaBrowserServiceCompat2.d.put(asBinder, connectionRecord);
                                asBinder.linkToDeath(connectionRecord, 0);
                                if (MediaBrowserServiceCompat.this.g != null) {
                                    serviceCallbacks2.b(connectionRecord.h.d(), MediaBrowserServiceCompat.this.g, connectionRecord.h.c());
                                }
                            } catch (RemoteException unused2) {
                                Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + str2);
                                MediaBrowserServiceCompat.this.d.remove(asBinder);
                            }
                        }
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i2 + " package=" + str);
        }

        public void c(final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.f.a(new Runnable() {
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.d.remove(serviceCallbacks.asBinder());
                    if (connectionRecord != null) {
                        connectionRecord.f.asBinder().unlinkToDeath(connectionRecord, 0);
                    }
                }
            });
        }

        public void d(final String str, final ResultReceiver resultReceiver, final ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f.a(new Runnable() {
                    public void run() {
                        ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.d.get(serviceCallbacks.asBinder());
                        if (connectionRecord == null) {
                            Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + str);
                            return;
                        }
                        MediaBrowserServiceCompat.this.n(str, connectionRecord, resultReceiver);
                    }
                });
            }
        }

        public void e(ServiceCallbacks serviceCallbacks, String str, int i, int i2, Bundle bundle) {
            final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
            final int i3 = i2;
            final String str2 = str;
            final int i4 = i;
            final Bundle bundle2 = bundle;
            MediaBrowserServiceCompat.this.f.a(new Runnable() {
                public void run() {
                    IBinder asBinder = serviceCallbacks2.asBinder();
                    MediaBrowserServiceCompat.this.d.remove(asBinder);
                    Iterator it = MediaBrowserServiceCompat.this.c.iterator();
                    ConnectionRecord connectionRecord = null;
                    while (it.hasNext()) {
                        ConnectionRecord connectionRecord2 = (ConnectionRecord) it.next();
                        if (connectionRecord2.c == i3) {
                            if (TextUtils.isEmpty(str2) || i4 <= 0) {
                                connectionRecord = new ConnectionRecord(connectionRecord2.f1432a, connectionRecord2.b, connectionRecord2.c, bundle2, serviceCallbacks2);
                            }
                            it.remove();
                        }
                    }
                    if (connectionRecord == null) {
                        connectionRecord = new ConnectionRecord(str2, i4, i3, bundle2, serviceCallbacks2);
                    }
                    MediaBrowserServiceCompat.this.d.put(asBinder, connectionRecord);
                    try {
                        asBinder.linkToDeath(connectionRecord, 0);
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "IBinder is already dead.");
                    }
                }
            });
        }

        public void f(final String str, final IBinder iBinder, final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.f.a(new Runnable() {
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.d.get(serviceCallbacks.asBinder());
                    if (connectionRecord == null) {
                        Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + str);
                    } else if (!MediaBrowserServiceCompat.this.p(str, connectionRecord, iBinder)) {
                        Log.w("MBServiceCompat", "removeSubscription called for " + str + " which is not subscribed");
                    }
                }
            });
        }

        public void g(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                final ResultReceiver resultReceiver2 = resultReceiver;
                MediaBrowserServiceCompat.this.f.a(new Runnable() {
                    public void run() {
                        ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.d.get(serviceCallbacks2.asBinder());
                        if (connectionRecord == null) {
                            Log.w("MBServiceCompat", "search for callback that isn't registered query=" + str2);
                            return;
                        }
                        MediaBrowserServiceCompat.this.o(str2, bundle2, connectionRecord, resultReceiver2);
                    }
                });
            }
        }

        public void h(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                final ResultReceiver resultReceiver2 = resultReceiver;
                MediaBrowserServiceCompat.this.f.a(new Runnable() {
                    public void run() {
                        ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.d.get(serviceCallbacks2.asBinder());
                        if (connectionRecord == null) {
                            Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + str2 + ", extras=" + bundle2);
                            return;
                        }
                        MediaBrowserServiceCompat.this.l(str2, bundle2, connectionRecord, resultReceiver2);
                    }
                });
            }
        }

        public void i(final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.f.a(new Runnable() {
                public void run() {
                    IBinder asBinder = serviceCallbacks.asBinder();
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.d.remove(asBinder);
                    if (connectionRecord != null) {
                        asBinder.unlinkToDeath(connectionRecord, 0);
                    }
                }
            });
        }
    }

    public interface ServiceCallbacks {
        void a(String str, List list, Bundle bundle, Bundle bundle2);

        IBinder asBinder();

        void b(String str, MediaSessionCompat.Token token, Bundle bundle);

        void onConnectFailed();
    }

    public static class ServiceCallbacksCompat implements ServiceCallbacks {

        /* renamed from: a  reason: collision with root package name */
        public final Messenger f1455a;

        public ServiceCallbacksCompat(Messenger messenger) {
            this.f1455a = messenger;
        }

        public void a(String str, List list, Bundle bundle, Bundle bundle2) {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList(list));
            }
            c(3, bundle3);
        }

        public IBinder asBinder() {
            return this.f1455a.getBinder();
        }

        public void b(String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            c(1, bundle2);
        }

        public final void c(int i, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.f1455a.send(obtain);
        }

        public void onConnectFailed() {
            c(2, (Bundle) null);
        }
    }

    public final class ServiceHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final ServiceBinderImpl f1456a;

        public ServiceHandler() {
            this.f1456a = new ServiceBinderImpl();
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle);
                    this.f1456a.b(data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 2:
                    this.f1456a.c(new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    this.f1456a.a(data.getString("data_media_item_id"), BundleCompat.a(data, "data_callback_token"), bundle2, new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 4:
                    this.f1456a.f(data.getString("data_media_item_id"), BundleCompat.a(data, "data_callback_token"), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 5:
                    this.f1456a.d(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    this.f1456a.e(new ServiceCallbacksCompat(message.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                    return;
                case 7:
                    this.f1456a.i(new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.ensureClassLoader(bundle4);
                    this.f1456a.g(data.getString("data_search_query"), bundle4, (ResultReceiver) data.getParcelable("data_result_receiver"), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.ensureClassLoader(bundle5);
                    this.f1456a.h(data.getString("data_custom_action"), bundle5, (ResultReceiver) data.getParcelable("data_result_receiver"), new ServiceCallbacksCompat(message.replyTo));
                    return;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: " + 2 + "\n  Client version: " + message.arg1);
                    return;
            }
        }

        public boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            int callingPid = Binder.getCallingPid();
            if (callingPid > 0) {
                data.putInt("data_calling_pid", callingPid);
            } else if (!data.containsKey("data_calling_pid")) {
                data.putInt("data_calling_pid", -1);
            }
            return super.sendMessageAtTime(message, j);
        }
    }

    public void a(String str, ConnectionRecord connectionRecord, IBinder iBinder, Bundle bundle) {
        List<Pair> list = (List) connectionRecord.g.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        for (Pair pair : list) {
            if (iBinder == pair.f847a && MediaBrowserCompatUtils.a(bundle, (Bundle) pair.b)) {
                return;
            }
        }
        list.add(new Pair(iBinder, bundle));
        connectionRecord.g.put(str, list);
        m(str, connectionRecord, bundle, (Bundle) null);
        this.e = connectionRecord;
        j(str, bundle);
        this.e = null;
    }

    public List b(List list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (i == -1 && i2 == -1) {
            return list;
        }
        int i3 = i2 * i;
        int i4 = i3 + i2;
        if (i < 0 || i2 < 1 || i3 >= list.size()) {
            return Collections.emptyList();
        }
        if (i4 > list.size()) {
            i4 = list.size();
        }
        return list.subList(i3, i4);
    }

    public boolean c(String str, int i) {
        if (str == null) {
            return false;
        }
        for (String equals : getPackageManager().getPackagesForUid(i)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void d(String str, Bundle bundle, Result result) {
        result.e((Bundle) null);
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract BrowserRoot e(String str, int i, Bundle bundle);

    public abstract void f(String str, Result result);

    public void g(String str, Result result, Bundle bundle) {
        result.g(1);
        f(str, result);
    }

    public void h(String str, Result result) {
        result.g(2);
        result.f((Object) null);
    }

    public void i(String str, Bundle bundle, Result result) {
        result.g(4);
        result.f((Object) null);
    }

    public void j(String str, Bundle bundle) {
    }

    public void k(String str) {
    }

    public void l(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        AnonymousClass4 r0 = new Result<Bundle>(str) {
            public void c(Bundle bundle) {
                resultReceiver.send(-1, bundle);
            }

            /* renamed from: h */
            public void d(Bundle bundle) {
                resultReceiver.send(0, bundle);
            }
        };
        this.e = connectionRecord;
        d(str, bundle, r0);
        this.e = null;
        if (!r0.b()) {
            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
        }
    }

    public void m(String str, ConnectionRecord connectionRecord, Bundle bundle, Bundle bundle2) {
        final ConnectionRecord connectionRecord2 = connectionRecord;
        final String str2 = str;
        final Bundle bundle3 = bundle;
        final Bundle bundle4 = bundle2;
        AnonymousClass1 r0 = new Result<List<MediaBrowserCompat.MediaItem>>(str) {
            /* renamed from: h */
            public void d(List list) {
                if (MediaBrowserServiceCompat.this.d.get(connectionRecord2.f.asBinder()) == connectionRecord2) {
                    if ((a() & 1) != 0) {
                        list = MediaBrowserServiceCompat.this.b(list, bundle3);
                    }
                    try {
                        connectionRecord2.f.a(str2, list, bundle3, bundle4);
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + str2 + " package=" + connectionRecord2.f1432a);
                    }
                } else if (MediaBrowserServiceCompat.h) {
                    Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + connectionRecord2.f1432a + " id=" + str2);
                }
            }
        };
        this.e = connectionRecord;
        if (bundle == null) {
            f(str, r0);
        } else {
            g(str, r0, bundle);
        }
        this.e = null;
        if (!r0.b()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connectionRecord.f1432a + " id=" + str);
        }
    }

    public void n(String str, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        AnonymousClass2 r0 = new Result<MediaBrowserCompat.MediaItem>(str) {
            /* renamed from: h */
            public void d(MediaBrowserCompat.MediaItem mediaItem) {
                if ((a() & 2) != 0) {
                    resultReceiver.send(-1, (Bundle) null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("media_item", mediaItem);
                resultReceiver.send(0, bundle);
            }
        };
        this.e = connectionRecord;
        h(str, r0);
        this.e = null;
        if (!r0.b()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    public void o(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        AnonymousClass3 r0 = new Result<List<MediaBrowserCompat.MediaItem>>(str) {
            /* renamed from: h */
            public void d(List list) {
                if ((a() & 4) != 0 || list == null) {
                    resultReceiver.send(-1, (Bundle) null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
                resultReceiver.send(0, bundle);
            }
        };
        this.e = connectionRecord;
        i(str, bundle, r0);
        this.e = null;
        if (!r0.b()) {
            throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f1430a.a(intent);
    }

    public void onCreate() {
        super.onCreate();
        MediaBrowserServiceImplApi28 mediaBrowserServiceImplApi28 = new MediaBrowserServiceImplApi28();
        this.f1430a = mediaBrowserServiceImplApi28;
        mediaBrowserServiceImplApi28.onCreate();
    }

    public boolean p(String str, ConnectionRecord connectionRecord, IBinder iBinder) {
        boolean z = false;
        if (iBinder == null) {
            try {
                if (connectionRecord.g.remove(str) != null) {
                    z = true;
                }
            } catch (Throwable th) {
                this.e = connectionRecord;
                k(str);
                this.e = null;
                throw th;
            }
        } else {
            List list = (List) connectionRecord.g.get(str);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == ((Pair) it.next()).f847a) {
                        it.remove();
                        z = true;
                    }
                }
                if (list.size() == 0) {
                    connectionRecord.g.remove(str);
                }
            }
        }
        this.e = connectionRecord;
        k(str);
        this.e = null;
        return z;
    }
}
