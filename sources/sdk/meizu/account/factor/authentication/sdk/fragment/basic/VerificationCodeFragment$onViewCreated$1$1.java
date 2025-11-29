package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.common.widget.MzButton;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "s", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VerificationCodeFragment$onViewCreated$1$1 extends Lambda implements Function1<CharSequence, Unit> {
    final /* synthetic */ VerificationCodeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerificationCodeFragment$onViewCreated$1$1(VerificationCodeFragment verificationCodeFragment) {
        super(1);
        this.this$0 = verificationCodeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CharSequence) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable CharSequence charSequence) {
        MzButton nextBtn = this.this$0.getNextBtn();
        if (nextBtn != null) {
            boolean z = false;
            if (charSequence != null && charSequence.length() > 0) {
                z = true;
            }
            nextBtn.setEnabled(z);
        }
    }
}
