package com.upuphone.xr.sapp.adapter;

import com.xjsd.ai.assistant.phone.vui.todo.TodoEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u001b\u0010\u0005R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0005R\"\u0010#\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010 \u001a\u0004\b\u000f\u0010\b\"\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/TodoItem;", "", "", "isSection", "<init>", "(Z)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Z", "e", "()Z", "Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;", "b", "Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;", "c", "()Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;", "i", "(Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;)V", "src", "h", "select", "d", "f", "isEdit", "Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "editContent", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TodoItem {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f6625a;
    public TodoEntry b;
    public boolean c;
    public boolean d;
    public String e = "";

    public TodoItem(boolean z) {
        this.f6625a = z;
    }

    public final String a() {
        return this.e;
    }

    public final boolean b() {
        return this.c;
    }

    public final TodoEntry c() {
        return this.b;
    }

    public final boolean d() {
        return this.d;
    }

    public final boolean e() {
        return this.f6625a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TodoItem) && this.f6625a == ((TodoItem) obj).f6625a;
    }

    public final void f(boolean z) {
        this.d = z;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.e = str;
    }

    public final void h(boolean z) {
        this.c = z;
    }

    public int hashCode() {
        return Boolean.hashCode(this.f6625a);
    }

    public final void i(TodoEntry todoEntry) {
        this.b = todoEntry;
    }

    public String toString() {
        boolean z = this.f6625a;
        return "TodoItem(isSection=" + z + ")";
    }
}
