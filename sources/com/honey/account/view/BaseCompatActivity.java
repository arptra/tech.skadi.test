package com.honey.account.view;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.LifecycleOwnerKt;
import com.honey.account.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012JJ\u0010\u0013\u001a\u00020\t\"\u0004\b\u0000\u0010\u0014*\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00172\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/honey/account/view/BaseCompatActivity;", "Lcom/honey/account/view/BaseAccountActivity;", "()V", "getArgbByAttr", "", "attrColor", "initActionBar", "Landroidx/appcompat/app/ActionBar;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "setResultOKAndFinish", "data", "Landroid/content/Intent;", "collectLifecycleFlow", "T", "Landroidx/activity/ComponentActivity;", "flow", "Lkotlinx/coroutines/flow/Flow;", "collect", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/activity/ComponentActivity;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)V", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BaseCompatActivity extends BaseAccountActivity {
    private final ActionBar initActionBar() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return null;
        }
        supportActionBar.q(false);
        supportActionBar.v(true);
        supportActionBar.p(true);
        supportActionBar.t(R.drawable.honey_action_bar_icon);
        supportActionBar.n(new ColorDrawable(0));
        return supportActionBar;
    }

    public static /* synthetic */ void setResultOKAndFinish$default(BaseCompatActivity baseCompatActivity, Intent intent, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                intent = null;
            }
            baseCompatActivity.setResultOKAndFinish(intent);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setResultOKAndFinish");
    }

    public final <T> void collectLifecycleFlow(@NotNull ComponentActivity componentActivity, @NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(flow, "flow");
        Intrinsics.checkNotNullParameter(function2, "collect");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(componentActivity), (CoroutineContext) null, (CoroutineStart) null, new BaseCompatActivity$collectLifecycleFlow$1(componentActivity, flow, function2, (Continuation<? super BaseCompatActivity$collectLifecycleFlow$1>) null), 3, (Object) null);
    }

    public final int getArgbByAttr(int i) {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.data;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        initActionBar();
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public final void setResultOKAndFinish(@Nullable Intent intent) {
        setResult(-1, intent);
        finish();
    }
}
