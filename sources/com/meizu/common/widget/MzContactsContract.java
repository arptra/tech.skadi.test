package com.meizu.common.widget;

import android.accounts.Account;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

public final class MzContactsContract {
    public static final String ALLOW_CALLLOGS_PARAM_KEY = "allow_calllogs";
    public static final Uri AUTHORITY_URI_NOTIFY = Uri.parse("content://com.android.contacts.notify");
    public static final String HAS_MORE_KEY = "has_more";
    private static Pattern SPLIT_PATTERN = Pattern.compile("([\\w-\\.]+)@((?:[\\w]+\\.)+)([a-zA-Z]{2,4})|[\\w]+");
    public static final String START_PARAM_KEY = "start";
    public static final String USE_WEIGHT_ORDER = "use_weight_order";

    public static final class MzAccounts {
        public static final Account DEVICES_ONLY_ACCOUNT = new Account("DeviceOnly", "DeviceOnly");
        private static final String DEVICES_ONLY_ACCOUNT_NAME = "DeviceOnly";
        private static final String DEVICES_ONLY_ACCOUNT_TYPE = "DeviceOnly";
        public static final String FLYME_ACCOUNT_TYPE = "com.meizu.account";
        public static final String SINA_ACCOUNT_TYPE = "com.meizu.sns.sina";
        public static final Account VENDER_ACCOUNT = new Account("account.vender", "account.vender");
        private static final String VENDER_ACCOUNT_NAME = "account.vender";
        public static final String VENDER_ACCOUNT_TYPE = "account.vender";

        private MzAccounts() {
        }

        public static Account[] addDeviceOnlyAccount(Account[] accountArr) {
            int i = 1;
            Account[] accountArr2 = new Account[(accountArr.length + 1)];
            int i2 = 0;
            accountArr2[0] = DEVICES_ONLY_ACCOUNT;
            int length = accountArr.length;
            while (i2 < length) {
                accountArr2[i] = accountArr[i2];
                i2++;
                i++;
            }
            return accountArr2;
        }

        public static boolean isFlymeAccount(Account account) {
            return account != null && TextUtils.equals(account.type, FLYME_ACCOUNT_TYPE);
        }
    }

    public static final class MzCommonDataKinds {

        public static final class MzEmail {
            public static final Uri CONTENT_GROUP_URI = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Email.CONTENT_URI, "group");
            public static final String USE_CUSTOM_ORDER = "use_custom_order";
        }

        public static final class MzEvent {
            public static final int TYPE_LUNAR_BIRTHDAY = 4;

            public static int getTypeResource(Integer num) {
                return ContactsContract.CommonDataKinds.Event.getTypeResource(num);
            }
        }

        public static final class MzGroupMembership {
            public static final String GROUP_TITLE = "group_title";
        }

        public static final class MzOrganization {
            public static final String IS_ORGANIZATION_NOTE = "data12";
        }

        public static final class MzPhone {
            public static final Uri CONTENT_GROUP_URI = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, "group");
            public static final String CONVERT_LETTERS = "convert_letters";

