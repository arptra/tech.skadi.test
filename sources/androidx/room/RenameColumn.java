package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@Target(allowedTargets = {AnnotationTarget.CLASS})
@Repeatable(Entries.class)
@Retention(AnnotationRetention.BINARY)
@java.lang.annotation.Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/room/RenameColumn;", "", "", "tableName", "fromColumnName", "toColumnName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Entries", "room-common"}, k = 1, mv = {1, 8, 0})
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
public @interface RenameColumn {

    @Target(allowedTargets = {AnnotationTarget.CLASS})
    @Retention(AnnotationRetention.BINARY)
    @java.lang.annotation.Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/RenameColumn$Entries;", "", "", "Landroidx/room/RenameColumn;", "value", "<init>", "(Lkotlin/Array;)V", "room-common"}, k = 1, mv = {1, 8, 0})
    @java.lang.annotation.Retention(RetentionPolicy.CLASS)
    public @interface Entries {
    }
}
