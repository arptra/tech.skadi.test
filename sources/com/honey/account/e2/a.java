package com.honey.account.e2;

import android.view.View;
import com.honey.account.country.adapter.CountryAdapter;
import com.honey.account.country.data.CountryData;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CountryAdapter f9189a;
    public final /* synthetic */ CountryAdapter.CountryViewHolder b;
    public final /* synthetic */ CountryData c;

    public /* synthetic */ a(CountryAdapter countryAdapter, CountryAdapter.CountryViewHolder countryViewHolder, CountryData countryData) {
        this.f9189a = countryAdapter;
        this.b = countryViewHolder;
        this.c = countryData;
    }

    public final void onClick(View view) {
        CountryAdapter.onBindViewHolder$lambda$0(this.f9189a, this.b, this.c, view);
    }
}
