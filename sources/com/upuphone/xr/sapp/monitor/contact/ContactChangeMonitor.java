package com.upuphone.xr.sapp.monitor.contact;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import com.google.gson.Gson;
import com.honey.account.view.web.WebJs;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.JsonUtils;
import com.upuphone.xr.sapp.utils.OSHelper;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0003#$%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u001f\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002XD¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002XD¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u00060\u001bR\u00020\u00008\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/contact/ContactChangeMonitor;", "", "<init>", "()V", "", "g", "i", "k", "f", "j", "Ljava/util/ArrayList;", "Lcom/upuphone/xr/sapp/monitor/contact/ContactChangeMonitor$Contact;", "Lkotlin/collections/ArrayList;", "h", "()Ljava/util/ArrayList;", "", "a", "Z", "isInit", "", "b", "I", "errorHandlerWhat", "", "c", "J", "errorTime", "Lcom/upuphone/xr/sapp/monitor/contact/ContactChangeMonitor$AutoHandler;", "d", "Lcom/upuphone/xr/sapp/monitor/contact/ContactChangeMonitor$AutoHandler;", "autoHandler", "Landroid/database/ContentObserver;", "e", "Landroid/database/ContentObserver;", "contactObserver", "AutoHandler", "Companion", "Contact", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nContactChangeMonitor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactChangeMonitor.kt\ncom/upuphone/xr/sapp/monitor/contact/ContactChangeMonitor\n+ 2 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,184:1\n29#2,5:185\n1855#3:190\n766#3:191\n857#3,2:192\n1856#3:194\n*S KotlinDebug\n*F\n+ 1 ContactChangeMonitor.kt\ncom/upuphone/xr/sapp/monitor/contact/ContactChangeMonitor\n*L\n114#1:185,5\n119#1:190\n120#1:191\n120#1:192,2\n119#1:194\n*E\n"})
public final class ContactChangeMonitor {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public boolean f7738a;
    public final int b = 200;
    public final long c = 3000;
    public final AutoHandler d = new AutoHandler();
    public final ContentObserver e = new ContactChangeMonitor$contactObserver$1(this, new Handler());

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/contact/ContactChangeMonitor$AutoHandler;", "Landroid/os/Handler;", "(Lcom/upuphone/xr/sapp/monitor/contact/ContactChangeMonitor;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AutoHandler extends Handler {
        public AutoHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            Intrinsics.checkNotNullParameter(message, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
            super.handleMessage(message);
            ULog.Delegate delegate = ULog.f6446a;
            int i = message.what;
            delegate.a("ContactChangeMonitor", "-- autoHandler what:" + i + "---");
            ContactChangeMonitor.this.k();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/contact/ContactChangeMonitor$Companion;", "", "()V", "CONTACT_CHANGE_DIFF_CACHE", "", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/contact/ContactChangeMonitor$Contact;", "", "", "id", "", "name", "<init>", "(ILjava/lang/String;)V", "a", "I", "()I", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Contact {

        /* renamed from: a  reason: collision with root package name */
        public final int f7740a;
        public final String b;

        public Contact(int i, String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.f7740a = i;
            this.b = str;
        }

        public final int a() {
            return this.f7740a;
        }

        public final String b() {
            return this.b;
        }
    }

    public final void f() {
        Object obj;
        String str = (String) DataStoreUtils.i(DataStoreUtils.e.a(), "contact_change_diff_cache_key", "", (Context) null, 4, (Object) null);
        ArrayList<Contact> h = h();
        if (str.length() > 0) {
            JsonUtils jsonUtils = JsonUtils.f7893a;
            Type type = new ContactChangeMonitor$diffContact$$inlined$fromJson$1().getType();
            if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
                Intrinsics.checkNotNull(type);
                obj = jsonUtils.a("{}", type);
            } else {
                Intrinsics.checkNotNull(type);
                obj = jsonUtils.a(str, type);
            }
            List list = (List) obj;
            if (list == null || list.size() != h.size()) {
                k();
                return;
            }
            for (Contact contact : h) {
                ArrayList arrayList = new ArrayList();
                for (Object next : list) {
                    Contact contact2 = (Contact) next;
                    if (contact2.a() == contact.a() && Intrinsics.areEqual((Object) contact2.b(), (Object) contact.b())) {
                        arrayList.add(next);
                    }
                }
                if (arrayList.isEmpty()) {
                    k();
                    return;
                }
            }
            return;
        }
        k();
    }

    public final void g() {
        if (this.f7738a) {
            i();
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("ContactChangeMonitor", "init contact change monitor");
        if (!OSHelper.f7904a.c("android.permission.READ_CONTACTS")) {
            delegate.c("ContactChangeMonitor", "contact permission error");
            return;
        }
        f();
        GlobalExtKt.f().getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, this.e);
    }

    public final ArrayList h() {
        ArrayList arrayList = new ArrayList();
        if (!OSHelper.f7904a.c("android.permission.READ_CONTACTS")) {
            this.f7738a = false;
            ULog.f6446a.c("ContactChangeMonitor", "contact permission error");
            return arrayList;
        }
        Cursor query = MainApplication.k.f().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"display_name", "contact_id"}, (String) null, (String[]) null, (String) null);
        if (query != null) {
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("display_name"));
                int i = query.getInt(query.getColumnIndex("contact_id"));
                ULog.Delegate delegate = ULog.f6446a;
                delegate.c("ContactChangeMonitor", "id:" + i);
                Intrinsics.checkNotNull(string);
                arrayList.add(new Contact(i, string));
            }
        }
        if (query != null) {
            query.close();
        }
        DataStoreUtils.e.a().o("contact_change_diff_cache_key", new Gson().toJson((Object) arrayList));
        return arrayList;
    }

    public final void i() {
        ULog.f6446a.c("ContactChangeMonitor", "contact change monitor release");
        GlobalExtKt.f().getContentResolver().unregisterContentObserver(this.e);
    }

    public final void j() {
        h();
    }

    public final void k() {
        ULog.f6446a.c("ContactChangeMonitor", "send sync message");
        StarryMessageHelper starryMessageHelper = StarryMessageHelper.f7799a;
        String json = new Gson().toJson((Object) MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "contact_change")))));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        StarryMessageHelper.r(starryMessageHelper, json, (byte[]) null, new ContactChangeMonitor$sendSyncMessage$1(this), (String) null, 10, (Object) null);
    }
}
