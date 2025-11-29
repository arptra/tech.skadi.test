package sdk.meizu.account.factor.authentication.sdk.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import dagger.hilt.android.internal.managers.ViewComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

public abstract class Hilt_VCodeEditLayout extends ConstraintLayout implements GeneratedComponentManagerHolder {
    private ViewComponentManager componentManager;
    private boolean injected;

    public Hilt_VCodeEditLayout(Context context) {
        super(context);
        if (!isInEditMode()) {
            inject();
        }
    }

    public ViewComponentManager createComponentManager() {
        return new ViewComponentManager(this, false);
    }

    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    public void inject() {
        if (!this.injected) {
            this.injected = true;
            ((VCodeEditLayout_GeneratedInjector) generatedComponent()).injectVCodeEditLayout((VCodeEditLayout) UnsafeCasts.unsafeCast(this));
        }
    }

    public final ViewComponentManager componentManager() {
        if (this.componentManager == null) {
            this.componentManager = createComponentManager();
        }
        return this.componentManager;
    }

    public Hilt_VCodeEditLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            inject();
        }
    }

    public Hilt_VCodeEditLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (!isInEditMode()) {
            inject();
        }
    }

    @TargetApi(21)
    public Hilt_VCodeEditLayout(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        if (!isInEditMode()) {
            inject();
        }
    }
}
