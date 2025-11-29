package com.honey.account.view.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.honey.account.R;
import com.honey.account.country.data.CountryData;
import com.honey.account.utils.system.ExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000202J\u0006\u00104\u001a\u00020\u000eJ\u000e\u00105\u001a\u0002002\u0006\u00106\u001a\u000202J\u0010\u00107\u001a\u0002002\b\u00108\u001a\u0004\u0018\u000102J\u0010\u00109\u001a\u0002002\u0006\u00106\u001a\u000202H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001a\u0010\u001bR(\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001b\u0010#\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b$\u0010\u001bR\u001b\u0010&\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b'\u0010\u001bR\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006:"}, d2 = {"Lcom/honey/account/view/widget/AccountEditLayout;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_countryData", "Lcom/honey/account/country/data/CountryData;", "accountEdit", "Landroid/widget/EditText;", "getAccountEdit", "()Landroid/widget/EditText;", "accountEdit$delegate", "Lkotlin/Lazy;", "areaCodeLayout", "Landroid/view/ViewGroup;", "getAreaCodeLayout", "()Landroid/view/ViewGroup;", "areaCodeLayout$delegate", "areaCodeTv", "Landroid/widget/TextView;", "getAreaCodeTv", "()Landroid/widget/TextView;", "areaCodeTv$delegate", "value", "countryData", "getCountryData", "()Lcom/honey/account/country/data/CountryData;", "setCountryData", "(Lcom/honey/account/country/data/CountryData;)V", "errorTv", "getErrorTv", "errorTv$delegate", "hiltTv", "getHiltTv", "hiltTv$delegate", "textWatcher", "Landroid/text/TextWatcher;", "getTextWatcher", "()Landroid/text/TextWatcher;", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "destroy", "", "getAccount", "", "getAccountInAreaCode", "getEdit", "setAccount", "account", "showError", "error", "updateAreaCodeLayout", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAccountEditLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccountEditLayout.kt\ncom/honey/account/view/widget/AccountEditLayout\n+ 2 CharSequence.kt\nandroidx/core/text/CharSequenceKt\n*L\n1#1,157:1\n28#2:158\n28#2:159\n*S KotlinDebug\n*F\n+ 1 AccountEditLayout.kt\ncom/honey/account/view/widget/AccountEditLayout\n*L\n94#1:158\n95#1:159\n*E\n"})
public final class AccountEditLayout extends LinearLayoutCompat {
    @NotNull
    private CountryData _countryData;
    @NotNull
    private final Lazy accountEdit$delegate;
    @NotNull
    private final Lazy areaCodeLayout$delegate;
    @NotNull
    private final Lazy areaCodeTv$delegate;
    @Nullable
    private CountryData countryData;
    @NotNull
    private final Lazy errorTv$delegate;
    @NotNull
    private final Lazy hiltTv$delegate;
    @Nullable
    private TextWatcher textWatcher;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AccountEditLayout(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: private */
    public final EditText getAccountEdit() {
        Object value = this.accountEdit$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (EditText) value;
    }

    private final TextView getAreaCodeTv() {
        Object value = this.areaCodeTv$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    private final TextView getErrorTv() {
        Object value = this.errorTv$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    private final TextView getHiltTv() {
        Object value = this.hiltTv$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    /* access modifiers changed from: private */
    public final void updateAreaCodeLayout(String str) {
        getAreaCodeLayout().setVisibility((str.length() <= 0 || !TextUtils.isDigitsOnly(str)) ? 8 : 0);
        if (str.length() != 0 && TextUtils.isDigitsOnly(str)) {
            setCountryData(this._countryData);
            if (getAreaCodeLayout().getMeasuredWidth() > 0) {
                getAccountEdit().setCompoundDrawablePadding(getAreaCodeLayout().getMeasuredWidth());
            } else {
                getAreaCodeLayout().getViewTreeObserver().addOnGlobalLayoutListener(new AccountEditLayout$updateAreaCodeLayout$1(this));
            }
        } else {
            getAccountEdit().setCompoundDrawablePadding(0);
            setCountryData((CountryData) null);
        }
    }

    public final void destroy() {
        getAccountEdit().setOnClickListener((View.OnClickListener) null);
    }

    @NotNull
    public final String getAccount() {
        return getAccountEdit().getText().toString();
    }

    @NotNull
    public final String getAccountInAreaCode() {
        CountryData countryData2 = this.countryData;
        if (countryData2 != null) {
            String str = countryData2.getCode() + ':' + getAccount();
            if (str != null) {
                return str;
            }
        }
        return getAccount();
    }

    @NotNull
    public final ViewGroup getAreaCodeLayout() {
        Object value = this.areaCodeLayout$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ViewGroup) value;
    }

    @Nullable
    public final CountryData getCountryData() {
        return this.countryData;
    }

    @NotNull
    public final EditText getEdit() {
        return getAccountEdit();
    }

    @Nullable
    public final TextWatcher getTextWatcher() {
        return this.textWatcher;
    }

    public final void setAccount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "account");
        getAccountEdit().setText(str);
    }

    public final void setCountryData(@Nullable CountryData countryData2) {
        this.countryData = countryData2;
        if (countryData2 != null) {
            this._countryData = countryData2;
        }
        getAreaCodeTv().setText(countryData2 != null ? countryData2.getSimpleCode() : null);
    }

    public final void setTextWatcher(@Nullable TextWatcher textWatcher2) {
        this.textWatcher = textWatcher2;
    }

    public final void showError(@Nullable String str) {
        Unit unit;
        if (str != null) {
            getAccountEdit().requestFocus();
            TextView errorTv = getErrorTv();
            errorTv.setText(str);
            errorTv.setVisibility(0);
            getAccountEdit().setBackgroundResource(R.drawable.ha_et_bg_err);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            getErrorTv().setVisibility(8);
            getAccountEdit().setBackgroundResource(R.drawable.ha_et_bg_grey);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AccountEditLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @SuppressLint({"Recycle", "CustomViewStyleable", "RestrictedApi", "ResourceType"})
    public AccountEditLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.hiltTv$delegate = LazyKt.lazy(new AccountEditLayout$hiltTv$2(this));
        this.areaCodeTv$delegate = LazyKt.lazy(new AccountEditLayout$areaCodeTv$2(this));
        this.areaCodeLayout$delegate = LazyKt.lazy(new AccountEditLayout$areaCodeLayout$2(this));
        this.accountEdit$delegate = LazyKt.lazy(new AccountEditLayout$accountEdit$2(this));
        this.errorTv$delegate = LazyKt.lazy(new AccountEditLayout$errorTv$2(this));
        this._countryData = CountryData.US_COUNTRY;
        LayoutInflater.from(context).inflate(R.layout.account_edit_layout, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.account_edit_layout);
        getHiltTv().setText(obtainStyledAttributes.getString(R.styleable.account_edit_layout_hint));
        EditText accountEdit = getAccountEdit();
        String string = obtainStyledAttributes.getString(R.styleable.account_edit_layout_hintEdit);
        accountEdit.setHint(string == null ? obtainStyledAttributes.getString(R.string.input_phone_hint) : string);
        ExtKt.doAfterTextChanged(getAccountEdit(), new Function1<Editable, Unit>(this) {
            final /* synthetic */ AccountEditLayout this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Editable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Editable editable) {
                AccountEditLayout accountEditLayout = this.this$0;
                accountEditLayout.updateAreaCodeLayout(accountEditLayout.getAccountEdit().getText().toString());
                TextWatcher textWatcher = this.this$0.getTextWatcher();
                if (textWatcher != null) {
                    textWatcher.afterTextChanged(editable);
                }
            }
        });
    }
}
