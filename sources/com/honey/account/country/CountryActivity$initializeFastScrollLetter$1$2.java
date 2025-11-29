package com.honey.account.country;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.country.data.CountryData;
import com.honey.account.country.util.CountryManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/honey/account/country/CountryActivity$initializeFastScrollLetter$1$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CountryActivity$initializeFastScrollLetter$1$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ LinearLayoutManager $layoutManager;
    final /* synthetic */ CountryActivity this$0;

    public CountryActivity$initializeFastScrollLetter$1$2(LinearLayoutManager linearLayoutManager, CountryActivity countryActivity) {
        this.$layoutManager = linearLayoutManager;
        this.this$0 = countryActivity;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        List<CountryData> mCountryData;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        int findFirstVisibleItemPosition = this.$layoutManager.findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition >= 0 && (mCountryData = CountryManager.INSTANCE.getMCountryData()) != null) {
            this.this$0.getFastScrollLetter().getNavigationLayout().setCurrentLetterFormScrolling(0, mCountryData.get(findFirstVisibleItemPosition).getSortKey());
        }
    }
}
