package sdk.meizu.account.factor.authentication.sdk.fragment.answer.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sdk.meizu.account.factor.authentication.sdk.R;
import sdk.meizu.account.factor.authentication.sdk.data.AnswerType;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\tH\u0017J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/answer/adapter/AnswerListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lsdk/meizu/account/factor/authentication/sdk/fragment/answer/adapter/AnswerListAdapter$ViewHolder;", "data", "", "Lsdk/meizu/account/factor/authentication/sdk/data/AnswerType;", "(Ljava/util/List;)V", "getAnswer", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AnswerListAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public final List<AnswerType> data;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/answer/adapter/AnswerListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "valueEdit", "Landroid/widget/EditText;", "getValueEdit", "()Landroid/widget/EditText;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final TextView descTv;
        @NotNull
        private final EditText valueEdit;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.item_validate_answer_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.descTv = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.item_validate_answer_value);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.valueEdit = (EditText) findViewById2;
        }

        @NotNull
        public final TextView getDescTv() {
            return this.descTv;
        }

        @NotNull
        public final EditText getValueEdit() {
            return this.valueEdit;
        }
    }

    public AnswerListAdapter(@NotNull List<AnswerType> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.data = list;
    }

    @NotNull
    public final List<AnswerType> getAnswer() {
        return this.data;
    }

    public int getItemCount() {
        return this.data.size();
    }

    @SuppressLint({"SetTextI18n"})
    public void onBindViewHolder(@NotNull ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        TextView descTv = viewHolder.getDescTv();
        StringBuilder sb = new StringBuilder();
        String string = ContextCompat.getString(viewHolder.getDescTv().getContext(), R.string.answer_index);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i + 1)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        sb.append(format);
        sb.append(this.data.get(i).getDesc());
        descTv.setText(sb.toString());
        viewHolder.getValueEdit().addTextChangedListener(new AnswerListAdapter$onBindViewHolder$2(this, i));
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_validate_answer_view, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        return new ViewHolder(inflate);
    }
}
