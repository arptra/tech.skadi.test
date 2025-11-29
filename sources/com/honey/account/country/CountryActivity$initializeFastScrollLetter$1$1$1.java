package com.honey.account.country;

import android.content.Intent;
import com.honey.account.country.adapter.CountryAdapter;
import com.honey.account.country.data.CountryData;
import com.honey.account.country.util.CountryManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/honey/account/country/CountryActivity$initializeFastScrollLetter$1$1$1", "Lcom/honey/account/country/adapter/CountryAdapter$OnItemClickListener;", "onItemClick", "", "position", "", "countryData", "Lcom/honey/account/country/data/CountryData;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CountryActivity$initializeFastScrollLetter$1$1$1 implements CountryAdapter.OnItemClickListener {
    final /* synthetic */ CountryActivity this$0;

    public CountryActivity$initializeFastScrollLetter$1$1$1(CountryActivity countryActivity) {
        this.this$0 = countryActivity;
    }

    public void onItemClick(int i, @NotNull CountryData countryData) {
        Intrinsics.checkNotNullParameter(countryData, "countryData");
        Intent intent = new Intent();
        intent.putExtra(CountryData.TAG, countryData);
        CountryManager.INSTANCE.setCountry(this.this$0, countryData);
        this.this$0.setResult(-1, intent);
        this.this$0.finish();
    }
}
