package com.honey.account.country;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.honey.account.R;
import com.honey.account.country.adapter.CountryAdapter;
import com.honey.account.country.data.CountryData;
import com.honey.account.country.util.CountryManager;
import com.honey.account.d2.a;
import com.honey.account.ui.fastscrollletter.MyFastScrollLetterRecyclerView;
import com.honey.account.view.BaseCompatActivity;
import com.meizu.common.fastscrollletter.FastScrollLetter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014R+\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/honey/account/country/CountryActivity;", "Lcom/honey/account/view/BaseCompatActivity;", "()V", "allLetters", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getAllLetters", "()Ljava/util/ArrayList;", "allLetters$delegate", "Lkotlin/Lazy;", "fastScrollLetter", "Lcom/meizu/common/fastscrollletter/FastScrollLetter;", "getFastScrollLetter", "()Lcom/meizu/common/fastscrollletter/FastScrollLetter;", "fastScrollLetter$delegate", "recyclerView", "Lcom/honey/account/ui/fastscrollletter/MyFastScrollLetterRecyclerView;", "getRecyclerView", "()Lcom/honey/account/ui/fastscrollletter/MyFastScrollLetterRecyclerView;", "recyclerView$delegate", "initializeFastScrollLetter", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CountryActivity extends BaseCompatActivity {
    @NotNull
    private final Lazy allLetters$delegate = LazyKt.lazy(CountryActivity$allLetters$2.INSTANCE);
    @NotNull
    private final Lazy fastScrollLetter$delegate = LazyKt.lazy(new CountryActivity$fastScrollLetter$2(this));
    @NotNull
    private final Lazy recyclerView$delegate = LazyKt.lazy(new CountryActivity$recyclerView$2(this));

    private final ArrayList<String> getAllLetters() {
        return (ArrayList) this.allLetters$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final FastScrollLetter getFastScrollLetter() {
        Object value = this.fastScrollLetter$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (FastScrollLetter) value;
    }

    private final MyFastScrollLetterRecyclerView getRecyclerView() {
        return (MyFastScrollLetterRecyclerView) this.recyclerView$delegate.getValue();
    }

    private final void initializeFastScrollLetter() {
        MyFastScrollLetterRecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            recyclerView.setLayoutManager(linearLayoutManager);
            List<CountryData> mCountryData = CountryManager.INSTANCE.getMCountryData();
            if (mCountryData != null) {
                CountryAdapter countryAdapter = new CountryAdapter(recyclerView, mCountryData);
                countryAdapter.setOnItemClickListener(new CountryActivity$initializeFastScrollLetter$1$1$1(this));
                recyclerView.setAdapter(countryAdapter);
            }
            recyclerView.addOnScrollListener(new CountryActivity$initializeFastScrollLetter$1$2(linearLayoutManager, this));
        }
        getFastScrollLetter().setListView(getRecyclerView());
        getFastScrollLetter().initialize(getAllLetters(), CountryManager.INSTANCE.getMCountryFastData());
        getFastScrollLetter().setNavigationLetters(getAllLetters());
        getFastScrollLetter().setOffsetCallBack(new a());
    }

    /* access modifiers changed from: private */
    public static final int initializeFastScrollLetter$lambda$2(int i, int i2) {
        return i2;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_country);
        initializeFastScrollLetter();
    }
}
