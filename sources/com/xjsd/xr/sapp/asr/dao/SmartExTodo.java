package com.xjsd.xr.sapp.asr.dao;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001$B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JA\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\tHÖ\u0001J\b\u0010#\u001a\u00020\u0003H\u0016R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R.\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013¨\u0006%"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/SmartExTodo;", "", "versionCode", "", "todoList", "Ljava/util/ArrayList;", "Lcom/xjsd/xr/sapp/asr/dao/SmartExTodo$ToDo;", "Lkotlin/collections/ArrayList;", "baseStatus", "", "requestId", "(Ljava/lang/String;Ljava/util/ArrayList;ILjava/lang/String;)V", "getBaseStatus", "()I", "setBaseStatus", "(I)V", "getRequestId", "()Ljava/lang/String;", "setRequestId", "(Ljava/lang/String;)V", "getTodoList", "()Ljava/util/ArrayList;", "setTodoList", "(Ljava/util/ArrayList;)V", "getVersionCode", "setVersionCode", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ToDo", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SmartExTodo {
    @SerializedName("base_status")
    private int baseStatus;
    @SerializedName("requestId")
    @NotNull
    private String requestId;
    @SerializedName("todo_list")
    @NotNull
    private ArrayList<ToDo> todoList;
    @SerializedName("version_code")
    @NotNull
    private String versionCode;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/SmartExTodo$ToDo;", "", "startTime", "", "endTime", "content", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getEndTime", "setEndTime", "getStartTime", "setStartTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ToDo {
        @NotNull
        private String content;
        @SerializedName("end_time")
        @NotNull
        private String endTime;
        @SerializedName("start_time")
        @NotNull
        private String startTime;

        public ToDo(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "startTime");
            Intrinsics.checkNotNullParameter(str2, "endTime");
            Intrinsics.checkNotNullParameter(str3, "content");
            this.startTime = str;
            this.endTime = str2;
            this.content = str3;
        }

        public static /* synthetic */ ToDo copy$default(ToDo toDo, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = toDo.startTime;
            }
            if ((i & 2) != 0) {
                str2 = toDo.endTime;
            }
            if ((i & 4) != 0) {
                str3 = toDo.content;
            }
            return toDo.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return this.startTime;
        }

        @NotNull
        public final String component2() {
            return this.endTime;
        }

        @NotNull
        public final String component3() {
            return this.content;
        }

        @NotNull
        public final ToDo copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "startTime");
            Intrinsics.checkNotNullParameter(str2, "endTime");
            Intrinsics.checkNotNullParameter(str3, "content");
            return new ToDo(str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ToDo)) {
                return false;
            }
            ToDo toDo = (ToDo) obj;
            return Intrinsics.areEqual((Object) this.startTime, (Object) toDo.startTime) && Intrinsics.areEqual((Object) this.endTime, (Object) toDo.endTime) && Intrinsics.areEqual((Object) this.content, (Object) toDo.content);
        }

        @NotNull
        public final String getContent() {
            return this.content;
        }

        @NotNull
        public final String getEndTime() {
            return this.endTime;
        }

        @NotNull
        public final String getStartTime() {
            return this.startTime;
        }

        public int hashCode() {
            return (((this.startTime.hashCode() * 31) + this.endTime.hashCode()) * 31) + this.content.hashCode();
        }

        public final void setContent(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.content = str;
        }

        public final void setEndTime(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.endTime = str;
        }

        public final void setStartTime(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.startTime = str;
        }

        @NotNull
        public String toString() {
            return "ToDo(startTime='" + this.startTime + "', endTime='" + this.endTime + "', content='" + this.content + "')";
        }
    }

    public SmartExTodo(@NotNull String str, @NotNull ArrayList<ToDo> arrayList, int i, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "versionCode");
        Intrinsics.checkNotNullParameter(arrayList, "todoList");
        Intrinsics.checkNotNullParameter(str2, "requestId");
        this.versionCode = str;
        this.todoList = arrayList;
        this.baseStatus = i;
        this.requestId = str2;
    }

    public static /* synthetic */ SmartExTodo copy$default(SmartExTodo smartExTodo, String str, ArrayList<ToDo> arrayList, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = smartExTodo.versionCode;
        }
        if ((i2 & 2) != 0) {
            arrayList = smartExTodo.todoList;
        }
        if ((i2 & 4) != 0) {
            i = smartExTodo.baseStatus;
        }
        if ((i2 & 8) != 0) {
            str2 = smartExTodo.requestId;
        }
        return smartExTodo.copy(str, arrayList, i, str2);
    }

    @NotNull
    public final String component1() {
        return this.versionCode;
    }

    @NotNull
    public final ArrayList<ToDo> component2() {
        return this.todoList;
    }

    public final int component3() {
        return this.baseStatus;
    }

    @NotNull
    public final String component4() {
        return this.requestId;
    }

    @NotNull
    public final SmartExTodo copy(@NotNull String str, @NotNull ArrayList<ToDo> arrayList, int i, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "versionCode");
        Intrinsics.checkNotNullParameter(arrayList, "todoList");
        Intrinsics.checkNotNullParameter(str2, "requestId");
        return new SmartExTodo(str, arrayList, i, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmartExTodo)) {
            return false;
        }
        SmartExTodo smartExTodo = (SmartExTodo) obj;
        return Intrinsics.areEqual((Object) this.versionCode, (Object) smartExTodo.versionCode) && Intrinsics.areEqual((Object) this.todoList, (Object) smartExTodo.todoList) && this.baseStatus == smartExTodo.baseStatus && Intrinsics.areEqual((Object) this.requestId, (Object) smartExTodo.requestId);
    }

    public final int getBaseStatus() {
        return this.baseStatus;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final ArrayList<ToDo> getTodoList() {
        return this.todoList;
    }

    @NotNull
    public final String getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return (((((this.versionCode.hashCode() * 31) + this.todoList.hashCode()) * 31) + Integer.hashCode(this.baseStatus)) * 31) + this.requestId.hashCode();
    }

    public final void setBaseStatus(int i) {
        this.baseStatus = i;
    }

    public final void setRequestId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.requestId = str;
    }

    public final void setTodoList(@NotNull ArrayList<ToDo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.todoList = arrayList;
    }

    public final void setVersionCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.versionCode = str;
    }

    @NotNull
    public String toString() {
        return "SmartExTodo(versionCode='" + this.versionCode + "', todoList=" + this.todoList + ", baseStatus=" + this.baseStatus + ", requestId='" + this.requestId + "')";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SmartExTodo(String str, ArrayList arrayList, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, arrayList, i, (i2 & 8) != 0 ? "" : str2);
    }
}
