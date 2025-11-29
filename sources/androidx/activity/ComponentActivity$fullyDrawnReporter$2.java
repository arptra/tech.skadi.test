package androidx.activity;

import androidx.activity.ComponentActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/activity/FullyDrawnReporter;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComponentActivity$fullyDrawnReporter$2 extends Lambda implements Function0<FullyDrawnReporter> {
    final /* synthetic */ ComponentActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComponentActivity$fullyDrawnReporter$2(ComponentActivity componentActivity) {
        super(0);
        this.this$0 = componentActivity;
    }

    @NotNull
    public final FullyDrawnReporter invoke() {
        ComponentActivity.ReportFullyDrawnExecutor access$getReportFullyDrawnExecutor$p = this.this$0.reportFullyDrawnExecutor;
        final ComponentActivity componentActivity = this.this$0;
        return new FullyDrawnReporter(access$getReportFullyDrawnExecutor$p, new Function0<Unit>() {
            public final void invoke() {
                componentActivity.reportFullyDrawn();
            }
        });
    }
}
