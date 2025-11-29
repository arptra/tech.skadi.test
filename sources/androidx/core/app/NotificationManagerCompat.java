package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.honey.account.constant.AccountConstantKt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class NotificationManagerCompat {
    public static final Object c = new Object();
    public static String d;
    public static Set e = new HashSet();
    public static final Object f = new Object();
    public static SideChannelManager g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f669a;
    public final NotificationManager b;

    @RequiresApi
    public static class Api23Impl {
        @DoNotInline
        public static List<StatusBarNotification> a(NotificationManager notificationManager) {
            StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
            return activeNotifications == null ? new ArrayList() : Arrays.asList(activeNotifications);
        }

        @DoNotInline
        public static int b(NotificationManager notificationManager) {
            return notificationManager.getCurrentInterruptionFilter();
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        @DoNotInline
        public static int b(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    @RequiresApi
    public static class Api26Impl {
        @DoNotInline
        public static void a(NotificationManager notificationManager, NotificationChannel notificationChannel) {
            notificationManager.createNotificationChannel(notificationChannel);
        }

        @DoNotInline
        public static void b(NotificationManager notificationManager, NotificationChannelGroup notificationChannelGroup) {
            notificationManager.createNotificationChannelGroup(notificationChannelGroup);
        }

        @DoNotInline
        public static void c(NotificationManager notificationManager, List<NotificationChannelGroup> list) {
            notificationManager.createNotificationChannelGroups(list);
        }

        @DoNotInline
        public static void d(NotificationManager notificationManager, List<NotificationChannel> list) {
            notificationManager.createNotificationChannels(list);
        }

        @DoNotInline
        public static void e(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannel(str);
        }

        @DoNotInline
        public static void f(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannelGroup(str);
        }

        @DoNotInline
        public static String g(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        @DoNotInline
        public static String h(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        @DoNotInline
        public static NotificationChannel i(NotificationManager notificationManager, String str) {
            return notificationManager.getNotificationChannel(str);
        }

        @DoNotInline
        public static List<NotificationChannelGroup> j(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannelGroups();
        }

        @DoNotInline
        public static List<NotificationChannel> k(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannels();
        }
    }

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static NotificationChannelGroup a(NotificationManager notificationManager, String str) {
            return notificationManager.getNotificationChannelGroup(str);
        }
    }

    @RequiresApi
    public static class Api30Impl {
        @DoNotInline
        public static NotificationChannel a(NotificationManager notificationManager, String str, String str2) {
            return notificationManager.getNotificationChannel(str, str2);
        }

        @DoNotInline
        public static String b(NotificationChannel notificationChannel) {
            return notificationChannel.getParentChannelId();
        }
    }

    @RequiresApi
    public static class Api34Impl {
        @DoNotInline
        public static boolean a(NotificationManager notificationManager) {
            return notificationManager.canUseFullScreenIntent();
        }
    }

    public static class CancelTask implements Task {

        /* renamed from: a  reason: collision with root package name */
        public final String f670a;
        public final int b;
        public final String c;
        public final boolean d;

        public void a(INotificationSideChannel iNotificationSideChannel) {
            if (this.d) {
                iNotificationSideChannel.cancelAll(this.f670a);
            } else {
                iNotificationSideChannel.cancel(this.f670a, this.b, this.c);
            }
        }

        public String toString() {
            return "CancelTask[" + "packageName:" + this.f670a + ", id:" + this.b + ", tag:" + this.c + ", all:" + this.d + "]";
        }
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterruptionFilter {
    }

    public static class NotificationWithIdAndTag {
    }

    public static class NotifyTask implements Task {

        /* renamed from: a  reason: collision with root package name */
        public final String f671a;
        public final int b;
        public final String c;
        public final Notification d;

        public NotifyTask(String str, int i, String str2, Notification notification) {
            this.f671a = str;
            this.b = i;
            this.c = str2;
            this.d = notification;
        }

        public void a(INotificationSideChannel iNotificationSideChannel) {
            iNotificationSideChannel.notify(this.f671a, this.b, this.c, this.d);
        }

        public String toString() {
            return "NotifyTask[" + "packageName:" + this.f671a + ", id:" + this.b + ", tag:" + this.c + "]";
        }
    }

    public static class ServiceConnectedEvent {

        /* renamed from: a  reason: collision with root package name */
        public final ComponentName f672a;
        public final IBinder b;

        public ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            this.f672a = componentName;
            this.b = iBinder;
        }
    }

    public static class SideChannelManager implements Handler.Callback, ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final Context f673a;
        public final HandlerThread b;
        public final Handler c;
        public final Map d = new HashMap();
        public Set e = new HashSet();

        public static class ListenerRecord {

            /* renamed from: a  reason: collision with root package name */
            public final ComponentName f674a;
            public boolean b = false;
            public INotificationSideChannel c;
            public ArrayDeque d = new ArrayDeque();
            public int e = 0;

            public ListenerRecord(ComponentName componentName) {
                this.f674a = componentName;
            }
        }

        public SideChannelManager(Context context) {
            this.f673a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.b = handlerThread;
            handlerThread.start();
            this.c = new Handler(handlerThread.getLooper(), this);
        }

        public final boolean a(ListenerRecord listenerRecord) {
            if (listenerRecord.b) {
                return true;
            }
            boolean bindService = this.f673a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(listenerRecord.f674a), this, 33);
            listenerRecord.b = bindService;
            if (bindService) {
                listenerRecord.e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + listenerRecord.f674a);
                this.f673a.unbindService(this);
            }
            return listenerRecord.b;
        }

        public final void b(ListenerRecord listenerRecord) {
            if (listenerRecord.b) {
                this.f673a.unbindService(this);
                listenerRecord.b = false;
            }
            listenerRecord.c = null;
        }

        public final void c(Task task) {
            j();
            for (ListenerRecord listenerRecord : this.d.values()) {
                listenerRecord.d.add(task);
                g(listenerRecord);
            }
        }

        public final void d(ComponentName componentName) {
            ListenerRecord listenerRecord = (ListenerRecord) this.d.get(componentName);
            if (listenerRecord != null) {
                g(listenerRecord);
            }
        }

        public final void e(ComponentName componentName, IBinder iBinder) {
            ListenerRecord listenerRecord = (ListenerRecord) this.d.get(componentName);
            if (listenerRecord != null) {
                listenerRecord.c = INotificationSideChannel.Stub.asInterface(iBinder);
                listenerRecord.e = 0;
                g(listenerRecord);
            }
        }

        public final void f(ComponentName componentName) {
            ListenerRecord listenerRecord = (ListenerRecord) this.d.get(componentName);
            if (listenerRecord != null) {
                b(listenerRecord);
            }
        }

        public final void g(ListenerRecord listenerRecord) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + listenerRecord.f674a + ", " + listenerRecord.d.size() + " queued tasks");
            }
            if (!listenerRecord.d.isEmpty()) {
                if (!a(listenerRecord) || listenerRecord.c == null) {
                    i(listenerRecord);
                    return;
                }
                while (true) {
                    Task task = (Task) listenerRecord.d.peek();
                    if (task == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + task);
                        }
                        task.a(listenerRecord.c);
                        listenerRecord.d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + listenerRecord.f674a);
                        }
                    } catch (RemoteException e2) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + listenerRecord.f674a, e2);
                    }
                }
                if (!listenerRecord.d.isEmpty()) {
                    i(listenerRecord);
                }
            }
        }

        public void h(Task task) {
            this.c.obtainMessage(0, task).sendToTarget();
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                c((Task) message.obj);
                return true;
            } else if (i == 1) {
                ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                e(serviceConnectedEvent.f672a, serviceConnectedEvent.b);
                return true;
            } else if (i == 2) {
                f((ComponentName) message.obj);
                return true;
            } else if (i != 3) {
                return false;
            } else {
                d((ComponentName) message.obj);
                return true;
            }
        }

        public final void i(ListenerRecord listenerRecord) {
            if (!this.c.hasMessages(3, listenerRecord.f674a)) {
                int i = listenerRecord.e;
                int i2 = i + 1;
                listenerRecord.e = i2;
                if (i2 > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + listenerRecord.d.size() + " tasks to " + listenerRecord.f674a + " after " + listenerRecord.e + " retries");
                    listenerRecord.d.clear();
                    return;
                }
                int i3 = (1 << i) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i3 + " ms");
                }
                this.c.sendMessageDelayed(this.c.obtainMessage(3, listenerRecord.f674a), (long) i3);
            }
        }

        public final void j() {
            Set h = NotificationManagerCompat.h(this.f673a);
            if (!h.equals(this.e)) {
                this.e = h;
                List<ResolveInfo> queryIntentServices = this.f673a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                HashSet<ComponentName> hashSet = new HashSet<>();
                for (ResolveInfo next : queryIntentServices) {
                    if (h.contains(next.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = next.serviceInfo;
                        ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                        if (next.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.d.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.d.put(componentName2, new ListenerRecord(componentName2));
                    }
                }
                Iterator it = this.d.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (!hashSet.contains(entry.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                        }
                        b((ListenerRecord) entry.getValue());
                        it.remove();
                    }
                }
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.c.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    public interface Task {
        void a(INotificationSideChannel iNotificationSideChannel);
    }

    public NotificationManagerCompat(Context context) {
        this.f669a = context;
        this.b = (NotificationManager) context.getSystemService("notification");
    }

    public static NotificationManagerCompat g(Context context) {
        return new NotificationManagerCompat(context);
    }

    public static Set h(Context context) {
        Set set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (c) {
            if (string != null) {
                try {
                    if (!string.equals(d)) {
                        String[] split = string.split(AccountConstantKt.CODE_SEPARTOR, -1);
                        HashSet hashSet = new HashSet(split.length);
                        for (String unflattenFromString : split) {
                            ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                            if (unflattenFromString2 != null) {
                                hashSet.add(unflattenFromString2.getPackageName());
                            }
                        }
                        e = hashSet;
                        d = string;
                    }
                } finally {
                }
            }
            set = e;
        }
        return set;
    }

    public static boolean n(Notification notification) {
        Bundle b2 = NotificationCompat.b(notification);
        return b2 != null && b2.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        return Api24Impl.a(this.b);
    }

    public void b(int i) {
        c((String) null, i);
    }

    public void c(String str, int i) {
        this.b.cancel(str, i);
    }

    public void d() {
        this.b.cancelAll();
    }

    public void e(NotificationChannel notificationChannel) {
        Api26Impl.a(this.b, notificationChannel);
    }

    public void f(NotificationChannelCompat notificationChannelCompat) {
        e(notificationChannelCompat.a());
    }

    public NotificationChannel i(String str) {
        return Api26Impl.i(this.b, str);
    }

    public List j() {
        return Api26Impl.k(this.b);
    }

    public void k(int i, Notification notification) {
        l((String) null, i, notification);
    }

    public void l(String str, int i, Notification notification) {
        if (n(notification)) {
            m(new NotifyTask(this.f669a.getPackageName(), i, str, notification));
            this.b.cancel(str, i);
            return;
        }
        this.b.notify(str, i, notification);
    }

    public final void m(Task task) {
        synchronized (f) {
            try {
                if (g == null) {
                    g = new SideChannelManager(this.f669a.getApplicationContext());
                }
                g.h(task);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
