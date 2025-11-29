package android.bluetooth.client.pbap;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.RemoteException;
import android.provider.ContactsContract;
import com.android.vcard.VCardEntry;
import com.meizu.common.util.LunarCalendar;
import com.upuphone.starrynet.common.StLog;
import com.xjsd.ai.assistant.protocol.schedule.Event;
import java.util.ArrayList;
import java.util.List;

public class PhonebookPullRequest extends PullRequest {
    public final Context c;
    public boolean d = false;

    public PhonebookPullRequest(Context context) {
        this.c = context;
        this.f80a = "telecom/pb.vcf";
    }

    public void b(ContentResolver contentResolver) {
        Cursor query = contentResolver.query(ContactsContract.RawContacts.CONTENT_URI, (String[]) null, (String) null, (String[]) null, (String) null);
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            arrayList.add(ContentProviderOperation.newDelete(ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, query.getLong(query.getColumnIndex("_id")))).withYieldAllowed(true).build());
        }
        query.close();
        if (!arrayList.isEmpty()) {
            try {
                contentResolver.applyBatch("com.android.contacts", arrayList);
            } catch (OperationApplicationException | RemoteException e) {
                StLog.e("PbapPbPullRequest", "Got exception: ", e);
            } catch (Throwable th) {
                this.d = true;
                throw th;
            }
            this.d = true;
        }
        StLog.d("PbapPbPullRequest", "clear all constant");
    }

    public String c(VCardEntry vCardEntry) {
        String p = vCardEntry.p();
        if (p == null || !p.contains(LunarCalendar.DATE_SEPARATOR) || vCardEntry.r() == null) {
            return p;
        }
        for (VCardEntry.PhoneData d2 : vCardEntry.r()) {
            if (p.equals(d2.d())) {
                return p.replaceAll(LunarCalendar.DATE_SEPARATOR, "");
            }
        }
        return p;
    }

    public void d() {
        if (this.b == null) {
            StLog.e("PbapPbPullRequest", "onPullComplete entries is null.");
            return;
        }
        StLog.d("PbapPbPullRequest", "onPullComplete with " + this.b.size() + " count.");
        ContentResolver contentResolver = this.c.getContentResolver();
        b(contentResolver);
        e(contentResolver);
        try {
            Cursor query = contentResolver.query(ContactsContract.RawContacts.CONTENT_URI, (String[]) null, (String) null, (String[]) null, (String) null);
            StLog.d("PbapPbPullRequest", "constant size = " + query.getCount());
            query.close();
        } catch (Exception e) {
            StLog.e("PbapPbPullRequest", "Got exception: ", (Throwable) e);
        }
    }

    public void e(ContentResolver contentResolver) {
        for (VCardEntry vCardEntry : this.b) {
            ArrayList arrayList = new ArrayList();
            int size = arrayList.size();
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI).withValue("account_type", (Object) null).withValue(Event.ACCOUNT_NAME, (Object) null).withYieldAllowed(true).build());
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", size).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data1", c(vCardEntry)).build());
            if (vCardEntry.r() != null && !vCardEntry.r().isEmpty()) {
                for (VCardEntry.PhoneData phoneData : vCardEntry.r()) {
                    arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", size).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", phoneData.d()).withValue("data2", Integer.valueOf(phoneData.e())).build());
                }
            }
            if (vCardEntry.q() != null && !vCardEntry.q().isEmpty()) {
                for (VCardEntry.EmailData d2 : vCardEntry.q()) {
                    arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", size).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", d2.d()).build());
                }
            }
            List<VCardEntry.PhotoData> s = vCardEntry.s();
            if (s != null) {
                for (VCardEntry.PhotoData c2 : s) {
                    arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", size).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", c2.c()).build());
                }
            }
            try {
                contentResolver.applyBatch("com.android.contacts", arrayList);
            } catch (OperationApplicationException | RemoteException e) {
                StLog.e("PbapPbPullRequest", "Got exception: ", e);
            } catch (Throwable th) {
                this.d = true;
                throw th;
            }
            this.d = true;
        }
        StLog.d("PbapPbPullRequest", "save all constant");
    }
}
