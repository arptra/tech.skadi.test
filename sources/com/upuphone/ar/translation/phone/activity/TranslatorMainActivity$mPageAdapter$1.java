package com.upuphone.ar.translation.phone.activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.upuphone.ar.translation.phone.bean.RecordTabBean;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/ar/translation/phone/activity/TranslatorMainActivity$mPageAdapter$1", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranslatorMainActivity$mPageAdapter$1 extends FragmentStateAdapter {
    final /* synthetic */ TranslatorMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorMainActivity$mPageAdapter$1(TranslatorMainActivity translatorMainActivity, FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        this.this$0 = translatorMainActivity;
    }

    @NotNull
    public Fragment createFragment(int i) {
        return ((RecordTabBean) this.this$0.getMMainVm().r().get(i)).getFragment();
    }

    public int getItemCount() {
        return this.this$0.getMMainVm().r().size();
    }
}
