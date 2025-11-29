package androidx.sqlite.db.framework;

import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class FrameworkSQLiteOpenHelper$lazyDelegate$1 extends Lambda implements Function0<FrameworkSQLiteOpenHelper.OpenHelper> {
    final /* synthetic */ FrameworkSQLiteOpenHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteOpenHelper$lazyDelegate$1(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        super(0);
        this.this$0 = frameworkSQLiteOpenHelper;
    }

    @NotNull
    public final FrameworkSQLiteOpenHelper.OpenHelper invoke() {
        FrameworkSQLiteOpenHelper.OpenHelper openHelper;
        if (this.this$0.b == null || !this.this$0.d) {
            openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(this.this$0.f1801a, this.this$0.b, new FrameworkSQLiteOpenHelper.DBRefHolder((FrameworkSQLiteDatabase) null), this.this$0.c, this.this$0.e);
        } else {
            openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(this.this$0.f1801a, new File(SupportSQLiteCompat.Api21Impl.a(this.this$0.f1801a), this.this$0.b).getAbsolutePath(), new FrameworkSQLiteOpenHelper.DBRefHolder((FrameworkSQLiteDatabase) null), this.this$0.c, this.this$0.e);
        }
        SupportSQLiteCompat.Api16Impl.g(openHelper, this.this$0.g);
        return openHelper;
    }
}
