package com.upuphone.xr.sapp.utils;

import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import androidx.core.content.ContextCompat;
import com.google.i18n.phonenumbers.PhoneNumberToCarrierMapper;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.sapp.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.slf4j.Marker;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\n\u0010\u0007J!\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018R\u001c\u0010\u001c\u001a\n \u0014*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001bR\u001c\u0010\u001f\u001a\n \u0014*\u0004\u0018\u00010\u001d0\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001e¨\u0006 "}, d2 = {"Lcom/upuphone/xr/sapp/utils/ContactHelper;", "", "<init>", "()V", "", "phoneNum", "c", "(Ljava/lang/String;)Ljava/lang/String;", "phoneNumber", "d", "f", "phoneNumberStr", "divider", "a", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "", "e", "()Ljava/util/List;", "Lcom/google/i18n/phonenumbers/PhoneNumberUtil;", "kotlin.jvm.PlatformType", "b", "Lcom/google/i18n/phonenumbers/PhoneNumberUtil;", "phoneNumberUtil", "I", "countryCode", "Lcom/google/i18n/phonenumbers/PhoneNumberToCarrierMapper;", "Lcom/google/i18n/phonenumbers/PhoneNumberToCarrierMapper;", "carrierMapper", "Lcom/google/i18n/phonenumbers/geocoding/PhoneNumberOfflineGeocoder;", "Lcom/google/i18n/phonenumbers/geocoding/PhoneNumberOfflineGeocoder;", "geocoder", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nContactHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactHelper.kt\ncom/upuphone/xr/sapp/utils/ContactHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,352:1\n1855#2,2:353\n1855#2,2:357\n1855#2:361\n1856#2:364\n13309#3,2:355\n13309#3,2:359\n13309#3,2:362\n*S KotlinDebug\n*F\n+ 1 ContactHelper.kt\ncom/upuphone/xr/sapp/utils/ContactHelper\n*L\n48#1:353,2\n288#1:357,2\n334#1:361\n334#1:364\n62#1:355,2\n307#1:359,2\n335#1:362,2\n*E\n"})
public final class ContactHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final ContactHelper f7857a = new ContactHelper();
    public static final PhoneNumberUtil b;
    public static final int c;
    public static final PhoneNumberToCarrierMapper d = PhoneNumberToCarrierMapper.getInstance();
    public static final PhoneNumberOfflineGeocoder e = PhoneNumberOfflineGeocoder.getInstance();

    static {
        PhoneNumberUtil instance = PhoneNumberUtil.getInstance();
        b = instance;
        c = instance.getCountryCodeForRegion(Locale.getDefault().getCountry());
    }

    public static /* synthetic */ String b(ContactHelper contactHelper, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = " ";
        }
        return contactHelper.a(str, str2);
    }

    public final String a(String str, String str2) {
        try {
            Result.Companion companion = Result.Companion;
            StringBuilder sb = new StringBuilder();
            String obj = StringsKt.reversed((CharSequence) str).toString();
            int length = obj.length();
            for (int i = 0; i < length; i++) {
                if (i == 4 || i == 8) {
                    sb.append(str2);
                }
                sb.append(obj.charAt(i));
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return StringsKt.reversed((CharSequence) sb2).toString();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
            return str;
        }
    }

    public final String c(String str) {
        String f;
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "phoneNum");
        ULog.f6446a.a("ContactHelper", "getDisplayNameByPhone :" + str2);
        String f2 = f(str);
        List<Number> e2 = e();
        if (f2 == null || f2.length() == 0) {
            for (Number intValue : e2) {
                int intValue2 = intValue.intValue();
                if (StringsKt.startsWith$default(str2, String.valueOf(intValue2), false, 2, (Object) null)) {
                    f = f7857a.f(Marker.ANY_NON_NULL_MARKER + str2);
                    if (f == null) {
                    }
                } else {
                    f = f7857a.f(Marker.ANY_NON_NULL_MARKER + intValue2 + str2);
                    if (f == null) {
                    }
                }
                f2 = f;
            }
        }
        if (f2 == null || f2.length() == 0) {
            String[] stringArray = GlobalExtKt.f().getResources().getStringArray(R.array.CountryCodes);
            Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
            for (String str3 : stringArray) {
                Intrinsics.checkNotNull(str3);
                int parseInt = Integer.parseInt((String) StringsKt.split$default((CharSequence) str3, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA}, false, 0, 6, (Object) null).get(0));
                if (!e2.contains(Integer.valueOf(parseInt)) && StringsKt.startsWith$default(str2, String.valueOf(parseInt), false, 2, (Object) null)) {
                    ULog.f6446a.a("ContactHelper", "getDisplayNameByPhone :" + parseInt);
                    String f3 = f7857a.f(Marker.ANY_NON_NULL_MARKER + str2);
                    if (f3 != null) {
                        f2 = f3;
                    }
                }
            }
        }
        return f2 == null ? str2 : f2;
    }

    public final String d(String str) {
        Object obj;
        Phonenumber.PhoneNumber phoneNumber;
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "phoneNumber");
        ULog.f6446a.a("ContactHelper", "getGeo phoneNum:" + str2);
        if (str.length() == 0) {
            return "";
        }
        try {
            Result.Companion companion = Result.Companion;
            PhoneNumberUtil phoneNumberUtil = b;
            obj = Result.m20constructorimpl(Boolean.valueOf(phoneNumberUtil.isValidNumber(phoneNumberUtil.parse(str2, (String) null))));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m27isSuccessimpl(obj)) {
            String descriptionForNumber = e.getDescriptionForNumber(b.parse(str2, (String) null), GlobalExtKt.n(ControlUtils.f7858a.y()));
            Intrinsics.checkNotNullExpressionValue(descriptionForNumber, "getDescriptionForNumber(...)");
            return descriptionForNumber;
        }
        try {
            PhoneNumberUtil phoneNumberUtil2 = b;
            Phonenumber.PhoneNumber parse = phoneNumberUtil2.parse(str2, "CH");
            boolean isValidNumber = phoneNumberUtil2.isValidNumber(parse);
            String descriptionForNumber2 = e.getDescriptionForNumber(parse, GlobalExtKt.n(ControlUtils.f7858a.y()));
            if (isValidNumber) {
                Intrinsics.checkNotNull(descriptionForNumber2);
                if (descriptionForNumber2.length() > 0) {
                    return descriptionForNumber2;
                }
            }
            Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th2));
        }
        List e2 = e();
        try {
            Iterator it = e2.iterator();
            do {
                if (it.hasNext()) {
                    int intValue = ((Number) it.next()).intValue();
                    if (StringsKt.startsWith$default(str2, String.valueOf(intValue), false, 2, (Object) null)) {
                        String d2 = d(Marker.ANY_NON_NULL_MARKER + str2);
                        if (d2.length() > 0) {
                            return d2;
                        }
                    }
                    phoneNumber = new Phonenumber.PhoneNumber();
                    phoneNumber.setCountryCode(intValue);
                    phoneNumber.setNationalNumber(Long.parseLong(str));
                    ILog.i("ContactHelper", "CountryCode " + intValue);
                } else {
                    String[] stringArray = GlobalExtKt.f().getResources().getStringArray(R.array.CountryCodes);
                    Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
                    for (String str3 : stringArray) {
                        Intrinsics.checkNotNull(str3);
                        int parseInt = Integer.parseInt((String) StringsKt.split$default((CharSequence) str3, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA}, false, 0, 6, (Object) null).get(0));
                        if (!e2.contains(Integer.valueOf(parseInt)) && StringsKt.startsWith$default(str2, String.valueOf(parseInt), false, 2, (Object) null)) {
                            ULog.f6446a.a("ContactHelper", "getGeo array  countryCode :" + parseInt);
                            String d3 = d(Marker.ANY_NON_NULL_MARKER + str2);
                            if (d3.length() > 0) {
                                return d3;
                            }
                        }
                    }
                    Result.m20constructorimpl(Unit.INSTANCE);
                    return "";
                }
            } while (!b.isValidNumber(phoneNumber));
            String descriptionForNumber3 = e.getDescriptionForNumber(phoneNumber, GlobalExtKt.n(ControlUtils.f7858a.y()));
            Intrinsics.checkNotNullExpressionValue(descriptionForNumber3, "getDescriptionForNumber(...)");
            return descriptionForNumber3;
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th3));
        }
    }

    public final List e() {
        ArrayList arrayList = new ArrayList();
        if (ContextCompat.checkSelfPermission(GlobalExtKt.f(), "android.permission.READ_PHONE_STATE") == 0) {
            Object systemService = GlobalExtKt.f().getSystemService("telephony_subscription_service");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.SubscriptionManager");
            List<SubscriptionInfo> activeSubscriptionInfoList = ((SubscriptionManager) systemService).getActiveSubscriptionInfoList();
            Intrinsics.checkNotNullExpressionValue(activeSubscriptionInfoList, "getActiveSubscriptionInfoList(...)");
            for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                String[] stringArray = GlobalExtKt.f().getResources().getStringArray(R.array.CountryCodes);
                Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
                for (String str : stringArray) {
                    Intrinsics.checkNotNull(str);
                    Object obj = StringsKt.split$default((CharSequence) str, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA}, false, 0, 6, (Object) null).get(1);
                    String countryIso = subscriptionInfo.getCountryIso();
                    Intrinsics.checkNotNullExpressionValue(countryIso, "getCountryIso(...)");
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                    String upperCase = countryIso.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    if (Intrinsics.areEqual(obj, (Object) upperCase)) {
                        int parseInt = Integer.parseInt((String) StringsKt.split$default((CharSequence) str, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA}, false, 0, 6, (Object) null).get(0));
                        arrayList.add(Integer.valueOf(parseInt));
                        ILog.i("ContactHelper", "getSimCardsCountryCode " + subscriptionInfo.getCountryIso() + " | countryCode:" + parseInt);
                    }
                }
            }
        }
        arrayList.add(Integer.valueOf(c));
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x021b, code lost:
        return r10;
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01fa A[Catch:{ all -> 0x004d, all -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01ff A[Catch:{ all -> 0x004d, all -> 0x0069 }, LOOP:0: B:56:0x01ff->B:61:0x0216, LOOP_START, PHI: r10 
      PHI: (r10v2 java.lang.String) = (r10v0 java.lang.String), (r10v3 java.lang.String) binds: [B:55:0x01fd, B:61:0x0216] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String f(java.lang.String r19) {
        /*
            r18 = this;
            r1 = r18
            r8 = r19
            monitor-enter(r18)
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ all -> 0x0069 }
            java.lang.String r2 = "ContactHelper"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r3.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.String r4 = "queryContacts phoneNum:"
            r3.append(r4)     // Catch:{ all -> 0x0069 }
            r3.append(r8)     // Catch:{ all -> 0x0069 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0069 }
            r0.a(r2, r3)     // Catch:{ all -> 0x0069 }
            com.upuphone.xr.sapp.utils.OSHelper r0 = com.upuphone.xr.sapp.utils.OSHelper.f7904a     // Catch:{ all -> 0x0069 }
            java.lang.String r2 = "android.permission.READ_CONTACTS"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ all -> 0x0069 }
            boolean r0 = r0.c(r2)     // Catch:{ all -> 0x0069 }
            if (r0 != 0) goto L_0x002d
            monitor-exit(r18)
            return r8
        L_0x002d:
            java.lang.String r0 = "display_name"
            java.lang.String r2 = "data1"
            java.lang.String[] r9 = new java.lang.String[]{r0, r2}     // Catch:{ all -> 0x0069 }
            int r2 = c     // Catch:{ all -> 0x0069 }
            r10 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x004d }
            com.google.i18n.phonenumbers.PhoneNumberUtil r0 = b     // Catch:{ all -> 0x004d }
            com.google.i18n.phonenumbers.Phonenumber$PhoneNumber r3 = r0.parse(r8, r10)     // Catch:{ all -> 0x004d }
            boolean r0 = r0.isValidNumber(r3)     // Catch:{ all -> 0x004d }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x004d }
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)     // Catch:{ all -> 0x004d }
            goto L_0x0058
        L_0x004d:
            r0 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ all -> 0x0069 }
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch:{ all -> 0x0069 }
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)     // Catch:{ all -> 0x0069 }
        L_0x0058:
            boolean r0 = kotlin.Result.m27isSuccessimpl(r0)     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x006c
            com.google.i18n.phonenumbers.PhoneNumberUtil r2 = b     // Catch:{ all -> 0x0069 }
            com.google.i18n.phonenumbers.Phonenumber$PhoneNumber r2 = r2.parse(r8, r10)     // Catch:{ all -> 0x0069 }
            int r2 = r2.getCountryCode()     // Catch:{ all -> 0x0069 }
            goto L_0x006c
        L_0x0069:
            r0 = move-exception
            goto L_0x021c
        L_0x006c:
            r3 = 2
            if (r0 == 0) goto L_0x007d
            com.google.i18n.phonenumbers.PhoneNumberUtil r4 = b     // Catch:{ all -> 0x0069 }
            com.google.i18n.phonenumbers.Phonenumber$PhoneNumber r5 = r4.parse(r8, r10)     // Catch:{ all -> 0x0069 }
            com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberFormat r6 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL     // Catch:{ all -> 0x0069 }
            java.lang.String r4 = r4.format(r5, r6)     // Catch:{ all -> 0x0069 }
        L_0x007b:
            r7 = r4
            goto L_0x0082
        L_0x007d:
            java.lang.String r4 = b(r1, r8, r10, r3, r10)     // Catch:{ all -> 0x0069 }
            goto L_0x007b
        L_0x0082:
            if (r0 == 0) goto L_0x00a3
            com.google.i18n.phonenumbers.PhoneNumberUtil r0 = b     // Catch:{ all -> 0x0069 }
            com.google.i18n.phonenumbers.Phonenumber$PhoneNumber r4 = r0.parse(r8, r10)     // Catch:{ all -> 0x0069 }
            com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberFormat r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.RFC3966     // Catch:{ all -> 0x0069 }
            java.lang.String r11 = r0.format(r4, r5)     // Catch:{ all -> 0x0069 }
            java.lang.String r0 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)     // Catch:{ all -> 0x0069 }
            java.lang.String r12 = "tel:"
            java.lang.String r13 = ""
            r15 = 4
            r16 = 0
            r14 = 0
            java.lang.String r0 = kotlin.text.StringsKt.replace$default((java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (boolean) r14, (int) r15, (java.lang.Object) r16)     // Catch:{ all -> 0x0069 }
            goto L_0x00a9
        L_0x00a3:
            java.lang.String r0 = "-"
            java.lang.String r0 = r1.a(r8, r0)     // Catch:{ all -> 0x0069 }
        L_0x00a9:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ all -> 0x0069 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r4.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.String r5 = "+"
            r4.append(r5)     // Catch:{ all -> 0x0069 }
            r4.append(r2)     // Catch:{ all -> 0x0069 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0069 }
            r5 = 0
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r7, (java.lang.CharSequence) r4, (boolean) r5, (int) r3, (java.lang.Object) r10)     // Catch:{ all -> 0x0069 }
            if (r4 == 0) goto L_0x00e7
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r4.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.String r6 = "+"
            r4.append(r6)     // Catch:{ all -> 0x0069 }
            r4.append(r2)     // Catch:{ all -> 0x0069 }
            java.lang.String r6 = " "
            r4.append(r6)     // Catch:{ all -> 0x0069 }
            java.lang.String r12 = r4.toString()     // Catch:{ all -> 0x0069 }
            java.lang.String r13 = ""
            r15 = 4
            r16 = 0
            r14 = 0
            r11 = r7
            java.lang.String r4 = kotlin.text.StringsKt.replace$default((java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (boolean) r14, (int) r15, (java.lang.Object) r16)     // Catch:{ all -> 0x0069 }
            r6 = r4
            goto L_0x00e8
        L_0x00e7:
            r6 = r7
        L_0x00e8:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r4.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.String r11 = "+"
            r4.append(r11)     // Catch:{ all -> 0x0069 }
            r4.append(r2)     // Catch:{ all -> 0x0069 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0069 }
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r0, (java.lang.CharSequence) r4, (boolean) r5, (int) r3, (java.lang.Object) r10)     // Catch:{ all -> 0x0069 }
            if (r4 == 0) goto L_0x0122
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r4.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.String r11 = "+"
            r4.append(r11)     // Catch:{ all -> 0x0069 }
            r4.append(r2)     // Catch:{ all -> 0x0069 }
            java.lang.String r11 = "-"
            r4.append(r11)     // Catch:{ all -> 0x0069 }
            java.lang.String r12 = r4.toString()     // Catch:{ all -> 0x0069 }
            java.lang.String r13 = ""
            r15 = 4
            r16 = 0
            r14 = 0
            r11 = r0
            java.lang.String r4 = kotlin.text.StringsKt.replace$default((java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (boolean) r14, (int) r15, (java.lang.Object) r16)     // Catch:{ all -> 0x0069 }
            r11 = r4
            goto L_0x0123
        L_0x0122:
            r11 = r0
        L_0x0123:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r4.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.String r12 = "+"
            r4.append(r12)     // Catch:{ all -> 0x0069 }
            r4.append(r2)     // Catch:{ all -> 0x0069 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0069 }
            boolean r4 = kotlin.text.StringsKt.startsWith$default(r8, r4, r5, r3, r10)     // Catch:{ all -> 0x0069 }
            if (r4 == 0) goto L_0x015c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r3.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.String r4 = "+"
            r3.append(r4)     // Catch:{ all -> 0x0069 }
            r3.append(r2)     // Catch:{ all -> 0x0069 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0069 }
            java.lang.String r4 = ""
            r12 = 4
            r13 = 0
            r5 = 0
            r2 = r19
            r14 = r6
            r6 = r12
            r12 = r7
            r7 = r13
            java.lang.String r2 = kotlin.text.StringsKt.replace$default((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (boolean) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0069 }
        L_0x015a:
            r7 = r2
            goto L_0x0177
        L_0x015c:
            r14 = r6
            r12 = r7
            java.lang.String r4 = "phoneCountryCode"
            boolean r3 = kotlin.text.StringsKt.startsWith$default(r8, r4, r5, r3, r10)     // Catch:{ all -> 0x0069 }
            if (r3 == 0) goto L_0x0176
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0069 }
            java.lang.String r4 = ""
            r6 = 4
            r7 = 0
            r5 = 0
            r2 = r19
            java.lang.String r2 = kotlin.text.StringsKt.replace$default((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (boolean) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0069 }
            goto L_0x015a
        L_0x0176:
            r7 = r8
        L_0x0177:
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ all -> 0x0069 }
            java.lang.String r3 = "ContactHelper"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r4.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.String r5 = "queryContacts phone1:"
            r4.append(r5)     // Catch:{ all -> 0x0069 }
            r4.append(r12)     // Catch:{ all -> 0x0069 }
            java.lang.String r5 = " phone2:"
            r4.append(r5)     // Catch:{ all -> 0x0069 }
            r4.append(r0)     // Catch:{ all -> 0x0069 }
            java.lang.String r5 = " phone3:"
            r4.append(r5)     // Catch:{ all -> 0x0069 }
            r4.append(r14)     // Catch:{ all -> 0x0069 }
            java.lang.String r5 = " phone4:"
            r4.append(r5)     // Catch:{ all -> 0x0069 }
            r4.append(r11)     // Catch:{ all -> 0x0069 }
            java.lang.String r5 = " phone5:"
            r4.append(r5)     // Catch:{ all -> 0x0069 }
            r4.append(r7)     // Catch:{ all -> 0x0069 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0069 }
            r2.a(r3, r4)     // Catch:{ all -> 0x0069 }
            com.upuphone.xr.sapp.MainApplication$Companion r2 = com.upuphone.xr.sapp.MainApplication.k     // Catch:{ all -> 0x0069 }
            com.upuphone.xr.sapp.MainApplication r2 = r2.f()     // Catch:{ all -> 0x0069 }
            android.content.ContentResolver r13 = r2.getContentResolver()     // Catch:{ all -> 0x0069 }
            android.net.Uri r15 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI     // Catch:{ all -> 0x01e9 }
            java.lang.String r16 = "data1 in(?,?,?,?,?,?,?)"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e9 }
            r2.<init>()     // Catch:{ all -> 0x01e9 }
            java.lang.String r3 = "0"
            r2.append(r3)     // Catch:{ all -> 0x01e9 }
            r2.append(r7)     // Catch:{ all -> 0x01e9 }
            java.lang.String r17 = r2.toString()     // Catch:{ all -> 0x01e9 }
            r2 = r19
            r3 = r12
            r4 = r0
            r5 = r14
            r6 = r11
            r8 = r17
            java.lang.String[] r7 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8}     // Catch:{ all -> 0x01e9 }
            r8 = 0
            r3 = r13
            r4 = r15
            r5 = r9
            r6 = r16
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x01e9 }
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)     // Catch:{ all -> 0x01e9 }
            goto L_0x01f4
        L_0x01e9:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0069 }
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch:{ all -> 0x0069 }
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)     // Catch:{ all -> 0x0069 }
        L_0x01f4:
            boolean r2 = kotlin.Result.m26isFailureimpl(r0)     // Catch:{ all -> 0x0069 }
            if (r2 == 0) goto L_0x01fb
            r0 = r10
        L_0x01fb:
            android.database.Cursor r0 = (android.database.Cursor) r0     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x021a
        L_0x01ff:
            boolean r2 = r0.moveToNext()     // Catch:{ all -> 0x0069 }
            if (r2 == 0) goto L_0x021a
            java.lang.String r2 = "display_name"
            int r2 = r0.getColumnIndex(r2)     // Catch:{ all -> 0x0069 }
            java.lang.String r10 = r0.getString(r2)     // Catch:{ all -> 0x0069 }
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0069 }
            if (r2 != 0) goto L_0x0216
            goto L_0x021a
        L_0x0216:
            r0.close()     // Catch:{ all -> 0x0069 }
            goto L_0x01ff
        L_0x021a:
            monitor-exit(r18)
            return r10
        L_0x021c:
            monitor-exit(r18)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.ContactHelper.f(java.lang.String):java.lang.String");
    }
}
