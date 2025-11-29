package sdk.meizu.account.factor.authentication.sdk.fragment.basic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.R;
import sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/adapter/ValidateListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/adapter/ValidateListAdapter$ViewHolder;", "selectorType", "Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;", "items", "", "(Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;Ljava/util/List;)V", "onSelectedListener", "Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/adapter/ValidateListAdapter$OnSelectedListener;", "getOnSelectedListener", "()Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/adapter/ValidateListAdapter$OnSelectedListener;", "setOnSelectedListener", "(Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/adapter/ValidateListAdapter$OnSelectedListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OnSelectedListener", "ViewHolder", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ValidateListAdapter extends RecyclerView.Adapter<ViewHolder> {
    @NotNull
    private final List<BasicInfoType> items;
    @Nullable
    private OnSelectedListener onSelectedListener;
    @NotNull
    private final BasicInfoType selectorType;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/adapter/ValidateListAdapter$OnSelectedListener;", "", "onSelected", "", "position", "", "type", "Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnSelectedListener {
        void onSelected(int i, @NotNull BasicInfoType basicInfoType);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/adapter/ValidateListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "descTv", "getDescTv", "titleTv", "getTitleTv", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final TextView contentTv;
        @NotNull
        private final TextView descTv;
        @NotNull
        private final TextView titleTv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.item_validate_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.titleTv = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.item_validate_content);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.contentTv = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.item_validate_desc);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.descTv = (TextView) findViewById3;
        }

        @NotNull
        public final TextView getContentTv() {
            return this.contentTv;
        }

        @NotNull
        public final TextView getDescTv() {
            return this.descTv;
        }

        @NotNull
        public final TextView getTitleTv() {
            return this.titleTv;
        }
    }

    public ValidateListAdapter(@NotNull BasicInfoType basicInfoType, @NotNull List<BasicInfoType> list) {
        Intrinsics.checkNotNullParameter(basicInfoType, "selectorType");
        Intrinsics.checkNotNullParameter(list, "items");
        this.selectorType = basicInfoType;
        this.items = list;
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(ValidateListAdapter validateListAdapter, int i, BasicInfoType basicInfoType, View view) {
        Intrinsics.checkNotNullParameter(validateListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(basicInfoType, "$type");
        OnSelectedListener onSelectedListener2 = validateListAdapter.onSelectedListener;
        if (onSelectedListener2 != null) {
            onSelectedListener2.onSelected(i, basicInfoType);
        }
    }

    public int getItemCount() {
        return this.items.size();
    }

    @Nullable
    public final OnSelectedListener getOnSelectedListener() {
        return this.onSelectedListener;
    }

    public final void setOnSelectedListener(@Nullable OnSelectedListener onSelectedListener2) {
        this.onSelectedListener = onSelectedListener2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull sdk.meizu.account.factor.authentication.sdk.fragment.basic.adapter.ValidateListAdapter.ViewHolder r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.List<sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType> r0 = r5.items
            java.lang.Object r0 = r0.get(r7)
            sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType r0 = (sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType) r0
            android.widget.TextView r1 = r6.getTitleTv()
            java.lang.String r2 = r0.getValidateType()
            int r3 = r2.hashCode()
            r4 = -827199977(0xffffffffceb1ee17, float:-1.49258534E9)
            if (r3 == r4) goto L_0x0041
            r4 = 921521722(0x36ed4e3a, float:7.072257E-6)
            if (r3 == r4) goto L_0x0035
            r4 = 1930793925(0x731593c5, float:1.1850729E31)
            if (r3 == r4) goto L_0x0029
            goto L_0x0049
        L_0x0029:
            java.lang.String r3 = "email_code_validate"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0032
            goto L_0x0049
        L_0x0032:
            int r2 = sdk.meizu.account.factor.authentication.sdk.R.string.validate_mode_email
            goto L_0x004e
        L_0x0035:
            java.lang.String r3 = "password_validate"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x003e
            goto L_0x0049
        L_0x003e:
            int r2 = sdk.meizu.account.factor.authentication.sdk.R.string.validate_mode_password
            goto L_0x004e
        L_0x0041:
            java.lang.String r3 = "phone_code_validate"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x004c
        L_0x0049:
            int r2 = sdk.meizu.account.factor.authentication.sdk.R.string.empty
            goto L_0x004e
        L_0x004c:
            int r2 = sdk.meizu.account.factor.authentication.sdk.R.string.validate_mode_verification_code
        L_0x004e:
            r1.setText(r2)
            android.widget.TextView r1 = r6.getContentTv()
            java.lang.String r2 = r0.getValidateAccount()
            r1.setText(r2)
            android.widget.TextView r1 = r6.getDescTv()
            java.lang.String r2 = r0.getValidateType()
            sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType r3 = r5.selectorType
            java.lang.String r3 = r3.getValidateType()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0072
            r2 = 0
            goto L_0x0074
        L_0x0072:
            r2 = 8
        L_0x0074:
            r1.setVisibility(r2)
            android.view.View r6 = r6.itemView
            com.honey.account.uc.a r1 = new com.honey.account.uc.a
            r1.<init>(r5, r7, r0)
            r6.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.meizu.account.factor.authentication.sdk.fragment.basic.adapter.ValidateListAdapter.onBindViewHolder(sdk.meizu.account.factor.authentication.sdk.fragment.basic.adapter.ValidateListAdapter$ViewHolder, int):void");
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_validate_view, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        return new ViewHolder(inflate);
    }
}
