package sdk.meizu.account.factor.authentication.sdk.fragment.answer;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sdk.meizu.account.factor.authentication.sdk.R;
import sdk.meizu.account.factor.authentication.sdk.common.helper.PackageKt;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"sdk/meizu/account/factor/authentication/sdk/fragment/answer/AnswerFragment$onViewCreated$3$1$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AnswerFragment$onViewCreated$3$1$1 extends ClickableSpan {
    final /* synthetic */ TextView $this_apply;

    public AnswerFragment$onViewCreated$3$1$1(TextView textView) {
        this.$this_apply = textView;
    }

    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        Context context = this.$this_apply.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        PackageKt.startAppByScheme(context, "com.android.browser", "https://i.flyme.cn/appeal");
    }

    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
        textPaint.setColor(ContextCompat.getColor(this.$this_apply.getContext(), R.color.colorPrimary));
    }
}
