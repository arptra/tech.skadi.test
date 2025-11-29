package com.upuphone.xr.sapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.c8.g;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.ItemLanguageCellBinding;
import com.upuphone.xr.sapp.entity.LanguageMode;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nLanguageAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LanguageAdapter.kt\ncom/upuphone/xr/sapp/adapter/LanguageAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,58:1\n256#2,2:59\n288#3,2:61\n*S KotlinDebug\n*F\n+ 1 LanguageAdapter.kt\ncom/upuphone/xr/sapp/adapter/LanguageAdapter\n*L\n40#1:59,2\n43#1:61,2\n*E\n"})
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001%B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u00020\u00122\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R(\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u0007R?\u0010$\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/LanguageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/upuphone/xr/sapp/adapter/LanguageAdapter$LanguageHolder;", "", "Lcom/upuphone/xr/sapp/entity/LanguageMode;", "data", "<init>", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "j", "(Landroid/view/ViewGroup;I)Lcom/upuphone/xr/sapp/adapter/LanguageAdapter$LanguageHolder;", "getItemCount", "()I", "holder", "position", "", "h", "(Lcom/upuphone/xr/sapp/adapter/LanguageAdapter$LanguageHolder;I)V", "a", "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "mode", "b", "Lkotlin/jvm/functions/Function1;", "getItemClick", "()Lkotlin/jvm/functions/Function1;", "k", "(Lkotlin/jvm/functions/Function1;)V", "itemClick", "LanguageHolder", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class LanguageAdapter extends RecyclerView.Adapter<LanguageHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List f6611a;
    public Function1 b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/LanguageAdapter$LanguageHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/upuphone/xr/sapp/databinding/ItemLanguageCellBinding;", "binding", "<init>", "(Lcom/upuphone/xr/sapp/adapter/LanguageAdapter;Lcom/upuphone/xr/sapp/databinding/ItemLanguageCellBinding;)V", "a", "Lcom/upuphone/xr/sapp/databinding/ItemLanguageCellBinding;", "()Lcom/upuphone/xr/sapp/databinding/ItemLanguageCellBinding;", "setBinding", "(Lcom/upuphone/xr/sapp/databinding/ItemLanguageCellBinding;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class LanguageHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ItemLanguageCellBinding f6612a;
        public final /* synthetic */ LanguageAdapter b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LanguageHolder(LanguageAdapter languageAdapter, ItemLanguageCellBinding itemLanguageCellBinding) {
            super(itemLanguageCellBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemLanguageCellBinding, "binding");
            this.b = languageAdapter;
            this.f6612a = itemLanguageCellBinding;
        }

        public final ItemLanguageCellBinding a() {
            return this.f6612a;
        }
    }

    public LanguageAdapter(List list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.f6611a = list;
    }

    public static final void i(LanguageAdapter languageAdapter, LanguageMode languageMode, View view) {
        Object obj;
        Intrinsics.checkNotNullParameter(languageAdapter, "this$0");
        Intrinsics.checkNotNullParameter(languageMode, "$languageMode");
        Function1 function1 = languageAdapter.b;
        if (function1 != null) {
            function1.invoke(languageMode);
        }
        Iterator it = languageAdapter.f6611a.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((LanguageMode) obj).getSelectState()) {
                break;
            }
        }
        LanguageMode languageMode2 = (LanguageMode) obj;
        if (languageMode2 != null) {
            languageMode2.setSelectState(false);
        }
        languageMode.setSelectState(true);
        languageAdapter.notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f6611a.size();
    }

    /* renamed from: h */
    public void onBindViewHolder(LanguageHolder languageHolder, int i) {
        Intrinsics.checkNotNullParameter(languageHolder, "holder");
        LanguageMode languageMode = (LanguageMode) this.f6611a.get(i);
        languageHolder.a().getRoot().setBackgroundResource(R.drawable.common_single_item_bg_rectangle);
        if (i == 0) {
            languageHolder.a().getRoot().setBackgroundResource(R.drawable.common_single_item_bg_top);
        }
        if (i == this.f6611a.size() - 1) {
            languageHolder.a().getRoot().setBackgroundResource(R.drawable.common_single_item_bg_bottom);
        }
        languageHolder.a().d.setText(GlobalExtKt.f().getString(languageMode.getLanguageStrId()));
        AppCompatImageView appCompatImageView = languageHolder.a().c;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "languageSelectImage");
        appCompatImageView.setVisibility(languageMode.getSelectState() ? 0 : 8);
        languageHolder.a().getRoot().setOnClickListener(new g(this, languageMode));
    }

    /* renamed from: j */
    public LanguageHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemLanguageCellBinding c = ItemLanguageCellBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        return new LanguageHolder(this, c);
    }

    public final void k(Function1 function1) {
        this.b = function1;
    }
}
