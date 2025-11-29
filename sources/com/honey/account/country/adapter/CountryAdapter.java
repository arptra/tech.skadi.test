package com.honey.account.country.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.R;
import com.honey.account.country.data.CountryData;
import com.honey.account.e2.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0017R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/honey/account/country/adapter/CountryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/honey/account/country/adapter/CountryAdapter$CountryViewHolder;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "data", "", "Lcom/honey/account/country/data/CountryData;", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;)V", "getData", "()Ljava/util/List;", "onItemClickListener", "Lcom/honey/account/country/adapter/CountryAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/honey/account/country/adapter/CountryAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/honey/account/country/adapter/CountryAdapter$OnItemClickListener;)V", "getItemCount", "", "getItemData", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CountryViewHolder", "OnItemClickListener", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    @NotNull
    private final List<CountryData> data;
    @Nullable
    private OnItemClickListener onItemClickListener;
    @NotNull
    private final RecyclerView recyclerView;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/honey/account/country/adapter/CountryAdapter$CountryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "countryTv", "Landroid/widget/TextView;", "getCountryTv", "()Landroid/widget/TextView;", "setCountryTv", "(Landroid/widget/TextView;)V", "hotTv", "getHotTv", "setHotTv", "itemRoot", "getItemRoot", "()Landroid/view/View;", "setItemRoot", "simpleCodeTv", "getSimpleCodeTv", "setSimpleCodeTv", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CountryViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private TextView countryTv;
        @NotNull
        private TextView hotTv;
        @NotNull
        private View itemRoot;
        @NotNull
        private TextView simpleCodeTv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CountryViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.itemRoot = view;
            View findViewById = view.findViewById(R.id.country_adapter_hot_tv);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.hotTv = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.country_adapter_title);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.countryTv = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.country_adapter_simple_code);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.simpleCodeTv = (TextView) findViewById3;
        }

        @NotNull
        public final TextView getCountryTv() {
            return this.countryTv;
        }

        @NotNull
        public final TextView getHotTv() {
            return this.hotTv;
        }

        @NotNull
        public final View getItemRoot() {
            return this.itemRoot;
        }

        @NotNull
        public final TextView getSimpleCodeTv() {
            return this.simpleCodeTv;
        }

        public final void setCountryTv(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.countryTv = textView;
        }

        public final void setHotTv(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.hotTv = textView;
        }

        public final void setItemRoot(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.itemRoot = view;
        }

        public final void setSimpleCodeTv(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.simpleCodeTv = textView;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/honey/account/country/adapter/CountryAdapter$OnItemClickListener;", "", "onItemClick", "", "position", "", "countryData", "Lcom/honey/account/country/data/CountryData;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnItemClickListener {
        void onItemClick(int i, @NotNull CountryData countryData);
    }

    public CountryAdapter(@NotNull RecyclerView recyclerView2, @NotNull List<CountryData> list) {
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        Intrinsics.checkNotNullParameter(list, "data");
        this.recyclerView = recyclerView2;
        this.data = list;
    }

    private final CountryData getItemData(int i) {
        if (i >= getItemCount()) {
            return null;
        }
        return this.data.get(i);
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(CountryAdapter countryAdapter, CountryViewHolder countryViewHolder, CountryData countryData, View view) {
        Intrinsics.checkNotNullParameter(countryAdapter, "this$0");
        Intrinsics.checkNotNullParameter(countryViewHolder, "$holder");
        int childAdapterPosition = countryAdapter.recyclerView.getChildAdapterPosition(countryViewHolder.itemView);
        OnItemClickListener onItemClickListener2 = countryAdapter.onItemClickListener;
        if (onItemClickListener2 != null) {
            Intrinsics.checkNotNull(countryData);
            onItemClickListener2.onItemClick(childAdapterPosition, countryData);
        }
    }

    @NotNull
    public final List<CountryData> getData() {
        return this.data;
    }

    public int getItemCount() {
        return this.data.size();
    }

    @Nullable
    public final OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public final void setOnItemClickListener(@Nullable OnItemClickListener onItemClickListener2) {
        this.onItemClickListener = onItemClickListener2;
    }

    public void onBindViewHolder(@NotNull CountryViewHolder countryViewHolder, int i) {
        Intrinsics.checkNotNullParameter(countryViewHolder, "holder");
        CountryData itemData = getItemData(i);
        countryViewHolder.getHotTv().setVisibility((itemData == null || !itemData.isFirst()) ? 8 : 0);
        String str = null;
        countryViewHolder.getHotTv().setText(itemData != null ? itemData.getSortKey() : null);
        countryViewHolder.getCountryTv().setText(itemData != null ? itemData.getCountry() : null);
        TextView simpleCodeTv = countryViewHolder.getSimpleCodeTv();
        if (itemData != null) {
            str = itemData.getSimpleCode();
        }
        simpleCodeTv.setText(str);
        countryViewHolder.getItemRoot().setOnClickListener(new a(this, countryViewHolder, itemData));
    }

    @NotNull
    @SuppressLint({"InflateParams"})
    public CountryViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.country_adapter, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new CountryViewHolder(inflate);
    }
}
