package flyme.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import com.meizu.common.util.ReflectUtils;
import flyme.support.v7.appcompat.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public class PermissionDialogBuilder {
    private static final String PREMISSION_INTERNET = "android.permission.INTERNET";
    private static final String PREMISSION_INTERNET_ACCESS = "android.permission.ACCESS_NETWORK_STATE";
    private static final String PREMISSION_INTERNET_CHANGE = "android.permission.CHANGE_NETWORK_STATE";
    private static final String PREMISSION_INTERNET_GROUP = "meizu.permission-group.NETWORK";
    public static final boolean sOldPermissionDialog = false;
    private static final ArrayList<String> sTabletPermissionFilterList;
    private List<Pair<String, String>> mAdditionalGroups;
    private String mAppName;
    /* access modifiers changed from: private */
    public OnPermissionClickListener mCallBack;
    private boolean mCancelable;
    private final Context mContext;
    private CharSequence mCsReminder;
    private String mCustomNegativeButtonText;
    private String mCustomPositiveButtonText;
    private String mCustomPrivacyPolicyName;
    private String mCustomUserAgreementName;
    private boolean mHaveSecondaryConfirmation;
    private boolean mIsDark;
    private boolean mIsIntl;
    private final boolean mIsTablet;
    private String mMessage;
    private int mPermissionBuilderType;
    private int mPermissionInternetType;
    private String[] mPermissionReason;
    private String[] mPermissions;
    /* access modifiers changed from: private */
    public View.OnClickListener mPrivacyPolicyListener;
    private String mReminder;
    private boolean mShowAlmostDenyBtn;
    private CharSequence mTerms;
    private int mTheme;
    /* access modifiers changed from: private */
    public View.OnClickListener mUserAgreementListener;

    public interface OnPermissionClickListener {
        void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z2) {
        }

        void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z2, Map<String, Boolean> map) {
        }
    }

    public static class PermissionDialog extends AlertDialog {
        private OnPermissionClickListener mCallBack;

        private boolean isPerformanceTest() {
            try {
                return ((Boolean) ReflectUtils.from("android.os.SystemProperties").method("getBoolean", String.class, Boolean.TYPE).invoke((Object) null, "debug.perf.applunch", Boolean.FALSE)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        private boolean isProductInternational() {
            try {
                return ((Boolean) ReflectUtils.from("android.os.BuildExt").method("isProductInternational", new Class[0]).invoke((Object) null, new Object[0])).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        private boolean isShopDemo() {
            try {
                return ((Boolean) ReflectUtils.from("android.os.BuildExt").method("isShopDemoVersion", new Class[0]).invoke((Object) null, new Object[0])).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        public void show() {
            if (isPerformanceTest() || isShopDemo()) {
                OnPermissionClickListener onPermissionClickListener = this.mCallBack;
                if (onPermissionClickListener != null) {
                    onPermissionClickListener.onPermissionClick(this, false, true);
                    return;
                }
                return;
            }
            super.show();
        }

        private PermissionDialog(@NonNull Context context, int i, OnPermissionClickListener onPermissionClickListener) {
            super(context, i);
            this.mCallBack = onPermissionClickListener;
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        sTabletPermissionFilterList = arrayList;
        arrayList.add("android.permission.CALL_PHONE");
        arrayList.add("android.permission.READ_CONTACTS");
        arrayList.add("android.permission.READ_SMS");
        arrayList.add("android.permission.WRITE_CONTACTS");
        arrayList.add("android.permission.SEND_SMS");
        arrayList.add("android.permission.RECEIVE_SMS");
        arrayList.add("android.permission.READ_CALL_LOG");
        arrayList.add("android.permission.RECORD_AUDIO");
    }

    public PermissionDialogBuilder(Context context) {
        this(context, AlertDialog.resolveDialogTheme(context, 0));
    }

    private ArrayList<Integer> buildInternetPermission(String[] strArr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= strArr.length) {
                break;
            } else if ("meizu.permission-group.NETWORK".equals(strArr[i])) {
                arrayList.clear();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if ("meizu.permission-group.NETWORK".equals(strArr[i2]) || PREMISSION_INTERNET.equals(strArr[i2]) || PREMISSION_INTERNET_CHANGE.equals(strArr[i2]) || PREMISSION_INTERNET_ACCESS.equals(strArr[i2])) {
                        arrayList.add(Integer.valueOf(i2));
                    }
                }
            } else {
                if (PREMISSION_INTERNET.equals(strArr[i])) {
                    arrayList.add(Integer.valueOf(i));
                }
                i++;
            }
        }
        if (arrayList.size() <= 0) {
            setPermissionInternetType(2);
        } else if (strArr.length - arrayList.size() > 0) {
            setPermissionInternetType(0);
        } else {
            setPermissionInternetType(1);
        }
        return arrayList;
    }

    private void filterPermission() {
        if (this.mIsTablet) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            while (true) {
                String[] strArr = this.mPermissions;
                if (i >= strArr.length) {
                    break;
                }
                String str = strArr[i];
                if (!sTabletPermissionFilterList.contains(str)) {
                    arrayList.add(str);
                    String[] strArr2 = this.mPermissionReason;
                    if (strArr2 != null) {
                        arrayList2.add(strArr2[i]);
                    }
                }
                i++;
            }
            this.mPermissions = (String[]) arrayList.toArray(new String[0]);
            if (this.mPermissionReason != null) {
                this.mPermissionReason = (String[]) arrayList2.toArray(new String[0]);
            }
        }
    }

    private static boolean isZh(String str) {
        return Pattern.compile("[\\u4E00-\\u9FA5]+").matcher(str).find();
    }

    /* access modifiers changed from: private */
    public void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z2, Map<String, Boolean> map) {
        OnPermissionClickListener onPermissionClickListener = this.mCallBack;
        if (onPermissionClickListener != null) {
            if (this.mIsIntl) {
                onPermissionClickListener.onPermissionClick(dialogInterface, z, z2, map);
            } else {
                onPermissionClickListener.onPermissionClick(dialogInterface, z, z2);
            }
        }
    }

    private String[] rebuildPermissions(String[] strArr, ArrayList<Integer> arrayList) {
        ArrayList arrayList2 = new ArrayList(Arrays.asList(strArr));
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList3.add((String) arrayList2.get(arrayList.get(i).intValue()));
        }
        for (int i2 = 0; i2 < arrayList3.size(); i2++) {
            arrayList2.remove(arrayList3.get(i2));
        }
        return (String[]) arrayList2.toArray(new String[0]);
    }

    private boolean showTermsCheckBox() {
        return ("en".equals(Locale.getDefault().getLanguage()) || "zh".equals(Locale.getDefault().getLanguage())) && !TextUtils.isEmpty(this.mTerms);
    }

    public PermissionDialogBuilder addAdditionalGroup(String str, String str2) {
        if (this.mAdditionalGroups == null) {
            this.mAdditionalGroups = new ArrayList();
        }
        this.mAdditionalGroups.add(Pair.create(str, str2));
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        r1 = r10.mAdditionalGroups;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public flyme.support.v7.app.AlertDialog create() {
        /*
            r10 = this;
            android.content.Context r0 = r10.mContext
            int r1 = flyme.support.v7.appcompat.R.string.mz_permission_use_info
            java.lang.String r0 = r0.getString(r1)
            int r1 = r10.mPermissionBuilderType
            if (r1 != 0) goto L_0x001d
            java.lang.String r1 = r10.mAppName
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0015
            goto L_0x001d
        L_0x0015:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "appName can't be null"
            r10.<init>(r0)
            throw r10
        L_0x001d:
            java.lang.String[] r1 = r10.mPermissions
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x002d
            int r4 = r1.length
            if (r4 > 0) goto L_0x0037
            int r1 = r1.length
            if (r1 != 0) goto L_0x002d
            int r1 = r10.mPermissionInternetType
            if (r1 == r3) goto L_0x0037
        L_0x002d:
            java.util.List<android.util.Pair<java.lang.String, java.lang.String>> r1 = r10.mAdditionalGroups
            if (r1 == 0) goto L_0x0039
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0039
        L_0x0037:
            r1 = r3
            goto L_0x003a
        L_0x0039:
            r1 = r2
        L_0x003a:
            boolean r4 = sOldPermissionDialog
            if (r4 == 0) goto L_0x004c
            if (r1 != 0) goto L_0x004b
            java.lang.String r1 = r10.mMessage
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r1 = r2
            goto L_0x004c
        L_0x004b:
            r1 = r3
        L_0x004c:
            java.lang.CharSequence r5 = r10.mTerms
            if (r5 != 0) goto L_0x005b
            android.view.View$OnClickListener r5 = r10.mPrivacyPolicyListener
            if (r5 != 0) goto L_0x005b
            android.view.View$OnClickListener r5 = r10.mUserAgreementListener
            if (r5 == 0) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r5 = r2
            goto L_0x005c
        L_0x005b:
            r5 = r3
        L_0x005c:
            if (r1 != 0) goto L_0x0069
            if (r5 == 0) goto L_0x0061
            goto L_0x0069
        L_0x0061:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "[permissions], [additional groups] and [terms] both null"
            r10.<init>(r0)
            throw r10
        L_0x0069:
            java.lang.String[] r5 = r10.mPermissions
            if (r5 == 0) goto L_0x0089
            java.lang.String[] r6 = r10.mPermissionReason
            if (r6 == 0) goto L_0x0081
            int r6 = r6.length
            int r5 = r5.length
            if (r6 != r5) goto L_0x0079
            r10.filterPermission()
            goto L_0x0089
        L_0x0079:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "permissionReason.length must equal permissions.length"
            r10.<init>(r0)
            throw r10
        L_0x0081:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "permissionReason can't be null"
            r10.<init>(r0)
            throw r10
        L_0x0089:
            r5 = r4 ^ 1
            flyme.support.v7.view.PermissionDialogView r6 = new flyme.support.v7.view.PermissionDialogView
            android.content.Context r7 = r10.mContext
            r6.<init>(r7)
            flyme.support.v7.view.PermissionDialogView$Builder r7 = new flyme.support.v7.view.PermissionDialogView$Builder
            r7.<init>()
            int r8 = r10.mPermissionBuilderType
            if (r8 != 0) goto L_0x009e
            java.lang.String r8 = r10.mAppName
            goto L_0x009f
        L_0x009e:
            r8 = r0
        L_0x009f:
            flyme.support.v7.view.PermissionDialogView$Builder r7 = r7.setAppName(r8)
            boolean r8 = r10.mShowAlmostDenyBtn
            flyme.support.v7.view.PermissionDialogView$Builder r7 = r7.setShowAlmostDenyBtn(r8)
            java.lang.String[] r8 = r10.mPermissions
            java.lang.String[] r9 = r10.mPermissionReason
            flyme.support.v7.view.PermissionDialogView$Builder r7 = r7.setPermission(r8, r9)
            java.util.List<android.util.Pair<java.lang.String, java.lang.String>> r8 = r10.mAdditionalGroups
            flyme.support.v7.view.PermissionDialogView$Builder r7 = r7.setAdditionalGroups(r8)
            java.lang.String r8 = r10.mMessage
            flyme.support.v7.view.PermissionDialogView$Builder r7 = r7.setMessage(r8)
            java.lang.String r8 = r10.mReminder
            flyme.support.v7.view.PermissionDialogView$Builder r7 = r7.setReminder(r8)
            java.lang.CharSequence r8 = r10.mCsReminder
            flyme.support.v7.view.PermissionDialogView$Builder r7 = r7.setCsReminder(r8)
            boolean r8 = r10.mIsDark
            flyme.support.v7.view.PermissionDialogView$Builder r7 = r7.setDark(r8)
            boolean r8 = r10.mIsIntl
            flyme.support.v7.view.PermissionDialogView$Builder r7 = r7.isIntl(r8)
            flyme.support.v7.view.PermissionDialogView$Builder r4 = r7.setShowTitle(r4)
            r4.build(r6)
            flyme.support.v7.app.AlertDialog$Builder r4 = new flyme.support.v7.app.AlertDialog$Builder
            android.content.Context r7 = r10.mContext
            int r8 = r10.mTheme
            r4.<init>(r7, r8)
            flyme.support.v7.app.AlertDialog$Builder r4 = r4.setView((android.view.View) r6)
            boolean r7 = r10.mCancelable
            flyme.support.v7.app.AlertDialog$Builder r4 = r4.setCancelable(r7)
            flyme.support.v7.app.PermissionDialogBuilder$1 r7 = new flyme.support.v7.app.PermissionDialogBuilder$1
            r7.<init>(r6)
            flyme.support.v7.app.AlertDialog$Builder r4 = r4.setOnCancelListener(r7)
            java.lang.String r7 = r10.mCustomPositiveButtonText
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0103
            java.lang.String r7 = r10.mCustomPositiveButtonText
            goto L_0x011d
        L_0x0103:
            int r7 = r10.mPermissionBuilderType
            if (r7 != r3) goto L_0x0114
            android.content.Context r7 = r10.mContext
            android.content.res.Resources r7 = r7.getResources()
            int r8 = flyme.support.v7.appcompat.R.string.mz_permission_i_know
        L_0x010f:
            java.lang.String r7 = r7.getString(r8)
            goto L_0x011d
        L_0x0114:
            android.content.Context r7 = r10.mContext
            android.content.res.Resources r7 = r7.getResources()
            int r8 = flyme.support.v7.appcompat.R.string.mz_permission_agree
            goto L_0x010f
        L_0x011d:
            flyme.support.v7.app.PermissionDialogBuilder$2 r8 = new flyme.support.v7.app.PermissionDialogBuilder$2
            r8.<init>(r6)
            r4.setPositiveButton((java.lang.CharSequence) r7, (android.content.DialogInterface.OnClickListener) r8)
            int r7 = r10.mPermissionBuilderType
            if (r7 == r3) goto L_0x0155
            java.lang.String r8 = r10.mCustomNegativeButtonText
            if (r8 == 0) goto L_0x012e
            goto L_0x0149
        L_0x012e:
            boolean r8 = r10.mHaveSecondaryConfirmation
            if (r8 != 0) goto L_0x0140
            r8 = 3
            if (r7 != r8) goto L_0x0136
            goto L_0x0140
        L_0x0136:
            android.content.Context r7 = r10.mContext
            int r8 = flyme.support.v7.appcompat.R.string.mz_reject
            java.lang.String r7 = r7.getString(r8)
        L_0x013e:
            r8 = r7
            goto L_0x0149
        L_0x0140:
            android.content.Context r7 = r10.mContext
            int r8 = flyme.support.v7.appcompat.R.string.mz_permission_deny
            java.lang.String r7 = r7.getString(r8)
            goto L_0x013e
        L_0x0149:
            flyme.support.v7.app.PermissionDialogBuilder$3 r7 = new flyme.support.v7.app.PermissionDialogBuilder$3
            r7.<init>(r6)
            r4.setNegativeButton((java.lang.CharSequence) r8, (android.content.DialogInterface.OnClickListener) r7)
            r7 = -1
            r4.setHighLightButton(r7, r2)
        L_0x0155:
            if (r5 == 0) goto L_0x0160
            int r5 = r10.mPermissionBuilderType
            if (r5 != 0) goto L_0x015d
            java.lang.String r0 = r10.mAppName
        L_0x015d:
            r4.setTitle((java.lang.CharSequence) r0)
        L_0x0160:
            flyme.support.v7.app.PermissionDialogBuilder$4 r0 = new flyme.support.v7.app.PermissionDialogBuilder$4
            r0.<init>()
            flyme.support.v7.app.AlertDialog r0 = r4.create(r0)
            flyme.support.v7.app.PermissionDialogBuilder$PermissionDialog r0 = (flyme.support.v7.app.PermissionDialogBuilder.PermissionDialog) r0
            android.widget.CheckBox r4 = r6.getCheckBox()
            flyme.support.v7.app.PermissionDialogBuilder$5 r5 = new flyme.support.v7.app.PermissionDialogBuilder$5
            r5.<init>(r0)
            r4.setOnCheckedChangeListener(r5)
            android.widget.TextView r4 = r6.getTermsView()
            java.lang.CharSequence r5 = r10.mTerms
            if (r5 != 0) goto L_0x01c6
            flyme.support.v7.permission.TermsStringBuilder r5 = new flyme.support.v7.permission.TermsStringBuilder
            android.content.Context r6 = r10.mContext
            r5.<init>(r6)
            flyme.support.v7.permission.TermsStringBuilder r1 = r5.setHasPermission(r1)
            android.view.View$OnClickListener r5 = r10.mPrivacyPolicyListener
            if (r5 == 0) goto L_0x0190
            r5 = r3
            goto L_0x0191
        L_0x0190:
            r5 = r2
        L_0x0191:
            flyme.support.v7.permission.TermsStringBuilder r1 = r1.setPrivacyPolicy(r5)
            android.view.View$OnClickListener r5 = r10.mUserAgreementListener
            if (r5 == 0) goto L_0x019a
            goto L_0x019b
        L_0x019a:
            r3 = r2
        L_0x019b:
            flyme.support.v7.permission.TermsStringBuilder r1 = r1.setUserAgreement(r3)
            int r3 = r10.mPermissionInternetType
            flyme.support.v7.permission.TermsStringBuilder r1 = r1.setInternetPermissionType(r3)
            int r3 = r10.mPermissionBuilderType
            flyme.support.v7.permission.TermsStringBuilder r1 = r1.setBuilderType(r3)
            java.lang.String r3 = r10.mCustomPrivacyPolicyName
            flyme.support.v7.permission.TermsStringBuilder r1 = r1.setPrivacyPolicyName(r3)
            java.lang.String r3 = r10.mCustomUserAgreementName
            flyme.support.v7.permission.TermsStringBuilder r1 = r1.setUserAgreementName(r3)
            flyme.support.v7.app.PermissionDialogBuilder$6 r3 = new flyme.support.v7.app.PermissionDialogBuilder$6
            r3.<init>(r4)
            flyme.support.v7.permission.TermsStringBuilder r1 = r1.setOnClickListener(r3)
            android.text.SpannableString r1 = r1.create()
            r10.mTerms = r1
        L_0x01c6:
            java.lang.CharSequence r1 = r10.mTerms
            r4.setText(r1)
            android.view.ViewTreeObserver r1 = r4.getViewTreeObserver()
            flyme.support.v7.app.PermissionDialogBuilder$7 r3 = new flyme.support.v7.app.PermissionDialogBuilder$7
            r3.<init>(r4)
            r1.addOnGlobalLayoutListener(r3)
            android.text.method.MovementMethod r10 = android.text.method.LinkMovementMethod.getInstance()
            r4.setMovementMethod(r10)
            r4.setHighlightColor(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.app.PermissionDialogBuilder.create():flyme.support.v7.app.AlertDialog");
    }

    public PermissionDialogBuilder isIntl(boolean z) {
        this.mIsIntl = z;
        return this;
    }

    public boolean isTablet(Context context) {
        return context.getResources().getBoolean(R.bool.isTablet);
    }

    public PermissionDialogBuilder setAppName(String str) {
        this.mAppName = str;
        return this;
    }

    public PermissionDialogBuilder setBuilderDialogType(int i) {
        this.mPermissionBuilderType = i;
        return this;
    }

    public PermissionDialogBuilder setCancelable(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public PermissionDialogBuilder setCustomNegativeButtonText(String str) {
        this.mCustomNegativeButtonText = str;
        return this;
    }

    public PermissionDialogBuilder setCustomPositiveButtonText(String str) {
        this.mCustomPositiveButtonText = str;
        return this;
    }

    public PermissionDialogBuilder setCustomTerms(CharSequence charSequence) {
        this.mTerms = charSequence;
        return this;
    }

    public PermissionDialogBuilder setDark(boolean z) {
        if (z) {
            this.mTheme = R.style.Theme_Flyme_AppCompat_Light_Dialog_Alert_Dark;
        }
        this.mIsDark = z;
        return this;
    }

    public PermissionDialogBuilder setMessage(String str) {
        this.mMessage = str;
        return this;
    }

    public PermissionDialogBuilder setOnPermissionListener(OnPermissionClickListener onPermissionClickListener) {
        this.mCallBack = onPermissionClickListener;
        return this;
    }

    public PermissionDialogBuilder setPermission(@NonNull String[] strArr, @NonNull String[] strArr2) {
        ArrayList<Integer> buildInternetPermission = buildInternetPermission(strArr);
        if (buildInternetPermission.size() > 0) {
            this.mPermissions = rebuildPermissions(strArr, buildInternetPermission);
            this.mPermissionReason = rebuildPermissions(strArr2, buildInternetPermission);
        } else {
            this.mPermissions = strArr;
            this.mPermissionReason = strArr2;
        }
        return this;
    }

    public PermissionDialogBuilder setPermissionInternetType(int i) {
        this.mPermissionInternetType = i;
        return this;
    }

    public PermissionDialogBuilder setPrivacyPolicyName(String str) {
        this.mCustomPrivacyPolicyName = str;
        return this;
    }

    public PermissionDialogBuilder setReminder(String str) {
        this.mReminder = str;
        return this;
    }

    public PermissionDialogBuilder setSecondaryConfirmation(boolean z) {
        this.mHaveSecondaryConfirmation = z;
        return this;
    }

    public PermissionDialogBuilder setShowAlmostDenyBtn(boolean z) {
        this.mShowAlmostDenyBtn = z;
        return this;
    }

    public PermissionDialogBuilder setUserAgreementName(String str) {
        this.mCustomUserAgreementName = str;
        return this;
    }

    public AlertDialog show() {
        AlertDialog create = create();
        create.show();
        return create;
    }

    public PermissionDialogBuilder showPrivacyPolicy(View.OnClickListener onClickListener) {
        this.mPrivacyPolicyListener = onClickListener;
        return this;
    }

    public PermissionDialogBuilder showUserAgreement(View.OnClickListener onClickListener) {
        this.mUserAgreementListener = onClickListener;
        return this;
    }

    public PermissionDialogBuilder(Context context, int i) {
        this.mPrivacyPolicyListener = null;
        this.mUserAgreementListener = null;
        this.mCancelable = false;
        this.mPermissionInternetType = 0;
        this.mPermissionBuilderType = 0;
        this.mCustomPrivacyPolicyName = null;
        this.mCustomUserAgreementName = null;
        this.mCustomNegativeButtonText = null;
        this.mCustomPositiveButtonText = null;
        this.mContext = context;
        this.mTheme = i;
        this.mIsTablet = isTablet(context);
    }

    public PermissionDialogBuilder setReminder(CharSequence charSequence) {
        this.mCsReminder = charSequence;
        return this;
    }
}