            private MzPhone() {
            }
        }

        public static final class MzPhoneAndEmail {
            public static final Uri CONTENT_FILTER_URI;
            public static final Uri CONTENT_GROUP_URI;
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/phone_email";
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/phone_email";
            public static final Uri CONTENT_URI;

            static {
                Uri withAppendedPath = Uri.withAppendedPath(ContactsContract.Data.CONTENT_URI, "phones_emails");
                CONTENT_URI = withAppendedPath;
                CONTENT_FILTER_URI = Uri.withAppendedPath(withAppendedPath, "filter");
                CONTENT_GROUP_URI = Uri.withAppendedPath(withAppendedPath, "group");
            }

            private MzPhoneAndEmail() {
            }
        }

        private MzCommonDataKinds() {
        }
    }

    public interface MzContactColumns {
        public static final String ADDRESS = "address";
        public static final String DISTANCE = "distance";
        public static final String PHONE_NUMBER = "phone_number";
        public static final String RECORD_TYPE = "record_type";
        public static final String SNS_TYPE = "sns_type";
    }

    public interface MzContactOptionsColumns {
        public static final String ORGANIZATION_NOTE = "organization_note";
    }

    public static class MzContacts implements MzContactColumns {
        public static final Uri CONTENT_EX_GROUP_URI;
        public static final Uri CONTENT_EX_URI;

        public static final class MzPhoto {
            public static final String FORCE_SET_PRIMARY = "data12";
        }

        static {
            Uri withAppendedPath = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, "ex");
            CONTENT_EX_URI = withAppendedPath;
            CONTENT_EX_GROUP_URI = Uri.withAppendedPath(withAppendedPath, "group");
        }
    }

    public static final class MzData {
        public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(ContactsContract.Data.CONTENT_URI, "filter");

        public static Uri buildUriWithRequestMimetypes(Uri uri, String[] strArr) {
            if (strArr == null || strArr.length < 1) {
                return uri;
            }
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                if (sb.length() > 0) {
                    sb.append(';');
                }
                if (TextUtils.equals("vnd.android.cursor.item/phone_v2", str)) {
                    sb.append("phone");
                } else if (TextUtils.equals("vnd.android.cursor.item/email_v2", str)) {
                    sb.append(Scopes.EMAIL);
                }
            }
            return sb.length() > 0 ? uri.buildUpon().appendQueryParameter("request_mimes", sb.toString()).build() : uri;
        }
    }

    public static final class MzDirectory {
        public static final Uri CONTENT_NOTIFY_URI = Uri.withAppendedPath(MzContactsContract.AUTHORITY_URI_NOTIFY, "directories");
        public static final String IS_VISIBLE = "is_visible";
        public static final long NET_CONTACT = 2;
    }

    public static final class MzDisplayPhoto {
        public static final String STORE_ORIGINAL = "store_original";
    }

    public static final class MzGroups implements BaseColumns, MzGroupsColumns {
        public static final Uri CONTENT_ACCOUNT_URI = Uri.withAppendedPath(ContactsContract.Groups.CONTENT_URI, "account");
        public static final Uri CONTENT_SUMMARY_FILTER_URI = Uri.withAppendedPath(ContactsContract.Groups.CONTENT_SUMMARY_URI, "filter");
        public static final String GROUP_SPLIT_MARK_EXTRA = ",";
        public static final String GROUP_SPLIT_MARK_SLASH = "/";
        public static final String GROUP_SPLIT_MARK_VCARD = ";";
        public static final String GROUP_SPLIT_MARK_XML = "|";

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
        /* JADX WARNING: type inference failed for: r1v3 */
        /* JADX WARNING: type inference failed for: r1v5 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x003a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String getGroupTitle(android.content.ContentResolver r8, long r9) {
            /*
                r0 = 0
                int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                r1 = 0
                if (r0 > 0) goto L_0x0008
                return r1
            L_0x0008:
                java.lang.String r9 = java.lang.String.valueOf(r9)
                java.lang.String[] r6 = new java.lang.String[]{r9}
                android.net.Uri r3 = android.provider.ContactsContract.Groups.CONTENT_URI     // Catch:{ all -> 0x0037 }
                java.lang.String r9 = "title"
                java.lang.String[] r4 = new java.lang.String[]{r9}     // Catch:{ all -> 0x0037 }
                java.lang.String r5 = "_id=?"
                r7 = 0
                r2 = r8
                android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0037 }
                if (r8 == 0) goto L_0x0031
                boolean r9 = r8.moveToFirst()     // Catch:{ all -> 0x002e }
                if (r9 == 0) goto L_0x0031
                r9 = 0
                java.lang.String r1 = r8.getString(r9)     // Catch:{ all -> 0x002e }
                goto L_0x0031
            L_0x002e:
                r9 = move-exception
                r1 = r8
                goto L_0x0038
            L_0x0031:
                if (r8 == 0) goto L_0x0036
                r8.close()
            L_0x0036:
                return r1
            L_0x0037:
                r9 = move-exception
            L_0x0038:
                if (r1 == 0) goto L_0x003d
                r1.close()
            L_0x003d:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.MzContactsContract.MzGroups.getGroupTitle(android.content.ContentResolver, long):java.lang.String");
        }
    }

    public interface MzGroupsColumns {
        public static final String ACCOUNT_ORDER = "account_order";
        public static final String REJECTED = "rejected";
        public static final String SUMMARY_DATA_COUNT = "summary_data_count";
        public static final String VIEW_ORDER = "view_order";
    }

    public static final class MzIntents {
        public static final String EXTRA_MULTIPLE_PICK_DATAS = "com.android.contacts.extra.MULTIPLE_PICK_DATAS";
        public static final String EXTRA_PICK_DATA = "com.android.contacts.extra.PICK_DATA";
        public static final String EXTRA_REQUEST_DATA_IDS = "com.android.contacts.extra.EXTRA_REQUEST_DATA_IDS";

        public static final class MzInsert {
            public static final String SOCIAL_PROFILE = "social_profile";
            public static final String SOCIAL_PROFILE_TYPE = "social_profile_type";
        }

        public static final class MzUI {
            public static final String BROWSE_ALL_CONTACTS_ACTION = "com.android.contacts.action.BROWSE_ALL_CONTACTS";
            public static final String REQUESTED_INFO_TYPE_KEY = "com.android.contacts.extra.REQUESTED_INFO_TYPE";
            public static final int REQUESTED_INFO_TYPE_NONE = -1;
            public static final int REQUESTED_INFO_TYPE_TEXT = 1;
            public static final int REQUESTED_INFO_TYPE_VCARD = 0;
            public static final String REQUESTED_ORIENTATION = "com.android.contacts.extra.REQUESTED_ORIENTATION";
            public static final String SHOULD_INCLUDE_CONTACT_KEY = "com.android.contacts.extra.SHOULD_INCLUDE_CONTACT";
            public static final String SHOULD_INCLUDE_PROFILE_KEY = "com.android.contacts.extra.SHOULD_INCLUDE_PROFILE";
            public static final String SUB_TITLE_EXTRA_KEY = "com.android.contacts.extra.SUB_TITLE_EXTRA";
        }
    }

    public static final class MzNetContacts {
        public static final String AUTHORITY = "com.meizu.netcontactservice.directory";
        public static final String ERROR_CODE_KEY = "error_code";
        public static final int ERROR_CODE_NETWORK_UNAVAILABLE = 1;
        public static final int ERROR_CODE_NO_ADDRESS = 2;
        public static final int ERROR_CODE_NUMBER_INVALIDATE = 3;
        public static final int ERROR_CODE_SUCCESS = 0;
        public static final int ERROR_CODE_UNKNOWN = 4;
        public static final String LINK_DISPLAY_NAME_AND_LABLE = "link_display_name_and_lable";
        public static final String NET_CONTACT_ACCOUNT_TYPE = "com.meizu.netcontactservice";
        public static final String NET_CONTACT_DIRECTORY_TYPE = "NetContact";
        public static final Uri PHONE_LOOKUP_URI = Uri.withAppendedPath(Uri.parse("content://com.meizu.netcontactservice.directory"), "phone_lookup");
        public static final String USE_YELLOW_PAGE_CONTACTS = "use_yellow_page_contacts";
        public static final long YELLOW_PAGE_MIN_ID = 9223372035781033983L;

        public static boolean isYPContact(long j) {
            return j >= YELLOW_PAGE_MIN_ID;
        }

        public static boolean isYPContact(Uri uri) {
            try {
                return isYPContact(ContentUris.parseId(uri));
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public static final class MzPhoneLookup implements MzContactOptionsColumns, MzContactColumns {
        public static final String CALL_ALLOWED_CONTACT_IDS = "call_allowed_contact_ids";
        public static final String CALL_REJECTED_CONTACT_IDS = "call_rejected_contact_ids";
        public static final String CALL_REJECTED_EXTRAS = "call_rejected_extras";
        public static final String CALL_REJECTED_TYPE = "call_rejected_type";

        public static Uri buildRejectedExtrasUri(Uri uri) {
            return uri.buildUpon().appendQueryParameter(CALL_REJECTED_EXTRAS, BooleanUtils.TRUE).build();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
            if (r1 != null) goto L_0x0033;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
            if (r1 == null) goto L_0x0040;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean isPhoneNumberInContact(android.content.Context r8, java.lang.String r9) {
            /*
                r0 = 0
                if (r8 == 0) goto L_0x0040
                boolean r1 = android.text.TextUtils.isEmpty(r9)
                if (r1 == 0) goto L_0x000a
                goto L_0x0040
            L_0x000a:
                r1 = 0
                android.content.ContentResolver r2 = r8.getContentResolver()     // Catch:{ Exception -> 0x003d, all -> 0x002f }
                android.net.Uri r8 = android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI     // Catch:{ Exception -> 0x003d, all -> 0x002f }
                android.net.Uri r3 = android.net.Uri.withAppendedPath(r8, r9)     // Catch:{ Exception -> 0x003d, all -> 0x002f }
                java.lang.String r8 = "_id"
                java.lang.String[] r4 = new java.lang.String[]{r8}     // Catch:{ Exception -> 0x003d, all -> 0x002f }
                r6 = 0
                r7 = 0
                r5 = 0
                android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x003d, all -> 0x002f }
                if (r1 == 0) goto L_0x0031
                int r8 = r1.getCount()     // Catch:{ Exception -> 0x003d, all -> 0x002f }
                if (r8 <= 0) goto L_0x002b
                r0 = 1
            L_0x002b:
                r1.close()
                return r0
            L_0x002f:
                r8 = move-exception
                goto L_0x0037
            L_0x0031:
                if (r1 == 0) goto L_0x0040
            L_0x0033:
                r1.close()
                goto L_0x0040
            L_0x0037:
                if (r1 == 0) goto L_0x003c
                r1.close()
            L_0x003c:
                throw r8
            L_0x003d:
                if (r1 == 0) goto L_0x0040
                goto L_0x0033
            L_0x0040:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.MzContactsContract.MzPhoneLookup.isPhoneNumberInContact(android.content.Context, java.lang.String):boolean");
        }
    }

    public static final class MzQuickContact {
        public static final String ACTION_MZ_QUICK_CONTACT = "com.android.contacts.action.MZ_QUICK_CONTACT";
    }

    public interface MzRawContactColumns {
        public static final String IS_SUPER_PHONE = "is_super_phone";
        public static final String IS_SUPER_PHOTO = "is_super_photo";
        public static final String RAW_PHONE_NUMBER = "raw_phone_number";
        public static final String RAW_PHOTO_FILE_ID = "raw_photo_file_id";
        public static final String RAW_PHOTO_ID = "raw_photo_id";
        public static final String RAW_PHOTO_THUMBNAIL_URI = "raw_photo_thumb_uri";
        public static final String RAW_PHOTO_URI = "raw_photo_uri";
        public static final String SNS_TYPE = "sns_type";
    }

    public static class MzSearchSnippetColumns {
        public static final String SEARCH_WEIGHT = "search_weight";
        public static final int SEARCH_WEIGHT_CONTENT = 10002;
        public static final int SEARCH_WEIGHT_NAME = 10000;
        public static final int SEARCH_WEIGHT_TOKENS = 10001;
        public static final int SEARCH_WEIGHT_UNKNOW = 10003;
    }

    public static final class MzSettings implements MzSettingsColumns {
        public static final Uri CONTENT_NOTIFY_URI = Uri.withAppendedPath(MzContactsContract.AUTHORITY_URI_NOTIFY, "settings");

        private MzSettings() {
        }
    }

    public interface MzSettingsColumns {
        public static final String DIRECTORY_VISIBLE = "directory_visible";
        public static final String IS_DEFAULT = "is_default";
        public static final String SYNC_WITH_DEFAULT_ACCOUNT = "sync_with_default_account";
    }

    private static void MzSplit(String str, List<String> list, List<Integer> list2) {
        Matcher matcher = SPLIT_PATTERN.matcher(str);
        while (matcher.find()) {
            list.add(matcher.group());
            list2.add(Integer.valueOf(matcher.start()));
        }
    }

    public static String snippetize(String str, String str2, String str3, char c, char c2, String str4, int i) {
        String str5 = str4;
        String str6 = null;
        String lowerCase = str3 != null ? str3.toLowerCase() : null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2) || !str.toLowerCase().contains(lowerCase)) {
            return null;
        }
        String lowerCase2 = str2 != null ? str2.toLowerCase() : "";
        ArrayList<String> arrayList = new ArrayList<>();
        MzSplit(lowerCase2.trim(), arrayList, new ArrayList());
        for (String startsWith : arrayList) {
            if (startsWith.startsWith(lowerCase)) {
                return null;
            }
        }
        String[] split = str.split(StringUtils.LF);
        int length = split.length;
        int i2 = 0;
        while (i2 < length) {
            String str7 = split[i2];
            if (str7.toLowerCase().contains(lowerCase)) {
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                MzSplit(str7, arrayList2, arrayList3);
                ArrayList arrayList4 = new ArrayList();
                int i3 = -1;
                int i4 = -1;
                for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                    String str8 = (String) arrayList2.get(i5);
                    if (str8.toLowerCase().startsWith(lowerCase)) {
                        arrayList4.add(c + str8 + c2);
                        if (i3 == -1) {
                            int max = Math.max(0, i5 - ((int) Math.floor(((double) Math.abs(i)) / 2.0d)));
                            i4 = Math.min(arrayList2.size(), max + Math.abs(i));
                            i3 = max;
                        }
                    } else {
                        char c3 = c;
                        arrayList4.add(str8);
                    }
                }
                char c4 = c;
                if (i3 > -1) {
                    StringBuilder sb = new StringBuilder();
                    if (i3 > 0) {
                        sb.append(str5);
                    }
                    while (i3 < i4) {
                        String str9 = (String) arrayList2.get(i3);
                        sb.append((String) arrayList4.get(i3));
                        if (i3 < i4 - 1) {
                            sb.append(str7, ((Integer) arrayList3.get(i3)).intValue() + str9.length(), ((Integer) arrayList3.get(i3 + 1)).intValue());
                        }
                        i3++;
                    }
                    if (i4 < arrayList2.size()) {
                        sb.append(str5);
                    }
                    return sb.toString();
                }
            } else {
                char c5 = c;
            }
            i2++;
            str6 = null;
        }
        return str6;
    }
}
