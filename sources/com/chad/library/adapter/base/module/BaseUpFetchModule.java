package com.chad.library.adapter.base.module;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnUpFetchListener;
import com.chad.library.adapter.base.listener.UpFetchListenerImp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\fR\"\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\nR\u001c\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/chad/library/adapter/base/module/BaseUpFetchModule;", "Lcom/chad/library/adapter/base/listener/UpFetchListenerImp;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "baseQuickAdapter", "<init>", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;)V", "", "position", "", "a", "(I)V", "Lcom/chad/library/adapter/base/listener/OnUpFetchListener;", "Lcom/chad/library/adapter/base/listener/OnUpFetchListener;", "mUpFetchListener", "", "b", "Z", "isUpFetchEnable", "()Z", "setUpFetchEnable", "(Z)V", "c", "isUpFetching", "setUpFetching", "d", "I", "getStartUpFetchPosition", "()I", "setStartUpFetchPosition", "startUpFetchPosition", "e", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public class BaseUpFetchModule implements UpFetchListenerImp {

    /* renamed from: a  reason: collision with root package name */
    public OnUpFetchListener f2801a;
    public boolean b;
    public boolean c;
    public int d = 1;
    public final BaseQuickAdapter e;

    public BaseUpFetchModule(BaseQuickAdapter baseQuickAdapter) {
        this.e = baseQuickAdapter;
    }

    public final void a(int i) {
        OnUpFetchListener onUpFetchListener;
        if (this.b && !this.c && i <= this.d && (onUpFetchListener = this.f2801a) != null) {
            onUpFetchListener.a();
        }
    }
}
