package com.upuphone.xr.sapp.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import com.honey.account.h8.aa;
import com.honey.account.h8.ba;
import com.honey.account.h8.ca;
import com.honey.account.h8.z9;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentUserAgreementBinding;
import com.upuphone.xr.sapp.utils.BuglyManager;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.BooleanUtils;
import org.xml.sax.XMLReader;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J+\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/UserAgreementFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "I0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Ljava/io/InputStream;", "inputStream", "", "M0", "(Ljava/io/InputStream;)[B", "L0", "", "type", "E0", "(Ljava/lang/String;)Ljava/lang/String;", "F0", "(Ljava/lang/String;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentUserAgreementBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentUserAgreementBinding;", "binding", "k", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nUserAgreementFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserAgreementFragment.kt\ncom/upuphone/xr/sapp/fragment/UserAgreementFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,143:1\n1#2:144\n*E\n"})
public final class UserAgreementFragment extends BaseFragment {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);
    public FragmentUserAgreementBinding j;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/UserAgreementFragment$Companion;", "", "()V", "PERMISSION_CHECK", "", "PERMISSION_CHECK_NO", "TAG", "TYPE_FLYME_PRIVACY_POLICY", "TYPE_FLYME_USER_AGREEMENT", "TYPE_NAME", "TYPE_SUPERAPP_PRIVACY_POLICY", "TYPE_SUPERAPP_USER_PROTOCOL", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final Drawable G0(UserAgreementFragment userAgreementFragment, String str) {
        Intrinsics.checkNotNullParameter(userAgreementFragment, "this$0");
        Drawable drawable = userAgreementFragment.getResources().getDrawable(R.mipmap.ic_sapp_launcher);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        return drawable;
    }

    public static final void H0(boolean z, String str, Editable editable, XMLReader xMLReader) {
    }

    private final void I0() {
        FragmentUserAgreementBinding fragmentUserAgreementBinding = this.j;
        FragmentUserAgreementBinding fragmentUserAgreementBinding2 = null;
        if (fragmentUserAgreementBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentUserAgreementBinding = null;
        }
        fragmentUserAgreementBinding.b.setOnClickListener(new ba(this));
        FragmentUserAgreementBinding fragmentUserAgreementBinding3 = this.j;
        if (fragmentUserAgreementBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentUserAgreementBinding2 = fragmentUserAgreementBinding3;
        }
        fragmentUserAgreementBinding2.c.setOnClickListener(new ca(this));
    }

    public static final void J0(UserAgreementFragment userAgreementFragment, View view) {
        Intrinsics.checkNotNullParameter(userAgreementFragment, "this$0");
        StaticMethodUtilsKt.q(userAgreementFragment);
    }

    public static final void K0(UserAgreementFragment userAgreementFragment, View view) {
        Intrinsics.checkNotNullParameter(userAgreementFragment, "this$0");
        DataStoreUtils.e.a().o("sp_user_agreement_state", Boolean.TRUE);
        BuglyManager.f7849a.n();
        StaticMethodUtilsKt.q(userAgreementFragment);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
        r5 = r5.getAssets();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String E0(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = "privacy_policy.html"
            if (r5 == 0) goto L_0x0089
            int r2 = r5.hashCode()
            java.lang.String r3 = "binding"
            switch(r2) {
                case -1037664246: goto L_0x006b;
                case 1034372738: goto L_0x004e;
                case 1970111357: goto L_0x0031;
                case 2102289619: goto L_0x0010;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0089
        L_0x0010:
            java.lang.String r2 = "SUPERAPP_USER_PROTOCOL"
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x001a
            goto L_0x0089
        L_0x001a:
            com.upuphone.xr.sapp.databinding.FragmentUserAgreementBinding r5 = r4.j
            if (r5 != 0) goto L_0x0022
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r5 = r0
        L_0x0022:
            android.widget.TextView r5 = r5.b
            int r1 = com.upuphone.xr.sapp.R.string.superapp_user_protocol
            java.lang.CharSequence r1 = r4.getText(r1)
            r5.setText(r1)
            java.lang.String r1 = "user_protocol.html"
            goto L_0x0089
        L_0x0031:
            java.lang.String r2 = "FLYME_PRIVACY_POLICY"
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x003a
            goto L_0x0089
        L_0x003a:
            com.upuphone.xr.sapp.databinding.FragmentUserAgreementBinding r5 = r4.j
            if (r5 != 0) goto L_0x0042
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r5 = r0
        L_0x0042:
            android.widget.TextView r5 = r5.b
            int r2 = com.upuphone.xr.sapp.R.string.flyme_privacy_policy
            java.lang.CharSequence r2 = r4.getText(r2)
            r5.setText(r2)
            goto L_0x0089
        L_0x004e:
            java.lang.String r2 = "SUPERAPP_PRIVACY_POLICY"
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x0057
            goto L_0x0089
        L_0x0057:
            com.upuphone.xr.sapp.databinding.FragmentUserAgreementBinding r5 = r4.j
            if (r5 != 0) goto L_0x005f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r5 = r0
        L_0x005f:
            android.widget.TextView r5 = r5.b
            int r2 = com.upuphone.xr.sapp.R.string.superapp_privacy_policy
            java.lang.CharSequence r2 = r4.getText(r2)
            r5.setText(r2)
            goto L_0x0089
        L_0x006b:
            java.lang.String r2 = "FLYME_USER_AGREEMENT"
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x0074
            goto L_0x0089
        L_0x0074:
            com.upuphone.xr.sapp.databinding.FragmentUserAgreementBinding r5 = r4.j
            if (r5 != 0) goto L_0x007c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r5 = r0
        L_0x007c:
            android.widget.TextView r5 = r5.b
            int r1 = com.upuphone.xr.sapp.R.string.flyme_user_agreement
            java.lang.CharSequence r1 = r4.getText(r1)
            r5.setText(r1)
            java.lang.String r1 = "account_privacy_policy.html"
        L_0x0089:
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()
            if (r5 == 0) goto L_0x009a
            android.content.res.AssetManager r5 = r5.getAssets()
            if (r5 == 0) goto L_0x009a
            java.io.InputStream r5 = r5.open(r1)
            goto L_0x009b
        L_0x009a:
            r5 = r0
        L_0x009b:
            if (r5 == 0) goto L_0x00a2
            byte[] r4 = r4.M0(r5)
            goto L_0x00a3
        L_0x00a2:
            r4 = r0
        L_0x00a3:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r5.read(r4)
            if (r4 == 0) goto L_0x00b2
            java.lang.String r0 = new java.lang.String
            java.nio.charset.Charset r5 = kotlin.text.Charsets.UTF_8
            r0.<init>(r4, r5)
        L_0x00b2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.UserAgreementFragment.E0(java.lang.String):java.lang.String");
    }

    public final void F0(String str) {
        String E0 = E0(str);
        FragmentUserAgreementBinding fragmentUserAgreementBinding = this.j;
        Spanned spanned = null;
        if (fragmentUserAgreementBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentUserAgreementBinding = null;
        }
        TextView textView = fragmentUserAgreementBinding.e;
        if (E0 != null) {
            spanned = HtmlCompat.a(E0, 63, new z9(this), new aa());
        }
        textView.setText(spanned);
    }

    public final void L0() {
        Bundle arguments = getArguments();
        if (StringsKt.equals$default(arguments != null ? arguments.getString("permission_check") : null, BooleanUtils.NO, false, 2, (Object) null)) {
            j0(false);
        }
    }

    public final byte[] M0(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                return byteArray;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentUserAgreementBinding c = FragmentUserAgreementBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        ConstraintLayout b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        I0();
        Bundle arguments = getArguments();
        F0(arguments != null ? arguments.getString("USER_AGREEMENT_TYPE") : null);
        L0();
    }
}
