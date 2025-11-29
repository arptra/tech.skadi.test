package com.upuphone.xr.sapp.vm;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.upuphone.xr.sapp.glass.GlassUpdateHelper;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/vm/GlassUpdateViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "Landroidx/lifecycle/LiveData;", "Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState;", "b", "Landroidx/lifecycle/LiveData;", "d", "()Landroidx/lifecycle/LiveData;", "glassCheckUpdateStateData", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState;", "c", "e", "glassUpdateStateData", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GlassUpdateViewModel extends AndroidViewModel {
    public final LiveData b;
    public final LiveData c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, VuiModelType.APPLICATION);
        GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
        this.b = glassUpdateHelper.y0();
        this.c = glassUpdateHelper.M0();
    }

    public final LiveData d() {
        return this.b;
    }

    public final LiveData e() {
        return this.c;
    }
}
