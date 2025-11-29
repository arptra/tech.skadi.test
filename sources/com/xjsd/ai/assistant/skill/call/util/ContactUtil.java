package com.xjsd.ai.assistant.skill.call.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.honey.account.country.db.CountryTable;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.skill.call.bean.ContactBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

@SuppressLint({"NewApi"})
public final class ContactUtil {

    /* renamed from: a  reason: collision with root package name */
    public static Map f8677a;

    static {
        HashMap hashMap = new HashMap();
        f8677a = hashMap;
        hashMap.put("1", "一");
        f8677a.put("2", "二");
        f8677a.put("3", "三");
        f8677a.put("4", "四");
        f8677a.put("5", "五");
        f8677a.put("6", "六");
        f8677a.put("7", "七");
        f8677a.put("8", "八");
        f8677a.put("9", "九");
        f8677a.put("0", "零");
    }

    public static String a(String str) {
        HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
        hanyuPinyinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        try {
            return PinyinHelper.toHanyuPinyinString(str, hanyuPinyinOutputFormat, "").toLowerCase();
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            ILog.h("PhoneCall#ContactUtil", "chineseToPinyin: 汉字->" + str + "，转拼音报错", e);
            return "";
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 1;
            String substring = str.substring(i, i2);
            sb.append((String) f8677a.getOrDefault(substring, substring));
            i = i2;
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008e, code lost:
        if (r2.isClosed() == false) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0090, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ab, code lost:
        if (r2.isClosed() == false) goto L_0x0090;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List c(android.content.Context r11, java.lang.String r12) {
        /*
            java.lang.String r0 = "PhoneCall#ContactUtil"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            boolean r2 = android.text.TextUtils.isEmpty(r12)
            if (r2 == 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.String r2 = "data2"
            java.lang.String r3 = "is_primary"
            java.lang.String r4 = "data1"
            java.lang.String[] r7 = new java.lang.String[]{r4, r2, r3}
            java.lang.String r2 = "contact_id"
            java.lang.Object[] r2 = new java.lang.Object[]{r2, r4}
            java.lang.String r3 = "(%s=?) AND (%s!=?)"
            java.lang.String r8 = java.lang.String.format(r3, r2)
            r2 = 0
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch:{ Exception -> 0x0073 }
            android.net.Uri r6 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI     // Catch:{ Exception -> 0x0073 }
            java.lang.String r11 = ""
            java.lang.String[] r9 = new java.lang.String[]{r12, r11}     // Catch:{ Exception -> 0x0073 }
            java.lang.String r10 = "is_primary DESC"
            android.database.Cursor r2 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0073 }
            if (r2 == 0) goto L_0x0094
            int r11 = r2.getCount()     // Catch:{ Exception -> 0x0073 }
            if (r11 > 0) goto L_0x0040
            goto L_0x0094
        L_0x0040:
            boolean r11 = r2.moveToFirst()     // Catch:{ Exception -> 0x0073 }
            if (r11 == 0) goto L_0x008a
        L_0x0046:
            boolean r11 = r2.isAfterLast()     // Catch:{ Exception -> 0x0073 }
            if (r11 != 0) goto L_0x008a
            r11 = 0
            java.lang.String r12 = r2.getString(r11)     // Catch:{ Exception -> 0x0073 }
            if (r12 == 0) goto L_0x0086
            r3 = 1
            int r3 = r2.getInt(r3)     // Catch:{ Exception -> 0x0073 }
            java.lang.String r4 = "getNumberListById: 电话号码->%s，类型->%d"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0073 }
            java.lang.Object[] r5 = new java.lang.Object[]{r12, r5}     // Catch:{ Exception -> 0x0073 }
            com.xjsd.ai.assistant.log.ILog.k(r0, r4, r5)     // Catch:{ Exception -> 0x0073 }
            boolean r4 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0073 }
            if (r4 == 0) goto L_0x0075
            java.lang.String r11 = "getNumberListById: 预处理后电话号码为null，排除！"
            com.xjsd.ai.assistant.log.ILog.j(r0, r11)     // Catch:{ Exception -> 0x0073 }
            goto L_0x0086
        L_0x0071:
            r11 = move-exception
            goto L_0x00af
        L_0x0073:
            r11 = move-exception
            goto L_0x00a0
        L_0x0075:
            java.lang.String r4 = "getNumberListById: 预处理后的电话号码->%s"
            java.lang.Object[] r5 = new java.lang.Object[]{r12}     // Catch:{ Exception -> 0x0073 }
            com.xjsd.ai.assistant.log.ILog.k(r0, r4, r5)     // Catch:{ Exception -> 0x0073 }
            com.xjsd.ai.assistant.skill.call.bean.PhoneNumberBean r4 = new com.xjsd.ai.assistant.skill.call.bean.PhoneNumberBean     // Catch:{ Exception -> 0x0073 }
            r4.<init>(r3, r12)     // Catch:{ Exception -> 0x0073 }
            r1.add(r11, r4)     // Catch:{ Exception -> 0x0073 }
        L_0x0086:
            r2.moveToNext()     // Catch:{ Exception -> 0x0073 }
            goto L_0x0046
        L_0x008a:
            boolean r11 = r2.isClosed()
            if (r11 != 0) goto L_0x00ae
        L_0x0090:
            r2.close()
            goto L_0x00ae
        L_0x0094:
            if (r2 == 0) goto L_0x009f
            boolean r11 = r2.isClosed()
            if (r11 != 0) goto L_0x009f
            r2.close()
        L_0x009f:
            return r1
        L_0x00a0:
            java.lang.String r12 = "getNumberListById: catch exception"
            com.xjsd.ai.assistant.log.ILog.h(r0, r12, r11)     // Catch:{ all -> 0x0071 }
            if (r2 == 0) goto L_0x00ae
            boolean r11 = r2.isClosed()
            if (r11 != 0) goto L_0x00ae
            goto L_0x0090
        L_0x00ae:
            return r1
        L_0x00af:
            if (r2 == 0) goto L_0x00ba
            boolean r12 = r2.isClosed()
            if (r12 != 0) goto L_0x00ba
            r2.close()
        L_0x00ba:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.call.util.ContactUtil.c(android.content.Context, java.lang.String):java.util.List");
    }

    public static List d(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        String b = b(str);
        String a2 = a(b);
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{"_id", "display_name", "lookup", CountryTable.SORT_KEY}, (String) null, (String[]) null, "sort_key COLLATE LOCALIZED ASC");
            if (query == null) {
                if (query != null && !query.isClosed()) {
                    query.close();
                }
                return arrayList;
            }
            try {
                if (query.getCount() <= 0) {
                    if (!query.isClosed()) {
                        query.close();
                    }
                    return arrayList;
                }
                while (query.moveToNext()) {
                    String string = query.getString(1);
                    if (!TextUtils.isEmpty(string)) {
                        String b2 = b(string);
                        String a3 = a(b2);
                        ILog.c("PhoneCall#ContactUtil", "searchContact: target[%s, %s, %s], compare[%s, %s, %s]", str, b, a2, string, b2, a3);
                        if (a3.contains(a2)) {
                            String string2 = query.getString(0);
                            ContactBean contactBean = new ContactBean();
                            contactBean.setContactId(string2);
                            contactBean.setName(string);
                            contactBean.setLookup(TextUtils.isEmpty(query.getString(2)) ? "1" : query.getString(2));
                            List c = c(context, string2);
                            if (c.isEmpty()) {
                                ILog.c("PhoneCall#ContactUtil", "searchContact: 联系人%s的电话号码为空，排除", string);
                            } else {
                                contactBean.setPhoneNumber(c);
                                arrayList.add(contactBean);
                            }
                        } else {
                            Context context2 = context;
                        }
                    }
                }
                if (!query.isClosed()) {
                    query.close();
                }
                return arrayList;
            } catch (Exception e) {
                e = e;
                cursor = query;
                try {
                    ILog.h("PhoneCall#ContactUtil", "searchContact: catch exception", e);
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                cursor.close();
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            ILog.h("PhoneCall#ContactUtil", "searchContact: catch exception", e);
            cursor.close();
            return arrayList;
        }
    }
}
