package com.android.vcard;

import android.accounts.Account;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Log;
import com.android.vcard.VCardUtils;
import com.meizu.common.widget.MzContactsContract;
import com.xjsd.ai.assistant.protocol.schedule.Event;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class VCardEntry {
    public static final Map t;
    public static final List u = Collections.unmodifiableList(new ArrayList(0));

    /* renamed from: a  reason: collision with root package name */
    public boolean f2370a = false;
    public final NameData b = new NameData();
    public List c;
    public List d;
    public List e;
    public List f;
    public List g;
    public List h;
    public List i;
    public List j;
    public List k;
    public List l;
    public List m;
    public BirthdayData n;
    public AnniversaryData o;
    public List p;
    public final int q;
    public final Account r;
    public List s;

    public static class AndroidCustomData implements EntryElement {

        /* renamed from: a  reason: collision with root package name */
        public final String f2371a;
        public final List b;

        public AndroidCustomData(String str, List list) {
            this.f2371a = str;
            this.b = list;
        }

        public static AndroidCustomData c(List list) {
            List list2;
            String str = null;
            if (list == null) {
                list2 = null;
            } else if (list.size() < 2) {
                str = (String) list.get(0);
                list2 = null;
            } else {
                int i = 16;
                if (list.size() < 16) {
                    i = list.size();
                }
                str = (String) list.get(0);
                list2 = list.subList(1, i);
            }
            return new AndroidCustomData(str, list2);
        }

        public void a(List list, int i) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", i);
            newInsert.withValue("mimetype", this.f2371a);
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                String str = (String) this.b.get(i2);
                if (!TextUtils.isEmpty(str)) {
                    newInsert.withValue("data" + (i2 + 1), str);
                }
            }
            list.add(newInsert.build());
        }

        public EntryLabel b() {
            return EntryLabel.ANDROID_CUSTOM;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AndroidCustomData)) {
                return false;
            }
            AndroidCustomData androidCustomData = (AndroidCustomData) obj;
            if (!TextUtils.equals(this.f2371a, androidCustomData.f2371a)) {
                return false;
            }
            List list = this.b;
            if (list == null) {
                return androidCustomData.b == null;
            }
            int size = list.size();
            if (size != androidCustomData.b.size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!TextUtils.equals((CharSequence) this.b.get(i), (CharSequence) androidCustomData.b.get(i))) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            String str = this.f2371a;
            int hashCode = str != null ? str.hashCode() : 0;
            List<String> list = this.b;
            if (list != null) {
                for (String str2 : list) {
                    hashCode = (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
                }
            }
            return hashCode;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r1 = r1.b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isEmpty() {
            /*
                r1 = this;
                java.lang.String r0 = r1.f2371a
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x0015
                java.util.List r1 = r1.b
                if (r1 == 0) goto L_0x0015
                int r1 = r1.size()
                if (r1 != 0) goto L_0x0013
                goto L_0x0015
            L_0x0013:
                r1 = 0
                goto L_0x0016
            L_0x0015:
                r1 = 1
            L_0x0016:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.vcard.VCardEntry.AndroidCustomData.isEmpty():boolean");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("android-custom: " + this.f2371a + ", data: ");
            List list = this.b;
            sb.append(list == null ? "null" : Arrays.toString(list.toArray()));
            return sb.toString();
        }
    }

    public static class AnniversaryData implements EntryElement {

        /* renamed from: a  reason: collision with root package name */
        public final String f2372a;

        public AnniversaryData(String str) {
            this.f2372a = str;
        }

        public void a(List list, int i) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", i);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/contact_event");
            newInsert.withValue("data1", this.f2372a);
            newInsert.withValue("data2", 1);
            list.add(newInsert.build());
        }

        public EntryLabel b() {
            return EntryLabel.ANNIVERSARY;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnniversaryData)) {
                return false;
            }
            return TextUtils.equals(this.f2372a, ((AnniversaryData) obj).f2372a);
        }

        public int hashCode() {
            String str = this.f2372a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f2372a);
        }

        public String toString() {
            return "anniversary: " + this.f2372a;
        }
    }

    public static class BirthdayData implements EntryElement {

        /* renamed from: a  reason: collision with root package name */
        public final String f2373a;

        public BirthdayData(String str) {
            this.f2373a = str;
        }

        public void a(List list, int i) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", i);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/contact_event");
            newInsert.withValue("data1", this.f2373a);
            newInsert.withValue("data2", 3);
            list.add(newInsert.build());
        }

        public EntryLabel b() {
            return EntryLabel.BIRTHDAY;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BirthdayData)) {
                return false;
            }
            return TextUtils.equals(this.f2373a, ((BirthdayData) obj).f2373a);
        }

        public int hashCode() {
            String str = this.f2373a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f2373a);
        }

        public String toString() {
            return "birthday: " + this.f2373a;
        }
    }

    public static class EmailData implements EntryElement {

        /* renamed from: a  reason: collision with root package name */
        public final String f2374a;
        public final int b;
        public final String c;
        public final boolean d;

        public EmailData(String str, int i, String str2, boolean z) {
            this.b = i;
            this.f2374a = str;
            this.c = str2;
            this.d = z;
        }

        public void a(List list, int i) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", i);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/email_v2");
            newInsert.withValue("data2", Integer.valueOf(this.b));
            if (this.b == 0) {
                newInsert.withValue("data3", this.c);
            }
            newInsert.withValue("data1", this.f2374a);
            if (this.d) {
                newInsert.withValue("is_primary", 1);
            }
            list.add(newInsert.build());
        }

        public final EntryLabel b() {
            return EntryLabel.EMAIL;
        }

        public String d() {
            return this.f2374a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EmailData)) {
                return false;
            }
            EmailData emailData = (EmailData) obj;
            return this.b == emailData.b && TextUtils.equals(this.f2374a, emailData.f2374a) && TextUtils.equals(this.c, emailData.c) && this.d == emailData.d;
        }

        public int hashCode() {
            int i = this.b * 31;
            String str = this.f2374a;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.c;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return ((hashCode + i2) * 31) + (this.d ? 1231 : 1237);
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f2374a);
        }

        public String toString() {
            return String.format("type: %d, data: %s, label: %s, isPrimary: %s", new Object[]{Integer.valueOf(this.b), this.f2374a, this.c, Boolean.valueOf(this.d)});
        }
    }

    public interface EntryElement {
        void a(List list, int i);

        EntryLabel b();

        boolean isEmpty();
    }

    public interface EntryElementIterator {
        boolean a(EntryElement entryElement);

        void b();

        void c(EntryLabel entryLabel);

        void d();

        void e();
    }

    public enum EntryLabel {
        NAME,
        PHONE,
        EMAIL,
        POSTAL_ADDRESS,
        ORGANIZATION,
        IM,
        PHOTO,
        WEBSITE,
        SIP,
        NICKNAME,
        NOTE,
        BIRTHDAY,
        ANNIVERSARY,
        ANDROID_CUSTOM
    }

    public static class ImData implements EntryElement {

        /* renamed from: a  reason: collision with root package name */
        public final String f2375a;
        public final int b;
        public final String c;
        public final int d;
        public final boolean e;

        public ImData(int i, String str, String str2, int i2, boolean z) {
            this.b = i;
            this.c = str;
            this.d = i2;
            this.f2375a = str2;
            this.e = z;
        }

        public void a(List list, int i) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", i);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/im");
            newInsert.withValue("data2", Integer.valueOf(this.d));
            newInsert.withValue("data5", Integer.valueOf(this.b));
            newInsert.withValue("data1", this.f2375a);
            if (this.b == -1) {
                newInsert.withValue("data6", this.c);
            }
            if (this.e) {
                newInsert.withValue("is_primary", 1);
            }
            list.add(newInsert.build());
        }

        public final EntryLabel b() {
            return EntryLabel.IM;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ImData)) {
                return false;
            }
            ImData imData = (ImData) obj;
            return this.d == imData.d && this.b == imData.b && TextUtils.equals(this.c, imData.c) && TextUtils.equals(this.f2375a, imData.f2375a) && this.e == imData.e;
        }

        public int hashCode() {
            int i = ((this.d * 31) + this.b) * 31;
            String str = this.c;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f2375a;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return ((hashCode + i2) * 31) + (this.e ? 1231 : 1237);
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f2375a);
        }

        public String toString() {
            return String.format("type: %d, protocol: %d, custom_protcol: %s, data: %s, isPrimary: %s", new Object[]{Integer.valueOf(this.d), Integer.valueOf(this.b), this.c, this.f2375a, Boolean.valueOf(this.e)});
        }
    }

    public class InsertOperationConstrutor implements EntryElementIterator {

        /* renamed from: a  reason: collision with root package name */
        public final List f2376a;
        public final int b;

        public InsertOperationConstrutor(List list, int i) {
            this.f2376a = list;
            this.b = i;
        }

        public boolean a(EntryElement entryElement) {
            if (entryElement.isEmpty()) {
                return true;
            }
            entryElement.a(this.f2376a, this.b);
            return true;
        }

        public void b() {
        }

        public void c(EntryLabel entryLabel) {
        }

        public void d() {
        }

        public void e() {
        }
    }

    public class IsIgnorableIterator implements EntryElementIterator {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2377a;

        public IsIgnorableIterator() {
            this.f2377a = true;
        }

        public boolean a(EntryElement entryElement) {
            if (entryElement.isEmpty()) {
                return true;
            }
            this.f2377a = false;
            return false;
        }

        public void b() {
        }

        public void c(EntryLabel entryLabel) {
        }

        public void d() {
        }

        public void e() {
        }

        public boolean f() {
            return this.f2377a;
        }
    }

    public static class NameData implements EntryElement {

        /* renamed from: a  reason: collision with root package name */
        public String f2378a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;

        public void a(List list, int i2) {
            boolean z;
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", i2);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/name");
            if (!TextUtils.isEmpty(this.b)) {
                newInsert.withValue("data2", this.b);
            }
            if (!TextUtils.isEmpty(this.f2378a)) {
                newInsert.withValue("data3", this.f2378a);
            }
            if (!TextUtils.isEmpty(this.c)) {
                newInsert.withValue("data5", this.c);
            }
            if (!TextUtils.isEmpty(this.d)) {
                newInsert.withValue("data4", this.d);
            }
            if (!TextUtils.isEmpty(this.e)) {
                newInsert.withValue("data6", this.e);
            }
            boolean z2 = true;
            if (!TextUtils.isEmpty(this.h)) {
                newInsert.withValue("data7", this.h);
                z = true;
            } else {
                z = false;
            }
            if (!TextUtils.isEmpty(this.g)) {
                newInsert.withValue("data9", this.g);
                z = true;
            }
            if (!TextUtils.isEmpty(this.i)) {
                newInsert.withValue("data8", this.i);
            } else {
                z2 = z;
            }
            if (!z2) {
                newInsert.withValue("data7", this.j);
            }
            newInsert.withValue("data1", this.k);
            list.add(newInsert.build());
        }

        public final EntryLabel b() {
            return EntryLabel.NAME;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NameData)) {
                return false;
            }
            NameData nameData = (NameData) obj;
            return TextUtils.equals(this.f2378a, nameData.f2378a) && TextUtils.equals(this.c, nameData.c) && TextUtils.equals(this.b, nameData.b) && TextUtils.equals(this.d, nameData.d) && TextUtils.equals(this.e, nameData.e) && TextUtils.equals(this.f, nameData.f) && TextUtils.equals(this.g, nameData.g) && TextUtils.equals(this.i, nameData.i) && TextUtils.equals(this.h, nameData.h) && TextUtils.equals(this.j, nameData.j);
        }

        public int hashCode() {
            String[] strArr = {this.f2378a, this.c, this.b, this.d, this.e, this.f, this.g, this.i, this.h, this.j};
            int i2 = 0;
            for (int i3 = 0; i3 < 10; i3++) {
                String str = strArr[i3];
                i2 = (i2 * 31) + (str != null ? str.hashCode() : 0);
            }
            return i2;
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f2378a) && TextUtils.isEmpty(this.c) && TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.d) && TextUtils.isEmpty(this.e) && TextUtils.isEmpty(this.f) && TextUtils.isEmpty(this.g) && TextUtils.isEmpty(this.i) && TextUtils.isEmpty(this.h) && TextUtils.isEmpty(this.j);
        }

        public String toString() {
            return String.format("family: %s, given: %s, middle: %s, prefix: %s, suffix: %s", new Object[]{this.f2378a, this.b, this.c, this.d, this.e});
        }

        public boolean v() {
            return TextUtils.isEmpty(this.g) && TextUtils.isEmpty(this.h) && TextUtils.isEmpty(this.i);
        }

        public boolean w() {
            return TextUtils.isEmpty(this.f2378a) && TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.c) && TextUtils.isEmpty(this.d) && TextUtils.isEmpty(this.e);
        }
    }

    public static class NicknameData implements EntryElement {

        /* renamed from: a  reason: collision with root package name */
        public final String f2379a;

        public NicknameData(String str) {
            this.f2379a = str;
        }

        public void a(List list, int i) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", i);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/nickname");
            newInsert.withValue("data2", 1);
            newInsert.withValue("data1", this.f2379a);
            list.add(newInsert.build());
        }

        public EntryLabel b() {
            return EntryLabel.NICKNAME;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof NicknameData)) {
                return false;
            }
            return TextUtils.equals(this.f2379a, ((NicknameData) obj).f2379a);
        }

        public int hashCode() {
            String str = this.f2379a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f2379a);
        }

        public String toString() {
            return "nickname: " + this.f2379a;
        }
    }

    public static class NoteData implements EntryElement {

        /* renamed from: a  reason: collision with root package name */
        public final String f2380a;

        public NoteData(String str) {
            this.f2380a = str;
        }

        public void a(List list, int i) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", i);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/note");
            newInsert.withValue("data1", this.f2380a);
            list.add(newInsert.build());
        }

        public EntryLabel b() {
            return EntryLabel.NOTE;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NoteData)) {
                return false;
            }
            return TextUtils.equals(this.f2380a, ((NoteData) obj).f2380a);
        }

        public int hashCode() {
            String str = this.f2380a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f2380a);
        }

        public String toString() {
            return "note: " + this.f2380a;
        }
    }

    public static class OrganizationData implements EntryElement {

        /* renamed from: a  reason: collision with root package name */
        public String f2381a;
        public String b;
        public String c;
        public final String d;
        public final int e;
        public boolean f;

        public OrganizationData(String str, String str2, String str3, String str4, int i, boolean z) {
            this.e = i;
            this.f2381a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.f = z;
        }

        public void a(List list, int i) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", i);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/organization");
            newInsert.withValue("data2", Integer.valueOf(this.e));
            String str = this.f2381a;
            if (str != null) {
                newInsert.withValue("data1", str);
            }
            String str2 = this.b;
            if (str2 != null) {
                newInsert.withValue("data5", str2);
            }
            String str3 = this.c;
            if (str3 != null) {
                newInsert.withValue("data4", str3);
            }
            String str4 = this.d;
            if (str4 != null) {
                newInsert.withValue("data8", str4);
            }
            if (this.f) {
                newInsert.withValue("is_primary", 1);
            }
            list.add(newInsert.build());
        }

        public final EntryLabel b() {
            return EntryLabel.ORGANIZATION;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OrganizationData)) {
                return false;
            }
            OrganizationData organizationData = (OrganizationData) obj;
            return this.e == organizationData.e && TextUtils.equals(this.f2381a, organizationData.f2381a) && TextUtils.equals(this.b, organizationData.b) && TextUtils.equals(this.c, organizationData.c) && this.f == organizationData.f;
        }

        public int hashCode() {
            int i = this.e * 31;
            String str = this.f2381a;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.c;
            if (str3 != null) {
                i2 = str3.hashCode();
            }
            return ((hashCode2 + i2) * 31) + (this.f ? 1231 : 1237);
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f2381a) && TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.c) && TextUtils.isEmpty(this.d);
        }

        public String j() {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.f2381a)) {
                sb.append(this.f2381a);
            }
            if (!TextUtils.isEmpty(this.b)) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(this.b);
            }
            if (!TextUtils.isEmpty(this.c)) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(this.c);
            }
            return sb.toString();
        }

        public String toString() {
            return String.format("type: %d, organization: %s, department: %s, title: %s, isPrimary: %s", new Object[]{Integer.valueOf(this.e), this.f2381a, this.b, this.c, Boolean.valueOf(this.f)});
        }
    }

    public static class PhoneData implements EntryElement {

        /* renamed from: a  reason: collision with root package name */
        public final String f2382a;
        public final int b;
        public final String c;
        public boolean d;

        public PhoneData(String str, int i, String str2, boolean z) {
            this.f2382a = str;
            this.b = i;
            this.c = str2;
            this.d = z;
        }

        public void a(List list, int i) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", i);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/phone_v2");
            newInsert.withValue("data2", Integer.valueOf(this.b));
            if (this.b == 0) {
                newInsert.withValue("data3", this.c);
            }
            newInsert.withValue("data1", this.f2382a);
            if (this.d) {
                newInsert.withValue("is_primary", 1);
            }
            list.add(newInsert.build());
        }

        public final EntryLabel b() {
            return EntryLabel.PHONE;
        }

        public String d() {
            return this.f2382a;
        }

        public int e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PhoneData)) {
                return false;
            }
            PhoneData phoneData = (PhoneData) obj;
            return this.b == phoneData.b && TextUtils.equals(this.f2382a, phoneData.f2382a) && TextUtils.equals(this.c, phoneData.c) && this.d == phoneData.d;
        }

        public int hashCode() {
            int i = this.b * 31;
            String str = this.f2382a;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.c;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return ((hashCode + i2) * 31) + (this.d ? 1231 : 1237);
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f2382a);
        }

        public String toString() {
            return String.format("type: %d, data: %s, label: %s, isPrimary: %s", new Object[]{Integer.valueOf(this.b), this.f2382a, this.c, Boolean.valueOf(this.d)});
        }
    }

    public static class PhotoData implements EntryElement {

        /* renamed from: a  reason: collision with root package name */
        public final String f2383a;
        public final boolean b;
        public final byte[] c;
        public Integer d = null;

        public PhotoData(String str, byte[] bArr, boolean z) {
            this.f2383a = str;
            this.c = bArr;
            this.b = z;
        }

        public void a(List list, int i) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", i);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/photo");
            newInsert.withValue("data15", this.c);
            if (this.b) {
                newInsert.withValue("is_primary", 1);
            }
            list.add(newInsert.build());
        }

        public final EntryLabel b() {
            return EntryLabel.PHOTO;
        }

        public byte[] c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PhotoData)) {
                return false;
            }
            PhotoData photoData = (PhotoData) obj;
            return TextUtils.equals(this.f2383a, photoData.f2383a) && Arrays.equals(this.c, photoData.c) && this.b == photoData.b;
        }

        public int hashCode() {
            Integer num = this.d;
            if (num != null) {
                return num.intValue();
            }
            String str = this.f2383a;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            byte[] bArr = this.c;
            if (bArr != null) {
                for (byte b2 : bArr) {
                    hashCode += b2;
                }
            }
            int i = (hashCode * 31) + (this.b ? 1231 : 1237);
            this.d = Integer.valueOf(i);
            return i;
        }

        public boolean isEmpty() {
            byte[] bArr = this.c;
            return bArr == null || bArr.length == 0;
        }

        public String toString() {
            return String.format("format: %s: size: %d, isPrimary: %s", new Object[]{this.f2383a, Integer.valueOf(this.c.length), Boolean.valueOf(this.b)});
        }
    }

    public static class PostalData implements EntryElement {

        /* renamed from: a  reason: collision with root package name */
        public final String f2384a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final String g;
        public final int h;
        public final String i;
        public boolean j;
        public int k;

        public PostalData(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, boolean z, int i3) {
            this.h = i2;
            this.f2384a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = str6;
            this.g = str7;
            this.i = str8;
            this.j = z;
            this.k = i3;
        }

        public static PostalData c(List list, int i2, String str, boolean z, int i3) {
            String[] strArr = new String[7];
            int size = list.size();
            if (size > 7) {
                size = 7;
            }
            Iterator it = list.iterator();
            int i4 = 0;
            while (it.hasNext()) {
                strArr[i4] = (String) it.next();
                i4++;
                if (i4 >= size) {
                    break;
                }
            }
            while (i4 < 7) {
                strArr[i4] = null;
                i4++;
            }
            return new PostalData(strArr[0], strArr[1], strArr[2], strArr[3], strArr[4], strArr[5], strArr[6], i2, str, z, i3);
        }

        public void a(List list, int i2) {
            String str;
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", i2);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/postal-address_v2");
            newInsert.withValue("data2", Integer.valueOf(this.h));
            if (this.h == 0) {
                newInsert.withValue("data3", this.i);
            }
            if (TextUtils.isEmpty(this.c)) {
                str = TextUtils.isEmpty(this.b) ? null : this.b;
            } else if (TextUtils.isEmpty(this.b)) {
                str = this.c;
            } else {
                str = this.c + " " + this.b;
            }
            newInsert.withValue("data5", this.f2384a);
            newInsert.withValue("data4", str);
            newInsert.withValue("data7", this.d);
            newInsert.withValue("data8", this.e);
            newInsert.withValue("data9", this.f);
            newInsert.withValue("data10", this.g);
            newInsert.withValue("data1", d(this.k));
            if (this.j) {
                newInsert.withValue("is_primary", 1);
            }
            list.add(newInsert.build());
        }

        public final EntryLabel b() {
            return EntryLabel.POSTAL_ADDRESS;
        }

        public String d(int i2) {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {this.f2384a, this.b, this.c, this.d, this.e, this.f, this.g};
            boolean z = true;
            if (VCardConfig.b(i2)) {
                for (int i3 = 6; i3 >= 0; i3--) {
                    String str = strArr[i3];
                    if (!TextUtils.isEmpty(str)) {
                        if (!z) {
                            sb.append(' ');
                        } else {
                            z = false;
                        }
                        sb.append(str);
                    }
                }
            } else {
                for (int i4 = 0; i4 < 7; i4++) {
                    String str2 = strArr[i4];
                    if (!TextUtils.isEmpty(str2)) {
                        if (!z) {
                            sb.append(' ');
                        } else {
                            z = false;
                        }
                        sb.append(str2);
                    }
                }
            }
            return sb.toString().trim();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PostalData)) {
                return false;
            }
            PostalData postalData = (PostalData) obj;
            int i2 = this.h;
            return i2 == postalData.h && (i2 != 0 || TextUtils.equals(this.i, postalData.i)) && this.j == postalData.j && TextUtils.equals(this.f2384a, postalData.f2384a) && TextUtils.equals(this.b, postalData.b) && TextUtils.equals(this.c, postalData.c) && TextUtils.equals(this.d, postalData.d) && TextUtils.equals(this.e, postalData.e) && TextUtils.equals(this.f, postalData.f) && TextUtils.equals(this.g, postalData.g);
        }

        public int hashCode() {
            int i2 = this.h * 31;
            String str = this.i;
            int hashCode = ((i2 + (str != null ? str.hashCode() : 0)) * 31) + (this.j ? 1231 : 1237);
            String[] strArr = {this.f2384a, this.b, this.c, this.d, this.e, this.f, this.g};
            for (int i3 = 0; i3 < 7; i3++) {
                String str2 = strArr[i3];
                hashCode = (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
            }
            return hashCode;
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f2384a) && TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.c) && TextUtils.isEmpty(this.d) && TextUtils.isEmpty(this.e) && TextUtils.isEmpty(this.f) && TextUtils.isEmpty(this.g);
        }

        public String toString() {
            return String.format("type: %d, label: %s, isPrimary: %s, pobox: %s, extendedAddress: %s, street: %s, localty: %s, region: %s, postalCode %s, country: %s", new Object[]{Integer.valueOf(this.h), this.i, Boolean.valueOf(this.j), this.f2384a, this.b, this.c, this.d, this.e, this.f, this.g});
        }
    }

    public static class SipData implements EntryElement {

        /* renamed from: a  reason: collision with root package name */
        public final String f2385a;
        public final int b;
        public final String c;
        public final boolean d;

        public SipData(String str, int i, String str2, boolean z) {
            if (str.startsWith("sip:")) {
                this.f2385a = str.substring(4);
            } else {
                this.f2385a = str;
            }
            this.b = i;
            this.c = str2;
            this.d = z;
        }

        public void a(List list, int i) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", i);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/sip_address");
            newInsert.withValue("data1", this.f2385a);
            newInsert.withValue("data2", Integer.valueOf(this.b));
            if (this.b == 0) {
                newInsert.withValue("data3", this.c);
            }
            boolean z = this.d;
            if (z) {
                newInsert.withValue("is_primary", Boolean.valueOf(z));
            }
            list.add(newInsert.build());
        }

        public EntryLabel b() {
            return EntryLabel.SIP;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SipData)) {
                return false;
            }
            SipData sipData = (SipData) obj;
            return this.b == sipData.b && TextUtils.equals(this.c, sipData.c) && TextUtils.equals(this.f2385a, sipData.f2385a) && this.d == sipData.d;
        }

        public int hashCode() {
            int i = this.b * 31;
            String str = this.c;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f2385a;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return ((hashCode + i2) * 31) + (this.d ? 1231 : 1237);
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f2385a);
        }

        public String toString() {
            return "sip: " + this.f2385a;
        }
    }

    public class ToStringIterator implements EntryElementIterator {

        /* renamed from: a  reason: collision with root package name */
        public StringBuilder f2386a;
        public boolean b;

        public ToStringIterator() {
        }

        public boolean a(EntryElement entryElement) {
            if (!this.b) {
                this.f2386a.append(", ");
                this.b = false;
            }
            StringBuilder sb = this.f2386a;
            sb.append("[");
            sb.append(entryElement.toString());
            sb.append("]");
            return true;
        }

        public void b() {
            StringBuilder sb = new StringBuilder();
            this.f2386a = sb;
            sb.append("[[hash: " + VCardEntry.this.hashCode() + StringUtils.LF);
        }

        public void c(EntryLabel entryLabel) {
            StringBuilder sb = this.f2386a;
            sb.append(entryLabel.toString() + ": ");
            this.b = true;
        }

        public void d() {
            this.f2386a.append(StringUtils.LF);
        }

        public void e() {
            this.f2386a.append("]]\n");
        }

        public String toString() {
            return this.f2386a.toString();
        }
    }

    public static class WebsiteData implements EntryElement {

        /* renamed from: a  reason: collision with root package name */
        public final String f2387a;

        public WebsiteData(String str) {
            this.f2387a = str;
        }

        public void a(List list, int i) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", i);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/website");
            newInsert.withValue("data1", this.f2387a);
            newInsert.withValue("data2", 1);
            list.add(newInsert.build());
        }

        public EntryLabel b() {
            return EntryLabel.WEBSITE;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WebsiteData)) {
                return false;
            }
            return TextUtils.equals(this.f2387a, ((WebsiteData) obj).f2387a);
        }

        public int hashCode() {
            String str = this.f2387a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f2387a);
        }

        public String toString() {
            return "website: " + this.f2387a;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        t = hashMap;
        hashMap.put("X-AIM", 0);
        hashMap.put("X-MSN", 1);
        hashMap.put("X-YAHOO", 2);
        hashMap.put("X-ICQ", 6);
        hashMap.put("X-JABBER", 7);
        hashMap.put("X-SKYPE-USERNAME", 3);
        hashMap.put("X-GOOGLE-TALK", 5);
        hashMap.put("X-GOOGLE TALK", 5);
    }

    public VCardEntry(int i2, Account account) {
        this.q = i2;
        this.r = account;
    }

    public boolean A() {
        IsIgnorableIterator isIgnorableIterator = new IsIgnorableIterator();
        B(isIgnorableIterator);
        return isIgnorableIterator.f();
    }

    public final void B(EntryElementIterator entryElementIterator) {
        entryElementIterator.b();
        entryElementIterator.c(this.b.b());
        entryElementIterator.a(this.b);
        entryElementIterator.d();
        C(this.c, entryElementIterator);
        C(this.d, entryElementIterator);
        C(this.e, entryElementIterator);
        C(this.f, entryElementIterator);
        C(this.g, entryElementIterator);
        C(this.h, entryElementIterator);
        C(this.i, entryElementIterator);
        C(this.j, entryElementIterator);
        C(this.k, entryElementIterator);
        C(this.l, entryElementIterator);
        C(this.m, entryElementIterator);
        BirthdayData birthdayData = this.n;
        if (birthdayData != null) {
            entryElementIterator.c(birthdayData.b());
            entryElementIterator.a(this.n);
            entryElementIterator.d();
        }
        AnniversaryData anniversaryData = this.o;
        if (anniversaryData != null) {
            entryElementIterator.c(anniversaryData.b());
            entryElementIterator.a(this.o);
            entryElementIterator.d();
        }
        entryElementIterator.e();
    }

    public final void C(List list, EntryElementIterator entryElementIterator) {
        if (list != null && list.size() > 0) {
            entryElementIterator.c(((EntryElement) list.get(0)).b());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                entryElementIterator.a((EntryElement) it.next());
            }
            entryElementIterator.d();
        }
    }

    public final String D(List list) {
        int size = list.size();
        if (size <= 1) {
            return size == 1 ? (String) list.get(0) : "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            if (size - 1 > 0) {
                sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);
            }
        }
        return sb.toString();
    }

    public final void E(Map map) {
        Collection collection;
        if ((!VCardConfig.d(this.q) || (TextUtils.isEmpty(this.b.g) && TextUtils.isEmpty(this.b.i) && TextUtils.isEmpty(this.b.h))) && (collection = (Collection) map.get("SORT-AS")) != null && collection.size() != 0) {
            if (collection.size() > 1) {
                Log.w("vCard", "Incorrect multiple SORT_AS parameters detected: " + Arrays.toString(collection.toArray()));
            }
            List b2 = VCardUtils.b((String) collection.iterator().next(), this.q);
            int size = b2.size();
            if (size > 3) {
                size = 3;
            }
            if (size != 2) {
                if (size == 3) {
                    String unused = this.b.i = (String) b2.get(2);
                }
                String unused2 = this.b.g = (String) b2.get(0);
            }
            String unused3 = this.b.h = (String) b2.get(1);
            String unused4 = this.b.g = (String) b2.get(0);
        }
    }

    public void a(VCardEntry vCardEntry) {
        if (this.s == null) {
            this.s = new ArrayList();
        }
        this.s.add(vCardEntry);
    }

    public final void b(int i2, String str, String str2, boolean z) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(new EmailData(str, i2, str2, z));
    }

    public final void c(int i2, String str, String str2, int i3, boolean z) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.add(new ImData(i2, str, str2, i3, z));
    }

    public final void d(String str, String str2, String str3, String str4, int i2, boolean z) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.add(new OrganizationData(str, str2, str3, str4, i2, z));
    }

    public final void e(String str) {
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(new NicknameData(str));
    }

    public final void f(String str) {
        if (this.l == null) {
            this.l = new ArrayList(1);
        }
        this.l.add(new NoteData(str));
    }

    public final void g(int i2, String str, String str2, boolean z) {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        StringBuilder sb = new StringBuilder();
        String trim = str.trim();
        if (i2 != 6 && !VCardConfig.f(this.q)) {
            int length = trim.length();
            boolean z2 = false;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = trim.charAt(i3);
                if (charAt == 'p' || charAt == 'P') {
                    sb.append(StringUtil.COMMA);
                } else if (charAt == 'w' || charAt == 'W') {
                    sb.append(';');
                } else {
                    if (PhoneNumberUtils.is12Key(charAt) || (i3 == 0 && charAt == '+')) {
                        sb.append(charAt);
                    }
                }
                z2 = true;
            }
            if (!z2) {
                trim = VCardUtils.PhoneNumberUtilsPort.a(sb.toString(), VCardUtils.j(this.q));
            } else {
                trim = sb.toString();
            }
        }
        this.c.add(new PhoneData(trim, i2, str2, z));
    }

    public final void h(String str, byte[] bArr, boolean z) {
        if (this.h == null) {
            this.h = new ArrayList(1);
        }
        this.h.add(new PhotoData(str, bArr, z));
    }

    public final void i(int i2, List list, String str, boolean z) {
        if (this.e == null) {
            this.e = new ArrayList(0);
        }
        this.e.add(PostalData.c(list, i2, str, z, this.q));
    }

    /* JADX WARNING: Removed duplicated region for block: B:141:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x024a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j(com.android.vcard.VCardProperty r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.String r1 = r18.d()
            java.util.Map r2 = r18.e()
            java.util.List r3 = r18.h()
            byte[] r4 = r18.c()
            if (r3 == 0) goto L_0x001a
            int r5 = r3.size()
            if (r5 != 0) goto L_0x001d
        L_0x001a:
            if (r4 != 0) goto L_0x001d
            return
        L_0x001d:
            r5 = 0
            if (r3 == 0) goto L_0x0029
            java.lang.String r6 = r0.D(r3)
            java.lang.String r6 = r6.trim()
            goto L_0x002a
        L_0x0029:
            r6 = r5
        L_0x002a:
            java.lang.String r7 = "VERSION"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x0034
            goto L_0x040d
        L_0x0034:
            java.lang.String r7 = "FN"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x0043
            com.android.vcard.VCardEntry$NameData r0 = r0.b
            java.lang.String unused = r0.f = r6
            goto L_0x040d
        L_0x0043:
            java.lang.String r7 = "NAME"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x005e
            com.android.vcard.VCardEntry$NameData r1 = r0.b
            java.lang.String r1 = r1.f
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x040d
            com.android.vcard.VCardEntry$NameData r0 = r0.b
            java.lang.String unused = r0.f = r6
            goto L_0x040d
        L_0x005e:
            java.lang.String r7 = "N"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x006b
            r0.v(r3, r2)
            goto L_0x040d
        L_0x006b:
            java.lang.String r7 = "SORT-STRING"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x007a
            com.android.vcard.VCardEntry$NameData r0 = r0.b
            java.lang.String unused = r0.j = r6
            goto L_0x040d
        L_0x007a:
            java.lang.String r7 = "NICKNAME"
            boolean r7 = r1.equals(r7)
            if (r7 != 0) goto L_0x040a
            java.lang.String r7 = "X-NICKNAME"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x008c
            goto L_0x040a
        L_0x008c:
            java.lang.String r7 = "SOUND"
            boolean r7 = r1.equals(r7)
            java.lang.String r8 = "TYPE"
            if (r7 == 0) goto L_0x00b1
            java.lang.Object r1 = r2.get(r8)
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x040d
            java.lang.String r2 = "X-IRMC-N"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x040d
            int r1 = r0.q
            java.util.List r1 = com.android.vcard.VCardUtils.b(r6, r1)
            r0.x(r1)
            goto L_0x040d
        L_0x00b1:
            java.lang.String r7 = "ADR"
            boolean r7 = r1.equals(r7)
            java.lang.String r9 = "X-"
            java.lang.String r10 = "WORK"
            java.lang.String r11 = "HOME"
            r13 = 2
            java.lang.String r14 = "PREF"
            r12 = 1
            if (r7 == 0) goto L_0x0153
            java.util.Iterator r1 = r3.iterator()
        L_0x00c7:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0152
            java.lang.Object r4 = r1.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00c7
            java.lang.Object r1 = r2.get(r8)
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x0147
            java.util.Iterator r1 = r1.iterator()
            r4 = r5
            r2 = -1
            r6 = 0
        L_0x00e8:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x0144
            java.lang.Object r7 = r1.next()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = r7.toUpperCase()
            boolean r16 = r8.equals(r14)
            if (r16 == 0) goto L_0x0100
            r6 = r12
            goto L_0x00e8
        L_0x0100:
            boolean r16 = r8.equals(r11)
            if (r16 == 0) goto L_0x0109
            r4 = r5
            r2 = r12
            goto L_0x00e8
        L_0x0109:
            boolean r16 = r8.equals(r10)
            if (r16 != 0) goto L_0x0141
            java.lang.String r15 = "COMPANY"
            boolean r15 = r8.equalsIgnoreCase(r15)
            if (r15 == 0) goto L_0x0118
            goto L_0x0141
        L_0x0118:
            java.lang.String r15 = "PARCEL"
            boolean r15 = r8.equals(r15)
            if (r15 != 0) goto L_0x00e8
            java.lang.String r15 = "DOM"
            boolean r15 = r8.equals(r15)
            if (r15 != 0) goto L_0x00e8
            java.lang.String r15 = "INTL"
            boolean r15 = r8.equals(r15)
            if (r15 == 0) goto L_0x0131
            goto L_0x00e8
        L_0x0131:
            if (r2 >= 0) goto L_0x00e8
            boolean r2 = r8.startsWith(r9)
            if (r2 == 0) goto L_0x013f
            java.lang.String r4 = r7.substring(r13)
        L_0x013d:
            r2 = 0
            goto L_0x00e8
        L_0x013f:
            r4 = r7
            goto L_0x013d
        L_0x0141:
            r4 = r5
            r2 = r13
            goto L_0x00e8
        L_0x0144:
            r5 = r4
            r15 = r6
            goto L_0x0149
        L_0x0147:
            r2 = -1
            r15 = 0
        L_0x0149:
            if (r2 >= 0) goto L_0x014c
            goto L_0x014d
        L_0x014c:
            r12 = r2
        L_0x014d:
            r0.i(r12, r3, r5, r15)
            goto L_0x040d
        L_0x0152:
            return
        L_0x0153:
            java.lang.String r7 = "EMAIL"
            boolean r7 = r1.equals(r7)
            r15 = 4
            if (r7 == 0) goto L_0x01b8
            java.lang.Object r1 = r2.get(r8)
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x01ae
            java.util.Iterator r1 = r1.iterator()
            r2 = -1
            r3 = 0
        L_0x016a:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x01ab
            java.lang.Object r4 = r1.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r7 = r4.toUpperCase()
            boolean r8 = r7.equals(r14)
            if (r8 == 0) goto L_0x0182
            r3 = r12
            goto L_0x016a
        L_0x0182:
            boolean r8 = r7.equals(r11)
            if (r8 == 0) goto L_0x018a
            r2 = r12
            goto L_0x016a
        L_0x018a:
            boolean r8 = r7.equals(r10)
            if (r8 == 0) goto L_0x0192
            r2 = r13
            goto L_0x016a
        L_0x0192:
            java.lang.String r8 = "CELL"
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x019c
            r2 = r15
            goto L_0x016a
        L_0x019c:
            if (r2 >= 0) goto L_0x016a
            boolean r2 = r7.startsWith(r9)
            if (r2 == 0) goto L_0x01a8
            java.lang.String r4 = r4.substring(r13)
        L_0x01a8:
            r5 = r4
            r2 = 0
            goto L_0x016a
        L_0x01ab:
            r12 = r2
            r15 = r3
            goto L_0x01b0
        L_0x01ae:
            r12 = -1
            r15 = 0
        L_0x01b0:
            if (r12 >= 0) goto L_0x01b3
            r12 = 3
        L_0x01b3:
            r0.b(r12, r6, r5, r15)
            goto L_0x040d
        L_0x01b8:
            java.lang.String r7 = "ORG"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x01e7
            java.lang.Object r1 = r2.get(r8)
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x01e1
            java.util.Iterator r1 = r1.iterator()
            r15 = 0
        L_0x01cd:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x01e2
            java.lang.Object r4 = r1.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = r4.equals(r14)
            if (r4 == 0) goto L_0x01cd
            r15 = r12
            goto L_0x01cd
        L_0x01e1:
            r15 = 0
        L_0x01e2:
            r0.w(r12, r3, r2, r15)
            goto L_0x040d
        L_0x01e7:
            java.lang.String r3 = "TITLE"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x01f4
            r0.z(r6)
            goto L_0x040d
        L_0x01f4:
            java.lang.String r3 = "ROLE"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x01fe
            goto L_0x040d
        L_0x01fe:
            java.lang.String r3 = "PHOTO"
            boolean r3 = r1.equals(r3)
            java.lang.String r7 = "URL"
            if (r3 != 0) goto L_0x03cf
            java.lang.String r3 = "LOGO"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0212
            goto L_0x03cf
        L_0x0212:
            java.lang.String r3 = "TEL"
            boolean r3 = r1.equals(r3)
            java.lang.String r4 = "sip:"
            if (r3 == 0) goto L_0x027b
            int r1 = r0.q
            boolean r1 = com.android.vcard.VCardConfig.e(r1)
            if (r1 == 0) goto L_0x023b
            boolean r1 = r6.startsWith(r4)
            if (r1 == 0) goto L_0x022d
            r1 = r5
            r3 = r12
            goto L_0x023d
        L_0x022d:
            java.lang.String r1 = "tel:"
            boolean r1 = r6.startsWith(r1)
            if (r1 == 0) goto L_0x023b
            java.lang.String r1 = r6.substring(r15)
        L_0x0239:
            r3 = 0
            goto L_0x023d
        L_0x023b:
            r1 = r6
            goto L_0x0239
        L_0x023d:
            if (r3 == 0) goto L_0x024a
            java.lang.Object r1 = r2.get(r8)
            java.util.Collection r1 = (java.util.Collection) r1
            r0.y(r6, r1)
            goto L_0x040d
        L_0x024a:
            int r3 = r6.length()
            if (r3 != 0) goto L_0x0251
            return
        L_0x0251:
            java.lang.Object r2 = r2.get(r8)
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object r3 = com.android.vcard.VCardUtils.k(r2, r1)
            boolean r4 = r3 instanceof java.lang.Integer
            if (r4 == 0) goto L_0x0266
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L_0x026b
        L_0x0266:
            java.lang.String r5 = r3.toString()
            r3 = 0
        L_0x026b:
            if (r2 == 0) goto L_0x0275
            boolean r2 = r2.contains(r14)
            if (r2 == 0) goto L_0x0275
            r15 = r12
            goto L_0x0276
        L_0x0275:
            r15 = 0
        L_0x0276:
            r0.g(r3, r1, r5, r15)
            goto L_0x040d
        L_0x027b:
            java.lang.String r3 = "X-SKYPE-PSTNNUMBER"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x029a
            java.lang.Object r1 = r2.get(r8)
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x0293
            boolean r1 = r1.contains(r14)
            if (r1 == 0) goto L_0x0293
            r15 = r12
            goto L_0x0294
        L_0x0293:
            r15 = 0
        L_0x0294:
            r1 = 7
            r0.g(r1, r6, r5, r15)
            goto L_0x040d
        L_0x029a:
            java.util.Map r3 = t
            boolean r5 = r3.containsKey(r1)
            if (r5 == 0) goto L_0x02f2
            java.lang.Object r1 = r3.get(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            java.lang.Object r2 = r2.get(r8)
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x02e2
            java.util.Iterator r2 = r2.iterator()
            r3 = -1
            r15 = 0
        L_0x02ba:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x02e0
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = r4.equals(r14)
            if (r5 == 0) goto L_0x02ce
            r15 = r12
            goto L_0x02ba
        L_0x02ce:
            if (r3 >= 0) goto L_0x02ba
            boolean r5 = r4.equalsIgnoreCase(r11)
            if (r5 == 0) goto L_0x02d8
            r3 = r12
            goto L_0x02ba
        L_0x02d8:
            boolean r4 = r4.equalsIgnoreCase(r10)
            if (r4 == 0) goto L_0x02ba
            r3 = r13
            goto L_0x02ba
        L_0x02e0:
            r5 = r15
            goto L_0x02e4
        L_0x02e2:
            r3 = -1
            r5 = 0
        L_0x02e4:
            if (r3 >= 0) goto L_0x02e8
            r4 = r12
            goto L_0x02e9
        L_0x02e8:
            r4 = r3
        L_0x02e9:
            r2 = 0
            r0 = r17
            r3 = r6
            r0.c(r1, r2, r3, r4, r5)
            goto L_0x040d
        L_0x02f2:
            java.lang.String r3 = "NOTE"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x02ff
            r0.f(r6)
            goto L_0x040d
        L_0x02ff:
            boolean r3 = r1.equals(r7)
            if (r3 == 0) goto L_0x031c
            java.util.List r1 = r0.i
            if (r1 != 0) goto L_0x0310
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r12)
            r0.i = r1
        L_0x0310:
            java.util.List r0 = r0.i
            com.android.vcard.VCardEntry$WebsiteData r1 = new com.android.vcard.VCardEntry$WebsiteData
            r1.<init>(r6)
            r0.add(r1)
            goto L_0x040d
        L_0x031c:
            java.lang.String r3 = "BDAY"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x032d
            com.android.vcard.VCardEntry$BirthdayData r1 = new com.android.vcard.VCardEntry$BirthdayData
            r1.<init>(r6)
            r0.n = r1
            goto L_0x040d
        L_0x032d:
            java.lang.String r3 = "ANNIVERSARY"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x033e
            com.android.vcard.VCardEntry$AnniversaryData r1 = new com.android.vcard.VCardEntry$AnniversaryData
            r1.<init>(r6)
            r0.o = r1
            goto L_0x040d
        L_0x033e:
            java.lang.String r3 = "X-PHONETIC-FIRST-NAME"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x034d
            com.android.vcard.VCardEntry$NameData r0 = r0.b
            java.lang.String unused = r0.h = r6
            goto L_0x040d
        L_0x034d:
            java.lang.String r3 = "X-PHONETIC-MIDDLE-NAME"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x035c
            com.android.vcard.VCardEntry$NameData r0 = r0.b
            java.lang.String unused = r0.i = r6
            goto L_0x040d
        L_0x035c:
            java.lang.String r3 = "X-PHONETIC-LAST-NAME"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x036b
            com.android.vcard.VCardEntry$NameData r0 = r0.b
            java.lang.String unused = r0.g = r6
            goto L_0x040d
        L_0x036b:
            java.lang.String r3 = "IMPP"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0384
            boolean r1 = r6.startsWith(r4)
            if (r1 == 0) goto L_0x040d
            java.lang.Object r1 = r2.get(r8)
            java.util.Collection r1 = (java.util.Collection) r1
            r0.y(r6, r1)
            goto L_0x040d
        L_0x0384:
            java.lang.String r3 = "X-SIP"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x039d
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x040d
            java.lang.Object r1 = r2.get(r8)
            java.util.Collection r1 = (java.util.Collection) r1
            r0.y(r6, r1)
            goto L_0x040d
        L_0x039d:
            java.lang.String r2 = "X-ANDROID-CUSTOM"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x03af
            int r1 = r0.q
            java.util.List r1 = com.android.vcard.VCardUtils.b(r6, r1)
            r0.u(r1)
            goto L_0x040d
        L_0x03af:
            java.lang.String r2 = r1.toUpperCase()
            boolean r2 = r2.startsWith(r9)
            if (r2 == 0) goto L_0x040d
            java.util.List r2 = r0.p
            if (r2 != 0) goto L_0x03c4
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r0.p = r2
        L_0x03c4:
            java.util.List r0 = r0.p
            android.util.Pair r2 = new android.util.Pair
            r2.<init>(r1, r6)
            r0.add(r2)
            goto L_0x040d
        L_0x03cf:
            java.lang.String r1 = "VALUE"
            java.lang.Object r1 = r2.get(r1)
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x03e0
            boolean r1 = r1.contains(r7)
            if (r1 == 0) goto L_0x03e0
            goto L_0x040d
        L_0x03e0:
            java.lang.Object r1 = r2.get(r8)
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x0405
            java.util.Iterator r1 = r1.iterator()
            r15 = 0
        L_0x03ed:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0406
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            boolean r3 = r14.equals(r2)
            if (r3 == 0) goto L_0x0401
            r15 = r12
            goto L_0x03ed
        L_0x0401:
            if (r5 != 0) goto L_0x03ed
            r5 = r2
            goto L_0x03ed
        L_0x0405:
            r15 = 0
        L_0x0406:
            r0.h(r5, r4, r15)
            goto L_0x040d
        L_0x040a:
            r0.e(r6)
        L_0x040d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.vcard.VCardEntry.j(com.android.vcard.VCardProperty):void");
    }

    public final void k(String str, int i2, String str2, boolean z) {
        if (this.j == null) {
            this.j = new ArrayList();
        }
        this.j.add(new SipData(str, i2, str2, z));
    }

    public final String l(Map map) {
        Collection collection = (Collection) map.get("SORT-AS");
        if (collection == null || collection.size() == 0) {
            return null;
        }
        if (collection.size() > 1) {
            Log.w("vCard", "Incorrect multiple SORT_AS parameters detected: " + Arrays.toString(collection.toArray()));
        }
        List<String> b2 = VCardUtils.b((String) collection.iterator().next(), this.q);
        StringBuilder sb = new StringBuilder();
        for (String append : b2) {
            sb.append(append);
        }
        return sb.toString();
    }

    public void m() {
        this.b.k = n();
    }

    public final String n() {
        String str;
        if (!TextUtils.isEmpty(this.b.f)) {
            str = this.b.f;
        } else if (!this.b.w()) {
            str = VCardUtils.d(this.q, this.b.f2378a, this.b.c, this.b.b, this.b.d, this.b.e);
        } else if (!this.b.v()) {
            str = VCardUtils.c(this.q, this.b.g, this.b.i, this.b.h);
        } else {
            List list = this.d;
            if (list == null || list.size() <= 0) {
                List list2 = this.c;
                if (list2 == null || list2.size() <= 0) {
                    List list3 = this.e;
                    if (list3 == null || list3.size() <= 0) {
                        List list4 = this.f;
                        str = (list4 == null || list4.size() <= 0) ? null : ((OrganizationData) this.f.get(0)).j();
                    } else {
                        str = ((PostalData) this.e.get(0)).d(this.q);
                    }
                } else {
                    str = ((PhoneData) this.c.get(0)).f2382a;
                }
            } else {
                str = ((EmailData) this.d.get(0)).f2374a;
            }
        }
        return str == null ? "" : str;
    }

    public ArrayList o(ContentResolver contentResolver, ArrayList arrayList) {
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        if (A()) {
            return arrayList;
        }
        int size = arrayList.size();
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
        Account account = this.r;
        if (account != null) {
            newInsert.withValue(Event.ACCOUNT_NAME, account.name);
            newInsert.withValue("account_type", this.r.type);
        } else {
            newInsert.withValue(Event.ACCOUNT_NAME, (Object) null);
            newInsert.withValue("account_type", (Object) null);
        }
        if (t()) {
            newInsert.withValue("starred", 1);
        }
        arrayList.add(newInsert.build());
        arrayList.size();
        B(new InsertOperationConstrutor(arrayList, size));
        arrayList.size();
        return arrayList;
    }

    public String p() {
        NameData nameData = this.b;
        if (nameData.k == null) {
            nameData.k = n();
        }
        return this.b.k;
    }

    public final List q() {
        return this.d;
    }

    public final List r() {
        return this.c;
    }

    public final List s() {
        return this.h;
    }

    public boolean t() {
        return this.f2370a;
    }

    public String toString() {
        ToStringIterator toStringIterator = new ToStringIterator();
        B(toStringIterator);
        return toStringIterator.toString();
    }

    public final void u(List list) {
        if (this.m == null) {
            this.m = new ArrayList();
        }
        this.m.add(AndroidCustomData.c(list));
    }

    public final void v(List list, Map map) {
        int size;
        E(map);
        if (list != null && (size = list.size()) >= 1) {
            if (size > 5) {
                size = 5;
            }
            if (size != 2) {
                if (size != 3) {
                    if (size != 4) {
                        if (size == 5) {
                            String unused = this.b.e = (String) list.get(4);
                        }
                        String unused2 = this.b.f2378a = (String) list.get(0);
                    }
                    String unused3 = this.b.d = (String) list.get(3);
                }
                String unused4 = this.b.c = (String) list.get(2);
            }
            String unused5 = this.b.b = (String) list.get(1);
            String unused6 = this.b.f2378a = (String) list.get(0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void w(int r8, java.util.List r9, java.util.Map r10, boolean r11) {
        /*
            r7 = this;
            java.lang.String r4 = r7.l(r10)
            if (r9 != 0) goto L_0x0008
            java.util.List r9 = u
        L_0x0008:
            int r10 = r9.size()
            r0 = 0
            if (r10 == 0) goto L_0x0044
            r1 = 0
            r2 = 1
            if (r10 == r2) goto L_0x003b
            java.lang.Object r0 = r9.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r3 = r2
        L_0x001f:
            if (r3 >= r10) goto L_0x0034
            if (r3 <= r2) goto L_0x0028
            r5 = 32
            r1.append(r5)
        L_0x0028:
            java.lang.Object r5 = r9.get(r3)
            java.lang.String r5 = (java.lang.String) r5
            r1.append(r5)
            int r3 = r3 + 1
            goto L_0x001f
        L_0x0034:
            java.lang.String r9 = r1.toString()
            r2 = r9
            r1 = r0
            goto L_0x0047
        L_0x003b:
            java.lang.Object r9 = r9.get(r1)
            java.lang.String r9 = (java.lang.String) r9
        L_0x0041:
            r1 = r9
            r2 = r0
            goto L_0x0047
        L_0x0044:
            java.lang.String r9 = ""
            goto L_0x0041
        L_0x0047:
            java.util.List r9 = r7.f
            if (r9 != 0) goto L_0x0053
            r3 = 0
            r0 = r7
            r5 = r8
            r6 = r11
            r0.d(r1, r2, r3, r4, r5, r6)
            return
        L_0x0053:
            java.util.Iterator r9 = r9.iterator()
        L_0x0057:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0079
            java.lang.Object r10 = r9.next()
            com.android.vcard.VCardEntry$OrganizationData r10 = (com.android.vcard.VCardEntry.OrganizationData) r10
            java.lang.String r0 = r10.f2381a
            if (r0 != 0) goto L_0x0057
            java.lang.String r0 = r10.b
            if (r0 != 0) goto L_0x0057
            java.lang.String unused = r10.f2381a = r1
            java.lang.String unused = r10.b = r2
            boolean unused = r10.f = r11
            return
        L_0x0079:
            r3 = 0
            r0 = r7
            r5 = r8
            r6 = r11
            r0.d(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.vcard.VCardEntry.w(int, java.util.List, java.util.Map, boolean):void");
    }

    public final void x(List list) {
        int size;
        if (TextUtils.isEmpty(this.b.g) && TextUtils.isEmpty(this.b.i) && TextUtils.isEmpty(this.b.h) && list != null && (size = list.size()) >= 1) {
            if (size > 3) {
                size = 3;
            }
            if (((String) list.get(0)).length() > 0) {
                int i2 = 1;
                while (i2 < size) {
                    if (((String) list.get(i2)).length() <= 0) {
                        i2++;
                    }
                }
                String[] split = ((String) list.get(0)).split(" ");
                int length = split.length;
                if (length == 3) {
                    String unused = this.b.g = split[0];
                    String unused2 = this.b.i = split[1];
                    String unused3 = this.b.h = split[2];
                    return;
                } else if (length == 2) {
                    String unused4 = this.b.g = split[0];
                    String unused5 = this.b.h = split[1];
                    return;
                } else {
                    String unused6 = this.b.h = (String) list.get(0);
                    return;
                }
            }
            if (size != 2) {
                if (size == 3) {
                    String unused7 = this.b.i = (String) list.get(2);
                }
                String unused8 = this.b.g = (String) list.get(0);
            }
            String unused9 = this.b.h = (String) list.get(1);
            String unused10 = this.b.g = (String) list.get(0);
        }
    }

    public final void y(String str, Collection collection) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("sip:")) {
                str = str.substring(4);
                if (str.length() == 0) {
                    return;
                }
            }
            boolean z = false;
            int i2 = -1;
            String str2 = null;
            if (collection != null) {
                Iterator it = collection.iterator();
                boolean z2 = false;
                while (it.hasNext()) {
                    String str3 = (String) it.next();
                    String upperCase = str3.toUpperCase();
                    int i3 = 1;
                    if (upperCase.equals("PREF")) {
                        z2 = true;
                    } else {
                        if (!upperCase.equals("HOME")) {
                            i3 = 2;
                            if (!upperCase.equals("WORK")) {
                                if (i2 < 0) {
                                    if (upperCase.startsWith("X-")) {
                                        str3 = str3.substring(2);
                                    }
                                    i2 = 0;
                                    str2 = str3;
                                }
                            }
                        }
                        i2 = i3;
                    }
                }
                z = z2;
            }
            if (i2 < 0) {
                i2 = 3;
            }
            k(str, i2, str2, z);
        }
    }

    public final void z(String str) {
        List<OrganizationData> list = this.f;
        if (list == null) {
            d((String) null, (String) null, str, (String) null, 1, false);
            return;
        }
        for (OrganizationData organizationData : list) {
            if (organizationData.c == null) {
                String unused = organizationData.c = str;
                return;
            }
        }
        d((String) null, (String) null, str, (String) null, 1, false);
    }
}
