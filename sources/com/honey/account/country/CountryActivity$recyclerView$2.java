package com.honey.account.country;

import com.honey.account.R;
import com.honey.account.ui.fastscrollletter.MyFastScrollLetterRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/honey/account/ui/fastscrollletter/MyFastScrollLetterRecyclerView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class CountryActivity$recyclerView$2 extends Lambda implements Function0<MyFastScrollLetterRecyclerView> {
    final /* synthetic */ CountryActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryActivity$recyclerView$2(CountryActivity countryActivity) {
        super(0);
        this.this$0 = countryActivity;
    }

    public final MyFastScrollLetterRecyclerView invoke() {
        return (MyFastScrollLetterRecyclerView) this.this$0.findViewById(R.id.country_recyclerview);
    }
}
